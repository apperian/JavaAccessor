
#include "jni.h"
#include "accessor.h"
#include <stdlib.h>

#define INVOKE(jtype,type) \
JNIEXPORT jtype JNICALL Java_com_apperian_javautil_Accessor_invoke##type(JNIEnv *env, jclass class, jobject obj, jstring methodName, jstring methodSig, jobjectArray args_arr)  \
{   jclass        obj_class;                                                                               \
    jmethodID     method_id;                                                                               \
    jvalue       *args = 0;                                                                                \
    jtype         ret;                                                                                     \
    const char   *method_name;                                                                             \
    const char*   method_sig;                                                                              \
    int           num_args;                                                                                \
                                                                                                           \
    obj_class   = (*env)->GetObjectClass(env, obj);                                                        \
    method_name = (*env)->GetStringUTFChars(env, methodName, 0);                                           \
    method_sig  = (*env)->GetStringUTFChars(env, methodSig, 0);                                            \
    num_args    = (*env)->GetArrayLength(env, args_arr);                                                   \
                                                                                                           \
    method_id = (*env)->GetMethodID(env, obj_class, method_name, method_sig);                              \
                                                                                                           \
    (*env)->ReleaseStringUTFChars(env, methodName, method_name);                                           \
    (*env)->ReleaseStringUTFChars(env, methodSig, method_sig);                                             \
                                                                                                           \
    if (!method_id)                                                                                        \
        return 0;                                                                                          \
                                                                                                           \
    if (num_args > 0 && !(args = calloc(num_args, sizeof(jvalue))))                                        \
        return 0;                                                                                          \
                                                                                                           \
    for (int i = 0; i < num_args; i++)                                                                     \
    {   args[i].l = (*env)->GetObjectArrayElement(env, args_arr, i);                                       \
    }                                                                                                      \
                                                                                                           \
    ret = (*env)->Call##type##MethodA(env, obj, method_id, args);                                          \
                                                                                                           \
    if (args)                                                                                              \
        free(args);                                                                                        \
                                                                                                           \
    return ret;                                                                                            \
}                                                                                                          \

INVOKE(jobject,Object)
INVOKE(jint,Int)

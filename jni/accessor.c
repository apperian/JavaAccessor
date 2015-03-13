
#include "jni.h"
#include "accessor.h"
#include <stdlib.h>

#define APPERIAN_BOOLEAN   0
#define APPERIAN_BYTE      1
#define APPERIAN_CHAR      2
#define APPERIAN_DOUBLE    3
#define APPERIAN_FLOAT     4
#define APPERIAN_INT       5
#define APPERIAN_LONG      6
#define APPERIAN_OBJECT    7
#define APPERIAN_SHORT     8

#define INVOKE(jtype,type) \
JNIEXPORT jtype JNICALL Java_com_apperian_javautil_Accessor_invoke##type(JNIEnv *env, jclass class, jobject obj, jstring methodName, jstring methodSig, jintArray argTypes, jobjectArray args_arr)  \
{   jclass        obj_class;                                                                               \
    jmethodID     method_id;                                                                               \
    jmethodID     convert_id;                                                                              \
    jvalue       *args = 0;                                                                                \
    jtype         ret;                                                                                     \
    jobject       tmp_obj;                                                                                 \
    const char   *method_name;                                                                             \
    const char*   method_sig;                                                                              \
    int          *arg_types;                                                                               \
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
    arg_types = (*env)->GetIntArrayElements(env, argTypes, 0);                                             \
                                                                                                           \
    for (int i = 0; i < num_args; i++)                                                                     \
    {   tmp_obj = (*env)->GetObjectArrayElement(env, args_arr, i);                                         \
                                                                                                           \
        switch(arg_types[i]) {                                                                             \
        case APPERIAN_BYTE:                                                                                \
            convert_id = (*env)->GetMethodID(env, class, "getByte", "(Ljava/lang/Byte;)B");                \
            args[i].b = (*env)->CallStaticByteMethod(env, class, convert_id, tmp_obj);                     \
            break;                                                                                         \
        case APPERIAN_CHAR:                                                                                \
            convert_id = (*env)->GetMethodID(env, class, "getChar", "(Ljava/lang/Char;)C");                \
            args[i].c = (*env)->CallStaticCharMethod(env, class, convert_id, tmp_obj);                     \
            break;                                                                                         \
        case APPERIAN_DOUBLE:                                                                              \
            convert_id = (*env)->GetMethodID(env, class, "getDouble", "(Ljava/lang/Double;)D");            \
            args[i].d = (*env)->CallStaticDoubleMethod(env, class, convert_id, tmp_obj);                   \
            break;                                                                                         \
        case APPERIAN_FLOAT:                                                                               \
            convert_id = (*env)->GetMethodID(env, class, "getFloat", "(Ljava/lang/Float;)F");              \
            args[i].f = (*env)->CallStaticFloatMethod(env, class, convert_id, tmp_obj);                    \
            break;                                                                                         \
        case APPERIAN_INT:                                                                                 \
            convert_id = (*env)->GetMethodID(env, class, "getInt", "(Ljava/lang/Integer;)I");          \
            args[i].i = (*env)->CallStaticIntMethod(env, class, convert_id, tmp_obj);                      \
            printf("int arg: %d", args[i].i); \
            break;                                                                                         \
        case APPERIAN_LONG:                                                                                \
            convert_id = (*env)->GetMethodID(env, class, "getLong", "(Ljava/lang/Long;)J");                \
            args[i].j = (*env)->CallStaticLongMethod(env, class, convert_id, tmp_obj);                     \
            break;                                                                                         \
        case APPERIAN_OBJECT:                                                                              \
            args[i].l = (*env)->CallStaticObjectMethod(env, class, convert_id, tmp_obj);                   \
            break;                                                                                         \
        case APPERIAN_SHORT:                                                                               \
            convert_id = (*env)->GetMethodID(env, class, "getShort", "(Ljava/lang/Short;)S");              \
            args[i].s = (*env)->CallStaticShortMethod(env, class, convert_id, tmp_obj);                    \
            break;                                                                                         \
        }                                                                                                  \
    }                                                                                                      \
                                                                                                           \
    ret = (*env)->Call##type##MethodA(env, obj, method_id, args);                                          \
                                                                                                           \
    if (args)                                                                                              \
        free(args);                                                                                        \
                                                                                                           \
    return ret;                                                                                            \
}

INVOKE(jobject,Object)
INVOKE(jboolean,Boolean)
INVOKE(jbyte,Byte)
INVOKE(jchar,Char)
INVOKE(jshort,Short)
INVOKE(jint,Int)
INVOKE(jdouble,Double)
INVOKE(jlong,Long)
INVOKE(jfloat,Float)



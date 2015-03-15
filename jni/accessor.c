
#include "jni.h"
#include "accessor_jni.h"
#include "accessor.h"
#include <stdlib.h>

static prim_t PRIM = {
    .class_name = "com/apperian/javautil/Accessor"
};

jint JNI_OnLoad(JavaVM *vm, void *reserved)
{   JNIEnv *env;

    if ((*vm)->GetEnv(vm, (void**)&env, JNI_VERSION_1_6) != JNI_OK)
    {   return JNI_ERR;
    }

    PRIM.class = (*env)->FindClass(env, PRIM.class_name);
    if (!PRIM.class)
    {   return JNI_ERR;
    }
    PRIM.class = (*env)->NewGlobalRef(env, PRIM.class);

    PRIM.to_boolean = (*env)->GetMethodID(env, PRIM.class, "getBoolean", "(Ljava/lang/Boolean;)Z");
    PRIM.to_byte    = (*env)->GetMethodID(env, PRIM.class, "getByte", "(Ljava/lang/Byte;)B");
    PRIM.to_char    = (*env)->GetMethodID(env, PRIM.class, "getChar", "(Ljava/lang/Character;)C");
    PRIM.to_double  = (*env)->GetMethodID(env, PRIM.class, "getDouble", "(Ljava/lang/Double;)D");
    PRIM.to_float   = (*env)->GetMethodID(env, PRIM.class, "getFloat", "(Ljava/lang/Float;)F");
    PRIM.to_int     = (*env)->GetMethodID(env, PRIM.class, "getInt", "(Ljava/lang/Integer;)I");
    PRIM.to_long    = (*env)->GetMethodID(env, PRIM.class, "getLong", "(Ljava/lang/Long;)J");
    PRIM.to_short   = (*env)->GetMethodID(env, PRIM.class, "getShort", "(Ljava/lang/Short;)S");

    return JNI_VERSION_1_6;
}


#define  DECLARE_JTYPE(jtype,var)       jtype  var;
#define  DECLARE_VOID(jtype,var)        /* no declaration needed  */
#define  METHOD_CALL(type)              (*env)->Call##type##MethodA(env, obj, method_id, args);
#define  JTYPE_CALL(type,var)           var = METHOD_CALL(type)
#define  VOID_CALL(type,var)            METHOD_CALL(type)
#define  JTYPE_RETURN(var)              return var;
#define  VOID_RETURN(var)               return;

#define DEFINE_METHOD(TYPE,jtype,type)                                                                     \
JNIEXPORT jtype JNICALL Java_com_apperian_javautil_Accessor_invoke##type(                                  \
    JNIEnv *env,                                                                                           \
    jclass class,                                                                                          \
    jobject obj,                                                                                           \
    jstring methodName,                                                                                    \
    jstring methodSig,                                                                                     \
    jintArray argTypes,                                                                                    \
    jobjectArray args_arr                                                                                  \
)                                                                                                          \
{   jclass        obj_class;                                                                               \
    jmethodID     method_id;                                                                               \
    jvalue       *args = 0;                                                                                \
    DECLARE_##TYPE(jtype,ret)                                                                              \
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
        TYPE##_RETURN(0)                                                                                          \
                                                                                                           \
    if (num_args > 0 && !(args = calloc(num_args, sizeof(jvalue))))                                        \
        TYPE##_RETURN(0)                                                                                          \
                                                                                                           \
    arg_types = (*env)->GetIntArrayElements(env, argTypes, 0);                                             \
                                                                                                           \
    for (int i = 0; i < num_args; i++)                                                                     \
    {   tmp_obj = (*env)->GetObjectArrayElement(env, args_arr, i);                                         \
        get_arg(env, arg_types[i], &args[i], tmp_obj);                                                     \
    }                                                                                                      \
                                                                                                           \
    TYPE##_CALL(type,ret)                                                                                  \
                                                                                                           \
    if (args)                                                                                              \
        free(args);                                                                                        \
                                                                                                           \
    TYPE##_RETURN(ret)                                                                                     \
}

void get_arg(JNIEnv *env, int arg_type, jvalue *arg, jobject obj)
{
    switch(arg_type) {
    case APPERIAN_BYTE:
        arg->b = (*env)->CallStaticByteMethod(env, PRIM.class, PRIM.to_byte, obj);
        break;
    case APPERIAN_CHAR:
        arg->c = (*env)->CallStaticCharMethod(env, PRIM.class, PRIM.to_char, obj);
        break;
    case APPERIAN_DOUBLE:
        arg->d = (*env)->CallStaticDoubleMethod(env, PRIM.class, PRIM.to_double, obj);
        break;
    case APPERIAN_FLOAT:
        arg->f = (*env)->CallStaticFloatMethod(env, PRIM.class, PRIM.to_float, obj);
        break;
    case APPERIAN_INT:
        arg->i = (*env)->CallStaticIntMethod(env, PRIM.class, PRIM.to_int, obj);
        break;
    case APPERIAN_LONG:
        arg->j = (*env)->CallStaticLongMethod(env, PRIM.class, PRIM.to_long, obj);
        break;
    case APPERIAN_SHORT:
        arg->s = (*env)->CallStaticShortMethod(env, PRIM.class, PRIM.to_short, obj);
        break;
    default:
        arg->l = obj;
    }
}

DEFINE_METHOD(VOID,void,Void)
DEFINE_METHOD(JTYPE,jboolean,Boolean)
DEFINE_METHOD(JTYPE,jbyte,Byte)
DEFINE_METHOD(JTYPE,jchar,Char)
DEFINE_METHOD(JTYPE,jdouble,Double)
DEFINE_METHOD(JTYPE,jint,Int)
DEFINE_METHOD(JTYPE,jlong,Long)
DEFINE_METHOD(JTYPE,jfloat,Float)
DEFINE_METHOD(JTYPE,jobject,Object)
DEFINE_METHOD(JTYPE,jshort,Short)



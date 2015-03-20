
#include "jni.h"
#include "accessor_jni.h"
#include "accessor.h"
#include <stdlib.h>

#define CONCATX(A, B)                   A ## B
#define CONCAT(A,B)                     CONCATX(A,B)

#define CLASSPFX                        Java_com_apperian_javautil_AccessorNative_
#define FUNC_NAME(name)                 CONCAT(CLASSPFX,name)

jint JNI_OnLoad(JavaVM *vm, void *reserved);
void get_arg(JNIEnv *env, int arg_type, jvalue *arg, jobject obj);


static prim_t PRIM = {
    .class_name = "com/apperian/javautil/Primitives"
};

/*
 *  Macros for generating JNI function names, variables,
 *  and statements based on types
 */
#define  DECLARE_JTYPE(jtype,var)       jtype  var
#define  DECLARE_VOID(jtype,var)        /* no declaration needed  */
#define  JTYPE_ASSIGN(type,var,stmt)    var = stmt
#define  VOID_ASSIGN(type,var,stmt)     stmt
#define  JTYPE_RETURN(var)              return var
#define  VOID_RETURN(var)               return

#define SET_RET_TYPE(jtype)             void
#define GET_RET_TYPE(jtype)             jtype
#define SET_NAME(type)                  set##type##Field
#define GET_NAME(type)                  get##type##Field
#define SET_ARGS(stmt,...)              __VA_ARGS__, stmt
#define GET_ARGS(stmt,...)              __VA_ARGS__
#define GET_STMT(stmt)                  Get##stmt
#define SET_STMT(stmt)                  Set##stmt

/*
 * The following macros are used to generate all of the public interface
 * functions for the native class. They're a little hairy, but it's better
 * than changing 20 individual functions every time a change is needed.
 */
#define DEFINE_METHOD_ACCESSOR(RET_TYPE,jtype,type)                                                                       \
JNIEXPORT jtype JNICALL FUNC_NAME(invoke##type)(                                                                          \
    JNIEnv *env,                                                                                                          \
    jclass class,                                                                                                         \
    jobject obj,                                                                                                          \
    jstring methodName,                                                                                                   \
    jboolean isStatic,                                                                                                    \
    jstring methodSig,                                                                                                    \
    jintArray argTypes,                                                                                                   \
    jobjectArray argsArr                                                                                                  \
)                                                                                                                         \
{   jclass        obj_class;                                                                                              \
    jmethodID     method_id;                                                                                              \
    jvalue       *args = 0;                                                                                               \
    DECLARE_##RET_TYPE(jtype,ret);                                                                                        \
    jobject       tmp_obj;                                                                                                \
    const char   *method_name;                                                                                            \
    const char*   method_sig;                                                                                             \
    int          *arg_types;                                                                                              \
    int           num_args;                                                                                               \
                                                                                                                          \
    if (isStatic)                                                                                                         \
        obj_class = obj;                                                                                                  \
    else                                                                                                                  \
        obj_class   = (*env)->GetObjectClass(env, obj);                                                                   \
                                                                                                                          \
    method_name = (*env)->GetStringUTFChars(env, methodName, 0);                                                          \
    method_sig  = (*env)->GetStringUTFChars(env, methodSig, 0);                                                           \
    num_args    = (*env)->GetArrayLength(env, argsArr);                                                                   \
                                                                                                                          \
    if (isStatic)                                                                                                         \
        method_id = (*env)->GetStaticMethodID(env, obj_class, method_name, method_sig);                                   \
    else                                                                                                                  \
        method_id = (*env)->GetMethodID(env, obj_class, method_name, method_sig);                                         \
                                                                                                                          \
    (*env)->ReleaseStringUTFChars(env, methodName, method_name);                                                          \
    (*env)->ReleaseStringUTFChars(env, methodSig, method_sig);                                                            \
                                                                                                                          \
    if (!method_id)                                                                                                       \
        RET_TYPE##_RETURN(0);                                                                                             \
                                                                                                                          \
    if (num_args > 0 && !(args = calloc(num_args, sizeof(jvalue))))                                                       \
        RET_TYPE##_RETURN(0);                                                                                             \
                                                                                                                          \
    arg_types = (*env)->GetIntArrayElements(env, argTypes, 0);                                                            \
                                                                                                                          \
    for (int i = 0; i < num_args; i++)                                                                                    \
    {   tmp_obj = (*env)->GetObjectArrayElement(env, argsArr, i);                                                         \
        get_arg(env, arg_types[i], &args[i], tmp_obj);                                                                    \
    }                                                                                                                     \
                                                                                                                          \
    if (isStatic)                                                                                                         \
        RET_TYPE##_ASSIGN(type,ret,(*env)->CallStatic##type##MethodA(env, obj, method_id, args));                         \
    else                                                                                                                  \
        RET_TYPE##_ASSIGN(type,ret,(*env)->Call##type##MethodA(env, obj, method_id, args));                               \
                                                                                                                          \
    if (args)                                                                                                             \
        free(args);                                                                                                       \
                                                                                                                          \
    RET_TYPE##_RETURN(ret);                                                                                               \
}

#define DEFINE_FIELD_ACCESSOR(RET_TYPE,FUNC,jtype,type)                                                                   \
JNIEXPORT FUNC##_RET_TYPE(jtype) JNICALL FUNC_NAME(FUNC##_NAME(type))(                                                    \
    FUNC##_ARGS(                                                                                                          \
        jtype value,                                                                                                      \
        JNIEnv *env,                                                                                                      \
        jclass class,                                                                                                     \
        jobject obj,                                                                                                      \
        jstring fieldName,                                                                                                \
        jboolean isStatic,                                                                                                \
        jstring fieldSig                                                                                                  \
    )                                                                                                                     \
)                                                                                                                         \
{   jclass        obj_class;                                                                                              \
    jfieldID      field_id;                                                                                               \
    DECLARE_##RET_TYPE(jtype,ret);                                                                                        \
    const char   *field_name;                                                                                             \
    const char*   field_sig;                                                                                              \
                                                                                                                          \
    if (isStatic)                                                                                                         \
        obj_class = obj;                                                                                                  \
    else                                                                                                                  \
        obj_class   = (*env)->GetObjectClass(env, obj);                                                                   \
                                                                                                                          \
    field_name = (*env)->GetStringUTFChars(env, fieldName, 0);                                                            \
    field_sig  = (*env)->GetStringUTFChars(env, fieldSig, 0);                                                             \
                                                                                                                          \
    if (isStatic)                                                                                                         \
        field_id = (*env)->GetStaticFieldID(env, obj_class, field_name, field_sig);                                       \
    else                                                                                                                  \
        field_id = (*env)->GetFieldID(env, obj_class, field_name, field_sig);                                             \
                                                                                                                          \
    (*env)->ReleaseStringUTFChars(env, fieldName, field_name);                                                            \
    (*env)->ReleaseStringUTFChars(env, fieldSig, field_sig);                                                              \
                                                                                                                          \
    if (!field_id)                                                                                                        \
        RET_TYPE##_RETURN(0);                                                                                             \
                                                                                                                          \
    if (isStatic)                                                                                                         \
        RET_TYPE##_ASSIGN(type,ret,(*env)->FUNC##_STMT(Static##type##Field)(FUNC##_ARGS(value,env, obj, field_id)));      \
    else                                                                                                                  \
        RET_TYPE##_ASSIGN(type,ret,(*env)->FUNC##_STMT(type##Field)(FUNC##_ARGS(value,env, obj, field_id)));              \
                                                                                                                          \
    RET_TYPE##_RETURN(ret);                                                                                               \
}

/*
 * The main reason for implementing this function is to cache the methodIDs
 * for the primitive conversion functions so we don't have to constantly look
 * them up.
 */
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

/*
 * Calls the appropriate conversion method. Kind of annoying that we need this,
 * but the arguments that we get will always be cast to Objects, but the function
 * we are calling is expecting primitives so we need to convert.
 */
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

DEFINE_METHOD_ACCESSOR(JTYPE,jboolean,Boolean)
DEFINE_METHOD_ACCESSOR(JTYPE,jbyte,Byte)
DEFINE_METHOD_ACCESSOR(JTYPE,jchar,Char)
DEFINE_METHOD_ACCESSOR(JTYPE,jdouble,Double)
DEFINE_METHOD_ACCESSOR(JTYPE,jint,Int)
DEFINE_METHOD_ACCESSOR(JTYPE,jlong,Long)
DEFINE_METHOD_ACCESSOR(JTYPE,jfloat,Float)
DEFINE_METHOD_ACCESSOR(JTYPE,jobject,Object)
DEFINE_METHOD_ACCESSOR(JTYPE,jshort,Short)
DEFINE_METHOD_ACCESSOR(VOID,void,Void)

DEFINE_FIELD_ACCESSOR(JTYPE,GET,jboolean,Boolean)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jbyte,Byte)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jchar,Char)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jdouble,Double)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jint,Int)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jlong,Long)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jfloat,Float)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jobject,Object)
DEFINE_FIELD_ACCESSOR(JTYPE,GET,jshort,Short)

DEFINE_FIELD_ACCESSOR(VOID,SET,jboolean,Boolean)
DEFINE_FIELD_ACCESSOR(VOID,SET,jbyte,Byte)
DEFINE_FIELD_ACCESSOR(VOID,SET,jchar,Char)
DEFINE_FIELD_ACCESSOR(VOID,SET,jdouble,Double)
DEFINE_FIELD_ACCESSOR(VOID,SET,jint,Int)
DEFINE_FIELD_ACCESSOR(VOID,SET,jlong,Long)
DEFINE_FIELD_ACCESSOR(VOID,SET,jfloat,Float)
DEFINE_FIELD_ACCESSOR(VOID,SET,jobject,Object)
DEFINE_FIELD_ACCESSOR(VOID,SET,jshort,Short)



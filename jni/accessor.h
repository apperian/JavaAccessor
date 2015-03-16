
#include  "jni.h"

#define APPERIAN_BOOLEAN   0x00
#define APPERIAN_BYTE      0x01
#define APPERIAN_CHAR      0x02
#define APPERIAN_DOUBLE    0x03
#define APPERIAN_FLOAT     0x04
#define APPERIAN_INT       0x05
#define APPERIAN_LONG      0x06
#define APPERIAN_OBJECT    0x07
#define APPERIAN_SHORT     0x08
#define APPERIAN_VOID      0x09

jint JNI_OnLoad(JavaVM *vm, void *reserved);

typedef struct {
    char       *class_name;
    jclass     class;
    jmethodID  to_boolean;
    jmethodID  to_byte;
    jmethodID  to_char;
    jmethodID  to_double;
    jmethodID  to_float;
    jmethodID  to_int;
    jmethodID  to_long;
    jmethodID  to_short;
} prim_t;

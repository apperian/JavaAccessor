package com.apperian.javautil;

/** Provides the interface to the native implementation
 *  of the onvocation methods
 * 
 * @author   Kevin LaFlamme
 * 
 */
final class AccessorNative {
    
    static {
        System.loadLibrary("accessor");
    }
    
    static final int BOOLEAN    = 0x00;
    static final int BYTE       = 0x01;
    static final int CHAR       = 0x02;
    static final int DOUBLE     = 0x03;
    static final int FLOAT      = 0x04;
    static final int INT        = 0x05;
    static final int LONG       = 0x06;
    static final int OBJECT     = 0x07;
    static final int SHORT      = 0x08;
    static final int VOID       = 0x09;
    
    static native boolean  invokeBoolean(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native byte     invokeByte(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native char     invokeChar(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native double   invokeDouble(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native int      invokeInt(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native float    invokeFloat(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native long     invokeLong(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native Object   invokeObject(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native short    invokeShort(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    static native void     invokeVoid(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    
    static native boolean  getBooleanField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native byte     getByteField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native char     getCharField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native double   getDoubleField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native int      getIntField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native float    getFloatField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native long     getLongField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native Object   getObjectField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    static native short    getShortField(Object obj, String fieldName, boolean isStatic, String fieldSig);
    
    static native void     setBooleanField(Object obj, String fieldName, boolean isStatic, String fieldSig, boolean z);
    static native void     setByteField(Object obj, String fieldName, boolean isStatic, String fieldSig, byte b);
    static native void     setCharField(Object obj, String fieldName, boolean isStatic, String fieldSig, char c);
    static native void     setDoubleField(Object obj, String fieldName, boolean isStatic, String fieldSig, double d);
    static native void     setIntField(Object obj, String fieldName, boolean isStatic, String fieldSig, int i);
    static native void     setFloatField(Object obj, String fieldName, boolean isStatic, String fieldSig, float f);
    static native void     setLongField(Object obj, String fieldName, boolean isStatic, String fieldSig, long l);
    static native void     setObjectField(Object obj, String fieldName, boolean isStatic, String fieldSig, Object o);
    static native void     setShortField(Object obj, String fieldName, boolean isStatic, String fieldSig, short s);
}

package com.apperian.javautil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** Provides constants and conversion methods for 
 *  working with primitive values between Java and JNI
 * 
 * @author   Kevin LaFlamme
 * 
 */
public final class Primitives {
    
    /** Class representing internal native types that
     *  are necessary for JNI calls
     */
    public final class NativeType {
        public static final int BOOLEAN    = AccessorNative.BOOLEAN;
        public static final int BYTE       = AccessorNative.BYTE;
        public static final int CHAR       = AccessorNative.CHAR;
        public static final int DOUBLE     = AccessorNative.DOUBLE;
        public static final int FLOAT      = AccessorNative.FLOAT;
        public static final int INT        = AccessorNative.INT;
        public static final int LONG       = AccessorNative.LONG;
        public static final int OBJECT     = AccessorNative.OBJECT;
        public static final int SHORT      = AccessorNative.SHORT;
        public static final int VOID       = AccessorNative.VOID;
    }
    
    /** Class representing internal raw types that
     *  are necessary for method signatures
     */
    public final class RawType {
        public static final char BOOLEAN   = 'Z';
        public static final char BYTE      = 'B';
        public static final char CHAR      = 'C';
        public static final char DOUBLE    = 'D';
        public static final char FLOAT     = 'F';
        public static final char INT       = 'I';
        public static final char LONG      = 'J';
        public static final char OBJECT    = 'L';
        public static final char SHORT     = 'S';
        public static final char VOID      = 'V';
    }
    
    /**
     * Internal class used to map the primitive classes
     * to their raw and native type constants
     */
    private static class Type {
        public final int mNativeType;
        public final char mRawType;
        public Type(int nativeType, char rawType) {
            mNativeType = nativeType;
            mRawType = rawType;
        }
    }
    
    /**
     * Internal field that maps primitive type classes
     * to raw and native constants
     */
    private static final Map<Class<?>,Type> mTypes;
    static {
        HashMap<Class<?>,Type> map = new HashMap<Class<?>,Type>();
        map.put(boolean.class, new Type(NativeType.BOOLEAN, RawType.BOOLEAN));
        map.put(byte.class, new Type(NativeType.BYTE, RawType.BYTE));
        map.put(char.class, new Type(NativeType.CHAR, RawType.CHAR));
        map.put(double.class, new Type(NativeType.DOUBLE, RawType.DOUBLE));
        map.put(float.class, new Type(NativeType.FLOAT, RawType.FLOAT));
        map.put(int.class, new Type(NativeType.INT, RawType.INT));
        map.put(long.class, new Type(NativeType.LONG, RawType.LONG));
        map.put(Object.class, new Type(NativeType.OBJECT, RawType.OBJECT));
        map.put(short.class, new Type(NativeType.SHORT, RawType.SHORT));
        map.put(void.class, new Type(NativeType.VOID, RawType.VOID));
        mTypes = Collections.unmodifiableMap(map);
    }

    /**
     * Retrieves the native type constant for {@code cls}
     * 
     * @param cls    Class for which to retrieve native type
     * @return       The native type constant for {@code cls}
     */
    public static int getNativeType(Class<?> cls) {
        Class<?> prim = cls;
        if (!mTypes.containsKey(cls)) {
            prim = Object.class;
        }
        return mTypes.get(prim).mNativeType;           
    }
    
    /**
     * Retrieves the raw type constant for {@code cls}
     * 
     * @param cls    Class for which to retrieve raw type
     * @return       The raw type constant for {@code cls}
     */
    public static char getRawType(Class<?> cls) {
        Class<?> prim = cls;
        if (!mTypes.containsKey(cls)) {
            prim = Object.class;
        }
        return mTypes.get(prim).mRawType;           
    }
    
    /**
     * Converts a Boolean object to a primitive boolean
     * 
     * @param o    Boolean object
     * @return     primitive boolean with value of {@code o} 
     */
    public boolean getBoolean(Boolean o) {
        return o;
    }
    
    /**
     * Converts a Byte object to a primitive byte
     * 
     * @param o    Byte object
     * @return     primitive byte with value of {@code o} 
     */
    public byte getByte(Byte o) {
        return o;
    }
    
    /**
     * Converts a Char object to a primitive char
     * 
     * @param o    Char object
     * @return     primitive char with value of {@code o} 
     */
    public char getChar(Character o) {
        return o;
    }
    
    /**
     * Converts a Double object to a primitive double
     * 
     * @param o    Double object
     * @return     primitive double with value of {@code o} 
     */
    public double getDouble(Double o) {
        return o;
    }
    
    /**
     * Converts a Float object to a primitive float
     * 
     * @param o    Float object
     * @return     primitive float with value of {@code o} 
     */
    public float getFloat(Float o) {
        return o;
    }
    
    /**
     * Converts a Integer object to a primitive int
     * 
     * @param o    Integer object
     * @return     primitive int with value of {@code o} 
     */
    public int getInt(Integer o) {
        return o;
    }
    
    /**
     * Converts a Long object to a primitive long
     * 
     * @param o    Long object
     * @return     primitive long with value of {@code o} 
     */
    public long getLong(Long o) {
        return o;
    }
    
    /**
     * Converts a Short object to a primitive short
     * 
     * @param o    Short object
     * @return     primitive short with value of {@code o} 
     */
    public short getShort(Short o) {
        return o;
    }
}

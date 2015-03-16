package com.apperian.javautil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Primitives {
    
    private static class Type {
        public final int mTypeOffset;
        public final char mRawType;
        public Type(int type, char rawType) {
            mTypeOffset = type;
            mRawType = rawType;
        }
    }
    
    public final class TypeOffset {
        public static final int BOOLEAN    = 0x00;
        public static final int BYTE       = 0x01;
        public static final int CHAR       = 0x02;
        public static final int DOUBLE     = 0x03;
        public static final int FLOAT      = 0x04;
        public static final int INT        = 0x05;
        public static final int LONG       = 0x06;
        public static final int OBJECT     = 0x07;
        public static final int SHORT      = 0x08;
        public static final int VOID       = 0x09;
    }
    
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
    
    private static final Map<Class<?>,Type> mTypes;
    static {
        HashMap<Class<?>,Type> map = new HashMap<Class<?>,Type>();
        map.put(boolean.class, new Type(TypeOffset.BOOLEAN, RawType.BOOLEAN));
        map.put(byte.class, new Type(TypeOffset.BYTE, RawType.BYTE));
        map.put(char.class, new Type(TypeOffset.CHAR, RawType.CHAR));
        map.put(double.class, new Type(TypeOffset.DOUBLE, RawType.DOUBLE));
        map.put(float.class, new Type(TypeOffset.FLOAT, RawType.FLOAT));
        map.put(int.class, new Type(TypeOffset.INT, RawType.INT));
        map.put(long.class, new Type(TypeOffset.LONG, RawType.LONG));
        map.put(Object.class, new Type(TypeOffset.OBJECT, RawType.OBJECT));
        map.put(short.class, new Type(TypeOffset.SHORT, RawType.SHORT));
        map.put(void.class, new Type(TypeOffset.VOID, RawType.VOID));
        mTypes = Collections.unmodifiableMap(map);
    }

    public static int getTypeOffset(Class<?> cls) {
        Class<?> prim = cls;
        if (!mTypes.containsKey(cls)) {
            prim = Object.class;
        }
        return mTypes.get(prim).mTypeOffset;           
    }
    
    public static char getRawType(Class<?> cls) {
        Class<?> prim = cls;
        if (!mTypes.containsKey(cls)) {
            prim = Object.class;
        }
        return mTypes.get(prim).mRawType;           
    }
    
    public boolean getBoolean(Boolean o) {
        return o;
    }
    
    public byte getByte(Byte o) {
        return o;
    }
    
    public char getChar(Character o) {
        return o;
    }
    
    public double getDouble(Double o) {
        return o;
    }
    
    public float getFloat(Float o) {
        return o;
    }
    
    public int getInt(Integer o) {
        return o;
    }
    
    public long getLong(Long o) {
        return o;
    }
    
    public short getShort(Short o) {
        return o;
    }
}

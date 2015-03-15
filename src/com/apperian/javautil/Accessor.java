package com.apperian.javautil;

import java.lang.reflect.Method;

public class Accessor {
    
    static {
        System.loadLibrary("accessor");
    }
    
    private static native Object   invokeObject(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    private static native boolean  invokeBoolean(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    private static native byte     invokeByte(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    private static native char     invokeChar(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    public static native double    invokeDouble(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    private static native int      invokeInt(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    public static native float     invokeFloat(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    public static native long      invokeLong(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    private static native short    invokeShort(Object obj, String methodName, String methodSig, int[] argTypes, Object[] args);
    
    
    public static Object invokeMethod(Object obj, String methodName, Object[] args, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        
        Method method = obj.getClass().getMethod(methodName, parameterTypes);
        
        return invokeMethod(obj, method, args);
    }
    
    public static Object invokeMethod(Object obj, String methodName, Object[] args) throws NoSuchMethodException {
        
        Method[] methods = obj.getClass().getMethods();
        
        Method method = null;
        
        for (Method m : methods) {
            String mName = m.getName();
            
            if (mName.equals(methodName)) {
                method = m;
                break;
            }
        }
        
        if (method == null) {
            throw new NoSuchMethodException("Accessor.invokeMethod(): Method '" + methodName + "' not found on object '" + obj.getClass().getCanonicalName() + "'");
        }
        
        return invokeMethod(obj, method, args);
    }
    
    public static Object invokeMethod(Object obj, Method method, Object[] args) {
        
        String methodSignature = MethodTools.getRawMethodSignature(method);
        
        int[] methodArgTypes = MethodTools.getMethodArgTypes(method);
        
        Class<?> clazz = method.getReturnType();
        
        if (clazz.equals(int.class)) {
            return invokeInt(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(boolean.class)) {
            return invokeBoolean(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(byte.class)) {
            return invokeByte(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(char.class)) {
            return invokeChar(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(double.class)) {
            return invokeDouble(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(float.class)) {
            return invokeFloat(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(long.class)) {
            return invokeLong(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
        else if (clazz.equals(short.class)) {
            return invokeShort(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
//        else if (clazz.equals(void.class)) {
//            return invokeVoid(obj, method.getName(), methodSignature, methodArgTypes, args);
//        }
        else {
            return invokeObject(obj, method.getName(), methodSignature, methodArgTypes, args);
        }
    }
    
    private boolean getBoolean(Boolean o) {
        return o;
    }
    
    private byte getByte(Byte o) {
        return o;
    }
    
    private char getChar(Character o) {
        return o;
    }
    
    private double getDouble(Double o) {
        return o;
    }
    
    private int getInt(Integer o) {
        return o;
    }
    
    private float getFloat(Float o) {
        return o;
    }
    
    private long getLong(Long o) {
        return o;
    }
    
    private short getShort(Short o) {
        return o;
    }
}

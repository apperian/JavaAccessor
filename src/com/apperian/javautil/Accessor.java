package com.apperian.javautil;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Accessor {
    
    static {
        System.loadLibrary("accessor");
    }
    
    private static native boolean  invokeBoolean(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native byte     invokeByte(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native char     invokeChar(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native double   invokeDouble(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native int      invokeInt(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native float    invokeFloat(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native long     invokeLong(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native Object   invokeObject(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native short    invokeShort(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    private static native void     invokeVoid(Object obj, String methodName, boolean isStatic, String methodSig, int[] argTypes, Object[] args);
    
    public static Object invokeMethod(Object obj, String methodName, Object[] args, Class<?>... parameterTypes) 
            throws NoSuchMethodException, SecurityException, UnsupportedTypeException 
    {
        Class<?> cls = obj instanceof Class ? 
            (Class<?>)obj : 
            obj.getClass();
            
        Method method = cls.getMethod(methodName, parameterTypes);
        return invokeMethod(obj, method, args);
    }
    
    public static Object invokeMethod(Object obj, String methodName, Object[] args) 
            throws NoSuchMethodException, UnsupportedTypeException 
    {
        Class<?> cls = obj instanceof Class ? 
                (Class<?>)obj : 
                obj.getClass();
                
        Method[] methods = cls.getMethods();
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
    
    public static Object invokeMethod(Object obj, Method method, Object[] args) 
            throws UnsupportedTypeException 
    {
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        String methodSignature = Methods.getMethodSignature(method);
        int[] methodArgTypes = Methods.getArgTypes(method);
        Class<?> cls = method.getReturnType();
        
        switch(Primitives.getTypeOffset(cls)) {
        case Primitives.TypeOffset.BOOLEAN:
            return invokeBoolean(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.BYTE:
            return invokeByte(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.CHAR:
            return invokeChar(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.DOUBLE:
            return invokeDouble(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.FLOAT:
            return invokeFloat(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.INT:
            return invokeInt(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.LONG:
            return invokeLong(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.OBJECT:
            return invokeObject(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.SHORT:
            return invokeShort(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case Primitives.TypeOffset.VOID:
            invokeVoid(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
            return null;
        default:
            throw new UnsupportedTypeException(method,cls);
        }
    }
}

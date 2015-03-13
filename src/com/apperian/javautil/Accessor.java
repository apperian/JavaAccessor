package com.apperian.javautil;

import java.lang.reflect.Method;

public class Accessor {
    
    static {
        System.loadLibrary("accessor");
    }
    
    public static native Object invoke();
    
    
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
        
        
        return 5;
    }
}

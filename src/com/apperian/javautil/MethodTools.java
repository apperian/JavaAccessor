package com.apperian.javautil;

import java.lang.reflect.Method;

public class MethodTools {
    
    public static String getRawMethodSignature(Method method) {
        
        Class<?>[] methodClasses = method.getParameterTypes();
        
        StringBuilder builder = new StringBuilder("(");
        
        // add parameter methods
        for (Class<?> methodClass : methodClasses) {
            builder.append(MethodTools.convertClassToRawRepresentation(methodClass));
        }
        
        builder.append(")");
        
        // add return type
        Class<?> returnType = method.getReturnType();
        builder.append(MethodTools.convertClassToRawRepresentation(returnType));
        
        return builder.toString();
    }
    
    private static String convertClassToRawRepresentation(Class<?> clazz) {
        
        if (clazz.equals(int.class)) {
            return "I";
        }
        else if (clazz.equals(boolean.class)) {
            return "Z";
        }
        else if (clazz.equals(byte.class)) {
            return "B";
        }
        else if (clazz.equals(char.class)) {
            return "C";
        }
        else if (clazz.equals(double.class)) {
            return "D";
        }
        else if (clazz.equals(float.class)) {
            return "F";
        }
        else if (clazz.equals(long.class)) {
            return "J";
        }
        else if (clazz.equals(short.class)) {
            return "S";
        }
        else if (clazz.equals(void.class)) {
            return "V";
        }
        else {
            return "L" + clazz.getName().replace('.', '/') + ";";
        }
    }
}

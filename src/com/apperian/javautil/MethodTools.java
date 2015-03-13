package com.apperian.javautil;

import java.lang.reflect.Method;

public class MethodTools {
    
    public class ParameterTypeConstants {
        public static final int BOOLEAN = 0;
        public static final int BYTE = 1;
        public static final int CHAR = 2;
        public static final int DOUBLE = 3;
        public static final int FLOAT = 4;
        public static final int INT = 5;
        public static final int LONG = 6;
        public static final int OBJECT = 7;
        public static final int SHORT = 8;
        public static final int VOID = 9;
        public static final int ARRAY = 10;
    }
    
    
    public static String getRawMethodSignature(Method method) {
        
        Class<?>[] paramClasses = method.getParameterTypes();
        
        StringBuilder builder = new StringBuilder("(");
        
        // add parameter methods
        for (Class<?> paramClass : paramClasses) {
            builder.append(MethodTools.convertClassToRawRepresentation(paramClass));
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
            String className = clazz.getName();
            //System.out.println("CLASS NAME: " + className);
            
            if (className.startsWith("[")) {
                return className;
            }
            else {
                return "L" + clazz.getName().replace('.', '/') + ";";
            }
        }
    }
    
    public static int[] getMethodArgTypes(Method method) {
        Class<?>[] paramClasses = method.getParameterTypes();
        
        int[] paramTypes = new int[paramClasses.length];
        
        for (int i = 0; i < paramTypes.length; i++) {
            paramTypes[i] = getArgType(paramClasses[i]);
        }
        
        return paramTypes;
    }
    
    private static int getArgType(Class<?> clazz) {
        if (clazz.equals(int.class)) {
            return ParameterTypeConstants.INT;
        }
        else if (clazz.equals(boolean.class)) {
            return ParameterTypeConstants.BOOLEAN;
        }
        else if (clazz.equals(byte.class)) {
            return ParameterTypeConstants.BYTE;
        }
        else if (clazz.equals(char.class)) {
            return ParameterTypeConstants.CHAR;
        }
        else if (clazz.equals(double.class)) {
            return ParameterTypeConstants.DOUBLE;
        }
        else if (clazz.equals(float.class)) {
            return ParameterTypeConstants.FLOAT;
        }
        else if (clazz.equals(long.class)) {
            return ParameterTypeConstants.LONG;
        }
        else if (clazz.equals(short.class)) {
            return ParameterTypeConstants.SHORT;
        }
        else if (clazz.equals(void.class)) {
            return ParameterTypeConstants.VOID;
        }
        else {
            return ParameterTypeConstants.OBJECT;
        }
    }
}

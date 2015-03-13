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
}

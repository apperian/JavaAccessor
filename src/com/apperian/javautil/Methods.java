package com.apperian.javautil;

import java.lang.reflect.Method;

public class Methods {
    
    public static String getMethodSignature(Method method) {
        
        Class<?>[] paramClasses = method.getParameterTypes();
        StringBuilder builder = new StringBuilder("(");
        
        // add parameter methods
        for (Class<?> paramClass : paramClasses) {
            builder.append(getRawName(paramClass));
        }
        
        builder.append(")");
        
        // add return type
        Class<?> returnType = method.getReturnType();
        builder.append(getRawName(returnType));
        
        return builder.toString();
    }
    
    public static int[] getArgTypes(Method method) {
        
        Class<?>[] paramClasses = method.getParameterTypes();
        int[] paramTypes = new int[paramClasses.length];
        
        for (int i = 0; i < paramTypes.length; i++) {
            paramTypes[i] = getArgType(paramClasses[i]);
        }
        return paramTypes;
    }
    
    private static String getRawName(Class<?> cls) {
        
        StringBuilder rawName = new StringBuilder();
        char rawType = Primitives.getRawType(cls);
        
        if (rawType == Primitives.RawType.OBJECT) {
            String className = cls.getName();
            
            if (className.startsWith("[")) {
                rawName.append(className);
            }
            else {
                rawName.append("L");
                rawName.append(cls.getName().replace('.', '/'));
                rawName.append(";");
            }
        } else {
            rawName.append(rawType);
        }
        return rawName.toString();
    }
    
    private static int getArgType(Class<?> cls) {
        return Primitives.getTypeOffset(cls);
    }
}

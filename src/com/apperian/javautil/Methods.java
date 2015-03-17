package com.apperian.javautil;

import java.lang.reflect.Method;

/** Provides methods for retrieving information about
 *  a Class or Method object.
 * 
 * @author   James Seibel
 * @author   Kevin LaFlamme
 * 
 */
public final class Methods {
    
    /**
     * Gets the method signature for a particular Method
     * <p>
     * This method returns the internal method signature for a Method object.
     * This signature can be used to retrieve the jmethodID via JNI 
     * 
     * @param method      The Method object used to retrieve the signature
     * @return            A {@link java.lang.String} representing the method signature
     */
    static String getSignature(Method method) {
        
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
    
    /**
     * Gets an internal representation of the argument types used by the native interface
     * 
     * @param method     The Method object used to retrieve the argument types
     * @return           The internal representation of the argument types
     */
    static int[] getArgTypes(Method method) {
        
        Class<?>[] paramClasses = method.getParameterTypes();
        int[] paramTypes = new int[paramClasses.length];
        
        for (int i = 0; i < paramTypes.length; i++) {
            paramTypes[i] = getArgType(paramClasses[i]);
        }
        return paramTypes;
    }
    
    /**
     *  Retrieves the raw internal name for {@code cls}
     * 
     *  @param cls       The class to get the raw name for
     *  @return          A {@link java.lang.String} representation of the
     *                   raw internal name for {@code cls}
     */
    private static String getRawName(Class<?> cls) {
        
        StringBuilder rawName = new StringBuilder();
        char rawType = Primitives.getRawType(cls);
        
        if (rawType == Primitives.RawType.OBJECT) {
            String className = cls.getName();
            
            if (className.startsWith("[")) {
                rawName.append(className.replace('.', '/'));
            }
            else {
                rawName.append("L");
                rawName.append(className.replace('.', '/'));
                rawName.append(";");
            }
        } else {
            rawName.append(rawType);
        }
        return rawName.toString();
    }
    
    /**
     *  Retrieves the native type for {@code cls}
     *  
     *  @param cls       The class to get the arg type for
     *  @return          The internal representation for the arg
     *                   type for {@code cls}
     */
    private static int getArgType(Class<?> cls) {
        return Primitives.getNativeType(cls);
    }
}

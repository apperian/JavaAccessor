package com.apperian.javautil;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.apperian.javautil.Primitives.NativeType;

/** Provides methods for retrieving information about
 *  a Method object.
 * 
 * @author   James Seibel
 * @author   Kevin LaFlamme
 * 
 */
final class Methods {
    
    /**
     * Calls {@code method} on {@code obj}
     * <p>
     * This will invoke {@code method} using {@code obj} as <i>this</i>, passing {@code args} as the arguments.
     * {@code obj} should be a {{@link java.lang.Class} if {@code method} is static
     * 
     * @param obj             The object to invoke the method on
     * @param method          The Method object to invoke
     * @param args            An array of arguments to pass to the method
     * @return                Returns the return value of the invoked method
     * 
     * @throws UnsupportedTypeException
     */
    static Object invokeMethod(Object obj, Method method, Object[] args) 
            throws UnsupportedTypeException 
    {
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        String methodSignature = getSignature(method);
        int[] methodArgTypes = getArgTypes(method);
        Class<?> cls = method.getReturnType();
        
        switch(Primitives.getNativeType(cls)) {
        case NativeType.BOOLEAN:
            return AccessorNative.invokeBoolean(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.BYTE:
            return AccessorNative.invokeByte(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.CHAR:
            return AccessorNative.invokeChar(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.DOUBLE:
            return AccessorNative.invokeDouble(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.FLOAT:
            return AccessorNative.invokeFloat(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.INT:
            return AccessorNative.invokeInt(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.LONG:
            return AccessorNative.invokeLong(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.OBJECT:
            return AccessorNative.invokeObject(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.SHORT:
            return AccessorNative.invokeShort(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
        case NativeType.VOID:
            AccessorNative.invokeVoid(obj, method.getName(), isStatic, methodSignature, methodArgTypes, args);
            return null;
        default:
            throw new UnsupportedTypeException(method,cls);
        }
    }
    
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
            builder.append(Primitives.getRawName(paramClass));
        }
        
        builder.append(")");
        
        // add return type
        Class<?> returnType = method.getReturnType();
        builder.append(Primitives.getRawName(returnType));
        
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
            paramTypes[i] = Primitives.getNativeType(paramClasses[i]);
        }
        return paramTypes;
    }
}

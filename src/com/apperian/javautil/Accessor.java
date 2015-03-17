package com.apperian.javautil;

import com.apperian.javautil.Primitives.NativeType;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/** Provides an interface for invoking the protected and 
 *  private methods of an object.
 * 
 * @author   James Seibel
 * @author   Kevin LaFlamme
 * @version  0.1
 * 
 */
public final class Accessor {
    
    /**
     * Calls method methodName on obj
     * <p>
     * For instance methods, this will look up the class of {@code obj} and then search for a method matching
     * the passed in {@code methodName} and {@code parameterTypes}.
     * If {@code obj} is an instance of {@link java.lang.Class}, then this will assume the method is static  
     * and will search for the method on {@code obj} directly.
     * 
     * @param obj             The object to invoke the method on, this should be a Class object for static methods
     * @param methodName      The name of the method to invoke
     * @param args            An array of arguments to pass to the method
     * @param parameterTypes  An array of classes that represent the argument types
     * @return                Returns the return value of the invoked method
     * 
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws UnsupportedTypeException
     */
    public static Object invokeMethod(Object obj, String methodName, Object[] args, Class<?>... parameterTypes) 
            throws NoSuchMethodException, SecurityException, UnsupportedTypeException 
    {
        Class<?> cls = obj instanceof Class ? 
            (Class<?>)obj : 
            obj.getClass();
            
        Method method = cls.getMethod(methodName, parameterTypes);
        return invokeMethod(obj, method, args);
    }
    
    /**
     * Calls method methodName on obj
     * <p>
     * For instance methods, this will look up the class of {@code obj} and then loop through the methods
     * of the class and select the first method matching methodName. This is a convenience function
     * but is not performant and may return the wrong method if there is more than one defined with the same
     * name (different signatures).
     * If {@code obj} is an instance of {@link java.lang.Class}, then this will assume the method is static 
     * and will search for the method on {@code obj} directly.
     * 
     * @param obj             The object to invoke the method on
     * @param methodName      The name of the method to invoke
     * @param args            An array of arguments to pass to the method
     * @return                Returns the return value of the invoked method
     * 
     * @throws NoSuchMethodException
     * @throws UnsupportedTypeException
     */
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
            StringBuilder builder = new StringBuilder();
            builder.append(cls.getCanonicalName());
            builder.append(" has no method ");
            builder.append(methodName);
            throw new NoSuchMethodException(builder.toString());
        }
        return invokeMethod(obj, method, args);
    }
    
    /**
     * Calls method {@code method} on obj
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
    public static Object invokeMethod(Object obj, Method method, Object[] args) 
            throws UnsupportedTypeException 
    {
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        String methodSignature = Methods.getSignature(method);
        int[] methodArgTypes = Methods.getArgTypes(method);
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
}

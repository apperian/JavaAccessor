package com.apperian.javautil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.apperian.javautil.Primitives.NativeType;

/** Provides methods for retrieving information about
 *  a Field object.
 * 
 * @author   Kevin LaFlamme
 * 
 */
final class Fields {

    /**
     * Gets field {@code field} on obj
     * <p>
     * This will retrieve {@code field} using {@code obj} as <i>this</i>.
     * {@code obj} should be a {{@link java.lang.Class} if {@code field} is static
     * 
     * @param obj             The object to retrieve the field from
     * @param field           The Field object to retrieve
     * @return                Returns the return value of the field on obj
     * 
     * @throws UnsupportedTypeException
     */
    static Object getField(Object obj, Field field) throws UnsupportedTypeException {
        
        boolean isStatic = Modifier.isStatic(field.getModifiers());
        String fieldSignature = getSignature(field);
        Class<?> cls = field.getType();
        
        switch(Primitives.getNativeType(cls)) {
        case NativeType.BOOLEAN:
            return AccessorNative.getBooleanField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.BYTE:
            return AccessorNative.getByteField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.CHAR:
            return AccessorNative.getCharField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.DOUBLE:
            return AccessorNative.getDoubleField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.FLOAT:
            return AccessorNative.getFloatField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.INT:
            return AccessorNative.getIntField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.LONG:
            return AccessorNative.getLongField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.OBJECT:
            return AccessorNative.getObjectField(obj, field.getName(), isStatic, fieldSignature);
        case NativeType.SHORT:
            return AccessorNative.getShortField(obj, field.getName(), isStatic, fieldSignature);
        default:
            throw new UnsupportedTypeException(field,cls);
        }
    }
    
    /**
     * Sets field {@code field} on obj to {@code value}
     * <p>
     * This will set {@code field} to {@code value} using {@code obj} as <i>this</i>.
     * {@code obj} should be a {{@link java.lang.Class} if {@code field} is static
     * 
     * @param obj             The object to retrieve the field from
     * @param field           The Field object to retrieve
     * @param value           The value to set
     * 
     * @throws UnsupportedTypeException
     * @throws ClassCastException
     */
    static void setField(Object obj, Field field, Object value) 
            throws UnsupportedTypeException, ClassCastException 
    {    
        boolean isStatic = Modifier.isStatic(field.getModifiers());
        String fieldSignature = getSignature(field);
        Class<?> cls = field.getType();
        
        switch(Primitives.getNativeType(cls)) {
        case NativeType.BOOLEAN:
            AccessorNative.setBooleanField(obj, field.getName(), isStatic, fieldSignature, (boolean)value);
            break;
        case NativeType.BYTE:
            AccessorNative.setByteField(obj, field.getName(), isStatic, fieldSignature, (byte)value);
            break;
        case NativeType.CHAR:
            AccessorNative.setCharField(obj, field.getName(), isStatic, fieldSignature, (char)value);
            break;
        case NativeType.DOUBLE:
            AccessorNative.setDoubleField(obj, field.getName(), isStatic, fieldSignature, (double)value);
            break;
        case NativeType.FLOAT:
            AccessorNative.setFloatField(obj, field.getName(), isStatic, fieldSignature, (float)value);
            break;
        case NativeType.INT:
            AccessorNative.setIntField(obj, field.getName(), isStatic, fieldSignature, (int)value);
            break;
        case NativeType.LONG:
            AccessorNative.setLongField(obj, field.getName(), isStatic, fieldSignature, (long)value);
            break;
        case NativeType.OBJECT:
            AccessorNative.setObjectField(obj, field.getName(), isStatic, fieldSignature, (Object)value);
            break;
        case NativeType.SHORT:
            AccessorNative.setShortField(obj, field.getName(), isStatic, fieldSignature, (short)value);
            break;
        default:
            throw new UnsupportedTypeException(field,cls);
        }
    }
    
    /**
     * Gets the field signature for a particular Field
     * <p>
     * This method returns the internal method signature for a Method object.
     * This signature can be used to retrieve the jmethodID via JNI 
     * 
     * @param field       The Field object used to retrieve the signature
     * @return            A {@link java.lang.String} representing the method signature
     */
    static String getSignature(Field field) {
        
        return Primitives.getRawName(field.getType());
    }
}

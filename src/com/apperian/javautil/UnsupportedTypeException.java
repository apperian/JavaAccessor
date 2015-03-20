package com.apperian.javautil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UnsupportedTypeException extends Exception {
    
    private static final long serialVersionUID = 1L;
    private String mError;
    
    UnsupportedTypeException(Method method, Class<?> returnType) {
        StringBuilder builder = new StringBuilder();
        builder.append("Unsupported return type for method: ");
        builder.append(method.getName());
        builder.append(" => ");
        builder.append(returnType.getName());
    }
    
    UnsupportedTypeException(Field field, Class<?> type) {
        StringBuilder builder = new StringBuilder();
        builder.append("Unsupported type for field: ");
        builder.append(field.getName());
        builder.append(" => ");
        builder.append(type.getName());
    }
    
    public String toString() {
        return mError;
    }
}

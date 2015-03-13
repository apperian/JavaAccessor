package com.apperian.javautil.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.apperian.javautil.Accessor;

public class InvokeTest {

    @Test
    public void testInvoke() {
        assertNull(Accessor.invoke());
    }
    
    @Test(expected=NoSuchMethodException.class)
    public void testInvokeMethodNameOnly_negative() throws NoSuchMethodException {
        
        Integer i = new Integer(5);
        Object[] args = new Object[0];
        
        Accessor.invokeMethod(i, "not_a_function", args);
    }
    
    @Test(expected=NoSuchMethodException.class)
    public void testInvokeMethodNameWithParamTypes_negative() throws NoSuchMethodException {
        
        Integer i = new Integer(5);
        Object[] args = new Object[0];
        Class<?>[] argTypes = new Class<?>[0];
        
        Accessor.invokeMethod(i, "not_a_function", args, argTypes);
    }
}

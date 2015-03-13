package com.apperian.javautil.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.apperian.javautil.Accessor;

public class InvokeTest {
    
    public class Tester {
        public int add(int i, int j) {
            return i + j;
        }
    }
    
    @Test
    public void testInvokeInt() {
        
        Tester test = new Tester();
        Method addMethod = null;
        try {
            addMethod = Tester.class.getMethod("add", int.class, int.class);
            Object[] args = new Object[2];
            args[0] = 1;
            args[1] = 2;

            assertEquals(addMethod.invoke(test, args), Accessor.invokeMethod(test,addMethod,args));
        } catch (Exception e) {}

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

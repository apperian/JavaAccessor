package com.apperian.javautil.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.apperian.javautil.Accessor;

public class InvokeTest {
    
    class MyInt {
        
        public Integer getInteger() {
            return new Integer(1);
        }
        
        public int getInt() {
            return 1;
        }
    }
    
    @Test
    public void testInvokeObject() {
        MyInt i = new MyInt();
        assertEquals("MyInt.getInteger() should return 1", i.getInteger(), Accessor.invokeObject(i, "getInteger", "()Ljava/lang/Integer;", new Object[0]));
    }
    
    @Test
    public void testInvokeInt() {
        MyInt i = new MyInt();
        assertEquals("MyInt.getInt() should return 1", i.getInt(), Accessor.invokeInt(i, "getInt", "()I", new Object[0]));
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

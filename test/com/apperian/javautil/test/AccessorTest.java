package com.apperian.javautil.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.apperian.javautil.Accessor;
import com.apperian.javautil.UnsupportedTypeException;

public class AccessorTest {
    
    @Test
    public void invokeBoolean() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnBoolean(),Accessor.invokeMethod(t,"returnBoolean",new Object[0]));
    }
    
    @Test
    public void invokeByte() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnByte(),Accessor.invokeMethod(t,"returnByte",new Object[0]));
    }
    
    @Test
    public void invokeChar() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnChar(),Accessor.invokeMethod(t,"returnChar",new Object[0]));
    }
    
    @Test
    public void invokeDouble() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnDouble(),Accessor.invokeMethod(t,"returnDouble",new Object[0]));
    }
    
    @Test
    public void invokeFloat() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnFloat(),Accessor.invokeMethod(t,"returnFloat",new Object[0]));
    }
    
    @Test
    public void invokeInt() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnInt(),Accessor.invokeMethod(t,"returnInt",new Object[0]));
    }
    
    @Test
    public void invokeLong() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnLong(),Accessor.invokeMethod(t,"returnLong",new Object[0]));
    }
    
    @Test
    public void invokeObject() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnObject(),Accessor.invokeMethod(t,"returnObject",new Object[0]));
    }
    
    @Test
    public void invokeShort() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnShort(),Accessor.invokeMethod(t,"returnShort",new Object[0]));
    }
    
    @Test
    public void invokeVoid() throws NoSuchMethodException, UnsupportedTypeException {
        Target t1 = new Target();
        Target t2 = new Target();
        t1.returnVoid();
        Accessor.invokeMethod(t2,"returnVoid",new Object[0]);
        assertEquals(t1.mInt,t2.mInt);
    }
    
    @Test(expected=NoSuchMethodException.class)
    public void testInvokeMethodNameOnly_negative() throws NoSuchMethodException, UnsupportedTypeException {
        
        Integer i = new Integer(5);
        Object[] args = new Object[0];
        
        Accessor.invokeMethod(i, "not_a_function", args);
    }
    
    @Test(expected=NoSuchMethodException.class)
    public void testInvokeMethodNameWithParamTypes_negative() throws NoSuchMethodException, SecurityException, UnsupportedTypeException {
        
        Integer i = new Integer(5);
        Object[] args = new Object[0];
        Class<?>[] argTypes = new Class<?>[0];
        
        Accessor.invokeMethod(i, "not_a_function", args, argTypes);
    }
}

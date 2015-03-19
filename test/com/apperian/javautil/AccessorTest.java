package com.apperian.javautil;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.apperian.javautil.Accessor;
import com.apperian.javautil.UnsupportedTypeException;

public class AccessorTest {
    
    @Test
    public void invokeBooleanMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnBoolean(),Accessor.invokeMethod(t,"returnBoolean",new Object[0]));
    }
    
    @Test
    public void invokeByteMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnByte(),Accessor.invokeMethod(t,"returnByte",new Object[0]));
    }
    
    @Test
    public void invokeCharMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnChar(),Accessor.invokeMethod(t,"returnChar",new Object[0]));
    }
    @Test
    public void invokeDoubleMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnDouble(),Accessor.invokeMethod(t,"returnDouble",new Object[0]));
    }
    
    @Test
    public void invokeFloatMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnFloat(),Accessor.invokeMethod(t,"returnFloat",new Object[0]));
    }
    
    @Test
    public void invokeIntMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnInt(),Accessor.invokeMethod(t,"returnInt",new Object[0]));
    }
    
    @Test
    public void invokeLongMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnLong(),Accessor.invokeMethod(t,"returnLong",new Object[0]));
    }
    
    @Test
    public void invokeObjectMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnObject(),Accessor.invokeMethod(t,"returnObject",new Object[0]));
    }
    
    @Test
    public void invokeShortMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnShort(),Accessor.invokeMethod(t,"returnShort",new Object[0]));
    }
    
    @Test
    public void invokeVoidMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.invokeMethod(t,"returnVoid",new Object[0]);
        assertEquals(t.instanceInt,t.instanceIntExpected);
    }
    
    @Test
    public void invokeStaticBooleanMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticBoolean(),Accessor.invokeMethod(Target.class,"returnStaticBoolean",new Object[0]));
    }
    
    @Test
    public void invokeStaticByteMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticByte(),Accessor.invokeMethod(Target.class,"returnStaticByte",new Object[0]));
    }
    
    @Test
    public void invokeStaticCharMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticChar(),Accessor.invokeMethod(Target.class,"returnStaticChar",new Object[0]));
    }
    
    @Test
    public void invokeStaticDoubleMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticDouble(),Accessor.invokeMethod(Target.class,"returnStaticDouble",new Object[0]));
    }
    
    @Test
    public void invokeStaticFloatMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticFloat(),Accessor.invokeMethod(Target.class,"returnStaticFloat",new Object[0]));
    }
    
    @Test
    public void invokeStaticIntMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticInt(),Accessor.invokeMethod(Target.class,"returnStaticInt",new Object[0]));
    }
    
    @Test
    public void invokeStaticLongMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticLong(),Accessor.invokeMethod(Target.class,"returnStaticLong",new Object[0]));
    }
    
    @Test
    public void invokeStaticObjectMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticObject(),Accessor.invokeMethod(Target.class,"returnStaticObject",new Object[0]));
    }
    
    @Test
    public void invokeStaticShortMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticShort(),Accessor.invokeMethod(Target.class,"returnStaticShort",new Object[0]));
    }
    
    @Test
    public void invokeStaticVoidMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Accessor.invokeMethod(Target.class,"returnStaticVoid",new Object[0]);
        assertEquals(Target.staticIntExpected,Target.staticInt);
    }

    
    @Test(expected=NoSuchMethodException.class)
    public void testInvokeMethodNameOnly_negative() throws NoSuchMethodException, UnsupportedTypeException {
        Accessor.invokeMethod(new Object(), "not_a_function", new Object[0]);
    }
    
    @Test(expected=NoSuchMethodException.class)
    public void testInvokeMethodNameWithParamTypes_negative() throws NoSuchMethodException, SecurityException, UnsupportedTypeException {
        Accessor.invokeMethod(new Object(), "not_a_function", new Object[0], new Class<?>[0]);
    }
}

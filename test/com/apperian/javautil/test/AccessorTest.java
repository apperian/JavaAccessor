package com.apperian.javautil.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.apperian.javautil.Accessor;
import com.apperian.javautil.UnsupportedTypeException;

public class AccessorTest {
    
    @Test
    public void invokeMethod() throws NoSuchMethodException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.returnBoolean(),Accessor.invokeMethod(t,"returnBoolean",new Object[0]));
        assertEquals(t.returnByte(),Accessor.invokeMethod(t,"returnByte",new Object[0]));
        assertEquals(t.returnChar(),Accessor.invokeMethod(t,"returnChar",new Object[0]));
        assertEquals(t.returnDouble(),Accessor.invokeMethod(t,"returnDouble",new Object[0]));
        assertEquals(t.returnFloat(),Accessor.invokeMethod(t,"returnFloat",new Object[0]));
        assertEquals(t.returnInt(),Accessor.invokeMethod(t,"returnInt",new Object[0]));
        assertEquals(t.returnLong(),Accessor.invokeMethod(t,"returnLong",new Object[0]));
        assertEquals(t.returnObject(),Accessor.invokeMethod(t,"returnObject",new Object[0]));
        assertEquals(t.returnShort(),Accessor.invokeMethod(t,"returnShort",new Object[0]));
        
        Accessor.invokeMethod(t,"returnVoid",new Object[0]);
        assertEquals(t.instanceInt,t.instanceIntExpected);
    }
    
    @Test
    public void invokeStaticMethod() throws NoSuchMethodException, UnsupportedTypeException {
        assertEquals(Target.returnStaticBoolean(),Accessor.invokeMethod(Target.class,"returnStaticBoolean",new Object[0]));
        assertEquals(Target.returnStaticByte(),Accessor.invokeMethod(Target.class,"returnStaticByte",new Object[0]));
        assertEquals(Target.returnStaticChar(),Accessor.invokeMethod(Target.class,"returnStaticChar",new Object[0]));
        assertEquals(Target.returnStaticDouble(),Accessor.invokeMethod(Target.class,"returnStaticDouble",new Object[0]));
        assertEquals(Target.returnStaticFloat(),Accessor.invokeMethod(Target.class,"returnStaticFloat",new Object[0]));
        assertEquals(Target.returnStaticInt(),Accessor.invokeMethod(Target.class,"returnStaticInt",new Object[0]));
        assertEquals(Target.returnStaticLong(),Accessor.invokeMethod(Target.class,"returnStaticLong",new Object[0]));
        assertEquals(Target.returnStaticObject(),Accessor.invokeMethod(Target.class,"returnStaticObject",new Object[0]));
        assertEquals(Target.returnStaticShort(),Accessor.invokeMethod(Target.class,"returnStaticShort",new Object[0]));
        
        Target.returnStaticVoid();
        Accessor.invokeMethod(Target.class,"returnStaticVoid",new Object[0]);
        assertEquals(Target.staticInt,Target.staticIntExpected);
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

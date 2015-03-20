package com.apperian.javautil;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
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
    
    @Test
    public void getBooleanField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.booleanField,Accessor.getField(t,"booleanField"));
    }
    
    @Test
    public void getByteField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.byteField,Accessor.getField(t,"byteField"));
    }
    
    @Test
    public void getCharField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.charField,Accessor.getField(t,"charField"));
    }
    
    @Test
    public void getDoubleField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.doubleField,Accessor.getField(t,"doubleField"));
    }
    
    @Test
    public void getFloatField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.floatField,Accessor.getField(t,"floatField"));
    }
    
    @Test
    public void getIntField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.intField,Accessor.getField(t,"intField"));
    }
    
    @Test
    public void getLongField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.longField,Accessor.getField(t,"longField"));
    }
    
    @Test
    public void getObjectField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.objectField,Accessor.getField(t,"objectField"));
    }
    
    @Test
    public void getShortField() throws NoSuchFieldException, UnsupportedTypeException {
        Target t = new Target();
        assertEquals(t.shortField,Accessor.getField(t,"shortField"));
    }
    
    @Test
    public void getStaticBooleanField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticBooleanField,Accessor.getField(Target.class,"staticBooleanField"));
    }
    
    @Test
    public void getStaticByteField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticByteField,Accessor.getField(Target.class,"staticByteField"));
    }
    
    @Test
    public void getStaticCharField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticCharField,Accessor.getField(Target.class,"staticCharField"));
    }
    
    @Test
    public void getStaticDoubleField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticDoubleField,Accessor.getField(Target.class,"staticDoubleField"));
    }
    
    @Test
    public void getStaticFloatField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticFloatField,Accessor.getField(Target.class,"staticFloatField"));
    }
    
    @Test
    public void getStaticIntField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticIntField,Accessor.getField(Target.class,"staticIntField"));
    }
    
    @Test
    public void getStaticLongField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticLongField,Accessor.getField(Target.class,"staticLongField"));
    }
    
    @Test
    public void getStaticObjectField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticObjectField,Accessor.getField(Target.class,"staticObjectField"));
    }
    
    @Test
    public void getStaticShortField() throws NoSuchFieldException, UnsupportedTypeException {
        assertEquals(Target.staticShortField,Accessor.getField(Target.class,"staticShortField"));
    }
    
    @Test(expected=NoSuchFieldException.class)
    public void testGetFieldNameOnly_negative() throws NoSuchFieldException, UnsupportedTypeException {
        Accessor.getField(new Object(), "not_a_field");
    }
    
    @Test
    public void testSetBooleanField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "booleanField", (boolean)false);
        assertEquals((boolean)false,t.booleanField);
    }
    
    @Test
    public void testSetByteField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "byteField", (byte)0);
        assertEquals((byte)0,t.byteField);
    }
    
    @Test
    public void testSetCharField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "charField", (char)0);
        assertEquals((char)0,t.charField);
    }
    
    @Test
    public void testSetDoubleField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "doubleField", (double)0);
        assertEquals((double)0,t.doubleField, 0);
    }
    
    @Test
    public void testSetFloatField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "floatField", (float)0.0);
        assertEquals((float)0.0,t.floatField, 0);
    }
    
    @Test
    public void testSetIntField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "intField", (int)0);
        assertEquals((int)0,t.intField);
    }
    
    @Test
    public void testSetLongField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "longField", (long)0L);
        assertEquals((long)0L,t.longField);
    }
    
    @Test
    public void testSetObjectField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Target.Inner i = new Target.Inner();
        Accessor.setField(t, "objectField", i);
        assertEquals(i,t.objectField);
    }
    
    @Test
    public void testSetShortField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target t = new Target();
        Accessor.setField(t, "shortField", (short)0);
        assertEquals((short)0,t.shortField);
    }
    
    @Test
    public void testSetStaticBooleanField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticBooleanField", (boolean)false);
        assertEquals((boolean)false,Target.staticBooleanField);
    }
    
    @Test
    public void testSetStaticByteField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticByteField", (byte)0);
        assertEquals((byte)0,Target.staticByteField);
    }
    
    @Test
    public void testSetStaticCharField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticCharField", (char)0);
        assertEquals((char)0,Target.staticCharField);
    }
    
    @Test
    public void testSetStaticDoubleField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticDoubleField", (double)0);
        assertEquals((double)0,Target.staticDoubleField, 0);
    }
    
    @Test
    public void testSetStaticFloatField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticFloatField", (float)0.0);
        assertEquals((float)0.0,Target.staticFloatField, 0);
    }
    
    @Test
    public void testSetStaticIntField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticIntField", (int)0);
        assertEquals((int)0,Target.staticIntField);
    }
    
    @Test
    public void testSetStaticLongField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticLongField", (long)0L);
        assertEquals((long)0L,Target.staticLongField);
    }
    
    @Test
    public void testSetStaticObjectField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Target.Inner i = new Target.Inner();
        Accessor.setField(Target.class, "staticObjectField", i);
        assertEquals(i,Target.staticObjectField);
    }
    
    @Test
    public void testSetStaticShortField() throws NoSuchFieldException, ClassCastException, UnsupportedTypeException {
        Accessor.setField(Target.class, "staticShortField", (short)0);
        assertEquals((short)0,Target.staticShortField);
    }
}

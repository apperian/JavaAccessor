package com.apperian.javautil;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldsTest {

    @Test
    public void testBooleanFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("booleanField");
        assertEquals("Z",Fields.getSignature(field));
    }
    
    @Test
    public void testByteFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("byteField");
        assertEquals("B",Fields.getSignature(field));
    }
    
    @Test
    public void testCharFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("charField");
        assertEquals("C",Fields.getSignature(field));
    }
    
    @Test
    public void testDoubleFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("doubleField");
        assertEquals("D",Fields.getSignature(field));
    }
    
    @Test
    public void testFloatFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("floatField");
        assertEquals("F",Fields.getSignature(field));
    }
    
    @Test
    public void testIntFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("intField");
        assertEquals("I",Fields.getSignature(field));
    }
    
    @Test
    public void testLongFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("longField");
        assertEquals("J",Fields.getSignature(field));
    }
    
    @Test
    public void testObjectFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("objectField");
        assertEquals("Lcom/apperian/javautil/Target$Inner;",Fields.getSignature(field));
    }
    
    @Test
    public void testShortFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("shortField");
        assertEquals("S",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticBooleanFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticBooleanField");
        assertEquals("Z",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticByteFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticByteField");
        assertEquals("B",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticCharFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticCharField");
        assertEquals("C",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticDoubleFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticDoubleField");
        assertEquals("D",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticFloatFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticFloatField");
        assertEquals("F",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticIntFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticIntField");
        assertEquals("I",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticLongFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticLongField");
        assertEquals("J",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticObjectFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticObjectField");
        assertEquals("Lcom/apperian/javautil/Target$Inner;",Fields.getSignature(field));
    }
    
    @Test
    public void testStaticShortFieldSig() throws NoSuchFieldException {
        Field field; 
        field = Target.class.getField("staticShortField");
        assertEquals("S",Fields.getSignature(field));
    }

}

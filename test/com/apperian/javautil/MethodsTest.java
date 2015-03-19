package com.apperian.javautil;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.apperian.javautil.Methods;
import com.apperian.javautil.Primitives.NativeType;

public class MethodsTest {
    
    @Test
    public void testBooleanReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnBoolean");
        assertEquals("()Z",Methods.getSignature(method));
    }
    
    @Test
    public void testByteReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnByte");
        assertEquals("()B",Methods.getSignature(method));
    }
    
    @Test
    public void testCharReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnChar");
        assertEquals("()C",Methods.getSignature(method));
    }
    
    @Test
    public void testDoubleReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnDouble");
        assertEquals("()D",Methods.getSignature(method));
    }
    
    @Test
    public void testFloatReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnFloat");
        assertEquals("()F",Methods.getSignature(method));
    }
    
    @Test
    public void testIntReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnInt");
        assertEquals("()I",Methods.getSignature(method));
    }
    
    @Test
    public void testLongReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnLong");
        assertEquals("()J",Methods.getSignature(method));
    }
    
    @Test
    public void testObjectReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnObject");
        assertEquals("()Lcom/apperian/javautil/Target;",Methods.getSignature(method));
    }
    
    @Test
    public void testPrimitiveArrayReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnPrimitiveArray");
        assertEquals("()[I",Methods.getSignature(method));
    }
    
    @Test
    public void testObjectArrayReturnSig() throws NoSuchMethodException, SecurityException {
        Method method;     
        method = Target.class.getMethod("returnObjectArray");
        assertEquals("()[Lcom/apperian/javautil/Target;",Methods.getSignature(method));
    }
    
    @Test
    public void testShortReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnShort");
        assertEquals("()S",Methods.getSignature(method));
    }
    
    @Test
    public void testVoidReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnVoid");
        assertEquals("()V",Methods.getSignature(method));
    }
    
    @Test
    public void testBooleanArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("booleanVoid",boolean.class);
        assertEquals("(Z)V",Methods.getSignature(method));
    }
    
    @Test
    public void testByteArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("byteVoid",byte.class);
        assertEquals("(B)V",Methods.getSignature(method));
    }
    
    @Test
    public void testCharArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("charVoid",char.class);
        assertEquals("(C)V",Methods.getSignature(method));
    }
    
    @Test
    public void testDoubleArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("doubleVoid",double.class);
        assertEquals("(D)V",Methods.getSignature(method));
    }
    
    @Test
    public void testFloatArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("floatVoid",float.class);
        assertEquals("(F)V",Methods.getSignature(method));
    }
    
    @Test
    public void testIntArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("intVoid",int.class);
        assertEquals("(I)V",Methods.getSignature(method));
    }
    
    @Test
    public void testLongArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("longVoid",long.class);
        assertEquals("(J)V",Methods.getSignature(method));
    }
    
    @Test
    public void testObjectArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("objectVoid",Target.class);
        assertEquals("(Lcom/apperian/javautil/Target;)V",Methods.getSignature(method));
    }
    
    @Test
    public void testPrimitiveArrayArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("primitiveArrayVoid",int[].class);
        assertEquals("([I)V",Methods.getSignature(method));
    }
    
    @Test
    public void testObjectArrayArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("objectArrayVoid",Target[].class);
        assertEquals("([Lcom/apperian/javautil/Target;)V",Methods.getSignature(method));
    }
    
    @Test
    public void testShortArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("shortVoid",short.class);
        assertEquals("(S)V",Methods.getSignature(method));
    }
    
    @Test
    public void testVoidArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("voidVoid");
        assertEquals("()V",Methods.getSignature(method));
    }
    
    @Test
    public void testAllArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("allArgsVoid", boolean.class, byte.class, char.class, double.class, float.class, int.class,
                long.class, Target.class, short.class, int[].class, Target[].class);
        assertEquals("(ZBCDFIJLcom/apperian/javautil/Target;S[I[Lcom/apperian/javautil/Target;)V",Methods.getSignature(method));
    }
    
    @Test
    public void testBooleanArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("booleanVoid",boolean.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.BOOLEAN,argTypes[0]);
    }
    
    @Test
    public void testByteArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("byteVoid",byte.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.BYTE,argTypes[0]);
    }
    
    @Test
    public void testCharArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("charVoid",char.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.CHAR,argTypes[0]);
    }
    
    @Test
    public void testDoubleArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("doubleVoid",double.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.DOUBLE,argTypes[0]);
    }
    
    @Test
    public void testFloatArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("floatVoid",float.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.FLOAT,argTypes[0]);
    }
    
    @Test
    public void testIntArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("intVoid",int.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.INT,argTypes[0]);
    }
    
    @Test
    public void testLongArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("longVoid",long.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.LONG,argTypes[0]);
    }
    
    @Test
    public void testObjectArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("objectVoid",Target.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.OBJECT,argTypes[0]);
    }
    
    @Test
    public void testPrimitiveArrayArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("primitiveArrayVoid",int[].class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.OBJECT,argTypes[0]);
    }
    
    @Test
    public void testObjectArrayArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("objectArrayVoid",Target[].class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.OBJECT,argTypes[0]);
    }
    
    @Test
    public void testShortArgumentType() throws NoSuchMethodException, SecurityException {
        Method method;
        int[] argTypes;
        method = Target.class.getMethod("shortVoid",short.class);
        argTypes = Methods.getArgTypes(method);
        assertEquals(NativeType.SHORT,argTypes[0]);
    }
    
    @Test
    public void testAllArgumentsType() throws NoSuchMethodException, SecurityException {
        Method method;
        method = Target.class.getMethod("allArgsVoid", boolean.class, byte.class, char.class, double.class, float.class, int.class,
                long.class, Target.class, short.class, int[].class, Target[].class);

        int[] argTypes = Methods.getArgTypes(method);
        
        assertEquals(NativeType.BOOLEAN, argTypes[0]);
        assertEquals(NativeType.BYTE, argTypes[1]);
        assertEquals(NativeType.CHAR, argTypes[2]);
        assertEquals(NativeType.DOUBLE, argTypes[3]);
        assertEquals(NativeType.FLOAT, argTypes[4]);
        assertEquals(NativeType.INT, argTypes[5]);
        assertEquals(NativeType.LONG, argTypes[6]);
        assertEquals(NativeType.OBJECT, argTypes[7]);
        assertEquals(NativeType.SHORT, argTypes[8]);
        assertEquals(NativeType.OBJECT, argTypes[9]);
        assertEquals(NativeType.OBJECT, argTypes[10]);
    }
}

package com.apperian.javautil;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;

import com.apperian.javautil.Methods;
import com.apperian.javautil.Primitives.NativeType;

public class MethodsTest {
    
    @Test
    public void testReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnBoolean");
        assertEquals("()Z",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnByte");
        assertEquals("()B",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnChar");
        assertEquals("()C",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnDouble");
        assertEquals("()D",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnFloat");
        assertEquals("()F",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnInt");
        assertEquals("()I",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnLong");
        assertEquals("()J",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnObject");
        assertEquals("()Lcom/apperian/javautil/Target;",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnPrimitiveArray");
        assertEquals("()[I",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnObjectArray");
        assertEquals("()[Lcom/apperian/javautil/Target;",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnShort");
        assertEquals("()S",Methods.getSignature(method));
        
        method = Target.class.getMethod("returnVoid");
        assertEquals("()V",Methods.getSignature(method));
    }
    
    @Test
    public void testArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("booleanVoid",boolean.class);
        assertEquals("(Z)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("byteVoid",byte.class);
        assertEquals("(B)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("charVoid",char.class);
        assertEquals("(C)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("doubleVoid",double.class);
        assertEquals("(D)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("floatVoid",float.class);
        assertEquals("(F)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("intVoid",int.class);
        assertEquals("(I)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("longVoid",long.class);
        assertEquals("(J)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("objectVoid",Target.class);
        assertEquals("(Lcom/apperian/javautil/Target;)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("primitiveArrayVoid",int[].class);
        assertEquals("([I)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("objectArrayVoid",Target[].class);
        assertEquals("([Lcom/apperian/javautil/Target;)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("shortVoid",short.class);
        assertEquals("(S)V",Methods.getSignature(method));
        
        method = Target.class.getMethod("voidVoid");
        assertEquals("()V",Methods.getSignature(method));
        
        method = Target.class.getMethod("allArgsVoid", boolean.class, byte.class, char.class, double.class, float.class, int.class,
                long.class, Target.class, short.class, int[].class, Target[].class);
        assertEquals("(ZBCDFIJLcom/apperian/javautil/Target;S[I[Lcom/apperian/javautil/Target;)V",Methods.getSignature(method));
    }
    
    @Test
    public void testArgumentTypes() throws NoSuchMethodException, SecurityException {
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

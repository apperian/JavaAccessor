package com.apperian.javautil.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;

import com.apperian.javautil.Methods;
import com.apperian.javautil.Primitives;

public class MethodsTest {
    
    @Test
    public void testReturnSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("returnBoolean");
        assertEquals("()Z",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnByte");
        assertEquals("()B",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnChar");
        assertEquals("()C",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnDouble");
        assertEquals("()D",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnFloat");
        assertEquals("()F",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnInt");
        assertEquals("()I",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnLong");
        assertEquals("()J",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnObject");
        assertEquals("()Lcom/apperian/javautil/test/Target;",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnPrimitiveArray");
        assertEquals("()[I",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnObjectArray");
        assertEquals("()[Lcom/apperian/javautil/test/Target;",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnShort");
        assertEquals("()S",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("returnVoid");
        assertEquals("()V",Methods.getMethodSignature(method));
    }
    
    @Test
    public void testArgumentSig() throws NoSuchMethodException, SecurityException {
        Method method; 
        method = Target.class.getMethod("booleanVoid",boolean.class);
        assertEquals("(Z)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("byteVoid",byte.class);
        assertEquals("(B)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("charVoid",char.class);
        assertEquals("(C)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("doubleVoid",double.class);
        assertEquals("(D)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("floatVoid",float.class);
        assertEquals("(F)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("intVoid",int.class);
        assertEquals("(I)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("longVoid",long.class);
        assertEquals("(J)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("objectVoid",Target.class);
        assertEquals("(Lcom/apperian/javautil/test/Target;)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("primitiveArrayVoid",int[].class);
        assertEquals("([I)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("objectArrayVoid",Target[].class);
        assertEquals("([Lcom/apperian/javautil/test/Target;)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("shortVoid",short.class);
        assertEquals("(S)V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("voidVoid");
        assertEquals("()V",Methods.getMethodSignature(method));
        
        method = Target.class.getMethod("allArgsVoid",
                boolean.class,
                byte.class,
                char.class,
                double.class,
                float.class,
                int.class,
                long.class,
                Target.class,
                short.class,
                int[].class,
                Target[].class);
        assertEquals("(ZBCDFIJLcom/apperian/javautil/test/Target;S[I[Lcom/apperian/javautil/test/Target;)V",Methods.getMethodSignature(method));
    }
    
    @Test
    public void testArgumentTypes() throws NoSuchMethodException, SecurityException {
        Method method;
        method = Target.class.getMethod("allArgsVoid",
                boolean.class,
                byte.class,
                char.class,
                double.class,
                float.class,
                int.class,
                long.class,
                Target.class,
                short.class,
                int[].class,
                Target[].class);

        int[] argTypes = Methods.getArgTypes(method);
        
        assertEquals(Primitives.TypeOffset.OBJECT, argTypes[0]);
        assertEquals(Primitives.TypeOffset.BOOLEAN, argTypes[1]);
        assertEquals(Primitives.TypeOffset.OBJECT, argTypes[2]);
        assertEquals(Primitives.TypeOffset.INT, argTypes[3]);
        assertEquals(Primitives.TypeOffset.OBJECT, argTypes[4]);
        assertEquals(Primitives.TypeOffset.FLOAT, argTypes[5]);
        assertEquals(Primitives.TypeOffset.OBJECT, argTypes[6]);
        assertEquals(Primitives.TypeOffset.DOUBLE, argTypes[7]);
        assertEquals(Primitives.TypeOffset.OBJECT, argTypes[8]);
        assertEquals(Primitives.TypeOffset.LONG, argTypes[9]);
    }
}

package com.apperian.javautil.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;

import com.apperian.javautil.MethodTools;

public class MethodToolsTest {
    
    // Classes used for various tests in MethodTools
    //
    // Function name formatting:
    //     ClassName_ArgType1_ArgeType2_ret_ReturnType
    //
    // arrays get the type prefixed with ARR, multidimensional with ARRARR, etc.
    //
    // 
    // example: Class Foo function takes int[], double and
    //          returns Integer: Foo_ARRint_double_ret_Integer
    
    class Foo {
        public Foo(){}
        
        public String Foo_Integer_int_ret_String(Integer a, int b) {
            return "Worked!";
        }
        
    }
    
    class Bar {
        public Bar(){}
        
        public Foo Bar_double_ret_Foo(double a) {
            return new Foo();
        }
        
        public Zoo Bar_ret_Zoo() {
            return new Zoo();
        }
        
        public boolean Bar_Boolean_boolean_Integer_int_Float_float_Double_double_Long_long_ret_boolean(Boolean a, boolean b, Integer c, int d, Float e, float f, Double g, double h, Long i, long j) {
            return true;
        }
        
        public void Bar_ARRint_ret_void(int[] a) {
            return;
        }
        
        public void Bar_ARRARRint_ret_void(int[][] a) {
            return;
        }
        
        public void Bar_ARRInteger_ret_void(Integer[] a) {
            return;
        }
        
        public Foo[] Bar_ARRARRFoo_ret_ARRFoo(Foo[][] a) {
            return new Foo[1];
        }
    }
    
    private class Zoo {
        Zoo() {}
        
        public char Zoo_int_Boolean_ret_char(int a, Boolean b) {
            return 'a';
        }
    }

    @Test
    public void testRawSig() {
        
        
        HashMap<String,String> expectedFunctionResults = new HashMap<String,String>();
        expectedFunctionResults.put("Foo_Integer_int_ret_String", "(Ljava/lang/Integer;I)Ljava/lang/String;");
        expectedFunctionResults.put("Bar_double_ret_Foo", "(D)Lcom/apperian/javautil/test/MethodToolsTest$Foo;");
        expectedFunctionResults.put("Bar_ARRint_ret_void", "([I)V");
        expectedFunctionResults.put("Bar_ARRARRint_ret_void", "([[I)V");
        expectedFunctionResults.put("Bar_ARRInteger_ret_void", "([Ljava.lang.Integer;)V");
        expectedFunctionResults.put("Bar_ARRARRFoo_ret_ARRFoo", "([[Lcom.apperian.javautil.test.MethodToolsTest$Foo;)[Lcom.apperian.javautil.test.MethodToolsTest$Foo;");
        expectedFunctionResults.put("Bar_Boolean_boolean_Integer_int_Float_float_Double_double_Long_long_ret_boolean", "(Ljava/lang/Boolean;ZLjava/lang/Integer;ILjava/lang/Float;FLjava/lang/Double;DLjava/lang/Long;J)Z");
        expectedFunctionResults.put("Zoo_int_Boolean_ret_char", "(ILjava/lang/Boolean;)C");
        
        
        // Iterate through each method on the object and ensure that the generated method signature matches what is expected
        Method[] fooMethods = Foo.class.getMethods();
        
        for (Method method : fooMethods) {
            
            //System.out.println(method.getName() + ": " + MethodTools.getRawMethodSignature(method));
            
            if (expectedFunctionResults.containsKey(method.getName())) {
                assertTrue(expectedFunctionResults.get(method.getName()).equals(MethodTools.getRawMethodSignature(method)));
            }
        }
        
        Method[] barMethods = Bar.class.getMethods();
        
        for (Method method : barMethods) {
            
            //System.out.println(method.getName() + ": " + MethodTools.getRawMethodSignature(method));
            
            if (expectedFunctionResults.containsKey(method.getName())) {
                assertTrue(expectedFunctionResults.get(method.getName()).equals(MethodTools.getRawMethodSignature(method)));
            }
        }
        
        Method[] zooMethods = Zoo.class.getMethods();
        
        for (Method method : zooMethods) {
            
            //System.out.println(method.getName() + ": " + MethodTools.getRawMethodSignature(method));
            
            if (expectedFunctionResults.containsKey(method.getName())) {
                assertTrue(expectedFunctionResults.get(method.getName()).equals(MethodTools.getRawMethodSignature(method)));
            }
        }
        
    }

}

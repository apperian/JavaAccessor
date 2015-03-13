package com.apperian.javautil.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.apperian.javautil.Accessor;

public class InvokeTest {

    @Test
    public void testInvoke() {
        assertNull(Accessor.invoke());
    }
}

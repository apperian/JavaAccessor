package com.apperian.javautil;

public class Target {
    
    public int instanceInt                = 0;
    public int instanceIntExpected        = 1;
    public static int staticInt           = 0;
    public static int staticIntExpected   = 1;
    
    /*
     * return type functions
     */
    public boolean  returnBoolean() { return true;           }
    public byte     returnByte()    { return (byte)1;        }
    public char     returnChar()    { return 'A';            }
    public double   returnDouble()  { return 1.2e2;          }
    public float    returnFloat()   { return 1.2f;           }
    public int      returnInt()     { return 1;              }
    public long     returnLong()    { return 12l;            }
    public Target   returnObject()  { return this;           }
    public short    returnShort()   { return (short)1;       }
    public void     returnVoid()    { instanceInt=instanceIntExpected; return; }
    // Special cases for objects
    public int[]    returnPrimitiveArray() { return new int[] {0,1}; }
    public Target[] returnObjectArray()    { return new Target[] {this,this}; }
    
    /*
     * Static
     * return type functions
     */
    public static boolean  returnStaticBoolean() { return true;           }
    public static byte     returnStaticByte()    { return (byte)1;        }
    public static char     returnStaticChar()    { return 'A';            }
    public static double   returnStaticDouble()  { return 1.2e2;          }
    public static float    returnStaticFloat()   { return 1.2f;           }
    public static int      returnStaticInt()     { return 1;              }
    public static long     returnStaticLong()    { return 12l;            }
    public static Target   returnStaticObject()  { return new Target();   }
    public static short    returnStaticShort()   { return (short)1;       }
    public static void     returnStaticVoid()    { staticInt=staticIntExpected; return;   }
    // Special cases for objects
    public static int[]    returnStaticPrimitiveArray() { return new int[] {0,1}; }
    public static Target[] returnStaticObjectArray()    { return new Target[] {new Target(), new Target()}; }
    
    /*
     * Argument type functions
     */
    public void    booleanVoid(boolean v) {}
    public void    byteVoid(byte v)       {}
    public void    charVoid(char v)       {}
    public void    doubleVoid(double v)   {}
    public void    floatVoid(float v)     {}
    public void    intVoid(int v)         {}
    public void    longVoid(long v)       {}
    public void    objectVoid(Target v)   {}
    public void    shortVoid(short v)     {}
    public void    voidVoid()             {}
    
    public void    primitiveArrayVoid(int[] v) {};
    public void    objectArrayVoid(Target[] v) {};
    
    public void    allArgsVoid(boolean z, byte b, char c, double d, float f, int i,
            long j, Target o, short s, int[] ia, Target[] ta) {};
            
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Target && ((Target)obj).instanceInt == instanceInt;
    }
}
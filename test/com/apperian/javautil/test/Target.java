package com.apperian.javautil.test;

public class Target {
    
    public int mInt = 0;
    
    /*
     * return type functions
     */
    public boolean  returnBoolean() { return true;         }
    public byte     returnByte()    { return (byte)1;      }
    public char     returnChar()    { return 'A';          }
    public double   returnDouble()  { return 1.2e2;        }
    public float    returnFloat()   { return 1.2f;         }
    public int      returnInt()     { return 1;            }
    public long     returnLong()    { return 12l;          }
    public Target   returnObject()  { return this;         }
    public short    returnShort()   { return (short)1;     }
    public void     returnVoid()    { mInt=1; return;      }
    // Special cases for objects
    public int[]    returnPrimitiveArray() { return new int[] {0,1}; }
    public Target[] returnObjectArray()    { return new Target[] {this,this}; }
    
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
    
    public void    allArgsVoid(
            boolean z, 
            byte b,
            char c,
            double d,
            float f,
            int i,
            long j,
            Target o,
            short s,
            int[] ia,
            Target[] ta
            ) {};
}
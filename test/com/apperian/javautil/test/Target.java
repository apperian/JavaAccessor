package com.apperian.javautil.test;

public class Target {
    
    public int mInt = 0;
    
    /*
     * return type functions
     */
    public boolean returnBoolean() { return true;         }
    public byte    returnByte()    { return (byte)1;      }
    public char    returnChar()    { return 'A';          }
    public double  returnDouble()  { return 1.2e2;        }
    public float   returnFloat()   { return 1.2f;         }
    public int     returnInt()     { return 1;            }
    public long    returnLong()    { return 12l;          }
    public Object  returnObject()  { return this;         }
    public short   returnShort()   { return (short)1;     }
    public void    returnVoid()    { mInt=1; return;      }
    

}
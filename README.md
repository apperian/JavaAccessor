# JavaAccessor
Library to easily access all private, public, and protected methods and fields on a Java (or Android) class.
Check out the [docs](http://apperian.github.io/JavaAccessor/).

# Building

To build the jar file and native shared library run ```ant build```. To build for Android, run ```ant build-android``` (you must have ```ndk-build``` in your PATH). The binaries can be found in the libs directory.

# Using

Examples assume the following class is defined:
```java
class MyObject {
    private int        intField = 5;
    private static int staticIntField = 10;
    
    private String toIntString() {
        return Integer.toString(intField);
    }
}
```

An example of calling a method on a Java class:
```java
MyObject obj = new MyObject();
String str = (String)Accessor.invokeMethod(obj, "toIntString", new Object[]());
System.out.println(str);   ==> '5'
```

You can call a static method by passing the class as the 'this' object:
```java
boolean b = (boolean)Accessor.invokeMethod(Boolean.class, "parseBoolean", new Object[] {"true"});
System.out.println(b);   ==> 'true'
```

To retrieve the value of a field:
```java
MyObject obj = new MyObject();
int i = (int)Accessor.getField(obj, "intField");
System.out.println(i);   ==> '5'
```

And to retrieve the value of a static field:
```java
int i = (int)Accessor.getField(MyObject.class, "staticIntField");
System.out.println(i);   ==> '10'
```

#License

MIT License
```text
Copyright (c) 2015 Apperian, Inc.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

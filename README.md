# JavaAccessor
Library to easily access all private and public methods and fields on a Java class.

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
String str = (String)Accessor.invokeMethod(obj, "toIntString", new Object[] {obj});
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


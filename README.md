# Apache Thrift
**Apache Thrift** was originally developed by the Facebook development team and is currently maintained by Apache. Mainly focuses on the communication layer between components of your system.

Thrift uses a special Interface Description Language (IDL) to define data types and service interfaces which are stored as ***.thrift*** files and used later as input by the compiler for generating the source code of client and server software that communicate over different programming languages.

Usage via maven:
```
<dependency>
    <groupId>org.apache.thrift</groupId>
    <artifactId>libthrift</artifactId>
    <version>0.10.0</version>
</dependency>
```
  - **Interface Description Language** is a specification language used to describe a software component's application programming interface (API). IDLs describe an interface in a language-independent way, enabling communication between software components that do not share one language.
  - **Base Types**
    - bool – a boolean value (true or false)
    - byte – an 8-bit signed integer
    - i16 – a 16-bit signed integer
    - i32 – a 32-bit signed integer
    - i64 – a 64-bit signed integer
    - double – a 64-bit floating point number
    - string – a text string encoded using UTF-8 encoding
  - **Special Types** 
    - binary – a sequence of unencoded bytes
    - optional – a Java 8’s Optional type
  - **Structs** are the equivalent of classes in OOP languages but without inheritance. A struct has a set of strongly typed fields, each with a unique name as an identifier. Fields may have various annotations (numeric field IDs, optional default values, etc.).
  - **Thrift containers** are strongly typed containers:
    - List – an ordered list of elements
    - set – an unordered set of unique elements
    - map<type1,type2> – a map of strictly unique keys to values
    - Container elements may be of any valid Thrift type.
  - **Exceptions** are functionally equivalent to structs, except that they inherit from the native exceptions.
  - **Services** are actually communication interfaces defined using Thrift types. They consist of a set of named functions, each with a list of parameters and a return type.

Commandline: 
``` 
thrift --gen <language> <Thrift filename> 
```
<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Apache_Thrift_architecture.png/273px-Apache_Thrift_architecture.png"/></p>

# Data Serialize

**Protobuf** 

   - Is a language-neutral, platform-neutral, extensible way of serializing structured data for use in communications protocols, data storage, and more.
   
   - Is a flexible, efficient, automated mechanism for serializing structured data – think XML, but smaller, faster, and simpler.
   
   - Protocol buffer contains a few nods to defining RPC protocols but does not include an official implementation (they do have one internally).
   
   - Define message structures in .proto files.
   - Generate codes via commandline:
    
   ```
   protoc --java_out=java sample.proto 
   ```

| Protobuf| Thrift|
|---|---|
| Manage cross-platform object serialization/deserialization processes| Mainly focuses on the communication layer between components of your system|

***Why should use Protobuf instead of XML or Json***

- ***XML*** is notoriously space intensive, and encoding/decoding it can impose a huge performance penalty on applications. Also, navigating an XML DOM tree is considerably more complicated than navigating simple fields in a class normally would be.

- ***Json*** is suitable when server side application is written in JavaScript, data from the service is directly consumed by a web browser.

<hr/>

**MessagePack** 

   - ***MessagePack*** is an efficient binary serialization format. It lets you exchange data among multiple languages like JSON. But it's faster and smaller. Small integers are encoded into a single byte, and typical short strings require only one extra byte in addition to the strings themselves.
   
   - ***MessagePack*** has two concepts: type system and formats.

   - Serialization is conversion from application objects into MessagePack formats via MessagePack type system.

   - Deserialization is conversion from MessagePack formats into application objects via MessagePack type system.
   
   ```
      Serialization:
       Application objects
       -->  MessagePack type system
       -->  MessagePack formats (byte array)

      Deserialization:
       MessagePack formats (byte array)
       -->  MessagePack type system
       -->  Application objects
   ```
<hr/>

**Kryo** 

   - ***Kryo*** is a fast and efficient binary object graph serialization framework for Java. The goals of the project are high speed, low size, and an easy to use API. The project is useful any time objects need to be persisted, whether to a file, database, or over the network.
   - ***Kryo*** is not multi-language and is specifically targeted at high-performance Java serialization and TCP/UDP connections.

   - ***Kryo*** can also perform automatic deep and shallow copying/cloning. This is direct copying from object to object, not object to bytes to object.
<hr/>

**Cap'n Proto**

   - ***Cap'n Proto*** is an insanely fast data interchange format and capability-based RPC system. Think JSON, except binary. Or think Protocol Buffers, except faster. In fact, in benchmarks, Cap’n Proto is INFINITY TIMES faster than Protocol Buffers.
   - ***Advantages***
      - ***Incremental reads:*** It is easy to start processing a Cap’n Proto message before you have received all of it since outer objects appear entirely before inner objects (as opposed to most encodings, where outer objects encompass inner objects).
      - ***Random access:*** You can read just one field of a message without parsing the whole thing.
   mmap: Read a large Cap’n Proto file by memory-mapping it. The OS won’t even read in the parts that you don’t access.
      - ***Inter-language communication:*** Calling C++ code from, say, Java or Python tends to be painful or slow. With Cap’n Proto, the two languages can easily operate on the same in-memory data structure.
      - ***Inter-process communication:*** Multiple processes running on the same machine can share a Cap’n Proto message via shared memory. No need to pipe data through the kernel. Calling another process can be just as fast and easy as calling another thread.
      - ***Arena allocation:*** Manipulating Protobuf objects tends to be bogged down by memory allocation, unless you are very careful about object reuse. Cap’n Proto objects are always allocated in an “arena” or “region” style, which is faster and promotes cache locality.
      - ***Tiny generated code:*** Protobuf generates dedicated parsing and serialization code for every message type, and this code tends to be enormous. Cap’n Proto generated code is smaller by an order of magnitude or more. In fact, usually it’s no more than some inline accessor methods!
      - ***Tiny runtime library:*** Due to the simplicity of the Cap’n Proto format, the runtime library can be much smaller.
      - ***Time-traveling RPC:*** Cap’n Proto features an RPC system that implements time travel such that call results are returned to the client before the request even arrives at the server!
<br/>
      <p align="center">
  <img src="https://capnproto.org/images/time-travel.png" width="50%" height="50%"/></p>
<hr/>

**Apache Avro**

   ***Apache Avro*** is a newer project designed to accomplish many of the same goals of Protobuf or Thrift but without the static compilation step and greater interop with dynamic languages. Avro is being driven largely by Hadoop, afaict. Messages are defined in JSON (truly more painful than Protobuf or Thrift). Language bindings exist for C, C++, Java, Python, Ruby, and PHP with RPC available in all of those but PHP. Code gen is available if you want to generate code from your messages but your data can be built with generic APIs.

<hr/>

# RPC (Remote Call Procedure)
<p align="center">
  <img src="https://cdncontribute.geeksforgeeks.org/wp-content/uploads/operating-system-remote-procedure-call-1.png" width="50%" height="50%"/></p>

<p align="center">
  <img src="https://cdncontribute.geeksforgeeks.org/wp-content/uploads/operating-system-remote-call-procedure-working.png" width="50%" height="50%"/></p>

**Apache Thrift** forms a remote procedure call (RPC) framework (Thrift also includes the RPC transport layer), originally developed by the Facebook development team and is currently maintained by Apache. Mainly focuses on the communication layer between components of your system.

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

***Notes***

Commandline: 
``` 
thrift --gen <language> <Thrift filename> 
```
<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Apache_Thrift_architecture.png/273px-Apache_Thrift_architecture.png"/></p>


**GRPC** is RPC framework, using protocol buffers as both its Interface Definition Language (IDL) and as its underlying message interchange format.

<p align="center">
  <img src="https://grpc.io/img/landing-2.svg" width="50%" height="50%"/></p>
  
  

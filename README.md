# Meminfo
[![JDK](https://img.shields.io/badge/java-SE8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[![Latest](https://img.shields.io/badge/latest-v1.0-blue.svg)](https://github.com/manuelkollus/meminfo)

Meminfo is an Java parser for "proc/meminfo" file. 
***

## Examples

The Meminfo library offers you the possibility to read the current data directly from the meminfo file.

```java
MemoryInfoParserFactory memoryInfoParserFactory = MemoryInfoParserFactory.create();

 try {
  memoryInfoParserFactory.getFieldsFromFile().forEach(memoryInfoFileField -> {
    System.out.println("KEY: " + memoryInfoFileField.key());
    System.out.println("VALUE: " + memoryInfoFileField.value());
    System.out.println("UNIT: " + memoryInfoFileField.memoryInfoUnit());
  });
 } catch (IOException failure) {
   failure.printStackTrace(); // Your error handling 
}
```
## Dependencys

**Maven**

```xml
  <repositories>
    <repository>
      <id>meminfo-repo</id>
      <url>https://packagecloud.io/manuelkollus/opensource</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>io.github.manuelkollus</groupId>
      <artifactId>meminfo-all</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
  </dependencies>
```

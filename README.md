# xjar-agent-hibernate
XJar Adapter For Spring Boot With Hibernate

## 功能说明
由于在 Spring Boot 项目中使用了JPA且实现为Hibernate时，Hibernate自己解析加密后的Jar文件导致无法正常启动的问题。
该模块采用 Java Agent 技术对org.hibernate.boot.archive.internal.JarFileBasedArchiveDescriptor 类中的resolveJarFileReference() 方法进行拦截并将其返回结果进行包装，
让Hibernate直接得到解密后的class，也就解决了Spring Boot + Hibernate 无法适配XJar的问题。

## 使用说明
1. clone本项目，使用 mvn clean package 编译出 xjar-agent-hibernate-${version}.jar 文件
2. 采用 java -javaagent:xjar-agent-hibernate-${version}.jar -jar your-spring-boot-app.jar 命令启动
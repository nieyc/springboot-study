打包：mvn clean package -Dmaven.test.skip=true
运行：java -jar sample1-0.0.1-SNAPSHOT.jar
注意事项：
发布在web容器下，需要更新pom.xml 里两个地方
1：<packaging>jar</packaging> 改为<packaging>war</packaging>
2：去掉spring-boot-starter-web 中的依赖，即去掉spring-boot默认的tomcat容器
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
           <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>


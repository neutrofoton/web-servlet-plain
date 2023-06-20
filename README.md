# Step create project :

1. Create project with maven :
   a. Eclipse way : File > New > Maven Project > etc...
   b. Maven command : 
      ``` bash
      $ mvn archetype:create -DgroupId=com.neutrofoton.j2ee -DartifactId=simple-web-app -DarchetypeArtifactId=maven-archetype-webapp
      ```

2. Add dependency for servlet. Since we will create Servlet to handle http request and response
     ``` xml
   		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.4</version>
			<scope>provided</scope>
		</dependency>
    ```
		
3. Create servlet class
4. Add Servlet config in web.xml
   ``` xml
	 <servlet>
         <servlet-name>SimpleServlet</servlet-name>
         <display-name>SimpleServlet</display-name>
         <description>A simple Servlet</description>
         <servlet-class>com.neutrofoton.j2ee.SimpleServlet</servlet-class>
	  </servlet>
	  <servlet-mapping>
	         <servlet-name>SimpleServlet</servlet-name>
	         <url-pattern>/SimpleServlet</url-pattern>
	  </servlet-mapping>
    ```  
5. Configure app server (container) ex: tomcat
6. Open <code>http://localhost:8080/simple-web-app/SimpleServlet</code>

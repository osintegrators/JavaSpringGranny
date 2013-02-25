JavaSpringGranny
================

Granny's Addressbook with Java + Spring MVC + PostgreSQL

1. Install git 
<pre><code>sudo apt-get install git</code></pre>
2. Do a <code> git clone https://github.com/osintegrators/JavaSpringGranny.git </code>
2. Open up your IDE ( Eclipse / STS preffered ) and go to File -> Import -> General -> Existing projects into workspace
3. Import the project.
4. Perform a Project -> Clean
5. Right click on the pom.xml and do a Maven -> clean, and a Maven -> install.
6. Right click on Project and Run As -> Run On server.
7. You might need to create a new server environment.
8. This project can be deployed on any of the following
8.1 Tomcat
8.2 vFabric tcServer
8.3 JBoss Application Server
9. After you create a server, Deploy the project on the server. 
10. Note: If your IDE does not have the facility to run on an server from within, you can do a mvn package from the command line and deploy the .war file directly on an external server
11. Browse to <code>http://localhost:8080/JavaSpringGranny/</code>

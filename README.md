JavaSpringGranny
================

Granny's Addressbook with Java + Spring MVC + PostgreSQL
Install database
----------------
Install the database.
* NOTE: You may need to setup trusted authentication for localhost. This is done by editing the [pg_hba.conf](http://www.postgresql.org/docs/devel/static/auth-pg-hba-conf.html) file.
<pre><code> sudo apt-get install postgresql-9.1</code></pre>
* make a user called postgres and Start the postgresql server. Documentation regarding this can be found [here](http://www.postgresql.org/docs/9.1/static/server-start.html)
* Create a database called granny by following command <pre><code> </code>CREATE DATABASE granny;</pre>
* Create a user/role called granny by following command <pre><code> </code>CREATE USER granny WITH password 'granny';</pre>
* Grant all privileges to the granny user/role by following command <pre><code> GRANT ALL PRIVILEGES ON DATABASE granny to granny; </code></pre>

Checkout Project from git
-------------------------
1. Install git  <code>sudo apt-get install git</code>
2. Do a <code> git clone https://github.com/osintegrators/JavaSpringGranny.git </code>
2. Open up your IDE ( Eclipse / STS preffered ) and go to File -> Import -> General -> Existing projects into workspace

Build
-----
4. Perform a Project -> Clean
5. Right click on the pom.xml and do a Maven -> clean, and a Maven -> install.
6. Right click on Project and Run As -> Run On server.
7. You might need to create a new server environment.

Run
---
* This project can be deployed on any of the following
<br> Tomcat
<br> vFabric tcServer
<br> JBoss Application Server
9. After you create a server, Deploy the project on the server. 
10. Note: If your IDE does not have the facility to run on an server from within, you can do a mvn package from the command line and deploy the .war file directly on an external server
11. Browse to <code>http://localhost:8080/JavaSpringGranny/</code>

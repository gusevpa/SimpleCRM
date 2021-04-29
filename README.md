# SimpleCRM

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ffd6db97d11449c5b95ebef33f2d1989)](https://app.codacy.com/gh/Gusev2048/SimpleCRM?utm_source=github.com&utm_medium=referral&utm_content=Gusev2048/SimpleCRM&utm_campaign=Badge_Grade_Settings)

Simple CRM project with:

- Java 9
- Spring boot 2
- Hibernate ORM
- Lombok
- Spring Web
- Spring MVC
- RESTful (maybe, I don't know) 
- some other interesting things

How to:
  - open annotation.property and change DB parameters to yours;
  - make shure that DB user you log in with have permission to create tables in selected DB "public" schema;
  - mvn clean install;
  - enjoy.

import.sql file has test data to refill empty DB table. If you do not want use it - just delete this file before build.
Make shure you use option mvn clean before mvn install.

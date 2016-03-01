# Spring Boot & more
In this repository 'll have examples of using different modules of the Spring Framework


<hr>
<b>test-sbb</b>: </br>
This small project is an example of how to use two data sources in <em>Spring Boot Batch</em>, during the development of a project in which not want to use Spring Batch own tables, and after several attempts and see who lost hours trying to eliminate I decided to use two data sources.
The first data source was attempting to use H2 in memory, and again lost hours until debugging saw that in some classes referred to HSQLDB and all was light. The second source of data is combined with JPA MySQL.
</br>
<hr>
<b>sb-weblogic-archetype</b>:</br> 
We've been testing "Spring Boot" on Weblogic 12c and although not complicated, I leave an archetype that generates an SB project with a RESTful service.
</br>
URL: http://127.0.0.1:7001/poc-wl/0.1/sb/wl12/environment
Method: POST
Headers:
  Authorization: SIF
  timestamp: 20150928
  CorrelationID: asad
  Content-Type: application/xml
Payload:
  <environment><application>everis</application><messg><id>23fg-esd3-frde4</id></messg><timestamp>Hoy</timestamp></environment>
<hr>
</br>
Expected to be of help.

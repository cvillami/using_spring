# Spring Boot & more
In this repository 'll have examples of using different modules of the Spring Framework


<hr>
<b>test-sbb</b>: </br>
This small project is an example of how to use two data sources in <em>Spring Boot Batch</em>, during the development of a project in which not want to use Spring Batch own tables, and after several attempts and see who lost hours trying to eliminate I decided to use two data sources.
The first data source was attempting to use H2 in memory, and again lost hours until debugging saw that in some classes referred to HSQLDB and all was light. The second source of data is combined with JPA MySQL.
</br>
<hr>
<b>sb-weblogic-archetype</b>:</br> 
We've been testing Spring Boot on Weblogic 12c and although not complicated, I leave an archetype that generates an SB project with a RESTful service.</br>
If you deploy more than one project in your weblogic beware the file (weblogic.xml) 
</br>
<p>
&nbsp;URL: http://127.0.0.1:7001/poc-wl/0.1/sb/wl12/environment</br>
&nbsp;Method: POST</br>
&nbsp;Headers:</br>
  &nbsp;&nbsp;Authorization: SIF</br>
  &nbsp;&nbsp;timestamp: 20150928</br>
  &nbsp;&nbsp;CorrelationID: asad</br>
  &nbsp;&nbsp;Content-Type: application/xml</br>
&nbsp;Payload:</br>
  &nbsp;&nbsp;&lt;environment&gt;&lt;application&gt;everis&lt;/application&gt;&lt;messg&gt;&lt;id&gt;23fg-esd3-frde4&lt;/id&gt;&lt;/messg&gt;&lt;timestamp&gt;Hoy&lt;/timestamp&gt;&lt;/environment&gt;</br>
</p>
<hr>
</br>
Expected to be of help.

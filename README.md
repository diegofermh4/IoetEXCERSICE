# IoetEXCERSICE
It is a java aplication, the jdk used is openjdk15.</br>
The class App is the main class.</br>
It is a maven project.</br>
<p>
This project calculate the salary from employes.</br>
The input data is througth process txt file locate in META-INF folder.</br>
The output is in the App class in command line.</br>
This project use Domain Driven Design model, it has follow layers:</br></br>
<td>
-Model .- Object that represents domain</br>
-Infraestructure.- Layer for obtain data.This layer has a command pattern for ecapsule the implementation inthis case is for   txt files.</br>
-Services .- This layer has a methods or function for process the data and decompone the tasks.</br>
-Enumerator.- this package has a data for calculate, it is a simulate database configuration for salary values for time lines.</br>  
</td>                                                                                                                                                                                 
</p>
I try that the infraestructure encapsule the data access because it is a layer that  mantain clean the domain,  i use a command pattern to encapsulate in an object all the data required for performing a read to file how data access.
It is a maven project, for command line locate  root project (pom.xml location) execute</br>  
 mvn -install 
 </br>
this command build a jar file SalaryProject-0.0.1.jar, for execute this jar, you can use the next command : </br>
 java -jar SalaryProject-0.0.1.jar

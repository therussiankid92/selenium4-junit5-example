# Selenium 4 with JUnit5 - Test Automation Example   

## Prerequisites  
Make sure you have the following installed on your machine:  
- latest JAVA SDK  
- latest Maven  
  
## Running the tests  
### Using a local browser  
- run  
 ```
       $ mvn test -Dtest.execution.type=local 
 ```   
This will execute the tests in local, in the browser specified in src/test/resources/config.properties  
### Using a remote grid of your choice  
- run  
 ```
      $ mvn test -Dtest.execution.type=remote -Dgrid.Url=http://${ipOfYourGrid}:${portOfYourGrid}/wd/hub
 ```  
This will execute the tests in the remote grid, in the browser specified in src/test/resources/config.properties   

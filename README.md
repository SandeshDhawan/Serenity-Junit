# Serenity JUnit project


## Get the code

Git:

    git clone https://github.com/SandeshDhawan/Serenity-Junit.git


## Use Maven

Open a command window and run:

    mvn clean verify


## Viewing the reports

commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!


### The project directory structure
The project has build scripts for both Maven and follows the standard directory structure used in most Serenity projects:
```
src
  + main
  + test
    + java                   
        + SaucePages         Created class under this folder having Locatores and method for pergorming operations
        + SauceTests         Test Cases for checking functionality
        + Steps              Created Steps calling method created in Pages
    + resources
      + webdriver            we can crrate folder for linux and mac and have all webdriver e.g chromedriver,geckodriver
        + windows            Store webdriver for windows                         
      + serenity.conf        Passed path of webdriver    
```

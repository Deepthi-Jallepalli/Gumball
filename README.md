# individual-project-Deepthi-Jallepalli

Design the method(s) that  reads a record from the file, verifies that the credit card number is a possible account number, and creates an instance of the appropriate credit card class using design patterns

# Requirements
  * Design credit card application to validate different types of credit cards
  * The application must accepts credit cards data in different file formats
  
# Implementation
  * Design pattern choice : Chain of Responsibility for designing validation of dynamic input type of credit card class. A modified Factory pattern for creation of input file        type parser objects dynamically. 
  * Implemented logic for validating 4 types of credit crads : MasterCard, Visa, AmericanExpress, Discover
  * Implemented logic for reading and writting 3 types of file formats : .csv, .xml, .json
  * Current design supports easy entension of this application to validate more types of credit cards, and parse more types of file formats by just adding corresponding classes.
    
# Development Environment Details
  *  Entire application is build on:
      Java version = **14.0.2**
      Java(TM) SE Runtime Environment (build 14.0.2+12-46)
      Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
  * Development IDE : IntelliJIDEA Community 2020.2, Maven Project
  * Dependencies are listed in pom.xml
  
# Project Structure

  * src/main
  * src/test
  * **src/main/java/com/project/app** - conatins all credit card validation design java files
  * **src/test/java/com/project/app** - contains Junit test cases java file
  
 # Running main and test files
 
  * To Run main file, Load project CMPE202_IndividualProject into IDE, Navidate to below directory and follow the command stated below
  
    **CMPE202_IndividualProject\src\main\java\com\project\app>java CreditCardValidator Input.xml Output.xml**
   
    **CMPE202_IndividualProject\src\main\java\com\project\app>java CreditCardValidator Input.json Output.json**
   
    **CMPE202_IndividualProject\src\main\java\com\project\app>java CreditCardValidator Input.csv Output.csv**
  
  * To Run Junit java file **please install IntelliJ IDE**, Load project CMPE202_IndividualProject into IDE, right click on file "CreditCardTestCases.java" 
  
    **located at CMPE202_IndividualProject\src\test\java\com\project\app and click on Run 'CreditCardTestCases'**
    
  * ***Note: Ignore if the IDE shows any problems such as unable to find particluar class, after loading the project into IDE. As this doesn't stop from running and executing          the code. You can verify by building the project, it would show successfully built. Go ahead and run above commands stated to run main class. Kidnly report back if you          face any issues with building or running the files.***
#  Deliverables: Diagrams annd description is mentioned in Project Deliverables folder. I have added both PNG and .asta files for Part1 and Part2 design UML class diagrams

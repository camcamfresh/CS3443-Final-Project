# CS3443-Final-Project

### Getting Started With Project
Java Version:
  - The instructions say the Professor will use UTSA's VDI machines to clone this repository and run our program. The VDI machines use Java Version 1.8 (or JDK 8).
    - Goto: https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html and download "Java SE Development Kit 8u51".

JavaFX:
  - In previous versions of Java (including JDK 8), the JavaFX Library is already included. There is no need to download JavaFX. This will also prevent us from adding features that are not available in JDK8.

Downloading/Cloning Project from Github:
  - Create Github account
  - Open Eclipse & go to: Window, Perspective, Open Perspective, Other, Git
	- Note: you can switch perspectives via icons on the top right of the window.
  - On the left side of the window, see Git Repositories, then select clone a git repository.
  - Enter Github Repository URL & enter Github Credentials (you'll probably want to store them).
  - Select master branch (& any other branches you want), click next, then finish
  - Now the git project has been downloaded to your computer, but the project has not been opened.
  - To open the project, right click on newly downloaded repository & select Import Projects
  - You want to import the existing eclipse project titled "Final-Project"
  - Switch to Java Perspective & you will now see the projects in your Package Explorer

Dependencies:
  - This project requires Java 8 (JDK/JRE) and the accompanying JavaFX Library.
  - If you recently downloaded this project you may need to configure your JRE System Library:
    - Goto: Project, Properties, Java Build Path, and select Libraries.
	- Remove all existing Libraries, Add Library, JRE System Library.
	- If Workspace default JRE is "JRE1.8xxxx" (where xxxx is the build version), then click that, finish & apply.
	- If you do not see JRE1.8xxxx, but you know the JDK or JRE is installed, then Install JREs, Add..., Standard VM, Directory..., navigate to the folder jre1.8xxxx (usually within Program Files), highlight and Select Folder, Finish, Apply and Close, now select Alternative JRE jre1.8xxxx, click Finish, and Apply and Close.
	- If none of the steps worked for you, check to see that Java 8 is installed on your machine.

Branching:
  - To better organize our code, I would recommend creating a branches. A branch is basically a copy of the master, but we can keep it separated until the code is complete.
  - To create a branch, right click on your Git Repository (in the Git Perspective) and click Switch To, New Branch, and enter a branch name (something to let other's know what exactly you're working on).
  - Write the code you want. You can also push the new branch to Github to discuss the code with your team.
  - When you're done coding, and you have committed to your branch. You can try to merge to the master branch (only do so if your code is completed).
  - To merge a branch, you will need to checkout the master then attempt to merge with the branch you were working on.
  - If you have a merge conflict, google it.

Extra:
  - JavaFX Scene Builder
    - Download at: https://gluonhq.com/products/scene-builder/#download



### Application Idea
TBA

### To Be Started:
### Work In Progress:
 - Come up with team name (everyone).
 - Come up with an awesome, but feasible application idea (everyone).
 - Determine scope of application (everyone).
 - Organize components of idea and comply with MVC design pattern (everyone).
 - Create UML diagram of application (anyone)
 - Begin Coding (everyone)
 

### Completed:



### When Finished:
This file must contain instructions for running the application.
It should include requirements, dependencies, and any extra files/information
required to compile and run the program.

Instructor will clone repository and use README file to run the application on a UTSA CS VDI (which has Java SE 1.8).

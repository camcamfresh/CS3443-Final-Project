# CS3443-Final-Project

### Snake
Features:
  - Snake game
    - Control a snake using the arrow keys 
    - eating pellets makes the snake longer
    - Try to eat as many pellets as possible while avoiding running into walls or your tail
    - 
  - High Score System
    - Stores the top 5 high scores and automatically updates when a new high score is reached
    - Allows players to enter their name to go with their score

### Installation Instructions
Java Version:
  - This application uses Java Version 1.8 (or JDK 8).
    - Download at https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html and select "Java SE Development Kit 8u51".

Eclipse:
  - Download the current version of Eclipse at https://www.eclipse.org/downloads/
  
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


JavaFX:
  - Java Version 1.8 (or JDK 8) includes the JavaFX Library. There is no need to download extra software, however it may need to be properly configured.
  - Easy Setup: 
    - If you are using the regular current Eclipse IDE titled "Eclipse IDE 2019-09", then go to "Help", "Eclipse Marketplace...", and search for "e(fx)clipse 3.6.0" and click "Install".
  - More Difficult Setup: 
    - If the above method did not work, or you using a flavor of Eclipse IDE (e.g. Mars Eclipse), then you must configure the JRE System Library manually. Goto: Project, Properties, Java Build Path, and select Libraries.Remove all existing Libraries, Add Library, JRE System Library. If Workspace default JRE is "JRE1.8xxxx" (where xxxx is the build version), then click that, finish & apply. If you do not see JRE1.8xxxx, but you know the JDK or JRE is installed, then Install JREs, Add..., Standard VM, Directory..., navigate to the folder jre1.8xxxx (usually within Program Files), highlight and Select Folder, Finish, Apply and Close, now select Alternative JRE jre1.8xxxx, click Finish, and Apply and Close.
  - If none of the steps worked for you, check to see that Java 8 is installed on your machine.
  
Running Application:
  - If all the steps have been correctly configured, goto Main.java within the project and click Run.

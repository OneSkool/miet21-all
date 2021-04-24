# Application Setup
This application use Java as primary language of development but you can always add any JVM based
language to the mix by adding dependencies to the Gradle build file.

## Build and Run application

On Windows machine (Linux and Mac users can use Homebrew):

1. Install JDK 14  
    https://adoptopenjdk.net/releases.html?variant=openjdk14&jvmVariant=hotspot  

    - Choose JDK 14, Hotspot, Windows and x64 in options. Download .msi file and install it    
    Verify installation by checking version:  
    ```
    c:\ java -version 
   ```  

2. Install Git  
     https://git-scm.com/download/win   

    - Download Window 64 bit setup  
    - During setup, select option to use 'main' as default branch
    -  Select to install bash shell    

    NOTE: Actual repo to clone would be configured for each team            

3. Install IDE (Intellij Idea Community Edition)
    https://www.jetbrains.com/idea/download/#section=windows    

4. Clone project code in your 'projects' directory   
    ```
    c:\ git clone https://schohan@github.com/oneskool-internal/training-project-templates.git   
    ```    

### Build & Run Application
On a Mac/Linux system:  
```
 $ cd training-project-templates/java-web
 $ ./gradlew build  
 $ ./gradlew bootRun  
```

On a Windows system  
```
 c:\ cd training-project-templates\java-web
 c:\ gradlew build  
 c:\ gradlew bootRun  
```
### Verify Application is running
http://localhost:8080/


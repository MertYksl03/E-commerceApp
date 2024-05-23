@echo off
rem Step 1: Compile all Java files in the current folder
javac *.java

rem Check if compilation was successful
if errorlevel 1 (
    echo Compilation failed.
    exit /b
)

rem Step 2: Run the Test class
java Test

rem Step 3: Remove all .class files
del *.class


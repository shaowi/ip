@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp ..\src\main\java\seedu\shao -Xlint:none -d ..\bin ..\src\main\java\seedu\shao\*.java ..\src\main\java\seedu\shao\commands\*.java ..\src\main\java\seedu\shao\parser\*.java ..\src\main\java\seedu\shao\storage\*.java ..\src\main\java\seedu\shao\task\*.java ..\src\main\java\seedu\shao\tasklist\*.java ..\src\main\java\seedu\shao\ui\*.java

IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin\seedu\shao Shao < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

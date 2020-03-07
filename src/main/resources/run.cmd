@echo off
IF "%JAVA_HOME%" == "" GOTO NOPATH
:YESPATH
REM The JAVA_HOME environment variable was detected.
set PATH=%JAVA_HOME%\bin;%PATH%
GOTO END
:NOPATH
REM The JAVA_HOME environment variable was not detected.
set PATH=%CD%\jdk8\bin;%PATH%
GOTO END
:END

@echo on
java -jar %CD%\csvtojson-1.0-SNAPSHOT-jar-with-dependencies.jar %*
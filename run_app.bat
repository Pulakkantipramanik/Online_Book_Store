@echo off
mvn clean package -DskipTests
if %ERRORLEVEL% NEQ 0 goto :error
java -jar target\bookstore-0.0.1-SNAPSHOT.jar
goto :eof
:error
echo Build failed
pause

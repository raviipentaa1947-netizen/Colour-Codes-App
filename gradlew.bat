@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem Gradle startup script for Windows
@rem ##########################################################################
set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
if defined JAVA_HOME goto findJavaFromJavaHome
set JAVA_EXE=java.exe
goto init
:findJavaFromJavaHome
set JAVA_EXE=%JAVA_HOME%\bin\java.exe
:init
"%JAVA_EXE%" -Xms64m -Xmx64m -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

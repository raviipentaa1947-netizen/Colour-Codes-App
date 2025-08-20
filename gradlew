#!/usr/bin/env sh

##############################################################################
## Gradle start up script for UN*X
##############################################################################
APP_BASE_NAME=${0##*/}
APP_HOME=$(cd "${0%/*}" ; pwd -P)
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar
if [ -n "$JAVA_HOME" ] ; then
    CLASSPATH="$CLASSPATH"
    exec "$JAVA_HOME/bin/java" -Xms64m -Xmx64m -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
else
    exec java -Xms64m -Xmx64m -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
fi

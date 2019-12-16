FROM openjdk:12

## Timezone
ENV TZ "Asia/Taipei"

## Java Options
ENV JAVA_TOOL_OPTIONS "\
-Dfile.encoding=UTF-8 \
"

## Copy and Run Application
COPY target/*.jar /application.jar
CMD ["java", "-jar", "application.jar"]
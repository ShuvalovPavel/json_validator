FROM openjdk:alpine

EXPOSE 80
RUN apk add --no-cache git
RUN apk add --no-cache maven
RUN git clone https://github.com/ShuvalovPavel/json_validator.git
WORKDIR /json_validator
RUN mvn clean install -e
CMD mvn exec:java -e

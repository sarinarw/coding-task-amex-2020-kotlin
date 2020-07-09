Coding task for AMEX 2020 interview.
(Note: My first time using Kotlin)

## Run `Mail` Service
1. `mvn clean install` from inside the `mail` directory
1. `mvn exec:java` 

## Run `Order` Service
First, run `mvn clean install` from inside the `order` directory
### Method 1
1. `mvn exec:java -Dexec.args="--help"`
### Method 2
1. `mvn package`
1. Take the full path of the with-dependencies `*-with-dependencies.jar` output
1. Run with `java -jar *-with-dependencies.jar --help`

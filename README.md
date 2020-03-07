# CVSTOJSON
CVSTOJSON project helps convert csv file to json

## Installation

Download 
```
src\main\resources\csvtojson-1.0-SNAPSHOT-jar-with-dependencies.jar
src\main\resources\run.cmd
src\main\resources\jdk8
```
to same local directory. You can skip downloading jdk8 directory if your local machine already has java 8+ and is configured in your PATH.

 
## Usage

Open command shell and cd to the local directory where above files were downloaded and enter below command. 
Please note if you open powershell make sure you type ````cmd```` and hit enter to switch to command shell mode 
```
run.cmd
```
##
It looks for following folder and file name ````C:\dev\events.csv```` 
##
It results into following json file to be created ````C:\dev\events.json````  
A sample ```events.csv``` and ```events.json``` are in resources

## Contributing

Build `````mvn clean:clean package````` and upload resulting ````csvtojson-1.0-SNAPSHOT-jar-with-dependencies.jar```` jar file to resources

## License
[MIT](https://choosealicense.com/licenses/mit/)

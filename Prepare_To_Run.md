# Prepare to run 
Follow these instructions to prepare to edit the excel sheet and generate json file that will be used by calendar app

First browse this github and go to 
```$xslt
src\main\resources
``` 
and download 
```xhtml
csv.zip
```
zip file to local folder, when you extract this zip file following files will be extracted
```$xslt
csvtojson-1.0-SNAPSHOT-jar-with-dependencies.jar
run.cmd
jdk8
events.csv
events.json
```
## Edit events.csv
Double click **events.csv**, this will open a Microsoft Excel. 
####events.csv
Edit _events.csv_ file in Microsoft Excel and save it. Make sure event is 
either of these values **breakfast**, **lunch**, **announcement**, **snack**.
Make sure date format is **mm/dd/yyyy** e.g **3/11/2020**. Entry in **Description** will appear
in the calendar app, make sure no **,** is used when filling out the description.
Save _events.csv_ file after editing and now you are ready to create _events.json_ file based
on the _events.csv_ file

## How to run
Double click the  
```
run.cmd
```
from your local windows folder, this will open a command shell and will prompt you with
```$xslt
Type in events.csv file directory location Eg: C:\cvs and press ENTER
```
Type the location of the events.csv file on your local machine. Once the run completes it will create a file
```$xslt
events.json
```
in the location you typed in earlier. Upload the events.json file to **website** github repo

# Avaj_Launcher
Implementation of a minimal aircraft simulation program based on a given UML class diagram. 
The Unified Modeling Language is used in software engineering for visualizing the design of an application.
It oﬀers programmers a standardized way of thinking about Object Oriented software, before writing any line of code

https://trello-attachments.s3.amazonaws.com/5b838d66f253fc021a40201e/5d09cb12132ff1172c62cf1f/e881db806d058577f6824f993ce4250e/avaj_uml.jpg

## Compiling

1. Make sure java is installed.

## Run the command below if you have git and bash(installed):

```bash
bash run.sh 
```

## Run manually if you dont have git and bash(installed):

```bash 
find . -name "*.java" > sources.txt
javac @sources.txt
java simulator scenario.txt

find . -name "*.class" -delete
```

## Author

Mxolisi

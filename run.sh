find . -name "*.java" > sources.txt
javac @sources.txt
java simulator scenario.txt

find . -name "*.class" -delete
#!/bin/bash

# Azul
files=(
    "Compilateur.class"
    "Compilateur.java"
    "CompilateurConstants.class"
    "CompilateurConstants.java"
    "CompilateurTokenManager.class"
    "CompilateurTokenManager.java"
    "ParseException.class"
    "ParseException.java"
    "SimpleCharStream.class"
    "SimpleCharStream.java"
    "Token.class"
    "Token.java"
    "TokenMgrError.class"
    "TokenMgrError.java"
)

# test & delete
for file in "${files[@]}"; do
    if [ -f "$file" ]; then
        rm "$file"
        echo "$file deleted."
    else
      printf Clearing
      sleep 0.5
      printf .
      sleep 0.5
      printf .
      sleep 0.5
      printf .
      sleep 0.5
      printf .
      clear
        break
    fi
done
# this "if" statement used to delete .java .class files (added files that we gonna not push everytime )
if [ $# -eq 1 ]; then
  rm AST/*.class
  exit 1
fi
javac AST/*.java
# program launching
javacc Compilateur.jj
javac *.java
echo "---- Starting -----"
java Compilateur
./mi-makefile.sh 1 > t
rm t


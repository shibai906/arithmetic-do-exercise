#!/usr/bin/env bash

i=0
while read line
do
  ((i++))
    if [ $i -eq 10 ]
    then echo $line
    fi
done < file.txt
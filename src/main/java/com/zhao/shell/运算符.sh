#!/usr/bin/env bash

# 运算符操作：https://www.runoob.com/linux/linux-shell-basic-operators.html
a=2
b=2
val=`expr 2 + 2`
ab=`expr $a + $b`
echo "两数之和为 : $val"
echo "ab之和为 : $ab"

if [ $a -eq $b ]
then
  echo "我和你心连心"
else
  echo "屁，我们注定无缘"
fi

file='file.txt'
if [ -r $file ]
then
  echo "我是文件文文件"
fi

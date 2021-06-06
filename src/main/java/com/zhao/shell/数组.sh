#!/usr/bin/env bash

# array_name=(value1 value2 ... valuen)
# 只支持一维数组（不支持多维数组）， 数组的下标从0开始
my_array=(A B "C" D)



# 读取数组元素值的一般格式是：${array_name[index]}
echo ${my_array[1]}
echo ${my_array[*]}
echo ${my_array[@]}


for arr in ${my_array[*]}; do
  echo $arr
done

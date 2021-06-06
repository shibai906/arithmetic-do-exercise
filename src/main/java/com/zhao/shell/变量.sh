#!/usr/bin/env bash
# 变量名和等号之间不能有空格
# 命名只能使用英文字母，数字和下划线，首个字符不能以数字开头。
# 中间不能有空格，可以使用下划线（_）。
# 不能使用标点符号。
# 不能使用bash里的关键字（可用help命令查看保留关键字）。
bash_name="zhaohuan04@baidu.com"
echo $bash_name

#for file in $(ls /etc)
#  echo $file


for skill in Ada Coffe Action Java; do
    echo "I am good at ${skill}Script"
done

myUrl="https://www.google.com"
# readonly 只读变量，不能进行修改
readonly myUrl


myUrl2="https://www.runoob.com"
# unset 删除变量，但是不能删除只读变量
unset myUrl2
echo $myUrl2

# 注意引号的使用，以后使用都用双引号
your_name='runoob'
str="Hello, I know you are \"$your_name\"! \n"
echo $str
echo -e $str
echo ${str:1:4}

# 数组书写方式使用空格隔开
array_name=(1 2 3 4 '234')
for name in ${array_name[*]}; do
 echo $name
done;




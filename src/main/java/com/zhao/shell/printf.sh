#!/usr/bin/env bash
# printf和c语言类似，比echo更加强大

printf "%-10s %-8s %-4s\n" 姓名 性别 体重kg > testFile
printf "%-10s %-8s %-4.2f\n" 郭靖 男 66.1234 >> testFile
printf "%-10s %-8s %-4.2f\n" 杨过 男 48.6543 >> testFile
printf "%-10s %-8s %-4.2f\n" 郭芙 女 47.9876 >> testFile

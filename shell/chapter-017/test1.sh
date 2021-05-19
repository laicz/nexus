#!/bin/bash

#使用函数 使用函数的时候，就跟普通命令一样
function fun1 {
    echo "this is an example of function"
}

count=1
while [ $count -le 5 ]; do
    fun1
    count=$[ $count + 1 ]
done

echo "this is the end of the loop"
fun1
echo "Now this is the end of the script"
#!/bin/bash

#使用变量接收函数输出
function db1() {
    read -p "Enter a value:" value
    echo $[ $value * 2 ]
}

result=$(db1)
echo "the result $result"
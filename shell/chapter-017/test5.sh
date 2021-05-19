#!/bin/bash

#shell 通过 return 来指定一个整数作为函数的退出状态码

function db1() {
    read -p "Enter a value:" value
    echo "doubling the value"
    return $[ $value * 2 ]
}

db1
#结果范围之后0-255
echo "the function exit code is $?"
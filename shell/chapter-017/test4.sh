#!/bin/bash

function func1() {
    echo "no such file"
    ls -l badfile
    echo "echo again"
}

echo "test func1"
func1
#获取的是函数最后一条命令的执行退出码，根据这个进行判断执行结果，是很危险的
echo "the exit status is:$?"
#!/bin/bash

#当函数名一样的时候，后一个函数会覆盖掉前一个函数
function func1() {
    echo "this is 1.0 function 1"
}

func1

function func1() {
    echo "this is 2.0 function 1"
}

func1

echo "end the script"

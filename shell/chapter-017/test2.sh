#!/bin/bash

#调用函数的时候，需要在调用之前就已经将函数定义好了
count=1
echo "This line comes before the function definition"

function func1 {
  echo "This is an example of function"
}

while [ $count -lt 5 ]; do
    func1
    count=$[ $count + 1 ]
done

echo "end loop"
func2
echo "end script"

function func2() {
    echo "this is func2"
}
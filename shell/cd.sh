#!/bin/bash

command="cd "
for arg in "$*"
do
    command=${command}" $arg"
done
$command

#echo ${#PWD}
pwd_len=${#PWD}
((std_len=14+60))  # 65 halfscreen
#echo std_len:$std_len
if [ $pwd_len -ge $std_len ]; then
    keep_str=${PWD:22-$std_len:$pwd_len}
    #echo $keep_str
    keep_str=${keep_str#*/}

    export PS1='${debian_chroot:+($debian_chroot)}\u@\h:$keep_str\$ '
else
    export PS1='${debian_chroot:+($debian_chroot)}\u@\h:\w\$ '
fi

#!/bin/bash

awk -F: '{if($3>500) print $1>"./tmpfile"}' /etc/passwd

for user in $(cat "./tmpfile")
do
    miduser_flag=0
    for miduser in $(cat "/mnt/hdd2/yanan/.miduserdb")
    do
        if [ $user = $miduser ]; then
            miduser_flag=1
        fi
    done

    if [ "$miduser_flag" -eq 1 ]; then
        echo $user is a miduser, no deal with it
        setquota $user 420000000 500000000 0 0 /mnt/hdd2
    else
        echo $user is a general user, deal with it
        setquota $user 110000000 150000000 0 0 /mnt/hdd2
    fi
done

rm -rf ./tmpfile

repquota /mnt/hdd2

#!/bin/bash

awk -F: '{if($3>500) print $1>"./tmpfile"}' /etc/passwd

for user in $(cat "./tmpfile")
do
    if [ $user = "yanan" ]||[ $user = "zone" ]||[ $user = "ProjectGroup" ]; then
        echo "no deal with it"
    else
        echo "deal with it"
        setquota $user 110000000 150000000 0 0 /mnt/hdd2
    fi
done

rm -rf ./tmpfile

repquota /mnt/hdd2

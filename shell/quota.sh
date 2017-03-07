#!/bin/bash

LOGFILE="/mnt/hdd2/yanan/bin/log/quota.log"

quota_init() {
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

        supuser_flag=0
        for supuser in $(cat "/mnt/hdd2/yanan/.supuserdb")
        do
            if [ $user = $supuser ]; then
                supuser_flag=1
            fi
        done
    
        if [ "$supuser_flag" -eq 1 ]; then
            echo `date`: $user is a super user, deal with it >> $LOGFILE
            sudo setquota $user 500000000 520000000 0 0 /mnt/hdd2
        elif [ "$miduser_flag" -eq 1 ]; then
            echo `date`: $user is a miduser, no deal with it >>$LOGFILE
            sudo setquota $user 300000000 320000000 0 0 /mnt/hdd2
        else
            echo `date`: $user is a general user, deal with it >> $LOGFILE
            sudo setquota $user 100000000 120000000 0 0 /mnt/hdd2
        fi
    done
}

quota_help() {
    cat <<EOF
Usage: `basename $0` replace hexo with parameter "-d" and "-g".
options:
    -d display the info
    -i init the quota
    -h display this help menu
EOF
}

quota_info() {
    sudo repquota /mnt/hdd2
}

if [ $# -eq 0 ]; then
    quota_init;
fi

while getopts dhi option; do
    case "$option" in
        d) quota_info;;
	    h) quota_help;;
        i) quota_init;;
        \?) quota_help
            exit 1;;
    esac
done

rm -rf ./tmpfile

echo ================================================= >> $LOGFILE

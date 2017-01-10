#!/bin/bash

hexo_deploy() {
    echo --------------hexo_deploy--------------
    /usr/bin/hexo deploy
}

hexo_usage() {
    cat <<EOF
Usage: `basename $0` replace hexo with parameter "-d" and "-g".
options:
    -d deploy the blog
    -g generate the blog
    -h display this help menu
    -n create new blog assay
EOF
}

hexo_generate() {
    echo --------------hexo_generate--------------
    mkdir -p ~/.tmp_for_blog
    for dir in $(ls ~/blog/public/books/)
    do
        full_dir=~/blog/public/books/$dir
        [ -d $full_dir ] && echo mv $full_dir ~/.tmp_for_blog/ && mv $full_dir ~/.tmp_for_blog/
    done
    echo hexo -g
    /usr/bin/hexo generate
    echo mv ~/.tmp_for_blog/* ~/blog/public/books/
    mv ~/.tmp_for_blog/* ~/blog/public/books/
}

hexo_new() {
    echo --------------hexo_new--------------
    /usr/bin/hexo new $file
}


if [ $# -eq 0 ]; then
    hexo_usage;
fi

while getopts dghn option; do
    case "$option" in
        d) hexo_deploy;;
        g) hexo_generate;;
        h) hexo_usage;;
        n) hexo_new;;
        \?) hexo_usage
            exit 1;;
    esac
done

shift $((OPTIND-1))

while [ $# -ne 0 ]; do
    file=$1
    hexo_new
    shift
done

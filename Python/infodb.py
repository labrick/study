#!/usr/bin/python
# -*- coding: utf-8 -*-

import sqlite3
import re

infodb = sqlite3.connect("./info.db")
infodb.text_factory = str
dbpointer = infodb.cursor()

dbpointer.execute("create table if not exists device_info (mac varchar(20) UNIQUE, ip varchar(20), name varchar(10), device_id varchar(15))")
infodb.commit()

def dump_db():
    dbpointer.execute("select * from device_info")
    while (1):
        result = dbpointer.fetchone()
        if (result != None):
            print result[0], result[1], result[2], result[3]
        else:
            break

def mac_exist(mac):
    dbpointer.execute("select * from device_info")
    while(1):
        result = dbpointer.fetchone()
        if (result != None):
            if (result[0] == mac):
                return True
        else:
            return False

def analyse_line(line):
    element_in_line = line.split(' ', 10)
    if (False == mac_exist(element_in_line[0])):
        dbpointer.execute("insert into device_info values (?,?,?,?)",(element_in_line[0], element_in_line[1], "xxx", 0))
        print "add mac:", element_in_line[0]

def analyse_cfg():
    input_file = open('myfile.cfg')
    try:
        lines = input_file.readlines()
    finally:
        input_file.close()

    line_count = 0
    for line in lines:
        line_count = line_count + 1
        analyse_line(line)
    infodb.commit()
    print 'process', line_count, "record!"

def analyse_line_myfile(line):
    line = re.sub("\\s{2,}", " ", line)
    if line:
        print "line:", line
    element_in_line = line.replace("\t"," ").split(' ', 10)
    if (len(element_in_line)>=4 and mac_exist(element_in_line[3])):
        print "update device_info set name=", element_in_line[1], "ip=", element_in_line[0], "where mac=", element_in_line[3]
        dbpointer.execute("update device_info set name=? where mac=?", (element_in_line[1], element_in_line[3]))

def analyse_myfile():
    input_file = open('info')
    try:
        lines = input_file.readlines()
    finally:
        input_file.close()

    line_count = 0
    for line in lines:
        line_count = line_count + 1
        analyse_line_myfile(line)
    infodb.commit()

dump_db()
analyse_cfg()
analyse_myfile()

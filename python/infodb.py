#!/usr/bin/python
# -*- coding: utf-8 -*-

import sqlite3
import re

infodb = sqlite3.connect("./info.db")
infodb.text_factory = str
dbpointer = infodb.cursor()

dbpointer.execute("create table if not exists device_info (mac varchar(20) UNIQUE, ip varchar(20), name varchar(10), device_id varchar(15))")

def dump_db():
    dbpointer.execute("select * from device_info")
    while (1):
        result = dbpointer.fetchone()
        if (result != None):
            print result[0], "\t", result[1], "\t", result[2], "\t", result[3]
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
        dbpointer.execute("insert into device_info values (?,?,?,?)",(element_in_line[0], element_in_line[1], None, None))
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

def solve_repeat(array):
    dbpointer.execute("select * from device_info")
    while(1):
        result = dbpointer.fetchone()
        if (result != None):
            # find mac
            if (result[0] == array[3]):
                if (result[1] != None):
                    include = result[1].split(" ",10)
                    find = False
                    for ip in include:
                        if (ip == array[0]):
                            find = True
                            break
                    if (find == False):
                        array[0] = result[1] + " " + array[0]

                if (result[2] != None):
                    find = False
                    include = result[2].split(" ",10)
                    for name in include:
                        if (name == array[1]):
                            find = True
                            break
                    if (find == False):
                        array[1] = result[2] + " " + array[1]
                break
        else:
            break

def analyse_line_myfile(line):
    line = re.sub("\\s{2,}", " ", line)
    if line:
        print "line:", line
    element_in_line = line.replace("\t"," ").split(' ', 10)
    if (len(element_in_line)>=4 and mac_exist(element_in_line[3])):
        solve_repeat(element_in_line)
        print "update device_info set name=", element_in_line[1], "ip=", element_in_line[0], "where mac=", element_in_line[3]
        dbpointer.execute("update device_info set name=? where mac=?", (element_in_line[1], element_in_line[3]))
        dbpointer.execute("update device_info set ip=? where mac=?", (element_in_line[0], element_in_line[3]))

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

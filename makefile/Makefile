
debug = debug
CC = g++
DOBJS = hello.do sum.do# 定义一个目标变量，相当于一个宏
ROBJS = hello.ro sum.ro# 定义一个目标变量，相当于一个宏

ifeq ($(debug), debug)
OFLAG = -c -g -Ddebug
all: target_debug
else
OFLAG = -c -o3
all: target_release
endif

target_debug: $(DOBJS)
	$(CC) $(DOBJS) -o $@	# 目标文件target的合成

target_release: $(ROBJS)
	$(CC) $(ROBJS) -o $@	# 目标文件target的合成

#%.do: %.c
.SUFFIXES : .do .c
.c.do:
	$(CC) $(OFLAG) $< -o $@	# 依赖比较多时，效率较高
#%.ro: %.c
.SUFFIXES : .ro .c
.c.ro:
	$(CC) $(OFLAG) $< -o $@	# 依赖比较多时，效率较高

#$(filter %.o,$(OBJS)): %.o: %.c		# 集合：目标集合($@)：依赖集合($<)，filter作过滤
#	$(CC) -c $< -o $@	# 依赖比较多时，效率较高

.PHONY: clean			# 特意指明clean是一个伪目标，只能显示执行
clean:
	rm -f target_* tmp_make $(DOBJS) $(ROBJS) *.o	# -f表示如果要删除的目标不存在，则忽略

dep:
	sed '/\#\#\# Dependencies/q' < Makefile > tmp_make		# q是退出的意思，这个sed意思是符合单引号中内容则退出，否则就复制
	(for i in *.c;do $(CPP) -M $$i;done) >> tmp_make
	cp tmp_make Makefile

# 后面是自动生成
### Dependencies
hello.o: hello.c /usr/include/stdc-predef.h /usr/include/stdio.h \
 /usr/include/features.h /usr/include/x86_64-linux-gnu/sys/cdefs.h \
 /usr/include/x86_64-linux-gnu/bits/wordsize.h \
 /usr/include/x86_64-linux-gnu/gnu/stubs.h \
 /usr/include/x86_64-linux-gnu/gnu/stubs-64.h \
 /usr/lib/gcc/x86_64-linux-gnu/4.8/include/stddef.h \
 /usr/include/x86_64-linux-gnu/bits/types.h \
 /usr/include/x86_64-linux-gnu/bits/typesizes.h /usr/include/libio.h \
 /usr/include/_G_config.h /usr/include/wchar.h \
 /usr/lib/gcc/x86_64-linux-gnu/4.8/include/stdarg.h \
 /usr/include/x86_64-linux-gnu/bits/stdio_lim.h \
 /usr/include/x86_64-linux-gnu/bits/sys_errlist.h sum.h
sum.o: sum.c /usr/include/stdc-predef.h /usr/include/stdio.h \
 /usr/include/features.h /usr/include/x86_64-linux-gnu/sys/cdefs.h \
 /usr/include/x86_64-linux-gnu/bits/wordsize.h \
 /usr/include/x86_64-linux-gnu/gnu/stubs.h \
 /usr/include/x86_64-linux-gnu/gnu/stubs-64.h \
 /usr/lib/gcc/x86_64-linux-gnu/4.8/include/stddef.h \
 /usr/include/x86_64-linux-gnu/bits/types.h \
 /usr/include/x86_64-linux-gnu/bits/typesizes.h /usr/include/libio.h \
 /usr/include/_G_config.h /usr/include/wchar.h \
 /usr/lib/gcc/x86_64-linux-gnu/4.8/include/stdarg.h \
 /usr/include/x86_64-linux-gnu/bits/stdio_lim.h \
 /usr/include/x86_64-linux-gnu/bits/sys_errlist.h

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/wait.h>
#define MAXFILE 65535

int main(int argc, char* argv[])
{
	pid_t pc,pid;		//创建两个进程的pid变量
	int i,fd,len,flag = 1;
	char *buf="this is a Dameon\n";
	len = strlen(buf);
	pc = fork(); //第一步，创建子进程

	if(pc<0)
	{
		printf("error fork\n");
		exit(1);
	}
	else if(pc>0)
		exit(0);

	pid = setsid(); //第二步[1],创建一个新的会话,1）让进程摆脱原会话的控制；2）让进程摆脱原进程组的控制；3）让进程摆脱控制终端的控制

	if (pid < 0)
		perror("setsid error");
	chdir("/"); //第三步
	umask(0); //第四步，收回父进程资源
	for(i=0;i<MAXFILE;i++) //第五步
		close(i);
		/*
		if(flag ==1 &&(fd=open("/tmp/daemon.log",O_CREAT|O_WRONLY|O_APPEND,0600))<0)
		{
			perror("open");
			flag=0;
			exit(1);
		}
		write(fd,buf,len);
		close(fd);
		usleep(10*1000); //10毫秒
		*/
		//system("cd /home/lab302");
		//system("tree -d > /home/lab302/yanan/test/hello.txt");
	system("/home/lab302/yanan/test/app_instart.sh");
}

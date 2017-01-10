#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/wait.h>

#include <time.h>

#define MAXFILE		65535

#define	APP_START	0
#define APP_END		1

volatile sig_atomic_t _running = 1;
int write_log(int log_id);

int main(int argc, char* argv[])
{
	pid_t pc,pid;		//创建两个进程的pid变量
	int i;
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

	while( _running )
	{	
		
		write_log(APP_START);
		system("teamviewer");
		write_log(APP_END);

		_running = 0;
		usleep(10*1000); //10毫秒
		usleep(1000*1000); //1秒
	}
	return 0;
}

int write_log(int log_id)
{
	char* buf;
	time_t rawtime;
	struct tm * timeinfo;
	int len,fd;

	if( (fd=open("home/lab302/yanan/bin/log/teamviewer.log",O_CREAT|O_WRONLY|O_APPEND,0600))<0)
	{
		perror("open");
		exit(1);
	}
	time( &rawtime );
	timeinfo = localtime ( &rawtime );
	buf = asctime(timeinfo);
	len = strlen(buf);
	write(fd,buf,len);
	
	if(APP_START == log_id)
	{
		buf = "		teamviewer started!\n";
	}else{
		buf = "		teamviewer closed!\n";
	}

	len = strlen(buf);
	write(fd,buf,len);
	close(fd);
	return 0;
}

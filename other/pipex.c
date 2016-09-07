#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>

#define BUF_SIZ    255     // message buffer size

int main(int argc, char **argv)
{
	char buffer[BUF_SIZ + 1];
	int fd[2];
	
	// receive a string as parameter
	if ( argc != 2){
		fprintf(stderr, "Usage: %s string\n\a", argv[0]);
		exit(1);
	}
	
	// create pipe for communication
	if ( pipe(fd) != 0 ){
		fprintf(stderr, "Create pipe error: %s\n\a", strerror(errno));
		exit(1);
	}
	// in child process write msg to pipe
	if ( fork() == 0 ){
		close(fd[0]);
		printf("Child %ld write to pipe\n\a", (long int)getpid()); 
		//dup2(fd[0],1);	// 将标准输入重定向为fd[0]
		//dup2(fd[1],2);	// 将标准输出重定向为fd[1]
		snprintf(buffer, BUF_SIZ, "%s", argv[1]);
		write(fd[1], buffer, strlen(buffer));
		printf("Child %ld quit.\n\a", (long int)getpid());
	// in parent process, read msg from pipe
	}else{
		close(fd[1]);
		//printf("Parent %ld read from pipe\n\a", (long int)getpid());
		memset(buffer, '\0', BUF_SIZ + 1);
		read(fd[0], buffer, BUF_SIZ);
		//printf("Parent %ld read : \n%s\n", (long int)getpid(), buffer);
		exit(1);
	}
	return 0;
}

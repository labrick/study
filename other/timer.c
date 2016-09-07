#include <stdio.h>
#include <time.h>

int main(void)
{
	time_t rawtime;
	struct tm *timeinfo;
	char temp;

    while(1)
    {
		time(&rawtime);
		timeinfo = localtime(&rawtime);
		if(timeinfo->tm_sec != temp){
			printf ("The current date/time is: %s", asctime(timeinfo) );
			temp = timeinfo->tm_sec;
		}
	}
}


#include <stdio.h>
#include <string.h>

typedef struct FileInfo {
	char *Name;
	FILE *Pointer;
} FileInfo_t;

int main(int argc,char *argv[]){
	char Element = 0;
	char Buffer[64] = {0,};
	char CodeSucFlag = 1;
	
	FileInfo_t InputFile,OutputFile;

	InputFile.Name = argv[1];
	OutputFile.Name = Buffer;
	strcpy(Buffer,argv[1]);
	strcat(Buffer,".n");

	if(NULL == (InputFile.Pointer = fopen(InputFile.Name,"r"))){
		printf("open InputFile:%s failure!\n",InputFile.Name);
		return -1;
	}

	if(NULL == (OutputFile.Pointer = fopen(OutputFile.Name,"w"))){
		printf("open OutputFile:%s failure!\n",OutputFile.Name);
		return -1;
	}
	while(fread(&Element,sizeof(char),1,InputFile.Pointer)){
		Element++;
		if(!fwrite(&Element,sizeof(char),1,OutputFile.Pointer)){
			printf("write %c failure!\n",(Element-1));
			CodeSucFlag = 0;
			goto CLEANUP;
		}
	}

CLEANUP:
	if(NULL != InputFile.Name){
		fclose(InputFile.Pointer);
	}
	if(NULL != OutputFile.Name){
		fclose(OutputFile.Pointer);
	}
	if(CodeSucFlag == 1){
		remove(InputFile.Name);
	}else{
		remove(OutputFile.Name);
	}

	return 0;
}

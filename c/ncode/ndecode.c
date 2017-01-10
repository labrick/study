#include <stdio.h>
#include <string.h>

typedef struct FileInfo {
	char *Name;
	FILE *Pointer;
} FileInfo_t;

int main(int argc,char *argv[]){
	char Element = 0;
	char DecodeSucFlag = 1;
	char Buffer[64] = {0,};
	
	FileInfo_t InputFile,OutputFile;

	InputFile.Name = argv[1];
	OutputFile.Name = Buffer;
	strcpy(Buffer,argv[1]);
	OutputFile.Name[strlen(OutputFile.Name)-2] = '\0';

	if(NULL == (InputFile.Pointer = fopen(InputFile.Name,"r"))){
		printf("open Input failure!");
		return -1;
	}
	if(NULL == (OutputFile.Pointer = fopen(OutputFile.Name,"w"))){
		printf("open OutputData failure!");
		return -1;
	}
	while(fread(&Element,sizeof(char),1,InputFile.Pointer)){
		Element--;
		if(!fwrite(&Element,sizeof(char),1,OutputFile.Pointer)){
			printf("write %c failure!",Element);
			DecodeSucFlag = 0;
		}
	}

CLEANUP:
	if(NULL != InputFile.Name){
		fclose(InputFile.Pointer);
	}
	if(NULL != OutputFile.Name){
		fclose(OutputFile.Pointer);
	}
	if(DecodeSucFlag == 1){
		remove(InputFile.Name);
	}else{
		remove(OutputFile.Name);
	}
	return 0;
}

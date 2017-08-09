#include <iostream>
#include <string>
#include <malloc.h>

using namespace std;

bool isNum(char oneChar)
{
    if('0' <= oneChar && oneChar <= '9' )
        return true;
    else
        return false;
}

bool isChar(char oneChar)
{
    if(oneChar >= 'a' && oneChar <= 'z')
        return true;
    else
        return false;
}

void err(char * output)
{
    cout << "!error" << endl;
    output[0] = '\0';
}

void unzip(const char* input, char* output)
{
    int outputIndex = 0;
    int inputIndex = 0;
    int repeatChar = 0;
    if(input[0]== '\0'){
        cout << "1" << endl;
        err(output);
        return;
    }
    for(inputIndex=0; *(input+inputIndex); inputIndex++);
    if(isNum(*(input+inputIndex-1))){
        cout << "2" << endl;
        err(output);
        return;
    }
    while(*input){
        char oneChar = *input;
        if(isChar(oneChar) || isNum(oneChar))
        {} else {
            cout << "3" << endl;
            err(output);
            return;
        }

        if(isNum(oneChar)){
            if(oneChar == '0'){
                cout << "4" << endl;
                err(output);
                return;
            }

            int charNum = oneChar - '0';
            int i;
            for(i=1; isNum(*(input+i));i++){
                charNum = charNum*10 + *(input+i) - '0';
            }
            if(charNum <= 2){
                cout << "5" << endl;
                err(output);
                return;
            }

            if(*(input+i) == *(input+i+1)){
                cout << "6" << endl;
                err(output);
                return;
            }
                
            for(int j=0; j<charNum; j++){
                if(isChar(*(input+i)))
                    output[outputIndex++] = *(input+i);
                else{
                    cout << "7" << endl;
                    err(output);
                    return;
                }
            }
            input += i+1;
            repeatChar = 1;
        } else if(isChar(oneChar)){
            output[outputIndex++] = *input++;
            cout << repeatChar << endl;
            if(*(input-2) == *(input-1))
                repeatChar++;
            else
                repeatChar = 1;

            if(repeatChar > 2){
                cout << "8" << endl;
                err(output);
                return;
            }
        }
    }
    output[outputIndex] = '\0';
}

int main()
{
    string input;
    while(getline(cin, input)){
        char *output = (char *)malloc(sizeof(char)*1024*2);
        unzip(input.c_str(), output);
        cout << output << endl;
    }
    return 0;
}

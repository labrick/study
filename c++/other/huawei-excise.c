#include <iostream>
#include <string>

using namespace std;
int main()
{
    char charTable[52] = {
        'F', 'G', 'R', 'S', 'T', 'L', 'M', 'N', 'O', 'P', 
        'Q', 'W', 'X', 'Y', 'Z', 'U', 'A', 'G', 'H', 'I', 
        'J', 'K', 'B', 'C', 'D', 'E', 'l', 'm', 'n', 'o', 
        'p', 'i', 'j', 'k', 'f', 'g', 'h', 'a', 'b', 'c',
        'd', 'e', 'q', 'r', 'w', 'x', 'y', 'z', 's', 't',
        'u', 'v'
    };

    string tmp;

    while(getline(cin,tmp)){
        char result[100];
        int resultIndex = 0;
        int charBin = 0;
        int newCharFlag = 1;
        int startFlag = 1;
        for(int i=0; i<(int)tmp.size(); i++)
        {
            if(tmp[i] == '#' && !newCharFlag){
                if(charBin > 51){
                    cout << "ERROR" <<endl; 
                    break;
                }
                result[resultIndex++] = charTable[charBin];
                charBin = 0;
                newCharFlag = 1;
            } else if (tmp[i] == '.'){
                charBin = charBin << 1;
                charBin += 1;
                newCharFlag = 0;
                startFlag = 0;
            } else if (tmp[i] == '-'){
                charBin = charBin << 1;
                newCharFlag = 0;
                startFlag = 0;
            }
        }
        if(startFlag == 0){
            result[resultIndex++] = charTable[charBin];
        }
        result[resultIndex] = '\0';
        cout << result << endl;;
    }
}

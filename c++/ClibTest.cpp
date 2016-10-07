#include <iostream>
#include "Clib.h"
#include <fstream>  // 文件输入流，
#include <cassert>
#include <string>

using namespace std;

int main()
{
    CStash intStash, stringStash;
    const int bufsize = 80;
    initialize(&intStash, sizeof(int));
    for (int i = 0; i < 150; i++)
        add(&intStash, &i);
    for (int i = 0; i < count(&intStash); i++)
        cout << *(int*)fetch(&intStash, i) << endl;  // 利用指针将里边的数取出来，fetch是一个万能指针将其转化成int类型的，
    initialize(&stringStash, bufsize * sizeof(char));
    ifstream in;
    in.open("main.cpp");  // 这个是利用文件输入流去打开文件，
    assert(in);
    string line;
    while (getline(in, line))
        add(&stringStash, line.c_str());  // add 的第二个参数是c语言的指针，所以用c_str,
    int k = 0;
    char* cp;  //字符指针，
    while ((cp = (char*)fetch(&stringStash, k++)) != 0)
    cout << cp << endl;
    cleanup(&intStash);
    cleanup(&stringStash);
    //system("pause");
    return 0;
}

magic: 72303b3e
version: 1
globals.count: 13
g{0}:  1 : 6 
        getint
g{1}:  1 : 9 
        getdouble
g{2}:  1 : 7 
        getchar
g{3}:  1 : 6 
        putint
g{4}:  1 : 9 
        putdouble
g{5}:  1 : 7 
        putchar
g{6}:  1 : 6 
        putstr
g{7}:  1 : 5 
        putln
g{8}:  0 : 8 
        00        00        00        00        00        00        00        00
g{9}:  0 : 8 
        00        00        00        00        00        00        00        00
g{10}:  1 : 4 
        swap
g{11}:  1 : 4 
        main
g{12}:  1 : 6 
        _start
functions.count: 3
F{0}:     fn[0] 0 0 -> 0:
[0]            globa 8;
[1]            push 0;
[2]            store.64; 
[3]            globa 9;
[4]            push 1;
[5]            store.64; 
[6]            stackalloc 0;
[7]            call 2;
F{1}:     fn[10] 1 0 -> 0:
[0]            loca 0;
[1]            globa 8;
[2]            load.64; 
[3]            store.64; 
[4]            globa 8;
[5]            globa 9;
[6]            load.64; 
[7]            store.64; 
[8]            globa 9;
[9]            loca 0;
[10]            load.64; 
[11]            store.64; 
[12]            ret; 
F{2}:     fn[11] 0 0 -> 0:
[0]            globa 8;
[1]            stackalloc 1;
[2]            callname 0;
[3]            store.64; 
[4]            globa 9;
[5]            stackalloc 1;
[6]            callname 0;
[7]            store.64; 
[8]            stackalloc 0;
[9]            globa 8;
[10]            load.64; 
[11]            callname 3;
[12]            push 32;
[13]            stackalloc 0;
[14]            callname 5;
[15]            stackalloc 0;
[16]            globa 9;
[17]            load.64; 
[18]            callname 3;
[19]            stackalloc 0;
[20]            callname 7;
[21]            stackalloc 0;
[22]            call 1;
[23]            stackalloc 0;
[24]            globa 8;
[25]            load.64; 
[26]            callname 3;
[27]            push 32;
[28]            stackalloc 0;
[29]            callname 5;
[30]            stackalloc 0;
[31]            globa 9;
[32]            load.64; 
[33]            callname 3;
[34]            ret; 

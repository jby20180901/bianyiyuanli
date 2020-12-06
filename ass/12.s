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
g{9}:  1 : 3 
        foo
g{10}:  1 : 3 
        bar
g{11}:  1 : 4 
        main
g{12}:  1 : 6 
        _start
functions.count: 4
F{0}:     fn[0] 0 0 -> 0:
[0]            globa 8;
[1]            push 2;
[2]            store.64; 
[3]            stackalloc 0;
[4]            call 3;
F{1}:     fn[9] 1 0 -> 1:
[0]            loca 0;
[1]            push 1;
[2]            store.64; 
[3]            stackalloc 0;
[4]            loca 0;
[5]            load.64; 
[6]            callname 3;
[7]            stackalloc 0;
[8]            callname 7;
[9]            arga 0;
[10]            loca 0;
[11]            load.64; 
[12]            store.64; 
[13]            ret; 
F{2}:     fn[10] 0 0 -> 0:
[0]            stackalloc 0;
[1]            globa 8;
[2]            load.64; 
[3]            callname 3;
[4]            stackalloc 0;
[5]            callname 7;
[6]            globa 8;
[7]            globa 8;
[8]            load.64; 
[9]            push 1;
[10]            add.i; 
[11]            store.64; 
[12]            ret; 
F{3}:     fn[11] 1 0 -> 0:
[0]            loca 0;
[1]            push 1;
[2]            store.64; 
[3]            stackalloc 0;
[4]            loca 0;
[5]            load.64; 
[6]            callname 3;
[7]            stackalloc 0;
[8]            callname 7;
[9]            stackalloc 0;
[10]            stackalloc 1;
[11]            call 1;
[12]            callname 3;
[13]            stackalloc 0;
[14]            callname 7;
[15]            stackalloc 0;
[16]            call 2;
[17]            stackalloc 0;
[18]            call 2;
[19]            stackalloc 0;
[20]            call 2;
[21]            stackalloc 0;
[22]            stackalloc 1;
[23]            call 1;
[24]            callname 3;
[25]            stackalloc 0;
[26]            callname 7;
[27]            ret; 

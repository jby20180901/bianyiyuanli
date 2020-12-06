magic: 72303b3e
version: 1
globals.count: 10
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
g{8}:  1 : 4 
        main
g{9}:  1 : 6 
        _start
functions.count: 2
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 1;
F{1}:     fn[8] 3 0 -> 0:
[0]            loca 0;
[1]            push 1;
[2]            store.64; 
[3]            loca 1;
[4]            push 3;
[5]            store.64; 
[6]            stackalloc 0;
[7]            loca 1;
[8]            load.64; 
[9]            callname 3;
[10]            stackalloc 0;
[11]            callname 7;
[12]            loca 2;
[13]            loca 0;
[14]            load.64; 
[15]            loca 1;
[16]            load.64; 
[17]            add.i; 
[18]            store.64; 
[19]            stackalloc 0;
[20]            loca 2;
[21]            load.64; 
[22]            callname 3;
[23]            stackalloc 0;
[24]            callname 7;
[25]            stackalloc 0;
[26]            loca 1;
[27]            load.64; 
[28]            callname 3;
[29]            stackalloc 0;
[30]            callname 7;
[31]            ret; 

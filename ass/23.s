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
F{1}:     fn[8] 2 0 -> 0:
[0]            loca 0;
[1]            push 1;
[2]            store.64; 
[3]            stackalloc 0;
[4]            loca 0;
[5]            load.64; 
[6]            callname 3;
[7]            stackalloc 0;
[8]            callname 7;
[9]            loca 0;
[10]            loca 0;
[11]            load.64; 
[12]            push 1;
[13]            add.i; 
[14]            store.64; 
[15]            loca 0;
[16]            loca 0;
[17]            load.64; 
[18]            push 1;
[19]            add.i; 
[20]            store.64; 
[21]            stackalloc 0;
[22]            loca 0;
[23]            load.64; 
[24]            callname 3;
[25]            stackalloc 0;
[26]            callname 7;
[27]            loca 1;
[28]            push 999;
[29]            store.64; 
[30]            stackalloc 0;
[31]            loca 1;
[32]            load.64; 
[33]            callname 3;
[34]            stackalloc 0;
[35]            callname 7;
[36]            loca 1;
[37]            loca 1;
[38]            load.64; 
[39]            push 1;
[40]            add.i; 
[41]            store.64; 
[42]            stackalloc 0;
[43]            loca 1;
[44]            load.64; 
[45]            callname 3;
[46]            stackalloc 0;
[47]            callname 7;
[48]            stackalloc 0;
[49]            loca 0;
[50]            load.64; 
[51]            callname 3;
[52]            stackalloc 0;
[53]            callname 7;
[54]            ret; 

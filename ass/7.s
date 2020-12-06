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
[2]            neg.i; 
[3]            neg.i; 
[4]            neg.i; 
[5]            neg.i; 
[6]            store.64; 
[7]            loca 1;
[8]            push 2;
[9]            store.64; 
[10]            loca 2;
[11]            loca 0;
[12]            load.64; 
[13]            loca 1;
[14]            load.64; 
[15]            add.i; 
[16]            store.64; 
[17]            stackalloc 0;
[18]            loca 2;
[19]            load.64; 
[20]            callname 3;
[21]            ret; 

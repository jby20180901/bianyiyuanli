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
[1]            push 0;
[2]            store.64; 
[3]            loca 1;
[4]            push 1;
[5]            store.64; 
[6]            stackalloc 0;
[7]            loca 0;
[8]            load.64; 
[9]            loca 1;
[10]            load.64; 
[11]            add.i; 
[12]            callname 3;
[13]            ret; 

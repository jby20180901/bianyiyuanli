magic: 72303b3e
version: 1
globals.count: 12
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
        move
g{9}:  1 : 5 
        hanoi
g{10}:  1 : 4 
        main
g{11}:  1 : 6 
        _start
functions.count: 4
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 3;
F{1}:     fn[8] 0 3 -> 0:
[0]            stackalloc 0;
[1]            arga 0;
[2]            load.64; 
[3]            callname 3;
[4]            push 32;
[5]            stackalloc 0;
[6]            callname 5;
[7]            arga 1;
[8]            load.64; 
[9]            stackalloc 0;
[10]            callname 5;
[11]            push 32;
[12]            stackalloc 0;
[13]            callname 5;
[14]            arga 2;
[15]            load.64; 
[16]            stackalloc 0;
[17]            callname 5;
[18]            stackalloc 0;
[19]            callname 7;
[20]            ret; 
F{2}:     fn[9] 0 4 -> 0:
[0]            arga 0;
[1]            load.64; 
[2]            push 1;
[3]            cmp.i; 
[4]            not; 
[5]            br.true 1;
[6]            br 9;
[7]            stackalloc 0;
[8]            arga 0;
[9]            load.64; 
[10]            arga 1;
[11]            load.64; 
[12]            arga 3;
[13]            load.64; 
[14]            call 1;
[15]            br 33;
[16]            stackalloc 0;
[17]            arga 0;
[18]            load.64; 
[19]            push 1;
[20]            sub.i; 
[21]            arga 1;
[22]            load.64; 
[23]            arga 3;
[24]            load.64; 
[25]            arga 2;
[26]            load.64; 
[27]            call 2;
[28]            stackalloc 0;
[29]            arga 0;
[30]            load.64; 
[31]            arga 1;
[32]            load.64; 
[33]            arga 3;
[34]            load.64; 
[35]            call 1;
[36]            stackalloc 0;
[37]            arga 0;
[38]            load.64; 
[39]            push 1;
[40]            sub.i; 
[41]            arga 2;
[42]            load.64; 
[43]            arga 1;
[44]            load.64; 
[45]            arga 3;
[46]            load.64; 
[47]            call 2;
[48]            br 0;
[49]            br 0;
[50]            ret; 
F{3}:     fn[10] 0 0 -> 0:
[0]            stackalloc 0;
[1]            push 6;
[2]            push 65;
[3]            push 66;
[4]            push 67;
[5]            call 2;
[6]            ret; 

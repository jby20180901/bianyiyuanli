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
g{8}:  1 : 6 
        calcPi
g{9}:  1 : 5 
        calcE
g{10}:  1 : 4 
        main
g{11}:  1 : 6 
        _start
functions.count: 4
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 3;
F{1}:     fn[8] 3 0 -> 1:
[0]            loca 0;
[1]            push 1;
[2]            store.64; 
[3]            loca 1;
[4]            push 0;
[5]            store.64; 
[6]            loca 2;
[7]            push 1;
[8]            neg.i; 
[9]            store.64; 
[10]            br 0;
[11]            push 0;
[12]            loca 0;
[13]            load.64; 
[14]            itof; 
[15]            div.f; 
[16]            push 0;
[17]            cmp.f; 
[18]            set.gt; 
[19]            br.true 1;
[20]            br 24;
[21]            loca 1;
[22]            loca 1;
[23]            load.64; 
[24]            loca 2;
[25]            load.64; 
[26]            itof; 
[27]            loca 0;
[28]            load.64; 
[29]            itof; 
[30]            div.f; 
[31]            add.f; 
[32]            store.64; 
[33]            loca 0;
[34]            loca 0;
[35]            load.64; 
[36]            push 2;
[37]            add.i; 
[38]            store.64; 
[39]            loca 2;
[40]            loca 2;
[41]            load.64; 
[42]            neg.i; 
[43]            store.64; 
[44]            br -34;
[45]            arga 0;
[46]            loca 1;
[47]            load.64; 
[48]            push 0;
[49]            mul.f; 
[50]            store.64; 
[51]            ret; 
F{2}:     fn[9] 3 0 -> 1:
[0]            loca 0;
[1]            push 0;
[2]            store.64; 
[3]            loca 1;
[4]            push 1;
[5]            store.64; 
[6]            loca 2;
[7]            push 0;
[8]            store.64; 
[9]            br 0;
[10]            loca 1;
[11]            load.64; 
[12]            push 1000;
[13]            cmp.i; 
[14]            set.lt; 
[15]            br.true 1;
[16]            br 24;
[17]            loca 2;
[18]            loca 2;
[19]            load.64; 
[20]            loca 1;
[21]            load.64; 
[22]            itof; 
[23]            mul.f; 
[24]            store.64; 
[25]            loca 0;
[26]            loca 0;
[27]            load.64; 
[28]            push 0;
[29]            loca 2;
[30]            load.64; 
[31]            div.f; 
[32]            add.f; 
[33]            store.64; 
[34]            loca 1;
[35]            loca 1;
[36]            load.64; 
[37]            push 1;
[38]            add.i; 
[39]            store.64; 
[40]            br -31;
[41]            arga 0;
[42]            loca 0;
[43]            load.64; 
[44]            store.64; 
[45]            ret; 
F{3}:     fn[10] 0 0 -> 0:
[0]            stackalloc 0;
[1]            stackalloc 1;
[2]            call 1;
[3]            callname 4;
[4]            stackalloc 0;
[5]            callname 7;
[6]            stackalloc 0;
[7]            stackalloc 1;
[8]            call 2;
[9]            callname 4;
[10]            ret; 

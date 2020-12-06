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
        is_odd
g{9}:  1 : 7 
        fastpow
g{10}:  1 : 4 
        main
g{11}:  1 : 6 
        _start
functions.count: 4
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 3;
F{1}:     fn[8] 0 1 -> 1:
[0]            arga 0;
[1]            arga 1;
[2]            load.64; 
[3]            push 2;
[4]            div.i; 
[5]            push 2;
[6]            mul.i; 
[7]            arga 1;
[8]            load.64; 
[9]            sub.i; 
[10]            store.64; 
[11]            ret; 
F{2}:     fn[9] 1 2 -> 1:
[0]            loca 0;
[1]            push 1;
[2]            store.64; 
[3]            arga 2;
[4]            load.64; 
[5]            push 0;
[6]            cmp.i; 
[7]            set.lt; 
[8]            br.true 1;
[9]            br 5;
[10]            arga 0;
[11]            push 0;
[12]            store.64; 
[13]            ret; 
[14]            br 0;
[15]            br 0;
[16]            br 0;
[17]            arga 2;
[18]            load.64; 
[19]            push 0;
[20]            cmp.i; 
[21]            set.gt; 
[22]            br.true 1;
[23]            br 29;
[24]            stackalloc 1;
[25]            arga 2;
[26]            load.64; 
[27]            call 1;
[28]            br.true 1;
[29]            br 8;
[30]            loca 0;
[31]            loca 0;
[32]            load.64; 
[33]            arga 1;
[34]            load.64; 
[35]            mul.i; 
[36]            store.64; 
[37]            br 0;
[38]            br 0;
[39]            arga 1;
[40]            arga 1;
[41]            load.64; 
[42]            arga 1;
[43]            load.64; 
[44]            mul.i; 
[45]            store.64; 
[46]            arga 2;
[47]            arga 2;
[48]            load.64; 
[49]            push 2;
[50]            div.i; 
[51]            store.64; 
[52]            br -36;
[53]            arga 0;
[54]            loca 0;
[55]            load.64; 
[56]            store.64; 
[57]            ret; 
F{3}:     fn[10] 3 0 -> 0:
[0]            loca 0;
[1]            stackalloc 1;
[2]            callname 0;
[3]            store.64; 
[4]            br 0;
[5]            loca 0;
[6]            load.64; 
[7]            push 0;
[8]            cmp.i; 
[9]            set.gt; 
[10]            br.true 1;
[11]            br 25;
[12]            loca 1;
[13]            stackalloc 1;
[14]            callname 0;
[15]            store.64; 
[16]            loca 2;
[17]            stackalloc 1;
[18]            callname 0;
[19]            store.64; 
[20]            stackalloc 0;
[21]            stackalloc 1;
[22]            loca 1;
[23]            load.64; 
[24]            loca 2;
[25]            load.64; 
[26]            call 2;
[27]            callname 3;
[28]            stackalloc 0;
[29]            callname 7;
[30]            loca 0;
[31]            loca 0;
[32]            load.64; 
[33]            push 1;
[34]            sub.i; 
[35]            store.64; 
[36]            br -32;
[37]            ret; 

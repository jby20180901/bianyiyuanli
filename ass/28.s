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
[17]            push 1;
[18]            br.true 1;
[19]            br 39;
[20]            stackalloc 1;
[21]            arga 2;
[22]            load.64; 
[23]            call 1;
[24]            br.true 1;
[25]            br 8;
[26]            loca 0;
[27]            loca 0;
[28]            load.64; 
[29]            arga 1;
[30]            load.64; 
[31]            mul.i; 
[32]            store.64; 
[33]            br 0;
[34]            br 0;
[35]            arga 1;
[36]            arga 1;
[37]            load.64; 
[38]            arga 1;
[39]            load.64; 
[40]            mul.i; 
[41]            store.64; 
[42]            arga 2;
[43]            arga 2;
[44]            load.64; 
[45]            push 2;
[46]            div.i; 
[47]            store.64; 
[48]            arga 2;
[49]            load.64; 
[50]            push 0;
[51]            cmp.i; 
[52]            not; 
[53]            br.true 1;
[54]            br 2;
[55]            br 3;
[56]            br 0;
[57]            br 0;
[58]            br -42;
[59]            arga 0;
[60]            loca 0;
[61]            load.64; 
[62]            store.64; 
[63]            ret; 
F{3}:     fn[10] 3 0 -> 0:
[0]            loca 2;
[1]            stackalloc 1;
[2]            callname 0;
[3]            store.64; 
[4]            loca 2;
[5]            loca 2;
[6]            load.64; 
[7]            push 4;
[8]            mul.i; 
[9]            push 1;
[10]            add.i; 
[11]            store.64; 
[12]            br 0;
[13]            push 1;
[14]            br.true 1;
[15]            br 49;
[16]            stackalloc 1;
[17]            loca 2;
[18]            load.64; 
[19]            call 1;
[20]            br.true 1;
[21]            br 8;
[22]            loca 2;
[23]            loca 2;
[24]            load.64; 
[25]            push 3;
[26]            sub.i; 
[27]            store.64; 
[28]            br -16;
[29]            br 9;
[30]            loca 2;
[31]            load.64; 
[32]            push 0;
[33]            cmp.i; 
[34]            set.lt; 
[35]            br.true 1;
[36]            br 2;
[37]            br 27;
[38]            br 0;
[39]            br 0;
[40]            loca 0;
[41]            stackalloc 1;
[42]            callname 0;
[43]            store.64; 
[44]            loca 1;
[45]            stackalloc 1;
[46]            callname 0;
[47]            store.64; 
[48]            stackalloc 0;
[49]            stackalloc 1;
[50]            loca 0;
[51]            load.64; 
[52]            loca 1;
[53]            load.64; 
[54]            call 2;
[55]            callname 3;
[56]            stackalloc 0;
[57]            callname 7;
[58]            loca 2;
[59]            loca 2;
[60]            load.64; 
[61]            push 1;
[62]            sub.i; 
[63]            store.64; 
[64]            br -52;
[65]            ret; 

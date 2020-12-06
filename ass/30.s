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
F{1}:     fn[8] 1 0 -> 0:
[0]            loca 0;
[1]            push 10;
[2]            store.64; 
[3]            br 0;
[4]            loca 0;
[5]            load.64; 
[6]            push 0;
[7]            cmp.i; 
[8]            set.gt; 
[9]            br.true 1;
[10]            br 51;
[11]            loca 0;
[12]            loca 0;
[13]            load.64; 
[14]            push 1;
[15]            sub.i; 
[16]            store.64; 
[17]            loca 0;
[18]            load.64; 
[19]            push 8;
[20]            cmp.i; 
[21]            not; 
[22]            br.true 1;
[23]            br 5;
[24]            loca 0;
[25]            push 4;
[26]            store.64; 
[27]            br -24;
[28]            br 0;
[29]            br 0;
[30]            loca 0;
[31]            load.64; 
[32]            push 0;
[33]            cmp.i; 
[34]            not; 
[35]            br.true 1;
[36]            br 2;
[37]            br 24;
[38]            br 0;
[39]            br 0;
[40]            br 0;
[41]            push 1;
[42]            br.true 1;
[43]            br 17;
[44]            loca 0;
[45]            load.64; 
[46]            push 0;
[47]            cmp.i; 
[48]            set.gt; 
[49]            br.true 1;
[50]            br 8;
[51]            stackalloc 0;
[52]            loca 0;
[53]            load.64; 
[54]            callname 3;
[55]            stackalloc 0;
[56]            callname 7;
[57]            br 3;
[58]            br 0;
[59]            br 0;
[60]            br -20;
[61]            br -58;
[62]            ret; 

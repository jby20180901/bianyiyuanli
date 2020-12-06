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
g{8}:  1 : 8 
        is_digit
g{9}:  1 : 8 
        is_space
g{10}:  1 : 4 
        atoi
g{11}:  1 : 4 
        main
g{12}:  1 : 6 
        _start
functions.count: 5
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 4;
F{1}:     fn[8] 0 1 -> 1:
[0]            arga 1;
[1]            load.64; 
[2]            push 48;
[3]            cmp.i; 
[4]            set.lt; 
[5]            br.true 1;
[6]            br 5;
[7]            arga 0;
[8]            push 0;
[9]            store.64; 
[10]            ret; 
[11]            br 17;
[12]            arga 1;
[13]            load.64; 
[14]            push 57;
[15]            cmp.i; 
[16]            set.gt; 
[17]            br.true 1;
[18]            br 5;
[19]            arga 0;
[20]            push 0;
[21]            store.64; 
[22]            ret; 
[23]            br 5;
[24]            arga 0;
[25]            push 1;
[26]            store.64; 
[27]            ret; 
[28]            br 0;
[29]            br 0;
F{2}:     fn[9] 0 1 -> 1:
[0]            arga 1;
[1]            load.64; 
[2]            push 32;
[3]            cmp.i; 
[4]            not; 
[5]            br.true 1;
[6]            br 5;
[7]            arga 0;
[8]            push 1;
[9]            store.64; 
[10]            ret; 
[11]            br 41;
[12]            arga 1;
[13]            load.64; 
[14]            push 10;
[15]            cmp.i; 
[16]            not; 
[17]            br.true 1;
[18]            br 5;
[19]            arga 0;
[20]            push 1;
[21]            store.64; 
[22]            ret; 
[23]            br 29;
[24]            arga 1;
[25]            load.64; 
[26]            push 13;
[27]            cmp.i; 
[28]            not; 
[29]            br.true 1;
[30]            br 5;
[31]            arga 0;
[32]            push 1;
[33]            store.64; 
[34]            ret; 
[35]            br 17;
[36]            arga 1;
[37]            load.64; 
[38]            push 9;
[39]            cmp.i; 
[40]            not; 
[41]            br.true 1;
[42]            br 5;
[43]            arga 0;
[44]            push 1;
[45]            store.64; 
[46]            ret; 
[47]            br 5;
[48]            arga 0;
[49]            push 0;
[50]            store.64; 
[51]            ret; 
[52]            br 0;
[53]            br 0;
F{3}:     fn[10] 3 0 -> 1:
[0]            loca 1;
[1]            push 0;
[2]            store.64; 
[3]            loca 2;
[4]            push 0;
[5]            store.64; 
[6]            loca 0;
[7]            stackalloc 1;
[8]            callname 2;
[9]            store.64; 
[10]            br 0;
[11]            stackalloc 1;
[12]            loca 0;
[13]            load.64; 
[14]            call 2;
[15]            br.true 1;
[16]            br 5;
[17]            loca 0;
[18]            stackalloc 1;
[19]            callname 2;
[20]            store.64; 
[21]            br -11;
[22]            loca 0;
[23]            load.64; 
[24]            push 45;
[25]            cmp.i; 
[26]            not; 
[27]            br.true 1;
[28]            br 8;
[29]            loca 2;
[30]            push 1;
[31]            store.64; 
[32]            loca 0;
[33]            stackalloc 1;
[34]            callname 2;
[35]            store.64; 
[36]            br 0;
[37]            br 0;
[38]            br 0;
[39]            stackalloc 1;
[40]            loca 0;
[41]            load.64; 
[42]            call 1;
[43]            br.true 1;
[44]            br 16;
[45]            loca 1;
[46]            loca 1;
[47]            load.64; 
[48]            push 10;
[49]            mul.i; 
[50]            loca 0;
[51]            load.64; 
[52]            push 48;
[53]            sub.i; 
[54]            add.i; 
[55]            store.64; 
[56]            loca 0;
[57]            stackalloc 1;
[58]            callname 2;
[59]            store.64; 
[60]            br -22;
[61]            loca 2;
[62]            load.64; 
[63]            br.true 1;
[64]            br 6;
[65]            loca 1;
[66]            loca 1;
[67]            load.64; 
[68]            neg.i; 
[69]            store.64; 
[70]            br 0;
[71]            br 0;
[72]            arga 0;
[73]            loca 1;
[74]            load.64; 
[75]            store.64; 
[76]            ret; 
F{4}:     fn[11] 1 0 -> 0:
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
[11]            br 13;
[12]            stackalloc 0;
[13]            stackalloc 1;
[14]            call 3;
[15]            callname 3;
[16]            stackalloc 0;
[17]            callname 7;
[18]            loca 0;
[19]            loca 0;
[20]            load.64; 
[21]            push 1;
[22]            sub.i; 
[23]            store.64; 
[24]            br -20;
[25]            ret; 

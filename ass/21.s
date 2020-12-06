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
g{8}:  1 : 4 
        sqrt
g{9}:  1 : 3 
        mod
g{10}:  1 : 9 
        judge_mod
g{11}:  1 : 4 
        main
g{12}:  1 : 6 
        _start
functions.count: 5
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 4;
F{1}:     fn[8] 4 1 -> 1:
[0]            loca 0;
[1]            push 0;
[2]            store.64; 
[3]            loca 1;
[4]            arga 1;
[5]            load.64; 
[6]            store.64; 
[7]            br 0;
[8]            loca 1;
[9]            load.64; 
[10]            loca 0;
[11]            load.64; 
[12]            sub.f; 
[13]            push 0;
[14]            cmp.f; 
[15]            set.gt; 
[16]            br.true 1;
[17]            br 51;
[18]            loca 2;
[19]            loca 0;
[20]            load.64; 
[21]            loca 1;
[22]            load.64; 
[23]            add.f; 
[24]            push 0;
[25]            div.f; 
[26]            store.64; 
[27]            loca 3;
[28]            loca 2;
[29]            load.64; 
[30]            loca 2;
[31]            load.64; 
[32]            mul.f; 
[33]            store.64; 
[34]            loca 3;
[35]            load.64; 
[36]            arga 1;
[37]            load.64; 
[38]            cmp.f; 
[39]            not; 
[40]            br.true 1;
[41]            br 6;
[42]            arga 0;
[43]            loca 2;
[44]            load.64; 
[45]            store.64; 
[46]            ret; 
[47]            br 0;
[48]            br 0;
[49]            loca 3;
[50]            load.64; 
[51]            arga 1;
[52]            load.64; 
[53]            cmp.f; 
[54]            set.lt; 
[55]            br.true 1;
[56]            br 5;
[57]            loca 0;
[58]            loca 2;
[59]            load.64; 
[60]            store.64; 
[61]            br 5;
[62]            loca 1;
[63]            loca 2;
[64]            load.64; 
[65]            store.64; 
[66]            br 0;
[67]            br 0;
[68]            br -61;
[69]            arga 0;
[70]            loca 2;
[71]            load.64; 
[72]            store.64; 
[73]            ret; 
F{2}:     fn[9] 1 2 -> 1:
[0]            loca 0;
[1]            arga 1;
[2]            load.64; 
[3]            arga 2;
[4]            load.64; 
[5]            div.i; 
[6]            itof; 
[7]            ftoi; 
[8]            store.64; 
[9]            arga 0;
[10]            arga 1;
[11]            load.64; 
[12]            arga 2;
[13]            load.64; 
[14]            loca 0;
[15]            load.64; 
[16]            mul.i; 
[17]            sub.i; 
[18]            itof; 
[19]            ftoi; 
[20]            store.64; 
[21]            ret; 
F{3}:     fn[10] 0 3 -> 1:
[0]            arga 2;
[1]            load.64; 
[2]            arga 3;
[3]            load.64; 
[4]            cmp.i; 
[5]            set.gt; 
[6]            br.true 1;
[7]            br 5;
[8]            arga 0;
[9]            push 0;
[10]            store.64; 
[11]            ret; 
[12]            br 21;
[13]            stackalloc 1;
[14]            arga 1;
[15]            load.64; 
[16]            arga 2;
[17]            load.64; 
[18]            call 2;
[19]            push 0;
[20]            cmp.i; 
[21]            not; 
[22]            br.true 1;
[23]            br 5;
[24]            arga 0;
[25]            push 0;
[26]            store.64; 
[27]            ret; 
[28]            br 5;
[29]            arga 0;
[30]            push 1;
[31]            store.64; 
[32]            ret; 
[33]            br 0;
[34]            br 0;
F{4}:     fn[11] 5 0 -> 0:
[0]            loca 0;
[1]            stackalloc 1;
[2]            callname 0;
[3]            store.64; 
[4]            loca 1;
[5]            push 2;
[6]            store.64; 
[7]            br 0;
[8]            loca 1;
[9]            load.64; 
[10]            loca 0;
[11]            load.64; 
[12]            cmp.i; 
[13]            set.gt; 
[14]            br.false 1;
[15]            br 88;
[16]            stackalloc 1;
[17]            loca 1;
[18]            load.64; 
[19]            push 2;
[20]            call 2;
[21]            push 0;
[22]            cmp.i; 
[23]            br.true 1;
[24]            br 71;
[25]            loca 4;
[26]            stackalloc 1;
[27]            loca 1;
[28]            load.64; 
[29]            itof; 
[30]            call 1;
[31]            store.64; 
[32]            loca 3;
[33]            stackalloc 1;
[34]            loca 1;
[35]            load.64; 
[36]            itof; 
[37]            call 1;
[38]            ftoi; 
[39]            store.64; 
[40]            loca 4;
[41]            load.64; 
[42]            ftoi; 
[43]            loca 3;
[44]            load.64; 
[45]            cmp.i; 
[46]            br.true 1;
[47]            br 9;
[48]            stackalloc 0;
[49]            push 1;
[50]            neg.i; 
[51]            callname 3;
[52]            stackalloc 0;
[53]            callname 7;
[54]            arga 0;
[55]            ret; 
[56]            br 0;
[57]            br 0;
[58]            loca 2;
[59]            push 2;
[60]            store.64; 
[61]            br 0;
[62]            stackalloc 1;
[63]            loca 1;
[64]            load.64; 
[65]            loca 2;
[66]            load.64; 
[67]            loca 3;
[68]            load.64; 
[69]            call 3;
[70]            br.true 1;
[71]            br 7;
[72]            loca 2;
[73]            loca 2;
[74]            load.64; 
[75]            push 1;
[76]            add.i; 
[77]            store.64; 
[78]            br -17;
[79]            loca 2;
[80]            load.64; 
[81]            loca 3;
[82]            load.64; 
[83]            cmp.i; 
[84]            set.gt; 
[85]            br.true 1;
[86]            br 7;
[87]            stackalloc 0;
[88]            loca 1;
[89]            load.64; 
[90]            callname 3;
[91]            stackalloc 0;
[92]            callname 7;
[93]            br 0;
[94]            br 0;
[95]            br 0;
[96]            br 0;
[97]            loca 1;
[98]            loca 1;
[99]            load.64; 
[100]            push 1;
[101]            add.i; 
[102]            store.64; 
[103]            br -96;

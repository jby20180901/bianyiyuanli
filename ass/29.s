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
        main
g{9}:  1 : 20 
        Invalid instruction!
g{10}:  1 : 12 
        You cheated!
g{11}:  1 : 6 
        _start
functions.count: 2
F{0}:     fn[0] 0 0 -> 0:
[0]            stackalloc 0;
[1]            call 1;
F{1}:     fn[8] 5 0 -> 0:
[0]            loca 4;
[1]            stackalloc 1;
[2]            callname 0;
[3]            store.64; 
[4]            br 0;
[5]            loca 4;
[6]            load.64; 
[7]            push 0;
[8]            cmp.i; 
[9]            set.gt; 
[10]            br.true 1;
[11]            br 106;
[12]            loca 1;
[13]            stackalloc 1;
[14]            callname 0;
[15]            store.64; 
[16]            loca 2;
[17]            stackalloc 1;
[18]            callname 0;
[19]            store.64; 
[20]            loca 4;
[21]            loca 4;
[22]            load.64; 
[23]            push 1;
[24]            sub.i; 
[25]            store.64; 
[26]            br 0;
[27]            push 1;
[28]            br.true 1;
[29]            br 79;
[30]            loca 3;
[31]            loca 1;
[32]            load.64; 
[33]            loca 2;
[34]            load.64; 
[35]            add.i; 
[36]            push 1;
[37]            add.i; 
[38]            push 2;
[39]            div.i; 
[40]            store.64; 
[41]            loca 0;
[42]            stackalloc 1;
[43]            callname 0;
[44]            store.64; 
[45]            loca 0;
[46]            load.64; 
[47]            push 0;
[48]            cmp.i; 
[49]            not; 
[50]            br.true 1;
[51]            br 2;
[52]            br 56;
[53]            br 31;
[54]            loca 0;
[55]            load.64; 
[56]            push 1;
[57]            cmp.i; 
[58]            not; 
[59]            br.true 1;
[60]            br 5;
[61]            loca 2;
[62]            loca 3;
[63]            load.64; 
[64]            store.64; 
[65]            br 19;
[66]            loca 0;
[67]            load.64; 
[68]            push 2;
[69]            cmp.i; 
[70]            not; 
[71]            br.true 1;
[72]            br 5;
[73]            loca 1;
[74]            loca 3;
[75]            load.64; 
[76]            store.64; 
[77]            br 7;
[78]            stackalloc 0;
[79]            push 9;
[80]            callname 6;
[81]            stackalloc 0;
[82]            callname 7;
[83]            br -57;
[84]            br 0;
[85]            br 0;
[86]            loca 1;
[87]            load.64; 
[88]            loca 2;
[89]            load.64; 
[90]            cmp.i; 
[91]            not; 
[92]            br.true 1;
[93]            br 7;
[94]            stackalloc 0;
[95]            push 10;
[96]            callname 6;
[97]            stackalloc 0;
[98]            callname 7;
[99]            br 9;
[100]            br 0;
[101]            br 0;
[102]            stackalloc 0;
[103]            loca 3;
[104]            load.64; 
[105]            callname 3;
[106]            stackalloc 0;
[107]            callname 7;
[108]            br -82;
[109]            stackalloc 0;
[110]            loca 3;
[111]            load.64; 
[112]            callname 3;
[113]            stackalloc 0;
[114]            callname 7;
[115]            stackalloc 0;
[116]            callname 7;
[117]            br -113;
[118]            ret; 

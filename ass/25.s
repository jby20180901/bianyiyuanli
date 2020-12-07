magic: 72303b3e
version: 1
globals.count: 10
G{0}:     1 : 6 
        getint
G{1}:     1 : 9 
        getdouble
G{2}:     1 : 7 
        getchar
G{3}:     1 : 6 
        putint
G{4}:     1 : 9 
        putdouble
G{5}:     1 : 7 
        putchar
G{6}:     1 : 6 
        putstr
G{7}:     1 : 5 
        putln
G{8}:     1 : 4 
        main
G{9}:     1 : 6 
        _start
functions.count: 2
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 1
         }

F{1}:    fn[8] 6 0 -> 0 {
            [0] loca 0
            [1] stackalloc 1
            [2] callname 0
            [3] store.64
            [4] br 0
            [5] loca 0
            [6] load.64
            [7] push 0
            [8] cmp.i
            [9] set.gt
           [10] br.true 1
           [11] br 84
           [12] loca 2
           [13] push 0
           [14] store.64
           [15] loca 3
           [16] push 1024
           [17] store.64
           [18] loca 4
           [19] push 3
           [20] neg.i
           [21] store.64
           [22] loca 1
           [23] stackalloc 1
           [24] callname 0
           [25] store.64
           [26] br 0
           [27] loca 2
           [28] load.64
           [29] loca 3
           [30] load.64
           [31] cmp.i
           [32] br.true 1
           [33] br 53
           [34] loca 5
           [35] loca 2
           [36] load.64
           [37] loca 3
           [38] load.64
           [39] add.i
           [40] push 1
           [41] add.i
           [42] push 2
           [43] div.i
           [44] store.64
           [45] stackalloc 0
           [46] loca 5
           [47] load.64
           [48] callname 3
           [49] stackalloc 0
           [50] callname 7
           [51] loca 5
           [52] load.64
           [53] loca 1
           [54] load.64
           [55] cmp.i
           [56] set.gt
           [57] br.true 1
           [58] br 5
           [59] loca 3
           [60] loca 5
           [61] load.64
           [62] store.64
           [63] br 21
           [64] loca 5
           [65] load.64
           [66] loca 1
           [67] load.64
           [68] cmp.i
           [69] br.false 1
           [70] br 9
           [71] loca 2
           [72] loca 5
           [73] load.64
           [74] store.64
           [75] loca 3
           [76] loca 5
           [77] load.64
           [78] store.64
           [79] br 5
           [80] loca 2
           [81] loca 5
           [82] load.64
           [83] store.64
           [84] br 0
           [85] br 0
           [86] br -60
           [87] stackalloc 0
           [88] callname 7
           [89] loca 0
           [90] loca 0
           [91] load.64
           [92] push 1
           [93] sub.i
           [94] store.64
           [95] br -91
           [96] ret
         }


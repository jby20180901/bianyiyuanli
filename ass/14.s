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

F{1}:    fn[8] 4 0 -> 0 {
            [0] loca 1
            [1] push 0
            [2] store.64
            [3] loca 2
            [4] push 1024
            [5] store.64
            [6] loca 0
            [7] stackalloc 1
            [8] callname 0
            [9] store.64
           [10] br 0
           [11] loca 1
           [12] load.64
           [13] loca 2
           [14] load.64
           [15] cmp.i
           [16] br.true 1
           [17] br 53
           [18] loca 3
           [19] loca 1
           [20] load.64
           [21] loca 2
           [22] load.64
           [23] add.i
           [24] push 1
           [25] add.i
           [26] push 2
           [27] div.i
           [28] store.64
           [29] stackalloc 0
           [30] loca 3
           [31] load.64
           [32] callname 3
           [33] stackalloc 0
           [34] callname 7
           [35] loca 3
           [36] load.64
           [37] loca 0
           [38] load.64
           [39] cmp.i
           [40] set.gt
           [41] br.true 1
           [42] br 5
           [43] loca 2
           [44] loca 3
           [45] load.64
           [46] store.64
           [47] br 21
           [48] loca 3
           [49] load.64
           [50] loca 0
           [51] load.64
           [52] cmp.i
           [53] br.false 1
           [54] br 9
           [55] loca 1
           [56] loca 3
           [57] load.64
           [58] store.64
           [59] loca 2
           [60] loca 3
           [61] load.64
           [62] store.64
           [63] br 5
           [64] loca 1
           [65] loca 3
           [66] load.64
           [67] store.64
           [68] br 0
           [69] br 0
           [70] br -60
           [71] ret
         }


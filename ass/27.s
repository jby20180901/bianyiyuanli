magic: 72303b3e
version: 1
globals.count: 11
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
G{8}:     1 : 3 
        gcd
G{9}:     1 : 4 
        main
G{10}:    1 : 6 
        _start
functions.count: 3
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 2
         }

F{1}:    fn[8] 2 2 -> 1 {
            [0] arga 1
            [1] load.64
            [2] arga 2
            [3] load.64
            [4] cmp.i
            [5] set.gt
            [6] br.true 1
            [7] br 13
            [8] loca 0
            [9] arga 1
           [10] load.64
           [11] store.64
           [12] arga 1
           [13] arga 2
           [14] load.64
           [15] store.64
           [16] arga 2
           [17] loca 0
           [18] load.64
           [19] store.64
           [20] br 0
           [21] br 0
           [22] br 0
           [23] arga 1
           [24] load.64
           [25] push 0
           [26] cmp.i
           [27] br.true 1
           [28] br 30
           [29] br 0
           [30] arga 1
           [31] load.64
           [32] arga 2
           [33] load.64
           [34] cmp.i
           [35] set.gt
           [36] br.false 1
           [37] br 8
           [38] arga 2
           [39] arga 2
           [40] load.64
           [41] arga 1
           [42] load.64
           [43] sub.i
           [44] store.64
           [45] br -16
           [46] loca 1
           [47] arga 2
           [48] load.64
           [49] store.64
           [50] arga 2
           [51] arga 1
           [52] load.64
           [53] store.64
           [54] arga 1
           [55] loca 1
           [56] load.64
           [57] store.64
           [58] br -36
           [59] arga 0
           [60] arga 2
           [61] load.64
           [62] store.64
           [63] ret
         }

F{2}:    fn[9] 3 0 -> 0 {
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
           [11] br 25
           [12] loca 1
           [13] stackalloc 1
           [14] callname 0
           [15] store.64
           [16] loca 2
           [17] stackalloc 1
           [18] callname 0
           [19] store.64
           [20] stackalloc 0
           [21] stackalloc 1
           [22] loca 1
           [23] load.64
           [24] loca 2
           [25] load.64
           [26] call 1
           [27] callname 3
           [28] stackalloc 0
           [29] callname 7
           [30] loca 0
           [31] loca 0
           [32] load.64
           [33] push 1
           [34] sub.i
           [35] store.64
           [36] br -32
           [37] ret
         }


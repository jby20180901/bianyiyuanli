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

F{1}:    fn[8] 1 0 -> 0 {
            [0] loca 0
            [1] push 10
            [2] store.64
            [3] br 0
            [4] loca 0
            [5] load.64
            [6] push 0
            [7] cmp.i
            [8] set.gt
            [9] br.true 1
           [10] br 49
           [11] loca 0
           [12] loca 0
           [13] load.64
           [14] push 1
           [15] sub.i
           [16] store.64
           [17] loca 0
           [18] load.64
           [19] push 8
           [20] cmp.i
           [21] br.false 1
           [22] br 5
           [23] loca 0
           [24] push 4
           [25] store.64
           [26] br -23
           [27] br 0
           [28] br 0
           [29] loca 0
           [30] load.64
           [31] push 0
           [32] cmp.i
           [33] br.false 1
           [34] br 2
           [35] br 24
           [36] br 0
           [37] br 0
           [38] br 0
           [39] push 1
           [40] br.true 1
           [41] br 17
           [42] loca 0
           [43] load.64
           [44] push 0
           [45] cmp.i
           [46] set.gt
           [47] br.true 1
           [48] br 8
           [49] stackalloc 0
           [50] loca 0
           [51] load.64
           [52] callname 3
           [53] stackalloc 0
           [54] callname 7
           [55] br 3
           [56] br 0
           [57] br 0
           [58] br -20
           [59] br -56
           [60] ret
         }


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
        fib
G{9}:     1 : 4 
        main
G{10}:    1 : 6 
        _start
functions.count: 3
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 1
            [1] call 2
         }

F{1}:    fn[8] 0 1 -> 1 {
            [0] arga 1
            [1] load.64
            [2] push 0
            [3] cmp.i
            [4] set.lt
            [5] br.true 1
            [6] br 6
            [7] arga 0
            [8] push 1
            [9] neg.i
           [10] store.64
           [11] ret
           [12] br 41
           [13] arga 1
           [14] load.64
           [15] push 0
           [16] cmp.i
           [17] not
           [18] br.true 1
           [19] br 5
           [20] arga 0
           [21] push 0
           [22] store.64
           [23] ret
           [24] br 29
           [25] arga 1
           [26] load.64
           [27] push 1
           [28] cmp.i
           [29] not
           [30] br.true 1
           [31] br 5
           [32] arga 0
           [33] push 1
           [34] store.64
           [35] ret
           [36] br 17
           [37] arga 0
           [38] stackalloc 1
           [39] arga 1
           [40] load.64
           [41] push 2
           [42] sub.i
           [43] call 1
           [44] stackalloc 1
           [45] arga 1
           [46] load.64
           [47] push 1
           [48] sub.i
           [49] call 1
           [50] add.i
           [51] store.64
           [52] ret
           [53] br 0
           [54] br 0
         }

F{2}:    fn[9] 2 0 -> 1 {
            [0] loca 0
            [1] push 0
            [2] store.64
            [3] loca 1
            [4] push 0
            [5] store.64
            [6] loca 1
            [7] stackalloc 1
            [8] callname 0
            [9] store.64
           [10] loca 1
           [11] load.64
           [12] push 20
           [13] cmp.i
           [14] set.gt
           [15] br.true 1
           [16] br 4
           [17] loca 1
           [18] push 21
           [19] store.64
           [20] br 17
           [21] loca 1
           [22] load.64
           [23] push 0
           [24] cmp.i
           [25] set.lt
           [26] br.true 1
           [27] br 9
           [28] stackalloc 0
           [29] push 1
           [30] neg.i
           [31] callname 3
           [32] arga 0
           [33] push 0
           [34] store.64
           [35] ret
           [36] br 1
           [37] br 0
           [38] br 0
           [39] br 0
           [40] loca 0
           [41] load.64
           [42] loca 1
           [43] load.64
           [44] cmp.i
           [45] set.gt
           [46] br.false 1
           [47] br 15
           [48] stackalloc 0
           [49] stackalloc 1
           [50] loca 0
           [51] load.64
           [52] call 1
           [53] callname 3
           [54] stackalloc 0
           [55] callname 7
           [56] loca 0
           [57] loca 0
           [58] load.64
           [59] push 1
           [60] add.i
           [61] store.64
           [62] br -23
           [63] arga 0
           [64] push 0
           [65] store.64
           [66] ret
         }


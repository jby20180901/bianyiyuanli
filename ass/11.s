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

F{1}:    fn[8] 0 2 -> 1 {
            [0] arga 1
            [1] load.64
            [2] arga 2
            [3] load.64
            [4] cmp.i
            [5] set.gt
            [6] br.true 1
            [7] br 10
            [8] arga 0
            [9] stackalloc 1
           [10] arga 2
           [11] load.64
           [12] arga 1
           [13] load.64
           [14] call 1
           [15] store.64
           [16] ret
           [17] br 26
           [18] arga 1
           [19] load.64
           [20] push 0
           [21] cmp.i
           [22] not
           [23] br.true 1
           [24] br 6
           [25] arga 0
           [26] arga 2
           [27] load.64
           [28] store.64
           [29] ret
           [30] br 13
           [31] arga 0
           [32] stackalloc 1
           [33] arga 2
           [34] load.64
           [35] arga 1
           [36] load.64
           [37] sub.i
           [38] arga 1
           [39] load.64
           [40] call 1
           [41] store.64
           [42] ret
           [43] br 0
           [44] br 0
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


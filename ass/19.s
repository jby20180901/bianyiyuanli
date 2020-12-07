magic: 72303b3e
version: 1
globals.count: 14
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
G{8}:     1 : 5 
        itoch
G{9}:     1 : 6 
        modulo
G{10}:    1 : 10 
        div_modulo
G{11}:    1 : 4 
        itoa
G{12}:    1 : 4 
        main
G{13}:    1 : 6 
        _start
functions.count: 6
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 5
         }

F{1}:    fn[8] 0 1 -> 1 {
            [0] arga 1
            [1] load.64
            [2] push 10
            [3] cmp.i
            [4] set.lt
            [5] br.true 1
            [6] br 8
            [7] arga 0
            [8] push 48
            [9] arga 1
           [10] load.64
           [11] add.i
           [12] store.64
           [13] ret
           [14] br 10
           [15] arga 0
           [16] push 97
           [17] arga 1
           [18] load.64
           [19] add.i
           [20] push 10
           [21] sub.i
           [22] store.64
           [23] ret
           [24] br 0
           [25] br 0
         }

F{2}:    fn[9] 0 2 -> 1 {
            [0] arga 0
            [1] arga 1
            [2] load.64
            [3] arga 1
            [4] load.64
            [5] arga 2
            [6] load.64
            [7] div.i
            [8] arga 2
            [9] load.64
           [10] mul.i
           [11] sub.i
           [12] store.64
           [13] ret
         }

F{3}:    fn[10] 0 3 -> 1 {
            [0] br 0
            [1] arga 2
            [2] load.64
            [3] push 0
            [4] cmp.i
            [5] set.gt
            [6] br.true 1
            [7] br 14
            [8] arga 1
            [9] arga 1
           [10] load.64
           [11] arga 3
           [12] load.64
           [13] div.i
           [14] store.64
           [15] arga 2
           [16] arga 2
           [17] load.64
           [18] push 1
           [19] sub.i
           [20] store.64
           [21] br -21
           [22] arga 0
           [23] stackalloc 1
           [24] arga 1
           [25] load.64
           [26] arga 3
           [27] load.64
           [28] call 2
           [29] store.64
           [30] ret
         }

F{4}:    fn[11] 2 2 -> 0 {
            [0] loca 0
            [1] push 0
            [2] store.64
            [3] arga 0
            [4] load.64
            [5] push 0
            [6] cmp.i
            [7] set.lt
            [8] br.true 1
            [9] br 9
           [10] arga 0
           [11] arga 0
           [12] load.64
           [13] neg.i
           [14] store.64
           [15] push 45
           [16] stackalloc 0
           [17] callname 5
           [18] br 0
           [19] br 0
           [20] loca 1
           [21] arga 0
           [22] load.64
           [23] store.64
           [24] loca 1
           [25] load.64
           [26] push 0
           [27] cmp.i
           [28] not
           [29] br.true 1
           [30] br 4
           [31] loca 0
           [32] push 1
           [33] store.64
           [34] br 23
           [35] br 0
           [36] loca 1
           [37] load.64
           [38] push 0
           [39] cmp.i
           [40] set.gt
           [41] br.true 1
           [42] br 14
           [43] loca 1
           [44] loca 1
           [45] load.64
           [46] arga 1
           [47] load.64
           [48] div.i
           [49] store.64
           [50] loca 0
           [51] loca 0
           [52] load.64
           [53] push 1
           [54] add.i
           [55] store.64
           [56] br -21
           [57] br 0
           [58] br 0
           [59] br 0
           [60] loca 0
           [61] load.64
           [62] push 0
           [63] cmp.i
           [64] set.gt
           [65] br.true 1
           [66] br 19
           [67] loca 0
           [68] loca 0
           [69] load.64
           [70] push 1
           [71] sub.i
           [72] store.64
           [73] stackalloc 1
           [74] stackalloc 1
           [75] arga 0
           [76] load.64
           [77] loca 0
           [78] load.64
           [79] arga 1
           [80] load.64
           [81] call 3
           [82] call 1
           [83] stackalloc 0
           [84] callname 5
           [85] br -26
           [86] ret
         }

F{5}:    fn[12] 3 0 -> 0 {
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
           [11] br 23
           [12] loca 2
           [13] stackalloc 1
           [14] callname 0
           [15] store.64
           [16] loca 1
           [17] stackalloc 1
           [18] callname 0
           [19] store.64
           [20] stackalloc 0
           [21] loca 2
           [22] load.64
           [23] loca 1
           [24] load.64
           [25] call 4
           [26] stackalloc 0
           [27] callname 7
           [28] loca 0
           [29] loca 0
           [30] load.64
           [31] push 1
           [32] sub.i
           [33] store.64
           [34] br -30
           [35] ret
         }


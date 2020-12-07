magic: 72303b3e
version: 1
globals.count: 10
G{0}:     1 : 6 
         `g` `e` `t` `i` `n` `t`
G{1}:     1 : 9 
         `g` `e` `t` `d` `o` `u` `b` `l` `e`
G{2}:     1 : 7 
         `g` `e` `t` `c` `h` `a` `r`
G{3}:     1 : 6 
         `p` `u` `t` `i` `n` `t`
G{4}:     1 : 9 
         `p` `u` `t` `d` `o` `u` `b` `l` `e`
G{5}:     1 : 7 
         `p` `u` `t` `c` `h` `a` `r`
G{6}:     1 : 6 
         `p` `u` `t` `s` `t` `r`
G{7}:     1 : 5 
         `p` `u` `t` `l` `n`
G{8}:     1 : 4 
         `m` `a` `i` `n`
G{9}:     1 : 6 
         `_` `s` `t` `a` `r` `t`
functions.count: 2
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 1
         }

F{1}:    fn[8] 2 0 -> 0 {
            [0] loca 0
            [1] push 0
            [2] store.64
            [3] br 0
            [4] loca 0
            [5] load.64
            [6] push 10
            [7] cmp.i
            [8] set.lt
            [9] br.true 1
           [10] br 59
           [11] loca 1
           [12] push 0
           [13] store.64
           [14] br 0
           [15] loca 1
           [16] load.64
           [17] push 9
           [18] loca 0
           [19] load.64
           [20] sub.i
           [21] cmp.i
           [22] set.lt
           [23] br.true 1
           [24] br 10
           [25] push 32
           [26] stackalloc 0
           [27] callname 5
           [28] loca 1
           [29] loca 1
           [30] load.64
           [31] push 1
           [32] add.i
           [33] store.64
           [34] br -20
           [35] loca 1
           [36] push 0
           [37] store.64
           [38] br 0
           [39] loca 1
           [40] load.64
           [41] push 2
           [42] loca 0
           [43] load.64
           [44] mul.i
           [45] push 1
           [46] add.i
           [47] cmp.i
           [48] set.lt
           [49] br.true 1
           [50] br 10
           [51] push 42
           [52] stackalloc 0
           [53] callname 5
           [54] loca 1
           [55] loca 1
           [56] load.64
           [57] push 1
           [58] add.i
           [59] store.64
           [60] br -22
           [61] stackalloc 0
           [62] callname 7
           [63] loca 0
           [64] loca 0
           [65] load.64
           [66] push 1
           [67] add.i
           [68] store.64
           [69] br -66
           [70] ret
         }


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
            [0] stackalloc 1
            [1] call 1
         }

F{1}:    fn[8] 2 0 -> 1 {
            [0] loca 0
            [1] stackalloc 1
            [2] callname 0
            [3] store.64
            [4] loca 1
            [5] stackalloc 1
            [6] callname 0
            [7] store.64
            [8] loca 0
            [9] load.64
           [10] push 0
           [11] cmp.i
           [12] set.gt
           [13] br.true 1
           [14] br 66
           [15] loca 1
           [16] load.64
           [17] push 0
           [18] cmp.i
           [19] set.gt
           [20] br.true 1
           [21] br 40
           [22] br 0
           [23] loca 1
           [24] load.64
           [25] push 0
           [26] cmp.i
           [27] set.gt
           [28] br.true 1
           [29] br 19
           [30] loca 1
           [31] loca 1
           [32] load.64
           [33] push 1
           [34] sub.i
           [35] store.64
           [36] loca 1
           [37] load.64
           [38] push 3
           [39] cmp.i
           [40] br.false 1
           [41] br 5
           [42] arga 0
           [43] push 1
           [44] store.64
           [45] ret
           [46] br 0
           [47] br 0
           [48] br -26
           [49] loca 0
           [50] load.64
           [51] push 2
           [52] cmp.i
           [53] br.false 1
           [54] br 5
           [55] arga 0
           [56] push 3
           [57] store.64
           [58] ret
           [59] br 0
           [60] br 0
           [61] br 17
           [62] loca 0
           [63] load.64
           [64] push 4
           [65] cmp.i
           [66] br.false 1
           [67] br 5
           [68] arga 0
           [69] push 5
           [70] store.64
           [71] ret
           [72] br 0
           [73] br 0
           [74] arga 0
           [75] push 6
           [76] store.64
           [77] ret
           [78] br 0
           [79] br 0
           [80] br 6
           [81] arga 0
           [82] push 1
           [83] neg.i
           [84] store.64
           [85] ret
           [86] br 0
           [87] br 0
         }


magic: 72303b3e
version: 1
globals.count: 12
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
G{9}:     1 : 20 
         `I` `n` `v` `a` `l` `i` `d` ` ` `i` `n` `s` `t` `r` `u` `c` `t` `i` `o` `n` `!`
G{10}:    1 : 12 
         `Y` `o` `u` ` ` `c` `h` `e` `a` `t` `e` `d` `!`
G{11}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
functions.count: 2
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 1
         }

F{1}:    fn[8] 5 0 -> 0 {
            [0] loca 4
            [1] stackalloc 1
            [2] callname 0
            [3] store.64
            [4] br 0
            [5] loca 4
            [6] load.64
            [7] push 0
            [8] cmp.i
            [9] set.gt
           [10] br.true 1
           [11] br 102
           [12] loca 1
           [13] stackalloc 1
           [14] callname 0
           [15] store.64
           [16] loca 2
           [17] stackalloc 1
           [18] callname 0
           [19] store.64
           [20] loca 4
           [21] loca 4
           [22] load.64
           [23] push 1
           [24] sub.i
           [25] store.64
           [26] br 0
           [27] push 1
           [28] br.true 1
           [29] br 75
           [30] loca 3
           [31] loca 1
           [32] load.64
           [33] loca 2
           [34] load.64
           [35] add.i
           [36] push 1
           [37] add.i
           [38] push 2
           [39] div.i
           [40] store.64
           [41] loca 0
           [42] stackalloc 1
           [43] callname 0
           [44] store.64
           [45] loca 0
           [46] load.64
           [47] push 0
           [48] cmp.i
           [49] br.false 1
           [50] br 2
           [51] br 53
           [52] br 29
           [53] loca 0
           [54] load.64
           [55] push 1
           [56] cmp.i
           [57] br.false 1
           [58] br 5
           [59] loca 2
           [60] loca 3
           [61] load.64
           [62] store.64
           [63] br 18
           [64] loca 0
           [65] load.64
           [66] push 2
           [67] cmp.i
           [68] br.false 1
           [69] br 5
           [70] loca 1
           [71] loca 3
           [72] load.64
           [73] store.64
           [74] br 7
           [75] stackalloc 0
           [76] push 9
           [77] callname 6
           [78] stackalloc 0
           [79] callname 7
           [80] br -54
           [81] br 0
           [82] br 0
           [83] loca 1
           [84] load.64
           [85] loca 2
           [86] load.64
           [87] cmp.i
           [88] br.false 1
           [89] br 7
           [90] stackalloc 0
           [91] push 10
           [92] callname 6
           [93] stackalloc 0
           [94] callname 7
           [95] br 9
           [96] br 0
           [97] br 0
           [98] stackalloc 0
           [99] loca 3
          [100] load.64
          [101] callname 3
          [102] stackalloc 0
          [103] callname 7
          [104] br -78
          [105] stackalloc 0
          [106] loca 3
          [107] load.64
          [108] callname 3
          [109] stackalloc 0
          [110] callname 7
          [111] stackalloc 0
          [112] callname 7
          [113] br -109
          [114] ret
         }


magic: 72303b3e
version: 1
globals.count: 13
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
         `s` `q` `r` `t`
G{9}:     1 : 3 
         `m` `o` `d`
G{10}:    1 : 9 
         `j` `u` `d` `g` `e` `_` `m` `o` `d`
G{11}:    1 : 4 
         `m` `a` `i` `n`
G{12}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
functions.count: 5
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 4
         }

F{1}:    fn[8] 4 1 -> 1 {
            [0] loca 0
            [1] push 0
            [2] store.64
            [3] loca 1
            [4] arga 1
            [5] load.64
            [6] store.64
            [7] br 0
            [8] loca 1
            [9] load.64
           [10] loca 0
           [11] load.64
           [12] sub.f
           [13] push 4517329193108106637
           [14] cmp.f
           [15] set.gt
           [16] br.true 1
           [17] br 50
           [18] loca 2
           [19] loca 0
           [20] load.64
           [21] loca 1
           [22] load.64
           [23] add.f
           [24] push 4611686018427387904
           [25] div.f
           [26] store.64
           [27] loca 3
           [28] loca 2
           [29] load.64
           [30] loca 2
           [31] load.64
           [32] mul.f
           [33] store.64
           [34] loca 3
           [35] load.64
           [36] arga 1
           [37] load.64
           [38] cmp.f
           [39] br.false 1
           [40] br 6
           [41] arga 0
           [42] loca 2
           [43] load.64
           [44] store.64
           [45] ret
           [46] br 0
           [47] br 0
           [48] loca 3
           [49] load.64
           [50] arga 1
           [51] load.64
           [52] cmp.f
           [53] set.lt
           [54] br.true 1
           [55] br 5
           [56] loca 0
           [57] loca 2
           [58] load.64
           [59] store.64
           [60] br 5
           [61] loca 1
           [62] loca 2
           [63] load.64
           [64] store.64
           [65] br 0
           [66] br 0
           [67] br -60
           [68] arga 0
           [69] loca 2
           [70] load.64
           [71] store.64
           [72] ret
         }

F{2}:    fn[9] 1 2 -> 1 {
            [0] loca 0
            [1] arga 1
            [2] load.64
            [3] arga 2
            [4] load.64
            [5] div.i
            [6] itof
            [7] ftoi
            [8] store.64
            [9] arga 0
           [10] arga 1
           [11] load.64
           [12] arga 2
           [13] load.64
           [14] loca 0
           [15] load.64
           [16] mul.i
           [17] sub.i
           [18] itof
           [19] ftoi
           [20] store.64
           [21] ret
         }

F{3}:    fn[10] 0 3 -> 1 {
            [0] arga 2
            [1] load.64
            [2] arga 3
            [3] load.64
            [4] cmp.i
            [5] set.gt
            [6] br.true 1
            [7] br 5
            [8] arga 0
            [9] push 0
           [10] store.64
           [11] ret
           [12] br 20
           [13] stackalloc 1
           [14] arga 1
           [15] load.64
           [16] arga 2
           [17] load.64
           [18] call 2
           [19] push 0
           [20] cmp.i
           [21] br.false 1
           [22] br 5
           [23] arga 0
           [24] push 0
           [25] store.64
           [26] ret
           [27] br 5
           [28] arga 0
           [29] push 1
           [30] store.64
           [31] ret
           [32] br 0
           [33] br 0
         }

F{4}:    fn[11] 5 0 -> 0 {
            [0] loca 0
            [1] stackalloc 1
            [2] callname 0
            [3] store.64
            [4] loca 1
            [5] push 2
            [6] store.64
            [7] br 0
            [8] loca 1
            [9] load.64
           [10] loca 0
           [11] load.64
           [12] cmp.i
           [13] set.gt
           [14] br.false 1
           [15] br 88
           [16] stackalloc 1
           [17] loca 1
           [18] load.64
           [19] push 2
           [20] call 2
           [21] push 0
           [22] cmp.i
           [23] br.true 1
           [24] br 71
           [25] loca 4
           [26] stackalloc 1
           [27] loca 1
           [28] load.64
           [29] itof
           [30] call 1
           [31] store.64
           [32] loca 3
           [33] stackalloc 1
           [34] loca 1
           [35] load.64
           [36] itof
           [37] call 1
           [38] ftoi
           [39] store.64
           [40] loca 4
           [41] load.64
           [42] ftoi
           [43] loca 3
           [44] load.64
           [45] cmp.i
           [46] br.true 1
           [47] br 9
           [48] stackalloc 0
           [49] push 1
           [50] neg.i
           [51] callname 3
           [52] stackalloc 0
           [53] callname 7
           [54] arga 0
           [55] ret
           [56] br 0
           [57] br 0
           [58] loca 2
           [59] push 2
           [60] store.64
           [61] br 0
           [62] stackalloc 1
           [63] loca 1
           [64] load.64
           [65] loca 2
           [66] load.64
           [67] loca 3
           [68] load.64
           [69] call 3
           [70] br.true 1
           [71] br 7
           [72] loca 2
           [73] loca 2
           [74] load.64
           [75] push 1
           [76] add.i
           [77] store.64
           [78] br -17
           [79] loca 2
           [80] load.64
           [81] loca 3
           [82] load.64
           [83] cmp.i
           [84] set.gt
           [85] br.true 1
           [86] br 7
           [87] stackalloc 0
           [88] loca 1
           [89] load.64
           [90] callname 3
           [91] stackalloc 0
           [92] callname 7
           [93] br 0
           [94] br 0
           [95] br 0
           [96] br 0
           [97] loca 1
           [98] loca 1
           [99] load.64
          [100] push 1
          [101] add.i
          [102] store.64
          [103] br -96
          [104] ret
         }


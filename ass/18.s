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
G{8}:     1 : 8 
         `i` `s` `_` `d` `i` `g` `i` `t`
G{9}:     1 : 8 
         `i` `s` `_` `s` `p` `a` `c` `e`
G{10}:    1 : 4 
         `a` `t` `o` `i`
G{11}:    1 : 4 
         `m` `a` `i` `n`
G{12}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
functions.count: 5
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 4
         }

F{1}:    fn[8] 0 1 -> 1 {
            [0] arga 1
            [1] load.64
            [2] push 48
            [3] cmp.i
            [4] set.lt
            [5] br.true 1
            [6] br 5
            [7] arga 0
            [8] push 0
            [9] store.64
           [10] ret
           [11] br 17
           [12] arga 1
           [13] load.64
           [14] push 57
           [15] cmp.i
           [16] set.gt
           [17] br.true 1
           [18] br 5
           [19] arga 0
           [20] push 0
           [21] store.64
           [22] ret
           [23] br 5
           [24] arga 0
           [25] push 1
           [26] store.64
           [27] ret
           [28] br 0
           [29] br 0
         }

F{2}:    fn[9] 0 1 -> 1 {
            [0] arga 1
            [1] load.64
            [2] push 32
            [3] cmp.i
            [4] br.false 1
            [5] br 5
            [6] arga 0
            [7] push 1
            [8] store.64
            [9] ret
           [10] br 38
           [11] arga 1
           [12] load.64
           [13] push 10
           [14] cmp.i
           [15] br.false 1
           [16] br 5
           [17] arga 0
           [18] push 1
           [19] store.64
           [20] ret
           [21] br 27
           [22] arga 1
           [23] load.64
           [24] push 13
           [25] cmp.i
           [26] br.false 1
           [27] br 5
           [28] arga 0
           [29] push 1
           [30] store.64
           [31] ret
           [32] br 16
           [33] arga 1
           [34] load.64
           [35] push 9
           [36] cmp.i
           [37] br.false 1
           [38] br 5
           [39] arga 0
           [40] push 1
           [41] store.64
           [42] ret
           [43] br 5
           [44] arga 0
           [45] push 0
           [46] store.64
           [47] ret
           [48] br 0
           [49] br 0
         }

F{3}:    fn[10] 3 0 -> 1 {
            [0] loca 1
            [1] push 0
            [2] store.64
            [3] loca 2
            [4] push 0
            [5] store.64
            [6] loca 0
            [7] stackalloc 1
            [8] callname 2
            [9] store.64
           [10] br 0
           [11] stackalloc 1
           [12] loca 0
           [13] load.64
           [14] call 2
           [15] br.true 1
           [16] br 5
           [17] loca 0
           [18] stackalloc 1
           [19] callname 2
           [20] store.64
           [21] br -11
           [22] loca 0
           [23] load.64
           [24] push 45
           [25] cmp.i
           [26] br.false 1
           [27] br 8
           [28] loca 2
           [29] push 1
           [30] store.64
           [31] loca 0
           [32] stackalloc 1
           [33] callname 2
           [34] store.64
           [35] br 0
           [36] br 0
           [37] br 0
           [38] stackalloc 1
           [39] loca 0
           [40] load.64
           [41] call 1
           [42] br.true 1
           [43] br 16
           [44] loca 1
           [45] loca 1
           [46] load.64
           [47] push 10
           [48] mul.i
           [49] loca 0
           [50] load.64
           [51] push 48
           [52] sub.i
           [53] add.i
           [54] store.64
           [55] loca 0
           [56] stackalloc 1
           [57] callname 2
           [58] store.64
           [59] br -22
           [60] loca 2
           [61] load.64
           [62] br.true 1
           [63] br 6
           [64] loca 1
           [65] loca 1
           [66] load.64
           [67] neg.i
           [68] store.64
           [69] br 0
           [70] br 0
           [71] arga 0
           [72] loca 1
           [73] load.64
           [74] store.64
           [75] ret
         }

F{4}:    fn[11] 1 0 -> 0 {
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
           [11] br 13
           [12] stackalloc 0
           [13] stackalloc 1
           [14] call 3
           [15] callname 3
           [16] stackalloc 0
           [17] callname 7
           [18] loca 0
           [19] loca 0
           [20] load.64
           [21] push 1
           [22] sub.i
           [23] store.64
           [24] br -20
           [25] ret
         }


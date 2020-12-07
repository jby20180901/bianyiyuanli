magic: 72303b3e
version: 1
globals.count: 11
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
G{8}:     1 : 3 
         `g` `c` `d`
G{9}:     1 : 4 
         `m` `a` `i` `n`
G{10}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
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
           [17] br 25
           [18] arga 1
           [19] load.64
           [20] push 0
           [21] cmp.i
           [22] br.false 1
           [23] br 6
           [24] arga 0
           [25] arga 2
           [26] load.64
           [27] store.64
           [28] ret
           [29] br 13
           [30] arga 0
           [31] stackalloc 1
           [32] arga 2
           [33] load.64
           [34] arga 1
           [35] load.64
           [36] sub.i
           [37] arga 1
           [38] load.64
           [39] call 1
           [40] store.64
           [41] ret
           [42] br 0
           [43] br 0
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


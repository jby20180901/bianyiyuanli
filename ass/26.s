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

F{1}:    fn[8] 3 0 -> 0 {
            [0] loca 0
            [1] push 1
            [2] store.64
            [3] loca 1
            [4] push 3
            [5] store.64
            [6] stackalloc 0
            [7] loca 1
            [8] load.64
            [9] callname 3
           [10] stackalloc 0
           [11] callname 7
           [12] loca 2
           [13] loca 0
           [14] load.64
           [15] loca 1
           [16] load.64
           [17] add.i
           [18] store.64
           [19] stackalloc 0
           [20] loca 2
           [21] load.64
           [22] callname 3
           [23] stackalloc 0
           [24] callname 7
           [25] stackalloc 0
           [26] loca 1
           [27] load.64
           [28] callname 3
           [29] stackalloc 0
           [30] callname 7
           [31] ret
         }


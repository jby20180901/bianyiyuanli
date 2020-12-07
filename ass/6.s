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
         `a` `d` `d`
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
            [0] arga 0
            [1] arga 1
            [2] load.64
            [3] arga 2
            [4] load.64
            [5] add.i
            [6] store.64
            [7] ret
         }

F{2}:    fn[9] 3 0 -> 0 {
            [0] loca 0
            [1] stackalloc 1
            [2] callname 0
            [3] store.64
            [4] loca 1
            [5] stackalloc 1
            [6] callname 0
            [7] store.64
            [8] loca 2
            [9] stackalloc 1
           [10] loca 0
           [11] load.64
           [12] loca 1
           [13] load.64
           [14] call 1
           [15] store.64
           [16] stackalloc 0
           [17] loca 2
           [18] load.64
           [19] callname 3
           [20] ret
         }


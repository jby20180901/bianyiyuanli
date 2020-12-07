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
            [2] neg.i
            [3] neg.i
            [4] neg.i
            [5] neg.i
            [6] store.64
            [7] loca 1
            [8] push 2
            [9] store.64
           [10] loca 2
           [11] loca 0
           [12] load.64
           [13] loca 1
           [14] load.64
           [15] add.i
           [16] store.64
           [17] stackalloc 0
           [18] loca 2
           [19] load.64
           [20] callname 3
           [21] ret
         }


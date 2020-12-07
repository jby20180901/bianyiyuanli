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
G{8}:     0 : 8 
         00 00 00 00 00 00 00 00
G{9}:     1 : 3 
         `f` `o` `o`
G{10}:    1 : 3 
         `b` `a` `r`
G{11}:    1 : 4 
         `m` `a` `i` `n`
G{12}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
functions.count: 4
F{0}:    fn[0] 0 0 -> 0 {
            [0] globa 8
            [1] push 2
            [2] store.64
            [3] stackalloc 0
            [4] call 3
         }

F{1}:    fn[9] 1 0 -> 1 {
            [0] loca 0
            [1] push 1
            [2] store.64
            [3] stackalloc 0
            [4] loca 0
            [5] load.64
            [6] callname 3
            [7] stackalloc 0
            [8] callname 7
            [9] arga 0
           [10] loca 0
           [11] load.64
           [12] store.64
           [13] ret
         }

F{2}:    fn[10] 0 0 -> 0 {
            [0] stackalloc 0
            [1] globa 8
            [2] load.64
            [3] callname 3
            [4] stackalloc 0
            [5] callname 7
            [6] globa 8
            [7] globa 8
            [8] load.64
            [9] push 1
           [10] add.i
           [11] store.64
           [12] ret
         }

F{3}:    fn[11] 1 0 -> 0 {
            [0] loca 0
            [1] push 1
            [2] store.64
            [3] stackalloc 0
            [4] loca 0
            [5] load.64
            [6] callname 3
            [7] stackalloc 0
            [8] callname 7
            [9] stackalloc 0
           [10] stackalloc 1
           [11] call 1
           [12] callname 3
           [13] stackalloc 0
           [14] callname 7
           [15] stackalloc 0
           [16] call 2
           [17] stackalloc 0
           [18] call 2
           [19] stackalloc 0
           [20] call 2
           [21] stackalloc 0
           [22] stackalloc 1
           [23] call 1
           [24] callname 3
           [25] stackalloc 0
           [26] callname 7
           [27] ret
         }


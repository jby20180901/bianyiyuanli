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

F{1}:    fn[8] 1 0 -> 1 {
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
           [11] br 15
           [12] loca 0
           [13] load.64
           [14] push 2
           [15] div.i
           [16] push 0
           [17] cmp.i
           [18] br.false 1
           [19] br 5
           [20] arga 0
           [21] push 2
           [22] store.64
           [23] ret
           [24] br 0
           [25] br 0
           [26] br -22
         }


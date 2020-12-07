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
         `m` `o` `v` `e`
G{9}:     1 : 5 
         `h` `a` `n` `o` `i`
G{10}:    1 : 4 
         `m` `a` `i` `n`
G{11}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
functions.count: 4
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 3
         }

F{1}:    fn[8] 0 3 -> 0 {
            [0] stackalloc 0
            [1] arga 0
            [2] load.64
            [3] callname 3
            [4] push 32
            [5] stackalloc 0
            [6] callname 5
            [7] arga 1
            [8] load.64
            [9] stackalloc 0
           [10] callname 5
           [11] push 32
           [12] stackalloc 0
           [13] callname 5
           [14] arga 2
           [15] load.64
           [16] stackalloc 0
           [17] callname 5
           [18] stackalloc 0
           [19] callname 7
           [20] ret
         }

F{2}:    fn[9] 0 4 -> 0 {
            [0] arga 0
            [1] load.64
            [2] push 1
            [3] cmp.i
            [4] br.false 1
            [5] br 9
            [6] stackalloc 0
            [7] arga 0
            [8] load.64
            [9] arga 1
           [10] load.64
           [11] arga 3
           [12] load.64
           [13] call 1
           [14] br 33
           [15] stackalloc 0
           [16] arga 0
           [17] load.64
           [18] push 1
           [19] sub.i
           [20] arga 1
           [21] load.64
           [22] arga 3
           [23] load.64
           [24] arga 2
           [25] load.64
           [26] call 2
           [27] stackalloc 0
           [28] arga 0
           [29] load.64
           [30] arga 1
           [31] load.64
           [32] arga 3
           [33] load.64
           [34] call 1
           [35] stackalloc 0
           [36] arga 0
           [37] load.64
           [38] push 1
           [39] sub.i
           [40] arga 2
           [41] load.64
           [42] arga 1
           [43] load.64
           [44] arga 3
           [45] load.64
           [46] call 2
           [47] br 0
           [48] br 0
           [49] ret
         }

F{3}:    fn[10] 0 0 -> 0 {
            [0] stackalloc 0
            [1] push 6
            [2] push 65
            [3] push 66
            [4] push 67
            [5] call 2
            [6] ret
         }


magic: 72303b3e
version: 1
globals.count: 11
G{0}:     1 : 6 
        getint
G{1}:     1 : 9 
        getdouble
G{2}:     1 : 7 
        getchar
G{3}:     1 : 6 
        putint
G{4}:     1 : 9 
        putdouble
G{5}:     1 : 7 
        putchar
G{6}:     1 : 6 
        putstr
G{7}:     1 : 5 
        putln
G{8}:     1 : 3 
        add
G{9}:     1 : 4 
        main
G{10}:    1 : 6 
        _start
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


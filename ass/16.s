magic: 72303b3e
version: 1
globals.count: 10
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
G{8}:     1 : 4 
        main
G{9}:     1 : 6 
        _start
functions.count: 2
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 1
         }

F{1}:    fn[8] 2 0 -> 0 {
            [0] loca 0
            [1] push 0
            [2] store.64
            [3] loca 1
            [4] push 1
            [5] store.64
            [6] stackalloc 0
            [7] loca 0
            [8] load.64
            [9] loca 1
           [10] load.64
           [11] add.i
           [12] callname 3
           [13] ret
         }


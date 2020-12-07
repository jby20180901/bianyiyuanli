magic: 72303b3e
version: 1
globals.count: 29
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
G{8}:     1 : 8 
        00        00        00        00        00        00        00        00
G{9}:     1 : 8 
        00        00        00        00        00        00        00        00
G{10}:    1 : 8 
        00        00        00        00        00        00        00        00
G{11}:    1 : 8 
        00        00        00        00        00        00        00        00
G{12}:    1 : 8 
        00        00        00        00        00        00        00        00
G{13}:    0 : 8 
        00        00        00        00        00        00        00        00
G{14}:    0 : 8 
        00        00        00        00        00        00        00        00
G{15}:    0 : 8 
        00        00        00        00        00        00        00        00
G{16}:    0 : 8 
        00        00        00        00        00        00        00        00
G{17}:    0 : 8 
        00        00        00        00        00        00        00        00
G{18}:    0 : 8 
        00        00        00        00        00        00        00        00
G{19}:    1 : 1 
        f
G{20}:    1 : 6 
        random
G{21}:    1 : 10 
        approx_exp
G{22}:    1 : 5 
        judge
G{23}:    1 : 10 
        run_anneal
G{24}:    1 : 6 
        round=
G{25}:    1 : 6 
         temp=
G{26}:    1 : 7 
         value=
G{27}:    1 : 4 
        main
G{28}:    1 : 6 
        _start
functions.count: 7
F{0}:    fn[0] 0 0 -> 0 {
            [0] globa 8
            [1] push 1000000009
            [2] store.64
            [3] globa 9
            [4] push 1919839
            [5] store.64
            [6] globa 10
            [7] push 4562254508917369340
            [8] store.64
            [9] globa 11
           [10] push 4611686018427387904
           [11] neg.f
           [12] store.64
           [13] globa 12
           [14] push 4611686018427387904
           [15] store.64
           [16] globa 13
           [17] push 19260817
           [18] store.64
           [19] globa 16
           [20] push 4656185812347138133
           [21] store.64
           [22] globa 18
           [23] push 4666723172467343360
           [24] store.64
           [25] stackalloc 0
           [26] call 6
         }

F{1}:    fn[19] 0 1 -> 1 {
            [0] arga 0
            [1] push 4613937818241073152
            [2] arga 1
            [3] load.64
            [4] arga 1
            [5] load.64
            [6] mul.f
            [7] sub.f
            [8] store.64
            [9] ret
         }

F{2}:    fn[20] 1 0 -> 1 {
            [0] globa 13
            [1] globa 13
            [2] load.64
            [3] globa 13
            [4] load.64
            [5] push 8192
            [6] mul.i
            [7] add.i
            [8] store.64
            [9] globa 13
           [10] globa 13
           [11] load.64
           [12] globa 13
           [13] load.64
           [14] push 131072
           [15] div.i
           [16] add.i
           [17] store.64
           [18] globa 13
           [19] globa 13
           [20] load.64
           [21] globa 13
           [22] load.64
           [23] push 32
           [24] mul.i
           [25] add.i
           [26] store.64
           [27] loca 0
           [28] globa 13
           [29] load.64
           [30] push 65536
           [31] div.i
           [32] store.64
           [33] loca 0
           [34] load.64
           [35] push 0
           [36] cmp.i
           [37] set.lt
           [38] br.true 1
           [39] br 6
           [40] loca 0
           [41] loca 0
           [42] load.64
           [43] neg.i
           [44] store.64
           [45] br 0
           [46] br 0
           [47] arga 0
           [48] loca 0
           [49] load.64
           [50] itof
           [51] push 281474976710656
           [52] itof
           [53] div.f
           [54] store.64
           [55] ret
         }

F{3}:    fn[21] 1 1 -> 1 {
            [0] arga 1
            [1] load.64
            [2] push 4591870180066957722
            [3] cmp.f
            [4] set.gt
            [5] br.true 1
            [6] br 17
            [7] loca 0
            [8] stackalloc 1
            [9] arga 1
           [10] load.64
           [11] push 4611686018427387904
           [12] div.f
           [13] call 3
           [14] store.64
           [15] arga 0
           [16] arga 1
           [17] load.64
           [18] arga 1
           [19] load.64
           [20] mul.f
           [21] store.64
           [22] ret
           [23] br 52
           [24] arga 1
           [25] load.64
           [26] push 4591870180066957722
           [27] neg.f
           [28] cmp.f
           [29] set.lt
           [30] br.true 1
           [31] br 17
           [32] loca 0
           [33] stackalloc 1
           [34] arga 1
           [35] load.64
           [36] push 4611686018427387904
           [37] div.f
           [38] call 3
           [39] store.64
           [40] arga 0
           [41] arga 1
           [42] load.64
           [43] arga 1
           [44] load.64
           [45] mul.f
           [46] store.64
           [47] ret
           [48] br 27
           [49] arga 0
           [50] arga 1
           [51] load.64
           [52] push 4613937818241073152
           [53] add.f
           [54] arga 1
           [55] load.64
           [56] push 4613937818241073152
           [57] add.f
           [58] mul.f
           [59] push 4613937818241073152
           [60] add.f
           [61] arga 1
           [62] load.64
           [63] push 4613937818241073152
           [64] sub.f
           [65] arga 1
           [66] load.64
           [67] push 4613937818241073152
           [68] sub.f
           [69] mul.f
           [70] push 4613937818241073152
           [71] add.f
           [72] div.f
           [73] store.64
           [74] ret
           [75] br 0
           [76] br 0
         }

F{4}:    fn[22] 0 2 -> 1 {
            [0] arga 1
            [1] load.64
            [2] push 0
            [3] cmp.f
            [4] set.lt
            [5] br.true 1
            [6] br 5
            [7] arga 0
            [8] push 1
            [9] store.64
           [10] ret
           [11] br 28
           [12] stackalloc 1
           [13] arga 1
           [14] load.64
           [15] neg.f
           [16] arga 2
           [17] load.64
           [18] div.f
           [19] push 4625196817309499392
           [20] div.f
           [21] call 3
           [22] stackalloc 1
           [23] call 2
           [24] cmp.f
           [25] set.gt
           [26] br.true 1
           [27] br 5
           [28] arga 0
           [29] push 1
           [30] store.64
           [31] ret
           [32] br 5
           [33] arga 0
           [34] push 0
           [35] store.64
           [36] ret
           [37] br 0
           [38] br 0
           [39] br 0
           [40] br 0
         }

F{5}:    fn[23] 3 0 -> 1 {
            [0] loca 2
            [1] push 0
            [2] store.64
            [3] globa 14
            [4] stackalloc 1
            [5] call 2
            [6] globa 12
            [7] load.64
            [8] globa 11
            [9] load.64
           [10] sub.f
           [11] mul.f
           [12] globa 11
           [13] load.64
           [14] add.f
           [15] store.64
           [16] globa 15
           [17] globa 14
           [18] load.64
           [19] store.64
           [20] globa 16
           [21] stackalloc 1
           [22] globa 14
           [23] load.64
           [24] call 1
           [25] store.64
           [26] globa 17
           [27] globa 16
           [28] load.64
           [29] store.64
           [30] br 0
           [31] globa 18
           [32] load.64
           [33] push 4562254508917369340
           [34] cmp.f
           [35] set.gt
           [36] br.true 1
           [37] br 128
           [38] loca 0
           [39] stackalloc 1
           [40] call 2
           [41] push 4602678819172646912
           [42] sub.f
           [43] push 4616189618054758400
           [44] mul.f
           [45] store.64
           [46] globa 15
           [47] globa 14
           [48] load.64
           [49] loca 0
           [50] load.64
           [51] add.f
           [52] store.64
           [53] globa 15
           [54] load.64
           [55] globa 12
           [56] load.64
           [57] cmp.f
           [58] set.gt
           [59] br.true 1
           [60] br 10
           [61] globa 15
           [62] globa 15
           [63] load.64
           [64] push 4611686018427387904
           [65] loca 0
           [66] load.64
           [67] mul.f
           [68] sub.f
           [69] store.64
           [70] br 18
           [71] globa 15
           [72] load.64
           [73] globa 11
           [74] load.64
           [75] cmp.f
           [76] set.lt
           [77] br.true 1
           [78] br 10
           [79] globa 15
           [80] globa 15
           [81] load.64
           [82] push 4611686018427387904
           [83] loca 0
           [84] load.64
           [85] mul.f
           [86] sub.f
           [87] store.64
           [88] br 0
           [89] br 0
           [90] globa 17
           [91] stackalloc 1
           [92] globa 15
           [93] load.64
           [94] call 1
           [95] store.64
           [96] loca 1
           [97] globa 16
           [98] load.64
           [99] globa 17
          [100] load.64
          [101] sub.f
          [102] store.64
          [103] stackalloc 1
          [104] loca 1
          [105] load.64
          [106] globa 18
          [107] load.64
          [108] call 4
          [109] br.true 1
          [110] br 9
          [111] globa 16
          [112] globa 17
          [113] load.64
          [114] store.64
          [115] globa 14
          [116] globa 15
          [117] load.64
          [118] store.64
          [119] br 0
          [120] br 0
          [121] loca 1
          [122] load.64
          [123] push 0
          [124] cmp.f
          [125] set.lt
          [126] br.true 1
          [127] br 30
          [128] globa 18
          [129] globa 18
          [130] load.64
          [131] push 4607002274814922588
          [132] mul.f
          [133] store.64
          [134] stackalloc 0
          [135] push 24
          [136] callname 6
          [137] stackalloc 0
          [138] loca 2
          [139] load.64
          [140] callname 3
          [141] stackalloc 0
          [142] push 25
          [143] callname 6
          [144] stackalloc 0
          [145] globa 18
          [146] load.64
          [147] callname 4
          [148] stackalloc 0
          [149] push 26
          [150] callname 6
          [151] stackalloc 0
          [152] globa 16
          [153] load.64
          [154] callname 4
          [155] stackalloc 0
          [156] callname 7
          [157] br 0
          [158] br 0
          [159] loca 2
          [160] loca 2
          [161] load.64
          [162] push 1
          [163] add.i
          [164] store.64
          [165] br -135
          [166] arga 0
          [167] globa 16
          [168] load.64
          [169] store.64
          [170] ret
         }

F{6}:    fn[27] 0 0 -> 0 {
            [0] stackalloc 0
            [1] stackalloc 1
            [2] call 5
            [3] callname 4
            [4] ret
         }


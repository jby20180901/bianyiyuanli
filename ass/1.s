magic: 72303b3e
version: 1
globals.count: 15
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
G{8}:     0 : 8 
        00        00        00        00        00        00        00        00
G{9}:     0 : 8 
        00        00        00        00        00        00        00        00
G{10}:    0 : 8 
        00        00        00        00        00        00        00        00
G{11}:    0 : 8 
        00        00        00        00        00        00        00        00
G{12}:    1 : 10 
        EightWhile
G{13}:    1 : 4 
        main
G{14}:    1 : 6 
        _start
functions.count: 3
F{0}:    fn[0] 0 0 -> 0 {
            [0] stackalloc 0
            [1] call 2
         }

F{1}:    fn[12] 4 0 -> 1 {
            [0] loca 0
            [1] push 5
            [2] store.64
            [3] loca 1
            [4] push 6
            [5] store.64
            [6] loca 2
            [7] push 7
            [8] store.64
            [9] loca 3
           [10] push 10
           [11] store.64
           [12] br 0
           [13] loca 0
           [14] load.64
           [15] push 20
           [16] cmp.i
           [17] set.lt
           [18] br.true 1
           [19] br 154
           [20] loca 0
           [21] loca 0
           [22] load.64
           [23] push 3
           [24] add.i
           [25] store.64
           [26] br 0
           [27] loca 1
           [28] load.64
           [29] push 10
           [30] cmp.i
           [31] set.lt
           [32] br.true 1
           [33] br 133
           [34] loca 1
           [35] loca 1
           [36] load.64
           [37] push 1
           [38] add.i
           [39] store.64
           [40] br 0
           [41] loca 2
           [42] load.64
           [43] push 7
           [44] cmp.i
           [45] not
           [46] br.true 1
           [47] br 112
           [48] loca 2
           [49] loca 2
           [50] load.64
           [51] push 1
           [52] sub.i
           [53] store.64
           [54] br 0
           [55] loca 3
           [56] load.64
           [57] push 20
           [58] cmp.i
           [59] set.lt
           [60] br.true 1
           [61] br 91
           [62] loca 3
           [63] loca 3
           [64] load.64
           [65] push 3
           [66] add.i
           [67] store.64
           [68] br 0
           [69] globa 11
           [70] load.64
           [71] push 1
           [72] cmp.i
           [73] set.gt
           [74] br.true 1
           [75] br 70
           [76] globa 11
           [77] globa 11
           [78] load.64
           [79] push 1
           [80] sub.i
           [81] store.64
           [82] br 0
           [83] globa 10
           [84] load.64
           [85] push 2
           [86] cmp.i
           [87] set.gt
           [88] br.true 1
           [89] br 49
           [90] globa 10
           [91] globa 10
           [92] load.64
           [93] push 2
           [94] sub.i
           [95] store.64
           [96] br 0
           [97] globa 8
           [98] load.64
           [99] push 3
          [100] cmp.i
          [101] set.lt
          [102] br.true 1
          [103] br 28
          [104] globa 8
          [105] globa 8
          [106] load.64
          [107] push 10
          [108] add.i
          [109] store.64
          [110] br 0
          [111] globa 9
          [112] load.64
          [113] push 10
          [114] cmp.i
          [115] set.lt
          [116] br.true 1
          [117] br 7
          [118] globa 9
          [119] globa 9
          [120] load.64
          [121] push 8
          [122] add.i
          [123] store.64
          [124] br -14
          [125] globa 9
          [126] globa 9
          [127] load.64
          [128] push 1
          [129] sub.i
          [130] store.64
          [131] br -35
          [132] globa 8
          [133] globa 8
          [134] load.64
          [135] push 8
          [136] sub.i
          [137] store.64
          [138] br -56
          [139] globa 10
          [140] globa 10
          [141] load.64
          [142] push 1
          [143] add.i
          [144] store.64
          [145] br -77
          [146] globa 11
          [147] globa 11
          [148] load.64
          [149] push 1
          [150] add.i
          [151] store.64
          [152] br -98
          [153] loca 3
          [154] loca 3
          [155] load.64
          [156] push 1
          [157] sub.i
          [158] store.64
          [159] br -119
          [160] loca 2
          [161] loca 2
          [162] load.64
          [163] push 1
          [164] add.i
          [165] store.64
          [166] br -140
          [167] loca 1
          [168] loca 1
          [169] load.64
          [170] push 2
          [171] sub.i
          [172] store.64
          [173] br -161
          [174] arga 0
          [175] loca 0
          [176] load.64
          [177] loca 1
          [178] load.64
          [179] loca 3
          [180] load.64
          [181] add.i
          [182] add.i
          [183] loca 2
          [184] load.64
          [185] add.i
          [186] globa 11
          [187] load.64
          [188] loca 3
          [189] load.64
          [190] add.i
          [191] globa 8
          [192] load.64
          [193] sub.i
          [194] globa 9
          [195] load.64
          [196] add.i
          [197] sub.i
          [198] store.64
          [199] ret
         }

F{2}:    fn[13] 0 0 -> 0 {
            [0] globa 8
            [1] push 1
            [2] store.64
            [3] globa 9
            [4] push 2
            [5] store.64
            [6] globa 11
            [7] push 4
            [8] store.64
            [9] globa 10
           [10] push 6
           [11] store.64
           [12] stackalloc 0
           [13] stackalloc 1
           [14] call 1
           [15] callname 3
           [16] ret
         }


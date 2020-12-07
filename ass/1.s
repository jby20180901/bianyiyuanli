magic: 72303b3e
version: 1
globals.count: 15
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
G{9}:     0 : 8 
         00 00 00 00 00 00 00 00
G{10}:    0 : 8 
         00 00 00 00 00 00 00 00
G{11}:    0 : 8 
         00 00 00 00 00 00 00 00
G{12}:    1 : 10 
         `E` `i` `g` `h` `t` `W` `h` `i` `l` `e`
G{13}:    1 : 4 
         `m` `a` `i` `n`
G{14}:    1 : 6 
         `_` `s` `t` `a` `r` `t`
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
           [19] br 153
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
           [33] br 132
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
           [45] br.false 1
           [46] br 112
           [47] loca 2
           [48] loca 2
           [49] load.64
           [50] push 1
           [51] sub.i
           [52] store.64
           [53] br 0
           [54] loca 3
           [55] load.64
           [56] push 20
           [57] cmp.i
           [58] set.lt
           [59] br.true 1
           [60] br 91
           [61] loca 3
           [62] loca 3
           [63] load.64
           [64] push 3
           [65] add.i
           [66] store.64
           [67] br 0
           [68] globa 11
           [69] load.64
           [70] push 1
           [71] cmp.i
           [72] set.gt
           [73] br.true 1
           [74] br 70
           [75] globa 11
           [76] globa 11
           [77] load.64
           [78] push 1
           [79] sub.i
           [80] store.64
           [81] br 0
           [82] globa 10
           [83] load.64
           [84] push 2
           [85] cmp.i
           [86] set.gt
           [87] br.true 1
           [88] br 49
           [89] globa 10
           [90] globa 10
           [91] load.64
           [92] push 2
           [93] sub.i
           [94] store.64
           [95] br 0
           [96] globa 8
           [97] load.64
           [98] push 3
           [99] cmp.i
          [100] set.lt
          [101] br.true 1
          [102] br 28
          [103] globa 8
          [104] globa 8
          [105] load.64
          [106] push 10
          [107] add.i
          [108] store.64
          [109] br 0
          [110] globa 9
          [111] load.64
          [112] push 10
          [113] cmp.i
          [114] set.lt
          [115] br.true 1
          [116] br 7
          [117] globa 9
          [118] globa 9
          [119] load.64
          [120] push 8
          [121] add.i
          [122] store.64
          [123] br -14
          [124] globa 9
          [125] globa 9
          [126] load.64
          [127] push 1
          [128] sub.i
          [129] store.64
          [130] br -35
          [131] globa 8
          [132] globa 8
          [133] load.64
          [134] push 8
          [135] sub.i
          [136] store.64
          [137] br -56
          [138] globa 10
          [139] globa 10
          [140] load.64
          [141] push 1
          [142] add.i
          [143] store.64
          [144] br -77
          [145] globa 11
          [146] globa 11
          [147] load.64
          [148] push 1
          [149] add.i
          [150] store.64
          [151] br -98
          [152] loca 3
          [153] loca 3
          [154] load.64
          [155] push 1
          [156] sub.i
          [157] store.64
          [158] br -118
          [159] loca 2
          [160] loca 2
          [161] load.64
          [162] push 1
          [163] add.i
          [164] store.64
          [165] br -139
          [166] loca 1
          [167] loca 1
          [168] load.64
          [169] push 2
          [170] sub.i
          [171] store.64
          [172] br -160
          [173] arga 0
          [174] loca 0
          [175] load.64
          [176] loca 1
          [177] load.64
          [178] loca 3
          [179] load.64
          [180] add.i
          [181] add.i
          [182] loca 2
          [183] load.64
          [184] add.i
          [185] globa 11
          [186] load.64
          [187] loca 3
          [188] load.64
          [189] add.i
          [190] globa 8
          [191] load.64
          [192] sub.i
          [193] globa 9
          [194] load.64
          [195] add.i
          [196] sub.i
          [197] store.64
          [198] ret
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


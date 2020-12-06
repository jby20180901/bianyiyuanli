72303b3e//magic
00000001//version
00000004//globals.count
01 //is_count
00000006//value.count
63616c635069//calcPi
01 //is_count
00000005//value.count
63616c6345//calcE
01 //is_count
00000004//value.count
6d61696e//main
01 //is_count
00000006//value.count
5f7374617274//_start
00000004//functions.count
00000000//nameOffset
00000000//ret_slots
00000000//param_slots
00000000//loc_slots
00000002//body.count
1a00000000//stackalloc 0
4800000003//call 3
00000000//nameOffset
00000001//ret_slots
00000000//param_slots
00000006//loc_slots
0000002f//body.count
0a00000000//loca 0
010000000000000001//push 1
17//store.64
0a00000002//loca 2
010000000000000000//push 0
17//store.64
0a00000004//loca 4
010000000000000001//push 1
17//store.64
4100000000//br 0
010000000000000000//push 0
0a00000000//loca 0
13//load.64
27//div.f
010000000000000000//push 0
32//cmp.f
3a//set.gt
4300000001//br.true 1
4100000015//br 21
0a00000002//loca 2
0a00000002//loca 2
13//load.64
0a00000004//loca 4
13//load.64
0a00000000//loca 0
13//load.64
27//div.f
24//add.f
17//store.64
0a00000000//loca 0
0a00000000//loca 0
13//load.64
010000000000000002//push 2
20//add.i
17//store.64
0a00000004//loca 4
0a00000004//loca 4
13//load.64
17//store.64
41ffffffe2//br -30
0b00000000//arga 0
0a00000002//loca 2
13//load.64
010000000000000000//push 0
26//mul.f
17//store.64
49//ret
00000001//nameOffset
00000001//ret_slots
00000000//param_slots
00000006//loc_slots
0000002d//body.count
0a00000000//loca 0
010000000000000000//push 0
17//store.64
0a00000002//loca 2
010000000000000001//push 1
17//store.64
0a00000004//loca 4
010000000000000000//push 0
17//store.64
4100000000//br 0
0a00000002//loca 2
13//load.64
0100000000000003e8//push 1000
30//cmp.i
39//set.lt
4300000001//br.true 1
4100000017//br 23
0a00000004//loca 4
0a00000004//loca 4
13//load.64
0a00000002//loca 2
13//load.64
26//mul.f
17//store.64
0a00000000//loca 0
0a00000000//loca 0
13//load.64
010000000000000000//push 0
0a00000004//loca 4
13//load.64
27//div.f
24//add.f
17//store.64
0a00000002//loca 2
0a00000002//loca 2
13//load.64
010000000000000001//push 1
20//add.i
17//store.64
41ffffffe2//br -30
0b00000000//arga 0
0a00000000//loca 0
13//load.64
17//store.64
49//ret
00000002//nameOffset
00000000//ret_slots
00000000//param_slots
00000000//loc_slots
00000008//body.count
1a00000000//stackalloc 0
4800000003//call 3
56//print.f
58//println
1a00000000//stackalloc 0
4800000003//call 3
56//print.f
49//ret

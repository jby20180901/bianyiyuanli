72303b3e//magic
00000001//version
00000003//globals.count
01 //is_count
00000003//value.count
666962//fib
01 //is_count
00000004//value.count
6d61696e//main
01 //is_count
00000006//value.count
5f7374617274//_start
00000003//functions.count
00000000//nameOffset
00000000//ret_slots
00000000//param_slots
00000000//loc_slots
00000002//body.count
1a00000001//stackalloc 1
4800000002//call 2
00000000//nameOffset
00000001//ret_slots
00000000//param_slots
00000000//loc_slots
00000036//body.count
0b00000001//arga 1
13//load.64
010000000000000000//push 0
30//cmp.i
39//set.lt
4300000001//br.true 1
4100000005//br 5
0b00000000//arga 0
010000000000000001//push 1
17//store.64
49//ret
4100000029//br 41
0b00000001//arga 1
13//load.64
010000000000000000//push 0
30//cmp.i
2e//not
4300000001//br.true 1
4100000005//br 5
0b00000000//arga 0
010000000000000000//push 0
17//store.64
49//ret
410000001d//br 29
0b00000001//arga 1
13//load.64
010000000000000001//push 1
30//cmp.i
2e//not
4300000001//br.true 1
4100000005//br 5
0b00000000//arga 0
010000000000000001//push 1
17//store.64
49//ret
4100000011//br 17
0b00000000//arga 0
1a00000001//stackalloc 1
0b00000001//arga 1
13//load.64
010000000000000002//push 2
21//sub.i
4800000001//call 1
1a00000001//stackalloc 1
0b00000001//arga 1
13//load.64
010000000000000001//push 1
21//sub.i
4800000001//call 1
20//add.i
17//store.64
49//ret
4100000000//br 0
4100000000//br 0
00000001//nameOffset
00000001//ret_slots
00000000//param_slots
00000004//loc_slots
0000003d//body.count
0a00000000//loca 0
010000000000000000//push 0
17//store.64
0a00000002//loca 2
010000000000000000//push 0
17//store.64
0a00000002//loca 2
17//store.64
0a00000002//loca 2
13//load.64
010000000000000014//push 20
30//cmp.i
3a//set.gt
4300000001//br.true 1
4100000004//br 4
0a00000002//loca 2
010000000000000015//push 21
17//store.64
410000000f//br 15
0a00000002//loca 2
13//load.64
010000000000000000//push 0
30//cmp.i
39//set.lt
4300000001//br.true 1
4100000007//br 7
010000000000000001//push 1
54//print.i
0b00000000//arga 0
010000000000000000//push 0
17//store.64
49//ret
4100000001//br 1
4100000000//br 0
4100000000//br 0
4100000000//br 0
0a00000000//loca 0
13//load.64
0a00000002//loca 2
13//load.64
30//cmp.i
3a//set.gt
4200000001//br.false 1
410000000d//br 13
1a00000001//stackalloc 1
0a00000000//loca 0
13//load.64
4800000002//call 2
54//print.i
58//println
0a00000000//loca 0
0a00000000//loca 0
13//load.64
010000000000000001//push 1
20//add.i
17//store.64
41ffffffeb//br -21
0b00000000//arga 0
010000000000000000//push 0
17//store.64
49//ret

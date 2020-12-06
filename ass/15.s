magic: 72303b3e
version: 1
globals.count: 12
globals[0]: 
        is_count: 1
        value.count: 6
        item: getint
globals[1]: 
        is_count: 1
        value.count: 9
        item: getdouble
globals[2]: 
        is_count: 1
        value.count: 7
        item: getchar
globals[3]: 
        is_count: 1
        value.count: 6
        item: putint
globals[4]: 
        is_count: 1
        value.count: 9
        item: putdouble
globals[5]: 
        is_count: 1
        value.count: 7
        item: putchar
globals[6]: 
        is_count: 1
        value.count: 6
        item: putstr
globals[7]: 
        is_count: 1
        value.count: 5
        item: putln
globals[8]: 
        is_count: 1
        value.count: 4
        item: move
globals[9]: 
        is_count: 1
        value.count: 5
        item: hanoi
globals[10]: 
        is_count: 1
        value.count: 4
        item: main
globals[11]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 4
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 2
            stackalloc 0;
            call 3;
functions[1]: 
        nameOffset: 8
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 21
            stackalloc 0;
            arga 1;
            load.64; 
            callname 3;
            push 32;
            stackalloc 0;
            callname 5;
            arga 2;
            load.64; 
            stackalloc 0;
            callname 5;
            push 32;
            stackalloc 0;
            callname 5;
            arga 3;
            load.64; 
            stackalloc 0;
            callname 5;
            stackalloc 0;
            callname 7;
            ret; 
functions[2]: 
        nameOffset: 9
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 51
            arga 1;
            load.64; 
            push 1;
            cmp.i; 
            not; 
            br.true 1;
            br 9;
            stackalloc 0;
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            arga 4;
            load.64; 
            call 1;
            br 33;
            stackalloc 0;
            arga 1;
            load.64; 
            push 1;
            sub.i; 
            arga 2;
            load.64; 
            arga 4;
            load.64; 
            arga 3;
            load.64; 
            call 2;
            stackalloc 0;
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            arga 4;
            load.64; 
            call 1;
            stackalloc 0;
            arga 1;
            load.64; 
            push 1;
            sub.i; 
            arga 3;
            load.64; 
            arga 2;
            load.64; 
            arga 4;
            load.64; 
            call 2;
            br 0;
            br 0;
            ret; 
functions[3]: 
        nameOffset: 10
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 7
            stackalloc 0;
            push 6;
            push 65;
            push 66;
            push 67;
            call 2;
            ret; 

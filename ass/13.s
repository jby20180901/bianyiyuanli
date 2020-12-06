magic: 72303b3e
version: 1
globals.count: 13
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
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[9]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[10]: 
        is_count: 1
        value.count: 4
        item: swap
globals[11]: 
        is_count: 1
        value.count: 4
        item: main
globals[12]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 3
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 8
            globa 8;
            push 0;
            store.64; 
            globa 9;
            push 1;
            store.64; 
            stackalloc 0;
            call 2;
functions[1]: 
        nameOffset: 10
        ret_slots: 0
        param_slots: 0
        loc_slots: 1
        body.count: 13
            loca 0;
            globa 8;
            load.64; 
            store.64; 
            globa 8;
            globa 9;
            load.64; 
            store.64; 
            globa 9;
            loca 0;
            load.64; 
            store.64; 
            ret; 
functions[2]: 
        nameOffset: 11
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 35
            globa 8;
            stackalloc 1;
            callname 0;
            store.64; 
            globa 9;
            stackalloc 1;
            callname 0;
            store.64; 
            stackalloc 0;
            globa 8;
            load.64; 
            callname 3;
            push 32;
            stackalloc 0;
            callname 5;
            stackalloc 0;
            globa 9;
            load.64; 
            callname 3;
            stackalloc 0;
            callname 7;
            stackalloc 0;
            call 1;
            stackalloc 0;
            globa 8;
            load.64; 
            callname 3;
            push 32;
            stackalloc 0;
            callname 5;
            stackalloc 0;
            globa 9;
            load.64; 
            callname 3;
            ret; 

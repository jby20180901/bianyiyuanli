magic: 72303b3e
version: 1
globals.count: 10
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
        item: main
globals[9]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 2
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 2
            stackalloc 0;
            call 1;
functions[1]: 
        nameOffset: 8
        ret_slots: 0
        param_slots: 0
        loc_slots: 2
        body.count: 14
            loca 0;
            push 0;
            store.64; 
            loca 1;
            push 1;
            store.64; 
            stackalloc 0;
            loca 0;
            load.64; 
            loca 1;
            load.64; 
            add.i; 
            callname 3;
            ret; 

magic: 72303b3e
version: 1
globals.count: 11
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
        value.count: 3
        item: add
globals[9]: 
        is_count: 1
        value.count: 4
        item: main
globals[10]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 3
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 2
            stackalloc 0;
            call 2;
functions[1]: 
        nameOffset: 8
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 8
            arga 0;
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            add.i; 
            store.64; 
            ret; 
functions[2]: 
        nameOffset: 9
        ret_slots: 0
        param_slots: 0
        loc_slots: 3
        body.count: 21
            loca 0;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 1;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 2;
            stackalloc 1;
            loca 0;
            load.64; 
            loca 1;
            load.64; 
            call 1;
            store.64; 
            stackalloc 0;
            loca 2;
            load.64; 
            callname 3;
            ret; 

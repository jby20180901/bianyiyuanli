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
        value.count: 6
        item: is_odd
globals[9]: 
        is_count: 1
        value.count: 7
        item: fastpow
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
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 12
            arga 0;
            arga 1;
            load.64; 
            push 2;
            div.i; 
            push 2;
            mul.i; 
            arga 1;
            load.64; 
            sub.i; 
            store.64; 
            ret; 
functions[2]: 
        nameOffset: 9
        ret_slots: 1
        param_slots: 0
        loc_slots: 1
        body.count: 64
            loca 0;
            push 1;
            store.64; 
            arga 2;
            load.64; 
            push 0;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 5;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 0;
            br 0;
            br 0;
            push 1;
            br.true 1;
            br 39;
            stackalloc 1;
            arga 2;
            load.64; 
            call 1;
            br.true 1;
            br 8;
            loca 0;
            loca 0;
            load.64; 
            arga 1;
            load.64; 
            mul.i; 
            store.64; 
            br 0;
            br 0;
            arga 1;
            arga 1;
            load.64; 
            arga 1;
            load.64; 
            mul.i; 
            store.64; 
            arga 2;
            arga 2;
            load.64; 
            push 2;
            div.i; 
            store.64; 
            arga 2;
            load.64; 
            push 0;
            cmp.i; 
            not; 
            br.true 1;
            br 2;
            br 3;
            br 0;
            br 0;
            br -42;
            arga 0;
            loca 0;
            load.64; 
            store.64; 
            ret; 
functions[3]: 
        nameOffset: 10
        ret_slots: 0
        param_slots: 0
        loc_slots: 3
        body.count: 66
            loca 2;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 2;
            loca 2;
            load.64; 
            push 4;
            mul.i; 
            push 1;
            add.i; 
            store.64; 
            br 0;
            push 1;
            br.true 1;
            br 49;
            stackalloc 1;
            loca 2;
            load.64; 
            call 1;
            br.true 1;
            br 8;
            loca 2;
            loca 2;
            load.64; 
            push 3;
            sub.i; 
            store.64; 
            br -16;
            br 9;
            loca 2;
            load.64; 
            push 0;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 2;
            br 27;
            br 0;
            br 0;
            loca 0;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 1;
            stackalloc 1;
            callname 0;
            store.64; 
            stackalloc 0;
            stackalloc 1;
            loca 0;
            load.64; 
            loca 1;
            load.64; 
            call 2;
            callname 3;
            stackalloc 0;
            callname 7;
            loca 2;
            loca 2;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            br -52;
            ret; 

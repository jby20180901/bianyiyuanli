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
        loc_slots: 1
        body.count: 63
            loca 0;
            push 10;
            store.64; 
            br 0;
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 51;
            loca 0;
            loca 0;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            loca 0;
            load.64; 
            push 8;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            loca 0;
            push 4;
            store.64; 
            br -24;
            br 0;
            br 0;
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            not; 
            br.true 1;
            br 2;
            br 24;
            br 0;
            br 0;
            br 0;
            push 1;
            br.true 1;
            br 17;
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 8;
            stackalloc 0;
            loca 0;
            load.64; 
            callname 3;
            stackalloc 0;
            callname 7;
            br 3;
            br 0;
            br 0;
            br -20;
            br -58;
            ret; 

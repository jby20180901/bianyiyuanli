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
        item: main
globals[9]: 
        is_count: 1
        value.count: 20
        item: Invalid instruction!
globals[10]: 
        is_count: 1
        value.count: 12
        item: You cheated!
globals[11]: 
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
        loc_slots: 5
        body.count: 119
            loca 4;
            stackalloc 1;
            callname 0;
            store.64; 
            br 0;
            loca 4;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 106;
            loca 1;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 2;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 4;
            loca 4;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            br 0;
            push 1;
            br.true 1;
            br 79;
            loca 3;
            loca 1;
            load.64; 
            loca 2;
            load.64; 
            add.i; 
            push 1;
            add.i; 
            push 2;
            div.i; 
            store.64; 
            loca 0;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            not; 
            br.true 1;
            br 2;
            br 56;
            br 31;
            loca 0;
            load.64; 
            push 1;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            loca 2;
            loca 3;
            load.64; 
            store.64; 
            br 19;
            loca 0;
            load.64; 
            push 2;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            loca 1;
            loca 3;
            load.64; 
            store.64; 
            br 7;
            stackalloc 0;
            push 9;
            callname 6;
            stackalloc 0;
            callname 7;
            br -57;
            br 0;
            br 0;
            loca 1;
            load.64; 
            loca 2;
            load.64; 
            cmp.i; 
            not; 
            br.true 1;
            br 7;
            stackalloc 0;
            push 10;
            callname 6;
            stackalloc 0;
            callname 7;
            br 9;
            br 0;
            br 0;
            stackalloc 0;
            loca 3;
            load.64; 
            callname 3;
            stackalloc 0;
            callname 7;
            br -82;
            stackalloc 0;
            loca 3;
            load.64; 
            callname 3;
            stackalloc 0;
            callname 7;
            stackalloc 0;
            callname 7;
            br -113;
            ret; 

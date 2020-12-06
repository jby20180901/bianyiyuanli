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
        item: fib
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
            stackalloc 1;
            call 2;
functions[1]: 
        nameOffset: 8
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 55
            arga 1;
            load.64; 
            push 0;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 6;
            arga 0;
            push 1;
            neg.i; 
            store.64; 
            ret; 
            br 41;
            arga 1;
            load.64; 
            push 0;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 29;
            arga 1;
            load.64; 
            push 1;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 17;
            arga 0;
            stackalloc 1;
            arga 1;
            load.64; 
            push 2;
            sub.i; 
            call 1;
            stackalloc 1;
            arga 1;
            load.64; 
            push 1;
            sub.i; 
            call 1;
            add.i; 
            store.64; 
            ret; 
            br 0;
            br 0;
functions[2]: 
        nameOffset: 9
        ret_slots: 1
        param_slots: 0
        loc_slots: 2
        body.count: 67
            loca 0;
            push 0;
            store.64; 
            loca 1;
            push 0;
            store.64; 
            loca 1;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 1;
            load.64; 
            push 20;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 4;
            loca 1;
            push 21;
            store.64; 
            br 17;
            loca 1;
            load.64; 
            push 0;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 9;
            stackalloc 0;
            push 1;
            neg.i; 
            callname 3;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 1;
            br 0;
            br 0;
            br 0;
            loca 0;
            load.64; 
            loca 1;
            load.64; 
            cmp.i; 
            set.gt; 
            br.false 1;
            br 15;
            stackalloc 0;
            stackalloc 1;
            loca 0;
            load.64; 
            call 1;
            callname 3;
            stackalloc 0;
            callname 7;
            loca 0;
            loca 0;
            load.64; 
            push 1;
            add.i; 
            store.64; 
            br -23;
            arga 0;
            push 0;
            store.64; 
            ret; 

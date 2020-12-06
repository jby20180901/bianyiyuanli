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
        item: calcPi
globals[9]: 
        is_count: 1
        value.count: 5
        item: calcE
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
        loc_slots: 3
        body.count: 52
            loca 0;
            push 1;
            store.64; 
            loca 1;
            push 0;
            store.64; 
            loca 2;
            push 1;
            neg.i; 
            store.64; 
            br 0;
            push 0;
            loca 0;
            load.64; 
            itof; 
            div.f; 
            push 0;
            cmp.f; 
            set.gt; 
            br.true 1;
            br 24;
            loca 1;
            loca 1;
            load.64; 
            loca 2;
            load.64; 
            itof; 
            loca 0;
            load.64; 
            itof; 
            div.f; 
            add.f; 
            store.64; 
            loca 0;
            loca 0;
            load.64; 
            push 2;
            add.i; 
            store.64; 
            loca 2;
            loca 2;
            load.64; 
            neg.i; 
            store.64; 
            br -34;
            arga 0;
            loca 1;
            load.64; 
            push 0;
            mul.f; 
            store.64; 
            ret; 
functions[2]: 
        nameOffset: 9
        ret_slots: 1
        param_slots: 0
        loc_slots: 3
        body.count: 46
            loca 0;
            push 0;
            store.64; 
            loca 1;
            push 1;
            store.64; 
            loca 2;
            push 0;
            store.64; 
            br 0;
            loca 1;
            load.64; 
            push 1000;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 24;
            loca 2;
            loca 2;
            load.64; 
            loca 1;
            load.64; 
            itof; 
            mul.f; 
            store.64; 
            loca 0;
            loca 0;
            load.64; 
            push 0;
            loca 2;
            load.64; 
            div.f; 
            add.f; 
            store.64; 
            loca 1;
            loca 1;
            load.64; 
            push 1;
            add.i; 
            store.64; 
            br -31;
            arga 0;
            loca 0;
            load.64; 
            store.64; 
            ret; 
functions[3]: 
        nameOffset: 10
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 11
            stackalloc 0;
            stackalloc 1;
            call 1;
            callname 4;
            stackalloc 0;
            callname 7;
            stackalloc 0;
            stackalloc 1;
            call 2;
            callname 4;
            ret; 

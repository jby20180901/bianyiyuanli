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
        is_count: 1
        value.count: 4
        item: sqrt
globals[9]: 
        is_count: 1
        value.count: 3
        item: mod
globals[10]: 
        is_count: 1
        value.count: 9
        item: judge_mod
globals[11]: 
        is_count: 1
        value.count: 4
        item: main
globals[12]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 5
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 2
            stackalloc 0;
            call 4;
functions[1]: 
        nameOffset: 8
        ret_slots: 1
        param_slots: 0
        loc_slots: 4
        body.count: 74
            loca 0;
            push 0;
            store.64; 
            loca 1;
            arga 1;
            load.64; 
            store.64; 
            br 0;
            loca 1;
            load.64; 
            loca 0;
            load.64; 
            sub.f; 
            push 0;
            cmp.f; 
            set.gt; 
            br.true 1;
            br 51;
            loca 2;
            loca 0;
            load.64; 
            loca 1;
            load.64; 
            add.f; 
            push 0;
            div.f; 
            store.64; 
            loca 3;
            loca 2;
            load.64; 
            loca 2;
            load.64; 
            mul.f; 
            store.64; 
            loca 3;
            load.64; 
            arga 1;
            load.64; 
            cmp.f; 
            not; 
            br.true 1;
            br 6;
            arga 0;
            loca 2;
            load.64; 
            store.64; 
            ret; 
            br 0;
            br 0;
            loca 3;
            load.64; 
            arga 1;
            load.64; 
            cmp.f; 
            set.lt; 
            br.true 1;
            br 5;
            loca 0;
            loca 2;
            load.64; 
            store.64; 
            br 5;
            loca 1;
            loca 2;
            load.64; 
            store.64; 
            br 0;
            br 0;
            br -61;
            arga 0;
            loca 2;
            load.64; 
            store.64; 
            ret; 
functions[2]: 
        nameOffset: 9
        ret_slots: 1
        param_slots: 0
        loc_slots: 1
        body.count: 22
            loca 0;
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            div.i; 
            itof; 
            ftoi; 
            store.64; 
            arga 0;
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            loca 0;
            load.64; 
            mul.i; 
            sub.i; 
            itof; 
            ftoi; 
            store.64; 
            ret; 
functions[3]: 
        nameOffset: 10
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 35
            arga 2;
            load.64; 
            arga 3;
            load.64; 
            cmp.i; 
            set.gt; 
            br.true 1;
            br 5;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 21;
            stackalloc 1;
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            call 2;
            push 0;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 0;
            br 0;
functions[4]: 
        nameOffset: 11
        ret_slots: 0
        param_slots: 0
        loc_slots: 5
        body.count: 104
            loca 0;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 1;
            push 2;
            store.64; 
            br 0;
            loca 1;
            load.64; 
            loca 0;
            load.64; 
            cmp.i; 
            set.gt; 
            br.false 1;
            br 88;
            stackalloc 1;
            loca 1;
            load.64; 
            push 2;
            call 2;
            push 0;
            cmp.i; 
            br.true 1;
            br 71;
            loca 4;
            stackalloc 1;
            loca 1;
            load.64; 
            itof; 
            call 1;
            store.64; 
            loca 3;
            stackalloc 1;
            loca 1;
            load.64; 
            itof; 
            call 1;
            ftoi; 
            store.64; 
            loca 4;
            load.64; 
            ftoi; 
            loca 3;
            load.64; 
            cmp.i; 
            br.true 1;
            br 9;
            stackalloc 0;
            push 1;
            neg.i; 
            callname 3;
            stackalloc 0;
            callname 7;
            arga 0;
            ret; 
            br 0;
            br 0;
            loca 2;
            push 2;
            store.64; 
            br 0;
            stackalloc 1;
            loca 1;
            load.64; 
            loca 2;
            load.64; 
            loca 3;
            load.64; 
            call 3;
            br.true 1;
            br 7;
            loca 2;
            loca 2;
            load.64; 
            push 1;
            add.i; 
            store.64; 
            br -17;
            loca 2;
            load.64; 
            loca 3;
            load.64; 
            cmp.i; 
            set.gt; 
            br.true 1;
            br 7;
            stackalloc 0;
            loca 1;
            load.64; 
            callname 3;
            stackalloc 0;
            callname 7;
            br 0;
            br 0;
            br 0;
            br 0;
            loca 1;
            loca 1;
            load.64; 
            push 1;
            add.i; 
            store.64; 
            br -96;

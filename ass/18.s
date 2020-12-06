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
        value.count: 8
        item: is_digit
globals[9]: 
        is_count: 1
        value.count: 8
        item: is_space
globals[10]: 
        is_count: 1
        value.count: 4
        item: atoi
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
        loc_slots: 0
        body.count: 30
            arga 1;
            load.64; 
            push 48;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 5;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 17;
            arga 1;
            load.64; 
            push 57;
            cmp.i; 
            set.gt; 
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
functions[2]: 
        nameOffset: 9
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 54
            arga 1;
            load.64; 
            push 32;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 41;
            arga 1;
            load.64; 
            push 10;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 29;
            arga 1;
            load.64; 
            push 13;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 17;
            arga 1;
            load.64; 
            push 9;
            cmp.i; 
            not; 
            br.true 1;
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 5;
            arga 0;
            push 0;
            store.64; 
            ret; 
            br 0;
            br 0;
functions[3]: 
        nameOffset: 10
        ret_slots: 1
        param_slots: 0
        loc_slots: 3
        body.count: 77
            loca 1;
            push 0;
            store.64; 
            loca 2;
            push 0;
            store.64; 
            loca 0;
            stackalloc 1;
            callname 2;
            store.64; 
            br 0;
            stackalloc 1;
            loca 0;
            load.64; 
            call 2;
            br.true 1;
            br 5;
            loca 0;
            stackalloc 1;
            callname 2;
            store.64; 
            br -11;
            loca 0;
            load.64; 
            push 45;
            cmp.i; 
            not; 
            br.true 1;
            br 8;
            loca 2;
            push 1;
            store.64; 
            loca 0;
            stackalloc 1;
            callname 2;
            store.64; 
            br 0;
            br 0;
            br 0;
            stackalloc 1;
            loca 0;
            load.64; 
            call 1;
            br.true 1;
            br 16;
            loca 1;
            loca 1;
            load.64; 
            push 10;
            mul.i; 
            loca 0;
            load.64; 
            push 48;
            sub.i; 
            add.i; 
            store.64; 
            loca 0;
            stackalloc 1;
            callname 2;
            store.64; 
            br -22;
            loca 2;
            load.64; 
            br.true 1;
            br 6;
            loca 1;
            loca 1;
            load.64; 
            neg.i; 
            store.64; 
            br 0;
            br 0;
            arga 0;
            loca 1;
            load.64; 
            store.64; 
            ret; 
functions[4]: 
        nameOffset: 11
        ret_slots: 0
        param_slots: 0
        loc_slots: 1
        body.count: 26
            loca 0;
            stackalloc 1;
            callname 0;
            store.64; 
            br 0;
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 13;
            stackalloc 0;
            stackalloc 1;
            call 3;
            callname 3;
            stackalloc 0;
            callname 7;
            loca 0;
            loca 0;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            br -20;
            ret; 

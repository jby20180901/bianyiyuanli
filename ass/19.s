magic: 72303b3e
version: 1
globals.count: 14
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
        value.count: 5
        item: itoch
globals[9]: 
        is_count: 1
        value.count: 6
        item: modulo
globals[10]: 
        is_count: 1
        value.count: 10
        item: div_modulo
globals[11]: 
        is_count: 1
        value.count: 4
        item: itoa
globals[12]: 
        is_count: 1
        value.count: 4
        item: main
globals[13]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 6
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 2
            stackalloc 0;
            call 5;
functions[1]: 
        nameOffset: 8
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 26
            arga 1;
            load.64; 
            push 10;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 8;
            arga 0;
            push 48;
            arga 1;
            load.64; 
            add.i; 
            store.64; 
            ret; 
            br 10;
            arga 0;
            push 97;
            arga 1;
            load.64; 
            add.i; 
            push 10;
            sub.i; 
            store.64; 
            ret; 
            br 0;
            br 0;
functions[2]: 
        nameOffset: 9
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 14
            arga 0;
            arga 1;
            load.64; 
            arga 1;
            load.64; 
            arga 2;
            load.64; 
            div.i; 
            arga 2;
            load.64; 
            mul.i; 
            sub.i; 
            store.64; 
            ret; 
functions[3]: 
        nameOffset: 10
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 31
            br 0;
            arga 2;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 14;
            arga 1;
            arga 1;
            load.64; 
            arga 3;
            load.64; 
            div.i; 
            store.64; 
            arga 2;
            arga 2;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            br -21;
            arga 0;
            stackalloc 1;
            arga 1;
            load.64; 
            arga 3;
            load.64; 
            call 2;
            store.64; 
            ret; 
functions[4]: 
        nameOffset: 11
        ret_slots: 0
        param_slots: 0
        loc_slots: 2
        body.count: 87
            loca 0;
            push 0;
            store.64; 
            arga 1;
            load.64; 
            push 0;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 9;
            arga 1;
            arga 1;
            load.64; 
            neg.i; 
            store.64; 
            push 45;
            stackalloc 0;
            callname 5;
            br 0;
            br 0;
            loca 1;
            arga 1;
            load.64; 
            store.64; 
            loca 1;
            load.64; 
            push 0;
            cmp.i; 
            not; 
            br.true 1;
            br 4;
            loca 0;
            push 1;
            store.64; 
            br 23;
            br 0;
            loca 1;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 14;
            loca 1;
            loca 1;
            load.64; 
            arga 2;
            load.64; 
            div.i; 
            store.64; 
            loca 0;
            loca 0;
            load.64; 
            push 1;
            add.i; 
            store.64; 
            br -21;
            br 0;
            br 0;
            br 0;
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            set.gt; 
            br.true 1;
            br 19;
            loca 0;
            loca 0;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            stackalloc 1;
            stackalloc 1;
            arga 1;
            load.64; 
            loca 0;
            load.64; 
            arga 2;
            load.64; 
            call 3;
            call 1;
            stackalloc 0;
            callname 5;
            br -26;
            ret; 
functions[5]: 
        nameOffset: 12
        ret_slots: 0
        param_slots: 0
        loc_slots: 3
        body.count: 36
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
            br 23;
            loca 2;
            stackalloc 1;
            callname 0;
            store.64; 
            loca 1;
            stackalloc 1;
            callname 0;
            store.64; 
            stackalloc 0;
            loca 2;
            load.64; 
            loca 1;
            load.64; 
            call 4;
            stackalloc 0;
            callname 7;
            loca 0;
            loca 0;
            load.64; 
            push 1;
            sub.i; 
            store.64; 
            br -30;
            ret; 

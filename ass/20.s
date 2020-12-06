magic: 72303b3e
version: 1
globals.count: 29
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
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[9]: 
        is_count: 1
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[10]: 
        is_count: 1
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[11]: 
        is_count: 1
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[12]: 
        is_count: 1
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[13]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[14]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[15]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[16]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[17]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[18]: 
        is_count: 0
        value.count: 8
        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00        item: 00
globals[19]: 
        is_count: 1
        value.count: 1
        item: f
globals[20]: 
        is_count: 1
        value.count: 6
        item: random
globals[21]: 
        is_count: 1
        value.count: 10
        item: approx_exp
globals[22]: 
        is_count: 1
        value.count: 5
        item: judge
globals[23]: 
        is_count: 1
        value.count: 10
        item: run_anneal
globals[24]: 
        is_count: 1
        value.count: 6
        item: round=
globals[25]: 
        is_count: 1
        value.count: 6
        item:  temp=
globals[26]: 
        is_count: 1
        value.count: 7
        item:  value=
globals[27]: 
        is_count: 1
        value.count: 4
        item: main
globals[28]: 
        is_count: 1
        value.count: 6
        item: _start
functions.count: 7
functions[0]: 
        nameOffset: 0
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 27
            globa 8;
            push 1000000009;
            store.64; 
            globa 9;
            push 1919839;
            store.64; 
            globa 10;
            push 0;
            store.64; 
            globa 11;
            push 0;
            neg.f; 
            store.64; 
            globa 12;
            push 0;
            store.64; 
            globa 13;
            push 19260817;
            store.64; 
            globa 16;
            push 0;
            store.64; 
            globa 18;
            push 0;
            store.64; 
            stackalloc 0;
            call 6;
functions[1]: 
        nameOffset: 19
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 10
            arga 0;
            push 0;
            arga 1;
            load.64; 
            arga 1;
            load.64; 
            mul.f; 
            sub.f; 
            store.64; 
            ret; 
functions[2]: 
        nameOffset: 20
        ret_slots: 1
        param_slots: 0
        loc_slots: 1
        body.count: 56
            globa 13;
            globa 13;
            load.64; 
            globa 13;
            load.64; 
            push 8192;
            mul.i; 
            add.i; 
            store.64; 
            globa 13;
            globa 13;
            load.64; 
            globa 13;
            load.64; 
            push 131072;
            div.i; 
            add.i; 
            store.64; 
            globa 13;
            globa 13;
            load.64; 
            globa 13;
            load.64; 
            push 32;
            mul.i; 
            add.i; 
            store.64; 
            loca 0;
            globa 13;
            load.64; 
            push 65536;
            div.i; 
            store.64; 
            loca 0;
            load.64; 
            push 0;
            cmp.i; 
            set.lt; 
            br.true 1;
            br 6;
            loca 0;
            loca 0;
            load.64; 
            neg.i; 
            store.64; 
            br 0;
            br 0;
            arga 0;
            loca 0;
            load.64; 
            itof; 
            push 281474976710656;
            itof; 
            div.f; 
            store.64; 
            ret; 
functions[3]: 
        nameOffset: 21
        ret_slots: 1
        param_slots: 0
        loc_slots: 1
        body.count: 77
            arga 1;
            load.64; 
            push 0;
            cmp.f; 
            set.gt; 
            br.true 1;
            br 17;
            loca 0;
            stackalloc 1;
            arga 1;
            load.64; 
            push 0;
            div.f; 
            call 3;
            store.64; 
            arga 0;
            arga 1;
            load.64; 
            arga 1;
            load.64; 
            mul.f; 
            store.64; 
            ret; 
            br 52;
            arga 1;
            load.64; 
            push 0;
            neg.f; 
            cmp.f; 
            set.lt; 
            br.true 1;
            br 17;
            loca 0;
            stackalloc 1;
            arga 1;
            load.64; 
            push 0;
            div.f; 
            call 3;
            store.64; 
            arga 0;
            arga 1;
            load.64; 
            arga 1;
            load.64; 
            mul.f; 
            store.64; 
            ret; 
            br 27;
            arga 0;
            arga 1;
            load.64; 
            push 0;
            add.f; 
            arga 1;
            load.64; 
            push 0;
            add.f; 
            mul.f; 
            push 0;
            add.f; 
            arga 1;
            load.64; 
            push 0;
            sub.f; 
            arga 1;
            load.64; 
            push 0;
            sub.f; 
            mul.f; 
            push 0;
            add.f; 
            div.f; 
            store.64; 
            ret; 
            br 0;
            br 0;
functions[4]: 
        nameOffset: 22
        ret_slots: 1
        param_slots: 0
        loc_slots: 0
        body.count: 41
            arga 1;
            load.64; 
            push 0;
            cmp.f; 
            set.lt; 
            br.true 1;
            br 5;
            arga 0;
            push 1;
            store.64; 
            ret; 
            br 28;
            stackalloc 1;
            arga 1;
            load.64; 
            neg.f; 
            arga 2;
            load.64; 
            div.f; 
            push 0;
            div.f; 
            call 3;
            stackalloc 1;
            call 2;
            cmp.f; 
            set.gt; 
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
            br 0;
            br 0;
functions[5]: 
        nameOffset: 23
        ret_slots: 1
        param_slots: 0
        loc_slots: 3
        body.count: 171
            loca 2;
            push 0;
            store.64; 
            globa 14;
            stackalloc 1;
            call 2;
            globa 12;
            load.64; 
            globa 11;
            load.64; 
            sub.f; 
            mul.f; 
            globa 11;
            load.64; 
            add.f; 
            store.64; 
            globa 15;
            globa 14;
            load.64; 
            store.64; 
            globa 16;
            stackalloc 1;
            globa 14;
            load.64; 
            call 1;
            store.64; 
            globa 17;
            globa 16;
            load.64; 
            store.64; 
            br 0;
            globa 18;
            load.64; 
            push 0;
            cmp.f; 
            set.gt; 
            br.true 1;
            br 128;
            loca 0;
            stackalloc 1;
            call 2;
            push 0;
            sub.f; 
            push 0;
            mul.f; 
            store.64; 
            globa 15;
            globa 14;
            load.64; 
            loca 0;
            load.64; 
            add.f; 
            store.64; 
            globa 15;
            load.64; 
            globa 12;
            load.64; 
            cmp.f; 
            set.gt; 
            br.true 1;
            br 10;
            globa 15;
            globa 15;
            load.64; 
            push 0;
            loca 0;
            load.64; 
            mul.f; 
            sub.f; 
            store.64; 
            br 18;
            globa 15;
            load.64; 
            globa 11;
            load.64; 
            cmp.f; 
            set.lt; 
            br.true 1;
            br 10;
            globa 15;
            globa 15;
            load.64; 
            push 0;
            loca 0;
            load.64; 
            mul.f; 
            sub.f; 
            store.64; 
            br 0;
            br 0;
            globa 17;
            stackalloc 1;
            globa 15;
            load.64; 
            call 1;
            store.64; 
            loca 1;
            globa 16;
            load.64; 
            globa 17;
            load.64; 
            sub.f; 
            store.64; 
            stackalloc 1;
            loca 1;
            load.64; 
            globa 18;
            load.64; 
            call 4;
            br.true 1;
            br 9;
            globa 16;
            globa 17;
            load.64; 
            store.64; 
            globa 14;
            globa 15;
            load.64; 
            store.64; 
            br 0;
            br 0;
            loca 1;
            load.64; 
            push 0;
            cmp.f; 
            set.lt; 
            br.true 1;
            br 30;
            globa 18;
            globa 18;
            load.64; 
            push 0;
            mul.f; 
            store.64; 
            stackalloc 0;
            push 24;
            callname 6;
            stackalloc 0;
            loca 2;
            load.64; 
            callname 3;
            stackalloc 0;
            push 25;
            callname 6;
            stackalloc 0;
            globa 18;
            load.64; 
            callname 4;
            stackalloc 0;
            push 26;
            callname 6;
            stackalloc 0;
            globa 16;
            load.64; 
            callname 4;
            stackalloc 0;
            callname 7;
            br 0;
            br 0;
            loca 2;
            loca 2;
            load.64; 
            push 1;
            add.i; 
            store.64; 
            br -135;
            arga 0;
            globa 16;
            load.64; 
            store.64; 
            ret; 
functions[6]: 
        nameOffset: 27
        ret_slots: 0
        param_slots: 0
        loc_slots: 0
        body.count: 5
            stackalloc 0;
            stackalloc 1;
            call 5;
            callname 4;
            ret; 

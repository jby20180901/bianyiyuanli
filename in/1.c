let a0: int;
let a1: int;
let a2: int;
let a3: int;
let a4: int;
let a5: int;
let a6: int;
let a7: int;


fn testParam8(a0: int, a1: int, a2: int, a3: int, a4: int, a5: int, a6: int, a7: int) -> int {
    return a0 + a1 + a2 + a3 + a4 + a5 + a6 + a7;
}

fn main() -> void{
    a0 = 0;
    a1 = 1;
    a2 = 2;
    a3 = 3;
    a4 = 4;
    a5 = 5;
    a6 = 6;
    a7 = 7;

    a0 = testParam8(a0, a1, a2, a3, a4, a5, a6, a7);
}
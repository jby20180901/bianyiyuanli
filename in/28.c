fn is_odd(x: int) -> int {
    return (x / 2 * 2) - x;
}

fn fastpow(base: int, exp: int) -> int {
    let res: int = 1;
    if exp < 0 {
        return 0;
    }
    while 1 {
        if is_odd(exp) {
            res = res * base;
        }
        base = base * base;
        exp = exp / 2;
        if exp == 0 {
            break;
        }
    }
    return res;
}

fn main() -> void {
    let base: int;
    let exp: int;
    let count: int;
    count = getint();
    count = count * 4 + 1;
    while 1 {
        if is_odd(count){
            count = count - 3;
            continue;
        } else if count < 0 {
            break;
        }
        base = getint();
        exp = getint();
        putint(fastpow(base,exp));
        putln();
        count = count - 1;
    }
}

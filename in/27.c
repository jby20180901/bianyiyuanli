fn gcd(a: int, b: int) -> int {
    if a > b {
        let temp: int = a;
        a = b;
        b = temp;
    }
    while a != 0 {
        while a <= b {
            b = b - a;
        }
        let temp1: int = b;
        b = a;
        a = temp1;
    }
    return b;
}

fn main() -> void {
    let count: int;
    let a: int;
    let b: int;

    count = getint();
    while count > 0 {
        a = getint();
        b = getint();
        putint(gcd(a, b));
        putln();
        count = count - 1;
    }
}

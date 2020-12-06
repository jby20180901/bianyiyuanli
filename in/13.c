let a: int = 0;
let b: int = 1;

fn swap() -> void {
    let temp: int = a;
    a = b;
    b = temp;
}

fn main() -> void {
    a = getint();
    b = getint();
    
    putint(a);
    putchar(32);
    putint(b);
    putln();

    swap();
    
    putint(a);
    putchar(32);
    putint(b);
}

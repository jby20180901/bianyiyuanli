fn main() -> void {
    let instruction: int;
    let low: int;
    let high: int;
    let mid: int;
    let count: int;
    count = getint();
    while count > 0 {
        low = getint();
        high = getint();
        count = count - 1;
        while 1 {
            mid = (low + high + 1) / 2;
            instruction = getint();
            if instruction == 0 {
                break;
            } else if instruction == 1 {
                high = mid;
            } else if instruction == 2 {
                low = mid;
            } else {
                putstr("Invalid instruction!");
                putln();
                continue;
            }
            if low == high {
                putstr("You cheated!");
                putln();
                break;
            }
            putint(mid);
            putln();
        }
        putint(mid);
        putln();
        putln();
    }
}

fn main() -> void {
    let counter: int = 10;
    while counter > 0 {
        counter = counter - 1;
        if counter == 8 {
            counter = 4;
            continue;
        }
        if counter == 0 {
            break;
        }
        while 1 {
            if counter > 0 {
                putint(counter);
                putln();
                break;
            }
        }
    }
}

fn main() -> void {
    let i: int = 1;
    putint(i);
    putln();
    i = i + 1;
    {
        i = i + 1;
        putint(i);
        putln();
        {
            let i: int = 999;
            putint(i);
            putln();
            i = i + 1;
            {
                putint(i);
                putln();
            }
        }
        putint(i);
        putln();
    }
}

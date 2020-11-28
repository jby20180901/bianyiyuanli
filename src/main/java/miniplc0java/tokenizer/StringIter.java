package miniplc0java.tokenizer;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import util.Pos;

/**
 * ����һ���� C++ �汾���������ַ�������
 */
public class StringIter {
    // ����Ϊ�����Ļ�����
    ArrayList<String> linesBuffer = new ArrayList<>();

    Scanner scanner;
    // ָ����һ��Ҫ��ȡ���ַ�
    Pos ptrNext = new Pos(0, 0);

    Pos ptr = new Pos(0, 0);

    boolean initialized = false;

    Optional<Character> peeked = Optional.empty();

    public StringIter(Scanner scanner) {
        this.scanner = scanner;
    }

    // �����￪ʼ��ʵ��һ�������кŵĻ�������ʵ��
    // Ϊ�˼����������û�е����ó�һ����ʵ��
    // ����˼��� C ���ļ�����������ƣ�����һ�� buffer ��һ��ָ�룬������ϸ��
    // 1.���������� \n
    // 2.ָ��ʼ��ָ����һ��Ҫ��ȡ�� char
    // 3.�кź��кŴ� 0 ��ʼ

    // һ�ζ���ȫ�����ݣ������滻���л���Ϊ \n
    // ������ʵ�ǲ������ģ�����ֻ�Ǽ������ôʵ��
    public void readAll() {
        if (initialized) {
            return;
        }
        while (scanner.hasNext()) {
            linesBuffer.add(scanner.nextLine() + '\n');
        }
        // todo:check read \n?
        initialized = true;
    }

    // һ���򵥵��ܽ�
    // | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | ƫ��
    // | = | = | = | = | = | = | = | = | = | = |
    // | h | a | 1 | 9 | 2 | 6 | 0 | 8 | 1 | \n |����������0�У�
    // | 7 | 1 | 1 | 4 | 5 | 1 | 4 | ����������1�У�
    // �������ָ��ָ���һ�е� \n����ô��
    // nextPos() = (1, 0)
    // currentPos() = (0, 9)
    // previousPos() = (0, 8)
    // nextChar() = '\n' ����ָ���ƶ��� (1, 0)
    // unreadLast() ָ���ƶ��� (0, 8)
    /**
     * ��ȡ��һ���ַ���λ��
     */
    public Pos nextPos() {
        if (ptr.row >= linesBuffer.size()) {
            throw new Error("advance after EOF");
        }
        if (ptr.col == linesBuffer.get(ptr.row).length() - 1) {
            return new Pos(ptr.row + 1, 0);
        }
        return new Pos(ptr.row, ptr.col + 1);
    }

    /**
     * ��ȡ��ǰ�ַ���λ��
     */
    public Pos currentPos() {
        return ptr;
    }

    /**
     * ��ȡ��һ���ַ���λ��
     */
    public Pos previousPos() {
        if (ptr.row == 0 && ptr.col == 0) {
            throw new Error("previous position from beginning");
        }
        if (ptr.col == 0) {
            return new Pos(ptr.row - 1, linesBuffer.get(ptr.row - 1).length() - 1);
        }
        return new Pos(ptr.row, ptr.col - 1);
    }

    /**
     * ��ָ��ָ����һ���ַ��������ص�ǰ�ַ�
     */
    public char nextChar() {
        if (this.peeked.isPresent()) {
            char ch = this.peeked.get();
            this.peeked = Optional.empty();
            this.ptr = ptrNext;
            return ch;
        } else {
            char ch = this.getNextChar();
            this.ptr = ptrNext;
            return ch;
        }
    }

    private char getNextChar() {
        if (isEOF()) {
            return 0;
        }
        char result = linesBuffer.get(ptrNext.row).charAt(ptrNext.col);
        ptrNext = nextPos();
        return result;
    }

    /**
     * �鿴��һ���ַ��������ƶ�ָ��
     */
    public char peekChar() {
        if (peeked.isPresent()) {
            return peeked.get();
        } else {
            char ch = getNextChar();
            this.peeked = Optional.of(ch);
            return ch;
        }
    }

    public Boolean isEOF() {
        return ptr.row >= linesBuffer.size();
    }

    // Note: Is it evil to unread a buffer?
    public void unreadLast() {
        ptr = previousPos();
    }

}

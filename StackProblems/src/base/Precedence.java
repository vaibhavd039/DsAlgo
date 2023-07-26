package base;

public class Precedence {
    public static int getPrecedence(Character x) {
        switch (x) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}

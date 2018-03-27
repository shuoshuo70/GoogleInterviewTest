import java.util.Stack;

/**
 * Created by shuoshu on 2018/3/12.
 */
public class BasicCalculator3 {
    public int evaluateExpression(String[] expression) {
        if (expression.length == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        Stack<String> signs = new Stack<>();

        for (String s : expression) {
            if (s.equals("(")) {
                signs.push("(");
            } else if (s.equals(")")) {
                while (!signs.isEmpty() && !signs.peek().equals("(")) {
                    nums.push(calculate(nums.pop(), nums.pop(), signs.pop()));
                }
                signs.pop();
            } else if ("+-*/".indexOf(s) != -1) {
                while (!signs.isEmpty() && isPreCal(s, signs.peek())) {
                    nums.push(calculate(nums.pop(), nums.pop(), signs.pop()));
                }
                signs.push(s);
            } else {
                nums.push(Integer.valueOf(s));
            }
        }

        while (!signs.isEmpty()) {
            nums.push(calculate(nums.pop(), nums.pop(), signs.pop()));
        }

        return nums.pop();
    }

    private boolean isPreCal(String cur, String pre) {
        if ("*/".indexOf(pre) != -1) {
            return true;
        }
        if ("+-".indexOf(cur) != -1 && "+-".indexOf(pre) != -1) {
            return true;
        }

        return false;
    }

    private int calculate(int b, int a, String sign) {
        int ans = 0;
        if (sign == "+") {
            ans = a + b;
        } else if (sign == "-") {
            ans = a - b;
        } else if (sign == "*") {
            ans = a * b;
        } else {
            ans = a / b;
        }

        return ans;
    }
}

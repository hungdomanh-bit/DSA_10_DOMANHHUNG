import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {

    public static String isBalanced(String s) {
        // Sử dụng Deque làm Stack (khuyến nghị thay cho Stack cũ của Java)
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // Nếu là dấu mở ngoặc, push vào stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // Nếu gặp dấu đóng ngoặc mà stack rỗng -> Không cân bằng
                if (stack.isEmpty()) {
                    return "NO";
                }

                // Lấy phần tử đỉnh stack ra kiểm tra
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return "NO";
                }
            }
        }

        // Chuỗi cân bằng khi và chỉ khi stack rỗng
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // Ví dụ kiểm thử
        String[] testCases = {
                "{[()]}",
                "{[(])}",
                "{{[[(())]]}}"
        };

        for (String test : testCases) {
            System.out.println(test + " -> " + isBalanced(test));
        }
    }
}
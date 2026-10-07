import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution2 {

    // Cấu trúc Queue bằng 2 Stacks
    static class QueueViaTwoStacks<T> {
        private final Deque<T> stackNewest = new ArrayDeque<>();
        private final Deque<T> stackOldest = new ArrayDeque<>();

        // Thêm phần tử vào cuối queue
        public void enqueue(T value) {
            stackNewest.push(value);
        }

        // Chuyển phần tử từ stackNewest sang stackOldest khi stackOldest rỗng
        private void prepOldest() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        // Xem phần tử ở đầu queue
        public T peek() {
            prepOldest();
            return stackOldest.peek();
        }

        // Xóa phần tử ở đầu queue
        public T dequeue() {
            prepOldest();
            return stackOldest.pop();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int q = scanner.nextInt();
        QueueViaTwoStacks<Integer> queue = new QueueViaTwoStacks<>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }

        scanner.close();
    }
}
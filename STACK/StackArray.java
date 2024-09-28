public class StackArray {

    private String[] s;
    private int count;

    public StackArray(int size) {
        s = new String[size];
        count = 0;

    }

    public StackArray() {
        this(10);
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == s.length;
    }

    public boolean push(String val) {
        if (!isFull()) {
            s[count++] = val;
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!isEmpty()) {
            s[count - 1] = null;
            count--;
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return s[count - 1];
        }
        return null;
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = count - 1; i >= 0; i--) {
                System.out.println("[" + s[i] + "]");

            }
        } else {
            System.out.println("Stack is empty");
        }
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");

        System.out.println("Stack Elements");
        stack.display();

        System.out.println("Stack peek of the top element: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Stack Elements after popping three times: ");
        stack.display();

        System.out.println("The top word after popping three times: " + stack.peek());

    }
}

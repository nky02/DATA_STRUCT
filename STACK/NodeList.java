public class NodeList {

    private Node last;
    private int counter;

    public NodeList() {
        this.last = null;
        this.counter = 0;
    }

    public boolean isEmpty() {
        return last == null;    
    }

    public boolean addNode(Node item) {
        if (isEmpty()) {
            last = item;
        } else {
            Node temp = last;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = item;
        }
        counter++;
        return true;
    }

    public boolean delete(int location) {
        if (isEmpty() || location < 0 || location >= counter) {
            return false;
        }

        if (location == 0) {
            last = last.next;
        } else {
            Node temp = last;
            for (int i = 0; i < location - 1; i++) {
                temp = temp.next;
            }
            if (temp.next.next == null) {
                temp.next = null;
            } else {
                temp.next = temp.next.next;
            }
        }

        counter--;
        return true;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node temp = last;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

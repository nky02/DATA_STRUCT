public class NodeListTest {
    public static void main(String[] args) {
        // Create an instance of NodeList
        NodeList nodeList = new NodeList();

        // Add nodes to the list directly (no need for nodeList.new Node())
             // Adding node with data 10
        nodeList.addNode(new Node(20)); // Adding node with data 20
        nodeList.addNode(new Node(30)); // Adding node with data 30

        // Display the list
        System.out.println("List after adding nodes:");
        nodeList.display(); // Expected output: 10->20->30->null

        // Delete a node (e.g., at index 1)
        nodeList.delete(1);

        // Display the list after deletion
        System.out.println("List after deleting node at index 1:");
        nodeList.display(); // Expected output: 10->30->null

        // Try deleting the first node
        nodeList.delete(0);

        // Display the list after deletion
        System.out.println("List after deleting node at index 0:");
        nodeList.display(); // Expected output: 30->null

        nodeList.delete(0);

        System.out.println("List after deleting node at index 2:");
        nodeList.display(); // Expected output: 30->null

    }
}

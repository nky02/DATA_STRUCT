public class NodeListTest {
    public static void main(String[] args) {
        
        NodeList nodeList = new NodeList();

        
        nodeList.addNode(new Node(20)); 
        nodeList.addNode(new Node(30)); 
        
        System.out.println("List after adding nodes:");
        nodeList.display(); 

        
        nodeList.delete(1);

       
        System.out.println("List after deleting node at index 1:");
        nodeList.display(); 
        
        nodeList.delete(0);

        
        System.out.println("List after deleting node at index 0:");
        nodeList.display(); 

        nodeList.delete(0);

        System.out.println("List after deleting node at index 2:");
        nodeList.display(); 

    }
}

public class Node {
    public Node previousNode; //Previous node
    public int count; //Current Position
    public Node nextNode; //Next node
    public Node(){
        previousNode = null;
        count = 0;
        nextNode = null;
    }
    public Node(Node newP, int newI, Node newN){
        previousNode = newP;
        count = newI;
        nextNode = newN;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }
}

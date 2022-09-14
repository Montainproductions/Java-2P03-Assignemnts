public class Node {
    public int item; //Current Position
    public Node nextNode; //Next node
    public Node previousNode;
    public Node (int i, Node n, Node p){
        item = i;
        nextNode = n;
        previousNode = p;
    }
}

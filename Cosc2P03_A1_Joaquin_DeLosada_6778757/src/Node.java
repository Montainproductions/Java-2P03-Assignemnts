public class Node {
    public int item; //Current Position
    public Node nextNode; //Next node
    public Node previousNode; //Previous node
    public Node (Node p, int i, Node n){
        previousNode = p;
        item = i;
        nextNode = n;
    }
}

public class Node {
    public Patient currentPatient;
    public Node previousNode; //Previous node
    public int count; //Current Position
    public Node nextNode; //Next node
    public Node(){
        currentPatient = null;
        previousNode = null;
        count = 0;
        nextNode = null;
    }
    public Node(Patient newPatient, Node newP, int newCount, Node newN){
        currentPatient = newPatient;
        previousNode = newP;
        count = newCount;
        nextNode = newN;
    }

    public Patient GetCurrentPatient(){return currentPatient;}

    public Node GetNextNode() {
        return nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public int GetCount(){return count;}
}

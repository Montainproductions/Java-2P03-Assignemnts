public class Node {
    public Patient currentPatient;
    public Node previousNode; //Previous node
    public Node nextNode; //Next node
    public Node(){
        currentPatient = null;
        previousNode = null;
        nextNode = null;
    }
    public Node(Patient newPatient, Node nextPatient){
        currentPatient = newPatient;
        previousNode = null;
        nextNode = nextPatient;

        //System.out.println(newPatient.getPatientName());
    }

    public void SetLink(Node newNode){
        nextNode = newNode;
    }

    public Patient GetCurrentPatient(){return currentPatient;}

    public Node GetNextNode() {return nextNode;}

    public Node GetPreviousNode() {
        return previousNode;
    }
}

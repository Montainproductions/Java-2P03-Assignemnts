import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    public class ListIterator{
        public Node position;
        public Node previous;

        public ListIterator(){
            position = head;
            previous = null;
        }

        public void Restart(){
            position = head;
            previous = null;
        }

        public void MovetoCorrectPosition(Patient newPatient){
            Patient currentPatient = position.GetCurrentPatient();
            if(currentPatient.getPriorityQueue() == newPatient.getPriorityQueue()){
                if(currentPatient.getPatientTimeOfArrival() != newPatient.getPatientTimeOfArrival()){}
            }else{
                currentPatient = Next();
            }
        }

        public Patient Next(){
            if(!HasNext()){
                throw new NoSuchElementException();
            }
            Patient returnPatient = position.GetCurrentPatient();
            previous = position;
            position = position.GetNextNode();
            return returnPatient;
        }

        public boolean HasNext(){
            return (position != null);
        }

        public void AddNodeHere(Patient newPatient){
            Node temp = new Node(newPatient,position);
            previous.SetLink(temp);
        }

        public void DeleteNodeHere(){
            previous.SetLink(position.GetNextNode());
            position.SetLink(position.GetNextNode());
        }
    }

    public LinkedList(){
        head = null;
    }

    public void AddtoStart(Patient newPatient, int count){
        head = new Node(newPatient, head);
    }

    public boolean DeleteHeadNode(){
        if(head != null){
            head = head.GetNextNode();
            return true;
        }else{
            return false;
        }
    }

    public int Size(){
        int count = 0;
        Node position = head;
        while(position != null){
            count++;
            position = position.GetNextNode();
        }
        return count;
    }

    /* This is shown in the book as usefull but as I work on the

    public boolean Contains(Patient patient){
        return (Find(patient) != null);
    }

    public Patient FindsPatient(Patient target){
        return Find(target).GetCurrentPatient();
    }

    private Node Find(Patient target){
        Node position = head;
        Patient patientAtNode;
        while(position != null){
            patientAtNode = position.currentPatient;
            if(patientAtNode.equals(target)){
                return position;
            }
            position = position.GetNextNode();
        }
        return null;
    }*/

    public void OutputList(){
        Node position = head;
        while(position != null){
            System.out.println(position.GetCurrentPatient().getPatientName());

            position = position.GetNextNode();
        }
    }

    public boolean isEmpty(){
        return (head == null);
    }

//    public boolean Equals(Patient otherPatient){}
}

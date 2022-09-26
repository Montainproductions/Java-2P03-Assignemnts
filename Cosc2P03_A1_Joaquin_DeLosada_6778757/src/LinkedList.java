import java.util.NoSuchElementException;

public class LinkedList {
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

        public void Next(){
            if(!HasNext()){
                throw new NoSuchElementException();
            }
            Patient returnPatient = position.GetCurrentPatient();
            previous = position;
            position = position.GetNextNode();
        }

        public boolean HasNext(){
            return (position != null);
        }

        public void AddNodeHere(Patient newPatient){
            Node temp = new Node(newPatient, position.GetPreviousNode(), position);
            position.previousNode.nextNode = temp;
            position.previousNode = temp;
        }

        public void DeleteNodeHere(){
            previous.SetLink(position.GetNextNode());
            position.SetLink(position.GetNextNode());
            position.GetNextNode();
        }
    }

    private Node head;

    public ListIterator iterator(){
        return new ListIterator();
    }

    public LinkedList(){
        head = null;
    }

    public void FirstLink(Patient patient){ //When there is no Nodes in the linked list
        head = new Node(patient, null, head);
    }

    public void FinalLink(Patient patient){ //Add to the end of the LL
        head = new Node(patient, head, null);
    }

    public void AddtoStart(Patient newPatient){ //Add to the start of the LL
        Node newHead = new Node(newPatient, null, head);
        head.SetPreviouseLink(newHead);
        head = newHead;
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

    public void OutputList(){
        Node position = head;
        while(position != null){
            System.out.println(position.GetCurrentPatient().getPatientName());

            position = position.GetNextNode();
        }
    }
}

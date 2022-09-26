import java.util.NoSuchElementException;

public class LinkedList {
    public class ListIterator{
        public Node position; //Current position of the nodes with its related info
        public Node previous; //Previouse node so it can traverse backwards in the nodes

        public ListIterator(){ //Initilize at the start of the list
            position = head;
            previous = null;
        }

        public void Restart(){ //Go back to the start of the list.
            position = head;
            previous = null;
        }

        public void Next(){ //Go to the next Node
            if(!HasNext()){ //If no more patients in the linked list then stop
                throw new NoSuchElementException();
            }
            Patient returnPatient = position.GetCurrentPatient();
            previous = position;//Sets the preveous node to the current one
            position = position.GetNextNode(); //Sets the next Node to the current Node
        }

        public boolean HasNext(){ //Checks if next node exists
            return (position != null);
        }

        public void AddNodeHere(Patient newPatient){ //Will split the linked list in two and add a new node in the middle
            Node temp = new Node(newPatient, position.GetPreviousNode(), position); //new node and what its connected to the other nodes
            position.previousNode.nextNode = temp; //Connect the previous Node to the new node
            position.previousNode = temp; //Connect the next node to the new node
        }
    }

    private Node head; //Sets up the head node (Technicly the current position from what I understand)

    public ListIterator iterator(){
        return new ListIterator();
    }

    public LinkedList(){ //Sets the head node
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

    public boolean DeleteHeadNode(){ //Delete the head node if it exists
        if(head != null){
            head = head.GetNextNode();
            return true;
        }else{
            return false;
        }
    }

    public int Size(){ //Runs through the linked list and counts how many nodes exist
        int count = 0;
        Node position = head;
        while(position != null){ //Counts till it reaches the end
            count++;
            position = position.GetNextNode();
        }
        return count;
    }

    public void OutputList(){ //Will pring each node (Currently only the name but other in for for patients is valid)
        Node position = head;
        while(position != null){ //Goes through each position untill the end
            System.out.println(position.GetCurrentPatient().getPatientName());

            position = position.GetNextNode(); //Goes  to the next node
        }
    }
}

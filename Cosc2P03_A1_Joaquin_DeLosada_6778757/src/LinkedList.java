public class LinkedList {
    private Node head;
    public LinkedList(){
        head = null;
    }

    public void AddtoStart(Patient newPatient, int count){
        head = new Node(newPatient,null, count, head);
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

    public boolean Contains(Patient patient){
        return (Find(patient) != null);
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
    }

    public void OutputList(){
        Node position = head;
        while(position != null){
            System.out.println(position.GetCurrentPatient() + " " + position.GetCount());

            position.GetNextNode();
        }
    }
}

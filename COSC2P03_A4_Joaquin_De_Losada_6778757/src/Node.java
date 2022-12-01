public class Node {
        public Vertex currentPatient; //Current Patient in the node
        public Node previousNode; //Previous node
        public Node nextNode; //Next node
        public Node(){ //Setting everything to null;
            currentPatient = null;
            previousNode = null;
            nextNode = null;
        }
        public Node(Vertex newPatient, Node previousNode, Node nextPatient){ //Recives info about the new node and saves it in corisponding variables
            currentPatient = newPatient;
            this.previousNode = previousNode;
            nextNode = nextPatient;

            //System.out.println(newPatient.getPatientName());
        }

        public Node(Vertex newPatient,Node previousNode){
            currentPatient = newPatient;
            this.previousNode = previousNode;
            nextNode = null;
        }

        public void SetLink(Node newNode){ //Sets link to the next Node
            nextNode = newNode;
        }

        public void SetPreviouseLink(Node previousNode){ //Sets the node to the previous node
            this.previousNode = previousNode;
        }

        public Vertex GetCurrentPatient(){return currentPatient;} //Returns the current patient in the Node

        public Node GetNextNode() {return nextNode;} //Returns the next node on the list

        public Node GetPreviousNode() {
            return previousNode;
        } //Returns the previous node in the list

}

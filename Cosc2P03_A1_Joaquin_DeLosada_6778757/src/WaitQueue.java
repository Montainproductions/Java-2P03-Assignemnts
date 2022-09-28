import jdk.nashorn.internal.ir.WhileNode;

import java.util.Objects;

public class WaitQueue {
    Patient currentPatient; //The current patient being placed in the wait queue

    LinkedList list = new LinkedList(); //Initilize the linked list
    LinkedList.ListIterator listIterator = list.iterator(); //Initilize the list iterator used to move through the link list for an easier time to add and take away nodes

    public void insert(Patient newPatient){ //Will insert a patient into the linked list
        int s = list.Size(); //Determines the size of the list. This is because the first two nodes of the linked list are a special case since they have a lot of null pointers that need to be arrainged
        //System.out.println(s);
        listIterator.Restart(); //Starts the list to the beggining
        //Patient currentPatient; //Current patient being traversed in the linked list. Used for compareson
        int currentPatientQueue; //Priority queue of patient being checked
        int newPatientQueue = newPatient.getPriorityQueue();//Priority queue of the patient being added

        if(s == 0){ //If the linked list is empty then add the first node
            list.AddtoStartFirstCase(newPatient); //Sets the first node of the linked list
            //printList();
            return; //Will return so that the rest of the method dosent run
        }
        currentPatient = listIterator.position.GetCurrentPatient(); //Finds the patient in the current node
        currentPatientQueue = currentPatient.getPriorityQueue(); //Priority queue of the patient in the node
        //System.out.println("Current Patient queue: " + currentPatientPos + ", " + "New Patient queue: " + newPatientQueue);

        //If your reading this comments then, yes its spaghetti code, yes it works. And I fear touching this in lue of more null point exeptions and not being able to return to a good state.
        //Will continuasly loop through the linked list untill it reaches the end of the linked list or it gets booted out with the return
        while(listIterator.position != null){
            //System.out.println("Current P Name: " + currentPatient.getPatientName() + " New P Name: " + newPatient.getPatientName());
            //System.out.println("Current P Queue: " + currentPatientQueue + " New P Queue: " + newPatientQueue);
            if(newPatientQueue == 0){ //If the priority queue of the patient is 0 then it will be added to the end of the list
                list.AddToEnd(newPatient); //Add to end of list
                //printList();
                listIterator.Restart(); //Have the position of the list iterator restart to the begining
                return; //Return so that the rest of the method dosent run
            }else if(currentPatientQueue >= newPatientQueue) { //If the current patients queue value is greater than or equal to the new patients queue value then go to the next position and update the position
                listIterator.position = listIterator.Next(); //Go to the next patient and updated the position in the listIterator
                //System.out.println("To next patient");
                currentPatient = listIterator.position.GetCurrentPatient(); //Finds the patient in the current node
                currentPatientQueue = currentPatient.getPriorityQueue(); //Priority queue of the patient in the node
            }else{ //Once the new patients has a queue value greater than the current patient queue it will add either at the start of the list or in that position depending on where the position that the node is at
                if(listIterator.previous == null){ //If the previous node is null then this means that it is at the start of the linked list so it adds the patient to the start
                    list.AddtoStart(newPatient);
                }else{ //If the patient is somewhere in the middle of the linked list then will add it to that position
                    listIterator.AddNodeHere(newPatient); //Add patient in current node
                }
                //printList();
                listIterator.Restart(); //Return to the start of the linked list node
                return;
            }
        }
        //System.out.println("List position: " + listIterator.position.GetCurrentPatient().getPatientName());

        //s = list.Size();
        //System.out.println("Size of linked list: " + s);
        //System.out.println(currentPatient.getPatientName());
        //printList();
    }

    public void printList(){ //Print the Linked list
        list.OutputList();
        System.out.println(" ");
    }

    public void removePatient(Patient delPatient){ //Remove the node which contains the patient
        if(list.Size() != 0)
        listIterator.position = list.Find(delPatient);
        listIterator.DeleteNodeHere();
        if(listIterator.previous != null) {
            listIterator.DeleteNodeHere();
        }else{
            list.DeleteHeadNode();
        }
    }

    public void getPatient(Patient newPatient){ //Recives the new patient and checks its position and trys to insert it
        currentPatient = newPatient;

        insert(currentPatient); //Insert patient

        //printList();
        //System.out.println(currentPatient.getPatientName());
        //System.out.println(patientScore);
    }

    public boolean CheckVax(boolean beingVaxxed){
        int s = list.Size();
        boolean canBeVaxxed;
        if(s > 0 && !beingVaxxed){
            canBeVaxxed = true;
        }else{
            canBeVaxxed = false;
        }
        return canBeVaxxed;
    }
}

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Objects;

public class WaitQueue {
    Patient currentPatient; //The current patient being placed in the wait queue

    LinkedList list = new LinkedList(); //Initilize the linked list
    LinkedList.ListIterator listIterator = list.iterator(); //Initilize the list iterator used to move through the link list for an easier time to add and take away nodes

    public void insert(Patient newPatient){ //Will insert a patient into the linked list

        // if empty list
        // just add
        // if not an empty list
        // check the priority of each patient
        // if newPatient.Queue() <= p.Queue() then p = p.next
        //
        //
        int s = list.Size(); //Determines the size of the list. This is because the first two nodes of the linked list are a special case since they have a lot of null pointers that need to be arrainged
        //System.out.println(s);
        listIterator.Restart(); //Starts the list to the beggining
        //Patient currentPatient; //Current patient being traversed in the linked list. Used for compareson
        int currentPatientQueue; //Priority queue of patient being checked
        int newPatientQueue = newPatient.getPriorityQueue();//Priority queue of the patient being added

        if(s == 0){
            list.AddtoStartFirstCase(newPatient);
            printList();
            return;
        }
        currentPatient = listIterator.position.GetCurrentPatient(); //Finds the patient in the current node
        currentPatientQueue = currentPatient.getPriorityQueue(); //Priority queue of the patient in the node
        //System.out.println("Current Patient queue: " + currentPatientPos + ", " + "New Patient queue: " + newPatientQueue);

        while(listIterator.position != null){
            System.out.println("Current P Name: " + currentPatient.getPatientName() + " New P Name: " + newPatient.getPatientName());
            System.out.println("Current P Queue: " + currentPatientQueue + " New P Queue: " + newPatientQueue);
            if(newPatientQueue == 0){
                list.AddToEnd(newPatient);
                printList();
                listIterator.Restart();
                return;
            }else if(currentPatientQueue >= newPatientQueue) {
                if(listIterator.Next() == null) {
                    list.AddToEnd(newPatient);
                    printList();
                    listIterator.Restart();
                    return;
                }else{
                    listIterator.position = listIterator.Next();
                    System.out.println("To next patient");
                    currentPatient = listIterator.position.GetCurrentPatient(); //Finds the patient in the current node
                    currentPatientQueue = currentPatient.getPriorityQueue(); //Priority queue of the patient in the node
                }
            }else{
                if(listIterator.previous == null){
                    list.AddtoStart(newPatient);
                }else{
                    listIterator.AddNodeHere(newPatient);
                }
                printList();
                listIterator.Restart();
                return;
            }
        }
        //System.out.println("List position: " + listIterator.position.GetCurrentPatient().getPatientName());

        s = list.Size();
        //System.out.println("Size of linked list: " + s);
        //System.out.println(currentPatient.getPatientName());
        printList();
    }

    public void printList(){ //Print the Linked list
        list.OutputList();
        System.out.println(" ");
    }

    public void removeMax(){ //Remove the first node. Dosent technicly work
        list.DeleteHeadNode();
    }

    public void getPatient(Patient newPatient){ //Recives the new patient and checks its position and trys to insert it
        currentPatient = newPatient;

        insert(currentPatient); //Insert patient
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

    public int CompareTimer(String currPatient, String newPatient){
        int timeDiff = 0;
        String[] currPatientTimeSplit = currPatient.split(":");
        int currPatientHour = Integer.valueOf(currPatientTimeSplit[0]);
        int currPatientMinute = Integer.valueOf(currPatientTimeSplit[1]);

        String[] newPatientTimeSplit = newPatient.split(":");
        int newPatientHour = Integer.valueOf(newPatientTimeSplit[0]);
        int newPatientMinute = Integer.valueOf(newPatientTimeSplit[1]);

        if(currPatientHour >= newPatientHour && currPatientMinute > newPatientMinute) {
            timeDiff = 1;
        } else if(currPatientHour <= newPatientHour && currPatientMinute < newPatientMinute){ //If the new patient has arrived later in the day compared to the current patient in node return -1
            timeDiff = -1;
        }else if(currPatientHour == newPatientHour && currPatientMinute ==newPatientMinute){
            timeDiff = 0;
        }
        return timeDiff;
    }
}

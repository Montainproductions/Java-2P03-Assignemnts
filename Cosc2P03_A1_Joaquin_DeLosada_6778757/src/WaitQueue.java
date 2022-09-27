import java.util.Objects;

public class WaitQueue {
    Patient currentPatient; //The current patient being placed in the wait queue
    int patientScore; //Patients priority queue

    LinkedList list = new LinkedList(); //Initilize the linked list
    LinkedList.ListIterator listIterator = list.iterator(); //Initilize the list iterator used to move through the link list for an easier time to add and take away nodes

    public void insert(Patient newPatient){ //Will insert a patient into the linked list
        int s = list.Size(); //Determines the size of the list. This is because the first two nodes of the linked list are a special case since they have a lot of null pointers that need to be arrainged
        //System.out.println(s);
        listIterator.Restart(); //Starts the list to the beggining
        Patient currentPatient; //Current patient being traversed in the linked list. Used for compareson
        int currentPatientPos; //Priority queue of patient being checked
        int newPatientQueue = newPatient.getPriorityQueue();//Priority queue of the patient being added

        if(s == 0){ //If there is no nodes add start it
            System.out.println(s);
            list.AddtoStartFirstCase(newPatient);
            printList();
            return;
        }

        currentPatient = listIterator.position.GetCurrentPatient(); //Finds the patient in the current node
        currentPatientPos = currentPatient.getPriorityQueue(); //Priority queue of the patient in the node

        if(currentPatientPos == newPatientQueue){
            int timeDiff = CompareTimer(currentPatient.getPatientTimeOfArrival(), newPatient.getPatientTimeOfArrival());
            if(timeDiff == -1){
                listIterator.Next();
            } else if(timeDiff == 1){
                listIterator.AddNodeHere(newPatient);
                listIterator.Restart(); //Starts the list to the beggining
            }
        }else if(currentPatientPos > newPatientQueue){
            listIterator.Next();
        }else if(currentPatientPos < newPatientQueue){
            listIterator.AddNodeHere(newPatient);
            listIterator.Restart(); //Starts the list to the beggining
        }else{
            list.AddToEnd(newPatient);
        }
        s = list.Size();
        System.out.println(s);
        printList();
        //System.out.println(currentPatient.getPatientName());
    }

    public void printList(){ //Print the Linked list
        list.OutputList();
    }

    public void removeMax(){ //Remove the first node. Dosent technicly work
        list.DeleteHeadNode();
    }

    public void getPatient(Patient newPatient){ //Recives the new patient and checks its position and trys to insert it
        currentPatient = newPatient;
        CalcPos(currentPatient); //Calculate priority queue
        currentPatient.setPriorityQueue(patientScore);
        insert(currentPatient); //Insert patient

        //System.out.println(currentPatient.getPatientName());
        //System.out.println(patientScore);
    }

    public void CalcPos(Patient newPatient){ //Will calculate the priority queue of the patient
        patientScore = 0;
        if(currentPatient.getPatientAge() >= 60){
            patientScore++;
        }
        if(Objects.equals(currentPatient.getPatientOccupation(), "Teacher") || Objects.equals(currentPatient.getPatientOccupation(), "Nurse") || Objects.equals(currentPatient.getPatientOccupation(), "Care Giver")){
            patientScore++;
        }
        if(Objects.equals(currentPatient.getPatientCondition(), "Pregnant") || Objects.equals(currentPatient.getPatientCondition(), "Cancer") || Objects.equals(currentPatient.getPatientCondition(), "Diabetes") || Objects.equals(currentPatient.getPatientCondition(), "Asthma") || Objects.equals(currentPatient.getPatientCondition(), "Primary Immune Deficiency") || Objects.equals(currentPatient.getPatientCondition(), "Cardiovascular Disease")){
            patientScore++;
        }
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

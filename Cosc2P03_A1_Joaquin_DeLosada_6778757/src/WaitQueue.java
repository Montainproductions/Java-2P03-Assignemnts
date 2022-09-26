public class WaitQueue {
    Patient currentPatient; //The current patient being placed in the wait queue
    int patientScore; //Patients priority queue

    LinkedList list = new LinkedList(); //Initilize the linked list
    LinkedList.ListIterator listIterator = list.iterator(); //Initilize the list iterator used to move through the link list for an easier time to add and take away nodes

    public void insert(Patient newPatient){ //Will insert a patient into the linked list
        int s = list.Size(); //Determines the size of the list. This is because the first two nodes of the linked list are a special case since they have a lot of null pointers that need to be arrainged
        System.out.println(s);
        listIterator.Restart(); //Starts the list to the beggining
        Patient currentPatient; //Current patient being traversed in the linked list. Used for compareson
        int currentPatientPos; //Priority queue of patient being checked
        int newPatientPos = newPatient.getPriorityQueue();//Priority queue of the patient being added

        if(s == 0){ //If there is no nodes add start it
            list.FirstLink(newPatient);
            return;
        }

        currentPatient = listIterator.position.GetCurrentPatient(); //Finds the patient in the current node
        currentPatientPos = currentPatient.getPriorityQueue(); //Priority queue of the patient in the node

        if(currentPatientPos == newPatientPos){ //If it has the same priority que then check which patient came first.
            int timeDiff = CompareTimer(currentPatient.getPatientTimeOfArrival(), newPatient.getPatientTimeOfArrival()); //Returns a 1,0,-1 depending on when it came 1 being new patient arrived sooner, and -1 later thea the current node patient
            System.out.println(timeDiff);
            if(timeDiff == -1){ //If later than insert it here and start again
                if(s == 1){
                    list.FinalLink(newPatient);
                }else{
                    listIterator.AddNodeHere(currentPatient); //Add the patient in that position
                    listIterator.Restart(); //Back to the start if the linked list
                    return;
                }
            }else{
                listIterator.Next(); //Next patient
            }
        }else if((listIterator.previous.GetCurrentPatient().getPriorityQueue() == newPatientPos) && (currentPatientPos < newPatientPos)){ //In case the patient the last person to arrive for that priority number than add it at the end of that list.
            listIterator.AddNodeHere(currentPatient); //Add the patient in that position
            listIterator.Restart(); //Back to the start if the linked list
            return;
        }else{
            listIterator.Next(); //Next Patient
        }

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
        if(currentPatient.getPatientOccupation() == "Teacher" || currentPatient.getPatientOccupation() == "Nurse" || currentPatient.getPatientOccupation() == "Care Giver"){
            patientScore++;
        }
        if(currentPatient.getPatientCondition() == "Pregnancy" || currentPatient.getPatientCondition() == "Cancer" || currentPatient.getPatientCondition() == "Diabetes" || currentPatient.getPatientCondition() == "Asthma" || currentPatient.getPatientCondition() == "Primary Immune Deficiency" || currentPatient.getPatientCondition() == "Cardiovascular Disease"){
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
        } else if ((currPatientHour <= newPatientHour && currPatientMinute < newPatientMinute)) {
            timeDiff = -1;
        }
        return timeDiff;
    }
}

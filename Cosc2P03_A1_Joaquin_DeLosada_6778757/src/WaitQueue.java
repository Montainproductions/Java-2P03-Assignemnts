public class WaitQueue {
    Patient currentPatient;
    int patientScore;

    LinkedList list = new LinkedList();
    LinkedList.ListIterator listIterator = list.iterator();

    public void insert(Patient newPatient){
        currentPatient = newPatient;
        int s = list.Size();
        System.out.println(s);
        if(s == 0){
            list.AddtoStart(newPatient,patientScore);
        }else{
            Patient currentPatient = listIterator.position.GetCurrentPatient();
            if(currentPatient.getPriorityQueue() == newPatient.getPriorityQueue()){
                int timeDiff = CompareTimer(currentPatient.getPatientTimeOfArrival(), newPatient.getPatientTimeOfArrival());
                if(timeDiff == -1){
                    listIterator.AddNodeHere(currentPatient);
                }else{
                    listIterator.Next();
                }
            }else{
                listIterator.Next();
            }

            listIterator.MovetoCorrectPosition(newPatient);
        }
        //System.out.println(currentPatient.getPatientName());
    }

    public void printList(){
        list.OutputList();
    }

    public void removeMax(){
    }

    public void getPatient(Patient newPatient){
        currentPatient = newPatient;
        CalcPos(currentPatient);
        currentPatient.setPriorityQueue(patientScore);
        insert(currentPatient);

        //System.out.println(currentPatient.getPatientName());
        //System.out.println(patientScore);
    }

    public void CalcPos(Patient newPatient){
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

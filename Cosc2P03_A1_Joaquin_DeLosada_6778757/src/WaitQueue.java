public class WaitQueue {
    Patient currentPatient;
    int patientScore;

    LinkedList list = new LinkedList();

    public void insert(Patient newPatient){
        currentPatient = newPatient;
        list.AddtoStart(newPatient,patientScore);
        int s = list.Size();
        /*if(s == 1){
            list.AddtoStart(newPatient,patientScore);
        }else{
            CalcPos(currentPatient);
            for(currentValues){
                if(repeating){
                    FindTimeDiff;
                    Node.AddNode(newPatient);
                    NewResizedArray(patientScore, Pos);
                }
            }
        }*/
        System.out.println(currentPatient.getPatientName());
        //list.OutputList();
    }

    public void removeMax(){
    }

    public void getPatient(Patient newPatient){
        currentPatient = newPatient;
        CalcPos(currentPatient);
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
}

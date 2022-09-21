public class WaitQueue {
    Patient currentPatient;
    int patientScore;

    /*
    s = 1 //Arraysize
    int[] currentValues = new int[s]


    public void insert(Patient newPatient){
        currentPatient = newPatient;
        if(s == 1){
            Node.AddNode(newPatient);
        }else{
            CalcPos();
            for(currentValues){
                if(repeating){
                    FindTimeDiff;
                    Node.AddNode(newPatient);
                    NewResizedArray(patientScore, Pos);
                }
            }
        }
    }
    */

    public void removeMax(){
    }

    public void getPatient(Patient newPatient){
        currentPatient = newPatient;
    }

    /*public void CalcPos(){
        patientScore = 0;
        if(currentPatient.getPatientAge >= 60){
            patientScore++;
        }
        if(currentPatient.getPatientOccupation == "Teacher" || currentPatient.getPatientOccupation == "Nurse" || currentPatient.getPatientOccupation == "Care Giver"){
            patientScore++;
        }
        if(currentPatient.getPatientCondition == "Pregnancy" || currentPatient.getPatientCondition == "Cancer" || currentPatient.getPatientCondition == "Diabetes" || currentPatient.getPatientCondition == "Asthma" || currentPatient.getPatientCondition == "Primary Immune Deficiency" || currentPatient.getPatientCondition == "Cardiovascular Disease"){
            patientScore++;
        }
    }*/
}

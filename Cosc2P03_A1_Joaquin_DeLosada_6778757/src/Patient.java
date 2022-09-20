public class Patient {

    String patientName;
    int patientAge;
    String patientOccupation;
    String patientCondition;
    String patientTimeOfArrival;

    public void setPatientName(String name){
        patientName = name;
    }

    public void setPatientAge(int age){
        patientAge = age;
    }

    public void setPatientOccupation(String occupation){
        patientOccupation = occupation;
    }

    public void setPatientCondition(String condition){patientCondition = condition;}

    public void setPatientTimeOfArrival(String time){patientTimeOfArrival = time;}

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientOccupation() {
        return patientOccupation;
    }

    public String getPatientCondition(){return patientCondition;}

    public String getPatientTimeOfArrival(){return patientTimeOfArrival;}
}

public class Patient {

    String patientName;
    int patientAge;
    String patientOccupation;

    public void setPatientName(String name){
        patientName = name;
    }

    public void setPatientAge(int age){
        patientAge = age;
    }

    public void setPatientOccupation(String occupation){
        patientOccupation = occupation;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientOccupation() {
        return patientOccupation;
    }
}

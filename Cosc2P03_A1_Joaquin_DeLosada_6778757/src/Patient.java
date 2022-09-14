public class Patient {

    static String patientName;
    static int patientAge;
    static String Occupation;

    public static void SetPatientName(String name){
        patientName = name;
    }

    public static void SetPatientAge(int age){
        patientAge = age;
    }

    public static String getPatientName() {
        return patientName;
    }
}

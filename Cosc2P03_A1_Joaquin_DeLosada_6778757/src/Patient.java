public class Patient {

    String patientName; //The name of the patient

    /* I did not add the gender that it has no use for a wait queue and saves a tiny bit of space*/

    int patientAge; //Patients current age
    String patientOccupation; //Patients current Occupation
    String patientCondition; //Patients current condition
    String patientTimeOfArrival; //The time the patient arrived to the clinic
    int priorityQueue; //The priority queue of the patient

    public void setPatientName(String name){patientName = name;} //Sets the patients name

    public void setPatientAge(int age){patientAge = age;} //Sets the patients age

    public void setPatientOccupation(String occupation){patientOccupation = occupation;} //Sets the patients occupation

    public void setPatientCondition(String condition){patientCondition = condition;} //Sets the patients condition

    public void setPatientTimeOfArrival(String time){patientTimeOfArrival = time;} //Sets the time the patient arrived

    public void setPriorityQueue(int priorityQueue){this.priorityQueue = priorityQueue;} //Sets  the priority queue of patient

    public String getPatientName(){return patientName;} //Returns the current patients name

    public int getPatientAge(){return patientAge;} //Returns the patients age

    public String getPatientOccupation(){return patientOccupation;} //Returns the patients occupation

    public String getPatientCondition(){return patientCondition;} //Returns the patients condition

    public String getPatientTimeOfArrival(){return patientTimeOfArrival;} //Returns the patients time of arrival

    public int getPriorityQueue(){return priorityQueue;} //Returns the patients priority queue
}

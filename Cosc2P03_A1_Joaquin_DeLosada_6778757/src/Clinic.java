import javax.lang.model.element.Name;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Clinic {
    public static InternalTimer timer = new InternalTimer(); //Instantiates timer
    public static WaitQueue wq = new WaitQueue(); //Instantiates the waitqueue
    public static Patient[] patients; //Instantiates the patients array
    public static int currPatientToEnter = 0; //The current array position

    public static void RunClinic(){ //reads the data and monitors when to send someone to wait queue
        ReadData();
        Monitor();
    }

    public static void ReadData(){
        File txtFile = new File("recourses//Patients.txt"); //Gets the file
        BufferedReader readFile;
        int totalArrayLength = 0; //Counter used to create the patients array.
        try { //Try this code
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file

            String line = ""; //String that will contain each line
            ArrayList<String> patientList = new ArrayList<>();
            //System.out.println(readFile);
            while(line != null){ //Loop through the txt file
                line = readFile.readLine(); //Read the line
                if(line == null){break;} //If the current line is null it will stop reading
                if(line.contains("Name")){} //If the line ever contains name then it will do nothing. This is used for the first line of the txt which dosent contain a patient
                else{ //Will add to the current patients list and increase size of patients array for later
                    totalArrayLength++;
                    patientList.add(line);
                }
            }
            patients = new Patient[totalArrayLength]; //Create the array of ADT of patients of the size of patients
            patientList.forEach((i) ->{ //Go through each arraylist of patient string to  split the string up and add it to a patient data type
                String[] currentPatient = i.split("\\t"); //Spliting the string into an array
                Patient newPatient = new Patient(); //Create a patient data type
                newPatient.setPatientName(currentPatient[0]); //Set the patients name
                newPatient.setPatientAge(Integer.valueOf(currentPatient[2])); //Set the patients age
                newPatient.setPatientOccupation(currentPatient[3]); //Set the patients occupation
                newPatient.setPatientCondition(currentPatient[4]); //Set the patients condition
                newPatient.setPatientTimeOfArrival(currentPatient[5]); //Set the patients time of arrival
                patients[patientList.indexOf(i)] = newPatient; //Add the patient to the array of patients
                //System.out.println("Current patient: " + newPatient.getPatientName());
                //System.out.println("Patient Array: " + patients);
            });
        } catch(FileNotFoundException e){ //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        } catch (IOException e) { //If the reader cant find a line through this exception
            throw new RuntimeException(e);
        }
    }

    public static void Monitor(){
        timer.StartDay(); //Start the day and 9 am
        boolean beingVaxxed = false;
        for(int i = 0; i <= 479; i++) { //Each in number is one minute and will run through the whole day. Done in case more people are added to the list at a later time
            timer.TimerIncrease(); //Increase by one minute
            int timeDiff = timer.CompareTime(patients[currPatientToEnter].getPatientTimeOfArrival()); //Checks if the current patient has the same time as current patient then sends them in.
            //System.out.println("Time diffrence: " + timeDiff);
            if (timeDiff == 0) { //If the same time then send them to the wait queue
                wq.getPatient(patients[currPatientToEnter]); //Sends to wait queue
                if(!((currPatientToEnter + 1) == patients.length)){ //If there are still patients in array then check the next one
                    currPatientToEnter++;
                }
                //System.out.println("Current pos in array: " + currPatientToEnter);
            }else if(timeDiff == -1){//If the current patient has a past their current time then break. This is mostly for the last person in the array so it dosent infenetly continue the for loop when there arent any more people coming into the building.
                break;
            }
            beingVaxxed = wq.CheckVax(beingVaxxed); //Checks if somebody can be vacced and if true then the patient is being vacced
            if(beingVaxxed){ //If the patient is being vacced then run this
                beingVaxxed = timer.VaccineTimer(); //Will flip being vacced to false
                wq.removeMax(); //Remove first person in list
            }
        }
        wq.printList(); //Print the current list of wait queue
    }

    public static void main(String[] args) {
        RunClinic();
    }
}
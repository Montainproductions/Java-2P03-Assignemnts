import javax.lang.model.element.Name;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Clinic {
    public static void RunClinic(){
        ReadData();
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
            Patient[] patients = new Patient[totalArrayLength]; //Create the array of ADT of patients of the size of patients
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
            InternalTimer timer = new InternalTimer(); //Set the timer
            timer.StartDay(); //Start the day and 9 am
        } catch(FileNotFoundException e){ //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        } catch (IOException e) { //If the reader cant find a line through this exception
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        RunClinic();
    }
}
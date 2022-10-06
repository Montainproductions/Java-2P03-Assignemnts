import java.io.*;
import java.util.ArrayList;

public class DrugBank {
    public static Drug[] drugsArray;


    public void ReadData() {
        File txtFile = new File("recourses//dockedApproved.tab"); //Gets the file
        BufferedReader readFile;
        int totalArrayLength = 0; //Counter used to create the patients array.


        try{ //Try this code
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file

            String line = ""; //String that will contain each line
            ArrayList<String> patientList = new ArrayList<>();
            //System.out.println(readFile);
            while (line != null) { //Loop through the txt file
                line = readFile.readLine(); //Read the line
                if (line == null) {
                    break;
                } //If the current line is null it will stop reading
                if (line.contains("Generic Name")) {} //If the line ever contains name then it will do nothing. This is used for the first line of the txt which dosent contain a patient
                else { //Will add to the current patients list and increase size of patients array for later
                    totalArrayLength++;
                    patientList.add(line);
                }
            }
            drugsArray = new Drug[totalArrayLength]; //Create the array of ADT of patients of the size of patients
            patientList.forEach((i) ->{ //Go through each arraylist of patient string to  split the string up and add it to a patient data type
                String[] currentDrug = i.split("\\t"); //Spliting the string into an array
                Drug newDrug = new Drug(); //Create a patient data type
                newDrug.SetGenericName(currentDrug[0]); //Set the drug name
                newDrug.SetSmiles(currentDrug[1]); //Set the drug SMILES
                newDrug.SetDrugBankID(currentDrug[2]); //Set drug ID
                newDrug.SetURL(currentDrug[3]); //Set drug URL
                newDrug.SetDrugGroup(currentDrug[4]); //Set drug group
                newDrug.SetScore(currentDrug[5]); //Set the patients age
                //System.out.println("Current patient: " + newPatient.getPatientName());
                //System.out.println("Patient Array: " + patients);
            });
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
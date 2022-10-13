import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

public class DrugBank {
    public Drug root;

    public Drug currentDrug;

    public void Start(){}

    public static Drug[] drugsArray;


    public void ReadData() {
        File txtFile = new File("recourses//dockedApproved.tab"); //Gets the file
        BufferedReader readFile;
        int totalArrayLength = 0; //Counter used to create the patients array.


        try{ //Try this code
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file

            String line = ""; //String that will contain each line
            ArrayList<String> drugList = new ArrayList<>();
            //System.out.println(readFile);
            while (line != null) { //Loop through the txt file
                line = readFile.readLine(); //Read the line
                if (line == null) {
                    break;
                } //If the current line is null it will stop reading
                if (line.contains("Generic Name")) {} //If the line ever contains name then it will do nothing. This is used for the first line of the txt which dosent contain a patient
                else { //Will add to the current patients list and increase size of patients array for later
                    totalArrayLength++;
                    drugList.add(line);
                }
            }
            drugsArray = new Drug[totalArrayLength]; //Create the array of ADT of patients of the size of patients
            drugList.forEach((i) ->{ //Go through each arraylist of patient string to  split the string up and add it to a patient data type
                String[] currentDrug = i.split("\\t"); //Spliting the string into an array
                Drug newDrug = new Drug(currentDrug[0], currentDrug[1], currentDrug[2], currentDrug[3], currentDrug[4], currentDrug[5]); //Create a patient data type
                //System.out.println("Current patient: " + newPatient.getPatientName());
                //System.out.println("Patient Array: " + patients);
                drugsArray[drugList.indexOf(i)] = newDrug;
            });
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }
    }

    public void DisplayDrug(){
        currentDrug.DisplayDrug();
    }

    public void CreateBinaryNode(){
        root = Insert(drugsArray[0],drugsArray[1]);
    }

    public Drug Insert(Drug currentDrug, Drug newDrug){
        String[] newDrugIDString = newDrug.ReturnDrugBankID().split("D");
        /*
        if(currentDrug == null){
            return new Drug(newDrug);
        }

        if(newDrug.ReturnDrugBankID() < currentDrug.ReturnDrugBankID()){
            currentDrug.left = Insert(currentDrug.left, newDrug);
        } else if(newDrug.ReturnDrugBankID() > currentDrug.ReturnDrugBankID()){
            currentDrug.left = Insert(currentDrug.left, newDrug);
        }else{
            return currentDrug;
        }
        */

        System.out.println(newDrugIDString[0]);
        return currentDrug;
    }

    public void Depth(Drug drugNode, int depthValue){

    }

    public int Depth2(Drug drugNode){
        if(drugNode == null){
            return -1;
        }
        if((drugNode.left == null) && (drugNode.right == null)){
            return 0;
        }

        int d = Math.max(Depth2(drugNode.left), Depth2(drugNode.right));
        return d+1;
    }

    public void InOrderTraverse(Drug drugNode){
        if(drugNode == null){
            return;
        }

        InOrderTraverse(drugNode.left);
        //maincode?
        DisplayDrug();

        InOrderTraverse(drugNode.right);
    }
}

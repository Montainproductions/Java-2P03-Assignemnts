import java.io.*;
import java.lang.Math;
import java.util.ArrayList;

public class DrugHeap {
    File writeTo = new File("recourses//dockedApprovedSorted.tab");

    public BufferedWriter writeToFile;

    public Drug root;

    public ArrayList<String> drugList = new ArrayList<>();
    public Drug[] drugArray;

    public Drug[] heapDrugArray;
    public int currentSize;

    //Will read the data from the file and place it in a array list
    public void ReadData() {
        File txtFile = new File("recourses//dockedApproved.tab"); //Gets the file
        BufferedReader readFile;
        int totalArrayLength = 0; //Counter used to create the patients array.


        try{ //Try this code
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file

            String line = ""; //String that will contain each line
            //ArrayList<String> drugList = new ArrayList<>();
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
            drugArray = new Drug[totalArrayLength]; //Create the array of ADT of drug of the size of patients
            drugList.forEach((i) ->{ //Go through each arraylist of drug string to split the string up and add it to a drug data type
                String[] currentPatient = i.split("\\t"); //Spliting the drug into an array
                Drug newDrug = new Drug(); //Create a drug data type
                newDrug.SetGenericName(currentPatient[0]); //Set the drug name
                newDrug.SetSmiles(currentPatient[2]); //Set the drug smiles
                newDrug.SetDrugBankID(currentPatient[3]); //Set the drug ID
                newDrug.SetURL(currentPatient[4]); //Set the drug URL
                newDrug.SetDrugGroup(currentPatient[5]); //Set the drugs group
                newDrug.SetScore(currentPatient[6]); //Set the drugs score
                drugArray[drugList.indexOf(i)] = newDrug; //Add the drug to the array of drugs
            });
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }

        //Runs the method for creating a method and allowing java to later write to said method
        CreateFile();
    }

    //If the file called "Docked Approved Sorted" dosent exist it will create it or then nothing will happen. It will then set up the buffer writer so that it can later write to the file.
    public void CreateFile(){
        try {
            if(writeTo.createNewFile()) {
                System.out.println("File Created: " + writeTo.getName());
            }else{
                System.out.println("File exists.");
            }

            writeToFile = new BufferedWriter(new PrintWriter(writeTo));
        }catch(IOException e){
            System.out.println("Error 404");
        }
    }

    public void Insert(Drug newDrug){
        if(currentSize == heapDrugArray.length - 1){
            EnlargeArray(heapDrugArray.length * 2 + 1);
        }

        int hole = ++currentSize;
        for(heapDrugArray[0] = newDrug; newDrug.compareTo(heapDrugArray[hole/2])<0; hole/= 2){
            heapDrugArray[hole] = heapDrugArray[hole/2];
        }
        heapDrugArray[hole] = newDrug;
    }

    public void EnlargeArray(int newArraySize){
        
    }
}

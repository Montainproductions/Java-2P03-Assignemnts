import java.io.*;
import java.lang.Math;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class DrugHeap {
    File writeToInOrderTraverse = new File("recourses//sockedApprovedInOrder.tab");
    File writeToHeapSorted = new File("recourses//dockedApprovedSorted.tab");

    public BufferedWriter writeFileInOrder, writeHeapSorted;

    public Drug root;

    public ArrayList<String> drugList = new ArrayList<>();

    public Drug[] drugArray;


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
                newDrug.SetSmiles(currentPatient[1]); //Set the drug smiles
                newDrug.SetDrugBankID(currentPatient[2]); //Set the drug ID
                newDrug.SetURL(currentPatient[3]); //Set the drug URL
                newDrug.SetDrugGroup(currentPatient[4]); //Set the drugs group
                newDrug.SetScore(currentPatient[5]); //Set the drugs score
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
            if(writeToInOrderTraverse.createNewFile()) {
                System.out.println("File Created: " + writeToInOrderTraverse.getName());
            }else{
                System.out.println("File exists.");
            }

            if(writeToHeapSorted.createNewFile()) {
                System.out.println("File Created: " + writeToHeapSorted.getName());
            }else{
                System.out.println("File exists.");
            }

            writeFileInOrder = new BufferedWriter(new PrintWriter(writeToInOrderTraverse));
            writeHeapSorted = new BufferedWriter(new PrintWriter(writeToHeapSorted));
        }catch(IOException e){
            System.out.println("Error 404");
        }
    }

    /*public void Insert(Drug newDrug){
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

    }*/

    public void BuildHeap(){
        for(int i = drugArray.length/2; i > 0; i--){
            TrickleDown(1);
        }

        System.out.println("Building Heap done");
    }

    /*public Drug RemoveMin(){
        if(drugList.isEmpty()){
            throw new BufferUnderflowException();
        }

        Drug minItem = FindMin();
        heapDrugArray[1] = heapDrugArray[currentSize--];
        TrickleDown(1);

        return minItem;
    }*/

    public void InOrderTraverse(){
        InOrderTraverse(root); //Goes in order and saves into "" file

        //Once all is saved it will "Try" to close the file. But if its gotten to this point then the file already exists and it has been found
        try {
            writeFileInOrder.close();
        }catch (IOException e){
            System.out.println("Error 404");
        }

        //Confirmation message it has finished
        System.out.println("In order traversal complete.");
    }

    public void InOrderTraverse(Drug drugNode){
        if(drugNode == null){
            return;
        }

        //Go to the left drug node
        InOrderTraverse(drugNode.left);
        System.out.println("Hello");
        //Will write all the drug info to the file and then go to the next file. Unless the file dosent exist or cant write more
        try {
            writeFileInOrder.write(drugNode.ReturnName() + " " + drugNode.ReturnSMILES() + " " + drugNode.ReturnDrugBankID() + " " + drugNode.ReturnURL() + " " + drugNode.ReturnGroup() + " " + drugNode.ReturnScore() + System.getProperty("line.separator"));
            writeFileInOrder.newLine();
        }catch (IOException e){
            System.out.println("Error 404");
        }

        //Go to the right drug node
        InOrderTraverse(drugNode.right);
    }


    public void HeapSort(){
        BuildHeap();
        for(int i = drugArray.length/2-1; i >= 0; i--){
            Drug newDrug = TrickleDown(drugArray, 0, i);
            try {
                writeHeapSorted.write(newDrug.ReturnName() + " " + newDrug.ReturnSMILES() + " " + newDrug.ReturnDrugBankID() + " " + newDrug.ReturnURL() + " " + newDrug.ReturnGroup() + " " + newDrug.ReturnScore() + System.getProperty("line.separator"));
                writeHeapSorted.newLine();
            }catch (IOException e){
                System.out.println("Error 404");
            }
        }

        try {
            writeHeapSorted.close();
        }catch (IOException e){
            System.out.println("Error 404");
        }

        System.out.println("Heap sorted");
    }

    private void TrickleDown( int hole ){
        int child;
        Drug tmp = drugArray[hole];
        for( ; hole * 2 <= drugArray.length; hole = child ) {
            child = hole * 2;
            if (child != drugArray.length && drugArray[child + 1].ReturnDrugBankID().compareTo(drugArray[child].ReturnDrugBankID()) < 0) {
                child++;
            }

            if (drugArray[child].ReturnDrugBankID().compareTo(tmp.ReturnDrugBankID()) < 0){
                drugArray[hole] = drugArray[child];
            }else{
                break;
            }
        }
        drugArray[ hole ] = tmp;
    }

    public Drug TrickleDown(Drug[] heapDrug,int i, int n){
        int child;
        Drug tmp;

        for(tmp = heapDrug[i]; LeftChild(i) < n; i = child){
            child = LeftChild(i);

            if(child != n - 1 && heapDrug[child].ReturnDrugBankID().compareTo(heapDrug[child + 1].ReturnDrugBankID()) < 0) {
                child++;
            }
            if(tmp.ReturnDrugBankID().compareTo(heapDrug[child].ReturnDrugBankID()) < 0){
                heapDrug[i] = heapDrug[child];
            }else{
                break;
            }
        }
        heapDrug[i] = tmp;
        //System.out.println(heapDrug[i].ReturnDrugBankID());
        return heapDrug[i];
    }

    public int LeftChild(int i){
        return 2 * i + 1;
    }
}

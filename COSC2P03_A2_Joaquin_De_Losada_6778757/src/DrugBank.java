import java.io.*;
import java.lang.Math;
import java.util.ArrayList;

public class DrugBank {

    public Drug root;

    public ArrayList<String> drugList = new ArrayList<>();

    public int depthSize;

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
                    drugList.add(line);
                }
            }
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }

        CreateFile();
    }

    public void CreateFile(){
        try {
            File writeTo = new File("recourses//dockedApprovedSorted.tab");
            if(writeTo.createNewFile()) {
                System.out.println("File Created: " + writeTo.getName());
            }else{
                System.out.println("File exists.");
            }
        }catch(IOException e){
            System.out.println("Error 404");
        }
    }

    //Will create the Binadry tree
    public void Create(ArrayList<String> insertionDrugs){
        for(int i = 0; i < insertionDrugs.size(); i++){
            //InOrderTraverse();
            Insert(i);
        }
    }

    //The method that starts the recursion of inserting the drugs into the tree
    public void Insert(int arrayValue){
        root = Insert(root,drugList.get(arrayValue));
    }

    //Will insert the drug in the closest apropiate position
    public Drug Insert(Drug currentDrug, String newDrugString){
        String[] currentDrugArray = newDrugString.split("\\t"); //Spliting the string into an array

        //Create a new Drug in the null position
        if(currentDrug == null){
            return new Drug(currentDrugArray[0], currentDrugArray[1], currentDrugArray[2], currentDrugArray[3], currentDrugArray[4], currentDrugArray[5]);
        }

        //System.out.println(currentDrug.drugBankID);

        //Turn the string of the int value to check position
        int newDrugID = DrugIDToInt(currentDrugArray[2]);

        //Grab the ID of the current Drug
        int currentDrugID = DrugIDToInt(currentDrug);

        //If the drug id is less than the current drug ID then go to the left else if it's greater than go to the right. If it's the same value then just return the value
        if(newDrugID < currentDrugID){
            currentDrug.left = Insert(currentDrug.left, newDrugString);
        } else if(newDrugID > currentDrugID){
            currentDrug.right = Insert(currentDrug.right, newDrugString);
        }else{
            return currentDrug;
        }

        return currentDrug;
    }

    public void InOrderTraverse(){
        InOrderTraverse(root);
        System.out.println("In order traversal complete");
    }

    //Will traverse through the tree and print each drugs info
    public void InOrderTraverse(Drug drugNode){
        if(drugNode == null){
            return;
        }

        InOrderTraverse(drugNode.left);
        try {
            FileWriter writeToFile = new FileWriter("recourses//dockedApprovedSorted.tab");
            writeToFile.write(drugNode.ReturnName());
            writeToFile.write(drugNode.ReturnSMILES());
            writeToFile.write(drugNode.ReturnDrugBankID());
            writeToFile.write(drugNode.ReturnURL());
            writeToFile.write(drugNode.ReturnGroup());
            writeToFile.write(drugNode.ReturnScore());
            writeToFile.close();
        }catch (IOException e){
            System.out.println("Error 404");
        }
        InOrderTraverse(drugNode.right);
    }

    //Search method called for main class
    public void Search(String drugIDString){
        System.out.println(" ");
        System.out.println("Drug " + drugIDString + " found: ");
        Search(root, drugIDString).DisplayDrug();
    }

    //Main search method that is meant to be called recursivly
    public Drug Search(Drug drugNode, String drugIDString){
        if(drugNode == null){ //If the first node is null then return null
            return null;
        }

        //Turns the given node or string into an int to later check
        int currentDrugID = DrugIDToInt(drugNode);
        int searchDrugID = DrugIDToInt(drugIDString);

        if(searchDrugID == currentDrugID){ //If the ID of the drug im searching is the same as the current drugs ID then display it
            //DisplayDrug(drugNode);
            return drugNode;
        }else if(searchDrugID < currentDrugID){ //If the ID of the drug I'm searching is less than the current drugID than go to the left and continue
            depthSize++;
            return Search(drugNode.left, drugIDString);
        }else{ //If the ID of the drug I'm searhing is greater than the current drug ID then go to the right and continue
            depthSize++;
            return Search(drugNode.right, drugIDString);
        }
    }

    //Will recive the String for the drug that will be eliminated
    public void Delete(String drugToEliminateID){
        Delete(root, Search(root,drugToEliminateID), drugToEliminateID);

        System.out.println("Drug " + drugToEliminateID+ " found and eliminated.");
    }

    //Recursive function that will go through the tree and delete
    public Drug Delete(Drug currentDrug, Drug drugToEliminate, String drugIDToEliminate){
        if(currentDrug == null){
            return null;
        }

        //Turn the drug ID String to int
        int currentDrugID = DrugIDToInt(currentDrug);
        int searchDrugID = DrugIDToInt(drugIDToEliminate);

        //If the drug ID that i'm serching is less than the current one then it will go left else if the ID of the search is greater than the current Drug then it will go to the right. else if both are null than it will find the next value and connect it the next one so that it deletes
        if(searchDrugID < currentDrugID){
            return Delete(currentDrug.left, drugToEliminate, drugIDToEliminate);
        }else if(searchDrugID > currentDrugID){
            return Delete(currentDrug.right, drugToEliminate, drugIDToEliminate);
        } else if(currentDrug.left != null && currentDrug.right !=null){
            currentDrug = FindMin(currentDrug.right);
            currentDrug.right = Delete(currentDrug.right, currentDrug, drugIDToEliminate);
        }

        return currentDrug;
    }

    public void Depth1(String drugID){
        depthSize = 0;
        Search(root,drugID);
        System.out.println(" ");
        System.out.println("Depth value of drug " + drugID + " is: " + depthSize);
    }

    //Base Depth search that will run the main recursion method.
    public void Depth2(){
        System.out.println(" ");
        System.out.println("Longest depth of tree is: " + Depth2(root));
    }

    //Will find the largest depth of the tree
    public int Depth2(Drug drugNode){
        if(drugNode == null){ //If the node is null then return -1
            return -1;
        }
        //If both next values are null then return 0
        if((drugNode.left == null) && (drugNode.right == null)){
            return 0;
        }

        //Find the largest number and then return the value and add 1
        int d = Math.max(Depth2(drugNode.left), Depth2(drugNode.right));
        return d+1;
    }

    //Turn a string into an int ID
    public int DrugIDToInt(String drugID){
        String[] drugIDString = drugID.split("B");

        return Integer.parseInt(drugIDString[1]);
    }

    //Grab the ID from the drug
    public int DrugIDToInt(Drug drug){
        String[] drugIDString = drug.ReturnDrugBankID().split("B");

        return Integer.parseInt(drugIDString[1]);
    }

    //Returns the arraylist
    public ArrayList<String> ReturnDrugArray(){
        return drugList;
    }

    //Find the lowest value of current subtree (last .left)
    public Drug FindMin(Drug currentDrug){
        if(currentDrug == null){
            return null;
        }else if(currentDrug.left == null){
            return currentDrug;
        }

        return FindMin(currentDrug);
    }
}

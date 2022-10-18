import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

public class DrugBank {

    public Drug root, currentDrug;

    public ArrayList<String> drugList = new ArrayList<>();

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
    }

    public void DisplayDrug(){
        currentDrug.DisplayDrug();
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

        if(currentDrug == null){
            return new Drug(currentDrugArray[0], currentDrugArray[1], currentDrugArray[2], currentDrugArray[3], currentDrugArray[4], currentDrugArray[5]);
        }

        System.out.println(currentDrug.drugBankID);

        int newDrugID = DrugIDToInt(currentDrugArray[2]);

        int currentDrugID = DrugIDToInt(currentDrug);

        if(newDrugID < currentDrugID){
            currentDrug.left = Insert(currentDrug.left, newDrugString);
        } else if(newDrugID > currentDrugID){
            currentDrug.right = Insert(currentDrug.right, newDrugString);
        }else{
            return currentDrug;
        }

        return currentDrug;
    }

    //Will traverse through the tree and print each drug
    public void InOrderTraverse(Drug drugNode){
        if(drugNode == null){
            return;
        }

        InOrderTraverse(drugNode.left);
        DisplayDrug();

        InOrderTraverse(drugNode.right);
    }

    //Search method called for main class
    public Drug Search(String drugIDString){
        return Search(root, drugIDString);
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
            DisplayDrug();
            return drugNode;
        }else if(searchDrugID < currentDrugID){ //If the ID of the drug I'm searching is less than the current drugID than go to the left and continue
            return Search(drugNode.left, drugIDString);
        }else{ //If the ID of the drug I'm searhing is greater than the current drug ID then go to the right and continue
            return Search(drugNode.right, drugIDString);
        }
    }

    public Drug Delete(String drugToEliminateID){
        return Delete(root, Search(drugToEliminateID));
    }

    public Drug Delete(Drug currentDrug, Drug drugToEliminate){
        if(currentDrug == null){
            return null;
        }

        String drugIDToEliminate = drugToEliminate.ReturnDrugBankID();

        int currentDrugID = DrugIDToInt(currentDrug);
        int searchDrugID = DrugIDToInt(drugIDToEliminate);

        if(searchDrugID < currentDrugID){
            return Delete(currentDrug.left, drugToEliminate);
        }else if(searchDrugID > currentDrugID){
            return Delete(currentDrug.right, drugToEliminate);
        } else if(currentDrug.left != null && currentDrug.right !=null){
            currentDrug = FindMin(currentDrug.right);
            currentDrug.right = Delete(currentDrug.right, currentDrug);
        }

        return currentDrug;
    }

    public int Depth1(String drugID){
        return Depth1(Search(drugID));
    }

    public int Depth1(Drug drugNode){
        int d = Math.max(Depth2(drugNode.left), Depth2(drugNode.right));
        return d+1;
    }

    public int Depth2(){
        return Depth2(root);
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

    //Turn a string into an int ID
    public int DrugIDToInt(String drugID){
        String[] drugIDString = drugID.split("B");

        return Integer.parseInt(drugIDString[1]);
    }

    public int DrugIDToInt(Drug drug){
        String[] drugIDString = drug.ReturnDrugBankID().split("B");

        return Integer.parseInt(drugIDString[1]);
    }

    public ArrayList<String> ReturnDrugArray(){
        return drugList;
    }

    public Drug FindMin(Drug currentDrug){
        if(currentDrug == null){
            return null;
        }else if(currentDrug.left == null){
            return currentDrug;
        }

        return FindMin(currentDrug);
    }
}

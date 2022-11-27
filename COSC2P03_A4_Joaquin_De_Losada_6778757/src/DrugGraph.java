import java.io.*;
import java.lang.Math;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Scanner;

public class DrugGraph {
    public ArrayList<String> vertexList = new ArrayList<>();
    public ArrayList<String> similaritiesList = new ArrayList<>();
    public Vertex[] vertices;

    public int[][] w,a;

    File writeToInOrderTraverse = new File("recourses//MSTPrimResult.txt");
    public BufferedWriter writeFileInOrder;

    public void ReadData() {
        LoadMainData();
        LoadSIMMAT();

        //Runs the method for creating a method and allowing java to later write to said method
        CreateFile();
    }

    public void LoadMainData(){
        File txtFile = new File("recourses//dockedApproved.tab"); //Gets the file
        BufferedReader readFile;

        int totalArrayLength = 0;

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
                    vertexList.add(line);
                }
            }
            vertices = new Vertex[totalArrayLength]; //Create the array of ADT of drug of the size of patients
            vertexList.forEach((i) ->{ //Go through each arraylist of drug string to split the string up and add it to a drug data type
                String[] currentPatient = i.split("\\t"); //Spliting the drug into an array
                Vertex newVertex = new Vertex(); //Create a drug data type
                newVertex.SetGenericName(currentPatient[0]); //Set the drug name
                newVertex.SetSmiles(currentPatient[1]); //Set the drug smiles
                newVertex.SetDrugBankID(currentPatient[2]); //Set the drug ID
                newVertex.SetURL(currentPatient[3]); //Set the drug URL
                newVertex.SetDrugGroup(currentPatient[4]); //Set the drugs group
                newVertex.SetScore(currentPatient[5]); //Set the drugs score
                vertices[vertexList.indexOf(i)] = newVertex; //Add the drug to the array of drugs
            });
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }
    }

    public void LoadSIMMAT(){
        File txtFile = new File("recourses//sim_mat.tab"); //Gets the file
        BufferedReader readFile;
        int row = 0;

        try{ //Try this code
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file
            //Scanner scanner = new Scanner(new BufferedReader(new FileReader(txtFile))); //Read file

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
                    row++;
                    similaritiesList.add(line);
                }
            }
            w = new int[row][row]; //Create the array of ADT of drug of the size of patients
            similaritiesList.forEach((i) ->{ //Go through each arraylist of drug string to split the string up and add it to a drug data type
                String[] currentPatient = i.split("\\t"); //Spliting the drug into an array
                for(int j = 0; j < currentPatient.length; j++){
                    //w[i][j] = currentPatient[j];
                }
            });
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }
    }

    public void CreateFile(){
        try {
            if(writeToInOrderTraverse.createNewFile()) {
                System.out.println("File Created: " + writeToInOrderTraverse.getName());
            }else{
                System.out.println("File exists.");
            }

            writeFileInOrder = new BufferedWriter(new PrintWriter(writeToInOrderTraverse));
        }catch(IOException e){
            System.out.println("Error 404");
        }
    }

}

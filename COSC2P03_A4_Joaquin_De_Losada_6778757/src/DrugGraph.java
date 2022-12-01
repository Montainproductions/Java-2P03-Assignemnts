import java.io.*;
import java.lang.Math;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DrugGraph {
    public ArrayList<String> vertexList = new ArrayList<>();
    public ArrayList<String> similaritiesList = new ArrayList<>();
    public Vertex[] vertices;

    public float[][] w;
    public int[][] a;

    File writeToInOrderTraverse = new File("recourses//MSTPrimResult.txt");
    public BufferedWriter writeFileInOrder;

    public void ReadData() {
        LoadMainData();
        System.out.println("Loaded Drugs/Vectors");
        System.out.println("Loaded SIMMAT file and created box Weighted and Unweighted matrix");

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
            w = new float[totalArrayLength][totalArrayLength]; //Create the array of ADT of drug of the size of patients
            a = new int[totalArrayLength][totalArrayLength];
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
                newVertex.SetVisitied(false);
                vertices[vertexList.indexOf(i)] = newVertex; //Add the drug to the array of drugs

                for(int j = 0; j < currentPatient.length; j++){
                    int x = vertexList.indexOf(i);
                    //System.out.println(currentPatient[x]);

                    float currentVal = Float.parseFloat(currentPatient[j]);
                    float WeightedValv = (1 - currentVal);

                    if(WeightedValv <= 0.7){
                        //System.out.println("Connected Graph");
                        w[x][j] = WeightedValv;
                    }else{
                        w[x][j] = (float)(1.0/0.0);
                    }
                }
            });
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }

        UnWeightedMatrix();
    }

    public void UnWeightedMatrix(){
        for(int x = 0; x < w.length; x++){
            for(int y = 0; y < w.length; y++){
                if(w[x][y] <= 0.7){
                    a[x][y] = 1;
                }else{
                    a[x][y] = 0;
                }
            }
        }
    }

    public void FindModules(){
        int moduleGroup = 0; //How do I know when to increase
        for(int x = 0; x < a.length; x++){
            for(int y = 0; y < a.length; y++){

                if(a[x][y] == 1){

                    BFS(DrugIDToInt(vertices[y].ReturnDrugBankID()));
                    //BFS(vertices[y], moduleGroup);
                }
            }
        }
    }

    public void BFS(int i){

    }

    /*public void BFS(Vertex s, int moduleGroup){
        s.dist = 0;
        queue.enqueue(s);
        while queue is not empty{
            Vertex v = Q.dequeue();
            v.wasVisited = true;
            for each vertex w adjacent to v{
                if(w.dist > v.dist+1)// we can improve w.dist by going through v to w
                {
                    w.dist = v.dist + 1;
                    w.path = v;
                    Q.enqueue(w);
                }
            }
        }
    }*/

    //Turn a string into an int ID
    public int DrugIDToInt(String drugID){
        String[] drugIDString = drugID.split("B");

        return Integer.parseInt(drugIDString[1]);
    }

    //Grab the ID from the drug
    public int DrugIDToInt(Vertex vertex){
        String[] drugIDString = vertex.ReturnDrugBankID().split("B");

        return Integer.parseInt(drugIDString[1]);
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

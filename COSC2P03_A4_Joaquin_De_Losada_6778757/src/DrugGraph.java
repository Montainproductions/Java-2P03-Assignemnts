import java.io.*;
import java.lang.Math;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class DrugGraph {
    public ArrayList<String> vertexList = new ArrayList<>();
    public ArrayList<Vertex> sameModuleList = new ArrayList<>();
    public Vertex[] vertices, keepModule;

    public LinkedList<Vertex> linkedList;

    public float[][] w, w2;
    public int[][] a, a2;

    public int toTheLeft;
    public int upTheMatrix;

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
                newVertex.SetModule(-1);
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
            if(vertices[x].wasVisited){
                break;
            }else{

            }
            /*for(int y = 0; y < a.length; y++){
                if(a[x][y] == 1);
            }*/
        }
    }

    public void BFS(int i){

    }

    public void BFS(Vertex s, int moduleGroup){
        LinkedList<Vertex> bfsLL = new LinkedList<>();
        s.dist = 0;
        bfsLL.add(s);
        /*while(!bfsLL.isEmpty()){
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
        }*/
    }


    public void KeepAModule(int moduleID){
        int size = 0;
        for(Vertex vertex : vertices){
            if(vertex.ReturnModule() == moduleID){
                sameModuleList.add(vertex);
                size++;
            }
        }
        w2 = new float[size][size]; //Create the array of ADT of drug of the size of patients
        a2 = new int[size][size];

        toTheLeft = 0;
        upTheMatrix = 0;
        //sameModuleList.forEach((i) ->{ //Only uncomment and run if you dont want to use your computer. lol
            for(int x = 0; x < w.length; x++){
                if(vertices[x].ReturnModule() != moduleID){
                    upTheMatrix++;
                    break;
                }
                for(int y = 0; y < w.length; y++){
                    if(vertices[y].ReturnModule() != moduleID){
                        toTheLeft++;
                        break;
                    }
                    w2[x - upTheMatrix][y - toTheLeft] = w[x][y];
                    a2[x - upTheMatrix][y - toTheLeft] = a[x][y];
                }
            }
        //});
    }

    public void FindShortestPath(Vertex fromVertex, Vertex toVertex, String method){
        if(Objects.equals(method, "unweighted")){
            unweightedShortestPath(fromVertex, toVertex);
        } else if (Objects.equals(method, "weighted")) {
            WeightedShortestPath(fromVertex,toVertex);
        }
    }

    public void unweightedShortestPath(Vertex start, Vertex finish) {
        for(int i = 0; i < keepModule.length; i++){
            keepModule[i].dist = (float)(1.0/0.0);
            keepModule[i].wasVisited = false;
        }
        finish.dist = 0;

        /*for (int currDist = 0; currDist < NUM_VERTICES; currDist++) {
            for (int i = 0; i < vertices.length; i++) {
                if (!vertices[i].wasVisited && vertices[i].dist == currDist) {
                    vertices[i].wasVisited = true;
                    for each Vertex w adjacent to v {
                        if (w.dist == INFINITY) {
                            w.dist = currDist + 1;
                            w.path = v;
                        }
                    }
                }
            }
        }*/
    }

    public void WeightedShortestPath(Vertex start, Vertex finish){

        for(int i = 0; i < keepModule.length; i++){
            keepModule[i].dist = (float)(1.0/0.0);
            keepModule[i].wasVisited = false;
        }
        finish.dist = 0;

        /*while( there is an unknown distance vertex )
        {
            Vertex v = smallest unknown distance vertex;
            v.known = true;
            for each Vertex w adjacent to v
            if( !w.known )
            {
                DistType cvw = cost of edge from v to w;
                if( v.dist + cvw < w.dist )
                {
// Update w
                    decrease( w.dist to v.dist + cvw );
                    w.path = v;
                }
            }
        }*/
    }

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

import java.io.*;
import java.lang.Math;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Objects;
import java.util.Scanner;

public class DrugGraph {
    public ArrayList<String> vertexList = new ArrayList<>();
    public ArrayList<String> simmatList = new ArrayList<>();
    public ArrayList<Vertex> sameModuleList = new ArrayList<>();
    public Vertex[] vertices, keepModule;

    public Queue<Vertex> q = new LinkedList<>();

    public LinkedList<Vertex> linkedList;

    public float[][] w, w2;
    public int[][] a, a2;

    public int toTheLeft;
    public int upTheMatrix;

    File writeToInOrderTraverse = new File("recourses//MSTPrimResult.txt");
    public BufferedWriter writeFileInOrder;

    public void ReadData() {
        LoadMainData();

        //Runs the method for creating a method and allowing java to later write to said method
        CreateFile();
    }

    public void LoadMainData(){
        File mainTxtFile = new File("recourses//dockedApproved.tab"); //Gets the file
        File simmatTxtFile = new File("recourses//sim_mat.tab"); //Gets the file

        BufferedReader mainReadFile, sim_mat;

        int totalArrayLength = 0;

        try{ //Try this code
            mainReadFile = new BufferedReader(new FileReader(mainTxtFile)); //Read file
            sim_mat = new BufferedReader(new FileReader(simmatTxtFile)); //Read sim mat file

            String line = ""; //String that will contain each line
            String lineSimMat = "";
            //ArrayList<String> drugList = new ArrayList<>();
            //System.out.println(readFile);
            while(line != null){
                line = mainReadFile.readLine(); //Read the line
                if (line == null) {
                    break;
                } //If the current line is null it will stop reading
                if (line.contains("Generic Name")) {} //If the line ever contains name then it will do nothing. This is used for the first line of the txt which dosent contain a patient
                else { //Will add to the current patients list and increase size of patients array for later
                    totalArrayLength++;
                    vertexList.add(line);
                }
            }

            while (lineSimMat != null) { //Loop through the txt file
                lineSimMat = sim_mat.readLine(); //Read the line
                if (lineSimMat == null) {
                    break;
                }
                simmatList.add(lineSimMat);
            }

            w = new float[totalArrayLength][totalArrayLength]; //Create the array of ADT of drug of the size of patients
            a = new int[totalArrayLength][totalArrayLength];
            vertices = new Vertex[totalArrayLength]; //Create the array of ADT of drug of the size of patients
            //System.out.println(vertexList.get(0));
            for(String i : vertexList){ //Go through each arraylist of drug string to split the string up and add it to a drug data type
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
            }
            System.out.println("Loaded Drugs/Vectors.");

            for(String x : simmatList){
                String[] currentPatient = x.split("\\t"); //Spliting the drug into an array
                for(int y = 0; y < currentPatient.length; y++){
                    float currentVal = Float.parseFloat(currentPatient[y]);
                    float WeightedValv = (1 - currentVal);

                    if(WeightedValv <= 0.7){
                        //System.out.println("Connected Graph");
                        w[simmatList.indexOf(x)][y] = WeightedValv;
                    }else{
                        w[simmatList.indexOf(x)][y] = (float)(1.0/0.0);
                    }
                }
            }
            System.out.println("Loaded SimMat and created weighted matrix.");
        } catch (IOException e) { //If the file isnt found then print this
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        }

        UnWeightedMatrix();
        System.out.println("Unweighted matrix made.");
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
            //System.out.println(vertices[x].moduleGroup);
            if(vertices[x].moduleGroup != -1){
                //moduleGroup++;
                //break;
            }else{
                //moduleGroup++;
                BFS(vertices[x], moduleGroup, x);
            }
            System.out.println(moduleGroup);
            /*for(int y = 0; y < a.length; y++){
                if(a[x][y] == 1);
            }*/
        }
        //System.out.println(moduleGroup);
        System.out.println("All modules found.");
    }

    public void BFS(int i){

    }

    public void BFS(Vertex s, int moduleGroup, int rowVertex){
        LinkedList<Vertex> bfsLL = new LinkedList<>();
        for(Vertex vertex : vertices){
            vertex.SetDist((float)(1.0/0.0));
        }
        s.dist = 0;
        bfsLL.add(s);
        while(!bfsLL.isEmpty()){
            Vertex v = bfsLL.remove();
            v.wasVisited = true;
            for(int y = 0; y < w.length; y++){
                if(vertices[y].dist == (float)(1.0/0.0)){// we can improve w.dist by going through v to w{
                    vertices[y].dist = v.dist + 1;
                    vertices[y].moduleGroup = moduleGroup;
                    //vertices[y].path = v;
                    bfsLL.add(vertices[y]);
                }
            }
        }
    }

    public void BFSSingleModule(Vertex s, int moduleGroup, int rowVertex){
        LinkedList<Vertex> bfsLL = new LinkedList<>();
        for(Vertex vertex : sameModuleList){
            vertex.SetDist((float)(1.0/0.0));
        }
        s.dist = 0;
        bfsLL.add(s);
        while(!bfsLL.isEmpty()){
            Vertex v = bfsLL.remove();
            v.wasVisited = true;
            for(int y = 0; y < w2.length; y++){
                if(sameModuleList.get(y).dist == (float)(1.0/0.0)){// we can improve w.dist by going through v to w{
                    sameModuleList.get(y).dist = v.dist + 1;
                    sameModuleList.get(y).moduleGroup = moduleGroup;
                    //vertices[y].path = v;
                    bfsLL.add(sameModuleList.get(y));
                }
            }
        }
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

        System.out.println("Module " + moduleID + " kept.");
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

        for(int i = 0; i < sameModuleList.size(); i++){
            sameModuleList.get(i).dist = (float)(1.0/0.0);
            sameModuleList.get(i).wasVisited = false;
        }
        finish.dist = 0;

        /*while( there is an unknown distance vertex ){
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

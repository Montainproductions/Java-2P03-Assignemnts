/*
Student name: Joaquin De Losada
Student ID: 6778757
Professor: Yifang Li
 */

public class Main {
    public static void main(String[] args) {
        DrugGraph dg = new DrugGraph();
        dg.ReadData();
        dg.FindModules();
        dg.KeepAModule(0);
        dg.FindShortestPath("DB01050", "DB00316", "unweighted");
        //dg.FindShortestPath(’DB01050’, ’DB00316’, ’weighted’);
        //dg.MSTPrim();
    }
}
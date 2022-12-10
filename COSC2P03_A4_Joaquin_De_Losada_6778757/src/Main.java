public class Main {
    public static void main(String[] args) {
        DrugGraph dg = new DrugGraph();
        dg.ReadData();
        dg.FindModules();
        dg.KeepAModule(0);
        dg.FindShortestPath("DB01050", "DB00316", "unweighted");
        //dg.findShorestPath(’DB01050’, ’DB00316’, ’weighted’);
        //dg.MSTPrim();
    }
}
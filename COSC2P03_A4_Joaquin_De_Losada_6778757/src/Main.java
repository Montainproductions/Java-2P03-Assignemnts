public class Main {
    public static void main(String[] args) {
        DrugGraph dg = new DrugGraph();
        dg.ReadData();
        dg.FindModules();
        //dg.keepAModule(0);
        //dg.findShorestPath(’DB01050’, ’DB00316’, ’unweighted’);
        //dg.findShorestPath(’DB01050’, ’DB00316’, ’weighted’);
        //dg.MSTPrim();
    }
}
public class Vertex {
    public String genericName, sMILES, drugBankID, url, drugGroups, score, path;

    public float dist;

    public boolean wasVisited;

    public Vertex(){

    }

    public Vertex(String GenericName, String SMILES, String DrugBankID, String URL, String DrugGroup, String Score, boolean WasVisited, float Dist, String Path){
        SetGenericName(GenericName);
        SetSmiles(SMILES);
        SetDrugBankID(DrugBankID);
        SetURL(URL);
        SetDrugGroup(DrugGroup);
        SetScore(Score);
        SetVisitied(WasVisited);
        SetDist(Dist);
        SetPath(Path);
    }

    public void SetGenericName(String name){this.genericName = name;}

    public void SetSmiles(String sMILES){this.sMILES = sMILES;}

    public void SetDrugBankID(String drugID){this.drugBankID = drugID;}

    public void SetURL(String url){this.url = url;}

    public void SetDrugGroup(String group){this.drugGroups = group;}

    public void SetScore(String score){this.score = score;}

    public void SetVisitied(boolean wasVisited){this.wasVisited = wasVisited;}

    public void SetDist(float dist){this.dist = dist;}

    public void SetPath(String path){this.path = path;}

    public void DisplayDrug(){
        System.out.println("Drug name: " + genericName);
        System.out.println("Drug SMILES?: " + sMILES);
        System.out.println("Drug ID: " + drugBankID);
        System.out.println("Drug URL: " + url);
        System.out.println("Drug Group: " + drugGroups);
        System.out.println("Drug Score: " + score);
        System.out.println("Drug Visited: " + wasVisited);
        System.out.println("Drug Distance: " + dist);
        System.out.println("Drug Path: " + path);
        System.out.println(" ");
    }

    public String ReturnName(){return genericName;}

    public String ReturnSMILES(){return sMILES;}

    public String ReturnDrugBankID(){return drugBankID;}

    public String ReturnURL(){return url;}

    public String ReturnGroup(){return drugGroups;}

    public String ReturnScore(){return score;}

    public boolean ReturnVisited(){return wasVisited;}

    public float ReturnDist(){return dist;}

    public String ReturnPath(){return path;}
}

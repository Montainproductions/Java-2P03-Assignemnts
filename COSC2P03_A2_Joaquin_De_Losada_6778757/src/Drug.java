public class Drug {
    public int drugBankID, score;

    public String genericName, url, drugGroups;

    public boolean SMILES;

    public Drug left, right;

    public void SetDrugBankID(int drugID){
        drugBankID = drugID;
    }

    public void SetScore(int score){
        this.score = score;
    }

    public void SetGenericName(String name){
        genericName = name;
    }

    public void SetURL(String url){
        this.url = url;
    }

    public void SetDrugGroup(String group){
        drugGroups = group;
    }

    public void DisplayDrug(){
        System.out.println("Drug name: " + genericName);
        System.out.println("Drug ID: " + drugBankID);
        System.out.println("Drug Score: " + score);
        System.out.println("Drug URL: " + url);
        System.out.println("Drug Group: " + drugGroups);
        System.out.println("Drug SMILES?: " + SMILES);
        System.out.println(" ");
    }

    public int ReturnDrugBankID(){
        return drugBankID;
    }

    public int ReturnScore(){
        return score;
    }

    public String ReturnName(){
        return genericName;
    }

    public String ReturnURL(){
        return url;
    }

    public String ReturnGroup(){
        return drugGroups;
    }
}

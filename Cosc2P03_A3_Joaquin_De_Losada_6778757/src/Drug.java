public class Drug {
    public String genericName, sMILES, drugBankID, url, drugGroups, score;

    public Drug left, right;

    public Drug(){
        left = null;
        right = null;
    }

    public Drug(String genericName, String SMILES, String DrugBankID, String URL, String DrugGroup, String Score){
        SetGenericName(genericName);
        SetSmiles(SMILES);
        SetDrugBankID(DrugBankID);
        SetURL(URL);
        SetDrugGroup(DrugGroup);
        SetScore(Score);
        left = null;
        right = null;
    }

    /*public void Drug(Drug newDrug){
        left = null;
        right = null;
    }*/

    public void SetGenericName(String name){genericName = name;}

    public void SetSmiles(String sMILES){this.sMILES = sMILES;}

    public void SetDrugBankID(String drugID){drugBankID = drugID;}

    public void SetURL(String url){this.url = url;}

    public void SetDrugGroup(String group){drugGroups = group;}

    public void SetScore(String score){this.score = score;}

    public void DisplayDrug(){
        System.out.println("Drug name: " + genericName);
        System.out.println("Drug SMILES?: " + sMILES);
        System.out.println("Drug ID: " + drugBankID);
        System.out.println("Drug URL: " + url);
        System.out.println("Drug Group: " + drugGroups);
        System.out.println("Drug Score: " + score);
        System.out.println(" ");
    }

    public String ReturnName(){return genericName;}

    public String ReturnSMILES(){return sMILES;}

    public String ReturnDrugBankID(){return drugBankID;}

    public String ReturnURL(){return url;}

    public String ReturnGroup(){return drugGroups;}

    public String ReturnScore(){return score;}
}


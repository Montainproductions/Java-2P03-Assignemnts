public class Main {
    public static void main(String[] args) {
        DrugBank db = new DrugBank();

        db.ReadData();

        db.Create(db.ReturnDrugArray());
    }
}
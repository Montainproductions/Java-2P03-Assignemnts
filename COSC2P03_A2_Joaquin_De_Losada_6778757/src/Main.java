import java.util.ArrayList;

//Student Name: Joaquin De Losada
//Student ID: 6778757
//Professor: Yifeng Li

public class Main {
    public static void main(String[] args) {
        DrugBank db = new DrugBank();

        db.ReadData();
        db.Create(db.ReturnDrugArray());
        db.InOrderTraverse();
        db.Depth1("DB01050");
        db.Depth2();
        db.Search("DB01050");
        db.Search("DB00316");
        db.Delete("DB01050");
    }
}
public class Main {

//readdata, trickleDown, buildHeap, removeMin, inordertraverse, heapSort
    public static void main(String[] args) {
        DrugHeap db = new DrugHeap();

        db.ReadData();
        db.Create(db.ReturnDrugArray());
        db.InOrderTraverse();
        db.Depth1("DB01050");
        db.Depth2();
        db.Search("DB01050");
        db.Search("DB00316");
        db.Delete("DB01050");
        System.out.println("Hello world!");
    }
}
public class Main {

//readdata, trickleDown, buildHeap, removeMin, inordertraverse, heapSort
    public static void main(String[] args) {
        DrugHeap db = new DrugHeap();

        db.ReadData();
        db.BuildHeap();
        //db.InOrderTraverse();
        //db.HeapSort();
    }
}
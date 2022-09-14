import java.io.*;
public class Clinic {
    public static void RunClinic(){
        StartTimer();
        ReadData();
    }

    public static void StartTimer(){

    }

    public static void ReadData(){
        File file = FileReader("C:\\Users\\monta\\IdeaProjects\\COSC2P03_A1_Joaquin_DeLosada_6778757\\src\\patients.txt");
    }

    public static void main(String[] args) {
        RunClinic();
    }
}
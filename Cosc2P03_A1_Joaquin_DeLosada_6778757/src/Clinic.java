import java.io.*;
public class Clinic {
    public static void RunClinic(){
        //StartTimer();
        ReadData();
    }

    public static void StartTimer(){

    }

    public static void ReadData(){
        File file = new File("C:\\Users\\monta\\Documents\\GitHub\\Java-2P03-Assignemnts\\Cosc2P03_A1_Joaquin_DeLosada_6778757\\src\\patients.txt");
        System.out.println(file);


    }

    public static void main(String[] args) {
        RunClinic();
    }
}
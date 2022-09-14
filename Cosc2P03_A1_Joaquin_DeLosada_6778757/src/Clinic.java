import java.io.*;
public class Clinic {
    public static void RunClinic(){
        //Timer();
        ReadData();
    }

    public static void Timer(){

    }

    public static void ReadData(){
        File file = new File("C:\\Users\\monta\\Documents\\GitHub\\Java-2P03-Assignemnts\\Cosc2P03_A1_Joaquin_DeLosada_6778757\\src\\patients.txt");
        System.out.println(file);

        //Sudo code
        /*for(string array[] line in file){
            if(line == null){return;}
            else if line[0]{return;}
            else{
                Patient newPatient = NewPatient(line);
                if(newPatient.TimeArrival() < Timer.CurrentTime()){
                    return;
                }else{
                    currentWaitQueue.AddToQueue(newPatient);
                    system.out.println(currentWaitQueue.ReturnCurrentQueue());
                }
            }
        }

         */
    }

    public static void main(String[] args) {
        RunClinic();
    }
}
import java.io.*;

public class Clinic {
    public static void RunClinic(){
        //Timer();
        ReadData();
    }

    public static void Timer(){
        int currentTime = 900;
        for(int i = 0; i <= 960; i++){
            if(i%2 == 0){
                currentTime++;
            }
            System.out.println(currentTime);
        }

        int vaccineTimer = 0;
        for(int i = 0; i <= 15; i++){
            vaccineTimer++;
            System.out.println(vaccineTimer);
        }
    }

    public static void ReadData(){
        File txtFile = new File("C:\\Users\\monta\\Documents\\GitHub\\Java-2P03-Assignemnts\\Cosc2P03_A1_Joaquin_DeLosada_6778757\\src\\patients.txt");
        System.out.println(txtFile);

        BufferedReader readFile;
        //"patients.txt"
        readFile = new BufferedReader(new FileReader("patients.txt")); //Read file in theory
        String line = "";
        /*while(line != null /*|| currentTime > "06:00"){
            line = readFile.readLine();
            String[] currentPatient = line.Split("  ", 6);
            //Patient[]
            System.out.print(currentPatient);
            /*if(currentPatient[5] <= currentTime){
                Patient newPatient = New Patient();

            }
        }*/
        //System.out.print(line);
        //readFile.close();

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
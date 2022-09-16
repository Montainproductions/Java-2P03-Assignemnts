import java.io.*;

public class Clinic {
    public static void RunClinic(){
        InternalTimer timer = new InternalTimer();
        //timer.StartDay();
        ReadData();
    }

    public static void ReadData(){
        File txtFile = new File("recourse//patients.txt");
        System.out.println(txtFile.exists());

        BufferedReader readFile;
        //"patients.txt"
        //readFile = new BufferedReader(new FileReader("recourses//patients.txt")); //Read file in theory
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
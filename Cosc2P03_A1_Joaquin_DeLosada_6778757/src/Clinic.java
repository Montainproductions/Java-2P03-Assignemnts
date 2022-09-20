import java.io.*;

public class Clinic {
    public static void RunClinic(){
        ReadData();
        InternalTimer timer = new InternalTimer();
        timer.StartDay();
    }

    public static void ReadData(){
        File txtFile = new File("recourses//Patients.txt");
        BufferedReader readFile;
        try {
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file in theory
            String line = "";
            //System.out.println(readFile);
            while(line != null /*|| currentTime > "06:00"*/){
                line = readFile.readLine();
                if(line == null){break;}
                //System.out.println(line);
                String[] currentPatient = line.split("  ");
                //Patient[]
                System.out.println(currentPatient);
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found. Did you try to move it? Not a good idea return it or give me 100%.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
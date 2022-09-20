import javax.lang.model.element.Name;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Clinic {
    public static void RunClinic(){
        ReadData();
        InternalTimer timer = new InternalTimer();
        timer.StartDay();
    }

    public static void ReadData(){
        File txtFile = new File("recourses//Patients.txt");
        BufferedReader readFile;
        int totalArrayLength = 0;
        try {
            readFile = new BufferedReader(new FileReader(txtFile)); //Read file in theory
            String line = "";
            ArrayList<String> patientList = new ArrayList<>();
            //System.out.println(readFile);
            while(line != null /*|| currentTime > "06:00"*/){
                line = readFile.readLine();
                if(line == null){break;}
                if(line.contains("Name")){}
                else{
                    totalArrayLength++;
                    patientList.add(line);
                }
            }
            Patient[] patients = new Patient[totalArrayLength];
            patientList.forEach((i) ->{
                String[] currentPatient = i.split("\\t");
                Patient newPatient = new Patient();
                newPatient.setPatientName(currentPatient[0]);
                newPatient.setPatientAge(Integer.valueOf(currentPatient[2]));
                newPatient.setPatientOccupation(currentPatient[3]);
                newPatient.setPatientCondition(currentPatient[4]);
                newPatient.setPatientTimeOfArrival(currentPatient[5]);
                patients[patientList.indexOf(i)] = newPatient;
                //System.out.println("Current patient: " + newPatient.getPatientName());
                //System.out.println("Patient Array: " + patients);
            });
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
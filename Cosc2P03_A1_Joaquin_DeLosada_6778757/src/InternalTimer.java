public class InternalTimer {
    int hour; //Current
    int minutes;

    public void StartDay(){ //Starting the day and setting up start time of work
        hour = 9; //Starting the hour at 9 am
        minutes = 0; //Starting the minutes
        Timer(); //Actually runs the clock of the world
    }

    public void Timer(){
        for(int i = 0; i <= 479; i++){
            if(minutes == 59){
                minutes = 0;
                hour++;
            }else{
                minutes++;
            }
            System.out.println(CurrentTime());
        }
    }

    public boolean VaccineTimer(){
        int vaccineTime = 0;
        for(int i = 0; i < 15; i++){
            vaccineTime++;
        }
        return true;
    }

    public String CurrentTime(){
        String currentHour = String.valueOf(hour);
        String currentMinute;
        if(minutes < 10){
            currentMinute = "0" + String.valueOf(minutes);
        }else{
            currentMinute = String.valueOf(minutes);
        }
        String currentTime = currentHour + ":" + currentMinute;
        return currentTime;
    }

    /*public int CompareTime(String patientTime){
        int timeDiff;


        return timeDiff;
    }*/
}

public class InternalTimer {
    int hour;
    int minutes;

    public void StartDay(){
        hour = 9;
        minutes = 0;
        Timer();
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
        String currentTime = String.valueOf(hour) + ":" + String.valueOf(minutes);
        return currentTime;
    }
}

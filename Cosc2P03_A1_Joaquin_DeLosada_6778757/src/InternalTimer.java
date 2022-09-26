public class InternalTimer {
    int hour; //Current hour
    int minutes; //Current minute

    public void StartDay(){ //Starting the day and setting up start time of work
        hour = 9; //Starting the hour at 9 am
        minutes = 0; //Starting the minutes
    }

    public void TimerIncrease(){ //Will increase the minute count each time called. Will do the same when an "hour" has passed
        if(minutes == 59){ //Once one hour has passed restart minutes and increase hour
            minutes = 0;
            hour++;
        }else{
            minutes++;
        }
        //System.out.println(CurrentTime());
    }

    public boolean VaccineTimer(){ //Starts the Vaccine timer
        int vaccineTime = 0; //Fluf int counter to make sure the for loop actually does 15 loops
        for(int i = 0; i < 15; i++){ //For loop representing the 15 min it takes to vaccinate. It will force
            vaccineTime++;
        }
        return false;
    }

    public String CurrentTime(){ //Returns  the current time as a string. Used mostly to check that it is the correct time.
        String currentHour = String.valueOf(hour);
        String currentMinute;
        if(minutes < 10){ //Formating the minutes in case its below 10 minutes
            currentMinute = "0" + String.valueOf(minutes);
        }else{
            currentMinute = String.valueOf(minutes);
        }
        String currentTime = currentHour + ":" + currentMinute; //Combining both minutes and hours to a single string
        return currentTime;
    }

    public int CompareTime(String patientTime){ //Method to compare a time given with the current time in the class.
        int timeDiff = 0;
        String[] patientTimeSplit = patientTime.split(":"); //Splits patients time into 2 numbers for minutes and hours
        int patientHour = Integer.valueOf(patientTimeSplit[0]);
        int patientMinute = Integer.valueOf(patientTimeSplit[1]);
        if(patientHour >= hour && patientMinute > minutes) { //If the patients hours are greater or if they are the same but the minutes are greater than the time diffrence is 1
            timeDiff = 1;
        } else if ((patientHour <= hour && patientMinute < minutes)) { //Else if its smaller then the time difference is -1
            timeDiff = -1;
        }

        return timeDiff;
    }
}

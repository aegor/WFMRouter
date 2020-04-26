package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;

public class timesheet implements Serializable {
    private int TimePinTypeId;
    private int Day;
    private int Minutes;
    private int NightMinutes;

    public int getTimePinTypeId() {
        return TimePinTypeId;
    }

    public void setTimePinTypeId(int timePinTypeId) {
        TimePinTypeId = timePinTypeId;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {
        Minutes = minutes;
    }

    public int getNightMinutes() {
        return NightMinutes;
    }

    public void setNightMinutes(int nightMinutes) {
        NightMinutes = nightMinutes;
    }

    public timesheet(int timePinTypeId, int day, int minutes, int nightMinutes) {
        TimePinTypeId = timePinTypeId;
        Day = day;
        Minutes = minutes;
        NightMinutes = nightMinutes;
    }

    public timesheet() {
    }
}

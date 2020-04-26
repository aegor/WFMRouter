package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;

public class plan implements Serializable {
    private int Day;
    private int Minutes;
    private int NightMinutes;

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

    public plan(int day, int minutes, int nightMinutes) {
        Day = day;
        Minutes = minutes;
        NightMinutes = nightMinutes;
    }

    public plan() {
    }
}

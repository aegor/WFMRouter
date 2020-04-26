package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;

public class overtime implements Serializable {
    private int Minutes;
    private int NightMinutes;

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

    public overtime(int minutes, int nightMinutes) {
        Minutes = minutes;
        NightMinutes = nightMinutes;
    }

    public overtime() {
    }
}

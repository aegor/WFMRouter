package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TimeSheetCreateOrUpdate extends MetaInfo implements Serializable {

    public ArrayList<timesheet> Timesheet = new ArrayList<>();
    public overtime OverTime;
}

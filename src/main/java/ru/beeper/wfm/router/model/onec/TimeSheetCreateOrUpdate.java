package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;
import java.util.List;

public class TimeSheetCreateOrUpdate extends MetaInfo implements Serializable {

    public List<timesheet> Timesheet;
    public overtime OverTime;
}

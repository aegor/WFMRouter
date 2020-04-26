package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;
import java.util.List;

public class TimeSheetCreateOrUpdate extends BaseRest implements Serializable {

    public List<timesheet> Timesheet;
    public overtime OverTime;
}

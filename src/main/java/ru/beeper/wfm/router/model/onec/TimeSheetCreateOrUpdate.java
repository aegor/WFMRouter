package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;
import java.util.List;

public class TimeSheetCreateOrUpdate extends BaseRest implements Serializable {

    private List<timesheet> Timesheet;
    private overtime OverTime;

    public List<timesheet> getTimesheet() {
        return Timesheet;
    }

    public void setTimesheet(List<timesheet> timesheet) {
        Timesheet = timesheet;
    }

    public overtime getOverTime() {
        return OverTime;
    }

    public void setOverTime(overtime overTime) {
        OverTime = overTime;
    }

    public TimeSheetCreateOrUpdate(int requestId, String employeeId1C, int employeeSourceId, int year, int month) {
        super(requestId, employeeId1C, employeeSourceId, year, month);
    }

    public TimeSheetCreateOrUpdate() {
    }
}

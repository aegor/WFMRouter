package ru.beeper.wfm.router.model.onec;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class BaseRest {

    private int RequestId;
    private String EmployeeId1C;
    private int EmployeeSourceId;
    private int Year;
    private int Month;

    public int getRequestId() {
        return RequestId;
    }

    public void setRequestId(int requestId) {
        RequestId = requestId;
    }

    public String getEmployeeId1C() {
        return EmployeeId1C;
    }

    public void setEmployeeId1C(String employeeId1C) {
        EmployeeId1C = employeeId1C;
    }

    public int getEmployeeSourceId() {
        return EmployeeSourceId;
    }

    public void setEmployeeSourceId(int employeeSourceId) {
        EmployeeSourceId = employeeSourceId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public BaseRest(int requestId, String employeeId1C, int employeeSourceId, int year, int month) {
        RequestId = requestId;
        EmployeeId1C = employeeId1C;
        EmployeeSourceId = employeeSourceId;
        Year = year;
        Month = month;
    }

    public BaseRest() {
    }
}

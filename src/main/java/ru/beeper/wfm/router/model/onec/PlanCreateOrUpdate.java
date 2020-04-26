package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanCreateOrUpdate extends BaseRest implements Serializable {

    private ArrayList<plan> Plan;

    public ArrayList<plan> getPlan() {
        return Plan;
    }

    public void setPlan(ArrayList<plan> plan) {
        Plan = plan;
    }

    public PlanCreateOrUpdate(int requestId, String employeeId1C, int employeeSourceId, int year, int month, ArrayList<plan> plan) {
        super(requestId, employeeId1C, employeeSourceId, year, month);
        Plan = plan;
    }

    public PlanCreateOrUpdate() {

    }
}

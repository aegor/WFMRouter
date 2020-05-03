package ru.beeper.wfm.router.model.onec;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanCreateOrUpdate extends MetaInfo implements Serializable {

    public ArrayList<plan> Plan = new ArrayList<> ();
}

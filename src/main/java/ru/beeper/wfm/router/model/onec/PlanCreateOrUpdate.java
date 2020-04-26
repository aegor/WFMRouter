package ru.beeper.wfm.router.model.onec;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PlanCreateOrUpdate extends BaseRest implements Serializable {

    @Getter @Setter private ArrayList<plan> Plan;
}

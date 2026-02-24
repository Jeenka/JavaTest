package Classes;

import Interfaces.Validable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkoutItem implements Validable {
    String exerciseCode;
    Integer sets;
    Integer reps;
    Integer restSec;
    Integer durationMin;

    @Override
    public void validate() {
        ValidatorUtility.validate(exerciseCode, "exerciseCode");
        ValidatorUtility.validateOptional(sets, "sets");
        ValidatorUtility.validateOptional(reps, "reps");
        ValidatorUtility.validateOptional(restSec, "restSec");
        ValidatorUtility.validateOptional(durationMin, "durationMin");

        if (restSec == null && durationMin == null) {
            throw new IllegalArgumentException("Either restSec or durationMin must be provided");
        }
    }
}

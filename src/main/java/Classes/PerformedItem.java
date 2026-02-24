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
public class PerformedItem implements Validable {
    String exerciseCode;
    int setsDone;
    int repsDone;
    Integer weight;
    Integer durationMin;

    @Override
    public void validate() {
        ValidatorUtility.validate(exerciseCode, "exerciseCode");
        ValidatorUtility.validate(setsDone, "setsDone");
        ValidatorUtility.validate(repsDone, "repsDone");
        ValidatorUtility.validateOptional(weight, "weight");
        ValidatorUtility.validateOptional(durationMin, "durationMin");
    }
}

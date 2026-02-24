package Classes;

import Enums.GoalType;
import Enums.Period;
import Interfaces.Identifiable;
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
public class Goal implements Identifiable<Integer>, Validable {
    int id;
    GoalType type;
    int targetValue;
    Period period;
    boolean active;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void validate() {
        ValidatorUtility.validate(id, "id");
        ValidatorUtility.validate(type, "type");
        ValidatorUtility.validate(targetValue, "targetValue");
        ValidatorUtility.validate(period, "period");
    }
}

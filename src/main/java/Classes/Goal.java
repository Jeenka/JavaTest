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

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal goal)) return false;
        return id == goal.id &&
                targetValue == goal.targetValue &&
                active == goal.active &&
                type == goal.type &&
                period == goal.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, targetValue, period, active);
    }
}

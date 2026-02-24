package Classes;

import Enums.WorkoutType;
import Interfaces.Identifiable;
import Interfaces.Validable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkoutTemplate implements Identifiable<Integer>, Validable {
    int id;
    String name;
    WorkoutType type;
    List<WorkoutItem> items;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void validate() {
        ValidatorUtility.validate(id, "id");
        ValidatorUtility.validate(name, "name");
        ValidatorUtility.validate(type, "type");
        /*if (items == null) {
            throw new IllegalArgumentException("items must not be null");
        }*/
    }
}

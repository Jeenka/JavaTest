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
import java.util.Objects;

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
        if (items == null) {
            throw new IllegalArgumentException("items must not be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutTemplate workoutTemplate)) return false;
        return id == workoutTemplate.id &&
                Objects.equals(name, workoutTemplate.name) &&
                type == workoutTemplate.type &&
                Objects.equals(items, workoutTemplate.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, items);
    }
}

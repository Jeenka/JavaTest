package Classes;
import Enums.Difficulty;
import Enums.Equipment;
import Enums.MuscleGroup;
import Interfaces.Identifiable;
import Interfaces.Validable;
import lombok.*;

import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exercise implements Identifiable<Integer>, Validable {
    int id;
    @NonNull
    String code;
    @NonNull
    String name;
    MuscleGroup muscleGroup;
    Equipment equipment;
    Difficulty difficulty;
    Integer caloriesPerMinute;
    String link;

    public Optional<Integer>getCaloriesPerMinute(){
        return Optional.ofNullable(caloriesPerMinute);
    }

    public Optional<String>Link(){
        return Optional.ofNullable(link);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void validate() {
        ValidatorUtility.validate(id, "id");
        ValidatorUtility.validate(code, "code");
        ValidatorUtility.validate(name, "name");
        ValidatorUtility.validate(muscleGroup, "muscleGroup");
        ValidatorUtility.validate(equipment, "equipment");
        ValidatorUtility.validate(difficulty, "difficulty");
        ValidatorUtility.validateOptional(caloriesPerMinute, "caloriesPerMinute");
        ValidatorUtility.validateLink(link, "link");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise exercise)) return false;
        return id == exercise.id &&
                Objects.equals(code, exercise.code) &&
                Objects.equals(name, exercise.name) &&
                muscleGroup == exercise.muscleGroup &&
                equipment == exercise.equipment &&
                difficulty == exercise.difficulty &&
                Objects.equals(caloriesPerMinute, exercise.caloriesPerMinute) &&
                Objects.equals(link, exercise.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, muscleGroup, equipment, difficulty, caloriesPerMinute, link);
    }
}

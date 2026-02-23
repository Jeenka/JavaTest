package Classes;
import Enums.Difficulty;
import Enums.Equipment;
import Enums.MuscleGroup;
import Interfaces.Validable;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exercise implements Validable {
    int id;
    //TODO: code
    @NonNull
    String name;
    MuscleGroup muscleGroup;
    Equipment equipment;
    Difficulty difficulty;
    Integer caloriesPerMinute;
    String link;
    //ValidatorUtility<String>
    //TODO: equals and hashCode, написать Validator на Link, использовать regex



    /*@Override
    public String toString() {
        return this.id + " " + this.name + " " + this.muscleGroup + " " + this.equipment + " " + this.difficulty + " " + getCaloriesPerMinute().orElseGet(() -> {return 0;});
    }*/

    /*public static Exercise getExercise(int id, @NonNull String name){
        return new Exercise(id, name, MuscleGroup.ARMS, Equipment.NONE, Difficulty.NONE, 0);
    }*/
    /*public Exercise(int id, @NonNull final String name, MuscleGroup muscleGroup, Equipment equipment, Difficulty difficulty, Integer caloriesPerMinute, String link){
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.caloriesPerMinute = caloriesPerMinute;
        this.link = link;
    }*/

    /*public Optional<Integer>fetchCaloriesPerMinute(){
        return Optional.ofNullable(caloriesPerMinute);
    }*/

    public Optional<String>Link(){
        return Optional.ofNullable(link);
    }

    @Override
    public void validate() {
        ValidatorUtility.validate(id, "id");
        ValidatorUtility.validate(name, "name");
        ValidatorUtility.validate(muscleGroup, "muscleGroup");
        ValidatorUtility.validate(equipment, "equipment");
        ValidatorUtility.validate(difficulty, "difficulty");
        ValidatorUtility.validateOptional(caloriesPerMinute, "caloriesPerMinute");
        ValidatorUtility.validate(link, "link");
    }
}

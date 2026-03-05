import Classes.Exercise;
import Classes.ExerciseRepository;
import Enums.Difficulty;
import Enums.Equipment;
import Enums.MuscleGroup;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExerciseRepository repository = new ExerciseRepository();
        List<Exercise> exercises = new ArrayList<>();

        Exercise ex1 = new Exercise(0, "SQUAT", "Name1", MuscleGroup.ARMS, Equipment.NONE, Difficulty.NONE, 100, "");
        Exercise ex2 = new Exercise(1, "PUSH_UP", "Name2", MuscleGroup.ARMS, Equipment.NONE, Difficulty.NONE, null, "");
        Exercise ex2Updated = new Exercise(1, "PUSH_UP", "Push Up Updated", MuscleGroup.CHEST, Equipment.NONE, Difficulty.NONE, 10, "");

        exercises.add(ex1);
        exercises.add(ex2);
        exercises.add(ex2Updated);

        exercises.stream().filter(exercise -> exercise.getName().equals("SQUAT")).anyMatch();

        repository.addExercise(ex1);
        repository.addExercise(ex2);
        System.out.println("After add: " + repository.findAll());

        repository.updateExercise(ex2Updated);
        System.out.println("After update: " + repository.findAll());

        repository.deleteExerciseById(0);
        System.out.println("After delete: " + repository.findAll());
    }
}

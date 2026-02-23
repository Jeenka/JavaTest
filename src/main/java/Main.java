import Classes.Exercise;
import Enums.Difficulty;
import Enums.Equipment;
import Enums.MuscleGroup;

public class Main {
    public static void main(String[] args) {
        Exercise ex1 = new Exercise(0, "Name1", MuscleGroup.ARMS, Equipment.NONE, Difficulty.NONE, 100, "");
        Exercise ex2 = new Exercise(1, "Name2", MuscleGroup.ARMS, Equipment.NONE, Difficulty.NONE, null, "");
        //Exercise ex3 = Exercise.getExercise(2, "Name3");

        System.out.println(ex1);
        System.out.println(ex2);
        //System.out.println(ex3);
    }
}

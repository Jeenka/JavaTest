package Classes;

import Interfaces.Repository;
import Interfaces.Searchable;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExerciseRepository implements Repository<Exercise>, Searchable<Exercise> {
    private final Map<Integer, Exercise> exercises = new HashMap<Integer, Exercise>();

    public void addExercise(@NonNull Exercise exercise) {
        exercise.validate();

        /*for (Exercise current : exercises) {
            if (current.getId().equals(exercise.getId())) {
                throw new IllegalArgumentException("Exercise with id " + exercise.getId() + " already exists");
            }
            if (current.getCode().equals(exercise.getCode())) {
                throw new IllegalArgumentException("Exercise with code " + exercise.getCode() + " already exists");
            }
        }*/
        exercises.put(exercise.getId(), exercise);
    }

    public boolean deleteExerciseById(int id) {
        /*for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).getId() == id) {
                exercises.remove(i);
                return true;
            }
        }*/
        return false;
    }

    public boolean updateExercise(@NonNull Exercise updatedExercise) {
        updatedExercise.validate();

        if (exercises.containsKey(updatedExercise.getId())) {
            if (exercises.get(updatedExercise.getId()).getCode().equals(updatedExercise.getCode())) {
                throw new IllegalArgumentException(
                        "Exercise with code " + updatedExercise.getCode() + " already exists");
            }
            exercises.put(updatedExercise.getId(), updatedExercise);
            return true;
        }
        return false;
    }

    @Override
    public void save(Exercise entity) {
        if (!exercises.containsKey(entity.getId())) {
            addExercise(entity);
        }
        else {
            updateExercise(entity);
        }
    }

    @Override
    public Exercise findById(Object id) {
        if (!(id instanceof Integer exerciseId)) {
            return null;
        }

        /*for (int i = 0; i < exercises.size(); i++) {
            Exercise current = exercises.get(i);
            if (current.getId().equals(exerciseId)) {
                return current;
            }
        }*/
        return null;
    }

    @Override
    public Map<Integer, Exercise> findAll() {
        return new Map<Integer, Exercise>(exercises);
    }

    @Override
    public List<Exercise> search(String query) { // заменить на rule, сделать класс rule, подобие exercises.stream().filter(exercise -> exercise.getName().equals("SQUAT")).anyMatch()
        List<Exercise> result = new ArrayList<>();
        if (query == null || query.isBlank()) {
            return result;
        }

        String normalizedQuery = query.toLowerCase();
        for (int i = 0; i < exercises.size(); i++) {
            Exercise current = exercises.get(i);
            String code = current.getCode() == null ? "" : current.getCode().toLowerCase();
            String name = current.getName() == null ? "" : current.getName().toLowerCase();
            if (code.contains(normalizedQuery) || name.contains(normalizedQuery)) {
                result.add(current);
            }
        }
        return result;
    }
}

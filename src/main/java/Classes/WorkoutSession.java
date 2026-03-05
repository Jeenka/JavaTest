package Classes;

import Interfaces.Identifiable;
import Interfaces.Validable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkoutSession implements Identifiable<Integer>, Validable {
    int id;
    Integer templateId;
    LocalDateTime dateTime;
    List<WorkoutItem> performedItems;
    int totalDurationMin;
    String notes;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void validate() {
        ValidatorUtility.validate(id, "id");
        ValidatorUtility.validateOptional(templateId, "templateId");
        if (dateTime == null) {
            throw new IllegalArgumentException("dateTime must not be null");
        }
        if (performedItems == null) {
            throw new IllegalArgumentException("performedItems must not be null");
        }
        ValidatorUtility.validate(totalDurationMin, "totalDurationMin");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutSession workoutSession)) return false;
        return id == workoutSession.id &&
                totalDurationMin == workoutSession.totalDurationMin &&
                Objects.equals(templateId, workoutSession.templateId) &&
                Objects.equals(dateTime, workoutSession.dateTime) &&
                Objects.equals(performedItems, workoutSession.performedItems) &&
                Objects.equals(notes, workoutSession.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, templateId, dateTime, performedItems, totalDurationMin, notes);
    }
}

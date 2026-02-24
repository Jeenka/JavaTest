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
}

package de.unistuttgart.iste.meitrex.scrumgame.util;

import de.unistuttgart.iste.meitrex.generated.dto.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Utility class for data fields of events.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class TemplateDataUtils {

    public static Optional<? extends DataField> findField(Event event, String key) {
        return event.getEventData().stream()
                .filter(field -> field.getKey().equals(key))
                .findFirst();
    }

    public static Optional<String> findStringField(Event event, String key) {
        return findField(event, key).map(DataField::getValue);
    }

    public static Optional<Integer> findIntField(Event event, String key) {
        try {
            return findField(event, key)
                    .map(DataField::getValue)
                    .map(Integer::parseInt);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static DataFieldInput intField(String key, int value) {
        return DataFieldInput.builder()
                .setType(AllowedDataType.INTEGER)
                .setKey(key)
                .setValue(String.valueOf(value))
                .build();
    }

    public static TemplateFieldInput stringField(String key, String value) {
        return TemplateFieldInput.builder()
                .setType(AllowedDataType.STRING)
                .setKey(key)
                .setValue(value)
                .build();
    }

}

package de.unistuttgart.iste.meitrex.scrumgame.external;

import com.fasterxml.jackson.databind.JsonNode;
import de.unistuttgart.iste.meitrex.generated.dto.CreateEventInput;

import java.util.*;

/**
 * Adapter for external systems to map their JSON payloads to DinoDev events.
 */
@FunctionalInterface
public interface ExternalSystemAdapter {

    /**
     * Maps JSON received from an external system to a list of CreateEventInput objects.
     *
     * @param jsonNode  payload of the external system web hook
     * @param headers   headers of the external system web hook
     * @param projectId The ID of the dinodev project, for which the events are created
     * @return the mapped list of CreateEventInput objects
     */
    List<CreateEventInput> mapToDinoDevEvents(JsonNode jsonNode, Map<String, String> headers, UUID projectId);
}

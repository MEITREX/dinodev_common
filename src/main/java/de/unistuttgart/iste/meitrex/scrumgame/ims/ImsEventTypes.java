package de.unistuttgart.iste.meitrex.scrumgame.ims;

import de.unistuttgart.iste.meitrex.generated.dto.*;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * Contains the event types that represent events in the IMS.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ImsEventTypes {

    private static final List<FieldSchemaDefinition> DEFAULT_ISSUE_DATA = List.of(
            DefaultFieldSchemaDefinition.builder()
                    .setName("issueKey")
                    .setType(AllowedDataType.STRING)
                    .setDescription("The key of the issue.")
                    .setRequired(true)
                    .build(),
            DefaultFieldSchemaDefinition.builder()
                    .setName("issueTitle")
                    .setType(AllowedDataType.STRING)
                    .setDescription("The title of the issue.")
                    .setRequired(true)
                    .build());

    @SafeVarargs
    private static <T> List<T> concat(List<T> list1, T... otherElements) {
        List<T> result = new ArrayList<>(list1);
        Collections.addAll(result, otherElements);
        return result;
    }

    /**
     * Event type for when an issue is assigned.
     */
    public static final EventType ASSIGNED_ISSUE = DefaultEventType.builder()
            .setIdentifier("ASSIGNED_ISSUE")
            .setDescription("An issue was assigned.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(
                            concat(
                                    DEFAULT_ISSUE_DATA,
                                    DefaultFieldSchemaDefinition.builder()
                                            .setName("assigneeId")
                                            .setType(AllowedDataType.STRING)
                                            .setDescription("The ID of the assignee.")
                                            .setRequired(true)
                                            .build()))
                    .build())
            .setMessageTemplate("assigned issue '${issueTitle}' to ${assigneeId}.")
            .build();

    /**
     * Event type for when an issue is unassigned.
     */
    public static final EventType UNASSIGNED_ISSUE = DefaultEventType.builder()
            .setIdentifier("UNASSIGNED_ISSUE")
            .setDescription("An issue was unassigned.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("removed the assignment from the issue '${issueTitle}'.")
            .build();

    /**
     * Event type for when a comment is added to an issue.
     */
    public static final EventType COMMENT_ON_ISSUE = DefaultEventType.builder()
            .setIdentifier("COMMENT_ON_ISSUE")
            .setDescription("A comment was added to an issue.")
            .setDefaultVisibility(EventVisibility.PRIVATE)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(
                            concat(
                                    DEFAULT_ISSUE_DATA,
                                    DefaultFieldSchemaDefinition.builder()
                                            .setName("comment")
                                            .setType(AllowedDataType.STRING)
                                            .setDescription("The comment.")
                                            .setRequired(true)
                                            .build()))
                    .build())
            .setMessageTemplate("commented on the issue '${issueTitle}': ${comment}")
            .build();

    /**
     * Event type for when an issue is started, i.e., moved
     * from the SPRINT_BACKLOG state to IN_PROGRESS.
     */
    public static final EventType START_PROGRESS = DefaultEventType.builder()
            .setIdentifier("START_PROGRESS")
            .setDescription("An issue was started.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("started working on the issue '${issueTitle}'.")
            .build();

    /**
     * Event type for when an issue is added to a sprint, i.e., moved from the
     * BACKLOG state to any other state other than DONE.
     */
    public static final EventType ADD_ISSUE_TO_SPRINT = DefaultEventType.builder()
            .setIdentifier("ADD_ISSUE_TO_SPRINT")
            .setDescription("An issue was added to a sprint.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("added the issue '${issueTitle}' to the sprint.")
            .build();

    /**
     * Event type for when an issue is removed from a sprint, i.e., moved
     * from any state other than DONE to the BACKLOG state.
     */
    public static final EventType REMOVE_ISSUE_FROM_SPRINT = DefaultEventType.builder()
            .setIdentifier("REMOVE_ISSUE_FROM_SPRINT")
            .setDescription("An issue was removed from a sprint.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("The issue '${issueKey}' was removed from the sprint '${sprintName}'.")
            .build();

    /**
     * Event type for when an issue is completed, i.e., moved to the DONE or DONE_SPRINT state.
     */
    public static final EventType ISSUE_COMPLETED = DefaultEventType.builder()
            .setIdentifier("ISSUE_COMPLETED")
            .setDescription("An issue was completed.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("completed the issue '${issueKey}'! Great job!")
            .build();

    /**
     * Event type for when an issue is reopened, i.e., moved from DONE or DONE_SPRINT
     * to another state.
     */
    public static final EventType ISSUE_REOPENED = DefaultEventType.builder()
            .setIdentifier("ISSUE_REOPENED")
            .setDescription("An issue was reopened.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("reopened the issue '${issueKey}'.")
            .build();

    /**
     * Event type for when an issue is created.
     */
    public static final EventType ISSUE_CREATED = DefaultEventType.builder()
            .setIdentifier("ISSUE_CREATED")
            .setDescription("An issue was created.")
            .setDefaultVisibility(EventVisibility.PUBLIC)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("created the issue '${issueKey}'.")
            .build();

    /**
     * Fallback event type for any updates on an issue that are not covered by the other event types.
     */
    public static final EventType ISSUE_UPDATED = DefaultEventType.builder()
            .setIdentifier("ISSUE_UPDATED")
            .setDescription("An issue was updated.")
            .setDefaultVisibility(EventVisibility.PRIVATE)
            .setEventSchema(DefaultSchemaDefinition.builder()
                    .setFields(DEFAULT_ISSUE_DATA)
                    .build())
            .setMessageTemplate("updated the issue '${issueKey}'.")
            .build();

    /**
     * Returns all event types defined in this class.
     *
     * @return The event types.
     */
    public static List<EventType> allEventTypes() {
        return List.of(
                ASSIGNED_ISSUE,
                UNASSIGNED_ISSUE,
                COMMENT_ON_ISSUE,
                START_PROGRESS,
                ADD_ISSUE_TO_SPRINT,
                REMOVE_ISSUE_FROM_SPRINT,
                ISSUE_COMPLETED,
                ISSUE_REOPENED,
                ISSUE_CREATED,
                ISSUE_UPDATED
        );
    }
}

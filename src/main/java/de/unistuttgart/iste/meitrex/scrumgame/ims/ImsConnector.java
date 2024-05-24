package de.unistuttgart.iste.meitrex.scrumgame.ims;

import de.unistuttgart.iste.meitrex.generated.dto.*;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.*;

/**
 * The ImsConnector interface provides a set of methods for interacting with issues in the issue management system (IMS).
 */
public interface ImsConnector {

    /**
     * Retrieves a list of issues for a given Scrum game project.
     *
     * @param scrumGameProjectId The UUID of the Scrum game project.
     * @return A list of Issue objects.
     */
    List<Issue> getIssues(UUID scrumGameProjectId);

    /**
     * Finds an issue by its ID.
     *
     * @param id The ID of the issue.
     * @return An Optional containing the Issue if found, or an empty Optional if not.
     */
    Optional<Issue> findIssue(String id);

    /**
     * Finds a list of issues by their IDs.
     *
     * @param ids The IDs of the issues.
     * @return A list of Issue objects with null entries for IDs that were not found.
     */
    List<Issue> findIssuesBatched(List<String> ids);

    /**
     * Retrieves a list of events that have occurred in the ims project for a specific issue.
     * Returns only events that have occurred since the given timestamp.
     * The events are CreateEventInputs, which are used to create events in the Scrum game.
     *
     * @param issueId The ID of the issue.
     * @param since   The timestamp to retrieve events since.
     * @return A list of create event inputs.
     */
    List<CreateEventInput> getEventsForIssue(String issueId, OffsetDateTime since);

    /**
     * Changes the title of an issue.
     *
     * @param issueId The ID of the issue.
     * @param title   The new title for the issue.
     * @return The updated Issue object.
     */
    Issue changeIssueTitle(String issueId, String title);

    /**
     * Changes the description of an issue.
     *
     * @param issueId     The ID of the issue.
     * @param description The new description for the issue.
     * @return The updated Issue object.
     */
    Issue changeIssueDescription(String issueId, String description);

    /**
     * Changes the state of an issue.
     *
     * @param issueId    The ID of the issue.
     * @param issueState The new state for the issue.
     * @return The updated Issue object.
     */
    Issue changeIssueState(String issueId, IssueState issueState);

    /**
     * Changes the priority of an issue.
     *
     * @param issueId  The ID of the issue.
     * @param priority The new priority for the issue.
     * @return The updated Issue object.
     */
    Issue changeIssuePriority(String issueId, IssuePriority priority);

    /**
     * Changes the type of an issue.
     *
     * @param issueId  The ID of the issue.
     * @param typeName The new type for the issue.
     * @return The updated Issue object.
     */
    Issue changeIssueType(String issueId, String typeName);

    /**
     * Changes the sprint of an issue.
     *
     * @param issueId      The ID of the issue.
     * @param sprintNumber The new sprint number for the issue.
     * @return The updated Issue object.
     */
    Issue changeSprintOfIssue(String issueId, Integer sprintNumber);

    /**
     * Changes the estimation of an issue.
     *
     * @param issueId    The ID of the issue.
     * @param estimation The new estimation for the issue.
     * @return The updated Issue object.
     */
    Issue changeEstimationOfIssue(String issueId, TShirtSizeEstimation estimation);

    /**
     * Assigns an issue to a user.
     *
     * @param issueId    The ID of the issue.
     * @param assigneeId The UUID of the user to assign the issue to.
     * @return The updated Issue object.
     */
    Issue assignIssue(String issueId, UUID assigneeId);

    /**
     * Adds a comment to an issue.
     *
     * @param issueId The ID of the issue.
     * @param comment The comment to add, possibly markdown-formatted.
     * @return The updated Issue object.
     */
    Issue addCommentToIssue(String issueId, String comment);

    /**
     * Creates a new issue in the issue tracking system.
     *
     * @param projectId        The UUID of the Scrum game project.
     * @param createIssueInput The data for the new issue.
     * @return The created Issue object.
     */
    Issue createIssue(UUID projectId, CreateIssueInput createIssueInput);
}
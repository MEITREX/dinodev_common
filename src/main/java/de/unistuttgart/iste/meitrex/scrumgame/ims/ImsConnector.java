package de.unistuttgart.iste.meitrex.scrumgame.ims;

import de.unistuttgart.iste.meitrex.generated.dto.*;

import java.util.*;

/**
 * The ImsConnector interface provides a set of methods for interacting with issues in the issue management system (IMS).
 * Each method requires an IssueMappingConfiguration object, which is used to map the issue data between the Scrum game and the IMS.
 * 
 * @param <C> The type of IssueMappingConfiguration used by the connector.
 */
public interface ImsConnector<C extends IssueMappingConfiguration> {

    /**
     * Retrieves a list of issues for a given Scrum game project.
     *
     * @param scrumGameProjectId   The UUID of the Scrum game project.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return A list of Issue objects.
     */
    List<Issue> getIssues(UUID scrumGameProjectId, C mappingConfiguration);

    /**
     * Finds an issue by its ID.
     *
     * @param id                   The ID of the issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return An Optional containing the Issue if found, or an empty Optional if not.
     */
    Optional<Issue> findIssue(String id, C mappingConfiguration);

    /**
     * Changes the title of an issue.
     *
     * @param issueId              The ID of the issue.
     * @param title                The new title for the issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The updated Issue object.
     */
    Issue changeIssueTitle(String issueId, String title, C mappingConfiguration);

    /**
     * Changes the description of an issue.
     *
     * @param issueId              The ID of the issue.
     * @param description          The new description for the issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The updated Issue object.
     */
    Issue changeIssueDescription(String issueId, String description, C mappingConfiguration);

    /**
     * Changes the state of an issue.
     *
     * @param issueId              The ID of the issue.
     * @param issueState           The new state for the issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The updated Issue object.
     */
    Issue changeIssueState(String issueId, IssueState issueState, C mappingConfiguration);

    /**
     * Changes the type of an issue.
     *
     * @param issueId              The ID of the issue.
     * @param typeName             The new type for the issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The updated Issue object.
     */
    Issue changeIssueType(String issueId, String typeName, C mappingConfiguration);

    /**
     * Changes the sprint of an issue.
     *
     * @param issueId              The ID of the issue.
     * @param sprintNumber         The new sprint number for the issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The updated Issue object.
     */
    Issue changeSprintOfIssue(String issueId, Integer sprintNumber, C mappingConfiguration);

    /**
     * Assigns an issue to a user.
     *
     * @param issueId              The ID of the issue.
     * @param assigneeId           The UUID of the user to assign the issue to.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The updated Issue object.
     */
    Issue assignIssue(String issueId, UUID assigneeId, C mappingConfiguration);

    /**
     * Creates a new issue in the issue tracking system.
     *
     * @param projectId            The UUID of the Scrum game project.
     * @param createIssueInput     The data for the new issue.
     * @param mappingConfiguration The configuration used for mapping issue data.
     * @return The created Issue object.
     */
    Issue createIssue(UUID projectId, CreateIssueInput createIssueInput, C mappingConfiguration);
}
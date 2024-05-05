package de.unistuttgart.iste.meitrex.scrumgame.ims;

import java.util.UUID;

/**
 * Configuration for mapping issues between the Scrum Game and the IMS.
 * Concrete connectors to IMS systems should provide a concrete implementation of this interface,
 * possibly with additional methods for configuration.
 */
public interface IssueMappingConfiguration {

    /**
     * Get the UUID of the Scrum Game project.
     *
     * @return The Scrum Game project ID.
     */
    UUID getScrumGameProjectId();

    /**
     * Get the ID of the project in the IMS.
     *
     * @return The IMS project ID.
     */
    String getImsProjectId();

    /**
     * Get the issue state converter for this configuration, used to convert issue states between the Scrum Game and the IMS.
     *
     * @return The issue state converter.
     */
    IssueStateConverter issueStateConverter();

    /**
     * Get the mapper to map user IDs between the Scrum Game and the IMS.
     *
     * @return The user ID mapping.
     */
    UserIdMapping userIdMapping();

    /**
     * Get the issue priority mapping for this configuration, used to map issue priorities between the Scrum Game and the IMS.
     *
     * @return The issue priority mapping.
     */
    IssuePriorityMapping issuePriorityMapping();

}

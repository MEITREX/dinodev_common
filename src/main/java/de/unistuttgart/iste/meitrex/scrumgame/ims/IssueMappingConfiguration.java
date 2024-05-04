package de.unistuttgart.iste.meitrex.scrumgame.ims;

import java.util.UUID;

public interface IssueMappingConfiguration {

    UUID getScrumGameProjectId();

    String getImsProjectId();

    IssueStateConverter issueStateConverter();

    UserIdMapping userIdMapping();

    String getSprintFieldName();

    String getEstimationTemplateFieldName();

}

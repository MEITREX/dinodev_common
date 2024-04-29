package de.unistuttgart.iste.meitrex.scrumgame.ims;

public interface IssueMappingConfiguration {

    IssueStateConverter issueStateConverter();

    UserIdMapping userIdMapping();

    String getSprintFieldName();

    String getEstimationTemplateFieldName();

}

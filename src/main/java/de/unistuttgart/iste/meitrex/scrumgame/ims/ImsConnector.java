package de.unistuttgart.iste.meitrex.scrumgame.ims;

import de.unistuttgart.iste.meitrex.scrumgame.ims.dto.Issue;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ImsConnector {

    List<Issue> getIssues(String imsProjectId, IssueMappingConfiguration mappingConfiguration);

    Optional<Issue> findIssue(String id, IssueMappingConfiguration mappingConfiguration);

    Map<String, Issue> getIssuesByState(IssueMappingConfiguration mappingConfiguration);

    Issue changeIssueTitle(String issueId, String title, IssueMappingConfiguration mappingConfiguration);

    Issue changeIssueDescription(String issueId, String description, IssueMappingConfiguration mappingConfiguration);

    Issue changeIssueState(String issueId, String stateName, IssueMappingConfiguration mappingConfiguration);

    Issue changeIssueType(String issueId, String typeName, IssueMappingConfiguration mappingConfiguration);

    Issue assignIssue(String issueId, UUID assigneeId, IssueMappingConfiguration mappingConfiguration);
}

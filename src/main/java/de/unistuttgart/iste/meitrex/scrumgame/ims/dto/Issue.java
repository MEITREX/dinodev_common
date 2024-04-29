package de.unistuttgart.iste.meitrex.scrumgame.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

    private String id;
    private String title;
    private String description;
    private IssueState state;
    private IssueType type;
    private Integer sprintNumber;
    private List<UUID> assigneeIds;
}

package de.unistuttgart.iste.meitrex.scrumgame.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueState {

    private String name;
    private IssueStateType type;
    private String imsStateId;
}

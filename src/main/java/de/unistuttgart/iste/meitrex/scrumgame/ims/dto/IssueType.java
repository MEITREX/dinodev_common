package de.unistuttgart.iste.meitrex.scrumgame.ims.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueType {

    private String name;
    private String description;
    private String iconPath;
}

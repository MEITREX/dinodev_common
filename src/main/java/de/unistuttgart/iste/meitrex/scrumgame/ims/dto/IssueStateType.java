package de.unistuttgart.iste.meitrex.scrumgame.ims.dto;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public enum IssueStateType {

    BACKLOG("BACKLOG"),
    SPRINT_BACKLOG("SPRINT_BACKLOG"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE_SPRINT("DONE_SPRINT"),
    DONE("DONE");

    private final String graphqlName;

}

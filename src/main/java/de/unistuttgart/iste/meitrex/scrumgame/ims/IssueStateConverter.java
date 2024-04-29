package de.unistuttgart.iste.meitrex.scrumgame.ims;

import de.unistuttgart.iste.meitrex.scrumgame.ims.dto.IssueState;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IssueStateConverter {

    private Map<String, IssueState> issueStateMap;

    public IssueStateConverter(List<IssueState> issueStates) {
        this.issueStateMap = issueStates.stream()
                .collect(Collectors.toMap(IssueState::getImsStateId, Function.identity()));
    }

    public IssueState getIssueState(String imsStateId) {
        return issueStateMap.get(imsStateId);
    }

}

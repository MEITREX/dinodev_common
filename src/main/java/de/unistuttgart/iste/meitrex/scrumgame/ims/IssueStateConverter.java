package de.unistuttgart.iste.meitrex.scrumgame.ims;

import de.unistuttgart.iste.meitrex.generated.dto.IssueState;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converts IMS issue states to IssueState objects.
 */
public class IssueStateConverter {

    private final Map<String, IssueState> issueStateMap;

    public IssueStateConverter(List<IssueState> issueStates) {
        this.issueStateMap = issueStates.stream()
                .collect(Collectors.toMap(IssueState::getImsStateId, Function.identity()));
    }

    public IssueState getIssueState(String imsStateId) {
        return issueStateMap.get(imsStateId);
    }

}

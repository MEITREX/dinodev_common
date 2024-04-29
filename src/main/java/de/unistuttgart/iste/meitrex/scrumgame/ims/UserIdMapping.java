package de.unistuttgart.iste.meitrex.scrumgame.ims;

import java.util.UUID;

public interface UserIdMapping {

    UUID imsToScrumgame(String imsUserId);

    String scrumGameToIms(UUID scrumgameUserId);

    static UserIdMapping identity() {
        return new UserIdMapping() {
            @Override
            public UUID imsToScrumgame(String imsUserId) {
                return UUID.fromString(imsUserId);
            }

            @Override
            public String scrumGameToIms(UUID scrumgameUserId) {
                return scrumgameUserId.toString();
            }
        };
    }

}

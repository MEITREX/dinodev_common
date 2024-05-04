package de.unistuttgart.iste.meitrex.scrumgame.ims;

import java.util.UUID;

/**
 * Maps user IDs between the Scrum Game and the IMS.
 */
public interface UserIdMapping {

    /**
     * Maps an IMS user ID to a Scrum Game user ID.
     *
     * @param imsUserId The IMS user ID.
     * @return The Scrum Game user ID.
     */
    UUID imsToScrumgame(String imsUserId);

    /**
     * Maps a Scrum Game user ID to an IMS user ID.
     *
     * @param scrumgameUserId The Scrum Game user ID.
     * @return The IMS user ID.
     */
    String scrumGameToIms(UUID scrumgameUserId);

    /**
     * Returns an identity mapping that maps the IMS user ID to the Scrum Game user ID and vice versa,
     * i.e., the IMS user ID is the same as the Scrum Game user ID.
     *
     * @return The identity mapping.
     */
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

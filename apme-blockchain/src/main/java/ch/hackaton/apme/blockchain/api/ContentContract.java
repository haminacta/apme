package ch.hackaton.apme.blockchain.api;

import java.util.List;

/**
 * The content-contract to handle contractual checks and other things
 *
 * @author apme
 */
public interface ContentContract {

    /**
     * Checks if the user with the given unique identifier is authorized to get a content with the unique identifier
     *
     * @param contentId
     *            the unique identifier of the desired content
     * @param userId
     *            the unique identifier of the asking user
     * @return true = he's authorized to get the content, false = he isn't to do that
     */
    boolean isUserAuthorizedToGetContent(String contentId, String userId);

    /**
     * Returns all content identifiers of the purchases of a user
     *
     * @param userId
     *            the unique identifier of the asking user
     * @return the unique content identifiers of his purchases
     */
    List<String> getPurchases(String userId);

    /**
     * Returns all buyers of a given content
     *
     * @param contentId
     *            the unique identifier of the content asking for
     * @return the unique identifiers of its buyers
     */
    List<String> getBuyers(String contentId);
}

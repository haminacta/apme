package ch.hackaton.apme.api;

import java.io.File;
import java.io.InputStream;

/**
 * The service to get or create content-files
 *
 * @author apme
 */
public interface ContentService {

    /**
     * Returns a content-file with the given unique identifier
     *
     * @param contentId
     *            the unique identifier of desired content-file
     * @return the desired content-file as an {@link InputStream}
     * @throws ContentResourceNotFoundException
     *             that's thrown if the content weren't found
     */
    InputStream get(String contentId) throws ContentResourceNotFoundException;

    /**
     * Creates a new content-file in the repository and returns its identifier
     *
     * @param content
     *            the {@link File} of the content-file, that should be created
     * @return the unique identifier of the created content-file
     * @throws ContentResourceCreateException
     *             that's thrown if the content couldn't created
     */
    String create(File content) throws ContentResourceCreateException;
}

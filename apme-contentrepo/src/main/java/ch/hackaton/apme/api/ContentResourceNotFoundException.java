package ch.hackaton.apme.api;

/**
 * The exception that is thrown if a content-file couldn't be found
 *
 * @author apme
 */
public class ContentResourceNotFoundException extends Exception {

    private static final long serialVersionUID = -1096384455048136608L;

    /**
     * Creates an instance of the {@link ContentResourceNotFoundException} containing the originally exception
     *
     * @param throwable
     *            the original thrown exception
     */
    public ContentResourceNotFoundException(final Throwable throwable) {

        super(throwable);
    }
}

package ch.hackaton.apme.api;

/**
 * The exception that is thrown if a content-file couldn't be created
 *
 * @author apme
 */
public class ContentResourceCreateException extends Exception {

    private static final long serialVersionUID = -1096384455048136608L;

    /**
     * Creates an instance of the {@link ContentResourceCreateException} containing the originally exception
     *
     * @param throwable
     *            the original thrown exception
     */
    public ContentResourceCreateException(final Throwable throwable) {

        super(throwable);
    }
}

package ch.hackaton.apme;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import ch.hackaton.apme.api.ContentResourceCreateException;
import ch.hackaton.apme.api.ContentResourceNotFoundException;
import ch.hackaton.apme.api.ContentService;
import io.ipfs.api.IPFS;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

/**
 * The service to get or create content-files in the InterPlanetary File System (IPFS)
 *
 * @author apme
 */
@Default
@ApplicationScoped
public class IPFSContentService implements ContentService {

    private IPFS ipfs;

    @PostConstruct
    public void initialize() {

        // TODO make that configurable
        this.ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
    }

    @Override
    public InputStream get(final String contentId) throws ContentResourceNotFoundException {

        try {

            return this.ipfs.catStream(Multihash.fromBase58(contentId));

        } catch (final IOException e) {
            throw new ContentResourceNotFoundException(e);
        }
    }

    @Override
    public String create(final File content) throws ContentResourceCreateException {

        try {

            return this.ipfs.add(new NamedStreamable.FileWrapper(content)).hash.toBase58();

        } catch (final IOException e) {
            throw new ContentResourceCreateException(e);
        }
    }

}

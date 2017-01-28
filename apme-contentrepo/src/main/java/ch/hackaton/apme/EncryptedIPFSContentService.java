package ch.hackaton.apme;

import java.io.File;
import java.io.InputStream;

import javax.inject.Inject;

import ch.hackaton.apme.api.ContentResourceCreateException;
import ch.hackaton.apme.api.ContentResourceNotFoundException;
import ch.hackaton.apme.api.ContentService;
import ch.hackaton.apme.api.EncryptedContentService;

/**
 * The service to get or create encrypted content-files in the InterPlanetary File System (IPFS)
 *
 * @author apme
 */
public class EncryptedIPFSContentService implements EncryptedContentService {

    @Inject
    private ContentService contentService; // use that to get a content-file and then decrypt & encrypt it

    @Override
    public InputStream get(final String contentId) throws ContentResourceNotFoundException {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String create(final File content, final String providerId) throws ContentResourceCreateException {

        // TODO Auto-generated method stub
        return null;
    }

}

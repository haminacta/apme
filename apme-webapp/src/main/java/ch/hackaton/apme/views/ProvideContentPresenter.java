package ch.hackaton.apme.views;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.vaadin.cdi.ViewScoped;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;

import ch.hackathon.apme.ContentInfo;
import ch.hackathon.apme.ContentInfoService;
import ch.hackaton.apme.DesignPresenter;
import ch.hackaton.apme.api.ContentResourceCreateException;
import ch.hackaton.apme.api.ContentService;

/**
 * @author apme
 *
 */
@Default
@ViewScoped
public class ProvideContentPresenter implements DesignPresenter<DefaultProvideContentDesign>, Receiver {

    private DefaultProvideContentDesign design;

    private File previewContent;
    private File content;

    @Inject
    private ContentService contentService;

    @Inject
    private ContentInfoService contentInfoService;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultProvideContentDesign();

        this.design.previewUpload.setReceiver(this);
        this.design.contentUpload.setReceiver(this);

        this.design.previewUpload.addSucceededListener(event -> {

            this.previewContent = new File(System.getProperty("java.io.tmpdir"), event.getFilename());
        });

        this.design.contentUpload.addSucceededListener(event -> {

            this.content = new File(System.getProperty("java.io.tmpdir"), event.getFilename());
        });

        this.design.commitButton.addClickListener(clickEvent -> {

            if (this.content != null && this.design.priceField.getValue() != null) {
                try {

                    String previewContentId = null;

                    if (this.previewContent != null) {
                        previewContentId = this.contentService.create(this.previewContent);
                    }

                    final String contentId = this.contentService.create(this.content);

                    final ContentInfo contentInfo = new ContentInfo();

                    contentInfo.setOwner("user1");
                    contentInfo.setDescription(this.content.getName());
                    contentInfo.setOwnerWallet("F6f160866b08AfaF25b9EDa0f4de1b596801Ed31");
                    contentInfo.setPublickey("F6f160866b08AfaF25b9EDa0f4de1b596801Ed31");
                    contentInfo.setTitle(this.content.getName());
                    contentInfo.setMultihash(contentId);
                    contentInfo.setDemoMultihash(previewContentId);
                    contentInfo.setPrice(Long.valueOf(this.design.priceField.getValue()));

                    this.contentInfoService.save(contentInfo);

                    Notification.show("Upload succeed");

                    this.content = null;
                    this.previewContent = null;
                    this.design.priceField.setValue(null);
                } catch (final ContentResourceCreateException e) {

                    // TODO Notify user that the upload didn't success
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public DefaultProvideContentDesign getDesign() {

        return this.design;
    }

    @Override
    public OutputStream receiveUpload(final String filename, final String mimeType) {

        FileOutputStream fos = null;
        try {
            final File file = new File(new File(System.getProperty("java.io.tmpdir")), filename);

            fos = new FileOutputStream(file); // NOSONAR
        } catch (final Exception e) {
            // TODO Notify user that the upload didn't success
            e.printStackTrace();
        }
        return fos;
    }
}

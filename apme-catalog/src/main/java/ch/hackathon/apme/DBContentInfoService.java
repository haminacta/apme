package ch.hackathon.apme;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author inacta AG
 *
 */
public class DBContentInfoService implements ContentInfoService {

    @Inject
    private ContentInfoDAO contentInfoDao;

    @Override
    public List<ContentInfo> list() {

        return this.contentInfoDao.list();
    }

    @Override
    public ContentInfo get(final Integer id) {

        return this.contentInfoDao.get(id);
    }

    @Override
    @Transactional
    public void save(final ContentInfo content) {

        this.contentInfoDao.save(content);

    }

}

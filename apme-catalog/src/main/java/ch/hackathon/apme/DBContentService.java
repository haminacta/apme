package ch.hackathon.apme;

import java.util.List;

import javax.inject.Inject;

/**
 * 
 * @author inacta AG
 *
 */
public class DBContentService implements ContentService {


	@Inject
	private ContentInfoDAO contentInfoDao;
	
	@Override
	public List<ContentInfo> list() {
		return contentInfoDao.list();
	}

	@Override
	public ContentInfo get(Integer id) {
		return contentInfoDao.get(id);
	}

	@Override
	public void save(ContentInfo content) {
		contentInfoDao.save(content);

	}

}

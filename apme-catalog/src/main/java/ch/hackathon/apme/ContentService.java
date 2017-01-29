package ch.hackathon.apme;

import java.util.List;

/**
 * 
 * @author apme
 *
 */
public interface ContentService {

	/**
	 * 
	 * @return
	 */
	List<ContentInfo> list();

	/**
	 * 
	 * @param id
	 * @return
	 */
	ContentInfo get(Integer id);

	/**
	 * 
	 * @param content
	 */
	void save(ContentInfo content);
}

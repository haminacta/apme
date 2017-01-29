package ch.hackathon.apme;

import java.util.Collections;
import java.util.List;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 
 * @author apme
 *
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContentInfoDAOImpl implements ContentInfoDAO {

	@PersistenceContext(unitName = "manager")
	private EntityManager entityManager;

	public List<ContentInfo> list() {

		final TypedQuery<ContentInfo> query = entityManager.createQuery("SELECT s FROM ContentInfo s",
				ContentInfo.class);
		try {
			return query.getResultList();
		} catch (final NoResultException ex) {
			ex.printStackTrace();
			return Collections.emptyList();
		}
	}

	public ContentInfo get(Integer id) {
		return entityManager.find(ContentInfo.class, id);
	}

	public void save(ContentInfo content) {
		entityManager.persist(content);
	}


}

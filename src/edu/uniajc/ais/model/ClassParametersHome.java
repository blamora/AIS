package edu.uniajc.ais.model;
// Generated Nov 7, 2017 7:42:30 PM by Hibernate Tools 5.2.6.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ClassParameters.
 * @see edu.uniajc.ais.model.ClassParameters
 * @author Hibernate Tools
 */
@Stateless
public class ClassParametersHome {

	private static final Log log = LogFactory.getLog(ClassParametersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ClassParameters transientInstance) {
		log.debug("persisting ClassParameters instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ClassParameters persistentInstance) {
		log.debug("removing ClassParameters instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ClassParameters merge(ClassParameters detachedInstance) {
		log.debug("merging ClassParameters instance");
		try {
			ClassParameters result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ClassParameters findById(int id) {
		log.debug("getting ClassParameters instance with id: " + id);
		try {
			ClassParameters instance = entityManager.find(ClassParameters.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

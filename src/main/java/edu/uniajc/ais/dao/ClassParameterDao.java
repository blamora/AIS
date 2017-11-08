package edu.uniajc.ais.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.uniajc.ais.dataaccess.api.HibernateDaoImpl;
import edu.uniajc.ais.model.ClassParameters;

@Repository("ClassParameterDao")
@Scope("singleton")
public class ClassParameterDao extends HibernateDaoImpl<ClassParameters, Integer> implements IClassParametersDao  {

	private static final Logger log = LoggerFactory.getLogger(ClassParameterDao.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IClassParametersDao getFromApplicationContext(ApplicationContext ctx) {
        return (IClassParametersDao) ctx.getBean("ClassParameterDao");
    }
	
	@Override
	public void saveClassParameters(ClassParameters entity) throws Exception {
		log.debug("saving ClassParameter instance");
		try {
			String query = "INSERT INTO public.class_parameters(description) VALUES(:description)";
			Query q = (Query) sessionFactory.getCurrentSession().createSQLQuery(query);
			q.setParameter("description", entity.getDescription());
			q.executeUpdate();
		} catch (Exception e) {
			log.error("save ClassParameter failed", e);
            throw e; 
		}
		
	}

}

package edu.uniajc.ais.dao;


import edu.uniajc.ais.dataaccess.api.Dao;
import edu.uniajc.ais.model.ClassParameters;

public interface IClassParametersDao extends Dao<ClassParameters, Integer> {

	public void saveClassParameters(ClassParameters entity) throws Exception;
}

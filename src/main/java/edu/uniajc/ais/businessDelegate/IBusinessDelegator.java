package edu.uniajc.ais.businessDelegate;

import java.util.List;

import edu.uniajc.ais.model.ClassParameters;

public interface IBusinessDelegator {

	public ClassParameters getClassById(Integer id) throws Exception;
	public List<ClassParameters> findAll() throws Exception;
	public void save(ClassParameters entity) throws Exception;
	public void update(ClassParameters entity) throws Exception;
	public void delete(ClassParameters entity) throws Exception;
}

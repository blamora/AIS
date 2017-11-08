package edu.uniajc.ais.businessDelegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uniajc.ais.logic.ClassParametersLogic;
import edu.uniajc.ais.model.ClassParameters;

@Component
@Scope("singleton")
public class BusinessDelegator implements IBusinessDelegator {

	@Autowired
	private ClassParametersLogic classParametersLogic;
	
	@Override
	public ClassParameters getClassById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassParameters> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ClassParameters entity) throws Exception {
		classParametersLogic.save(entity);
		
	}

	@Override
	public void update(ClassParameters entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClassParameters entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

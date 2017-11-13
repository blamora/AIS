package edu.uniajc.ais.logic;

import java.util.List;

import edu.uniajc.ais.dto.ClassParametersDTO;
import edu.uniajc.ais.model.ClassParameters;

public interface IClassParameterLogic {

	public ClassParameters getClassById(Integer id) throws Exception;
	public List<ClassParametersDTO> findAll() throws Exception;
	public void save(ClassParameters entity) throws Exception;
	public void update(ClassParameters entity) throws Exception;
	public void delete(ClassParameters entity) throws Exception;
}

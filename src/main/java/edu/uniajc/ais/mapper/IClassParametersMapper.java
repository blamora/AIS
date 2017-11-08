package edu.uniajc.ais.mapper;

import edu.uniajc.ais.dto.ClassParametersDTO;
import edu.uniajc.ais.model.ClassParameters;

public interface IClassParametersMapper {

	public ClassParametersDTO classParametersToClassParametersDTO(ClassParameters entity) throws Exception;
	public ClassParameters classParametersDTOToClassparameter(ClassParametersDTO entityDTO) throws Exception;
	
}

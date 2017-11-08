package edu.uniajc.ais.mapper;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.uniajc.ais.dto.ClassParametersDTO;
import edu.uniajc.ais.model.ClassParameters;

@Component
@Scope("singleton")
public class ClassParametersMapper implements IClassParametersMapper{

	@Transactional(readOnly = true)
	public ClassParametersDTO classParametersToClassParametersDTO(ClassParameters entity) throws Exception {
		try {
			
			ClassParametersDTO entityDTO = new ClassParametersDTO();
			
			entityDTO.setId(entity.getId());
			entityDTO.setDescription(entity.getDescription() != null
					? entity.getDescription() : null);
			
			return entityDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ClassParameters classParametersDTOToClassparameter(ClassParametersDTO entityDTO) throws Exception {
		try {
			
			ClassParameters entity = new ClassParameters();
			
			entity.setId(entityDTO.getId());
			entity.setDescription(entityDTO.getDescription() != null
					? entityDTO.getDescription() : null);
			
			return entity;
		} catch (Exception e) {
			throw e;
		}
	}

}

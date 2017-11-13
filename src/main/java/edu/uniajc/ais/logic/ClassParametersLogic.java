package edu.uniajc.ais.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.uniajc.ais.dao.IClassParametersDao;
import edu.uniajc.ais.dto.ClassParametersDTO;
import edu.uniajc.ais.exceptions.ZMessManager;
import edu.uniajc.ais.mapper.IClassParametersMapper;
import edu.uniajc.ais.model.ClassParameters;

@Service
@Scope("singleton")
public class ClassParametersLogic implements IClassParameterLogic {

	private static final Logger log = LoggerFactory.getLogger(ClassParametersLogic.class);

	@Autowired
	private IClassParametersMapper classParametersMapper;

	@Autowired
	private IClassParametersDao classParametersDao;

	@Autowired
	private Validator validator;

	public void validateClassParameters(ClassParameters entity) throws Exception {
		try {
			Set<ConstraintViolation<ClassParameters>> constraintViolations = validator.validate(entity);
			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<ClassParameters> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}

				throw new Exception(strMessage.toString());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ClassParameters getClassById(Integer id) throws Exception {
		log.debug("getting class Parameters instance");
		
		ClassParameters entity = null;
		try {
			entity = classParametersDao.findById(id);
		} catch (Exception e) {
			log.error("get class Parameters failed", e);
            throw new ZMessManager().new FindingException("ClassParameters");
		}
		return entity;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<ClassParametersDTO> findAll() throws Exception {
		try {
			List<ClassParameters> classParameters = classParametersDao.findAll();

			List<ClassParametersDTO> classParametersDTO = new ArrayList<ClassParametersDTO>();

			for (ClassParameters classParametersTmp : classParameters) {
				ClassParametersDTO classParametersDTO2 = classParametersMapper
						.classParametersToClassParametersDTO(classParametersTmp);
				classParametersDTO.add(classParametersDTO2);
			}
			return classParametersDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(ClassParameters entity) throws Exception {
		log.debug("saving ClassParameters instance");
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ClassParameters");
			}

			validateClassParameters(entity);
			classParametersDao.saveClassParameters(entity);

		} catch (Exception e) {
			log.error("save classParameters failed", e);
			throw e;
		}

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(ClassParameters entity) throws Exception {
		log.debug("updating Class Parameters instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Class Parameters");
			}

			validateClassParameters(entity);

			classParametersDao.saveOrUpdate(entity, true);

			log.debug("update Class Parameters successful");
		} catch (Exception e) {
			log.error("update Class Parameters failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(ClassParameters entity) throws Exception {
		log.debug("deleting ClassParameters instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("ClassParameters");
        }

        try {
            classParametersDao.delete(classParametersDao.merge(entity));

            log.debug("delete ClassParameters successful");
        } catch (Exception e) {
            log.error("delete ClassParameters failed", e);
            throw e;
        } finally {
        }

	}

}

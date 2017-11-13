package edu.uniajc.ais.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uniajc.ais.businessDelegate.IBusinessDelegator;
import edu.uniajc.ais.dto.ClassParametersDTO;
import edu.uniajc.ais.mapper.IClassParametersMapper;
import edu.uniajc.ais.model.ClassParameters;

@RestController
@RequestMapping("/classParameter")
public class ClassParameterController {

	private static final Logger log = LoggerFactory.getLogger(ClassParameterController.class);

	@Autowired
	private IBusinessDelegator businessDelegator;

	@Autowired
	private IClassParametersMapper classParametersMapper;

	@PostMapping(value = "/class")
	public void save(@RequestBody ClassParametersDTO entityDTO) throws Exception {

		try {
			ClassParameters entity = classParametersMapper.classParametersDTOToClassparameter(entityDTO);
			businessDelegator.save(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@GetMapping(value = "/class")
	public List<ClassParametersDTO> getDataAll() throws Exception {
		try {
			return businessDelegator.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@PutMapping(value = "/class")
	public void update(@RequestBody ClassParametersDTO entityDTO) throws Exception {
		try {
			ClassParameters entity = classParametersMapper.classParametersDTOToClassparameter(entityDTO);
			businessDelegator.update(entity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            throw e;
		}
	}
	
	@DeleteMapping(value = "/class/{id}")
    public void deleteParameters(@PathVariable("id")
    Integer id) throws Exception {
        try {
            ClassParameters entity = businessDelegator.getClassById(id);

            businessDelegator.delete(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}

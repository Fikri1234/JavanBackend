/**
 * 
 */
package com.pajak.project.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pajak.project.DTO.MUserDTO;
import com.pajak.project.DTO.PajakDTO;
import com.pajak.project.Entity.PajakEntity;
import com.pajak.project.Enum.RoleEnum;
import com.pajak.project.Service.PajakService;
import com.pajak.project.Util.CustomException;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Fikri
 *
 */

@Slf4j
@RestController
public class PajakController {
	private static final String LOG_FRMT = "data PajakEntity: {}";
	
	@Autowired
	private PajakService pajakService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> retrieveById(@PathVariable("id") Long id) throws CustomException {
		
		PajakDTO dto = new PajakDTO();
		Optional<PajakEntity> opt = pajakService.findById(id);
		
		if (opt.isPresent()) {
			dto = new PajakDTO(opt.get());
			log.info(LOG_FRMT, dto);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			log.error("id not found: ", id);
			throw new CustomException("Unable to find id " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> retrieveAllEnabled() {
		
		List<PajakDTO> dtos = new ArrayList<>();
		List<PajakEntity> entities = pajakService.findAll();
		
		if (!entities.isEmpty()) {
			dtos = entities.stream().map(PajakDTO::new).collect(Collectors.toList());
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/maker")
	public ResponseEntity<Object> retrieveAllMaker() {
		
		MUserDTO userDto = pajakService.getUser();
		if (RoleEnum.CHECKER.isEqual(userDto.getRole().getCode())) {
			List<PajakDTO> dtos = new ArrayList<>();
			List<PajakEntity> entities = pajakService.findByRole(RoleEnum.MAKER);
			
			if (!entities.isEmpty()) {
				dtos = entities.stream().map(PajakDTO::new).collect(Collectors.toList());
			}
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/checker")
	public ResponseEntity<Object> retrieveAllChecker() {
		
		MUserDTO userDto = pajakService.getUser();
		if (RoleEnum.APPROVER.isEqual(userDto.getRole().getCode())) {
			List<PajakDTO> dtos = new ArrayList<>();
			List<PajakEntity> entities = pajakService.findByRole(RoleEnum.CHECKER);
			
			if (!entities.isEmpty()) {
				dtos = entities.stream().map(PajakDTO::new).collect(Collectors.toList());
			}
			
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/maker")
    public ResponseEntity<Object> postMakerPajakEntity(@RequestBody PajakDTO dto) throws CustomException {
        log.info("REST API for insert postPajakEntity: {}", dto);
        MUserDTO userDto = pajakService.getUser();
		if (RoleEnum.MAKER.isEqual(userDto.getRole().getCode())) {
			try {
				PajakEntity entity = new PajakEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setCreatedBy(userDto.getEmail());
				entity.setCreatedDate(new Date());
				entity.setRole(userDto.getRole());
				pajakService.save(entity);

				BeanUtils.copyProperties(entity, dto);
				return new ResponseEntity<>(dto, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
    }
	
	@PostMapping("/checker")
    public ResponseEntity<Object> postCheckerPajakEntity(@RequestBody PajakDTO dto) throws CustomException {
        log.info("REST API for insert postPajakEntity: {}", dto);
        MUserDTO userDto = pajakService.getUser();
		if (RoleEnum.CHECKER.isEqual(userDto.getRole().getCode())) {
			try {
				PajakEntity entity = new PajakEntity();
				BeanUtils.copyProperties(dto, entity);

				entity.setCreatedBy(userDto.getEmail());
				entity.setCreatedDate(new Date());
				entity.setRole(userDto.getRole());
				pajakService.save(entity);

				BeanUtils.copyProperties(entity, dto);
				return new ResponseEntity<>(dto, HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
    }
	
	@PutMapping("/")
    public ResponseEntity<Object> putPajakEntity(@RequestBody PajakDTO dto) throws CustomException {
        log.info("REST API for update putPajakEntity");
        
        Optional<PajakEntity> opt = pajakService.findById(dto.getId());
        
        if (!opt.isPresent()) {
 			log.error("Unable to update. PajakEntity with id {} not found",dto.getId());
 			throw new CustomException("Unable to update. PajakEntity with id " +dto.getId()+ " not found", HttpStatus.NOT_FOUND);
 		}
        
        try {
        	PajakEntity entity = new PajakEntity();
 			BeanUtils.copyProperties(dto, entity);
 			
 			pajakService.update(opt.get());
 			
 			BeanUtils.copyProperties(opt.get(), dto);
 			return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
		}
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePajakEntityById(@PathVariable("id") Long id) throws CustomException {
        log.info("REST API for delete deletePajakEntityById by id : {}", id);
        
        Optional<PajakEntity> opt = pajakService.findById(id);
        
        if (!opt.isPresent()) {
 			log.error("Unable to delete.PajakEntity with id {} not found",id);
 			throw new CustomException("Unable to delete.PajakEntity with id " +id+ " not found", HttpStatus.NOT_FOUND);
 		}
 		
        try {
        	pajakService.deleteById(id);
        	return ResponseEntity.ok(null);
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/paging")
	public ResponseEntity<Object> retrieveAllPaging(Pageable pageable) {
		
		List<PajakDTO> dtos = new ArrayList<>();
		Page<PajakEntity> pages = pajakService.findAll(pageable);
		
		if (pages.hasContent()) {
			Page<PajakDTO> dtoPage = pages.map(new Function<PajakEntity, PajakDTO>() {
				
			    @Override
			    public PajakDTO apply(PajakEntity entity) {
			        return new PajakDTO(entity);
			    }
	        });
			
			return new ResponseEntity<>(dtoPage, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<Object> retrieveByEmail(@PathVariable("status") String status) throws CustomException {
		
		List<PajakDTO> dtos = new ArrayList<PajakDTO>();
		List<PajakEntity> entities = pajakService.findByStatus(status);
		
		if (!entities.isEmpty()) {
			dtos = entities.stream().map(PajakDTO::new).collect(Collectors.toList());
		}
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}

/**
 * 
 */
package com.user.project.Controller;

import java.util.ArrayList;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.project.DTO.MUserDTO;
import com.user.project.Entity.MUserEntity;
import com.user.project.Service.MUserService;
import com.user.project.Util.CustomException;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Fikri
 *
 */

@Slf4j
@RestController
public class MUserController {
	private static final String LOG_FRMT = "data MUserEntity: {}";
	
	@Autowired
	private MUserService mUserService;
	
	@Autowired
	private PasswordEncoder userPasswordEncoder;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> retrieveById(@PathVariable("id") Long id) throws CustomException {
		
		Optional<MUserEntity> opt = mUserService.findById(id);
		
		if (opt.isPresent()) {
			MUserDTO dto = new MUserDTO(opt.get());
			log.info(LOG_FRMT, dto);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			log.error("id not found: ", id);
			throw new CustomException("Unable to find id " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> retrieveAllEnabled() {
		
		List<MUserDTO> dtos = new ArrayList<>();
		List<MUserEntity> entities = mUserService.findAll();

		if (!entities.isEmpty()) {
			dtos = entities.stream().map(MUserDTO::new).collect(Collectors.toList());
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping("/")
    public ResponseEntity<Object> postMUserEntity(@RequestBody MUserDTO dto) throws CustomException {
        log.info("REST API for insert postMUserEntity: {}", dto);
        
        try {
			MUserEntity entity = new MUserEntity();

			entity.setEmail(dto.getEmail());
			entity.setRole(dto.getRole());
			entity.setPassword(userPasswordEncoder.encode(dto.getPassword()));

			mUserService.save(entity);

			BeanUtils.copyProperties(entity, dto);
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
		}
    }
	
	@PutMapping("/")
    public ResponseEntity<Object> putMUserEntity(@RequestBody MUserDTO dto) throws CustomException {
        log.info("REST API for update putMUserEntity");
        
        Optional<MUserEntity> opt = mUserService.findById(dto.getId());

		if (!opt.isPresent()) {
			log.error("Unable to update. MUserEntity with id {} not found", dto.getId());
			throw new CustomException("Unable to update. MUserEntity with id " + dto.getId() + " not found",
					HttpStatus.NOT_FOUND);
		}

		try {
			MUserEntity entity = new MUserEntity();
			BeanUtils.copyProperties(dto, entity);

			opt.get().setEmail(dto.getEmail());
			opt.get().setRole(dto.getRole());

			mUserService.update(opt.get());

			BeanUtils.copyProperties(opt.get(), dto);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), HttpStatus.CONFLICT);
		}
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMUserEntityById(@PathVariable("id") Long id) throws CustomException {
        log.info("REST API for delete deleteMUserEntityById by id : {}", id);
        
        Optional<MUserEntity> opt = mUserService.findById(id);

		if (!opt.isPresent()) {
			log.error("Unable to delete.MUserEntity with id {} not found", id);
			throw new CustomException("Unable to delete.MUserEntity with id " + id + " not found",
					HttpStatus.NOT_FOUND);
		}

		try {
			mUserService.deleteById(id);
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/paging")
	public ResponseEntity<Object> retrieveAllPaging(Pageable pageable) {

		List<MUserDTO> dtos = new ArrayList<>();
		Page<MUserEntity> pages = mUserService.findAll(pageable);

		if (pages.hasContent()) {
			Page<MUserDTO> dtoPage = pages.map(new Function<MUserEntity, MUserDTO>() {

				@Override
				public MUserDTO apply(MUserEntity entity) {
					return new MUserDTO(entity);
				}
			});

			return new ResponseEntity<>(dtoPage, HttpStatus.OK);
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Object> retrieveByEmail(@PathVariable("email") String email) throws CustomException {
		
		MUserDTO dto = new MUserDTO();
		Optional<MUserEntity> opt = mUserService.findByEmail(email);

		if (opt.isPresent()) {
			BeanUtils.copyProperties(opt.get(), dto);
			log.info(LOG_FRMT, dto);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			log.error("email not found: ", email);

			throw new CustomException("Unable to find email " + email, HttpStatus.NOT_FOUND);
		}
	}

}

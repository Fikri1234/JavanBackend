package com.user.project.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.user.project.Enum.RoleEnum;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author ATI-User
 * Jul 29, 2020
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="tbl_user")
public class MUserEntity implements Serializable {

	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "email", nullable = false)
	String email;
	
	@Column(name = "password", nullable = false)
	String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", columnDefinition = "enum('ADMIN','USER','MAKER','CHECKER','APPROVER')", nullable = false)
	RoleEnum role = RoleEnum.USER;
}

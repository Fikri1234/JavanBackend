package com.auth.project.Enum;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum RoleEnum {
	MAKER("MAKER"),
	CHECKER("CHECKER"),
	APPROVER("APPROVER"),
	USER("USER"),
	ADMIN("ADMIN");

    private String code;
    
    public boolean isEqual(String status) {
		return getCode().equalsIgnoreCase(status);
	}

    public static RoleEnum getByName(String name) {
        if (StringUtils.hasText(name)) {
        	for (RoleEnum value : RoleEnum.values()) {
                if (value.name().equalsIgnoreCase(name)) {
                    return value;
                }
            }
        }
        return null;
    }
}
package com.pajak.project.Enum;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum StatusEnum {
	PENDING("PENDING"),
	REJECTED("REJECTED"),
	APPROVED("APPROVED"),
	;

    private String code;
    
    public boolean isEqual(String status) {
		return getCode().equalsIgnoreCase(status);
	}

    public static StatusEnum getByName(String name) {
        if (StringUtils.hasText(name)) {
        	for (StatusEnum value : StatusEnum.values()) {
                if (value.name().equalsIgnoreCase(name)) {
                    return value;
                }
            }
        }
        return null;
    }
}
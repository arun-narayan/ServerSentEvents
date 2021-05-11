package com.sse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Type {

	ANNOUNCEMENT("announcement"),
	EVENT("event"),
	UNKNOWN("Unknown");
	
	private String displayName;
}

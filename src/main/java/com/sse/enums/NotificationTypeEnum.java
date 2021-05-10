package com.sse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum NotificationTypeEnum {

	ANNOUNCEMENT("announcement"),
	EVENT("event"),
	UNKNOWN("Unknown");
	
	private String displayName;
}

/**
 * Copyright 2017 (C) FixStream Networks, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.sse.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sse.entity.Notification;
import com.sse.enums.NotificationTypeEnum;
import com.sse.service.NotificationService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Scheduler {

	@Autowired
	NotificationService service;
	
	int events = 1;
	int announcements = 1;
	
	@Scheduled(fixedRate = 20000)
	public void periodicNotificationForEvents() {
		log.debug("Sending notification for {}", NotificationTypeEnum.EVENT.getDisplayName());
		Notification notification = new Notification(NotificationTypeEnum.EVENT.getDisplayName(), "Event " + events);
		service.sendNotification(notification);
		events++;
	}
	
	@Scheduled(fixedRate = 10000)
	public void periodicNotificationForAnnouncments() {
		log.debug("Sending notification for {}", NotificationTypeEnum.ANNOUNCEMENT.getDisplayName());
		Notification notification = new Notification(NotificationTypeEnum.ANNOUNCEMENT.getDisplayName(), "Announcement " + announcements);
		service.sendNotification(notification);
		announcements++;
	}

}

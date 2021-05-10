package com.sse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.sse.entity.Notification;
import com.sse.serializer.JsonSerializable;
import com.sse.service.EmitterService;
import com.sse.service.NotificationService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/notification/subscribe")
public class NotificationController {

	@Autowired
	EmitterService emitterService;

	@Autowired
	NotificationService notificationService;

	@GetMapping(path = "/{type}")
	public SseEmitter subscribeToEvents(@PathVariable("type") String type) {
		log.debug("Subscribing for {}", type);
		return emitterService.createEmitter(type);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void publishEvent(@RequestBody Notification notification) {
		log.debug("Publishing notification message {}", JsonSerializable.toJson(notification));
		notificationService.sendNotification(notification);
	}
}

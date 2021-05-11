package com.sse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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
}

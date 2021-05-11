package com.sse.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SseNotificationService implements NotificationService {

	@Autowired
	EmitterService emitterService;
	
	@Override
	public void sendNotification(String type, String message) {
        if (null == message) {
            log.debug("No message to send...");
            return;
        }
        doSendNotification(type, message);
    }

	private void doSendNotification(String type, String message) {

		SseEmitter emitter = emitterService.getEmitterMap().get(type);

		if (null != emitter) {

			try {

				log.debug("Sending notification for type {}", type);

				SseEmitter.SseEventBuilder event = SseEmitter.event().name(type).data(message).reconnectTime(5000);

				emitter.send(event);

			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}

		} else {
			log.warn("No emitters available for {}", type);
		}

	}
	
}

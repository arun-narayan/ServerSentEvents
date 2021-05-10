package com.sse.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.sse.entity.Notification;
import com.sse.serializer.JsonSerializable;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SseNotificationService implements NotificationService {

	@Autowired
	EmitterService emitterService;
	
	@Override
	public void sendNotification(Notification notification) {
        if (null == notification) {
            log.debug("No message to send...");
            return;
        }
        doSendNotification(notification);
    }

	private void doSendNotification(Notification notification) {

		SseEmitter emitter = emitterService.getEmitterMap().get(notification.getType());

		if (null != emitter) {

			try {
				
				log.debug("Sending notification for type {}", notification.getType());
				
				SseEmitter.SseEventBuilder event = SseEmitter.event()
						.data(JsonSerializable.toJson(notification), MediaType.APPLICATION_JSON).reconnectTime(5000);
				
				emitter.send(event);
				
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}

		} else {
			log.warn("No emitters available for {}", notification.getType());
		}

	}
	
}

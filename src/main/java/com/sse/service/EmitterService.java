package com.sse.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class EmitterService {

	private static Map<String, SseEmitter> currentEmitters = new ConcurrentHashMap<>();
	
	@Value("${connection.timeout}")
	private long connectionTimeout;
	
	public SseEmitter createEmitter(String type) {
		SseEmitter emitter = new SseEmitter(connectionTimeout);
		currentEmitters.put(type, emitter);
		return emitter;
	}

	public Map<String, SseEmitter> getEmitterMap() {
		return currentEmitters;
	}
}

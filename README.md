# Server Sent Events
### (A Spring Boot Application)

## Intro
A very basic service for sending real time events to the client making use of Server Side Events framework.

### Highlights
- The service uses Server Sent Event (SSE) for one-way communication with client. 
- The service runs multiple schedulers for 2 different notification types: 
  - Announcement
  - Event
  
- Client listens to the service by subscribing to one or more notification type(s) as defined in `NotificationTypeEnum`
- The service responds with notifications as text/event-stream containing:
  - data: JSON String
  
- `SSE.html` subscribes to announcement and event notifications  
  
  
## 3rd Party Jars

- jackson - v2.12.3
- slf4j - v1.7.30
- logback - v1.2.3
- apache commons-collections4 - v4.4
- apache commons-lang3 - v3.12.0
- junit - v4.12  
  
  
## Reference Links
https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events

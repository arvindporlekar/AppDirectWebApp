package com.appdirect.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.spring.model.NotificationStatus;
import com.appdirect.spring.service.NotificationService;

@RestController
@RequestMapping(value="/subscription")
public class AppDirectNotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@RequestMapping(value = "/create/notification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationStatus> createNotification(@RequestParam("eventUrl") String eventUrl) {
		System.out.println("Fetching notification url with id " + eventUrl);
		NotificationStatus notificationStatus = notificationService.createNotificationforEventUrl(eventUrl);
		if (notificationStatus == null) {
			System.out.println("notificationStatus is null");
			return new ResponseEntity<NotificationStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<NotificationStatus>(notificationStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/change/notification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationStatus> changeNotification(@RequestParam("eventUrl") String eventUrl) {
		System.out.println("Fetching notification url with id " + eventUrl);
		NotificationStatus notificationStatus = notificationService.changeNotificationEventDetails(eventUrl);
		if (notificationStatus == null) {
			System.out.println("notificationStatus is null");
			return new ResponseEntity<NotificationStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<NotificationStatus>(notificationStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancel/notification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationStatus> cancelNotification(@RequestParam("eventUrl") String eventUrl) {
		System.out.println("Fetching notification url with id " + eventUrl);
		NotificationStatus notificationStatus = notificationService.cancelNotificationEventDetails(eventUrl);
		if (notificationStatus == null) {
			System.out.println("notificationStatus is null");
			return new ResponseEntity<NotificationStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<NotificationStatus>(notificationStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/status/notification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationStatus> statusEventlNotification(@RequestParam("eventUrl") String eventUrl) {
		System.out.println("Fetching notification url with id " + eventUrl);
		NotificationStatus notificationStatus = notificationService.getEventNotificationStatusDetails(eventUrl);
		if (notificationStatus == null) {
			System.out.println("notificationStatus is null");
			return new ResponseEntity<NotificationStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<NotificationStatus>(notificationStatus, HttpStatus.OK);
	}
	
}

package com.appdirect.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appdirect.spring.model.NotificationStatus;

@Service("notificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService{

	public NotificationStatus createNotificationforEventUrl(String eventUrl) {
		// TODO Auto-generated method stub
		System.out.println("## calling notification service");
		NotificationStatus notificationStatus = null;
		notificationStatus = populateCreateNotificationStatus(eventUrl);
		System.out.println("## End notification service with param :: " + notificationStatus.toString());
		return notificationStatus;
	}

	private NotificationStatus populateCreateNotificationStatus(String eventUrl) {
		NotificationStatus notificationStatus = new NotificationStatus();
		return notificationStatus;
	}

	@Override
	public NotificationStatus changeNotificationEventDetails(String eventUrl) {
		NotificationStatus notificationStatus = new NotificationStatus();
		return notificationStatus;
	}

	@Override
	public NotificationStatus cancelNotificationEventDetails(String eventUrl) {
		NotificationStatus notificationStatus = new NotificationStatus();
		return notificationStatus;
	}

	@Override
	public NotificationStatus getEventNotificationStatusDetails(String eventUrl) {
		NotificationStatus notificationStatus = new NotificationStatus();
		return notificationStatus;
	}

}

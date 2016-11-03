package com.appdirect.spring.service;

import com.appdirect.spring.model.NotificationStatus;

public interface NotificationService {

	NotificationStatus createNotificationforEventUrl(String eventUrl);

	NotificationStatus changeNotificationEventDetails(String eventUrl);

	NotificationStatus cancelNotificationEventDetails(String eventUrl);

	NotificationStatus getEventNotificationStatusDetails(String eventUrl);

}

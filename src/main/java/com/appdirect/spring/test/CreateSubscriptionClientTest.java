package com.appdirect.spring.test;

import java.util.Arrays;
import java.util.LinkedHashMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.appdirect.spring.model.AuthTokenInfo;
import com.appdirect.spring.model.NotificationStatus;

public class CreateSubscriptionClientTest {
	public static final String REST_SERVICE_URI = "http://localhost:8080/AppDirectWebApp";
	public static final String AUTH_SERVER_URI = "http://localhost:8080/AppDirectWebApp/oauth/token";
	public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=bill&password=abc123";
	public static final String QPM_ACCESS_TOKEN = "?access_token=";


	/*
	 * Prepare HTTP Headers.
	 */
	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * client-credentials.
	 */
	private static HttpHeaders getHeadersWithClientCredentials() {
		String plainClientCredentials = "my-trusted-client:secret";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}

	/*
	 * Send a POST request [on /oauth/token] to get an access-token, which will
	 * then be send with each request.
	 */
	@SuppressWarnings({ "unchecked" })
	private static AuthTokenInfo sendTokenRequest() {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeadersWithClientCredentials());
		System.out.println("AUTH URL :: " + AUTH_SERVER_URI + QPM_PASSWORD_GRANT);
		ResponseEntity<Object> response = restTemplate.exchange(AUTH_SERVER_URI + QPM_PASSWORD_GRANT, HttpMethod.POST,
				request, Object.class);
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();
		AuthTokenInfo tokenInfo = null;

		if (map != null) {
			tokenInfo = new AuthTokenInfo();
			tokenInfo.setAccess_token((String) map.get("access_token"));
			tokenInfo.setToken_type((String) map.get("token_type"));
			tokenInfo.setRefresh_token((String) map.get("refresh_token"));
			tokenInfo.setExpires_in((int) map.get("expires_in"));
			tokenInfo.setScope((String) map.get("scope"));
			System.out.println(tokenInfo);
			// System.out.println("access_token ="+map.get("access_token")+",
			// token_type="+map.get("token_type")+",
			// refresh_token="+map.get("refresh_token")
			// +", expires_in="+map.get("expires_in")+",
			// scope="+map.get("scope"));;
		} else {
			System.out.println("No subscription event exist----------");

		}
		return tokenInfo;
	}
	
	
	/* GET */
	private static void createSubscription(AuthTokenInfo tokenInfo) {
		System.out.println("Testing createSubscription API----------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("URL :: " + REST_SERVICE_URI + "/subscription/create/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<NotificationStatus> response = restTemplate.exchange(
				REST_SERVICE_URI + "/subscription/create/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request,
				NotificationStatus.class);
		NotificationStatus notificationStatus = response.getBody();
		System.out.println("create subscription success with status : " + notificationStatus);
		
	}

	public static void main(String args[]) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		createSubscription(tokenInfo);
		changeSubscription(tokenInfo);
		cancelSubscription(tokenInfo);
		getStautsSubscription(tokenInfo);
		
	}

	private static void getStautsSubscription(AuthTokenInfo tokenInfo) {
		System.out.println("Testing get subscription status API----------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("URL :: " + REST_SERVICE_URI + "/subscription/status/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<NotificationStatus> response = restTemplate.exchange(
				REST_SERVICE_URI + "/subscription/status/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request,
				NotificationStatus.class);
		NotificationStatus notificationStatus = response.getBody();
		System.out.println("get status subscription success with status : " + notificationStatus);
	}

	private static void cancelSubscription(AuthTokenInfo tokenInfo) {
		System.out.println("Testing cancel subscription API----------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("URL :: " + REST_SERVICE_URI + "/subscription/cancel/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<NotificationStatus> response = restTemplate.exchange(
				REST_SERVICE_URI + "/subscription/cancel/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request,
				NotificationStatus.class);
		NotificationStatus notificationStatus = response.getBody();
		System.out.println("cancel subscription success with status : " + notificationStatus);
	}

	private static void changeSubscription(AuthTokenInfo tokenInfo) {
		System.out.println("Testing change API----------");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("URL :: " + REST_SERVICE_URI + "/subscription/change/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<NotificationStatus> response = restTemplate.exchange(
				REST_SERVICE_URI + "/subscription/change/notification?eventUrl=https://www.acme-marketplace.com/api/integration/v1/events/d15bb36e-5fb5-11e0-8c3c-00262d2cda03" + QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request,
				NotificationStatus.class);
		NotificationStatus notificationStatus = response.getBody();
		System.out.println("change subscription success with status : " + notificationStatus);
	}
}

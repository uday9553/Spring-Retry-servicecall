package com.uday.springretry.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.uday.springretry.exception.RemoteServiceNotAvailableException;
import com.uday.springretry.service.BackendService;

@Service
public class BackendServiceImpl implements BackendService {

	@Override
	public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) {

		if (simulateretry) {
			System.out.println("Simulateretry is true, so try to simulate exception scenerio.");

			if (simulateretryfallback) {
				throw new RemoteServiceNotAvailableException(
						"Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
			}
			int random = new Random().nextInt(4);

			System.out.println("Random Number : " + random);
			if (random % 2 == 0) {
				throw new RemoteServiceNotAvailableException("Just Simulated for Spring-retry..");
			}
		}

		return "Hello from Remote Backend!!!";
	}

//	@Override
//	public String getBackendResponseFallback(RuntimeException e) {
//		System.out.println("All retries completed, so Fallback method called!!!");
//		return "All retries completed, so Fallback method called!!!";
//	}

	@Override
	public String getBackendResponseFallback1(RuntimeException e) {
		System.out.println("All retries completed111, so Fallback method called!!!");
		return "All retries completed1111, so Fallback method called!!!";
	}
}

package com.uday.springretry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.uday.springretry.exception.RemoteServiceNotAvailableException;

public interface BackendService {

	@Retryable(value = { RemoteServiceNotAvailableException.class }, maxAttempts = 3, backoff = @Backoff(delay = 3000))
	public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback);

//	@Recover
//	public String getBackendResponseFallback(RuntimeException e);
	
	@Recover
	public String getBackendResponseFallback1(RuntimeException e);

}

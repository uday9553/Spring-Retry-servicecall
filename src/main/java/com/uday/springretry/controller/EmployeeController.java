package com.uday.springretry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springretry.service.BackendService;

@RestController
public class EmployeeController {

	@Autowired
	BackendService backendAdapter;

	@GetMapping("/retry")
	@ExceptionHandler({ Exception.class })
	public String validateSPringRetryCapability(@RequestParam(required = false) boolean simulateretry,
			@RequestParam(required = false) boolean simulateretryfallback) {
		System.out.println("===============================");
		System.out.println("Inside RestController method..");
		return backendAdapter.getBackendResponse(simulateretry, simulateretryfallback);
	}
}

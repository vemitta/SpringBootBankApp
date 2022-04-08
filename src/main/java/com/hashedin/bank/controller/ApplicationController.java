package com.hashedin.bank.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/home")
	public String home() {
		return "Welcome to Hashedin Bank!";
	}
}

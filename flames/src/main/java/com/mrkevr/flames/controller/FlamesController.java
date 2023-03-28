package com.mrkevr.flames.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrkevr.flames.api.Flames;
import com.mrkevr.flames.service.FlamesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/flames/api")
@AllArgsConstructor
public class FlamesController {

	private final FlamesService flamesService;

	@GetMapping
	public ResponseEntity<Flames> getFlames(
			@RequestParam(value = "firstPerson", required = true) String firstPerson,
			@RequestParam(value = "secondPerson", required = true) String secondPerson) {

		Flames flames = flamesService.flames(firstPerson, secondPerson);

		return ResponseEntity.status(HttpStatus.OK).body(flames);
	}
}

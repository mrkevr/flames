package com.mrkevr.flames.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrkevr.flames.api.Flames;
import com.mrkevr.flames.service.FlamesService;

@RestController
@RequestMapping("/flames")
public class FlamesController {

	@Autowired
	FlamesService flamesService;

	@GetMapping("/{names}")
	public ResponseEntity<Flames> getFlames(@PathVariable("names") String names) {

		String[] person = names.split("&");
		String tag = flamesService.flames(person[0], person[1]);
		String result = "The relationship between " + person[0] + " and " + person[1] + " will end in " + tag;

		Flames flames = new Flames();
		flames.setFlames(result);
		flames.setTime(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.OK).body(flames);
	}
}

package com.mrkevr.flames.api;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flames {

	private String firstPerson;
	
	private String secondPerson;
	
	private String message;
	
	private LocalDateTime time;
}

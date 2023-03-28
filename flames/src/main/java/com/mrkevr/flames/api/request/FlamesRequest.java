package com.mrkevr.flames.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlamesRequest {
	
	private String firstPerson;
	private String secondPerson;
}

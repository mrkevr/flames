package com.mrkevr.flames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrkevr.flames.api.request.OriginalStringRequest;
import com.mrkevr.flames.security.util.EncodeDecodeUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/flames/util")
@AllArgsConstructor
public class EncodeDecodeController {

	private final EncodeDecodeUtil encodeUtil;

	@GetMapping(value = "/encode/base64")
	public String encodeBase64(@RequestBody(required = true) OriginalStringRequest requestStr) {
		return encodeUtil.encodeBase64(requestStr.getText());
	}

	@GetMapping(value = "/decode/base64")
	public String decodeBase64(@RequestParam(required = true) String encodedStr) {
		return encodeUtil.decondeBase64(encodedStr);
	}

	@GetMapping(value = "/encode/url")
	public String encodeUrl(@RequestBody(required = true) OriginalStringRequest requestStr) {
		return encodeUtil.encodeUrl(requestStr.getText());
	}

	@GetMapping(value = "/decode/url")
	public String decodeUrl(@RequestParam(required = true) String encodedStr) {
		return encodeUtil.decodeUrl(encodedStr);
	}
}

package com.mrkevr.flames.security.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.util.UriUtils;

@Component
public class EncodeDecodeUtil {

	private final Charset CHAR_SET = StandardCharsets.UTF_8;

	public String encodeBase64(String originalStr) {
		byte[] bytes = originalStr.getBytes(CHAR_SET);
		String encodedStr = Base64Utils.encodeToString(bytes);
		return encodedStr;
	}

	public String decondeBase64(String encodedStr) {
		byte[] decodedStr = Base64Utils.decodeFromString(encodedStr);
		return new String(decodedStr, CHAR_SET);
	}

	public String encodeUrl(String originalStr) {
		return UriUtils.encode(originalStr, CHAR_SET);
	}

	public String decodeUrl(String encodedStr) {
		return UriUtils.decode(encodedStr, CHAR_SET);
	}
}

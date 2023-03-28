package com.mrkevr.flames.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mrkevr.flames.api.Flames;

@Service
public class FlamesService {

	public Flames flames(String firstPerson, String secondPerson) {

		StringBuffer s1 = new StringBuffer(firstPerson);
		StringBuffer s2 = new StringBuffer(secondPerson);

		char c, d, e = '\0';
		for (int i = 0; i < s1.length(); i++) {
			c = s1.charAt(i);
			for (int j = 0; j < s2.length(); j++) {
				d = s2.charAt(j);
				if (c == d) {
					s1.deleteCharAt(i);
					s2.deleteCharAt(j);
					i--;
					j--;
					break;
				}
			}
		}
		s1 = s1.append(s2);
		int k = 6, l = 0;
		String s3 = "FLAMES";
		while (k > 1) {
			for (int m = 1; m < s1.length(); m++) {
				if (s3.charAt(l) != 'X') {
					l++;
					if (l == 6)
						l = 0;
				} else {
					l++;
					if (l == 6)
						l = 0;
					m--;
				}
			}
			while (s3.charAt(l) == 'X') {
				l++;
				if (l == 6)
					l = 0;
			}
			s3 = s3.substring(0, l) + "X" + s3.substring(l + 1);
			k--;
		}

		for (int i = 0; i < s3.length(); i++) {
			if (s3.charAt(i) != 'X')
				e = s3.charAt(i);
		}

		String result = "";

		switch (e) {

		case 'F':
			result = "FRIENDS";
			break;
		case 'L':
			result = "LOVE";
			break;
		case 'A':
			result = "AFFECTION";
			break;
		case 'M':
			result = "MARRIAGE";
			break;
		case 'E':
			result = "ENEMIES";
			break;
		case 'S':
			result = "SUN AND MOON";
			break;
		default:
			break;
		}
		
		String message = "The relationship between " + firstPerson + " and " + secondPerson + " will end in " + result;
		
		Flames flames = new Flames();
		flames.setFirstPerson(firstPerson);
		flames.setSecondPerson(secondPerson);
		flames.setMessage(message);
		flames.setTime(LocalDateTime.now());
		
		return flames;
	}
}

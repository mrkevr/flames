package com.mrkevr.flames.service;

import org.springframework.stereotype.Service;

@Service
public class FlamesService {

	public String flames(String name1, String name2) {

		StringBuffer s1 = new StringBuffer(name1);
		StringBuffer s2 = new StringBuffer(name2);

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

		switch (e) {

		case 'F':
			return "FRIENDS";

		case 'L':
			return "LOVE";

		case 'A':
			return "AFFECTION";

		case 'M':
			return "MARRIAGE";

		case 'E':
			return "ENEMIES";

		case 'S':
			return "SUN AND MOON";

		default:
			break;
		}
		return null;
	}
}

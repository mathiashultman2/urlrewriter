package biz.mathias;

import java.util.Base64;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class HashUtil {
	public String getShortUrl(String realUrl) {
		byte[] digest = getSha256Digest(realUrl);
		String urlPathLong = getBase64UrlEncoded(digest);
		String urlPath = urlPathLong.substring(0, 5);
		return "http://localhost:8080/" + urlPath;
	}

	public byte[] getSha256Digest(String text) {
		return DigestUtils.digest(DigestUtils.getSha256Digest(), text.getBytes());
	}

	public String getBase64UrlEncoded(byte[] bytes) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}
}

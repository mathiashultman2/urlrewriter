package biz.mathias.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import biz.mathias.HashUtil;
import biz.mathias.domain.Url;
import biz.mathias.service.UrlService;

@Controller
public class HomeController {
	@Autowired
	private UrlService urlService;
	@Autowired
	private HashUtil hashUtil;

	@GetMapping("/")
	@ResponseBody
	public String home(@RequestParam("url") String realUrlShort) {
		String shortUrl = hashUtil.getShortUrl(realUrlShort);

		Url url = new Url();
		url.setRealUrl("http://" + realUrlShort);
		url.setShortUrl(shortUrl);
		urlService.save(url);
		return shortUrl;
	}

	@GetMapping("/{shortUrl}")
	public String getRealUrlByShortUrl(@PathVariable("shortUrl") String shortUrl) {
		Optional<Url> url = urlService.findByShortUrl("http://localhost:8080/" + shortUrl);
		if (url.isPresent())
			return "redirect:" + url.get().getRealUrl();
		return "";
	}

	@GetMapping("/all")
	@ResponseBody
	public Iterable<Url> getAllUrls() {
		return urlService.findAll();
	}
}

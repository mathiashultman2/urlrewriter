package biz.mathias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.mathias.domain.Url;
import biz.mathias.repository.UrlRepository;

@Service
public class UrlService {
	@Autowired
	private UrlRepository urlRepository;
	
	public Optional<Url> findByShortUrl(String shortUrl){
		return urlRepository.findByShortUrl(shortUrl);
	}
	
	public Url save(Url url) {
		return urlRepository.save(url);
	}
	
	public Iterable<Url> findAll() {
		return urlRepository.findAll();
	}
}

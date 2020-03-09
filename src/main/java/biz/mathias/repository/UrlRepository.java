package biz.mathias.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import biz.mathias.domain.Url;

@Repository
public interface UrlRepository extends CrudRepository<Url, Integer>{
	Optional<Url> findByShortUrl(String shortUrl);
}

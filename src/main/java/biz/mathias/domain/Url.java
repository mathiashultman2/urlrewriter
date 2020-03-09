package biz.mathias.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {
	@Id
	@GeneratedValue
	private int id;
	private String realUrl;
	private String shortUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealUrl() {
		return realUrl;
	}
	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", realUrl=" + realUrl + ", shortUrl=" + shortUrl + "]";
	}
}

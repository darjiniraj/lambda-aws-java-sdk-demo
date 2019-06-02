package in.niraj.urlshortnerdemo.dao;

public interface UrlDAO {
	String generateShortCode();
	
	void storeUrl(String shortCode, String URL);

	String getUrl(String shortCode);
}

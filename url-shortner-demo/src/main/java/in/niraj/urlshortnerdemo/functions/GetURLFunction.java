package in.niraj.urlshortnerdemo.functions;

import in.niraj.urlshortnerdemo.dao.UrlDAO;
import in.niraj.urlshortnerdemo.exception.RedirectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("getURL")
public class GetURLFunction implements Function<String, String> {

	@Autowired
	private UrlDAO urlDAO;

	@Override
	public String apply(String shortCode) {
		String url = urlDAO.getUrl(shortCode);
		throw new RedirectException(url);
	}

}

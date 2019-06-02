package in.niraj.urlshortnerdemo.functions;

import in.niraj.urlshortnerdemo.dao.UrlDAO;
import in.niraj.urlshortnerdemo.exception.InvalidURLFormatException;
import in.niraj.urlshortnerdemo.functiontypes.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

@Component("generateShortcode")
public class GenerateShortcodeFunction implements Function<String, String> {

	@Autowired
	private UrlDAO urlDAO;

	@Autowired
	private LambdaFunctions lambdaFunctions;

	@Override
	public String apply(String url) {
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			throw new InvalidURLFormatException();
		}

		String shortCode = urlDAO.generateShortCode();
		urlDAO.storeUrl(shortCode, url);
		// enter your verified emails
		EmailDetails emailDetails = new EmailDetails("test@test.com",
				"test@test.com", "Congratulations, you have created a shortCode for: " + url,
				url, shortCode);
		lambdaFunctions.sendShortcodeGeneratedEmail(emailDetails);

		return shortCode;
	}
}

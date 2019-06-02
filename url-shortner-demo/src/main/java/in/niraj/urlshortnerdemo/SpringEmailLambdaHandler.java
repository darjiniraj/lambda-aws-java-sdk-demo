package in.niraj.urlshortnerdemo;

import in.niraj.urlshortnerdemo.functiontypes.EmailDetails;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class SpringEmailLambdaHandler extends SpringBootRequestHandler<EmailDetails, Boolean> {
}

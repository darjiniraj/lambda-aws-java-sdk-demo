package in.niraj.urlshortnerdemo.functions;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import in.niraj.urlshortnerdemo.functiontypes.EmailDetails;

public interface LambdaFunctions {
	@LambdaFunction(functionName="sendEmail")
    Boolean sendShortcodeGeneratedEmail(EmailDetails emailDetails);
}

package in.niraj.urlshortnerdemo.config;

import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import in.niraj.urlshortnerdemo.functions.LambdaFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSLambdaFunctionAutoConfig {
    @Bean
    public LambdaFunctions lambdaFunctions() {
        return LambdaInvokerFactory.builder()
				 .lambdaClient(AWSLambdaClientBuilder.defaultClient())
				 .build(LambdaFunctions.class);
    }
}

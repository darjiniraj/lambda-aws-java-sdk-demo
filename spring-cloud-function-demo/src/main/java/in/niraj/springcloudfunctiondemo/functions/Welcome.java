package in.niraj.springcloudfunctiondemo.functions;

import java.util.function.Function;

public class Welcome implements Function<String, String> {

    @Override
    public String apply(String s) {
        return "Hello " + s + ", Greetings from Niraj !!!";
    }
}
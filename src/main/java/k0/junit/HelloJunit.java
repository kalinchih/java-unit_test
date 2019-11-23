package k0.junit;

import org.apache.commons.lang3.StringUtils;

public class HelloJunit {
    public String greeting(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Argument name cannot not be null or empty/blank.");
        } else {
            return String.format("Hello %s", name);
        }
    }
}

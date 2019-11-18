package kalinchih.unit_test.junit_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloJunit5Test {
    private HelloJunit5 helloJunit5 = null;

    @BeforeEach
    void setUp() {
        this.helloJunit5 = new HelloJunit5();
    }

    @AfterEach
    void tearDown() {
        this.helloJunit5 = null;
    }

    @Test
    void greeting() {
        // happy
        Assertions.assertEquals("Hello Junit5", helloJunit5.greeting("Junit5"));

        // exceptions
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    helloJunit5.greeting(null);
                });

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    helloJunit5.greeting("");
                });

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    helloJunit5.greeting(" ");
                });

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    helloJunit5.greeting("\t");
                });
    }
}

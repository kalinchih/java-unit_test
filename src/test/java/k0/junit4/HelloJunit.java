package k0.junit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloJunit {

    private k0.junit.HelloJunit helloJunit = null;

    @Before
    public void before() {
        this.helloJunit = new k0.junit.HelloJunit();
    }

    @After
    public void after() {
        this.helloJunit = null;
    }

    @Test
    public void greeting_return_greeting_with_name() {
        String name = "Junit4";
        Assert.assertEquals(String.format("Hello %s", name), helloJunit.greeting(name));
    }

    @Test(expected = IllegalArgumentException.class)
    public void greeting_throws_exception_for_null_name() {
        helloJunit.greeting(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void greeting_throws_exception_for_empty_name() {
        helloJunit.greeting("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greeting_throws_exception_for_space_name() {
        helloJunit.greeting(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greeting_throws_exception_for_tab_name() {
        helloJunit.greeting("\t");
    }
}

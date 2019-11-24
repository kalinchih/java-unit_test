# java-unit_test-junit4


## JUnit: test, assert 
Demo: [HelloJunit_Test](/src/test/java/k0/junit4/HelloJunit_Test.java)
- Preparation:
    - @Before
    - @After
- Test:
    - @Test
- Assertion:
    - Assert
    - @Test(expected=Exception.class)


## Run Unit Test in Maven
```mvn clean test```

## Code Coverage
[JaCoCo](https://www.eclemma.org/jacoco/) - by EClEmma 

```mvn verify```

##  Mockito: mock, stub, dummy, verify, spy 
Demo: [HelloJunit_Test](/src/test/java/k0/junit4/mockito/OrderBizHelper_PostgreSQLUtil_Test.java)
- Mock:
    - @Mock
    - MockitoAnnotations.initMocks(this);
- Stub return method:
    - Mockito.when()
    - Mockito.thenReturn()
    - Mockito.thenThrow()
- Stub void method:    
    - Mockito.doNothing()
    - Mockito.throw()
- Dummy:
    - Mockito.any()
- Verify mock invocation:
    - Mockito.verify()
    - Mockito.times()
- Spying real object:
    - @Spy
    - Mockito.doReturn()
    - [When to use Mock or Spy?](https://javapointers.com/tutorial/difference-between-spy-and-mock-in-mockito/)
        - If you want to be safe and avoid calling external services and just want to test the logic inside of the unit, then use mock. 
        - If you want to call external service and perform calling of real dependency, or simply say, you want to run the program as it is and just stub specific methods, then use spy.
         

## Unit Test Principles (F.I.R.S.T)
- First
- Independent
- Repeatable
- Self-validation
- Timely
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

## Unit Test Principles (F.I.R.S.T)
- First
- Independent
- Repeatable
- Self-validation
- Timely
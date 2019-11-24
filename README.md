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

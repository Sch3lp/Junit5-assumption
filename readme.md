Assertions :
* group assertions (check always the whole group) : interesting
* timeout assertions : maybe
* dependent assertions : seems nothing new

Assumptions :
* early termination of test based on a conditional
* integrates with intellij as if test is ignored (when assumption fails)

Tags : add annotation : test plan based on those

Assertions
https://howtodoinjava.com/junit-5/junit-5-assertions-examples/

```
@Test
void testCase() {
 
    boolean trueBool = true;
    boolean falseBool = false;
 
    Assertions.assertTrue(trueBool);
    Assertions.assertTrue(falseBool, "test execution message");
    Assertions.assertTrue(falseBool, AppTest::message);
    Assertions.assertTrue(AppTest::getResult, AppTest::message);
     
    Assertions.assertFalse(falseBool);
    Assertions.assertFalse(trueBool, "test execution message");
    Assertions.assertFalse(trueBool, AppTest::message);
    Assertions.assertFalse(AppTest::getResult, AppTest::message);
}

@Test
void allAssertions() {

assertAll("cart",

    ()-assertEquals("Shirt",cart.getItemName()),
    ()-assertEquals("White",cart.getItemColor())

);
}
 

 Assumptions
 https://howtodoinjava.com/junit-5/junit-5-assumptions-examples/
 
     @Test
     void testOnDev()
     {
         System.setProperty("ENV", "DEV");
         Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
         //remainder of test will proceed
     }
     
     Maatwerk testen
 

 Tags
 https://howtodoinjava.com/junit-5/junit-5-tag-annotation-example/
 
 @Tag("development")
 public class ClassATest
 {
     @Test
     @Tag("userManagement")
     void testCaseA(TestInfo testInfo) {
     }
 }
 
 //@IncludeTags example
 
@RunWith(JUnitPlatform.class)
@SelectPackages("com.howtodoinjava.junit5.examples")
@IncludeTags("production")
public class JUnit5Example
{
}
```
Geen project voor Selenium / niet snel test hebben

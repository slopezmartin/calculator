import calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Created by silen on 05/04/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    private Calculator calculator;



    @Before
    public void init(){
        calculator = new Calculator(-100,100);
    }


    @Test
    public void add(){
        int result = calculator.add(2,2);
        Assert.assertTrue(result == 4);
    }

    @Test
    public void addWithDifferentArguments(){
        int result = calculator.add(5,2);
        Assert.assertTrue(result==7);
    }

    @Test
    public void substract(){
        int result = calculator.substract(5,3);
        Assert.assertTrue(result == 2);
    }

    @Test
    public void substractsReturningNegative(){
        int result = calculator.substract(3,5);
        Assert.assertTrue(result == -2
        );
    }

    @Test
    public void substractSettingLimitValues(){
        int result = calculator.substract(5,10);
        Assert.assertTrue(result == -5);
    }


    @Test
    public void substractExcedingLowerLimit(){
       try {
           Calculator calculator = new Calculator(-100, 100);
           int result = calculator.substract(5, 150);
           Assert.fail("Something wrong, not failed when exceeded");
       }catch(StackOverflowError overflowError){
           // Works as expected
       }
    }

    @Test
    public void addExcedingUpperLimit(){
        try {
            Calculator calculator = new Calculator(-100, 100);
            int result = calculator.add(10, 150);
            Assert.fail("Something wrong, failed when exceeded");
        }catch(StackOverflowError overflowError){
            // Works as expected
        }
    }

    @Test
    public void setAndGetLimits(){
       Calculator calculator = new Calculator(-100,100);
       Assert.assertTrue(100 == calculator.getUpperLimit());
        Assert.assertTrue(-100 == calculator.getLowerLimit());
    }


    @Test
    public void argumentsExceedLimits(){
        Calculator calculator = new Calculator(-100 ,100 );

        try{
            calculator.validateArgs(calculator.getLowerLimit() -1,calculator.getUpperLimit()+1);
            Assert.fail("This should fail, arguments exceed limits");
        }catch (StackOverflowError overflowError){
            //Ok! Works
        }
    }

    @Test
    public void argumentsExceedLimitsInverse(){
        Calculator calculator = new Calculator(-100 ,100 );

        try{
            calculator.validateArgs(calculator.getUpperLimit()+1,calculator.getLowerLimit() -1);
            Assert.fail("This should fail, arguments exceed limits");
        }catch (StackOverflowError overflowError){
            //Ok! Works
        }
    }

   /* @Test
    public void substractIsUsingValidator(){

        int arg1 = 10;
        int arg2 = -20;

        int upperLimit = 100;
        int lowerLimit = -100;

        LimitsValidator validatorMock = Mockito.mock(LimitsValidator.class);
        Mockito.doNothing().when(validatorMock).setLimits(isAs(Integer.class),isAs(Integer.class));
        validatorMock.setLimits(lowerLimit,upperLimit);
        Mockito.verify(validatorMock).setLimits(lowerLimit,upperLimit);

        Mockito.doNothing().when(validatorMock).validateArgs
                (isAs(Integer.class),isAs(Integer.class));

        Calculator calculator = new Calculator(validatorMock);
        calculator.substract(arg1,arg2);
        Mockito.validateMockitoUsage();


    }*/
}

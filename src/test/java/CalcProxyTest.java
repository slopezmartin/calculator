import calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by silen on 26/04/2019.
 */
public class CalcProxyTest {


    private Calculator calculator;
    private CalcProxy calcProxy;

    @Test
    public void add(){
        calculator = new Calculator();
        calcProxy = new CalcProxy(calculator);

        int result = calcProxy.binaryOperation(calculator.add,2,2);
        Assert.assertTrue(result == 4);
    }

}

package calculator;

/**
 * Created by silen on 05/04/2019.
 */
public class Calculator {

    private int upperLimit;
    private int lowerLimit;

    public Calculator(int arg1, int arg2) {
        this.upperLimit = arg2;
        this.lowerLimit = arg1;

    }

    public int add(int arg1, int arg2){

        validateArgs(arg1,arg2);

        int result = arg1 + arg2;

        if(result > this.getUpperLimit()){
            throw new StackOverflowError(" Result exceeded upper Limit");
        }
        return result;
    }


    public int substract(int arg1, int arg2) {
        validateArgs(arg1,arg2);
        int result = arg1 - arg2;

        if(result < this.lowerLimit){
            throw new StackOverflowError(" Result is lower than LowerLimit");
        }
        return result;
    }

    public boolean validateArgs(int arg1, int arg2){
        if(arg2 > getUpperLimit()){
            throw new StackOverflowError(" arg2 exceeded upper Limit");
        }

        if(arg2 < getLowerLimit()){
            throw new StackOverflowError(" arg2 exceeded lower Limit");
        }

        if(arg1 < getLowerLimit()){
            throw new StackOverflowError(" arg1 exceeded lower Limit");
        }

        if(arg1 > getUpperLimit()){
            throw new StackOverflowError(" arg1 exceeded upper Limit");
        }
        return true;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
}

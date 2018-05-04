package com.company;

public class ConditionValue {

    private boolean fulfilled;
    private int numShared;

    public ConditionValue(boolean fulfilled, int numShared) {
        if (numShared < 0) numShared = 0;
        this.fulfilled = fulfilled;
        this.numShared = numShared;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public int getNumShared() {
        return numShared;
    }

    public void increaseShared(){
        numShared ++;
    }

    public void decreaseShared(){
        if (numShared>0) numShared --;
    }
}

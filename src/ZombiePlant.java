public class ZombiePlant {
    private int maxpotency;
    private int initialtreatments;

    public ZombiePlant(int maxpotency, int initialtreatments){
        this.maxpotency = maxpotency;
        this.initialtreatments = initialtreatments;
    }
    public int getPotency (){
        return maxpotency;
    }
    public int treatmentsNeeded(){
        return initialtreatments;
    }
    public boolean isDangerous(){
        return(initialtreatments>0);
    }
    public void treat (int treatmentpotency){
        if(treatmentpotency<=0){

        }
        else if(treatmentpotency<=maxpotency&& initialtreatments>0){
            initialtreatments--;
        }
        else{
            initialtreatments++;
        }
    }

}

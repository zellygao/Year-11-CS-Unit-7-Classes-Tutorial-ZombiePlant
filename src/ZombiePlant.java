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
        if(initialtreatments<0){
            return initialtreatments=0;
        }
        return initialtreatments;
    }
    public boolean isDangerous() {
        if(initialtreatments>0){
            return true;
        }
        return false;
    }

    public void treat (int treatmentpotency){
        //if(treatmentpotency<0){

        //}
         if(treatmentpotency <= maxpotency && treatmentpotency>0){
            initialtreatments--;
        }
        else if (treatmentpotency>maxpotency && treatmentpotency>0){
            initialtreatments++;
        }
        else if (treatmentpotency==0){
            return;
        }
    }

}

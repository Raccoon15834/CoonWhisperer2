package das.anusha.coonwhisperer;

public class Message {
    private String mDisplay, mReplaceable, myTxt;
    String[] strArr;
    int counter = -1;
    public Message(String[] arr){
        strArr = arr;
    }
    public void nextMessage(){
        if (counter==strArr.length-1) counter=0;
        else counter++;
        mDisplay = strArr[counter];
        mReplaceable = strArr[counter].replace("__", "%1$s");
    }
    public String getDisp(){
        return mDisplay;
    }
    public String fillBlanks(String txt){
        myTxt = String.format(mReplaceable, txt);
        return myTxt;
    }
    public String oneUp(){
        return myTxt.toUpperCase();
    }
    public String cattify(){
        String newText = "";
        String meow = "meow";
        int counter = 0;
        for (int j=0; j<myTxt.length(); j++){
            if (myTxt.charAt(j)==' ') newText += " ";
            else {
                newText += meow.charAt(counter);
                if (counter == 3) counter = 0;
                else counter++;
            }
        }
        return newText;
    }
}

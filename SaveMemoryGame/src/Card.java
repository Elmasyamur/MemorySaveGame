import java.io.Serializable;

public class Card implements Serializable {
    private char value;
    private boolean prediction;
    public Card(char value2){
        value= value2;
    }

    public char getValue() {
        return value;
    }

    public void setPrediction(boolean prediction) {
        this.prediction = prediction;
    }

    public void setValue(char value) {
        this.value = value;
    }
    public boolean getPrediction(){
        return prediction;
    }
}

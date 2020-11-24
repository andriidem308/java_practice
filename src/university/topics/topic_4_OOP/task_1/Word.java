package topic_4_OOP.task_1;

public class Word {
    String word;

    Word() { word = ""; }
    Word(String word){ this.word = word; }

    int getLength(){ return word.length(); }

    @Override
    public String toString() {
        return word;
    }
}

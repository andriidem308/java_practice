package topic_4_OOP.task_1;


public class Sentence {
    Word[] sentence;

    Sentence(){ sentence = new Word[Main.maxWordsAmount]; }
    Sentence(Word[] words){ sentence = words.clone(); }

    void capitalizeFirst(){
        if (sentence[0] == null) return;
        sentence[0].word = sentence[0].word.substring(0, 1).toUpperCase() + sentence[0].word.substring(1);
    }

    @Override
    public String toString() {
        if (sentence[0] == null) return "<empty>";
        capitalizeFirst();

        String s = sentence[0].toString();
        for (int i = 1; i < sentence.length; i++){
            s += " " + sentence[i];
        }

        return s;
    }
}

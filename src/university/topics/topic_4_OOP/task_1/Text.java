package topic_4_OOP.task_1;


public class Text {
    Sentence[] text;
    String header;

    Text(){
        text = new Sentence[Main.maxLinesAmount];
    };

    Text(Sentence[] sentences){
        text = sentences.clone();
    };

    Text(String header, Sentence[] sentences){
        this.header = header;
        this.text = sentences.clone();
    };

    Sentence[] getSentencesArray(){
        return text;
    }

    void setHeader(String h){
        header = h;
    }

    @Override
    public String toString(){
        String txt = "";

        if (header != null)
            System.out.println("\t\t\t\t*** " + header + " ***");
        for (Sentence sentence: text){
            txt += sentence + ".\n";
        }

        return txt;
    }
}

package Polymorphism.Word;

import java.util.ArrayDeque;

public class TextTransform implements ICommand {

    private StringBuilder text;
    private ArrayDeque<String> cuts;

    public TextTransform(String text) {

        this.text = new StringBuilder();
        this.text.append(text);
        cuts = new ArrayDeque<>();
    }

    @Override
    public void uppercase(int start, int end) {

        StringBuilder result = new StringBuilder();

        for (int i = start; i < end; i++) {

            result.append(text.charAt(i));
        }

        this.text.replace(start, end, result.toString().toUpperCase());
    }

    @Override
    public void cut(int start, int end) {

        String a = text.substring(start, end);
        this.text.replace(start, end, "");
        this.cuts.push(a);
    }

    @Override
    public void paste(int start, int end) {

        if (this.cuts.isEmpty()) {

            return;
        }

        this.text.replace(start, end, this.cuts.peek());
    }

    public StringBuilder getText() {
        return text;
    }


}

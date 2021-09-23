package Polymorphism.Word;

public interface ICommand {

    void uppercase(int start, int end);

    void cut(int start, int end);

    void paste(int start, int end);
}

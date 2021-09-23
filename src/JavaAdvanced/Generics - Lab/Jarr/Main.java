package Generics.Jarr;

public class Main {

    public static void main(String[] args) {


       Jar<Integer> jar = new Jar<>();
       Jar<String> jarTwo = new Jar<>();

       jar.add(10);
       jarTwo.add("Pesho");

       jar.remove();
       jarTwo.remove();


    }
}

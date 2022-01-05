package application;

public class Main {
    public static void main(String[] args) throws ParsingException {
        System.out.println("Hello Parser");
        Parser parser1 = new Parser();
        parser1.parseFile("sample1.txt");

    }
}

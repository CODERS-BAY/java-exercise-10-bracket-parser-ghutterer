package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Parser {

    private final Deque<Character> elementStack;

    public Parser() {
        elementStack = new ArrayDeque<>();
    }

    public void parseFile(final String filename) throws ParsingException {

        File file = new File(getClass().getClassLoader().getResource(filename).getFile());
        try(Scanner input = new Scanner(file)){
            while(input.hasNextLine()){
                String str = input.nextLine();
                System.out.println(str);
                for (int i =0; i<str.length(); i++){
                    elementStack.add(str.charAt(i));
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found lol");
        }

        int openp = (int)elementStack.stream().filter(x->x.equals('{')).count();
        int closep = (int)elementStack.stream().filter(x->x.equals('}')).count();
        if(openp>closep)throw new ParsingException("Error parsing the file. } expected");
        if(openp<closep)throw new ParsingException("Error parsing the file. { expected");
        System.out.println(openp);
        System.out.println(closep);

    }

    public Deque<Character> getElementStack() {
        return elementStack;
    }
}



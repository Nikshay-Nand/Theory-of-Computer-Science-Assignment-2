import java.util.*;

public class Lexer {
    public List<Token> lexer(String input) throws ExpressionException, NumberException {
        List<Token> tokens = new ArrayList<>();
        String buffer = "";
        int state = 0;
        char[] symbol = {'+', '-', '×', '=', '?', 'λ', '≜', '(', ')'};

        // Method for Lexer
        for (int i = 0; i < input.length(); i++) {

            switch(state) {
                case 0:
                if (Character.isDigit(input.charAt(i))) {
                    buffer = buffer + input.charAt(i);
                    state = 1;
                    break;
                }
                else if (Character.isLetter(input.charAt(i))) {
                    buffer = buffer + input.charAt(i);
                    state = 2;
                    break;
                }
                else if (new String(symbol).indexOf(input.charAt(i)) >= 0) {
                    tokens.add(new Token(Token.typeOf(input.charAt(i))));
                    break;
                }    
                else if (input.charAt(i) == ' ') {
                    break;
                }
                else {
                    throw new ExpressionException();
                }

                case 1:
                if (Character.isDigit(input.charAt(i))) {
                    buffer = buffer + input.charAt(i);
                    break;
                }
                else if (Character.isLetter(input.charAt(i))) {
                    throw new NumberException();
                }
                else if (new String(symbol).indexOf(input.charAt(i)) >= 0) {
                    tokens.add(new Token(Integer.parseInt(buffer.toString())));
                    tokens.add(new Token(Token.typeOf(input.charAt(i))));
                    state = 0;
                    buffer = "";
                    break;
                }
                else if (input.charAt(i) == ' ') {
                    tokens.add(new Token(Integer.parseInt(buffer.toString())));
                    buffer = "";
                    state = 0;
                    break;
                }
                else {
                    throw new ExpressionException();
                }
                
                case 2:
                if (Character.isDigit(input.charAt(i))) {
                    buffer = buffer + input.charAt(i);
                    break;
                }
                else if (Character.isLetter(input.charAt(i))) {
                    buffer = buffer + input.charAt(i);
                    break;
                }
                else if (new String(symbol).indexOf(input.charAt(i)) >= 0) {
                    tokens.add(new Token(buffer.toString()));
                    tokens.add(new Token(Token.typeOf(input.charAt(i))));
                    state = 0;
                    buffer = "";
                    break;
                }
                else if (input.charAt(i) == ' ') {
                    tokens.add(new Token(buffer.toString()));
                    buffer = "";
                    state = 0;
                    break;
                }
                else {
                    throw new ExpressionException();
                }
            } 
        }

        if (state == 1) { tokens.add(new Token(Integer.parseInt(buffer.toString()))); }
        if (state == 2) { tokens.add(new Token(buffer.toString())); }

        return tokens;
    }
}

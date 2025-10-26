import java.util.ArrayList;
import java.util.List;

// Run lexer first, then parser (they need to be separate functions)

public class LexerParserAnalyser {
    public static List<Token> analyse(String input) throws NumberException, IdentifierException, ExpressionException {
        List<Token> tokens = new ArrayList<>();
        String buffer = "";
        int state = 0;
        char[] symbol = {'+', '-', '*', '=', '?', 'λ', '≜', '(', ')'};

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

                // if the character is equals to any symbol '+', '-', '*', '=', '?', 'λ', '≜', '(', ')'
                // add the type of the symbol to the token list.
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
                    //cause a number can't be followed by an expression or any character.
                }
                else if (new String(symbol).indexOf(input.charAt(i)) >= 0) {
                    //if there's no whitespace between number and the expresison then add the
                    //expression to the list and then change the state to 0 and empty the buffer.
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

        // Method for Parser
        try {
            new LLParserAlgo((ArrayList<Token>) tokens);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return tokens;
    }

    //using LL(1)parsing deriving the string again using all the grammar formula to check if rules were
    //and if it follows then what grammar rules were being followed.

}

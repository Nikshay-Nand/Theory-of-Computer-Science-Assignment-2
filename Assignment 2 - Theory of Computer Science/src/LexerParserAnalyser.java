import java.util.List;

// Run lexer first, then parser (they need to be separate functions)

public class LexerParserAnalyser {
    public static List<Token> analyse(String input) throws NumberException, IdentifierException, ExpressionException, ParseException {
        // Lexer
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.lexer(input);

        // Parser
        Parser parser = new Parser();
        parser.parse(tokens);
       
        return tokens;
    }
}

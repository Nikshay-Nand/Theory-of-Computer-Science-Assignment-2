public class Runner {
    public static void main(String[] args) {
        try {
            // Testing:

            // NUMBER:
            // System.out.println(LexerParserAnalyser.analyse("42"));

            // IDENTIFIER:
            // System.out.println(LexerParserAnalyser.analyse("a"));

            // PLUS:
            // System.out.println(LexerParserAnalyser.analyse("(+ 2 3)"));

            // MINUS:
            // System.out.println(LexerParserAnalyser.analyse("(- 6 9)"));

            // MULT: 
            // System.out.println(LexerParserAnalyser.analyse("(× 5 8)"));

            // EQUALS:
            // System.out.println(LexerParserAnalyser.analyse("(= x y)"));

            // CONDITIONAL:
            // System.out.println(LexerParserAnalyser.analyse("(? a 4 1)"));

            // LAMBDA: 
            // System.out.println(LexerParserAnalyser.analyse("(λ a 2)"));

            // LET: 
            // System.out.println(LexerParserAnalyser.analyse("(≜ a 2 3)"));

            // APPLICATION RULES:
            // Nested Expressions:
            // System.out.println(LexerParserAnalyser.analyse("(+ (× 2 3) 4)"));
            // System.out.println(LexerParserAnalyser.analyse("(? (= x 0) 1 0)"));

            // Function Expressions:
            System.out.println(LexerParserAnalyser.analyse("((λ x (+ x 1)) 5)"));

        }
        catch (NumberException e) {
            System.out.println("Number");
        }
        catch (IdentifierException e) {
            System.out.println("Identifier");
        }
        catch (ExpressionException e) {
            System.out.println("Expression");
        }
        catch (ParseException e) {
            System.out.println("Parser");
        }
    }
}

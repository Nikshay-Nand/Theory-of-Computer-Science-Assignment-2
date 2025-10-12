public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(LexerParserAnalyser.analyse("42"));
            System.out.println(LexerParserAnalyser.analyse(""));
            System.out.println(LexerParserAnalyser.analyse("(λ 2 3)"));
            System.out.println(LexerParserAnalyser.analyse("(+ (* 2 3) 4)"));
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
    }
}

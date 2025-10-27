public class Runner {
    public static void main(String[] args) throws NumberException, IdentifierException, ExpressionException {
        //            System.out.println(LexerParserAnalyser.analyse("42"));
            System.out.println(LexerParserAnalyser.analyse("(λ a 1 1)"));
//        test.testingAllCases();
//            System.out.println(Token.typeOf('λ'));
//            System.out.println(LexerParserAnalyser.analyse("(+ (* 2 3) 4)"));
//            System.out.println(LexerParserAnalyser.analyse("((λ x (+ x 1)) 5)"));
    }
}

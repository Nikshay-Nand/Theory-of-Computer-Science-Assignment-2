import java.util.ArrayList;
import java.util.Arrays;

public class test {

    //getting all the different string to check if they follow the grammar rules or not?
    static ArrayList<String> test_cases = new ArrayList<>(
            Arrays.asList(
                    //for all the numbers
                    "1",
                    "10",
                    "101",
                    "1001",
                    "123345",

                    //for all the variables (identifiers)
                    "x",
                    "x x",
                    "x a b",

                    //deriving expr into (NUMBER)
                    "(1)",  //suposed to fail.
                    "(10)", //supposed to fail
                    "(123345)", //supposed to fail
                    "(1 2)",

                    "(x)", //pass
                    "(x x )", //pass
                    "(x a b)",

                    //deriving paren-expr into operators and other expression .
                    "(+ 1 1)",
                    "(+ a a)",
                    "(+ x 1)",
                    "(- 1 1)",
                    "(- a a)",
                    "(- x 1)",
                    "(x a a)",
                    "(x 1 1)",
                    "(x a 1)",
                    "(= 1 1)",
                    "(= a a)",
                    "(= x 1)",
                    "(? 1 1 1)",
                    "(? a a a)",
                    "(? x x 1)",
                    "(? 1 x x)",
                    "(? 1 x 1)",
                    "(? (1))",
                    "(? (x))",
                    "(? (101))",
                    "(? (+ 1 1))",
                    "(? (- 1 1))",
                    "(? (x a a))",
                    "(? (= 1 1))",
                    "(? (= x 1))",
                    "(? (? 1 1 1))",
                    "(? (x))",
                    "(? (+ 1 1))",
                    "(? (+ 1 1))",
                    "(λ x x)",
                    "(λ x 1)",
                    "(λ x (x))",
                    "(λ x (101))",
                    "(λ x (+ 1 1))",
                    "(λ x (- 1 1))",
                    "(λ x (- a a))",
                    "(λ x (- x 1))",
                    "(λ x (x a a))",
                    "(λ x (x 1 1))",
                    "(λ x (- a a))",
                    "(≜ x x)",
                    "(≜ x 1)",
                    "(≜ x (x) (1))",
                    "(≜ x (101) (x))",
                    "(≜ x (+ 1 1) (+ 1 1))",
                    "(≜ x (- 1 1) (- a a))",
                    "(≜ x (- a a) (+ x 1))",
                    "(≜ x (- a a) (- x 1))",
                    "(≜ x (- a a) (x a a))",
                    "(≜ x (- a a) (= 1 1))",
                    "(≜ x (- a a) (= x 1))",
                    "(≜ x (- a a) (? 1 1 1))"

            )


    );

    //now running the program for each test cases.
    public static void main(String[] args) {
        //running the program.
    }

    public static void testingAllCases(){
        for(String testcase:test_cases){
            try {
                System.out.println(LexerParserAnalyser.analyse(testcase));
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

}

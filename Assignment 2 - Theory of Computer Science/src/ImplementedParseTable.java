import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementedParseTable {


    //the Hshmap templae which will store each rule with non-terminal value, terminal value and al the values it can change to.
    private static final Map<String , Map<String , List<String>>> tableRule = new HashMap<>();

    public void  NTerminalToTerminal(){
        tableRule.put("expr" , new HashMap<>());
        //now making the grammar rule for the expression which will consists of what value to assign to the expr.

        //it represents each unique parse tree.

        tableRule.get("expr").put("NUMBER" , Arrays.asList("NUMBER"));
        tableRule.get("expr").put("IDENTIFIER" , Arrays.asList("IDENTIFIER"));
        tableRule.get("expr").put("LPAREN" ,Arrays.asList("LPAREN" , "paren-expr" , "RPAREN"));
        tableRule.get("paren-expr").put("PLUS" , Arrays.asList("PLUS" , "Expr" , "Expr"));
        tableRule.get("paren-expr").put("MINUS" , Arrays.asList("MINUS", "Expr" , "Expr"));
        tableRule.get("paren-expr").put("MULT" , Arrays.asList("MULT", "Expr" , "Expr"));
        tableRule.get("paren-expr").put("EQUALS" , Arrays.asList("EQUALS", "Expr" , "Expr"));
        tableRule.get("paren-expr").put("CONDITIONAL" , Arrays.asList("CONDITIONAL", "Expr", "Expr", "Expr"));
        tableRule.get("paren-expr").put("LAMBDA" , Arrays.asList("LAMBDA", "Expr"));
        tableRule.get("paren-expr").put("LET" , Arrays.asList("LET", "Expr", "Expr"));
        tableRule.get("paren-expr").put("LET" , Arrays.asList( "Expr", "Expr"));



    }

    //returnign the tableRule cause it got a private access:
    public static Map<String , Map<String , List<String>>> getTableRule(){
        return tableRule;
    }

    //a method that will return the


    //initiating the internat hashmap.


    //derivation for paren-expr.


}

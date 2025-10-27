import java.util.*;

public class ImplementedParseTable {


    //the Hshmap templae which will store each rule with non-terminal value, terminal value and al the values it can change to.
    private static final Map<String , Map<String , ArrayList<String>>> tableRule = new HashMap<>();

    public static void  NTerminalToTerminal(){
        tableRule.put("expr" , new HashMap<>());
        tableRule.put("paren-expr" , new HashMap<>());
        //now making the grammar rule for the expression which will consists of what value to assign to the expr.

        //it represents each unique parse tree.

        tableRule.get("expr").put("NUMBER" , new ArrayList<>(Arrays.asList("NUMBER")));
        tableRule.get("expr").put("IDENTIFIER" ,new ArrayList<> (Arrays.asList("IDENTIFIER")));
        tableRule.get("expr").put("LPAREN" , new ArrayList<> (Arrays.asList("LPAREN" , "paren-expr" , "RPAREN")));
        tableRule.get("paren-expr").put("PLUS" , new ArrayList<> (Arrays.asList("PLUS" , "expr" , "expr")));
        tableRule.get("paren-expr").put("MINUS" , new ArrayList<> (Arrays.asList("MINUS", "expr" , "expr")));
        tableRule.get("paren-expr").put("MULT" , new ArrayList<> (Arrays.asList("MULT", "expr" , "expr")));
        tableRule.get("paren-expr").put("EQUALS" , new ArrayList<> (Arrays.asList("EQUALS", "expr" , "expr")));
        tableRule.get("paren-expr").put("CONDITIONAL" , new ArrayList<> (Arrays.asList("CONDITIONAL", "expr", "expr", "expr")));
        tableRule.get("paren-expr").put("LAMBDA" ,new ArrayList<> (Arrays.asList("LAMBDA", "expr" ,"expr" )));
        tableRule.get("paren-expr").put("LET" ,new ArrayList<> (Arrays.asList("LET", "expr", "expr")));
        tableRule.get("paren-expr").put("expr" , new ArrayList<> (Arrays.asList( "expr", "expr")));



    }

    //returnign the tableRule cause it got a private access:
    public static Map<String, Map<String, ArrayList<String>>> getTableRule(){
        NTerminalToTerminal();
        return tableRule;
    }

    //a method that will return the


    //initiating the internat hashmap.


    //derivation for paren-expr.


}

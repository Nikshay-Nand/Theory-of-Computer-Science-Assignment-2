import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementedParseTable {


    //the Hshmap templae which will store each rule with non-terminal value, terminal value and al the values it can change to.
    private final Map<String , Map<Token.TokenType , List<String>>> tableRule = new HashMap<>();

    public void  NTerminalToTerminal(){
        tableRule.put("expr" , new HashMap<>());
        //now making the grammar rule for the expression which will consists of what value to assign to the expr.

        tableRule.get("expr").put(Token.TokenType.NUMBER , Arrays.asList("NUMBER"));
        tableRule.get("expr").put(Token.TokenType.IDENTIFIER , Arrays.asList("IDENTIFIER"));
        tableRule.get("expr").put(Token.TokenType.LPAREN ,Arrays.asList("(" , "paren-expr" , ")"));
        tableRule.get("paren-expr").put(Token.TokenType.PLUS , Arrays.asList("PLUS"));
        tableRule.get("paren-expr").put(Token.TokenType.MINUS , Arrays.asList("MINUS"));
        tableRule.get("paren-expr").put(Token.TokenType.MULT , Arrays.asList("TIMES"));
        tableRule.get("paren-expr").put(Token.TokenType.EQUALS , Arrays.asList("EQUALS"));
        tableRule.get("paren-expr").put(Token.TokenType.CONDITIONAL , Arrays.asList("QUESTION"));
        tableRule.get("paren-expr").put(Token.TokenType.LAMBDA , Arrays.asList("LAMBDA"));
        tableRule.get("paren-expr").put(Token.TokenType.LET , Arrays.asList("LET"));


    }

    //returnign the tableRule cause it got a private access:
    public static Map<String , Map<Token.TokenType , List<String>>> getTableRule(){
        return tableRule;
    }


    //initiating the internat hashmap.


    //derivation for paren-expr.


}

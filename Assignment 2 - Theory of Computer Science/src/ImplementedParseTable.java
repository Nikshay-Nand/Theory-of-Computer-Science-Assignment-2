import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementedParseTable {


    //the Hshmap templae which will store each rule with non-terminal value, terminal value and al the values it can change to.
    private final Map<String , Map<String , List<String>>> tableRule = new HashMap<>();

    public void  NTerminalToTerminal(){
        tableRule.put("expr" , new HashMap<>());
        //now making the grammar rule for the expression which will consists of what value to assign to the expr.

        tableRule.get("expr").put("NUMBER" , Arrays.asList("NUMBER"));
        tableRule.get("expr").put("IDENTIFIER" , Arrays.asList("IDENTIFIER"));
        tableRule.get("expr").put("(" ,Arrays.asList("(" , "paren-expr" , ")"));
        tableRule.get("paren-expr").put("PLUS" , Arrays.asList("PLUS"));
        tableRule.get("paren-expr").put("MINUS" , Arrays.asList("MINUS"));
        tableRule.get("paren-expr").put("TIMES" , Arrays.asList("TIMES"));
        tableRule.get("paren-expr").put("EQUALS" , Arrays.asList("EQUALS"));
        tableRule.get("paren-expr").put("QUESTION" , Arrays.asList("QUESTION"));
        tableRule.get("paren-expr").put("LAMBDA" , Arrays.asList("LAMBDA"));
        tableRule.get("paren-expr").put("DELTA" , Arrays.asList("DELTA"));


    }
    //initiating the internat hashmap.


    //derivation for paren-expr.


}

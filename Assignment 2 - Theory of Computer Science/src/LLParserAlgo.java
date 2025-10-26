//have to jfinish theh parse


import java.util.ArrayList;
import java.util.Stack;

public class LLParserAlgo {

    //now making all the attributes for the parser.
    Stack stack = new Stack();

    //this is where the parse algorithem will work

    public LLParserAlgo(ArrayList<Token> tokens) throws Exception {
      for(Token t: this.LLParser(tokens)){
          System.out.println(t);
      }
    }

    //the method that's gonna check if the token follows the termination rule or not.
    //if it does then follow the termination rules then reutrn the toke and if it doesn't follow
    //the terminal rule then throw an exception.

    public ArrayList<Token> LLParser(ArrayList<Token> tokens) throws  Exception {
        ArrayList<Token> returnTokens  = new ArrayList<>();
        int index = 0;
        this.stack = new Stack();
        this.stack.push("$");
        this.stack.push("expr");

        while(this.stack.size() > 0) {
            String top = (String) this.stack.pop();
            if(checkStackTop(top)) {
                //check with which key the value of the terminal value matches.
                // if the value matches with a perticular key then
                //by using the grammar rules, push the token into the string.
                returnTokens.add(tokens.get(index));
                index++;

            }
            if(top.equals("$")) {
                continue;  //let's go
            }

            //if the top value is non-terminal in nature then using all the grammar rules
            //derive the terminal value and then push the terminal value into the stack by following the grammar rules.
            //the loop is going ot run on the basis of the terminal value.
            if(!checkStackTop(top)) {
                //using the lookahead method see the first value of the token.
                //check what rule we will be using to derive from expr to the value.
                //now, if hte key of the current NT is expr
                //then using all the rules deriving the NT to a terminal value.


               //checking if the value of token's type is a terminal value or not.
                if(tokens.get(index).getType().toString().equals("NUMBER")||
                tokens.get(index).getType().toString().equals("IDENTFIER")) {
                    this.stack.push(tokens.get(index).getType());
                }
                if(tokens.get(index).getType().toString().equals("LPAREN")) {
                   //getting the list of all the following NT values if the R is LAPREN.
                    ArrayList<String> ParseInto = (ArrayList<String>) ImplementedParseTable.getTableRule().get("expr").get("LPAREN");
                    for(int i = ParseInto.size()-1; i>=0;i--){
                        this.stack.push(ParseInto.get(i));
                    }

                }

                //checking if the token is paren-expr and then pushing all the values of the paren-expr to the
                //list.
                if(tokens.get(index).getType().toString().equals("paren-expr")) {
                    ArrayList<String> ParseInto = (ArrayList<String>) ImplementedParseTable.getTableRule().get("paren-expr").get(tokens.get(index).getType().toString());
                    for(int i = ParseInto.size()-1; i>=0;i--){
                        this.stack.push(ParseInto.get(i));
                    }
                }
                else {
                    throw new Exception("That the token doesn't follow the rules");
                }
            }
        }
        return returnTokens;

    }

    public boolean checkStackTop(String isterm){

        //return the value fo the hashmap if the key matches with the iterm.


        if(isterm.equals("NUMBER") || isterm.equals("IDENTIFIER") || isterm.equals("PLUS") ||
                isterm.equals("MINUS")
                || isterm.equals("MULT") || isterm.equals("EQUALS") ||
                isterm.equals("CONDITIONAL") ||
                isterm.equals("LAMBDA") || isterm.equals("LET") ||
                isterm.equals("LPAREN") || isterm.equals("RPAREN")||
                isterm.equals("NONE")){
            return true;
        }
        else return false;
    }
}

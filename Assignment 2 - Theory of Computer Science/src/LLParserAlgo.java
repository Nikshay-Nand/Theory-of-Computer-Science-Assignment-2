//have to jfinish theh parse


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LLParserAlgo {

    //now making all the attributes for the parser.
    Stack stack = new Stack();
    //getting all the rules over here.
    Map<String, Map<String, ArrayList<String>>> tableRule = ImplementedParseTable.getTableRule();
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

        while(this.stack.size() > 0 ) {
            String top = (String) this.stack.pop();
            if(checkStackTop(top)) {

//                System.out.println("if it's anumber then it's been passed here");
                //check with which key the value of the terminal value matches.
                // if the value matches with a perticular key then
                //by using the grammar rules, push the token into the string.
                returnTokens.add(tokens.get(index));
                index++;

            }
            if(top.equals("$")) {
                System.out.println("✅ Parsing complete!");
                return returnTokens;  //let's go
            }

            //if the top value is non-terminal in nature then using all the grammar rules
            //derive the terminal value and then push the terminal value into the stack by following the grammar rules.
            //the loop is going ot run on the basis of the terminal value.
            if(!checkStackTop(top)) {
//                System.out.println(top);
//                System.out.println(tokens.get(index));
                //using the lookahead method see the first value of the token.
                //check what rule we will be using to derive from expr to the value.
                //now, if hte key of the current NT is expr
                //then using all the rules deriving the NT to a terminal value.
            //implementing this part of the assignment:
                //get all theproductino rules
                Map<String, Map<String, ArrayList<String>>> ProductionRules = ImplementedParseTable.getTableRule();
                Map<String, ArrayList<String>> ProductionRule = ProductionRules.get(top);
//                ArrayList<String> theRule = new ArrayList<>();
                if (ProductionRule == null) {
                    throw new Exception("No rules found for non-terminal: " + top);
                }
//


                //trying to get the rule if the next value ia number or an identifier (basically an expr)
                if(tokens.get(index).getType().toString().equals("NUMBER") &&
                        top.equals("paren-expr")
                        || tokens.get(index).getType().toString().equals("IDENTIFIER") && top.equals("paren-expr")) {
                    ArrayList<String> theRule = ProductionRule.get("expr");
                    if (theRule == null) {
//
                        throw new Exception("No rule for (" + top + ", " + tokens.get(index).getType() + ") returntoken was"+ returnTokens);
//
                    }
//
//
                    for(int i = theRule.size() - 1; i >= 0; i--) {

                    System.out.println(theRule.get(i));
                        this.stack.push(theRule.get(i));
                    }
                }
                else {
                    ArrayList<String> theRule = ProductionRule.get(tokens.get(index).getType().toString());
                    if (theRule == null) {
//
                        throw new Exception("No rule for (" + top + ", " + tokens.get(index).getType() + ") returntoken was"+ returnTokens);
//
                    }
//
//
                    for(int i = theRule.size() - 1; i >= 0; i--) {
//                    System.out.println(theRule.get(i));
                        this.stack.push(theRule.get(i));
                    }
                }


//
                System.out.println("Token "+ tokens.get(index) + " type of the token "+ tokens.get(index).getType().toString() );


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

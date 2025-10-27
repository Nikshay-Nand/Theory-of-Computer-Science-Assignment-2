//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
////import static sun.jvm.hotspot.oops.CellTypeState.top;
//
//public class ParsingAlgo {
//
////making the constructor that's gonna take the valueint it and initialise the token.
//    private List<Token> tokens;
//    //stack list to store all values inthe stack.
//    private Stack<String> stack;
//    private ImplementedParseTable ipt = new ImplementedParseTable();;
//
//    //making the constructor:
//    public  ParsingAlgo(List<Token> token){
//        this.tokens = token;
//        this.stack = new Stack<>();
//    }
//
//    //making a method that will take the token and run on it and will make the parse table.
//
//    public ArrayList<Object> parse_the_token(List<Token> tokens) throws Exception {
//        //the code implementation of the parse tree.
//        //making the tree.
//        //the parsetree will be containing a nested list inside of the main list that being said, the
//        //type of the parsetree has to be Object.
//        ArrayList<Object> parseTree = new ArrayList<>();
//        int index = 0;
//
//
//
//        //the special symbol which means end of th eline.
//        this.stack.add("$");
//        this.stack.add("Expr");
//
//        while(this.stack.size() > 0){
//
//            //getting the token for what we ahve to check.
//            Token token = tokens.get(index);
//
//           String firstout = this.stack.pop();
////            now, using the method of look-ahead we will be able to check if the value of the key matches with the given value
//            //and if it does then we will add that token in the list
//            //and if it doesn't then we will just throw an exception.
//
//            //checking if the given value is terminal or not.
//            //if the value is terminal then remove it from the list and then pass it to the tree
//            if(checkStackTop(firstout)){
//                //then add the value to the tree and then pass the code further.
//                for(Token t : tokens){
//                    if(t.getType().toString().equals(firstout)){
//                        parseTree.add(t.getType());
//                    }
//                }
//                index++;
//            }
//            if(firstout.equals("$")){
//                return parseTree;
//            }
//            else {
//                //getting theterminal value out of the non-terminal value.
//                //get the hasmmap form the rule and then stack it in the stack
//                //so that a loop on stack will determine and get us the the string of all the values.
//
//                    ArrayList allValues = (ArrayList) ImplementedParseTable.getTableRule().get(firstout);
//
//                    //and then adding each value of the allValues one by one in teh stack in the LIFO method.
//
//
//                    //checking the value of the allvalues.
//                //if it's nothign then throw an exception or else continue with the code.
//                if(allValues.size() <= 0){
//                    throw new Exception("No grammar rule is being followed by the parser.");
//                }
//                else {
//                    for(int i = allValues.size() - 1; i >= 0; i--){
//                        this.stack.push(allValues.get(i).toString());
//                    }
//                }
//
//
//
//            }
//
//
//            if(this.stack.peek().equals("$")){
//                    System.out.println("The stack is empoy and no item to pull!");
//            }
////            if(this.stack.pop().matches(token.getType().toString())){
////                parseTree.add(token);
////                index+;
////            }
//
//
//
//        }
//
//    return parseTree;
//    }
//
//    // LAMBDA, LET, LPAREN, RPAREN, NONE
//
//
//    //a method that will check if the given value a terminal or not with values
//    public boolean checkStackTop(String isterm){
//
//        //return the value fo the hashmap if the key matches with the iterm.
//
//
//        if(isterm.equals("NUMBER") || isterm.equals("IDENTIFIER") || isterm.equals("PLUS") ||
//                isterm.equals("MINUS")
//        || isterm.equals("MULT") || isterm.equals("EQUALS") ||
//                isterm.equals("CONDITIONAL") ||
//        isterm.equals("LAMBDA") || isterm.equals("LET") ||
//                isterm.equals("LPAREN") || isterm.equals("RPAREN")||
//        isterm.equals("NONE")){
//            return true;
//        }
//        else return false;
//    }
//
////    public boolean checkStackTop(Token.TokenType isterm){
////
////        //return the value fo the hashmap if the key matches with the iterm.
////
////
////        if(isterm.equals(Token.TokenType.NUMBER) || isterm.equals(Token.TokenType.IDENTIFIER) || isterm.equals(Token.TokenType.PLUS) ||
////                isterm.equals(Token.TokenType.MINUS)
////                || isterm.equals(Token.TokenType.MULT) || isterm.equals(Token.TokenType.EQUALS) ||
////                isterm.equals(Token.TokenType.CONDITIONAL) ||
////                isterm.equals(Token.TokenType.LAMBDA) || isterm.equals(Token.TokenType.LET) ||
////                isterm.equals(Token.TokenType.LPAREN) || isterm.equals(Token.TokenType.RPAREN)||
////                isterm.equals(Token.TokenType.NONE)){
////            return true;
////        }
////        else return false;
////    }
//}

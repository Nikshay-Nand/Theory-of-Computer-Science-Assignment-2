import java.util.*;

public class Parser {
    private final Map<String, Map<Token.TokenType, Integer>> parseTable = new HashMap<>();
    private int current = 0;

    // Parse Table
    private void parseTable() {
        parseTable.put("PROGRAM", new HashMap<>());
        parseTable.put("EXPR", new HashMap<>());
        parseTable.put("PAREN-EXPR", new HashMap<>());

        parseTable.get("PROGRAM").put(Token.TokenType.NUMBER, 1);
        parseTable.get("PROGRAM").put(Token.TokenType.IDENTIFIER, 1);
        parseTable.get("PROGRAM").put(Token.TokenType.LPAREN, 1);

        parseTable.get("EXPR").put(Token.TokenType.NUMBER, 2);
        parseTable.get("EXPR").put(Token.TokenType.IDENTIFIER, 3);
        parseTable.get("EXPR").put(Token.TokenType.LPAREN, 4);

        parseTable.get("PAREN-EXPR").put(Token.TokenType.PLUS, 5);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.MINUS, 6);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.MULT, 7);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.EQUALS, 8);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.CONDITIONAL, 9);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.LAMBDA, 10);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.LET, 11);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.NUMBER, 12);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.IDENTIFIER, 12);
        parseTable.get("PAREN-EXPR").put(Token.TokenType.LPAREN, 12);
    }

    // Lookahead 
    private Token lookahead(List<Token> tokens) {
        if (current < tokens.size()) { return tokens.get(current); }
        return new Token(Token.TokenType.NONE);
    }

    // Increases the count of the index number of the current symbol
    private void resume() {
        current++;
    }

    // Checks if the string is a Terminal
    private boolean isTerminal(String s) {
        String[] terminal = {"NUMBER", "IDENTIFIER", "(", ")", "+", "-", "×", "=", "?", "λ", "≜", "$"};
        for (String t : terminal) {
            if (t.equals(s)) {
                return true;
            }
        }
        return false;
    }

    // Matches the top of the stack
    private boolean isMatch(String top, Token token) {
        switch (top) {
            case "NUMBER":
                return token.getType() == Token.TokenType.NUMBER;
            case "IDENTIFIER":
                return token.getType() == Token.TokenType.IDENTIFIER;
            case "(":
                return token.getType() == Token.TokenType.LPAREN;
            case ")":
                return token.getType() == Token.TokenType.RPAREN;
            case "+":
                return token.getType() == Token.TokenType.PLUS;
            case "-":
                return token.getType() == Token.TokenType.MINUS;
            case "×":
                return token.getType() == Token.TokenType.MULT;
            case "=":
                return token.getType() == Token.TokenType.EQUALS;
            case "?":
                return token.getType() == Token.TokenType.CONDITIONAL;
            case "λ":
                return token.getType() == Token.TokenType.LAMBDA;
            case "≜":
                return token.getType() == Token.TokenType.LET;
            case "$":
                return token.getType() == Token.TokenType.NONE;
            default:
                return false;
        }
    }

    // Gets the Rule Number from the Parse Table
    private int getRule(String var, Token token) {
        return parseTable.get(var).get(token.getType());
    }

    // Push the appropriate production rule into the stack to parse
    private void pushProduction(Stack<String> stack, int rule) {
        List<String> rhs = new ArrayList<>();
        switch(rule) {
            case 1:
                rhs.add("EXPR");
                break;
            case 2:
                rhs.add("NUMBER");
                break;
            case 3:
                rhs.add("IDENTIFIER");
                break;
            case 4:
                rhs.add("(");
                rhs.add("PAREN-EXPR");
                rhs.add(")");
                break;
            case 5:
                rhs.add("+");
                rhs.add("EXPR");
                rhs.add("EXPR");
                break;
            case 6:
                rhs.add("-");
                rhs.add("EXPR");
                rhs.add("EXPR");
                break;
            case 7:
                rhs.add("×");
                rhs.add("EXPR");
                rhs.add("EXPR");
                break;
            case 8:
                rhs.add("=");
                rhs.add("EXPR");
                rhs.add("EXPR");
                break;
            case 9:
                rhs.add("?");
                rhs.add("EXPR");
                rhs.add("EXPR");
                rhs.add("EXPR");
                break;
            case 10:
                rhs.add("λ");
                rhs.add("IDENTIFIER");
                rhs.add("EXPR");
                break;
            case 11:
                rhs.add("≜");
                rhs.add("IDENTIFIER");
                rhs.add("EXPR");
                rhs.add("EXPR");
                break;
            case 12:
                rhs.add("EXPR");
                break;
        }
        
        for (int i = rhs.size() - 1; i >= 0; i--) {
            stack.push(rhs.get(i));
        }
    }

    public void parse(List<Token> tokens) throws ParseException {
        Stack<String> stack = new Stack<>();
        parseTable();
        stack.push("$");
        stack.push("PROGRAM");

        while(!stack.isEmpty()) {
            Token lookahead = lookahead(tokens);
            String peek = stack.peek();
            System.out.println(stack);

            if (isTerminal(peek)) {
                if (isMatch(peek, lookahead)) {
                    stack.pop();
                    resume();
                } else {
                    throw new ParseException();
                }
            }
            else {
                Integer rule = getRule(peek, lookahead);
                stack.pop();
                pushProduction(stack, rule);
            }
        }
    }
}

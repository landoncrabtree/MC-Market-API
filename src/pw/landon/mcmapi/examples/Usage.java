package pw.landon.mcmapi.examples;

import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;

public class Usage {
    public static void main(String[] args) throws Exception {

        // Create the Token object.
        // Token(key, type). Valid types are: TokenType.PRIVATE and TokenType.SHARED
        Token token = new Token("", Token.TokenType.PRIVATE);

        // Check to ensure the token key and type are valid.
        if (Wrapper.init(token)) {
            System.out.println("[MCM-API] Initialised successfully.");
            Wrapper.token = token;
            // Done!
        } else {
            System.out.println("[MCM-API] Error while initialising. Check to ensure your token is correct.");
            System.exit(0);
        }
    }
}



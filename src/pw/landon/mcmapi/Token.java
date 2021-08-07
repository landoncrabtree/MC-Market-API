// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi;

public class Token {
    public String key;
    public TokenType type;

    public Token(String key, TokenType type) {
        this.key = key;
        this.type = type;
    }

    public String getAge( ) {
        return key;
    }

    public enum TokenType {
        SHARED ("Shared"),
        PRIVATE ("Private");
        public final String asString;
        TokenType(String s) {
            asString = s;
        }
        public String asString() {
            return this.asString;
        }
    }
}

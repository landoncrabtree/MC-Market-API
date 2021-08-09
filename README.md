# MC-Market Ultimate API: Java Wrapper
![Downloads](https://img.shields.io/github/downloads/landoncrabtree/MCM-API/total)

This project is an unofficial implemention of MC-Market's Ultimate RESTful API written in Java.
This project allows easy access to many methods of the API, all you have to do is import the project.

## Installation & Initialising
1. Import the wrapper into your project by downloading the source and adding it into your own project's source. Download the latest version of the Wrapper on the [Releases](https://github.com/landoncrabtree/MCM-API/releases) page. Download `MCM-API-Java.zip` and extract it. In the folder, you will find two libraries: External and Spigot. External includes the GSON library, whereas Spigot does not (because Spigot has GSON included already). If you are implementing the wrapper in an external program, such as a program to run a CRON job, you should use the external library source code within your project. If you are implementing the wrapper within a Spigot plugin, such as a version-checker, you should use the Spigot library source code within your project. 


2. Create the Token object. 

```java
import pw.landon.mcmapi.Token;

// There are two supported TokenTypes, PRIVATE and SHARED.
Token token = new Token("YOUR TOKEN KEY HERE", Token.TokenType.PRIVATE);
//Token token = new Token("YOUR TOKEN KEY HERE", Token.TokenType.SHARED);
```

3. Initialise your Token to ensure everything is correct.

```java
import pw.landon.mcmapi.Wrapper;
import pw.landon.mcmapi.Token;

// There are two supported TokenTypes, PRIVATE and SHARED.
Token token = new Token("YOUR TOKEN KEY HERE", Token.TokenType.PRIVATE);
//Token token = new Token("YOUR TOKEN KEY HERE", Token.TokenType.SHARED);

if (Wrapper.init(token)) {
    System.out.println("[MCM-API] Initialised successfully.");
    Wrapper.token = token; // This is NEEDED. Ensure you set the Wrapper token.
} else {
    System.out.println("[MCM-API] Error while initialising. Check to ensure your token is correct.");
}
```

## Usage
For usage documentation and pre-made examples, please check out the [Documentation](https://github.com/landoncrabtree/MCM-API/tree/master/src/pw/landon/mcmapi/examples)

## Issues, support, and requests
If you have any issues, need general support, or have requests to be added, use the [issues tracker](https://github.com/landoncrabtree/MCM-API/issues).

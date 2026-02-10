package com.gnews.fake.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

// INFO: Comentários javadoc incompletos
/**
 * String utility class
 */
public class StringUtils {
    
    // BLOCKER: Optional como campo - viola standards.md
    private Optional<String> cachedValue;
    
    // LOW: Variável de instância não utilizada
    private int unusedCounter = 0;
    private String unusedString;
    
    // INFO: Magic numbers sem constantes
    private static final int MAGIC_NUMBER = 42;
    
    // BLOCKER: Potencial NullPointerException
    public static String toUpperCase(String input) {
        // Não verifica se input é null antes de usar
        return input.toUpperCase(); // BLOCKER: NPE se input for null
    }
    
    // BLOCKER: Uso de Optional como parâmetro - viola standards.md
    public static String processOptional(Optional<String> value) {
        return value.orElse("default");
    }
    
    // LOW: Método nunca usado
    private void neverUsedMethod() {
        System.out.println("This is never called");
    }
    
    // INFO: Código comentado desnecessário
    // public static String oldMethod(String s) {
    //     return s.toLowerCase();
    // }
    // 
    // public static boolean isValid(String s) {
    //     return s != null && !s.isEmpty();
    // }
    
    // BLOCKER: Comparação de strings com == em vez de equals
    public static boolean compareStrings(String a, String b) {
        return a == b; // BLOCKER: deve usar equals()
    }
    
    // LOW: TODO não resolvido
    // TODO: Implement proper validation
    public static boolean validate(String input) {
        return true;
    }
    
    // BLOCKER: Divisão por zero potencial
    public static int calculate(int a, int b) {
        return a / b; // BLOCKER: se b for 0, ArithmeticException
    }
    
    // INFO: Método com comentário óbvio
    // This method returns true
    public static boolean returnTrue() {
        return true;
    }
    
    // BLOCKER: SQL Injection potencial
    public static String buildQuery(String userInput) {
        // BLOCKER: Concatenação direta de input do usuário em query
        return "SELECT * FROM articles WHERE title = '" + userInput + "'";
    }
    
    // LOW: Variável local não utilizada
    public static String process(String text) {
        String unused = "not used";
        int alsoUnused = 10;
        return text;
    }
    
    // BLOCKER: Hardcoded password
    private static final String DB_PASSWORD = "password123";
    private static final String API_KEY = "12345-abcde-67890";
    
    // INFO: Empty catch block
    public static void riskyOperation() {
        try {
            // Some risky operation
            throw new Exception("Error");
        } catch (Exception e) {
            // BLOCKER: Empty catch block - erro ignorado
        }
    }
    
    // BLOCKER: Return null em vez de Optional
    public static String findValue(String key) {
        if (key == null) {
            return null; // BLOCKER: deveria retornar Optional
        }
        return "value";
    }
}

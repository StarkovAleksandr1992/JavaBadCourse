package ru.starkov;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String exp = "1 + 1 * (4-2 *(3 - 1)) + 6 / 3";

        List<Lexeme> lexemes = Lexeme.lexAnalyze(exp);
        Lexeme.LexemeBuffer lexemeBuffer = new Lexeme.LexemeBuffer(lexemes);
        System.out.println(lexemes);
        System.out.println(Lexeme.expr(lexemeBuffer));
    }
}

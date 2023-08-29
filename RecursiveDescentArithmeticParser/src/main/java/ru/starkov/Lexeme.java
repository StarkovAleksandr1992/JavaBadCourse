package ru.starkov;

import java.util.ArrayList;
import java.util.List;

import static ru.starkov.LexemeType.*;

public class Lexeme {
    private LexemeType lexemeType;
    private String value;

    public Lexeme(LexemeType lexemeType, String value) {
        this.lexemeType = lexemeType;
        this.value = value;
    }

    public Lexeme(LexemeType lexemeType, Character value) {
        this.lexemeType = lexemeType;
        this.value = value.toString();
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "lexemeType=" + lexemeType +
                ", value='" + value + '\'' +
                '}';
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expText.length()) {
            char currentChar = expText.charAt(pos);
            switch (currentChar) {
                case '(' -> {
                    lexemes.add(new Lexeme(LEFT_BRACKET, currentChar));
                    pos++;
                }
                case ')' -> {
                    lexemes.add(new Lexeme(RIGHT_BRACKET, currentChar));
                    pos++;
                }
                case '+' -> {
                    lexemes.add(new Lexeme(OP_PLUS, currentChar));
                    pos++;
                }
                case '-' -> {
                    lexemes.add(new Lexeme(OP_MINUS, currentChar));
                    pos++;
                }
                case '*' -> {
                    lexemes.add(new Lexeme(OP_MULTIPLICATION, currentChar));
                    pos++;
                }
                case '/' -> {
                    lexemes.add(new Lexeme(OP_DIVISION, currentChar));
                    pos++;
                }
                default -> {
                    StringBuilder number = new StringBuilder();
                    if (currentChar >= '0' && currentChar <= '9') {
                        do {
                            number.append(currentChar);
                            pos++;

                            if (pos >= expText.length()) {
                                break;
                            }
                            currentChar = expText.charAt(pos);
                        } while (currentChar >= '0' && currentChar <= '9');
                        lexemes.add(new Lexeme(NUMBER, number.toString()));
                    } else {
                        if (currentChar != ' ') {
                            throw new RuntimeException("Its not a digit");
                        } else {
                            pos++;
                        }
                    }
                }
            }
        }
        lexemes.add(new Lexeme(EOF, ""));
        return lexemes;
    }

    public static int factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        int value = 0;
        switch (lexeme.lexemeType) {
            case NUMBER -> value = Integer.parseInt(lexeme.value);
            case LEFT_BRACKET -> {
                value = expr(lexemes);
                lexeme = lexemes.next();
                if (lexeme.lexemeType != RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position " + lexemes.getPos());
                }
            }
            default -> {
                throw new RuntimeException("Unexpected token: " + lexeme.value + "at position " + lexemes.getPos());
            }
        }
        return value;
    }

    public static int multdiv(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.lexemeType) {
                case OP_MULTIPLICATION -> value *= factor(lexemes);
                case OP_DIVISION -> value /= factor(lexemes);
                default -> {
                    lexemes.back();
                    return value;
                }
            }
        }
    }

    public static int plusminus(LexemeBuffer lexemes) {
        int value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.lexemeType) {
                case OP_PLUS -> value += multdiv(lexemes);
                case OP_MINUS -> value -= multdiv(lexemes);
                default -> {
                    lexemes.back();
                    return value;
                }
            }
        }
    }

    public static int expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.lexemeType == EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }


    public static class LexemeBuffer {
        private List<Lexeme> lexemes;
        private int pos;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }


}

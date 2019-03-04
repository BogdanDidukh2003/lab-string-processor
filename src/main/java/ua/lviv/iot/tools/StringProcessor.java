package ua.lviv.iot.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private String inputText;
    private StringBuilder resultStrBuilder;
    private String wordPatternPart = "[a-zA-Z']*\\b";

    public StringProcessor() {
    }

    public StringProcessor(String inputText) {
        this.inputText = inputText;
    }

    public void processText() {
        resultStrBuilder = new StringBuilder();
        String[] alphabet = {"a|A", "b|B", "c|C", "d|D", "e|E", "f|F", "g|G", "h|H",
                "i|I", "j|J", "k|K", "l|L", "m|M", "n|N", "o|O", "p|P", "q|Q", "r|R",
                "s|S", "t|T", "u|U", "v|V", "w|W", "x|X", "y|Y", "z|Z"};
        boolean isFound;

        resultStrBuilder.append("\t");
        for (int letterIndex = 0; letterIndex < alphabet.length - 1; letterIndex++) {
            isFound = false;
            Pattern pattern = Pattern.compile("\\b[" + alphabet[letterIndex] + "]" + wordPatternPart);
            Matcher matcher = pattern.matcher(inputText);

            while (matcher.find()) {
                resultStrBuilder.append(matcher.group() + " ");
                isFound = true;
            }
            if (isFound) {
                resultStrBuilder.append("\n\t");
            }
        }
    }

    public String getResultString() {
        return resultStrBuilder.toString();
    }

    public void showResults() {
        System.out.println(this.getResultString());
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}

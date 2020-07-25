package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File(args[0]);
        // all variable names should be consistent, self-documenting, and purposeful
        // the exception are little things we use that everyone knows
        // like scanner
        // or in a for loop, i (or j)

        try (Scanner scanner = new Scanner(textFile)) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            Text text = new Text(String.join("\n", lines)); // now we can create a new text object

            int wordCount = text.getWordCount();
            int sentenceCount = text.getSentenceCount();
            int charCount = text.getCharacterCount();
            int syllables = text.getSyllableCount()[0];
            int polysyllables = text.getSyllableCount()[1];
            double score = text.getReadabilityIndex();
            String ages = text.getText();

            System.out.println("Words: " + wordCount);
            System.out.println("Sentences: " + sentenceCount);
            System.out.println("Characters: " + charCount);
            System.out.println("Syllables: " + syllables);
            System.out.println("Polysyllables: " + polysyllables);
            System.out.println("The score is: " + score);
            System.out.println("This text should be understood by " + ages + " year olds.");
            Scanner sc = new Scanner(System.in);
            String method = sc.nextLine();

            switch (method) {
                case "ARI":
                    score = text.getReadabilityIndex();
                    System.out.println("Automated Readability Index: " + score + " (about " + text.getAgeGroup() + " year olds).");
                case "FK":
                    score = text.getfKReadabilityScore();
                    System.out.println("Flesch–Kincaid readability tests: " + score + " (about " + text.getAgeGroup() + " year olds).");
                case "SMOG":
                    score = text.getSmogIndex();
                    System.out.println("Simple Measure of Gobbledygook: " + score + "(about " + text.getAgeGroup() + " year olds).");
                case "CL":
                    score = text.getColemanLiauIndex();
                    System.out.println("Coleman-Liau index: " + score + " (about " + text.getAgeGroup() + " year olds).");
                case "all":
                    int totalAge = 0;
                    score = text.getReadabilityIndex();
                    totalAge += Integer.parseInt(text.getAgeGroup());
                    System.out.println("Automated Readability Index: " + score + " (about " + text.getAgeGroup() + " year olds).");
                    score = text.getfKReadabilityScore();
                    totalAge += Integer.parseInt(text.getAgeGroup());
                    System.out.println("Flesch–Kincaid readability tests: " + score + " (about " + text.getAgeGroup() + " year olds).");
                    score = text.getSmogIndex();
                    totalAge += Integer.parseInt(text.getAgeGroup());
                    System.out.println("Simple Measure of Gobbledygook: " + score + "(about " + text.getAgeGroup() + " year olds).");
                    score = text.getColemanLiauIndex();
                    totalAge += Integer.parseInt(text.getAgeGroup());
                    System.out.println("Coleman–Liau index: " + score + " (about " + text.getAgeGroup() + " year olds).");
                    System.out.println("\nThis text should be understood in average by " + (double) totalAge / 4 + " year olds.");
                    break;
            }
        }
    }
}

class Text {
    private final String text; // PROPERTIES SHOULD BE PRIVATE BY DEFAULT
    // ERR ON THE SIDE OF RESTRICTIVENESS
    private final int characterCount; // BUT THEY ARE NOT PASSED IN. THEY ARE COMPUTED IN THE CONSTRUCTOR
    private final int[] syllableCount;
    private final int wordCount;
    private final int sentenceCount; // THESE ARE FIELDS BECAUSE THEY ARE PROPERTIES OF A TEXT
    private final double readabilityScore;
    private final double fKReadabilityScore;
    private final double smogIndex;
    private final double colemanLiauIndex;
    private final String ageGroup;

    // if a field can be final (it is not changed after the constructor)
    // it should

    // PRINCIPLE 1: ACCESS SHOULD BE LIMITED AS MUCH AS POSSIBLE
    // PRINCIPLE 2: MUTABILITY SHOULD BE LIMITED AS MUCH AS POSSIBLE

    // mutability = ability to change

    public Text(String text) { // YOU SHOULD SHADOW FIELD NAMES
        // YOU SHOULD ALSO COMPUTE ANY PROPERTIES HERE
        // ALSO, YOU SHOULD GO IN ORDER
        // EG FIRST PROPERTY SHOULD BE INSTANTIATED FIRST
        // so here text is instantiated
        // then wordCount because it is second on the field list
        this.text = text;

        int charCountTmp = 0;
        for (char c : text.toCharArray()) {
            if (c != ' ') charCountTmp++;
        }

        this.characterCount = charCountTmp;
        this.syllableCount = calculateSyllables();
        this.wordCount = text.split(" ").length;
        this.sentenceCount = text.split("[.!]").length;
        this.readabilityScore =
                4.71 * (((double) this.characterCount) / this.wordCount)
                        + 0.5 * ((double) this.wordCount / this.sentenceCount) - 21.43;
        this.fKReadabilityScore =
                0.39 * (((double) this.wordCount) / this.sentenceCount)
                        + 11.8 * (((double) this.syllableCount[0]) / this.wordCount)
                        - 15.59;
        this.smogIndex =
                1.043 * Math.sqrt(this.syllableCount[1] * (((double) 30) / this.sentenceCount)) + 3.1291;
        this.colemanLiauIndex =
                0.0588 * (((double) this.characterCount / this.wordCount) * 100) - 0.296
                        * (((double) this.sentenceCount / this.wordCount) * 100) - 15.8;
        this.ageGroup = calculateAgeGroup(); // we don't want a super long constructor
        // methods should generally be easy to understand and short

    }

    private int[] calculateSyllables() {
        int syllables = 0;
        int polysyllables = 0;

        String[] words = this.text.split(" ");
        for (String word : words) {
            String i = "(?i)[aiouy][aeiouy]*|e[aeiouy]*(?!d?\\b)";
            Matcher m = Pattern.compile(i).matcher(word.trim());
            int currentWordSyllables = 0;

            while (m.find()) {
                currentWordSyllables++;
            }
            if (currentWordSyllables == 0) currentWordSyllables = 1;
            syllables += currentWordSyllables;
            if (currentWordSyllables > 2) polysyllables++;
        }
        return new int[]{Math.max(syllables, 1), Math.max(polysyllables, 1)};
    }

    private String calculateAgeGroup() { // should be PRIVATE because we don't want to give access
        // this could be improved further by introducing an ENUM, having a static method inside the
        // enum class that parses a string to enum, and overriding toString
        // and then you return the enum
        // but i'm not gonna do that

        switch ((int) Math.ceil(this.readabilityScore)) {
            case 1:
                return "6";
            case 2:
                return "7";
            case 3:
                return "9";
            case 4:
                return "10";
            case 5:
                return "11";
            case 6:
                return "12";
            case 7:
                return "13";
            case 8:
                return "14";
            case 9:
                return "15";
            case 10:
                return "16";
            case 11:
                return "17";
            case 12:
                return "18";
            case 13:
                return "24";
            case 14:
                return "24+";
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public int[] getSyllableCount() {
        return syllableCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public double getReadabilityIndex() {
        return readabilityScore;
    }

    public double getfKReadabilityScore() {
        return fKReadabilityScore;
    }

    public double getSmogIndex() {
        return smogIndex;
    }

    public double getColemanLiauIndex() {
        return colemanLiauIndex;
    }

    public String getAgeGroup() {
        return this.ageGroup;
    }

    public String getText() {
        // even though this is unused, it's an obvious getter to include - essence of text is the text
        return text;
    }
}

package MathPackage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationDetection {
    public static void main(String[] args) {
        String sentence = "can you increase 12 by 6?";
        String operation = detectOperation(sentence);
        System.out.println("Operation: " + operation);
        float[] numbers = ExtractNumbers(sentence);
        System.out.println("Numbers are : " + numbers[0]+" and "+numbers[1]);

    }

    public static float[] ExtractNumbers(String sentence) {

        String[] split = sentence.split("[ ?]");
        float[] numbers = new float[2];
        int counter=0;
        for (int i = 0; i < split.length; i++) {
            try {
                float f = Float.parseFloat(split[i]);
                numbers[counter] = f;
                counter++;
            } catch (Exception e) {
                // TODO: handle exception
            }
         
        }

        return numbers;
    }
    public static String detectOperation(String sentence) {
        Pattern sumPattern = Pattern.compile("(sum|add(ition)?)\\s*(of)?\\s*(\\d+(\\.\\d+)?)\\s*(and|with)?\\s*(\\d+(\\.\\d+)?)");
        Pattern subPattern = Pattern.compile("(difference|subtract(ion)?)\\s*(of)?\\s*(\\d+(\\.\\d+)?)\\s*(and|with)?\\s*(\\d+(\\.\\d+)?)");
        Pattern multPattern = Pattern.compile("(product|multiply|multiplication)\\s*(of)?\\s*(\\d+(\\.\\d+)?)\\s*(and|with)?\\s*(\\d+(\\.\\d+)?)");
        Pattern divPattern = Pattern.compile("(quotient|divide|division|quotent|devide|devision)\\s*(of)?\\s*(\\d+(\\.\\d+)?)\\s*(and|with)?\\s*(\\d+(\\.\\d+)?)", Pattern.CASE_INSENSITIVE);
        Pattern Logpattern = Pattern.compile("\\b(logarithm\\s+of\\s+\\S+|log\\s*\\([^\\)]+\\)|log(?!\\())", Pattern.CASE_INSENSITIVE);
        Pattern Increasingpattern = Pattern.compile("(increment|increase|add)\\s+(\\d+)\\s+by\\s+(\\d+)\\b", Pattern.CASE_INSENSITIVE);
        Pattern decreasingpattern = Pattern.compile("(decrement|decrease|minus)\\s+(\\d+)\\s+by\\s+(\\d+)\\b", Pattern.CASE_INSENSITIVE);

        
        Matcher matcher;

        matcher = sumPattern.matcher(sentence);
        if (matcher.find()) {
            return "sum";
        }

        matcher = subPattern.matcher(sentence);
        if (matcher.find()) {
            return "subtraction";
        }

        matcher = multPattern.matcher(sentence);
        if (matcher.find()) {
            return "multiplication";
        }

        matcher = divPattern.matcher(sentence);
        if (matcher.find()) {
            return "division";
        }

        matcher = Logpattern.matcher(sentence);
        if (matcher.find()) {
            return "Log";
        }
        matcher = Increasingpattern.matcher(sentence);
        if (matcher.find()) {
            return "Increasing";
        }
        matcher = decreasingpattern.matcher(sentence);
        if (matcher.find()) {
            return "decreasing";
        }
        return "unknown";
    }
}

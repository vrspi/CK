import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

public class LanguageDetector {
    public static void main(String[] args) throws IOException {
        // Load the language detector model
        InputStream modelIn = LanguageDetector.class.getResourceAsStream("langdetect-183.bin");
        LanguageDetectorModel model = new LanguageDetectorModel(modelIn);

        // Create a LanguageDetectorME object
        LanguageDetectorME detector = new LanguageDetectorME(model);

        // Detect the language of the user's input
        String input = "Bonjour tout le monde";
        String[] languages = detector.predictLanguages(input);

        // Print the detected language
        System.out.println("Detected language: " + languages[0]);

        
    }
}
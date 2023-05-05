package Tools;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class pipline {
    
    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
    private static String PropertiesName = "tokenize, ssplit, pos, lemma, stopword";
    

    private pipline(){

    }
    static{
        properties = new Properties();
        properties.setProperty("annotators, tokenize, ssplit, pos, lemma, stopword", PropertiesName);
    }

    public static StanfordCoreNLP getPipline(){
        if(stanfordCoreNLP == null){
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
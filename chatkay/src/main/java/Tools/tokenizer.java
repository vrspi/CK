package Tools;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class tokenizer {
    
    private StanfordCoreNLP stanfordCoreNLP = pipline.getPipline();
    private String Text ="";
    public void setText(String text) {
        Text = text;
    }

    private List<String> list = new ArrayList<String>();
    
    
    public tokenizer(String Query){
        Text = Query;
       
    }

    public List<String> tokenize(String Query){
      
    CoreDocument coreDocument = new CoreDocument(Query);
    stanfordCoreNLP.annotate(coreDocument);
       List<CoreLabel> l = coreDocument.tokens();
       for (CoreLabel coreLabel : l) {
        list.add(coreLabel.originalText());
       }
       return list;
    }
}

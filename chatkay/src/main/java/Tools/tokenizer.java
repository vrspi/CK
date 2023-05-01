package Tools;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class tokenizer {
    
    private StanfordCoreNLP stanfordCoreNLP = pipline.getPipline();
    private String Text ="";
    private List<String> list = new ArrayList<String>();
    public tokenizer(String Query){
        Text = Query;
    }

    public List<String>  tokenize(){
        CoreDocument coreDocument = new CoreDocument(Text);
       stanfordCoreNLP.annotate(coreDocument);

       List<CoreLabel> l = coreDocument.tokens();
       for (CoreLabel coreLabel : l) {
        list.add(coreLabel.originalText());
       }
       return list;
    }
}
package CodePackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Tools.pipline;
import Tools.tokenizer;
import edu.stanford.nlp.pipeline.Annotation;
public class CodeScrapper {
    private String Query;
    private String url;
    private Document document;
    private String Language;
    private List<String> QueryWords;


    public List<String> getQueryWords() {
        return QueryWords;
    }

    public String getLanguage() {
        return Language;
    }
    private String Code;
    public String getCode() {
        return Code;
    }

    public Document getDocument() {
        return document;
    }

    public String getUrl() {
        return url;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String codeQuery) {
        Query = codeQuery;
    }

    public CodeScrapper(String Query){
        this.Query = Query;
        url  = "https://codepal.ai/";
        tokenizer Tokenizer = new tokenizer(Query);
        QueryWords = Tokenizer.tokenize();

    }
    public String Start(){
        try {
             document = Jsoup.connect(url).get();
            return Scrap();
        } catch (IOException e) {
            System.out.println("I'm sorry but I can't Generate Code for you");
        }
        return "";
    }
    public String Scrap() {
        Language = GetLanguage();
        Elements ButtonLang = document.select(".btn.btn-primary-2.dropdown-toggle");
        Elements TextEdit = document.select(".form-control");
        ButtonLang.attr("data-language", Language);
        

        return "";
    }
    public String GetLanguage(){
        String filename = "chatkay\\src\\main\\java\\CodePackage\\DataCode.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                if(Query.contains(line))
                return line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Nothing";
    }
}

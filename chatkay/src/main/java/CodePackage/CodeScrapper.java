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
import kay.App;
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
        url  = "https://www.google.com/search?q=";
        //App.Tokenizer.setText(Query);
        QueryWords = App.Tokenizer.tokenize(Query);

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
        try {
            Language = GetLanguage();
            for (String word : QueryWords) {
                url+=word+"+";
            }        
    
            url+="stackoverflow";
            ScrapDataFromGoogle();        
            return "Done";
        } catch (Exception e) {
            return "Error";
        }
       
    }
    public String GetLanguage(){
        String filename = "chatkay\\src\\main\\java\\CodePackage\\DataCode.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                

                if(Query.toLowerCase().contains(line.toLowerCase()))
                return line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Nothing";
    }

    
    private void writeParagraphe(Element paragraph){
        // System.out.println("im  here");
         if(paragraph.is("pre")){
            // System.out.println("\n\n");
             System.out.println("######################### Code Block  #########################");
         }
         for(int i=0; i<paragraph.text().length();i++){
             if(i==500){
                 System.out.println();
                 System.out.println("Chat KAY : do you want the complete answer ? (YES / NO)");
                 Scanner scs = new Scanner(System.in);
                 String Answer = scs.nextLine();
                 //scs.close();
                 if(Answer.toLowerCase().contains("y")){
                     System.out.println();
                     System.out.print(paragraph.text());
                     break;
                 }
 
             }
             System.out.print(paragraph.text().charAt(i));
             try {
                 Thread.sleep(10); 
                 } catch (Exception e) {
                 e.printStackTrace();
                 }
             }
        // System.out.println(paragraph.text());
             if(paragraph.is("pre")){        
                 System.out.println();       
                 System.out.println("###############################################################");
             }
             
             System.out.println();
     }
    

    public void ScrapDataFromGoogle(){
        try {
        // Connect to the google api
            Document document2 = Jsoup.connect(url).get();
           document2.outputSettings().charset("UTF-8");
          // System.out.println(document2.outerHtml());
            
             Elements SpecialInfo = document2.select(".yuRUbf a");
             
              int done = 0;
         
                    if(!SpecialInfo.isEmpty()){
                        for (Element paragraph : SpecialInfo) {
                           if(paragraph.attr("href").contains("stackoverflow")){
                         //   System.out.println(paragraph.attr("href"));
                             String Nexturl = paragraph.attr("href");
                             Document Nextdocument = Jsoup.connect(Nexturl).get();
                             Elements BestAnswer = Nextdocument.select(".s-prose.js-post-body");
                             int BA = 0;
                             
                                
                             for (Element iterable_element : BestAnswer) {
                               
                            if(BA==1){
                                Elements links = iterable_element.select("a");
                                Elements al3kes = iterable_element.select("g-bubble");
                               // Elements CodeBlock = iterable_element.select("pre");
                                
                                for (Element link : links) {
                                    link.remove();
                                   al3kes.remove();
                                  
                               }
                            Elements e = iterable_element.children();
                            for (Element Childs : e) {
                                writeParagraphe(Childs);
                            }
                              
                               done = 1;
                               break;
                               
                            }
                           
                            BA++;
                            
                             }
                            
                             if(done==1)
                             break;
                            //s-prose js-post-body
        
                           }
                                            
                            
                        }
        
        
                    }
                    
                

        } catch (IOException e) {
            System.err.println("Error fetching URL: " + e.getMessage());
        }
    }
  





}

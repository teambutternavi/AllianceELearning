package AES.Model;
// Generated May 21, 2015 1:38:17 PM by Hibernate Tools 4.3.1

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




/**
 * Exam generated by hbm2java
 */
public class Exam  implements java.io.Serializable {


     private Integer id;
     private String title;
     private String description;
     private String filepath;
     private Integer creatorid;
     private Integer score;
     private List<Question> question ;
    public Exam() {
        question = new ArrayList<>();
    }
    
    public Exam(String title, String description, String filepath, Integer creatorid, Integer score) {
       this.title = title;
       this.description = description;
       this.filepath = filepath;
       this.creatorid = creatorid;
       this.score = score;
    }
    public void addQuestion(Question question){
        this.question.add(question);
    }
    public List<Question> getQuestion() {
        return question;
    }
    public String toString(){
        String str = "";
        for(Question q:question){
            str+=q.toString()+"\n";
        }
        return str;
    }
    public void generateXML(String path) throws ParserConfigurationException, TransformerException{
        generateXML(new File(path));
    }
    public void generateXML(File f) throws ParserConfigurationException, TransformerException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("Exam");
        doc.appendChild(root);
        for(Question q:this.question)
            q.addToParentElement(root);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(f);
        transformer.transform(source, result);
    }
    public static Exam generateExam(String path) throws ParserConfigurationException, SAXException, IOException{ return generateExam(new File(path));}
    public static Exam generateExam(File f) throws ParserConfigurationException, SAXException, IOException{
        Exam exam = null;
        if(f.exists()){
            exam = new Exam();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);
            Element root = (Element) doc.getFirstChild();
            NodeList nodes = root.getElementsByTagName("question");
            for(int i=0; i < nodes.getLength();i++){
                //System.out.println(nodes.item(i));
                Element elem = (Element)nodes.item(i);
                Question q = Question.generateQuestion(elem);
                exam.addQuestion(q);
            }
        }
        return exam;
    }
    public static void main(String args[]) throws ParserConfigurationException, TransformerException, SAXException, IOException{
       /*
        Exam ex = new Exam();
        Question q = new Question();
        q.setMessage("Mao ni question");
        q.addPossibleAnswer("1");
        q.addPossibleAnswer("2");
        q.addPossibleAnswer("3");
        q.addCorrecteAnswer("1");
        ex.addQuestion(q);
        q = new Question();
        q.setMessage("Mao ni question 2");
        q.addPossibleAnswer("a");
        q.addPossibleAnswer("b");
        q.addPossibleAnswer("c");
        q.addCorrecteAnswer("a");
        ex.addQuestion(q);
        ex.generateXML("test.xml");
         */       
        Exam ex = Exam.generateExam("test.xml");
        System.out.println(ex.toString());
    }
    
   //// HIBERNATE GENERATED
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFilepath() {
        return this.filepath;
    }
    
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    public Integer getCreatorid() {
        return this.creatorid;
    }
    
    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }
    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
}



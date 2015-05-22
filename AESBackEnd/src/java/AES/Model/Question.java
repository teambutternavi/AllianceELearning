/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Ted Ian Osias
 */
public class Question {
   String message = null;
   List<String> p_answers = null;
   List<String> c_answers = null;
   
   public Question(){
       message = "";
       p_answers = new ArrayList<>();
       c_answers =new ArrayList<>();
   }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setP_answers(List<String> p_answers) {
        this.p_answers = p_answers;
    }

    public void setC_answers(List<String> c_answers) {
        this.c_answers = c_answers;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getP_answers() {
        return p_answers;
    }

    public List<String> getC_answers() {
        return c_answers;
    }

    public void addPossibleAnswer(String answer){
        if(p_answers==null)
            p_answers = new ArrayList<>();
        if(answer!=null)
            p_answers.add(answer);
    }
    public void addCorrecteAnswer(String answer){
        if(answer!=null)
            c_answers.add(answer);
    }

    public void addToParentElement(Element parent) throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
                Document doc = parent.getOwnerDocument();
                Element rootElement = doc.createElement("question");
		parent.appendChild(rootElement);
 
		Element question = doc.createElement("message");
		question.appendChild(doc.createTextNode(getMessage()));
                rootElement.appendChild(question);
                 //answer = null;
                Element possibleAnswers = doc.createElement("p_answers");
                Element answer = null;
                for(String s:p_answers){
                    answer = doc.createElement("answer");
                    answer.appendChild(doc.createTextNode(s));
                    possibleAnswers.appendChild(answer);
                }
                rootElement.appendChild(possibleAnswers);
                
                Element correctAnswers = doc.createElement("c_answers");
                for(String s:c_answers){
                    answer = doc.createElement("answer");
                    answer.appendChild(doc.createTextNode(s));
                    correctAnswers.appendChild(answer);
                }
                rootElement.appendChild(correctAnswers);
    }
    public static void main(String args[])throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("root");
        Element mes = doc.createElement("message");
        mes.appendChild(doc.createTextNode("testing rani"));
        root.appendChild(mes);
        
        Element p_answer = doc.createElement("p_answers");
        Element answer = doc.createElement("answer");
        answer.appendChild(doc.createTextNode("1"));
        p_answer.appendChild(answer);
        
        Element c_answer = doc.createElement("p_answers");
        answer = doc.createElement("answer");
        answer.appendChild(doc.createTextNode("2"));
        c_answer.appendChild(answer);
        
        root.appendChild(p_answer);
        root.appendChild(c_answer);
        doc.appendChild(root);
        Question q = Question.generateQuestion(root);
        
    }
    public static Question genereateQuestion(Document doc){
        return generateQuestion(doc.getDocumentElement());
    }
    public static Question generateQuestion(Element elem){
        Question question = null;
        if(elem!=null){
            question = new Question();
            List<Element> elems = XMLOperations.removeNodesWithoutText(elem.getChildNodes());
            Element mes = elems.get(0);
            List<Element> p_answers = XMLOperations.removeNodesWithoutText(elems.get(1).getChildNodes());
            List<Element> c_answers = XMLOperations.removeNodesWithoutText(elems.get(2).getChildNodes());
            if(mes!=null)
                question.setMessage(((Text)mes.getFirstChild()).getWholeText());
            for(Element element:p_answers ){
                String answer = ((Text)element.getFirstChild()).getWholeText();
                question.addPossibleAnswer(answer);
            }
            for(Element element:c_answers ){
                String answer = ((Text)element.getFirstChild()).getWholeText();
                question.addCorrecteAnswer(answer);
            }
            
        }
        return question;
    }
    @Override
    public String toString(){
        String str = getMessage();
        str+="\nChoices:\n";
        for(String s:this.p_answers)
            str+= s +"\n";
        str+="\nCorrect answer/s:\n";
        for(String s:this.c_answers)
            str+= s +"\n";
        return str;
    }
}

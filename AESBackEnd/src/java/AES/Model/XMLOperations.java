/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Model;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ted Ian Osias
 */
public class XMLOperations {
    public static List<Element> removeNodesWithoutText(NodeList nodelist){
        List<Element> elems = new ArrayList<>();
        for(int i=0;i<nodelist.getLength();i++){
            try{
            Element node = (Element)nodelist.item(i);
            if(node.getTagName().length()>0)
                elems.add(node);
            }catch(Exception e){
                
            }
            
        }
        return elems;
    }
}

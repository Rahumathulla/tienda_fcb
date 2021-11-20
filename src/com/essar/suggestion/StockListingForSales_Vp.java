/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.suggestion;
import com.essar.dao.StockDAO;
import com.essar.dao.VpStockDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author rahumathulla
 */


public class StockListingForSales_Vp {
    
   // public static void main(String[] args) {
    VpStockDAO stockDAO = null;
    public StockListingForSales_Vp(){
          stockDAO = new VpStockDAO();
    }

    public static void populateItemNames(JFrame frame, JTextField textField) {
        //JFrame frame = createFrame();
        //JTextField textField = new JTextField(10);
        SuggestionDropDownDecorator.decorate(textField,
                new TextComponentSuggestionClient(StockListingForSales_Vp::getSuggestions));
        /*Font font = new Font(Font.SANS_SERIF, 2, 2);
        JTextPane textPane = new JTextPane();
        JScrollPane jsp = new JScrollPane(textPane);
        textPane.setFont(font);
        frame.add(new JScrollPane(textPane));*/
        
        //frame.add(jsp);
        frame.setVisible(true);
        
        
        //SuggestionDropDownDecorator.decorate(textPane,
        //new TextComponentWordSuggestionClient(SuggestionExampleMain::getSuggestions));
        //frame.add(textField, BorderLayout.NORTH);
        //frame.add(new JScrollPane(textPane));
        //frame.setVisible(true);
    }
    
    private static List<String> words = StockDAO.retrieveItemNames();
    
            //RandomUtil.getWords(2, 400).stream().map(String::toLowerCase).collect(Collectors.toList());
    
    

    private static List<String> getSuggestions(String input) {
        //the suggestion provider can control text search related stuff, e.g case insensitive match, the search  limit etc.
        if (input.isEmpty()) {
            return null;
        }
        return words.stream()
                    .filter(s -> s.toLowerCase().contains(input.toLowerCase()))
                    .limit(20)
                    .collect(Collectors.toList());
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("Suggestion Dropdown Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
}

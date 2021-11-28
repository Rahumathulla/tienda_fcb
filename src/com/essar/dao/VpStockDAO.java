/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.dao;

import com.essar.utils.ConnectionManager;
import com.essar.pojos.ProductCategory;
import com.essar.pojos.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahumathulla
 */
public class VpStockDAO {
    
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    ResultSet rs = null;
    String sql = null;
    //List<ProductCategory>  productCategoryList= null;
        
    public List<Stock> retrieveAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Stock>  stockList= null;
        try {
            sql = "SELECT * from stock_vp";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Stock stock = null;
            stockList = new ArrayList<Stock>();
            while(rs.next()){
                stock = new Stock();
                stock.setItemId(rs.getLong(1));
                stock.setHsnCode(rs.getString(2));
                stock.setItemName(rs.getString(3));
                stock.setCategory(rs.getString(4));
                stock.setSupplier(rs.getString(5));
                stock.setDescription(rs.getString(6));
                stock.setPurchasePrice(rs.getDouble(7));
                stock.setGstPercentage(rs.getDouble(8));
                stock.setGstAmount(rs.getDouble(9));
                stock.setMargin(rs.getDouble(10));
                stock.setSellingPrice(rs.getDouble(11));
                stock.setQuantity(rs.getDouble(12));
                stock.setReOrderQuantity(rs.getDouble(13));
                //Adding to List
                stockList.add(stock);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stockList;
    }
    
    public static List<String> retrieveItemNames() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<String>  itemList= null;
        try {
            String sql = "SELECT item_name from stock_vp";
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            ResultSet rs = null;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            itemList = new ArrayList<String>();
            while(rs.next()){
                //Adding to List
                itemList.add(rs.getString(1));                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemList;
    }

    public List<Object> retrieveByQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Stock retrieveByName(String name) {
        //List<String>  itemList= null;
        Stock stock = null;
        try {
            String sql = "SELECT * from stock_vp where item_name = '"+name+"'";
            System.out.println("Query--"+sql);
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            ResultSet rs = null;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            stock = new Stock();
            while(rs.next()){
                //Adding to List
                //itemList.add(rs.getString(1));
                stock.setItemId(rs.getInt("item_id"));
                stock.setHsnCode(rs.getString("hsn_code"));                
                stock.setItemName(rs.getString("item_name"));
                stock.setCategory(rs.getString("category"));
                stock.setSupplier(rs.getString("supplier"));
                stock.setDescription(rs.getString("description"));
                stock.setPurchasePrice(rs.getDouble("purchase_price"));
                stock.setGstPercentage(rs.getDouble("gst_percentage"));
                stock.setGstAmount(rs.getDouble("gst_amount"));
                stock.setMargin(rs.getDouble("margin"));
                stock.setDiscount(rs.getDouble("discount"));
                stock.setSellingPrice(rs.getDouble("selling_price"));
                stock.setQuantity(rs.getDouble("quantity"));
                stock.setReOrderQuantity(rs.getDouble("reorder_quantity"));              
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stock;
    }
    
    public Stock retrieveById(long stockId) {
        //List<String>  itemList= null;
        Stock stock = null;
        try {
            String sql = "SELECT * from stock_vp where item_id = "+stockId;
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            ResultSet rs = null;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            stock = new Stock();
            while(rs.next()){
                //Adding to List
                //itemList.add(rs.getString(1));
                stock.setItemId(rs.getInt("item_id"));
                stock.setHsnCode(rs.getString("hsn_code"));                
                stock.setItemName(rs.getString("item_name"));
                stock.setCategory(rs.getString("category"));
                stock.setSupplier(rs.getString("supplier"));
                stock.setDescription(rs.getString("description"));
                stock.setPurchasePrice(rs.getDouble("purchase_price"));
                stock.setGstPercentage(rs.getDouble("gst_percentage"));
                stock.setGstAmount(rs.getDouble("gst_amount"));
                stock.setMargin(rs.getDouble("margin"));
                stock.setDiscount(rs.getDouble("discount"));
                stock.setSellingPrice(rs.getDouble("selling_price"));
                stock.setQuantity(rs.getDouble("quantity"));
                stock.setReOrderQuantity(rs.getDouble("reorder_quantity"));              
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stock;
    }
    
    public List<Double> retrieveAuditSummary(long stockId, String stockName) {
        //List<String>  itemList= null;
        List<Double> summaryList = new ArrayList<Double>();
        try {
            String sql = "SELECT 1, CASE WHEN stock_entry_quantity IS NULL THEN 0 ELSE stock_entry_quantity  END AS direct_entry"
                                + " FROM stock_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'"
                        +" UNION" 
                        +" SELECT 2, CASE WHEN SUM(quantity) IS NULL THEN 0 ELSE SUM(quantity) END AS purchased_quantity "
                                + " FROM purchase_details_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'"
                        +" UNION" 
                        +" SELECT 3, CASE WHEN SUM(quantity) IS NULL THEN 0 ELSE SUM(quantity) END AS sold_quantity "
                                + " FROM sales_details_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'"
                        +" UNION"
                        +" SELECT 4, CASE WHEN quantity IS NULL THEN 0 ELSE quantity  END AS closing_stock"
                                + " FROM stock_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'";
                    
            System.out.println("QUERY :: "+sql);            
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            ResultSet rs = null;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            //stock = new Stock();
            while(rs.next()){
                //Adding to List
                //itemList.add(rs.getString(1));
                //System.out.println("---"+rs.);
                System.out.println("Inside ResultSet"+rs.getDouble(1));
                summaryList.add(rs.getDouble(2));
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return summaryList;
    }
    
    
    public List<Double> retrieveStockStatus(String fromDate) {
        //List<String>  itemList= null;
        long stockId =0; 
        String stockName ="";
        List<Double> statusList = new ArrayList<Double>();
        try {
            String sql = "SELECT 1, CASE WHEN stock_entry_quantity IS NULL THEN 0 ELSE stock_entry_quantity  END AS direct_entry"
                                + " FROM stock_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'"
                        +" UNION" 
                        +" SELECT 2, CASE WHEN SUM(quantity) IS NULL THEN 0 ELSE SUM(quantity) END AS purchased_quantity "
                                + " FROM purchase_details_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'"
                        +" UNION" 
                        +" SELECT 3, CASE WHEN SUM(quantity) IS NULL THEN 0 ELSE SUM(quantity) END AS sold_quantity "
                                + " FROM sales_details_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'"
                        +" UNION"
                        +" SELECT 4, CASE WHEN quantity IS NULL THEN 0 ELSE quantity  END AS closing_stock"
                                + " FROM stock_vp WHERE item_id = "+stockId+ " OR item_name = '"+stockName+"'";
                    
            System.out.println("QUERY :: "+sql);            
            ConnectionManager cm = new ConnectionManager();
            Connection con = cm.getConnection();
            ResultSet rs = null;
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            //stock = new Stock();
            while(rs.next()){
                //Adding to List
                //itemList.add(rs.getString(1));
                //System.out.println("---"+rs.);
                System.out.println("Inside ResultSet"+rs.getDouble(1));
                //statusList.add(rs.getLong(1));
                statusList.add(rs.getDouble(2));
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return statusList;
    }
        
    public List<Stock> retrieveStocksByQuery(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Stock>  stockList= null;
        try {
            sql = query;
            //"SELECT * from stock where quantity <= reorder_quantity";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            Stock stock = null;
            stockList = new ArrayList<Stock>();
            while(rs.next()){
                stock = new Stock();
                stock.setItemId(rs.getInt("item_id"));
                stock.setHsnCode(rs.getString("hsn_code"));                
                stock.setItemName(rs.getString("item_name"));
                stock.setCategory(rs.getString("category"));
                stock.setSupplier(rs.getString("supplier"));
                stock.setDescription(rs.getString("description"));
                stock.setPurchasePrice(rs.getDouble("purchase_price"));
                stock.setGstPercentage(rs.getDouble("gst_percentage"));
                stock.setGstAmount(rs.getDouble("gst_amount"));
                stock.setMargin(rs.getDouble("margin"));
                //stock.setDiscount(rs.getDouble("discount"));
                stock.setSellingPrice(rs.getDouble("selling_price"));
                stock.setQuantity(rs.getDouble("quantity"));
                stock.setReOrderQuantity(rs.getDouble("reorder_quantity")); 
                //Adding to List
                stockList.add(stock);                        
                
            }
            con.close();
            //System.out.println("</TABLE></BODY></HTML>"+productCategoryList.size());
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stockList;
    }

    public void insertIntoDB(Stock stock) {
        try {            
            String sql = "INSERT INTO stock_vp (hsn_code, item_name, category , supplier , description"
                    + ", purchase_price, gst_percentage, gst_amount, margin, selling_price, quantity, reorder_quantity, stock_entry_quantity )  values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stock.getHsnCode());
            ps.setString(2, stock.getItemName());
            ps.setString(3, stock.getCategory());
            ps.setString(4, stock.getSupplier());
            ps.setString(5, stock.getDescription());
            ps.setDouble(6, stock.getPurchasePrice());
            ps.setDouble(7, stock.getGstPercentage());
            ps.setDouble(8, stock.getGstAmount());
            ps.setDouble(9, stock.getMargin());
            ps.setDouble(10, stock.getSellingPrice());
            ps.setDouble(11, stock.getQuantity());
            ps.setDouble(12, stock.getReOrderQuantity());
            ps.setDouble(13, stock.getQuantity());
            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStock(Stock stock) {
        try {            
            String sql = "UPDATE stock_vp set hsn_code=?, item_name= ?, category =?, supplier =?"
                    + ", description =?, purchase_price=?, gst_percentage=?, gst_amount=?"
                    + ", margin=?, selling_price=?, quantity=?, reorder_quantity=? "
                    + " WHERE item_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stock.getHsnCode());
            ps.setString(2, stock.getItemName());
            ps.setString(3, stock.getCategory());
            ps.setString(4, stock.getSupplier());
            ps.setString(5, stock.getDescription());
            ps.setDouble(6, stock.getPurchasePrice());
            ps.setDouble(7, stock.getGstPercentage());
            ps.setDouble(8, stock.getGstAmount());
            ps.setDouble(9, stock.getMargin());
            ps.setDouble(10, stock.getSellingPrice());
            ps.setDouble(11, stock.getQuantity());
            ps.setDouble(12, stock.getReOrderQuantity());
            ps.setDouble(13, stock.getItemId());

            ps.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStockById(long id) {
        try {            
            String sql = "DELETE FROM stock_vp WHERE item_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            System.out.println("--"+ps.toString());
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteRecordByCode(String code) {
        try {            
            String sql = "DELETE FROM stock_vp WHERE hsn_code = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, code);
            ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRecord(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.SalesDAO;
import com.essar.dao.StockDAO;
import com.essar.pojos.Sales;
import com.essar.utils.TableMouseListener;
import com.essar.pojos.Stock;
import com.essar.utils.GenericUtils;
import com.essar.utils.QueryStrings;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author rahumathulla
 */
public class Vp_ViewStockAlerts extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ProductCategory
     */
    long itemId=0;
    DefaultTableModel stockModel = null;
    DecimalFormat df = new DecimalFormat("##,##,###.##");
    public Vp_ViewStockAlerts() {        
        initComponents();
        initializeForm();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tienda.png")));
        //this.setBounds(10, 10, 1040, 800);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        mnuTable = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mitDelete = new javax.swing.JMenuItem();
        mitView = new javax.swing.JMenuItem();
        panStockAlertView = new javax.swing.JScrollPane();
        tblStockAlertView = new javax.swing.JTable();
        lblTotalCount = new javax.swing.JLabel();
        lblTotalValue = new javax.swing.JLabel();
        lblTotalSalesValue = new javax.swing.JLabel();
        lblPredictedProfit = new javax.swing.JLabel();
        lblTotalSkipped = new javax.swing.JLabel();
        cmdCancel = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        mitDelete.setText("jMenuItem1");

        mitView.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock Report");
        setName("frmProductCategory"); // NOI18N

        panStockAlertView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panStockAlertViewMouseClicked(evt);
            }
        });

        tblStockAlertView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HSN Code", "Item Name", "Category", "Supplier", "Purchase Price", "GST %", "Margin", "Qty", "ROLevel", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panStockAlertView.setViewportView(tblStockAlertView);

        lblTotalCount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotalCount.setForeground(new java.awt.Color(255, 153, 0));
        lblTotalCount.setText("Total Count : ");

        lblTotalValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalValue.setForeground(new java.awt.Color(0, 153, 255));
        lblTotalValue.setText("Total Stock Value : ");

        lblTotalSalesValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalSalesValue.setForeground(new java.awt.Color(153, 153, 0));
        lblTotalSalesValue.setText("Total Sales Value : ");

        lblPredictedProfit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPredictedProfit.setForeground(new java.awt.Color(51, 204, 0));
        lblPredictedProfit.setText("Predicted Profit : ");

        lblTotalSkipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotalSkipped.setForeground(new java.awt.Color(255, 0, 204));

        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panStockAlertView)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblTotalCount, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalSkipped, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPredictedProfit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalSalesValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addGap(653, 653, 653)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panStockAlertView, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotalCount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalSkipped, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalSalesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPredictedProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panStockAlertViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panStockAlertViewMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                                Sales sales = null;
                itemId = Integer.parseInt(tblStockAlertView.getModel().getValueAt(tblStockAlertView.getSelectedRow(),10).toString());
                SalesDAO salesDAO = new SalesDAO();
                sales = salesDAO.retrieveByBillNumber(itemId+"");
                
                SalesWindow salesWindow = new SalesWindow();
                //salesWindow.fetchSalesDataIntoTable(salesDAO.retrieveByBillNumber(itemId));
                salesWindow.repaint();
                salesWindow.setVisible(true);
                salesWindow.fetchSalesDataIntoTable(sales);
                this.dispose();
                
     //handle double click event.
            }
    }//GEN-LAST:event_panStockAlertViewMouseClicked

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        /*SalesWindow salesWindow = new SalesWindow();
        salesWindow.setBounds(100, 100, 960, 590);
        salesWindow.setVisible(true);*/
    }//GEN-LAST:event_cmdCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vp_ViewStockAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vp_ViewStockAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vp_ViewStockAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vp_ViewStockAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vp_ViewStockAlerts().setVisible(true);
            }
        });
    }
    

    public void initializeForm(){

        StockDAO stockDAO = new StockDAO();
        renderDataIntoTable(stockDAO.retrieveStocksByQuery(QueryStrings.stockQuery));
        mnuTable = new JPopupMenu();
        mitDelete = new JMenuItem("Delete");
        mitDelete.addActionListener(this);
        
        mitView = new JMenuItem("View");
        mitView.addActionListener(this);
        
        mnuTable.add(mitDelete);
        mnuTable.add(mitView);
         // sets the popup menu for the table
        tblStockAlertView.setComponentPopupMenu(mnuTable);      
        tblStockAlertView.addMouseListener(new TableMouseListener(tblStockAlertView));
        /*tblStockAlertView.setBounds(20,20,1020, 740);
        panStockAlertView.setBounds(20,20,1020, 740);
        pnlSalesView.setBounds(20,20,1020, 740);*/
   
    }
    

    public void renderDataIntoTable(List<Stock> stockList){
        
        stockModel = (DefaultTableModel) tblStockAlertView.getModel();
        //!@--17/03/2020 Setting id column width to 0;
        TableColumn idColumn1 = tblStockAlertView.getColumnModel().getColumn(tblStockAlertView.getColumnCount()-1);
        idColumn1.setPreferredWidth(0);
        idColumn1.setMinWidth(0);
        idColumn1.setMaxWidth(0);
        //idColumn1.
        double dStockValue=0;
        double dSalesValue=0;
        double dProfitPrediction=0;
        int iSkipped =0;
        for(int i=0;i<stockList.size();i++){
            stockModel.addRow(new Object[]{stockList.get(i).getHsnCode(),stockList.get(i).getItemName(),stockList.get(i).getCategory(),stockList.get(i).getSupplier(),stockList.get(i).getPurchasePrice(),stockList.get(i).getGstPercentage(), stockList.get(i).getMargin(), stockList.get(i).getQuantity(),stockList.get(i).getReOrderQuantity(), stockList.get(i).getItemId()});
            if(stockList.get(i).getQuantity()>0){
                dStockValue += stockList.get(i).getPurchasePrice()*stockList.get(i).getQuantity();
                dSalesValue += stockList.get(i).getSellingPrice()*stockList.get(i).getQuantity();
            }else{
                iSkipped++;
            }
            
        }
        dProfitPrediction = dSalesValue - dStockValue;
        if(dProfitPrediction < 0)
            lblPredictedProfit.setForeground(Color.red);
        lblTotalSalesValue.setText("Total Sales Value : "+df.format(dSalesValue));
        lblTotalValue.setText("Total Stock Value : "+df.format(dStockValue));
        lblPredictedProfit.setText("Predicted Profit  : "+df.format(dProfitPrediction));
        lblTotalCount.setText("Total Count : "+stockList.size());
        if(iSkipped>0){
            lblTotalSkipped.setText("Skip Count : "+iSkipped);
        }
        TableColumn nameColumn = tblStockAlertView.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(240);
        
        tblStockAlertView.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events              
                    syncDataFromViewToTable();
                }
            }
        });
        
    }
    
    public void syncDataFromViewToTable(){
        //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
        Stock stock = null;
        StockDAO stockDAO = new StockDAO();
        itemId = Integer.parseInt(tblStockAlertView.getModel().getValueAt(tblStockAlertView.getSelectedRow(),tblStockAlertView.getColumnCount()-1).toString());
        //SalesDAO salesDAO = new SalesDAO();
        System.out.println("Id---"+itemId);
        stock = stockDAO.retrieveById(itemId);

        StockEntry stockEntry = new StockEntry();
        stockEntry.setBounds(100, 100, 800, 500);
        stockEntry.fetchStockDataIntoTable(stock);
        stockEntry.repaint();
        stockEntry.setVisible(true);
        //stockEntry.(sales);
        this.dispose();
    }               
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblPredictedProfit;
    private javax.swing.JLabel lblTotalCount;
    private javax.swing.JLabel lblTotalSalesValue;
    private javax.swing.JLabel lblTotalSkipped;
    private javax.swing.JLabel lblTotalValue;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitView;
    private javax.swing.JPopupMenu mnuTable;
    private javax.swing.JScrollPane panStockAlertView;
    private javax.swing.JTable tblStockAlertView;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == mitDelete) {
                Stock stock = null;
                //StockDAO stockDAO = new StockDAO();
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                long id = Long.parseLong(tblStockAlertView.getModel().getValueAt(tblStockAlertView.getSelectedRow(),tblStockAlertView.getColumnCount()-1).toString());
                StockDAO stockDAO = new StockDAO();
                stockDAO.deleteStockById(id);
                GenericUtils.removeRowFromJTable(tblStockAlertView, stockModel);
                
                //tblGst.getModel().removeRow(tblGst.getSelectedRow());
                //tblGst.remove(3);
                //tblGst.revalidate();
                //tblGst.repaint();
                // Bug Fix for row doubling during table record deletion
                /*this.dispose();
                GSTForm gSTForm = new GSTForm();
                gSTForm.setVisible(true);*/
                
                //initializeForm();
                
                
            }
            
            if (menu == mitView) {
                    syncDataFromViewToTable();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}

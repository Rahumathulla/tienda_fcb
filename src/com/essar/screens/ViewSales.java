/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.GstDAO;
import com.essar.dao.SalesDAO;
import com.essar.pojos.GST;
import com.essar.pojos.Sales;
import com.essar.pojos.SalesDetails;
import com.essar.utils.TableMouseListener;
import com.essar.pojos.SalesView;
import com.essar.utils.GenericUtils;
import com.essar.utils.QueryStrings;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author rahumathulla
 */
public class ViewSales extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ProductCategory
     */
    String salesId="";
    double dPaidAmount=0;
    double dCreditAmount=0;
    DecimalFormat df = new DecimalFormat("##,##,###.##");
  
    DefaultTableModel salesModel = null;
    public ViewSales() {
        initComponents();
        initializeForm();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tienda.png")));
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
        pnlSalesView = new javax.swing.JPanel();
        panSalesView = new javax.swing.JScrollPane();
        tblSalesView = new javax.swing.JTable();
        cmdCancel = new javax.swing.JButton();
        lblTotalSales = new javax.swing.JLabel();
        lblByCash = new javax.swing.JLabel();
        lblByCredit = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();

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
        setTitle("Sales View");
        setExtendedState(6);
        setName("frmProductCategory"); // NOI18N

        javax.swing.GroupLayout pnlSalesViewLayout = new javax.swing.GroupLayout(pnlSalesView);
        pnlSalesView.setLayout(pnlSalesViewLayout);
        pnlSalesViewLayout.setHorizontalGroup(
            pnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        pnlSalesViewLayout.setVerticalGroup(
            pnlSalesViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panSalesView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panSalesViewMouseClicked(evt);
            }
        });
        panSalesView.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panSalesViewKeyPressed(evt);
            }
        });

        tblSalesView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Bill Number", "Total Qty", "Bill Amount", "Cess", "Discount", "Net Amount", "Sales Date", " Status", "Sales Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSalesView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSalesViewMouseClicked(evt);
            }
        });
        tblSalesView.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblSalesViewKeyPressed(evt);
            }
        });
        panSalesView.setViewportView(tblSalesView);

        cmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        lblTotalSales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalSales.setForeground(new java.awt.Color(153, 0, 102));
        lblTotalSales.setText("Total Sales");

        lblByCash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblByCash.setForeground(new java.awt.Color(0, 153, 0));
        lblByCash.setText("By Cash");

        lblByCredit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblByCredit.setForeground(new java.awt.Color(204, 0, 0));
        lblByCredit.setText("By Credit");

        lblCount.setForeground(new java.awt.Color(102, 102, 255));
        lblCount.setText("Count:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panSalesView)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pnlSalesView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalSales, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblByCash, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(lblByCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panSalesView, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlSalesView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblByCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblByCash, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panSalesViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panSalesViewMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                syncDataFromViewToTable();

            }
    }//GEN-LAST:event_panSalesViewMouseClicked

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        /*SalesWindow salesWindow = new SalesWindow();
        salesWindow.setBounds(100, 20, 960, 640);
        salesWindow.setVisible(true);*/
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void tblSalesViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSalesViewMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && tblSalesView.getSelectedRow() != -1){
            
        }
    }//GEN-LAST:event_tblSalesViewMouseClicked

    private void panSalesViewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panSalesViewKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_panSalesViewKeyPressed

    private void tblSalesViewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSalesViewKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_HOME && tblSalesView.getRowCount()>0){
            mnuTable.removeAll();
            //Add Existing
            mitView = new JMenuItem("View");
            mitView.addActionListener(this); 
            mnuTable.add(mitView);
            //Add New
            mitDelete = new JMenuItem("Delete");
            mitDelete.addActionListener(this); 
            mnuTable.add(mitDelete);
             
        }
    }//GEN-LAST:event_tblSalesViewKeyPressed

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
            java.util.logging.Logger.getLogger(ViewSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSales().setVisible(true);
            }
        });
    }
    

    public void initializeForm(){

        SalesDAO salesDAO = new SalesDAO();
        renderDataIntoTable(salesDAO.retrieveSalesByQuery(QueryStrings.viewSalesSql));
        mnuTable = new JPopupMenu();
        /*mitDelete = new JMenuItem("Delete");
        mitDelete.addActionListener(this);*/
        
        mitView = new JMenuItem("View");
        mitView.addActionListener(this);
        
        //mnuTable.add(mitDelete);
        mnuTable.add(mitView);
         // sets the popup menu for the table
        tblSalesView.setComponentPopupMenu(mnuTable);      
        tblSalesView.addMouseListener(new TableMouseListener(tblSalesView));
        

        TableColumn nameColumn = tblSalesView.getColumnModel().getColumn(0);
        nameColumn.setPreferredWidth(360);
        nameColumn.setMinWidth(360);
        
        TableColumn salesIdColumn = tblSalesView.getColumnModel().getColumn(tblSalesView.getColumnCount()-1);
        salesIdColumn.setPreferredWidth(0);
        salesIdColumn.setMinWidth(0);
        salesIdColumn.setMaxWidth(0);

   
    }

    public void renderDataIntoTable(List<SalesView> salesViewList){
        dPaidAmount=0;
        dCreditAmount=0;
        salesModel = (DefaultTableModel) tblSalesView.getModel();
        for(int i=0;i<salesViewList.size();i++){
            //salesModel.addRow(new Object[]{salesViewList.get(i).getCustomerName(), salesViewList.get(i).getBillNumber(),salesViewList.get(i).getBillAmount(),salesViewList.get(i).getCess(),salesViewList.get(i).getDiscount(), salesViewList.get(i).getPayableAmount(), salesViewList.get(i).getSalesDate(), salesViewList.get(i).getStatus()});
            salesModel.addRow(new Object[]{salesViewList.get(i).getCustomerName(), salesViewList.get(i).getBillNumber(),salesViewList.get(i).getQuantity(),salesViewList.get(i).getBillAmount(),salesViewList.get(i).getCess(),salesViewList.get(i).getDiscount(), salesViewList.get(i).getPayableAmount(), salesViewList.get(i).getSalesDate(), salesViewList.get(i).getStatus(), salesViewList.get(i).getSalesId()});
            if(salesViewList.get(i).getStatus().equalsIgnoreCase("credit"))
                dCreditAmount += salesViewList.get(i).getBillAmount();
            else
                dPaidAmount += salesViewList.get(i).getBillAmount();
        }        
        lblTotalSales.setText("Total Sales : "+df.format(dPaidAmount+dCreditAmount));
        lblByCash.setText("By Cash : "+df.format(dPaidAmount));        
        lblByCredit.setText("By Credit : "+df.format(dCreditAmount));
        lblCount.setText("Count : "+salesViewList.size());
        
        tblSalesView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable)me.getSource();
                int row = target.getSelectedRow(); // select a row
                int column = target.getSelectedColumn(); // select a column
                //JOptionPane.showMessageDialog(null, tblSalesView.getValueAt(row, column)); // get the value of a row and column.
                    syncDataFromViewToTable();
                }
            }
        });
    }
    
    public void syncDataFromViewToTable(){
        Sales sales = null;
        salesId = tblSalesView.getModel().getValueAt(tblSalesView.getSelectedRow(),tblSalesView.getColumnCount()-1).toString();
        SalesDAO salesDAO = new SalesDAO();
        sales = salesDAO.retrieveBySalesId(Long.parseLong(salesId));
        
        

        SalesWindow salesWindow = new SalesWindow();
        //salesWindow.fetchSalesDataIntoTable(salesDAO.retrieveByBillNumber(salesBillNumber));
        salesWindow.repaint();
        salesWindow.setBounds(100, 20, 980, 680);
        salesWindow.setVisible(true); 
        salesWindow.fetchSalesDataIntoTable(sales);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblByCash;
    private javax.swing.JLabel lblByCredit;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblTotalSales;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitView;
    private javax.swing.JPopupMenu mnuTable;
    private javax.swing.JScrollPane panSalesView;
    private javax.swing.JPanel pnlSalesView;
    private javax.swing.JTable tblSalesView;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == mitDelete) {
                Sales sales = new Sales();
                List<SalesDetails> salesDetailsList = null;
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                //String billNumber = tblSalesView.getModel().getValueAt(tblSalesView.getSelectedRow(),tblSalesView.getColumnCount()-1).toString();
                String salesId = tblSalesView.getModel().getValueAt(tblSalesView.getSelectedRow(),tblSalesView.getColumnCount()-1).toString();
                SalesDAO salesDAO = new SalesDAO();
                //salesDAO.deleteSalesByBillNumber(billNumber);
                //sales =  salesDAO.retrieveBySalesId(Long.parseLong(salesId));
                sales =  salesDAO.retrieveBySalesId(Long.parseLong(salesId));
                salesDetailsList = sales.getSalesDetails();
                if(salesDetailsList.size()<1)
                    JOptionPane.showMessageDialog(this, "No Sales Record Found..!");
                else{
                    System.out.println("SALES ID-"+salesId);                    
                    salesDAO.updateStockAfterBillDeletion(sales, salesDetailsList, true);
                    salesDAO = new SalesDAO();//for re-instating the session
                    salesDAO.deleteSalesBySalesId(Long.parseLong(salesId));
                    GenericUtils.removeRowFromJTable(tblSalesView, salesModel);
                }
 
            }
            
            if (menu == mitView) {
                syncDataFromViewToTable();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}

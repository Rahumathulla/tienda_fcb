/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.SupplierDAO;
import com.essar.pojos.Customer;
import com.essar.pojos.Supplier;
import com.essar.utils.ConnectionManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author rahumathulla
 */
public class Vp_PurchaseSummarySelection extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Stock
     */
    long stockIdEdit=0;
    boolean customerSelected = false;
    Customer customer =null;
    DecimalFormat df = new DecimalFormat("####.##");
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Vp_PurchaseSummarySelection() {
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

        grpBillType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlStockEntry = new javax.swing.JPanel();
        lblBillNumber = new javax.swing.JLabel();
        txtBillNumber = new javax.swing.JTextField();
        lblDateRange = new javax.swing.JLabel();
        lblPaymentType = new javax.swing.JLabel();
        dtpFromDate = new com.toedter.calendar.JDateChooser();
        dtpToDate = new com.toedter.calendar.JDateChooser();
        cmbPaymentType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("[Purchase Summary Report]");

        pnlStockEntry.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Options"));

        lblBillNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBillNumber.setText("Invoice Number");

        txtBillNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBillNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillNumberActionPerformed(evt);
            }
        });
        txtBillNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBillNumberKeyPressed(evt);
            }
        });

        lblDateRange.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDateRange.setText("Date Range (From)");

        lblPaymentType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPaymentType.setText("Payment Type");

        dtpFromDate.setDateFormatString("dd/MM/yyyy");

        dtpToDate.setDateFormatString("dd/MM/yyyy");

        cmbPaymentType.setMaximumRowCount(4);
        cmbPaymentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Cash", "Credit" }));
        cmbPaymentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentTypeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("To");

        javax.swing.GroupLayout pnlStockEntryLayout = new javax.swing.GroupLayout(pnlStockEntry);
        pnlStockEntry.setLayout(pnlStockEntryLayout);
        pnlStockEntryLayout.setHorizontalGroup(
            pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addComponent(lblBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addComponent(lblPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cmbPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addComponent(lblDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(dtpFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(dtpToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlStockEntryLayout.setVerticalGroup(
            pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cmbPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnSearch.setMnemonic('P');
        btnSearch.setText("Print");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStockEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(10, 10, 10)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlStockEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String fromDate = simpleDateFormat.format(dtpFromDate.getDate());
        String toDate = simpleDateFormat.format(dtpToDate.getDate());
        String selectClause = "";
        String reportString = "";
        
        //selectClause = "SELECT * FROM purchase WHERE 1=1 ";
        selectClause =  "SELECT d.purchase_id as p_id"
            + ", sup.supplier_name as sup_name"
            + ", p.bill_number as inv_number"
            + ", SUM(d.quantity) as purch_qty"
            + ", p.bill_amount as bill_amount"
            + ", p.discount as discount"
            + ", p.payable_amount as payable_amount"
            + ", p.purchase_date as purchase_date"
            + ", p.status as status"
            + " from purchase_vp p JOIN supplier sup ON p.supplier_id = sup.supplier_id"
            + " JOIN purchase_details_vp d ON p.purchase_id = d.purchase_id WHERE 1=1 ";
            
        reportString="src\\com\\essar\\reports\\purchase_report_vp.jrxml";
        
        
        if(null!= txtBillNumber.getText() && !("".equals(txtBillNumber.getText()))) { 
            selectClause = selectClause + " AND p.bill_number ='"+txtBillNumber.getText()+"' ";
            
        }else if(cmbPaymentType.getSelectedIndex()!=0){
            if(cmbPaymentType.getSelectedIndex()==1){
                    selectClause = selectClause + " AND p.status = 'Paid' ";
            }
            else if(cmbPaymentType.getSelectedIndex()==2){
                   selectClause = selectClause + " AND p.status = 'Credit' ";
            }

        }
        else{
            if(!(fromDate.equals(toDate))){
            selectClause = selectClause + " AND p.purchase_date BETWEEN "
                    + "'"+fromDate +" 00:00:00' AND '"+toDate+ " 23:59:59'" ;
            }
        }
        selectClause = selectClause + " group by d.purchase_id order by p.purchase_date"; 
        
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();

        //String reportString="src\\com\\essar\\reports\\gst.jrxml";
        JasperReport jr = null;
        HashMap map = new HashMap();
        map.put("query_param",selectClause);
        try {
            jr = JasperCompileManager.compileReport(reportString);
        } catch (JRException ex) {
            Logger.getLogger(Vp_PurchaseSummarySelection.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(jr, map,con);

            con.close();
        } catch (JRException ex) {
            Logger.getLogger(StockEntry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vp_PurchaseSummarySelection.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JasperViewer.viewReport(jp);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt){
                //JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Closed","Why?", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Jasper Window has been closed");
            }
        });
        jv.setVisible(true);
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtBillNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillNumberKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB || evt.getKeyCode() == KeyEvent.VK_ENTER){
            //txtItemName.requestFocus();
        }
    }//GEN-LAST:event_txtBillNumberKeyPressed

    private void txtBillNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillNumberActionPerformed

    private void cmbPaymentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaymentTypeActionPerformed

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
            java.util.logging.Logger.getLogger(Vp_PurchaseSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vp_PurchaseSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vp_PurchaseSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vp_PurchaseSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Vp_PurchaseSummarySelection().setVisible(true);
            }
        });
    }
    
    public void initializeForm(){
        stockIdEdit =0;
        txtBillNumber.requestFocus();
        if(null==dtpFromDate.getDate()){
            //dtpFromDate.setDate(new Date());
            Calendar cal = Calendar.getInstance();
            System.out.println("Today : " + cal.getTime());
            cal.add(Calendar.DATE, -30);           
            System.out.println("30 days ago: " + cal.getTime());
            dtpFromDate.setDate(cal.getTime());
        }        
        if(null==dtpToDate.getDate()){
            dtpToDate.setDate(new Date());
        }
        
        //enableFormElements(false);
        //SupplierDAO supplierDAO = new SupplierDAO();
        //renderDataIntoTable(supplierDAO.retrieveAll());

    }
    
    public void enableFormElements(boolean flag){
        txtBillNumber.setEnabled(flag);
       
    }
    public boolean validateForm(){
        //btnSave.setText("Add");
        //btnSave.requestFocus();
        if(null == txtBillNumber.getText() || !(txtBillNumber.getText().matches("\\w+"))){
            JOptionPane.showMessageDialog(null, "Invoice Number "+txtBillNumber.getText() +" is not valid.");
            txtBillNumber.requestFocus();
            return false;
        }

        //txtProductCategoryName.setText("");
        return true;
    }
    

    
   
    
  

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
           /* if (menu == mitDelete) {
                //int rowIndex = tblSupplier.getSelectedRow();
                System.out.println("--------INSIDE DELETE-"+tblSupplier.getModel().getValueAt(tblSupplier.getSelectedRow(),0));
                String supplierCode = tblSupplier.getModel().getValueAt(tblSupplier.getSelectedRow(),0).toString();
                SupplierDAO supplierDAO = new SupplierDAO();
                supplierDAO.deleteRecordByCode(supplierCode);
                initializeForm();
            } */
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbPaymentType;
    private com.toedter.calendar.JDateChooser dtpFromDate;
    private com.toedter.calendar.JDateChooser dtpToDate;
    private javax.swing.ButtonGroup grpBillType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblDateRange;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JPanel pnlStockEntry;
    private javax.swing.JTextField txtBillNumber;
    // End of variables declaration//GEN-END:variables
}

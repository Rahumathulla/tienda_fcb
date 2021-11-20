/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.CustomerDAO;
import com.essar.dao.StockDAO;
import com.essar.dao.SupplierDAO;
import com.essar.pojos.Customer;
import com.essar.pojos.GST;
import com.essar.pojos.Stock;
import com.essar.pojos.Supplier;
import com.essar.utils.ConnectionManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
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
public class Vp_SalesSummarySelection extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Stock
     */
    long stockIdEdit=0;
    boolean customerSelected = false;
    Customer customer =null;
    DecimalFormat df = new DecimalFormat("####.##");
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Vp_SalesSummarySelection() {
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
        jPanel2 = new javax.swing.JPanel();
        radB2C = new javax.swing.JRadioButton();
        radB2B = new javax.swing.JRadioButton();
        lblBillType = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales Summary Report");

        pnlStockEntry.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Options"));

        lblBillNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBillNumber.setText("Bill Number (onwards)");

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

        grpBillType.add(radB2C);
        radB2C.setText("B2C");
        radB2C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radB2CActionPerformed(evt);
            }
        });

        grpBillType.add(radB2B);
        radB2B.setText("B2B");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(radB2C)
                .addGap(36, 36, 36)
                .addComponent(radB2B)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radB2C)
                    .addComponent(radB2B)))
        );

        lblBillType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBillType.setText("Bill Type");

        javax.swing.GroupLayout pnlStockEntryLayout = new javax.swing.GroupLayout(pnlStockEntry);
        pnlStockEntry.setLayout(pnlStockEntryLayout);
        pnlStockEntryLayout.setHorizontalGroup(
            pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStockEntryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addComponent(lblBillType, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(11, 11, 11)
                .addGroup(pnlStockEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStockEntryLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblBillType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
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
                    .addComponent(dtpToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        Date cessEndDate=null;
        try {
            cessEndDate = dateFormat.parse("2021-08-01");
        } catch (ParseException ex) {
            Logger.getLogger(SalesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dtpFromDate.getDate().before(cessEndDate)){
            
        }
        if(radB2B.isSelected()){
            selectClause = "SELECT * FROM sales WHERE UPPER(bill_type) = 'B2B' ";
            reportString="src\\com\\essar\\reports\\gst_b2b.jrxml";
        }else if (radB2C.isSelected()){
            selectClause = "SELECT * FROM sales WHERE UPPER(bill_type) = 'NORMAL' ";
            if(dtpFromDate.getDate().before(cessEndDate))
                reportString="src\\com\\essar\\reports\\gst_b2c_with_cess.jrxml";
            else
                reportString="src\\com\\essar\\reports\\gst_b2c.jrxml";
        }else {
            selectClause = "SELECT * FROM sales WHERE UPPER(bill_type) = 'CONTRACTOR' ";
            if(dtpFromDate.getDate().before(cessEndDate))
                reportString="src\\com\\essar\\reports\\gst_b2c_with_cess.jrxml";
            else
                reportString="src\\com\\essar\\reports\\gst_b2c.jrxml";
        }
        
        if(null!= txtBillNumber.getText() && !("".equals(txtBillNumber.getText()))) { 
            selectClause = selectClause + " AND bill_seq_number >='"+txtBillNumber.getText()+"' ORDER BY sales_id";
            
        }else if(cmbPaymentType.getSelectedIndex()!=0){
            if(cmbPaymentType.getSelectedIndex()==1){
                    selectClause = selectClause + " AND status = 'Paid' ORDER BY sales_id";
            }
            else if(cmbPaymentType.getSelectedIndex()==2){
                   selectClause = selectClause + " AND status = 'Credit' ORDER BY sales_id";
            }
            else
                selectClause = selectClause + " ORDER BY sales_id";
        }
        else{
            if(!(fromDate.equals(toDate))){
            selectClause = selectClause + " AND sales_date BETWEEN "
                    + "'"+fromDate +" 00:00:00' AND '"+toDate+ " 23:59:59'" + " ORDER BY sales_id";
            }
        }
        
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();

        //String reportString="src\\com\\essar\\reports\\gst.jrxml";
        JasperReport jr = null;
        HashMap map = new HashMap();
        map.put("query_param",selectClause);
        try {
            jr = JasperCompileManager.compileReport(reportString);
        } catch (JRException ex) {
            Logger.getLogger(SalesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(jr, map,con);

            con.close();
        } catch (JRException ex) {
            Logger.getLogger(StockEntry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SalesWindow.class.getName()).log(Level.SEVERE, null, ex);
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

    private void radB2CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radB2CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radB2CActionPerformed

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
            java.util.logging.Logger.getLogger(Vp_SalesSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vp_SalesSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vp_SalesSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vp_SalesSummarySelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vp_SalesSummarySelection().setVisible(true);
            }
        });
    }
    
    public void initializeForm(){
        stockIdEdit =0;
        txtBillNumber.requestFocus();
        dtpToDate.setDate(new Date());
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
        
        
        radB2C.setSelected(true);


        //enableFormElements(false);
        SupplierDAO supplierDAO = new SupplierDAO();
        renderDataIntoTable(supplierDAO.retrieveAll());
        
        CustomerDAO customerDAO = new CustomerDAO();
        renderCustomerDataIntoDropDown(customerDAO.retrieveAll());
    }
    
    public void enableFormElements(boolean flag){
        txtBillNumber.setEnabled(flag);
       
    }
    public boolean validateForm(){
        //btnSave.setText("Add");
        //btnSave.requestFocus();
        if(null == txtBillNumber.getText() || !(txtBillNumber.getText().matches("\\w+"))){
            JOptionPane.showMessageDialog(null, "HSN code "+txtBillNumber.getText() +" is not valid.");
            txtBillNumber.requestFocus();
            return false;
        }

        //txtProductCategoryName.setText("");
        return true;
    }
    
    public void renderCustomerDataIntoDropDown(List<Customer> customerList){
        Customer customer = null;
        /*if(customerList!= null){
            //cmbCustomerName.addItem("Select");
            for(int i=0; i<customerList.size();i++){
                cmbCustomerName.addItem(customerList.get(i));
            }
            cmbCustomerName.setSelectedIndex(0);
            customer = (Customer)cmbCustomerName.getSelectedItem();            
        }*/
    }
    
    public void saveStockData(){
 
        Stock stock = new Stock();
        stock.setHsnCode(txtBillNumber.getText());
        //stock.setItemName(txtItemName.getText());
       
        //Float fSellingPrice = (Float.parseFloat(txtPurchasePrice.getText()))+(Float.parseFloat(txtMargin.getText()));
        double preMarginSalesPrice = stock.getPurchasePrice()+stock.getPurchasePrice()*stock.getGstPercentage()*0.01;
        stock.setSellingPrice(preMarginSalesPrice+preMarginSalesPrice*stock.getMargin()*0.01);
       

        StockDAO stockDAO = new StockDAO();
        if (stockIdEdit >0){
            stock.setItemId(stockIdEdit);
            stockDAO.updateStock(stock);
        }else
            stockDAO.insertIntoDB(stock);
        
    }
    
    public final void fetchStockDataIntoTable(Stock stock){
        stockIdEdit=0;
        stockIdEdit = stock.getItemId();
        System.out.println("--Called fetchStockDataIntoTable"+stock.getItemName());
        //initializeForm();
        enableFormElements(true);
        
        
        

        /*if(salesDetailsModel != null){
        salesDetailsModel.addRow(new Object[]{stock.getHsnCode(),stock.getItemName(),stock.getGstPercentage(),df.format(Double.parseDouble(stock.getGstAmount()) * Double.parseDouble(txtQuantity.getText())), itemAmount, Double.parseDouble(txtQuantity.getText()), df.format(itemAmount * Double.parseDouble(txtQuantity.getText())), stock.getItemId()});
        //model.
                
        } */
        //deriveValuesFromSalesInput();
    }
    
    public void renderDataIntoTable(List<Supplier> supplierList){
        /*DefaultTableModel supplierModel = null;
        supplierModel = (DefaultTableModel) tblSupplier.getModel();
        System.out.println("-----"+supplierList.size());
        for(int i=0;i<supplierList.size();i++){
        supplierModel.addRow(new Object[]{supplierList.get(i).getSupplierCode(),supplierList.get(i).getSupplierName(),supplierList.get(i).getSupplierContactNumber(), supplierList.get(i).getSupplierRating(), supplierList.get(i).getSupplierAddress()});
        //model.
        }        */
        
    }
    
   
    
    public void renderSupplierDataIntoDropDown(List<Supplier> supplierList){
        Supplier supplier = null;
        if(supplierList!= null){
            /*for(int i=0; i<supplierList.size();i++){
                cmbSupplier.addItem(supplierList.get(i));
            }
            cmbSupplier.setSelectedIndex(0);
            supplier = (Supplier)cmbSupplier.getSelectedItem();*/     
        }
    }
    
    public void renderGstDataIntoDropDown(List<GST> gstList){
        GST gst = null;
        if(gstList!= null){
            /*for(int i=0; i<gstList.size();i++){
                cmbGST.addItem(gstList.get(i));
            }
            cmbGST.setSelectedIndex(0);
            gst = (GST)cmbGST.getSelectedItem();    */  
        }  
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblBillType;
    private javax.swing.JLabel lblDateRange;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JPanel pnlStockEntry;
    private javax.swing.JRadioButton radB2B;
    private javax.swing.JRadioButton radB2C;
    private javax.swing.JTextField txtBillNumber;
    // End of variables declaration//GEN-END:variables
}

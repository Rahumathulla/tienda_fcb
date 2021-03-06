/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

import com.essar.dao.ActivityDAO;
import com.essar.dao.GstDAO;
import com.essar.pojos.Activity;
import com.essar.pojos.GST;
import com.essar.utils.TableMouseListener;
import com.essar.utils.GenericUtils;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
public class ActivityLog extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ProductCategory
     */
    long activityId=0;
    DefaultTableModel activityModel = null;
    public ActivityLog() {
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
        mnuCategory = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mitDelete = new javax.swing.JMenuItem();
        mitEdit = new javax.swing.JMenuItem();
        pnlGstSettings = new javax.swing.JPanel();
        panActivity = new javax.swing.JScrollPane();
        tblActivityLog = new javax.swing.JTable();

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

        mitEdit.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insights");
        setExtendedState(6);
        setName("frmProductCategory"); // NOI18N

        pnlGstSettings.setBorder(javax.swing.BorderFactory.createTitledBorder("Activity Log"));

        panActivity.setForeground(new java.awt.Color(102, 102, 0));
        panActivity.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N

        tblActivityLog.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        tblActivityLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity Details", "Created By", "Date", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panActivity.setViewportView(tblActivityLog);

        javax.swing.GroupLayout pnlGstSettingsLayout = new javax.swing.GroupLayout(pnlGstSettings);
        pnlGstSettings.setLayout(pnlGstSettingsLayout);
        pnlGstSettingsLayout.setHorizontalGroup(
            pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGstSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panActivity, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGstSettingsLayout.setVerticalGroup(
            pnlGstSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGstSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panActivity, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGstSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGstSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ActivityLog().setVisible(true);
            }
        });
    }
    
    /*tblGst.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            if (me.getClickCount() == 2) {     // to detect doble click events
               JTable target = (JTable)me.getSource();
               int row = target.getSelectedRow(); // select a row
               int column = target.getSelectedColumn(); // select a column
              JOptionPane.showMessageDialog(null, table.getValueAt(row, column)); // get the value of a row and column.
            }
         }
      });*/
    
    public void calculateGstSplitLogic(){
        try{

        }
        catch(NumberFormatException nfe){
            System.out.println("Invalid Number ("+nfe.getMessage()+") .");
        }
    }
    public void initializeForm(){
        DefaultTableModel model = (DefaultTableModel) tblActivityLog.getModel();
        model.setRowCount(0);
        

     

        enableFormElements(false);
        ActivityDAO activityDAO = new ActivityDAO();
        renderDataIntoTable(activityDAO.retrieveAll());
        mnuCategory = new JPopupMenu();
        mitDelete = new JMenuItem("Delete");
        mitDelete.addActionListener(this);
        
        mitEdit = new JMenuItem("Edit");
        mitEdit.addActionListener(this);
        
        mnuCategory.add(mitDelete);
        mnuCategory.add(mitEdit);
         // sets the popup menu for the table
        tblActivityLog.setComponentPopupMenu(mnuCategory);      
        tblActivityLog.addMouseListener(new TableMouseListener(tblActivityLog));
        
        TableColumn idColumn1 = tblActivityLog.getColumnModel().getColumn(tblActivityLog.getColumnCount()-1);
        
        idColumn1.setPreferredWidth(0);
        idColumn1.setMinWidth(0);
        idColumn1.setMaxWidth(0);
        TableColumn activityColumn = tblActivityLog.getColumnModel().getColumn(0);
        activityColumn.setPreferredWidth(580);
        activityColumn.setMinWidth(580);
        //activityColumn.setMaxWidth(580);
   
    }
    
    public void enableFormElements(boolean flag){

    }
    public boolean validateForm(){
        //btnSave.setText("Add");
        //btnSave.requestFocus();

       /* if(null == txtDescription.getText() || !(txtProductCategoryName.getText().matches("\\w+"))){
            JOptionPane.showMessageDialog(null, "The product category name "+txtProductCategoryName.getText() +" is not valid.");
            return false;
        }*/
        //txtProductCategoryName.setText("");
        return true;
    }
    
    public void saveGSTForm(){ 
        GST gst = new GST();
        //gst.setGstValue(Double.parseDouble(txtGST.getText()));
    
        GstDAO gstDAO = new GstDAO();
        gstDAO.insertIntoDB(gst);        
    }
    
    public void updateGSTForm(){

        GST gst = new GST();
        gst.setGstId(activityId);       
        GstDAO gstDAO = new GstDAO();
        gstDAO.updateRecord(gst);
        
    }
    
    public void renderDataIntoTable(List<Activity> activityList){
        
        activityModel = (DefaultTableModel) tblActivityLog.getModel();
        //System.out.println("-----"+productCategoryList.size());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(int i=0;i<activityList.size();i++){
            activityModel.addRow(new Object[]{activityList.get(i).getDescription(),activityList.get(i).getCreatedBy(), sdf.format(activityList.get(i).getCreateTS()) });
        //model.
        }        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuItem mitDelete;
    private javax.swing.JMenuItem mitEdit;
    private javax.swing.JPopupMenu mnuCategory;
    private javax.swing.JScrollPane panActivity;
    private javax.swing.JPanel pnlGstSettings;
    private javax.swing.JTable tblActivityLog;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            JMenuItem menu = (JMenuItem) event.getSource();
            if (menu == mitDelete) {
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                long id = Long.parseLong(tblActivityLog.getModel().getValueAt(tblActivityLog.getSelectedRow(),tblActivityLog.getColumnCount()-1).toString());
                GstDAO gstDAO = new GstDAO();
                gstDAO.deleteRecordById(id);
                GenericUtils.removeRowFromJTable(tblActivityLog, activityModel);
                
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
            
            if (menu == mitEdit) {
                //int rowIndex = tblCategory.getSelectedRow();
                //System.out.println("--------INSIDE DELETE-"+tblCategory.getModel().getValueAt(tblCategory.getSelectedRow(),0));
                GST gst = new GST();
                //activityId = Integer.parseInt(tblActivityLog.getModel().getValueAt(tblActivityLog.getSelectedRow(),tblActivityLog.getColumnCount()-1).toString());
                //GstDAO gstDAO = new GstDAO();
                //gst = gstDAO.retrieveById(activityId);

                enableFormElements(true);
                //btnSave.setText("Update");
                //btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png")));
                //initializeForm();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }
     
     
}

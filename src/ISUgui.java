import java.util.ArrayList;
import java.util.Timer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class ISUgui extends javax.swing.JFrame {
    Timer t;
    Updater u;
    DefaultListModel model= new DefaultListModel();
    static ArrayList generatorList = new ArrayList();
        public ISUgui() {
            initComponents();
            initObjects();
            txtres.setText(Game.ToString());
            btnbuy.setEnabled(false);
            this.setResizable(false);
    }
    private void initObjects(){
        //for scheduled increments
        t = new Timer();
        //the increment itself
        u = new Updater();
        //connecting the task to the timer
        t.schedule(u, 0, 1000);
        //first point generator
        generatorList.add(new PGnormal(10, 1, "Miner"));
        model.addElement(((PGnormal)generatorList.get(0)).getName());
        generatorList.add(new PGnormal(300, 10, "Auto Drill"));
        model.addElement(((PGnormal)generatorList.get(1)).getName());
        generatorList.add(new PGnormal(1200, 100, "Mining Robot"));
        model.addElement(((PGnormal)generatorList.get(0)).getName());
        lstresources.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIncrease = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtres = new javax.swing.JTextField();
        btndouble = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstresources = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtinfo = new javax.swing.JTextArea();
        btnbuy = new javax.swing.JButton();
        labelincrease = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnupgrade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generic Idle Game");
        setBackground(new java.awt.Color(0, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.magenta);

        btnIncrease.setText("+1");
        btnIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncreaseActionPerformed(evt);
            }
        });

        jLabel1.setText("Resources:");

        txtres.setEditable(false);

        btndouble.setText("Double Click Power");
        btndouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoubleActionPerformed(evt);
            }
        });

        lstresources.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstresourcesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstresourcesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstresources);

        txtinfo.setEditable(false);
        txtinfo.setColumns(20);
        txtinfo.setRows(5);
        jScrollPane2.setViewportView(txtinfo);

        btnbuy.setText("Buy");
        btnbuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuyActionPerformed(evt);
            }
        });

        labelincrease.setText("Idle Increase: 0/s");

        jLabel2.setText("Resource Generator List");

        jLabel3.setText("Info");

        btnupgrade.setText("Upgrade");
        btnupgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupgradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIncrease)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndouble))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtres, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelincrease))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnbuy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnupgrade)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelincrease))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncrease)
                    .addComponent(btndouble))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuy)
                    .addComponent(btnupgrade))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncreaseActionPerformed
        //Manually click the button -> increase the resources by the amount
        //of the manual increase
        Game.increaseResources(ManualIncrease.incrementAmount);
        txtres.setText(Game.ToString());
        checkButtons();
    }//GEN-LAST:event_btnIncreaseActionPerformed

    private void btndoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoubleActionPerformed
        ManualIncrease.doubleIncrement();
        btnIncrease.setText("+" + ManualIncrease.incrementAmount);
    }//GEN-LAST:event_btndoubleActionPerformed

    private void lstresourcesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstresourcesMouseClicked
    }//GEN-LAST:event_lstresourcesMouseClicked

    private void lstresourcesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstresourcesMouseReleased
        int item = lstresources.getSelectedIndex();
        txtinfo.setText(generatorList.get(item).toString());
        checkButtons();
    }//GEN-LAST:event_lstresourcesMouseReleased

    private void btnbuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuyActionPerformed
        int item = lstresources.getSelectedIndex();
        int cost = ((PGnormal)generatorList.get(item)).getCost();
        Game.decreaseResources(cost);
        txtres.setText(String.valueOf(Game.resources));
        ((PGnormal)generatorList.get(item)).upQuantity();
        txtinfo.setText(generatorList.get(item).toString());
        AutoIncrease.increase(item+1);
        checkButtons();
    }//GEN-LAST:event_btnbuyActionPerformed

    private void btnupgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupgradeActionPerformed
        //upgrades one of the units to be super awesome
        //still have to add effect and instantiate a new object
        int item = lstresources.getSelectedIndex();
        if (((PGnormal)generatorList.get(item)).getQuantity()>0){
            int cost = ((PGnormal)generatorList.get(item)).getBaseCost() * 100;
            Game.decreaseResources(cost);
            txtres.setText(String.valueOf(Game.resources));
            ((PGnormal)generatorList.get(item)).downQuantity();
            txtinfo.setText(generatorList.get(item).toString());
            checkButtons();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "You need at least one unit to upgrade!");
        }
    }//GEN-LAST:event_btnupgradeActionPerformed
    public static void updateCall(int increase){
        Game.increaseResources(increase);
        labelincrease.setText("Idle Increase: " + increase + "/s");
        txtres.setText(Game.ToString());
        checkButtons();
    }
    private static void checkButtons (){
        if (lstresources.isSelectionEmpty()){
            btnbuy.setEnabled(false);
            btnupgrade.setEnabled(false);
        }
        else{
            int item = lstresources.getSelectedIndex();
            if (Game.getRes() >= ((PGnormal)generatorList.get(item)).getCost()) btnbuy.setEnabled (true);
            else btnbuy.setEnabled(false);
            if (Game.getRes()>= ((PGnormal)generatorList.get(item)).getBaseCost()*100) btnupgrade.setEnabled(true);
            else btnupgrade.setEnabled(false);
        }
        
    }
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
            java.util.logging.Logger.getLogger(ISUgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ISUgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ISUgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ISUgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ISUgui().setVisible(true);
            }
        });
    }  
    
    //custom variable declaration
    //this is because some elements are 
    //required to be static to be called from static methods
    private javax.swing.JButton btnIncrease;
    private static javax.swing.JButton btnbuy;
    private static javax.swing.JButton btndouble;
    private static javax.swing.JButton btnupgrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JTextField txtres;
    private static javax.swing.JList lstresources;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea txtinfo;
    private static javax.swing.JLabel labelincrease;
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIncrease;
    private javax.swing.JButton btnbuy;
    private javax.swing.JButton btndouble;
    private javax.swing.JButton btnupgrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelincrease;
    private javax.swing.JList lstresources;
    private javax.swing.JTextArea txtinfo;
    private javax.swing.JTextField txtres;
    // End of variables declaration//GEN-END:variables
    */
}





//gotta read all the info into the actual game stats, setting up the auto upgraded correctly
//more comments omg



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class ISUgui extends javax.swing.JFrame {
    Timer t;
    Updater u;
    static DefaultListModel normalmodel= new DefaultListModel();
    static DefaultListModel upgraded= new DefaultListModel();
    static ArrayList<PGnormal> generatorList = new ArrayList();
    static ArrayList<PGupgraded> upgradedList = new ArrayList();
    public HashMap<String,SaveProfile> saves = new HashMap<>();
    boolean isUpgradedList = false;
    String currentSave;
        public ISUgui() {
            initComponents();
            initObjects();//create all the lists and timer
            //initialize the GUI to its beginning state
            txtres.setText(Game.ToString());
            btnbuy.setEnabled(false);
            loadSaves();
            currentSave = "TJ";
            if (currentSave != null){
                generatorList = (ArrayList<PGnormal>)saves.get(currentSave).getGeneratorList().clone();
                upgradedList = (ArrayList<PGupgraded>)saves.get(currentSave).getUpgradedList().clone();
            }
            System.out.println(generatorList);
            upgradedList.equals(saves.get(currentSave).getUpgradedList());
            this.setResizable(false);
    }
    private void initObjects(){
        //list of normal point generators and list model
        generatorList.add(new PGnormal(10, 1, "Miner",0));
        normalmodel.addElement(generatorList.get(0).getName());
        generatorList.add(new PGnormal(300, 10, "Auto Drill",1));
        normalmodel.addElement(generatorList.get(1).getName());
        generatorList.add(new PGnormal(1200, 100, "Mining Robot",2));
        normalmodel.addElement(generatorList.get(2).getName());
        //sets list to the model
        lstresources.setModel(normalmodel);
        //list of upgraded point generators and list model
        upgradedList.add(new PGupgraded(1, "Miner",0));
        upgraded.addElement(upgradedList.get(0).getName());
        upgradedList.add(new PGupgraded(10, "Auto Drill",1));
        upgraded.addElement(upgradedList.get(1).getName());
        upgradedList.add(new PGupgraded(100, "Mining Robot",2));
        upgraded.addElement(upgradedList.get(2).getName());
        //setting up all the upgrade costs of the upgraded units intially
        for (int x= 0;x<generatorList.size();x++){
            getUpgradeCost(generatorList.get(x),upgradedList.get(x));
        }//for scheduled point increments
        t = new Timer();
        //the increment itself
        u = new Updater();
        //setting all the sceduled increments to their proper values
        for (int x = 0;x<generatorList.size();x++){
            u.setRate(x, generatorList.get(x).getRate());
        }
        //connecting the task to the timer
        t.schedule(u, 0, 1000);
        
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
        chkupgraded = new javax.swing.JCheckBox();
        btnsave = new javax.swing.JButton();

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

        chkupgraded.setText("Upgraded");
        chkupgraded.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkupgradedStateChanged(evt);
            }
        });
        chkupgraded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkupgradedMouseClicked(evt);
            }
        });
        chkupgraded.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                chkupgradedPropertyChange(evt);
            }
        });

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
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
                                .addComponent(labelincrease)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkupgraded)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnbuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnupgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkupgraded)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuy)
                    .addComponent(btnupgrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsave)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncreaseActionPerformed
        //Manually click the button -> increase the resources by the amount
        //of the manual increase
        Game.increaseResources(ManualIncrease.incrementAmount);
        txtres.setText(Game.ToString());
        checkInterface();//making sure that the button update is instant
    }//GEN-LAST:event_btnIncreaseActionPerformed

    private void btndoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoubleActionPerformed
        //this is simply a developer function for now
        ManualIncrease.doubleIncrement();//double the increment
        btnIncrease.setText("+" + ManualIncrease.incrementAmount);//update button text
    }//GEN-LAST:event_btndoubleActionPerformed

    private void lstresourcesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstresourcesMouseClicked
    
    }//GEN-LAST:event_lstresourcesMouseClicked

    private void lstresourcesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstresourcesMouseReleased
    if (lstresources.getSelectedIndex() == -1) return;//this doesnt seem neccessary but actually prevents a random error
    if (!chkupgraded.isSelected()){//this is the regular list (non upgraded)
        int item = lstresources.getSelectedIndex();
        int upgradeCost =  getUpgradeCost(generatorList.get(item),upgradedList.get(item));
        txtinfo.setText(generatorList.get(item).toString(upgradeCost)); //brings up info of the item
        checkInterface();//making sure that the button update is instant
    }
    else {
        int item = lstresources.getSelectedIndex();
        txtinfo.setText(upgradedList.get(item).toString());//brings up info of the upgraded item
        checkInterface();//making sure that the button update is instant
    }
    }//GEN-LAST:event_lstresourcesMouseReleased

    private void btnbuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuyActionPerformed
        int item = lstresources.getSelectedIndex();
        int cost = generatorList.get(item).getCost();
        Game.decreaseResources(cost);//"buy" the item, decrease resources
        txtres.setText(String.valueOf(Game.resources));//update resource text
        generatorList.get(item).upQuantity();//increase appropriate generator by 1
        int upgradeCost =  getUpgradeCost(generatorList.get(item),upgradedList.get(item));
        txtinfo.setText(generatorList.get(item).toString(upgradeCost));//update item info text
        AutoIncrease.increase("Normal",item+1);//update the automatic increase by the appropriate item
        checkInterface();//making sure that the button update is instant
    }//GEN-LAST:event_btnbuyActionPerformed

    private void btnupgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupgradeActionPerformed
        //upgrades one of the units to have 100x the current rate
        int item = lstresources.getSelectedIndex();
        if (generatorList.get(item).getQuantity()>0){//only allow upgrade if theres anything to upgrade
            int upgradeCost =  getUpgradeCost(generatorList.get(item),upgradedList.get(item));
            Game.decreaseResources(upgradeCost);//deduct the cost from resources
            txtres.setText(String.valueOf(Game.resources));//update resources counter
            generatorList.get(item).downQuantity();//decreaes the number of normal units by 1
            upgradedList.get(item).upQuantity();//increases the number of upgraded units of the same type by 1int upgradeCost =  getUpgradeCost(generatorList.get(item),upgradedList.get(item));
            upgradeCost =  getUpgradeCost(generatorList.get(item),upgradedList.get(item));
            txtinfo.setText(generatorList.get(item).toString(upgradeCost));//update info text
            AutoIncrease.increase("Upgraded", item+1);//update the auto increase to match the units
            AutoIncrease.decrease("Normal",item+1);//removing the corresponding normal item
            checkInterface();//making sure that the button update is instant
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "You need at least one unit to upgrade!");
        }
    }//GEN-LAST:event_btnupgradeActionPerformed

    private void chkupgradedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_chkupgradedPropertyChange
    }//GEN-LAST:event_chkupgradedPropertyChange
    private void chkupgradedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkupgradedStateChanged
    }//GEN-LAST:event_chkupgradedStateChanged

    private void chkupgradedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkupgradedMouseClicked
        //for some reason sometimes if the checkbox is clicked, it doesnt change the check mark
        //we check for the actual selection boolean to make the list change more consistent
        if (chkupgraded.isSelected()){
            lstresources.setModel(upgraded);
        }
        else lstresources.setModel(normalmodel);
        txtinfo.setText("");
        checkInterface();//making sure that the button update is instant
    }//GEN-LAST:event_chkupgradedMouseClicked

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        PGnormal[] pgn = new PGnormal[generatorList.size()];
            PGupgraded[] pgu = new PGupgraded[upgradedList.size()];
            for (int x=0;x<generatorList.size();x++){
                pgn[x] = generatorList.get(x);
            }
            for (int x=0;x<upgradedList.size();x++){
                pgu[x] = upgradedList.get(x);
            }
            FileWriter fw;
            SaveProfile save = new SaveProfile("TJ", "Dev");
            try {
                fw = new FileWriter ("saves.txt");
                PrintWriter p = new PrintWriter(fw);
                System.out.println("Attempting to save");
                save.save(pgn, pgu, p);
                p.close();
            }
            catch(IOException ex){
                System.out.println(ex);
            }
    }//GEN-LAST:event_btnsaveActionPerformed
  
    public static void updateCall(int increase){
        Game.increaseResources(increase);//increase the resources
        labelincrease.setText("Idle Increase: " + increase + "/s");//updates the point generation per second text
        txtres.setText(Game.ToString());//updates the resources text
        checkInterface();//check the buttons and things again to make sure theyre appropraitly enabled and disabled
    }
    
    //the bulk of the interface updating
    private static void checkInterface(){
        //changes the list model depending on check box
        //inner if statements prevent constant refreshing and clearing of selection
        if(chkupgraded.isSelected()){
            if (lstresources.getModel() == normalmodel){
                lstresources.setModel(upgraded);
            }
        }
        else{
            if (lstresources.getModel()==upgraded){
                lstresources.setModel(normalmodel);
            }
        }
//        this code is to enable or disable various buttons 
//        depending on if your resources are enough to afford
        int item = lstresources.getSelectedIndex();
//        it also works as a resource checker
//        if you cannot afford to buy something, the button is disabled
//        this way you wont be able to run the buy methods to buy things when 
//        youre not supposed to 
        
        if (lstresources.isSelectionEmpty()){
            btnbuy.setEnabled(false);
            btnupgrade.setEnabled(false);
        }
        else{
            if (!chkupgraded.isSelected() && !lstresources.isSelectionEmpty()){
                if (Game.getRes() >= (generatorList.get(item)).getCost()) btnbuy.setEnabled (true);
                else btnbuy.setEnabled(false);
                int upgradeCost =  getUpgradeCost(generatorList.get(item),upgradedList.get(item));
                if (Game.getRes()>= upgradeCost) btnupgrade.setEnabled(true);
                else btnupgrade.setEnabled(false);
            }
            else{
                btnbuy.setEnabled(false);
                btnupgrade.setEnabled(false);
            }
        }
    }
    public static int getUpgradeCost (PGnormal a, PGupgraded b){
        int upgradeCost = a.getBaseCost();
        upgradeCost = b.getUpgradeCost(upgradeCost);//finding the upgrade cost
        return upgradeCost;
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
    private void loadSaves() {
        try{
            FileReader fr = new FileReader ("saves.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true){
                String name=br.readLine();
                if (name==null)break;
                String type=br.readLine();
                SaveProfile s = new SaveProfile(name, type);
                for (int x = 0; x<3; x++){
                    String n = br.readLine();
                    int t = Integer.parseInt(br.readLine());
                    int r = Integer.parseInt(br.readLine());
                    int q = Integer.parseInt(br.readLine());
                    double c = Double.parseDouble(br.readLine());
                    PGnormal pgn = new PGnormal(c, r, n, t);
                    pgn.setQuantity(q);
                    s.addPGN(pgn);
                }
                
                for (int x = 0; x<3; x++){
                    String n = br.readLine();
                    int t = Integer.parseInt(br.readLine());
                    int r = Integer.parseInt(br.readLine());
                    int q = Integer.parseInt(br.readLine());
                    PGupgraded pgu = new PGupgraded(r, n, t);
                    pgu.setQuantity(q);
                    s.addPGU(pgu);
                }
                saves.put(s.getName(), s);
                int r = Integer.parseInt(br.readLine());
                Game.increaseResources(r);
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
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
    private static javax.swing.JCheckBox chkupgraded;
    private javax.swing.JButton btnsave;
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIncrease;
    private javax.swing.JButton btnbuy;
    private javax.swing.JButton btndouble;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupgrade;
    private javax.swing.JCheckBox chkupgraded;
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

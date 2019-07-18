/*
Copyright (c) 2008, George Blouin Jr. (skyhigh@solaris7.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are
permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of
conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list
of conditions and the following disclaimer in the documentation and/or other materials
provided with the distribution.
 * Neither the name of George Blouin Jr nor the names of contributors may be
used to endorse or promote products derived from this software without specific prior
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package BFB.GUI;

import Force.*;
import Force.View.abTable;
import Force.View.tbTotalWarfare;
import filehandlers.Media;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ForcePanel extends javax.swing.JPanel {

    private Force force;
    private abTable currentModel = new tbTotalWarfare();
    private Media media = new Media();
    private Preferences Prefs;

    KeyListener Overrides = new KeyListener() {
        public void keyReleased(KeyEvent e) { OverrideSkills(); }
        public void keyTyped(KeyEvent e) { OverrideSkills(); }
        public void keyPressed(KeyEvent e) { OverrideSkills(); }
    };

    /** Creates new form ForcePanel */
    public ForcePanel(Preferences prefs) {
        this.Prefs = prefs;
        initComponents();

        txtOverrideGunnery.addKeyListener(Overrides);
        txtOverridePiloting.addKeyListener(Overrides);
    }

    private void OverrideSkills() {
        int Gunnery = 4,
            Piloting = 5;

        try { Gunnery = Integer.parseInt(txtOverrideGunnery.getText()); } catch ( Exception e ) {}
        try { Piloting = Integer.parseInt(txtOverridePiloting.getText()); } catch ( Exception e ) {}
        for ( Unit u : force.getUnits() ) {
            u.setGunnery(Gunnery);
            u.setPiloting(Piloting);
            u.Refresh();
        }
        force.RefreshBV();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spnForces = new javax.swing.JScrollPane();
        tblForces = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblNumUnits = new javax.swing.JLabel();
        lblTotalBV = new javax.swing.JLabel();
        lblTotalTonnage = new javax.swing.JLabel();
        lblBaseBV = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtForceName = new javax.swing.JTextField();
        cmbForceType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtOverrideGunnery = new javax.swing.JTextField();
        txtOverridePiloting = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnTransfer = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnRandom = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnOpenForce = new javax.swing.JButton();
        btnSaveForce = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnClipboard = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        tblForces.setModel(new javax.swing.table.DefaultTableModel(
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
        tblForces.setRowMargin(2);
        tblForces.setShowVerticalLines(false);
        tblForces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForcesMouseClicked(evt);
            }
        });
        tblForces.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblForcesKeyReleased(evt);
            }
        });
        spnForces.setViewportView(tblForces);

        lblNumUnits.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumUnits.setText("6 Units");

        lblTotalBV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalBV.setText("12,000");

        lblTotalTonnage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalTonnage.setText("100 Tons");

        lblBaseBV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBaseBV.setText("10,000 BV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumUnits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(lblTotalTonnage)
                .addGap(31, 31, 31)
                .addComponent(lblBaseBV)
                .addGap(156, 156, 156)
                .addComponent(lblTotalBV)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(lblNumUnits)
                .addComponent(lblTotalBV)
                .addComponent(lblBaseBV)
                .addComponent(lblTotalTonnage))
        );

        jLabel1.setText("Unit Name:");

        cmbForceType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inner Sphere", "Clan", "Comstar/WoB" }));

        jLabel2.setText("Type:");

        txtOverrideGunnery.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOverrideGunnery.setText("4");
        txtOverrideGunnery.setPreferredSize(new java.awt.Dimension(20, 20));

        txtOverridePiloting.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOverridePiloting.setText("5");
        txtOverridePiloting.setPreferredSize(new java.awt.Dimension(20, 20));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shield--plus.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAdd);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shield--pencil.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shield--minus.png"))); // NOI18N
        btnDelete.setText("Del");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnDelete);

        btnTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shield--down.png"))); // NOI18N
        btnTransfer.setText("Move");
        btnTransfer.setFocusable(false);
        btnTransfer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransfer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnTransfer);
        jToolBar1.add(jSeparator1);

        btnRandom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ruler-triangle.png"))); // NOI18N
        btnRandom.setText("Random");
        btnRandom.setFocusable(false);
        btnRandom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRandom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnRandom);
        jToolBar1.add(jSeparator2);

        btnOpenForce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/folder-open-document.png"))); // NOI18N
        btnOpenForce.setText("Open");
        btnOpenForce.setFocusable(false);
        btnOpenForce.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenForce.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnOpenForce);

        btnSaveForce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/disk.png"))); // NOI18N
        btnSaveForce.setText("Save");
        btnSaveForce.setFocusable(false);
        btnSaveForce.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveForce.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSaveForce);
        jToolBar1.add(jSeparator3);

        btnClipboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clipboard.png"))); // NOI18N
        btnClipboard.setText("Clip");
        btnClipboard.setFocusable(false);
        btnClipboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClipboard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnClipboard);

        jLabel6.setText("Override");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtForceName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbForceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOverrideGunnery, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOverridePiloting, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtForceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbForceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtOverridePiloting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOverrideGunnery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)))
        );

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("Logo");
        lblLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnForces, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnForces, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblForcesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForcesMouseClicked
}//GEN-LAST:event_tblForcesMouseClicked

    private void tblForcesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblForcesKeyReleased
}//GEN-LAST:event_tblForcesKeyReleased

    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked
        File Logo = media.SelectImage(Prefs.get("LastOpenLogo", ""), "Select Logo");
        try {
            if (Logo == null) {
                if (!force.LogoPath.isEmpty()) {
                    if (javax.swing.JOptionPane.showConfirmDialog(this, "Would you like to remove your current logo?", "Remove Logo", javax.swing.JOptionPane.YES_NO_OPTION) == javax.swing.JOptionPane.YES_OPTION) {
                        media.setLogo(lblLogo, Logo);
                        force.LogoPath = "";
                        force.isDirty = true;
                    }
                }
            } else {
                force.LogoPath = Logo.getCanonicalPath();
                force.isDirty = true;
                media.setLogo(lblLogo, Logo);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_lblLogoMouseClicked

    /**
     * @return the force
     */
    public Force getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(Force force) {
        this.force = force;
    }

    /**
     * @return the currentModel
     */
    public abTable getCurrentModel() {
        return currentModel;
    }

    /**
     * @param currentModel the currentModel to set
     */
    public void setCurrentModel(abTable currentModel) {
        this.currentModel = currentModel;
        currentModel.addTableModelListener(tableChanged);
        force.setCurrentModel(currentModel);
        force.setupTable(tblForces);
    }
    /**
     *
     */
    private TableModelListener tableChanged = new TableModelListener() {
        public void tableChanged(TableModelEvent e) {
            force.setupTable(tblForces);
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClipboard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpenForce;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnSaveForce;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JComboBox cmbForceType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBaseBV;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNumUnits;
    private javax.swing.JLabel lblTotalBV;
    private javax.swing.JLabel lblTotalTonnage;
    private javax.swing.JScrollPane spnForces;
    private javax.swing.JTable tblForces;
    private javax.swing.JTextField txtForceName;
    private javax.swing.JTextField txtOverrideGunnery;
    private javax.swing.JTextField txtOverridePiloting;
    // End of variables declaration//GEN-END:variables
}

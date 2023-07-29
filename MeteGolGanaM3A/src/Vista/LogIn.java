/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import LIB.FSTexFieldMD;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author tatip
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    public static FSTexFieldMD getTxt1erApeDLG() {
        return txt1erApeDLG;
    }

    public static void setTxt1erApeDLG(FSTexFieldMD txt1erApeDLG) {
        LogIn.txt1erApeDLG = txt1erApeDLG;
    }

    public static FSTexFieldMD getTxt1erNomDlg() {
        return txt1erNomDlg;
    }

    public static void setTxt1erNomDlg(FSTexFieldMD txt1erNomDlg) {
        LogIn.txt1erNomDlg = txt1erNomDlg;
    }

    public static FSTexFieldMD getTxt2doApeDLG() {
        return txt2doApeDLG;
    }

    public static void setTxt2doApeDLG(FSTexFieldMD txt2doApeDLG) {
        LogIn.txt2doApeDLG = txt2doApeDLG;
    }

    public static FSTexFieldMD getTxt2doNomDLG() {
        return txt2doNomDLG;
    }

    public static void setTxt2doNomDLG(FSTexFieldMD txt2doNomDLG) {
        LogIn.txt2doNomDLG = txt2doNomDLG;
    }

    public static FSTexFieldMD getTxtCedulaDLG() {
        return txtCedulaDLG;
    }

    public static void setTxtCedulaDLG(FSTexFieldMD txtCedulaDLG) {
        LogIn.txtCedulaDLG = txtCedulaDLG;
    }

    public static FSTexFieldMD getTxtCorreoDlg() {
        return txtCorreoDlg;
    }

    public static void setTxtCorreoDlg(FSTexFieldMD txtCorreoDlg) {
        LogIn.txtCorreoDlg = txtCorreoDlg;
    }

    public static FSTexFieldMD getTxtDirecDLG() {
        return txtDirecDLG;
    }

    public static void setTxtDirecDLG(FSTexFieldMD txtDirecDLG) {
        LogIn.txtDirecDLG = txtDirecDLG;
    }

    public static JDateChooser getTxtFechaDlg() {
        return txtFechaDlg;
    }

    public static void setTxtFechaDlg(JDateChooser txtFechaDlg) {
        LogIn.txtFechaDlg = txtFechaDlg;
    }

    public static FSTexFieldMD getTxtTelfDLG() {
        return txtTelfDLG;
    }

    public static void setTxtTelfDLG(FSTexFieldMD txtTelfDLG) {
        LogIn.txtTelfDLG = txtTelfDLG;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgPersona = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        txtCedulaDLG = new LIB.FSTexFieldMD();
        txtCorreoDlg = new LIB.FSTexFieldMD();
        txtDirecDLG = new LIB.FSTexFieldMD();
        txt1erNomDlg = new LIB.FSTexFieldMD();
        txt2doNomDLG = new LIB.FSTexFieldMD();
        txtTelfDLG = new LIB.FSTexFieldMD();
        txtFechaDlg = new com.toedter.calendar.JDateChooser();
        txt1erApeDLG = new LIB.FSTexFieldMD();
        txt2doApeDLG = new LIB.FSTexFieldMD();
        rdbMasculinoDlg = new javax.swing.JRadioButton();
        rdbFemeninoDlg = new javax.swing.JRadioButton();
        rdbOtroDlg = new javax.swing.JRadioButton();
        btnRetrocederDlgRegistro = new LIB.FSButtonMD();
        btnSiguienteDlgUsu = new LIB.FSButtonMD();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        btnGrupo1 = new javax.swing.ButtonGroup();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fSTexFieldMD1 = new LIB.FSTexFieldMD();
        fSPasswordFieldMD1 = new LIB.FSPasswordFieldMD();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        fSButtonMD1 = new LIB.FSButtonMD();
        fSButtonMD2 = new LIB.FSButtonMD();

        dlgPersona.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCedulaDLG.setForeground(new java.awt.Color(0, 0, 0));
        txtCedulaDLG.setToolTipText("Ingresa tu cédula");
        txtCedulaDLG.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txtCedulaDLG.setPlaceholder("Cédula");
        jPanel3.add(txtCedulaDLG, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txtCorreoDlg.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreoDlg.setToolTipText("Ingresa tu email");
        txtCorreoDlg.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txtCorreoDlg.setPlaceholder("Correo Electrónico");
        txtCorreoDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoDlgActionPerformed(evt);
            }
        });
        jPanel3.add(txtCorreoDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        txtDirecDLG.setForeground(new java.awt.Color(0, 0, 0));
        txtDirecDLG.setToolTipText("Ingresa tu direccion");
        txtDirecDLG.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txtDirecDLG.setPlaceholder("Dirección");
        txtDirecDLG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirecDLGActionPerformed(evt);
            }
        });
        jPanel3.add(txtDirecDLG, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        txt1erNomDlg.setForeground(new java.awt.Color(0, 0, 0));
        txt1erNomDlg.setToolTipText("Ingresa tu primer nombre");
        txt1erNomDlg.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txt1erNomDlg.setPlaceholder("Primer Nombre");
        jPanel3.add(txt1erNomDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        txt2doNomDLG.setForeground(new java.awt.Color(0, 0, 0));
        txt2doNomDLG.setToolTipText("Ingresa tu segundo nombre");
        txt2doNomDLG.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txt2doNomDLG.setPlaceholder("Segundo Nombre");
        jPanel3.add(txt2doNomDLG, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        txtTelfDLG.setForeground(new java.awt.Color(0, 0, 0));
        txtTelfDLG.setToolTipText("Ingresa tu telefono");
        txtTelfDLG.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txtTelfDLG.setPlaceholder("Teléfono");
        txtTelfDLG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelfDLGActionPerformed(evt);
            }
        });
        jPanel3.add(txtTelfDLG, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));
        jPanel3.add(txtFechaDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 250, 42));

        txt1erApeDLG.setForeground(new java.awt.Color(0, 0, 0));
        txt1erApeDLG.setToolTipText("Ingresa tu primer apellido");
        txt1erApeDLG.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txt1erApeDLG.setPlaceholder("Primer Apellido");
        txt1erApeDLG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1erApeDLGActionPerformed(evt);
            }
        });
        jPanel3.add(txt1erApeDLG, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        txt2doApeDLG.setForeground(new java.awt.Color(0, 0, 0));
        txt2doApeDLG.setToolTipText("Ingresa tu segundo apellido");
        txt2doApeDLG.setBordeColorFocus(new java.awt.Color(0, 102, 255));
        txt2doApeDLG.setPlaceholder("Segundo Apellido");
        txt2doApeDLG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2doApeDLGActionPerformed(evt);
            }
        });
        jPanel3.add(txt2doApeDLG, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        btnGrupo1.add(rdbMasculinoDlg);
        rdbMasculinoDlg.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        rdbMasculinoDlg.setForeground(new java.awt.Color(0, 51, 204));
        rdbMasculinoDlg.setText("Masculino");
        jPanel3.add(rdbMasculinoDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, 42));

        btnGrupo1.add(rdbFemeninoDlg);
        rdbFemeninoDlg.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        rdbFemeninoDlg.setForeground(new java.awt.Color(0, 51, 204));
        rdbFemeninoDlg.setText("Femenino");
        jPanel3.add(rdbFemeninoDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, 42));

        btnGrupo1.add(rdbOtroDlg);
        rdbOtroDlg.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        rdbOtroDlg.setForeground(new java.awt.Color(0, 51, 204));
        rdbOtroDlg.setText("Otro");
        rdbOtroDlg.setActionCommand("");
        jPanel3.add(rdbOtroDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, -1, 42));

        btnRetrocederDlgRegistro.setBackground(new java.awt.Color(255, 0, 0));
        btnRetrocederDlgRegistro.setText("Retroceder");
        btnRetrocederDlgRegistro.setToolTipText("Regresar al inicio de sesión");
        btnRetrocederDlgRegistro.setColorHover(new java.awt.Color(0, 0, 0));
        btnRetrocederDlgRegistro.setColorNormal(new java.awt.Color(255, 0, 0));
        btnRetrocederDlgRegistro.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnRetrocederDlgRegistro.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnRetrocederDlgRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederDlgRegistroActionPerformed(evt);
            }
        });
        jPanel3.add(btnRetrocederDlgRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 180, -1));

        btnSiguienteDlgUsu.setText("Siguiente");
        btnSiguienteDlgUsu.setToolTipText("Continua con tu registro");
        btnSiguienteDlgUsu.setColorHover(new java.awt.Color(0, 102, 204));
        btnSiguienteDlgUsu.setColorPressed(new java.awt.Color(0, 204, 51));
        btnSiguienteDlgUsu.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnSiguienteDlgUsu.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnSiguienteDlgUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteDlgUsuActionPerformed(evt);
            }
        });
        jPanel3.add(btnSiguienteDlgUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 180, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        lblTitulo.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel6.setText("Foto");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 140, 130));

        btnFoto.setBackground(new java.awt.Color(0, 153, 204));
        btnFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnFoto.setText("Agregar foto");
        jPanel3.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 140, -1));

        javax.swing.GroupLayout dlgPersonaLayout = new javax.swing.GroupLayout(dlgPersona.getContentPane());
        dlgPersona.getContentPane().setLayout(dlgPersonaLayout);
        dlgPersonaLayout.setHorizontalGroup(
            dlgPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgPersonaLayout.setVerticalGroup(
            dlgPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/wallhaven-4xj8l3.jpg"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 200));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("METE GOL GANA");

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inicio de Sesión");

        fSTexFieldMD1.setForeground(new java.awt.Color(0, 0, 0));
        fSTexFieldMD1.setToolTipText("Ingresa tu cédula");
        fSTexFieldMD1.setBordeColorFocus(new java.awt.Color(51, 102, 255));
        fSTexFieldMD1.setPlaceholder("Usuario");

        fSPasswordFieldMD1.setForeground(new java.awt.Color(0, 0, 0));
        fSPasswordFieldMD1.setToolTipText("Ingresa tu contraseña");
        fSPasswordFieldMD1.setBordeColorFocus(new java.awt.Color(51, 102, 255));
        fSPasswordFieldMD1.setPlaceholder("Contraseña ");

        jComboBox1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 102, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingresar Como:", "Jugador", "Entrenador", "Arbitro" }));
        jComboBox1.setToolTipText("Tipo de usuario");

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿Olvidaste tu contraseña?");
        jLabel2.setToolTipText("Restablece tu contraseña");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        fSButtonMD1.setBackground(new java.awt.Color(51, 102, 255));
        fSButtonMD1.setText("Ingresar");
        fSButtonMD1.setToolTipText("Inicia Sesión");
        fSButtonMD1.setColorNormal(new java.awt.Color(51, 102, 255));
        fSButtonMD1.setColorPressed(new java.awt.Color(51, 102, 255));
        fSButtonMD1.setColorTextHover(new java.awt.Color(51, 102, 255));
        fSButtonMD1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N

        fSButtonMD2.setText("Crear Cuenta");
        fSButtonMD2.setToolTipText("Inicia Sesión");
        fSButtonMD2.setColorHover(new java.awt.Color(102, 102, 102));
        fSButtonMD2.setColorNormal(new java.awt.Color(51, 204, 0));
        fSButtonMD2.setColorPressed(new java.awt.Color(51, 204, 0));
        fSButtonMD2.setColorTextHover(new java.awt.Color(255, 255, 255));
        fSButtonMD2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fSTexFieldMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fSPasswordFieldMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fSButtonMD1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fSButtonMD2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(fSTexFieldMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fSPasswordFieldMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(fSButtonMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fSButtonMD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        getContentPane().add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelfDLGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelfDLGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelfDLGActionPerformed

    private void txtDirecDLGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirecDLGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirecDLGActionPerformed

    private void btnSiguienteDlgUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteDlgUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteDlgUsuActionPerformed

    private void txt2doApeDLGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2doApeDLGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2doApeDLGActionPerformed

    private void txtCorreoDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoDlgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoDlgActionPerformed

    private void btnRetrocederDlgRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederDlgRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetrocederDlgRegistroActionPerformed

    private void txt1erApeDLGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1erApeDLGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1erApeDLGActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnFoto;
    public static javax.swing.ButtonGroup btnGrupo1;
    public static LIB.FSButtonMD btnRetrocederDlgRegistro;
    public static LIB.FSButtonMD btnSiguienteDlgUsu;
    public static javax.swing.JDialog dlgPersona;
    private LIB.FSButtonMD fSButtonMD1;
    private LIB.FSButtonMD fSButtonMD2;
    private LIB.FSPasswordFieldMD fSPasswordFieldMD1;
    private LIB.FSTexFieldMD fSTexFieldMD1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JLabel lblFoto;
    public static javax.swing.JLabel lblTitulo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public static javax.swing.JRadioButton rdbFemeninoDlg;
    public static javax.swing.JRadioButton rdbMasculinoDlg;
    public static javax.swing.JRadioButton rdbOtroDlg;
    public static LIB.FSTexFieldMD txt1erApeDLG;
    public static LIB.FSTexFieldMD txt1erNomDlg;
    public static LIB.FSTexFieldMD txt2doApeDLG;
    public static LIB.FSTexFieldMD txt2doNomDLG;
    public static LIB.FSTexFieldMD txtCedulaDLG;
    public static LIB.FSTexFieldMD txtCorreoDlg;
    public static LIB.FSTexFieldMD txtDirecDLG;
    public static com.toedter.calendar.JDateChooser txtFechaDlg;
    public static LIB.FSTexFieldMD txtTelfDLG;
    // End of variables declaration//GEN-END:variables
}

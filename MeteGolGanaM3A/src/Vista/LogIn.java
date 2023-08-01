/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import LIB.FSButtonMD;
import LIB.FSPasswordFieldMD;
import LIB.FSTexFieldMD;
import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.edisoncor.gui.panel.PanelImage;

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

    public JComboBox<String> getCbxRegistrarComo() {
        return cbxRegistrarComo;
    }

    public void setCbxRegistrarComo(JComboBox<String> cbxRegistrarComo) {
        this.cbxRegistrarComo = cbxRegistrarComo;
    }

    public JDialog getDlgCombo() {
        return dlgCombo;
    }

    public void setDlgCombo(JDialog dlgCombo) {
        this.dlgCombo = dlgCombo;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public FSButtonMD getBtnCrearCuenta() {
        return btnCrearCuenta;
    }

    public void setBtnCrearCuenta(FSButtonMD btnCrearCuenta) {
        this.btnCrearCuenta = btnCrearCuenta;
    }

    public static JButton getBtnFoto() {
        return btnFoto;
    }

    public static void setBtnFoto(JButton btnFoto) {
        LogIn.btnFoto = btnFoto;
    }

    public static ButtonGroup getBtnGrupo1() {
        return btnGrupo1;
    }

    public static void setBtnGrupo1(ButtonGroup btnGrupo1) {
        LogIn.btnGrupo1 = btnGrupo1;
    }

    public FSButtonMD getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(FSButtonMD btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public static FSButtonMD getBtnRetrocederDlgRegistro() {
        return btnRetrocederDlgRegistro;
    }

    public static void setBtnRetrocederDlgRegistro(FSButtonMD btnRetrocederDlgRegistro) {
        LogIn.btnRetrocederDlgRegistro = btnRetrocederDlgRegistro;
    }

    public static FSButtonMD getBtnSiguienteDlgUsu() {
        return btnSiguienteDlgUsu;
    }

    public static void setBtnSiguienteDlgUsu(FSButtonMD btnSiguienteDlgUsu) {
        LogIn.btnSiguienteDlgUsu = btnSiguienteDlgUsu;
    }

    public static JDialog getDlgPersona() {
        return dlgPersona;
    }

    public static void setDlgPersona(JDialog dlgPersona) {
        LogIn.dlgPersona = dlgPersona;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public static JLabel getjLabel6() {
        return jLabel6;
    }

    public static void setjLabel6(JLabel jLabel6) {
        LogIn.jLabel6 = jLabel6;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public static JLabel getLblFoto() {
        return lblFoto;
    }

    public static void setLblFoto(JLabel lblFoto) {
        LogIn.lblFoto = lblFoto;
    }
    
    public static JLabel getLblTitulo() {
        return lblTitulo;
    }

    public static void setLblTitulo(JLabel lblTitulo) {
        LogIn.lblTitulo = lblTitulo;
    }

    public PanelImage getPanelImage1() {
        return panelImage1;
    }

    public void setPanelImage1(PanelImage panelImage1) {
        this.panelImage1 = panelImage1;
    }

    public static JRadioButton getRdbFemeninoDlg() {
        return rdbFemeninoDlg;
    }

    public static void setRdbFemeninoDlg(JRadioButton rdbFemeninoDlg) {
        LogIn.rdbFemeninoDlg = rdbFemeninoDlg;
    }

    public static JRadioButton getRdbMasculinoDlg() {
        return rdbMasculinoDlg;
    }

    public static void setRdbMasculinoDlg(JRadioButton rdbMasculinoDlg) {
        LogIn.rdbMasculinoDlg = rdbMasculinoDlg;
    }

    public static JRadioButton getRdbOtroDlg() {
        return rdbOtroDlg;
    }

    public static void setRdbOtroDlg(JRadioButton rdbOtroDlg) {
        LogIn.rdbOtroDlg = rdbOtroDlg;
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

    public FSPasswordFieldMD getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(FSPasswordFieldMD txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JTextField getTxtRuta() {
        return txtRuta;
    }

    public void setTxtRuta(JTextField txtRuta) {
        this.txtRuta = txtRuta;
    }

    public static FSTexFieldMD getTxtTelfDLG() {
        return txtTelfDLG;
    }

    public static void setTxtTelfDLG(FSTexFieldMD txtTelfDLG) {
        LogIn.txtTelfDLG = txtTelfDLG;
    }

    public FSTexFieldMD getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(FSTexFieldMD txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JButton getBtnSiguienteCombo() {
        return btnSiguienteCombo;
    }

    public void setBtnSiguienteCombo(JButton btnSiguienteCombo) {
        this.btnSiguienteCombo = btnSiguienteCombo;
    }

    public JButton getBtnCancelarCombo() {
        return btnCancelarCombo;
    }

    public void setBtnCancelarCombo(JButton btnCancelarCombo) {
        this.btnCancelarCombo = btnCancelarCombo;
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
        txtRuta = new javax.swing.JTextField();
        btnGrupo1 = new javax.swing.ButtonGroup();
        dlgCombo = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        cbxRegistrarComo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSiguienteCombo = new javax.swing.JButton();
        btnCancelarCombo = new javax.swing.JButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new LIB.FSTexFieldMD();
        txtPassword = new LIB.FSPasswordFieldMD();
        btnIngresar = new LIB.FSButtonMD();
        btnCrearCuenta = new LIB.FSButtonMD();

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

        txtFechaDlg.setDateFormatString("yyyy-MM-dd");
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

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtRuta.setForeground(new java.awt.Color(255, 255, 255));
        txtRuta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 140, -1));

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

        dlgCombo.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        cbxRegistrarComo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrarse Como", "Jugador", "Entrenador", "Arbitro" }));

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipo de usuario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        btnSiguienteCombo.setBackground(new java.awt.Color(0, 153, 204));
        btnSiguienteCombo.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteCombo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/adelante.png"))); // NOI18N
        btnSiguienteCombo.setText("Siguiente");
        btnSiguienteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteComboActionPerformed(evt);
            }
        });

        btnCancelarCombo.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelarCombo.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCombo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/cancelar.png"))); // NOI18N
        btnCancelarCombo.setText("Cancelar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnSiguienteCombo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbxRegistrarComo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(cbxRegistrarComo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSiguienteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgComboLayout = new javax.swing.GroupLayout(dlgCombo.getContentPane());
        dlgCombo.getContentPane().setLayout(dlgComboLayout);
        dlgComboLayout.setHorizontalGroup(
            dlgComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgComboLayout.setVerticalGroup(
            dlgComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setToolTipText("Ingrese su email");
        txtUsuario.setBordeColorFocus(new java.awt.Color(51, 102, 255));
        txtUsuario.setPlaceholder("Ingrese su email");

        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setToolTipText("Ingrese su cedula");
        txtPassword.setBordeColorFocus(new java.awt.Color(51, 102, 255));
        txtPassword.setPlaceholder("Contraseña ");

        btnIngresar.setBackground(new java.awt.Color(51, 102, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("Inicia Sesión");
        btnIngresar.setColorNormal(new java.awt.Color(51, 102, 255));
        btnIngresar.setColorPressed(new java.awt.Color(51, 102, 255));
        btnIngresar.setColorTextHover(new java.awt.Color(51, 102, 255));
        btnIngresar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N

        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.setToolTipText("Inicia Sesión");
        btnCrearCuenta.setColorHover(new java.awt.Color(102, 102, 102));
        btnCrearCuenta.setColorNormal(new java.awt.Color(51, 204, 0));
        btnCrearCuenta.setColorPressed(new java.awt.Color(51, 204, 0));
        btnCrearCuenta.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N

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
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
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

    private void btnSiguienteComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteComboActionPerformed

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
    private javax.swing.JButton btnCancelarCombo;
    private LIB.FSButtonMD btnCrearCuenta;
    public static javax.swing.JButton btnFoto;
    public static javax.swing.ButtonGroup btnGrupo1;
    private LIB.FSButtonMD btnIngresar;
    public static LIB.FSButtonMD btnRetrocederDlgRegistro;
    private javax.swing.JButton btnSiguienteCombo;
    public static LIB.FSButtonMD btnSiguienteDlgUsu;
    private javax.swing.JComboBox<String> cbxRegistrarComo;
    private javax.swing.JDialog dlgCombo;
    public static javax.swing.JDialog dlgPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
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
    private LIB.FSPasswordFieldMD txtPassword;
    private javax.swing.JTextField txtRuta;
    public static LIB.FSTexFieldMD txtTelfDLG;
    private LIB.FSTexFieldMD txtUsuario;
    // End of variables declaration//GEN-END:variables
}

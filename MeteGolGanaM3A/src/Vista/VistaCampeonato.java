/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import LIB.FSButtonMD;
import LIB.FSTexFieldMD;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.JTable;


public class VistaCampeonato extends javax.swing.JInternalFrame {

    
    public VistaCampeonato() {
        initComponents();
    }

    public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public static void setBtnAgregar(JButton btnAgregar) {
        VistaCampeonato.btnAgregar = btnAgregar;
    }

    public static FSButtonMD getBtnCancelarDlg() {
        return btnCancelarDlg;
    }

    public static void setBtnCancelarDlg(FSButtonMD btnCancelarDlg) {
        VistaCampeonato.btnCancelarDlg = btnCancelarDlg;
    }
    
    

    public static JButton getBtnEliminar() {
        return btnEliminar;
    }

    public static void setBtnEliminar(JButton btnEliminar) {
        VistaCampeonato.btnEliminar = btnEliminar;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public static void setBtnInicio(FSButtonMD btnInicio) {
        VistaCampeonato.btnInicio = btnInicio;
    }

    public static JButton getBtnModificar() {
        return btnModificar;
    }

    public static void setBtnModificar(JButton btnModificar) {
        VistaCampeonato.btnModificar = btnModificar;
    }

    public static FSButtonMD getBtnRegistrarModificarDlg() {
        return btnRegistrarModificarDlg;
    }

    public static void setBtnRegistrarModificarDlg(FSButtonMD btnRegistrarModificarDlg) {
        VistaCampeonato.btnRegistrarModificarDlg = btnRegistrarModificarDlg;
    }

    public JComboBox<String> getCbxTipoCampeonato() {
        return cbxTipoCampeonato;
    }

    public void setCbxTipoCampeonato(JComboBox<String> cbxTipoCampeonato) {
        this.cbxTipoCampeonato = cbxTipoCampeonato;
    }

    public static JDialog getDlgCampeonatos() {
        return dlgCampeonatos;
    }

    public static void setDlgCampeonatos(JDialog dlgCampeonatos) {
        VistaCampeonato.dlgCampeonatos = dlgCampeonatos;
    }

   

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public static JButton getBtnBuscar() {
        return btnBuscar;
    }

    public static void setBtnBuscar(JButton btnBuscar) {
        VistaCampeonato.btnBuscar = btnBuscar;
    }



    public JLabel getLblReMoJugadores() {
        return lblReMoJugadores;
    }

    public void setLblReMoJugadores(JLabel lblReMoJugadores) {
        this.lblReMoJugadores = lblReMoJugadores;
    }

    public JSpinner getSpnMaxEqipo() {
        return spnMaxEqipo;
    }

    public static JButton getBtnLimpiarBuscar() {
        return btnLimpiarBuscar;
    }

    public static void setBtnLimpiarBuscar(JButton btnLimpiarBuscar) {
        VistaCampeonato.btnLimpiarBuscar = btnLimpiarBuscar;
    }
    
    

    public void setSpnMaxEqipo(JSpinner spnMaxEqipo) {
        this.spnMaxEqipo = spnMaxEqipo;
    }

    public static JTable getTblCampeonato() {
        return tblCampeonato;
    }

    public static void setTblCampeonato(JTable tblCampeonato) {
        VistaCampeonato.tblCampeonato = tblCampeonato;
    }

    public static FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public static void setTxtBuscar(FSTexFieldMD txtBuscar) {
        VistaCampeonato.txtBuscar = txtBuscar;
    }


    public static FSTexFieldMD getTxtNombre() {
        return txtNombre;
    }

    public static FSButtonMD getBtnLimpiarDlg() {
        return btnLimpiarDlg;
    }

    public static void setBtnLimpiarDlg(FSButtonMD btnLimpiarDlg) {
        VistaCampeonato.btnLimpiarDlg = btnLimpiarDlg;
    }

    public static void setTxtNombre(FSTexFieldMD txtNombre) {
        VistaCampeonato.txtNombre = txtNombre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgCampeonatos = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblReMoJugadores = new javax.swing.JLabel();
        txtNombre = new LIB.FSTexFieldMD();
        btnCancelarDlg = new LIB.FSButtonMD();
        btnRegistrarModificarDlg = new LIB.FSButtonMD();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoCampeonato = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spnMaxEqipo = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        btnLimpiarDlg = new LIB.FSButtonMD();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();
        txtBuscar = new LIB.FSTexFieldMD();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCampeonato = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiarBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        dlgCampeonatos.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        lblReMoJugadores.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblReMoJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoJugadores.setText("REGISTRAR CAMPEONATO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtNombre.setPlaceholder("Nombre del campeonato");
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 200, -1));

        btnCancelarDlg.setText("Cancelar");
        btnCancelarDlg.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelarDlg.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelarDlg.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnCancelarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 190, -1));

        btnRegistrarModificarDlg.setText("Registrar");
        btnRegistrarModificarDlg.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificarDlg.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificarDlg.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnRegistrarModificarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 190, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setText("Número Máximo de Equipos");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        cbxTipoCampeonato.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        cbxTipoCampeonato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona:", "Fútbol sala", "Fútbol 6 vs 6", "Fúbol 7 vs 7", "Fútball 12 vs 12", " " }));
        jPanel3.add(cbxTipoCampeonato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 200, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setText("Tipo de Campeonato");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        spnMaxEqipo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        spnMaxEqipo.setModel(new javax.swing.SpinnerNumberModel(2, 2, 20, 1));
        jPanel3.add(spnMaxEqipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/campeonatoremovebg400x390.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        btnLimpiarDlg.setText("Limpiar");
        btnLimpiarDlg.setToolTipText("Limpiar los campos de texto");
        btnLimpiarDlg.setColorNormal(new java.awt.Color(0, 102, 255));
        btnLimpiarDlg.setColorPressed(new java.awt.Color(0, 204, 51));
        btnLimpiarDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDlgActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 190, -1));

        javax.swing.GroupLayout dlgCampeonatosLayout = new javax.swing.GroupLayout(dlgCampeonatos.getContentPane());
        dlgCampeonatos.getContentPane().setLayout(dlgCampeonatosLayout);
        dlgCampeonatosLayout.setHorizontalGroup(
            dlgCampeonatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgCampeonatosLayout.setVerticalGroup(
            dlgCampeonatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Campeonatos");

        btnInicio.setBackground(new java.awt.Color(0, 102, 204));
        btnInicio.setText("Pagina Principal");
        btnInicio.setColorHover(new java.awt.Color(0, 102, 204));
        btnInicio.setColorNormal(new java.awt.Color(0, 102, 204));
        btnInicio.setColorPressed(new java.awt.Color(0, 102, 204));
        btnInicio.setColorTextHover(new java.awt.Color(204, 204, 204));
        btnInicio.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setToolTipText("Ingrese una cedula o nombre");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("Buscar campeonato");

        btnAgregar.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/boton.png"))); // NOI18N
        btnAgregar.setText("Crear nuevo");
        btnAgregar.setToolTipText("Registrar un nuevo jugador");

        tblCampeonato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Campeonato", "Nombre Campeonato", "Tipo de Campeonato", "Número de Equipos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCampeonato);

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Registrar un nuevo jugador");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contenedor-de-basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Registrar un nuevo jugador");

        btnBuscar.setBackground(new java.awt.Color(0, 153, 0));
        btnBuscar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar40x40.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Registrar un nuevo jugador");

        btnLimpiarBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarBuscar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnLimpiarBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/limpiar32.png"))); // NOI18N
        btnLimpiarBuscar.setText("Limpiar");
        btnLimpiarBuscar.setToolTipText("Limpiar campos de texto y actualizar tablas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiarBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDlgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarDlgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnBuscar;
    public static LIB.FSButtonMD btnCancelarDlg;
    public static javax.swing.JButton btnEliminar;
    public static LIB.FSButtonMD btnInicio;
    public static javax.swing.JButton btnLimpiarBuscar;
    public static LIB.FSButtonMD btnLimpiarDlg;
    public static javax.swing.JButton btnModificar;
    public static LIB.FSButtonMD btnRegistrarModificarDlg;
    private javax.swing.JComboBox<String> cbxTipoCampeonato;
    public static javax.swing.JDialog dlgCampeonatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReMoJugadores;
    private javax.swing.JSpinner spnMaxEqipo;
    public static javax.swing.JTable tblCampeonato;
    public static LIB.FSTexFieldMD txtBuscar;
    public static LIB.FSTexFieldMD txtNombre;
    // End of variables declaration//GEN-END:variables
}

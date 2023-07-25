
package Vista;

import LIB.FSButtonMD;
import LIB.FSTexFieldMD;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;

public class VistaEstadios extends javax.swing.JInternalFrame {

    public VistaEstadios() {
        initComponents();
    }

    public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public static void setBtnAgregar(JButton btnAgregar) {
        VistaEstadios.btnAgregar = btnAgregar;
    }

    public FSButtonMD getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(FSButtonMD btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public static JButton getBtnEliminar() {
        return btnEliminar;
    }

    public static void setBtnEliminar(JButton btnEliminar) {
        VistaEstadios.btnEliminar = btnEliminar;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public static void setBtnInicio(FSButtonMD btnInicio) {
        VistaEstadios.btnInicio = btnInicio;
    }

    public static JButton getBtnModificar() {
        return btnModificar;
    }

    public static void setBtnModificar(JButton btnModificar) {
        VistaEstadios.btnModificar = btnModificar;
    }

    public FSButtonMD getBtnRegistrarModificar() {
        return btnRegistrarModificar;
    }

    public void setBtnRegistrarModificar(FSButtonMD btnRegistrarModificar) {
        this.btnRegistrarModificar = btnRegistrarModificar;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JComboBox<String> getCbxNombreEquipo() {
        return cbxNombreEquipo;
    }

    public void setCbxNombreEquipo(JComboBox<String> cbxNombreEquipo) {
        this.cbxNombreEquipo = cbxNombreEquipo;
    }

    public static JDialog getDialogRegistrarModificar() {
        return dialogRegistrarModificar;
    }

    public static void setDialogRegistrarModificar(JDialog dialogRegistrarModificar) {
        VistaEstadios.dialogRegistrarModificar = dialogRegistrarModificar;
    }

    public JLabel getLblReMoJugadores() {
        return lblReMoJugadores;
    }

    public void setLblReMoJugadores(JLabel lblReMoJugadores) {
        this.lblReMoJugadores = lblReMoJugadores;
    }

    public static JTable getTblEstadios() {
        return tblEstadios;
    }

    public static void setTblEstadios(JTable tblEstadios) {
        VistaEstadios.tblEstadios = tblEstadios;
    }

    public JTable getTblEstadios1() {
        return tblEstadios1;
    }

    public void setTblEstadios1(JTable tblEstadios1) {
        this.tblEstadios1 = tblEstadios1;
    }

    public FSTexFieldMD getTxtAforoEst() {
        return txtAforoEst;
    }

    public void setTxtAforoEst(FSTexFieldMD txtAforoEst) {
        this.txtAforoEst = txtAforoEst;
    }

    public static FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public static void setTxtBuscar(FSTexFieldMD txtBuscar) {
        VistaEstadios.txtBuscar = txtBuscar;
    }

    public FSTexFieldMD getTxtCodigoEst() {
        return txtCodigoEst;
    }

    public void setTxtCodigoEst(FSTexFieldMD txtCodigoEst) {
        this.txtCodigoEst = txtCodigoEst;
    }

    public FSTexFieldMD getTxtNombreEst() {
        return txtNombreEst;
    }

    public void setTxtNombreEst(FSTexFieldMD txtNombreEst) {
        this.txtNombreEst = txtNombreEst;
    }

    public FSTexFieldMD getTxtUbicacionEst() {
        return txtUbicacionEst;
    }

    public void setTxtUbicacionEst(FSTexFieldMD txtUbicacionEst) {
        this.txtUbicacionEst = txtUbicacionEst;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogRegistrarModificar = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblReMoJugadores = new javax.swing.JLabel();
        txtCodigoEst = new LIB.FSTexFieldMD();
        txtNombreEst = new LIB.FSTexFieldMD();
        txtAforoEst = new LIB.FSTexFieldMD();
        cbxNombreEquipo = new javax.swing.JComboBox<>();
        txtUbicacionEst = new LIB.FSTexFieldMD();
        btnCancelar = new LIB.FSButtonMD();
        btnRegistrarModificar = new LIB.FSButtonMD();
        jPanel5 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEstadios1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();
        txtBuscar = new LIB.FSTexFieldMD();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstadios = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        dialogRegistrarModificar.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        lblReMoJugadores.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblReMoJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoJugadores.setText("REGISTRAR ESTADIOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtCodigoEst.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoEst.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodigoEst.setPlaceholder("Codigo");
        jPanel3.add(txtCodigoEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, -1));

        txtNombreEst.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreEst.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtNombreEst.setPlaceholder("Nombre Estadio");
        jPanel3.add(txtNombreEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, -1));

        txtAforoEst.setForeground(new java.awt.Color(0, 0, 0));
        txtAforoEst.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtAforoEst.setPlaceholder("Aforo Estadio");
        jPanel3.add(txtAforoEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 210, -1));

        cbxNombreEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Posicion", "Portero", "Defensa Central", "Defensa Lateral", "Centro Campista Defensivo", "Centro Campista Ofensivo", "Delantero Lateral", "Centrodelantero" }));
        jPanel3.add(cbxNombreEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 200, 32));

        txtUbicacionEst.setForeground(new java.awt.Color(0, 0, 0));
        txtUbicacionEst.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtUbicacionEst.setPlaceholder("Ubicacion Estadio");
        jPanel3.add(txtUbicacionEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, -1, -1));

        btnRegistrarModificar.setText("Registrar");
        btnRegistrarModificar.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificar.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificar.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnRegistrarModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, -1));

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

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 130));

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar foto");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 140, -1));

        tblEstadios1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblEstadios1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Aforo", "Ubicacion", "Nombre Equipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEstadios1);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 530, 170));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre de Equipo dueño de Estadio");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Foto Estadio");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tabla de Estadio:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jRadioButton1.setText("Falso");
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        jRadioButton2.setText("Verdadero");
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Eliminacion de Estadio:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        javax.swing.GroupLayout dialogRegistrarModificarLayout = new javax.swing.GroupLayout(dialogRegistrarModificar.getContentPane());
        dialogRegistrarModificar.getContentPane().setLayout(dialogRegistrarModificarLayout);
        dialogRegistrarModificarLayout.setHorizontalGroup(
            dialogRegistrarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        dialogRegistrarModificarLayout.setVerticalGroup(
            dialogRegistrarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
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
        jLabel1.setText("Estadios");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setToolTipText("Ingrese una cedula o nombre");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("Buscar Estadio");

        btnAgregar.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/boton.png"))); // NOI18N
        btnAgregar.setText("Crear nuevo");
        btnAgregar.setToolTipText("Registrar un nuevo jugador");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblEstadios.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblEstadios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Aforo", "Ubicacion", "Nombre Equipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEstadios);

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Registrar un nuevo jugador");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contenedor-de-basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Registrar un nuevo jugador");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
//        this.dispose();
//        RegistroEstadio re = new RegistroEstadio();
//        re.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
//        this.dispose();
//        RegistroEstadio re = new RegistroEstadio();
//        re.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

//    public JButton getBtnEstadios() {
//        return btnEstadios;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static LIB.FSButtonMD btnInicio;
    public static javax.swing.JButton btnModificar;
    private LIB.FSButtonMD btnRegistrarModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxNombreEquipo;
    public static javax.swing.JDialog dialogRegistrarModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblReMoJugadores;
    public static javax.swing.JTable tblEstadios;
    private javax.swing.JTable tblEstadios1;
    private LIB.FSTexFieldMD txtAforoEst;
    public static LIB.FSTexFieldMD txtBuscar;
    private LIB.FSTexFieldMD txtCodigoEst;
    private LIB.FSTexFieldMD txtNombreEst;
    private LIB.FSTexFieldMD txtUbicacionEst;
    // End of variables declaration//GEN-END:variables
}

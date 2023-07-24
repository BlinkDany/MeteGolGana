/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import LIB.FSButtonMD;
import LIB.FSTexFieldMD;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class VistaPartido extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vista
     */
    public VistaPartido() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogRegistrarModificar = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblReMoJugadores = new javax.swing.JLabel();
        txtEquipo1 = new LIB.FSTexFieldMD();
        txtEstadio = new LIB.FSTexFieldMD();
        txtEquipo2 = new LIB.FSTexFieldMD();
        btnCancelar = new LIB.FSButtonMD();
        btnRegistrarModificar = new LIB.FSButtonMD();
        txtCampeonato = new LIB.FSTexFieldMD();
        btnEstadio = new LIB.FSButtonMD();
        btnEquipo1 = new LIB.FSButtonMD();
        btnTemporada = new LIB.FSButtonMD();
        btnEquipo2 = new LIB.FSButtonMD();
        txtCodPartido = new LIB.FSTexFieldMD();
        txtgrupo = new LIB.FSTexFieldMD();
        dtfecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cmestado = new javax.swing.JComboBox<>();
        dialogtablas = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblbusqueda = new javax.swing.JLabel();
        txtbuscarcod = new LIB.FSTexFieldMD();
        btnCancelar1 = new LIB.FSButtonMD();
        btnmandardatos = new LIB.FSButtonMD();
        btnBuscar = new LIB.FSButtonMD();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbuscar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();
        txtBuscar = new LIB.FSTexFieldMD();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        dialogRegistrarModificar.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        lblReMoJugadores.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblReMoJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoJugadores.setText("Registro o Modificar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtEquipo1.setForeground(new java.awt.Color(0, 0, 0));
        txtEquipo1.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtEquipo1.setPlaceholder("Equipo1");
        jPanel3.add(txtEquipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 300, -1));

        txtEstadio.setForeground(new java.awt.Color(0, 0, 0));
        txtEstadio.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtEstadio.setPlaceholder("Estadio");
        jPanel3.add(txtEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 300, -1));

        txtEquipo2.setForeground(new java.awt.Color(0, 0, 0));
        txtEquipo2.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtEquipo2.setPlaceholder("Equipo2");
        jPanel3.add(txtEquipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 300, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, -1, -1));

        btnRegistrarModificar.setText("Registrar");
        btnRegistrarModificar.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificar.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificar.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnRegistrarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, -1, -1));

        txtCampeonato.setForeground(new java.awt.Color(0, 0, 0));
        txtCampeonato.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCampeonato.setPlaceholder("Temporada");
        txtCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampeonatoActionPerformed(evt);
            }
        });
        jPanel3.add(txtCampeonato, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 300, -1));

        btnEstadio.setBackground(new java.awt.Color(204, 204, 204));
        btnEstadio.setText("Buscar Estadio");
        btnEstadio.setColorHover(new java.awt.Color(0, 0, 0));
        btnEstadio.setColorNormal(new java.awt.Color(204, 204, 204));
        btnEstadio.setColorPressed(new java.awt.Color(204, 204, 204));
        btnEstadio.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, -1, -1));

        btnEquipo1.setBackground(new java.awt.Color(204, 204, 204));
        btnEquipo1.setText("Buscar Equipo");
        btnEquipo1.setColorHover(new java.awt.Color(0, 0, 0));
        btnEquipo1.setColorNormal(new java.awt.Color(204, 204, 204));
        btnEquipo1.setColorPressed(new java.awt.Color(204, 204, 204));
        btnEquipo1.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnEquipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        btnTemporada.setText("Buscar Temporada");
        btnTemporada.setColorHover(new java.awt.Color(0, 0, 0));
        btnTemporada.setColorNormal(new java.awt.Color(204, 204, 204));
        btnTemporada.setColorPressed(new java.awt.Color(204, 204, 204));
        btnTemporada.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemporadaActionPerformed(evt);
            }
        });
        jPanel3.add(btnTemporada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, -1, -1));

        btnEquipo2.setBackground(new java.awt.Color(204, 204, 204));
        btnEquipo2.setText("Buscar Equipo");
        btnEquipo2.setColorHover(new java.awt.Color(0, 0, 0));
        btnEquipo2.setColorNormal(new java.awt.Color(204, 204, 204));
        btnEquipo2.setColorPressed(new java.awt.Color(204, 204, 204));
        btnEquipo2.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnEquipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, -1, -1));

        txtCodPartido.setForeground(new java.awt.Color(0, 0, 0));
        txtCodPartido.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodPartido.setPlaceholder("CodigoPartido");
        txtCodPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPartidoActionPerformed(evt);
            }
        });
        jPanel3.add(txtCodPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 300, -1));

        txtgrupo.setForeground(new java.awt.Color(0, 0, 0));
        txtgrupo.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtgrupo.setPlaceholder("Grupo");
        jPanel3.add(txtgrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 300, -1));

        dtfecha.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(dtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 310, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel5.setText("Fecha Partido");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        cmestado.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        cmestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Activo", "Finalizado", "Suspendido", "En Espera" }));
        cmestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmestadoActionPerformed(evt);
            }
        });
        jPanel3.add(cmestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 300, 40));

        javax.swing.GroupLayout dialogRegistrarModificarLayout = new javax.swing.GroupLayout(dialogRegistrarModificar.getContentPane());
        dialogRegistrarModificar.getContentPane().setLayout(dialogRegistrarModificarLayout);
        dialogRegistrarModificarLayout.setHorizontalGroup(
            dialogRegistrarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogRegistrarModificarLayout.setVerticalGroup(
            dialogRegistrarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );

        dialogtablas.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        lblbusqueda.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblbusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblbusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbusqueda.setText("tabla");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblbusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtbuscarcod.setForeground(new java.awt.Color(0, 0, 0));
        txtbuscarcod.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtbuscarcod.setPlaceholder("Codigo");
        txtbuscarcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarcodActionPerformed(evt);
            }
        });
        jPanel5.add(txtbuscarcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 440, -1));

        btnCancelar1.setText("Cancelar");
        btnCancelar1.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar1.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar1.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel5.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, -1, -1));

        btnmandardatos.setText("Guardar");
        btnmandardatos.setColorHover(new java.awt.Color(0, 102, 204));
        btnmandardatos.setColorPressed(new java.awt.Color(0, 204, 51));
        btnmandardatos.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnmandardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmandardatosActionPerformed(evt);
            }
        });
        jPanel5.add(btnmandardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setText("Buscar");
        btnBuscar.setColorHover(new java.awt.Color(0, 0, 0));
        btnBuscar.setColorNormal(new java.awt.Color(204, 204, 204));
        btnBuscar.setColorPressed(new java.awt.Color(204, 204, 204));
        btnBuscar.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        tblbuscar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        tblbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblbuscar);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 760, 290));

        javax.swing.GroupLayout dialogtablasLayout = new javax.swing.GroupLayout(dialogtablas.getContentPane());
        dialogtablas.getContentPane().setLayout(dialogtablasLayout);
        dialogtablasLayout.setHorizontalGroup(
            dialogtablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        dialogtablasLayout.setVerticalGroup(
            dialogtablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        tblPartidos.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CodigoPartido", "CodigoEstadio", "CodigoTemporada", "Fecha", "Grupo", "Estado", "Equipo1", "Equipo2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPartidos);

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

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PARTIDO");

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
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(655, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setToolTipText("Ingrese el Codigo del Partido");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("BuscarPartido");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
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
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarModificarActionPerformed

    private void txtCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampeonatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampeonatoActionPerformed

    private void btnTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemporadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTemporadaActionPerformed

    private void cmestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmestadoActionPerformed

    private void txtbuscarcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarcodActionPerformed

    private void btnmandardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmandardatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmandardatosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtCodPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPartidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodPartidoActionPerformed

  public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public static void setBtnAgregar(JButton btnAgregar) {
        VistaPartido.btnAgregar = btnAgregar;
    }

    public FSButtonMD getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(FSButtonMD btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public static FSButtonMD getBtnCancelar() {
        return btnCancelar;
    }

    public static void setBtnCancelar(FSButtonMD btnCancelar) {
        VistaPartido.btnCancelar = btnCancelar;
    }

    public static FSButtonMD getBtnCancelar1() {
        return btnCancelar1;
    }

    public static void setBtnCancelar1(FSButtonMD btnCancelar1) {
        VistaPartido.btnCancelar1 = btnCancelar1;
    }

    public static JButton getBtnEliminar() {
        return btnEliminar;
    }

    public static void setBtnEliminar(JButton btnEliminar) {
        VistaPartido.btnEliminar = btnEliminar;
    }

    public FSButtonMD getBtnEquipo1() {
        return btnEquipo1;
    }

    public void setBtnEquipo1(FSButtonMD btnEquipo1) {
        this.btnEquipo1 = btnEquipo1;
    }

    public FSButtonMD getBtnEquipo2() {
        return btnEquipo2;
    }

    public void setBtnEquipo2(FSButtonMD btnEquipo2) {
        this.btnEquipo2 = btnEquipo2;
    }

    public FSButtonMD getBtnEstadio() {
        return btnEstadio;
    }

    public void setBtnEstadio(FSButtonMD btnEstadio) {
        this.btnEstadio = btnEstadio;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public static void setBtnInicio(FSButtonMD btnInicio) {
        VistaPartido.btnInicio = btnInicio;
    }

    public static JButton getBtnModificar() {
        return btnModificar;
    }

    public static void setBtnModificar(JButton btnModificar) {
        VistaPartido.btnModificar = btnModificar;
    }

    public static FSButtonMD getBtnRegistrarModificar() {
        return btnRegistrarModificar;
    }

    public static void setBtnRegistrarModificar(FSButtonMD btnRegistrarModificar) {
        VistaPartido.btnRegistrarModificar = btnRegistrarModificar;
    }

    public FSButtonMD getBtnTemporada() {
        return btnTemporada;
    }

    public void setBtnTemporada(FSButtonMD btnTemporada) {
        this.btnTemporada = btnTemporada;
    }

    public static FSButtonMD getBtnmandardatos() {
        return btnmandardatos;
    }

    public static void setBtnmandardatos(FSButtonMD btnmandardatos) {
        VistaPartido.btnmandardatos = btnmandardatos;
    }

    public static JDialog getDialogRegistrarModificar() {
        return dialogRegistrarModificar;
    }

    public static void setDialogRegistrarModificar(JDialog dialogRegistrarModificar) {
        VistaPartido.dialogRegistrarModificar = dialogRegistrarModificar;
    }

    public static JDialog getDialogtablas() {
        return dialogtablas;
    }

    public static void setDialogtablas(JDialog dialogtablas) {
        VistaPartido.dialogtablas = dialogtablas;
    }

    public JDateChooser getDtfecha() {
        return dtfecha;
    }

    public void setDtfecha(JDateChooser dtfecha) {
        this.dtfecha = dtfecha;
    }

    public JComboBox<String> getCmestado() {
        return cmestado;
    }

    public void setCmestado(JComboBox<String> cmestado) {
        this.cmestado = cmestado;
    }

    public JLabel getLblReMoJugadores() {
        return lblReMoJugadores;
    }

    public void setLblReMoJugadores(JLabel lblReMoJugadores) {
        this.lblReMoJugadores = lblReMoJugadores;
    }

    public JLabel getLblbusqueda() {
        return lblbusqueda;
    }

    public void setLblbusqueda(JLabel lblbusqueda) {
        this.lblbusqueda = lblbusqueda;
    }

    public static JTable getTblPartidos() {
        return tblPartidos;
    }

    public static void setTblPartidos(JTable tblPartidos) {
        VistaPartido.tblPartidos = tblPartidos;
    }

    public static JTable getTblbuscar() {
        return tblbuscar;
    }

    public static void setTblbuscar(JTable tblbuscar) {
        VistaPartido.tblbuscar = tblbuscar;
    }

    public static FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public static void setTxtBuscar(FSTexFieldMD txtBuscar) {
        VistaPartido.txtBuscar = txtBuscar;
    }

    public static FSTexFieldMD getTxtCampeonato() {
        return txtCampeonato;
    }

    public static void setTxtCampeonato(FSTexFieldMD txtCampeonato) {
        VistaPartido.txtCampeonato = txtCampeonato;
    }

    public FSTexFieldMD getTxtCodPartido() {
        return txtCodPartido;
    }

    public void setTxtCodPartido(FSTexFieldMD txtCodPartido) {
        this.txtCodPartido = txtCodPartido;
    }

 
    public static FSTexFieldMD getTxtEquipo1() {
        return txtEquipo1;
    }

    public static void setTxtEquipo1(FSTexFieldMD txtEquipo1) {
        VistaPartido.txtEquipo1 = txtEquipo1;
    }

    public static FSTexFieldMD getTxtEquipo2() {
        return txtEquipo2;
    }

    public static void setTxtEquipo2(FSTexFieldMD txtEquipo2) {
        VistaPartido.txtEquipo2 = txtEquipo2;
    }

    public static FSTexFieldMD getTxtEstadio() {
        return txtEstadio;
    }

    public static void setTxtEstadio(FSTexFieldMD txtEstadio) {
        VistaPartido.txtEstadio = txtEstadio;
    }

    public static FSTexFieldMD getTxtbuscarcod() {
        return txtbuscarcod;
    }

    public static void setTxtbuscarcod(FSTexFieldMD txtbuscarcod) {
        VistaPartido.txtbuscarcod = txtbuscarcod;
    }

    public static FSTexFieldMD getTxtgrupo() {
        return txtgrupo;
    }

    public static void setTxtgrupo(FSTexFieldMD txtgrupo) {
        VistaPartido.txtgrupo = txtgrupo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnBuscar;
    public static LIB.FSButtonMD btnCancelar;
    public static LIB.FSButtonMD btnCancelar1;
    public static javax.swing.JButton btnEliminar;
    private LIB.FSButtonMD btnEquipo1;
    private LIB.FSButtonMD btnEquipo2;
    private LIB.FSButtonMD btnEstadio;
    public static LIB.FSButtonMD btnInicio;
    public static javax.swing.JButton btnModificar;
    public static LIB.FSButtonMD btnRegistrarModificar;
    private LIB.FSButtonMD btnTemporada;
    public static LIB.FSButtonMD btnmandardatos;
    private javax.swing.JComboBox<String> cmestado;
    public static javax.swing.JDialog dialogRegistrarModificar;
    public static javax.swing.JDialog dialogtablas;
    private com.toedter.calendar.JDateChooser dtfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblReMoJugadores;
    private javax.swing.JLabel lblbusqueda;
    public static javax.swing.JTable tblPartidos;
    public static javax.swing.JTable tblbuscar;
    public static LIB.FSTexFieldMD txtBuscar;
    public static LIB.FSTexFieldMD txtCampeonato;
    private LIB.FSTexFieldMD txtCodPartido;
    public static LIB.FSTexFieldMD txtEquipo1;
    public static LIB.FSTexFieldMD txtEquipo2;
    public static LIB.FSTexFieldMD txtEstadio;
    public static LIB.FSTexFieldMD txtbuscarcod;
    public static LIB.FSTexFieldMD txtgrupo;
    // End of variables declaration//GEN-END:variables
}

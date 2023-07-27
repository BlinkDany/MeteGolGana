/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import LIB.FSButtonMD;
import LIB.FSTexFieldMD;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;
import javax.swing.JTable;

/**
 *
 * @author blink
 */
public class VistaTemporada extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaJugadores
     */
    public VistaTemporada() {
        initComponents();
    }

    public static JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public static void setBtnLimpiar(JButton btnLimpiar) {
        VistaTemporada.btnLimpiar = btnLimpiar;
    }
    
    

    public FSButtonMD getBtnBuscarCampeonato() {
        return btnBuscarCampeonato;
    }

    public void setBtnBuscarCampeonato(FSButtonMD btnBuscarCampeonato) {
        this.btnBuscarCampeonato = btnBuscarCampeonato;
    }

    public static FSTexFieldMD getTxtBuscarCampeonato() {
        return txtBuscarCampeonato;
    }

    public static void setTxtBuscarCampeonato(FSTexFieldMD txtBuscarCampeonato) {
        VistaTemporada.txtBuscarCampeonato = txtBuscarCampeonato;
    }
    
    

    public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public static void setBtnAgregar(JButton btnAgregar) {
        VistaTemporada.btnAgregar = btnAgregar;
    }

    public static FSButtonMD getBtnCancelarDlg() {
        return btnCancelarDlg;
    }

    public static void setBtnCancelarDlg(FSButtonMD btnCancelarDlg) {
        VistaTemporada.btnCancelarDlg = btnCancelarDlg;
    }

    public static JButton getBtnEliminar() {
        return btnEliminar;
    }

    public static void setBtnEliminar(JButton btnEliminar) {
        VistaTemporada.btnEliminar = btnEliminar;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public static void setBtnInicio(FSButtonMD btnInicio) {
        VistaTemporada.btnInicio = btnInicio;
    }

    public static JButton getBtnModificar() {
        return btnModificar;
    }

    public static void setBtnModificar(JButton btnModificar) {
        VistaTemporada.btnModificar = btnModificar;
    }

    public static FSButtonMD getBtnRegistrarModificarDlg() {
        return btnRegistrarModificarDlg;
    }

    public static void setBtnRegistrarModificarDlg(FSButtonMD btnRegistrarModificarDlg) {
        VistaTemporada.btnRegistrarModificarDlg = btnRegistrarModificarDlg;
    }

    public static FSButtonMD getBtnLimpiarDlg() {
        return btnLimpiarDlg;
    }

    public static void setBtnLimpiarDlg(FSButtonMD btnLimpiarDlg) {
        VistaTemporada.btnLimpiarDlg = btnLimpiarDlg;
    }
    
    

    public static JDialog getDlgaTemporada() {
        return dlgaTemporada;
    }

    public static void setDlgaTemporada(JDialog dlgaTemporada) {
        VistaTemporada.dlgaTemporada = dlgaTemporada;
    }

    public FSButtonMD getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(FSButtonMD btnBuscar) {
        this.btnBuscar = btnBuscar;
    }


    public JLabel getLblReMoJugadores() {
        return lblReMoJugadores;
    }

    public void setLblReMoJugadores(JLabel lblReMoJugadores) {
        this.lblReMoJugadores = lblReMoJugadores;
    }

    public JTable getTblCampeonatoFK() {
        return tblCampeonatoFK;
    }

    public void setTblCampeonatoFK(JTable tblCampeonatoFK) {
        this.tblCampeonatoFK = tblCampeonatoFK;
    }

    public static JTable getTblTemporada() {
        return tblTemporada;
    }

    public static void setTblTemporada(JTable tblTemporada) {
        VistaTemporada.tblTemporada = tblTemporada;
    }

    public static FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public static void setTxtBuscar(FSTexFieldMD txtBuscar) {
        VistaTemporada.txtBuscar = txtBuscar;
    }


    public static FSTexFieldMD getTxtCodigoCampeonatoFK() {
        return txtCodigoCampeonatoFK;
    }

    public static void setTxtCodigoCampeonatoFK(FSTexFieldMD txtCodigoCampeonatoFK) {
        VistaTemporada.txtCodigoCampeonatoFK = txtCodigoCampeonatoFK;
    }

    public JDateChooser getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(JDateChooser txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public JDateChooser getTxtFechaIni() {
        return txtFechaIni;
    }

    public void setTxtFechaIni(JDateChooser txtFechaIni) {
        this.txtFechaIni = txtFechaIni;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgaTemporada = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblReMoJugadores = new javax.swing.JLabel();
        txtCodigoCampeonatoFK = new LIB.FSTexFieldMD();
        btnCancelarDlg = new LIB.FSButtonMD();
        btnRegistrarModificarDlg = new LIB.FSButtonMD();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        txtFechaIni = new com.toedter.calendar.JDateChooser();
        btnLimpiarDlg = new LIB.FSButtonMD();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();
        txtBuscar = new LIB.FSTexFieldMD();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTemporada = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new LIB.FSButtonMD();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCampeonatoFK = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarCampeonato = new LIB.FSTexFieldMD();
        btnBuscarCampeonato = new LIB.FSButtonMD();
        btnLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        dlgaTemporada.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        lblReMoJugadores.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblReMoJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoJugadores.setText("REGISTRAR TEMPORADA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtCodigoCampeonatoFK.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoCampeonatoFK.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodigoCampeonatoFK.setPlaceholder("Código del campeonato");
        jPanel3.add(txtCodigoCampeonatoFK, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, -1));

        btnCancelarDlg.setText("Cancelar");
        btnCancelarDlg.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelarDlg.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelarDlg.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnCancelarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 200, -1));

        btnRegistrarModificarDlg.setText("Registrar");
        btnRegistrarModificarDlg.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificarDlg.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificarDlg.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnRegistrarModificarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 200, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setText("Fecha de Inicio");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de finalización");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtFechaFin.setToolTipText("Fecha de finalizacion de temporada");
        jPanel3.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, 40));

        txtFechaIni.setBackground(new java.awt.Color(0, 51, 255));
        txtFechaIni.setToolTipText("Fecha de inicio de temporada");
        jPanel3.add(txtFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 40));

        btnLimpiarDlg.setText("Limpiar");
        btnLimpiarDlg.setToolTipText("Limpiar los campos de texto");
        btnLimpiarDlg.setColorNormal(new java.awt.Color(0, 102, 255));
        btnLimpiarDlg.setColorPressed(new java.awt.Color(0, 204, 51));
        jPanel3.add(btnLimpiarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        javax.swing.GroupLayout dlgaTemporadaLayout = new javax.swing.GroupLayout(dlgaTemporada.getContentPane());
        dlgaTemporada.getContentPane().setLayout(dlgaTemporadaLayout);
        dlgaTemporadaLayout.setHorizontalGroup(
            dlgaTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgaTemporadaLayout.setVerticalGroup(
            dlgaTemporadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Temporadas");

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
        txtBuscar.setToolTipText("Ingrese el código de la temporada.");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("Buscar una temporada");

        btnAgregar.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/boton.png"))); // NOI18N
        btnAgregar.setText("Crear nuevo");
        btnAgregar.setToolTipText("Crear una nueva temporada");

        tblTemporada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código temporada", "Fecha de inicio", "Fecha de finalización", "Código del campeonato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTemporada);

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Primero elija la temporada ha modificar de la tabla");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contenedor-de-basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Primero elija la temporada ha eliminar de la tabla");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar40x40.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Ingrese el código de la temporada");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Tabla de Temporadas");

        tblCampeonatoFK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código campeonato", "Nombre", "Tipo de campeonato", "Cupo máximo de equipos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCampeonatoFK.setToolTipText("Lista de campeonatos disponibles");
        jScrollPane2.setViewportView(tblCampeonatoFK);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("Tabla de Campeonatos");

        txtBuscarCampeonato.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarCampeonato.setToolTipText("Ingrese el código de la temporada.");
        txtBuscarCampeonato.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscarCampeonato.setPlaceholder("Buscar un campeonato");
        txtBuscarCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCampeonatoActionPerformed(evt);
            }
        });

        btnBuscarCampeonato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar40x40.png"))); // NOI18N
        btnBuscarCampeonato.setText("Buscar");
        btnBuscarCampeonato.setToolTipText("Ingrese el código de la temporada");
        btnBuscarCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCampeonatoActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/limpiar32.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Limpiar campos de texto y actualizar tablas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnModificar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarCampeonato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarCampeonato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCampeonatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarCampeonatoActionPerformed

    private void txtBuscarCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCampeonatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCampeonatoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnBuscar;
    private LIB.FSButtonMD btnBuscarCampeonato;
    public static LIB.FSButtonMD btnCancelarDlg;
    public static javax.swing.JButton btnEliminar;
    public static LIB.FSButtonMD btnInicio;
    public static javax.swing.JButton btnLimpiar;
    public static LIB.FSButtonMD btnLimpiarDlg;
    public static javax.swing.JButton btnModificar;
    public static LIB.FSButtonMD btnRegistrarModificarDlg;
    public static javax.swing.JDialog dlgaTemporada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblReMoJugadores;
    private javax.swing.JTable tblCampeonatoFK;
    public static javax.swing.JTable tblTemporada;
    public static LIB.FSTexFieldMD txtBuscar;
    public static LIB.FSTexFieldMD txtBuscarCampeonato;
    public static LIB.FSTexFieldMD txtCodigoCampeonatoFK;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaIni;
    // End of variables declaration//GEN-END:variables
}

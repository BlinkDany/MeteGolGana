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

    public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public static void setBtnAgregar(JButton btnAgregar) {
        VistaTemporada.btnAgregar = btnAgregar;
    }

    public FSButtonMD getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(FSButtonMD btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public FSButtonMD getBtnBuscarCampeonatoDlg() {
        return btnBuscarCampeonatoDlg;
    }

    public void setBtnBuscarCampeonatoDlg(FSButtonMD btnBuscarCampeonatoDlg) {
        this.btnBuscarCampeonatoDlg = btnBuscarCampeonatoDlg;
    }

    public FSButtonMD getBtnCampeonato() {
        return btnCampeonato;
    }

    public void setBtnCampeonato(FSButtonMD btnCampeonato) {
        this.btnCampeonato = btnCampeonato;
    }

    public static FSButtonMD getBtnCancelar() {
        return btnCancelar;
    }

    public static void setBtnCancelar(FSButtonMD btnCancelar) {
        VistaTemporada.btnCancelar = btnCancelar;
    }

    public static FSButtonMD getBtnCancelarDlg2() {
        return btnCancelarDlg2;
    }

    public static void setBtnCancelarDlg2(FSButtonMD btnCancelarDlg2) {
        VistaTemporada.btnCancelarDlg2 = btnCancelarDlg2;
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

    public static JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public static void setBtnLimpiar(JButton btnLimpiar) {
        VistaTemporada.btnLimpiar = btnLimpiar;
    }

    public static FSButtonMD getBtnLimpiarDlg() {
        return btnLimpiarDlg;
    }

    public static void setBtnLimpiarDlg(FSButtonMD btnLimpiarDlg) {
        VistaTemporada.btnLimpiarDlg = btnLimpiarDlg;
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

    public static FSButtonMD getBtnmandardatos() {
        return btnmandardatos;
    }

    public static void setBtnmandardatos(FSButtonMD btnmandardatos) {
        VistaTemporada.btnmandardatos = btnmandardatos;
    }

    public JDialog getDlgCampeonato() {
        return dlgCampeonato;
    }

    public void setDlgCampeonato(JDialog dlgCampeonato) {
        this.dlgCampeonato = dlgCampeonato;
    }

    public static JDialog getDlgaTemporada() {
        return dlgaTemporada;
    }

    public static void setDlgaTemporada(JDialog dlgaTemporada) {
        VistaTemporada.dlgaTemporada = dlgaTemporada;
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

    public JTable getTblCampeonatoFK1() {
        return tblCampeonatoFK1;
    }

    public void setTblCampeonatoFK1(JTable tblCampeonatoFK1) {
        this.tblCampeonatoFK1 = tblCampeonatoFK1;
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

    public static FSTexFieldMD getTxtBuscarCampeonato1() {
        return txtBuscarCampeonato1;
    }

    public static void setTxtBuscarCampeonato1(FSTexFieldMD txtBuscarCampeonato1) {
        VistaTemporada.txtBuscarCampeonato1 = txtBuscarCampeonato1;
    }

    public static FSTexFieldMD getTxtCodigoCampeonatoFK() {
        return txtCodigoCampeonatoFK;
    }

    public static void setTxtCodigoCampeonatoFK(FSTexFieldMD txtCodigoCampeonatoFK) {
        VistaTemporada.txtCodigoCampeonatoFK = txtCodigoCampeonatoFK;
    }

    public static FSTexFieldMD getTxtCodigoPk() {
        return txtCodigoPk;
    }

    public static void setTxtCodigoPk(FSTexFieldMD txtCodigoPk) {
        VistaTemporada.txtCodigoPk = txtCodigoPk;
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
        txtCodigoPk = new LIB.FSTexFieldMD();
        btnCancelar = new LIB.FSButtonMD();
        btnRegistrarModificarDlg = new LIB.FSButtonMD();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        txtFechaIni = new com.toedter.calendar.JDateChooser();
        btnCampeonato = new LIB.FSButtonMD();
        btnLimpiarDlg = new LIB.FSButtonMD();
        txtCodigoCampeonatoFK = new LIB.FSTexFieldMD();
        jLabel2 = new javax.swing.JLabel();
        dlgCampeonato = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        btnBuscarCampeonatoDlg = new LIB.FSButtonMD();
        txtBuscarCampeonato1 = new LIB.FSTexFieldMD();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCampeonatoFK1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblbusqueda = new javax.swing.JLabel();
        btnmandardatos = new LIB.FSButtonMD();
        btnCancelarDlg2 = new LIB.FSButtonMD();
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
        btnLimpiar = new javax.swing.JButton();

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

        txtCodigoPk.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoPk.setToolTipText("Código temporada");
        txtCodigoPk.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodigoPk.setPlaceholder("Código Temporada");
        jPanel3.add(txtCodigoPk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 200, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 200, -1));

        btnRegistrarModificarDlg.setText("Registrar");
        btnRegistrarModificarDlg.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificarDlg.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificarDlg.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnRegistrarModificarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 200, -1));

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

        btnCampeonato.setText("Buscar Campeonato");
        btnCampeonato.setColorHover(new java.awt.Color(0, 0, 0));
        btnCampeonato.setColorNormal(new java.awt.Color(204, 204, 204));
        btnCampeonato.setColorPressed(new java.awt.Color(204, 204, 204));
        btnCampeonato.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCampeonatoActionPerformed(evt);
            }
        });
        jPanel3.add(btnCampeonato, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 200, -1));

        btnLimpiarDlg.setText("Limpiar");
        btnLimpiarDlg.setToolTipText("Limpiar los campos de texto");
        btnLimpiarDlg.setColorNormal(new java.awt.Color(0, 102, 255));
        btnLimpiarDlg.setColorPressed(new java.awt.Color(0, 204, 51));
        jPanel3.add(btnLimpiarDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        txtCodigoCampeonatoFK.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoCampeonatoFK.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodigoCampeonatoFK.setPlaceholder("Código del campeonato");
        jPanel3.add(txtCodigoCampeonatoFK, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/messy.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 460, 470));

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscarCampeonatoDlg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/buscar40x40.png"))); // NOI18N
        btnBuscarCampeonatoDlg.setText("Buscar");
        btnBuscarCampeonatoDlg.setToolTipText("Ingrese el código de la temporada");
        btnBuscarCampeonatoDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCampeonatoDlgActionPerformed(evt);
            }
        });

        txtBuscarCampeonato1.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarCampeonato1.setToolTipText("Ingrese el código de la temporada.");
        txtBuscarCampeonato1.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscarCampeonato1.setPlaceholder("Buscar un campeonato");
        txtBuscarCampeonato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCampeonato1ActionPerformed(evt);
            }
        });

        tblCampeonatoFK1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCampeonatoFK1.setToolTipText("Lista de campeonatos disponibles");
        jScrollPane3.setViewportView(tblCampeonatoFK1);

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Tabla de Campeonatos");

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        lblbusqueda.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblbusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblbusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbusqueda.setText("tabla");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnmandardatos.setText("Guardar");
        btnmandardatos.setColorHover(new java.awt.Color(0, 102, 204));
        btnmandardatos.setColorPressed(new java.awt.Color(0, 204, 51));
        btnmandardatos.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnmandardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmandardatosActionPerformed(evt);
            }
        });

        btnCancelarDlg2.setText("Cancelar");
        btnCancelarDlg2.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelarDlg2.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelarDlg2.setColorTextHover(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtBuscarCampeonato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCampeonatoDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelarDlg2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnmandardatos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarCampeonatoDlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarCampeonato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnmandardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarDlg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout dlgCampeonatoLayout = new javax.swing.GroupLayout(dlgCampeonato.getContentPane());
        dlgCampeonato.getContentPane().setLayout(dlgCampeonatoLayout);
        dlgCampeonatoLayout.setHorizontalGroup(
            dlgCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgCampeonatoLayout.setVerticalGroup(
            dlgCampeonatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Temporada");

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
                .addGap(110, 110, 110)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setToolTipText("Ingrese el código de la temporada.");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("Buscar una temporada");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar)
                                .addGap(0, 79, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarCampeonatoDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCampeonatoDlgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarCampeonatoDlgActionPerformed

    private void txtBuscarCampeonato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCampeonato1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCampeonato1ActionPerformed

    private void btnmandardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmandardatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmandardatosActionPerformed

    private void btnCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCampeonatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCampeonatoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnBuscar;
    private LIB.FSButtonMD btnBuscarCampeonatoDlg;
    private LIB.FSButtonMD btnCampeonato;
    public static LIB.FSButtonMD btnCancelar;
    public static LIB.FSButtonMD btnCancelarDlg2;
    public static javax.swing.JButton btnEliminar;
    public static LIB.FSButtonMD btnInicio;
    public static javax.swing.JButton btnLimpiar;
    public static LIB.FSButtonMD btnLimpiarDlg;
    public static javax.swing.JButton btnModificar;
    public static LIB.FSButtonMD btnRegistrarModificarDlg;
    public static LIB.FSButtonMD btnmandardatos;
    private javax.swing.JDialog dlgCampeonato;
    public static javax.swing.JDialog dlgaTemporada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblReMoJugadores;
    private javax.swing.JLabel lblbusqueda;
    private javax.swing.JTable tblCampeonatoFK1;
    public static javax.swing.JTable tblTemporada;
    public static LIB.FSTexFieldMD txtBuscar;
    public static LIB.FSTexFieldMD txtBuscarCampeonato1;
    public static LIB.FSTexFieldMD txtCodigoCampeonatoFK;
    public static LIB.FSTexFieldMD txtCodigoPk;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaIni;
    // End of variables declaration//GEN-END:variables
}

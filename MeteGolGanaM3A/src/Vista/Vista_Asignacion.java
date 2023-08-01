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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Carlos
 */
public class Vista_Asignacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vista
     */
    public Vista_Asignacion() {
        initComponents();
    }

    public FSTexFieldMD getTxt_apellido_arb() {
        return txt_apellido_arb;
    }

    public void setTxt_apellido_arb(FSTexFieldMD txt_apellido_arb) {
        this.txt_apellido_arb = txt_apellido_arb;
    }

    public FSTexFieldMD getTxt_equipo_1() {
        return txt_equipo_1;
    }

    public void setTxt_equipo_1(FSTexFieldMD txt_equipo_1) {
        this.txt_equipo_1 = txt_equipo_1;
    }

    public FSTexFieldMD getTxt_equipo_2() {
        return txt_equipo_2;
    }

    public void setTxt_equipo_2(FSTexFieldMD txt_equipo_2) {
        this.txt_equipo_2 = txt_equipo_2;
    }

    public FSTexFieldMD getTxt_nombre_arb() {
        return txt_nombre_arb;
    }

    public void setTxt_nombre_arb(FSTexFieldMD txt_nombre_arb) {
        this.txt_nombre_arb = txt_nombre_arb;
    }

    public JTextField getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(JTextField fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public static JButton getBtnAgregar() {
        return btnAgregar;
    }

    public static void setBtnAgregar(JButton btnAgregar) {
        Vista_Asignacion.btnAgregar = btnAgregar;
    }

    public FSButtonMD getBtnArbitro() {
        return btnArbitro;
    }

    public void setBtnArbitro(FSButtonMD btnArbitro) {
        this.btnArbitro = btnArbitro;
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
        Vista_Asignacion.btnCancelar = btnCancelar;
    }

    public static FSButtonMD getBtnCancelar1() {
        return btnCancelar1;
    }

    public static void setBtnCancelar1(FSButtonMD btnCancelar1) {
        Vista_Asignacion.btnCancelar1 = btnCancelar1;
    }

    public static JButton getBtnEliminar() {
        return btnEliminar;
    }

    public static void setBtnEliminar(JButton btnEliminar) {
        Vista_Asignacion.btnEliminar = btnEliminar;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public static void setBtnInicio(FSButtonMD btnInicio) {
        Vista_Asignacion.btnInicio = btnInicio;
    }

    public static JButton getBtnModificar() {
        return btnModificar;
    }

    public static void setBtnModificar(JButton btnModificar) {
        Vista_Asignacion.btnModificar = btnModificar;
    }

    public FSButtonMD getBtnPartido() {
        return btnPartido;
    }

    public void setBtnPartido(FSButtonMD btnPartido) {
        this.btnPartido = btnPartido;
    }

    public static FSButtonMD getBtnRegistrarModificar() {
        return btnRegistrarModificar;
    }

    public static void setBtnRegistrarModificar(FSButtonMD btnRegistrarModificar) {
        Vista_Asignacion.btnRegistrarModificar = btnRegistrarModificar;
    }

    public static FSButtonMD getBtnmandardatos() {
        return btnmandardatos;
    }

    public static void setBtnmandardatos(FSButtonMD btnmandardatos) {
        Vista_Asignacion.btnmandardatos = btnmandardatos;
    }

    public static JDialog getDialogRegistrarModificar() {
        return dialogRegistrarModificar;
    }

    public static void setDialogRegistrarModificar(JDialog dialogRegistrarModificar) {
        Vista_Asignacion.dialogRegistrarModificar = dialogRegistrarModificar;
    }

    public static JDialog getDialogtablas() {
        return dialogtablas;
    }

    public static void setDialogtablas(JDialog dialogtablas) {
        Vista_Asignacion.dialogtablas = dialogtablas;
    }

    public FSTexFieldMD getDtfecha() {
        return dtfecha;
    }

    public void setDtfecha(FSTexFieldMD dtfecha) {
        this.dtfecha = dtfecha;
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

    public static JTable getTblAsignacion() {
        return tblAsignacion;
    }

    public static void setTblAsignacion(JTable tblAsignacion) {
        Vista_Asignacion.tblAsignacion = tblAsignacion;
    }

    public static JTable getTblArbitro() {
        return tblArbitro;
    }

    public static void setTblArbitro(JTable tblArbitro) {
        Vista_Asignacion.tblArbitro = tblArbitro;
    }

    public JTable getTblPartido() {
        return tblPartido;
    }

    public JPanel getPanelPartido() {
        return panelPartido;
    }

    public void setPanelPartido(JPanel panelPartido) {
        this.panelPartido = panelPartido;
    }

    public void setTblPartido(JTable tblPartido) {
        this.tblPartido = tblPartido;
    }

    public static FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public static void setTxtBuscar(FSTexFieldMD txtBuscar) {
        Vista_Asignacion.txtBuscar = txtBuscar;
    }

    public static FSTexFieldMD getTxtCodAsignacion() {
        return txtCodAsignacion;
    }

    public static void setTxtCodAsignacion(FSTexFieldMD txtCodAsignacion) {
        Vista_Asignacion.txtCodAsignacion = txtCodAsignacion;
    }

    public static FSTexFieldMD getTxtbuscarcod() {
        return txtbuscarcod;
    }

    public static void setTxtbuscarcod(FSTexFieldMD txtbuscarcod) {
        Vista_Asignacion.txtbuscarcod = txtbuscarcod;
    }

    public static FSTexFieldMD getTxtcodArbitro() {
        return txtcodArbitro;
    }

    public static void setTxtcodArbitro(FSTexFieldMD txtcodArbitro) {
        Vista_Asignacion.txtcodArbitro = txtcodArbitro;
    }

    public static FSTexFieldMD getTxtcodPartido() {
        return txtcodPartido;
    }

    public static void setTxtcodPartido(FSTexFieldMD txtcodPartido) {
        Vista_Asignacion.txtcodPartido = txtcodPartido;
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
        txtcodPartido = new LIB.FSTexFieldMD();
        btnCancelar = new LIB.FSButtonMD();
        btnRegistrarModificar = new LIB.FSButtonMD();
        dtfecha = new LIB.FSTexFieldMD();
        btnPartido = new LIB.FSButtonMD();
        btnArbitro = new LIB.FSButtonMD();
        txtCodAsignacion = new LIB.FSTexFieldMD();
        jLabel5 = new javax.swing.JLabel();
        txtcodArbitro = new LIB.FSTexFieldMD();
        fechaPartido = new javax.swing.JTextField();
        txt_equipo_2 = new LIB.FSTexFieldMD();
        txt_nombre_arb = new LIB.FSTexFieldMD();
        txt_apellido_arb = new LIB.FSTexFieldMD();
        jLabel2 = new javax.swing.JLabel();
        txt_equipo_1 = new LIB.FSTexFieldMD();
        dialogtablas = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblbusqueda = new javax.swing.JLabel();
        txtbuscarcod = new LIB.FSTexFieldMD();
        btnCancelar1 = new LIB.FSButtonMD();
        btnmandardatos = new LIB.FSButtonMD();
        btnBuscar = new LIB.FSButtonMD();
        panelPartido = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPartido = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArbitro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsignacion = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();
        txtBuscar = new LIB.FSTexFieldMD();

        dialogRegistrarModificar.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        lblReMoJugadores.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblReMoJugadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoJugadores.setText("REGISTRO DE ASIGNACION");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReMoJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblReMoJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        txtcodPartido.setEditable(false);
        txtcodPartido.setBackground(new java.awt.Color(255, 255, 255));
        txtcodPartido.setForeground(new java.awt.Color(255, 255, 255));
        txtcodPartido.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtcodPartido.setPlaceholder("PARTIDO");
        jPanel3.add(txtcodPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 70, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 180, -1));

        btnRegistrarModificar.setText("Registrar");
        btnRegistrarModificar.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificar.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificar.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnRegistrarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 180, -1));

        dtfecha.setEditable(false);
        dtfecha.setBackground(new java.awt.Color(255, 255, 255));
        dtfecha.setForeground(new java.awt.Color(0, 0, 0));
        dtfecha.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        dtfecha.setPlaceholder("FECHA ACTUAL");
        dtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtfechaActionPerformed(evt);
            }
        });
        jPanel3.add(dtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 140, -1));

        btnPartido.setBackground(new java.awt.Color(204, 204, 204));
        btnPartido.setText("Buscar Partido");
        btnPartido.setColorHover(new java.awt.Color(0, 0, 0));
        btnPartido.setColorNormal(new java.awt.Color(204, 204, 204));
        btnPartido.setColorPressed(new java.awt.Color(204, 204, 204));
        btnPartido.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel3.add(btnPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 130, -1));

        btnArbitro.setText("Buscar Arbitro");
        btnArbitro.setColorHover(new java.awt.Color(0, 0, 0));
        btnArbitro.setColorNormal(new java.awt.Color(204, 204, 204));
        btnArbitro.setColorPressed(new java.awt.Color(204, 204, 204));
        btnArbitro.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbitroActionPerformed(evt);
            }
        });
        jPanel3.add(btnArbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 130, -1));

        txtCodAsignacion.setEditable(false);
        txtCodAsignacion.setBackground(new java.awt.Color(255, 255, 255));
        txtCodAsignacion.setForeground(new java.awt.Color(255, 255, 255));
        txtCodAsignacion.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtCodAsignacion.setPlaceholder("Codigo Asignacion");
        txtCodAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAsignacionActionPerformed(evt);
            }
        });
        jPanel3.add(txtCodAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 110, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel5.setText("Fecha Asignacion");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtcodArbitro.setEditable(false);
        txtcodArbitro.setBackground(new java.awt.Color(255, 255, 255));
        txtcodArbitro.setForeground(new java.awt.Color(255, 255, 255));
        txtcodArbitro.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtcodArbitro.setPlaceholder("ARBITRO");
        txtcodArbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodArbitroActionPerformed(evt);
            }
        });
        jPanel3.add(txtcodArbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 70, 30));

        fechaPartido.setEditable(false);
        fechaPartido.setBackground(new java.awt.Color(255, 255, 255));
        fechaPartido.setForeground(new java.awt.Color(255, 255, 255));
        fechaPartido.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(fechaPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 90, -1));

        txt_equipo_2.setEditable(false);
        txt_equipo_2.setBackground(new java.awt.Color(255, 255, 255));
        txt_equipo_2.setForeground(new java.awt.Color(0, 0, 0));
        txt_equipo_2.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txt_equipo_2.setPlaceholder("EQUIPO 2");
        jPanel3.add(txt_equipo_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 80, -1));

        txt_nombre_arb.setEditable(false);
        txt_nombre_arb.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre_arb.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre_arb.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txt_nombre_arb.setPlaceholder("NOMBRE");
        jPanel3.add(txt_nombre_arb, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 110, -1));

        txt_apellido_arb.setEditable(false);
        txt_apellido_arb.setBackground(new java.awt.Color(255, 255, 255));
        txt_apellido_arb.setForeground(new java.awt.Color(0, 0, 0));
        txt_apellido_arb.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txt_apellido_arb.setPlaceholder("APELLIDO");
        jPanel3.add(txt_apellido_arb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 110, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("VS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        txt_equipo_1.setEditable(false);
        txt_equipo_1.setBackground(new java.awt.Color(255, 255, 255));
        txt_equipo_1.setForeground(new java.awt.Color(0, 0, 0));
        txt_equipo_1.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txt_equipo_1.setPlaceholder("EQUIPO 1");
        jPanel3.add(txt_equipo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 80, -1));

        javax.swing.GroupLayout dialogRegistrarModificarLayout = new javax.swing.GroupLayout(dialogRegistrarModificar.getContentPane());
        dialogRegistrarModificar.getContentPane().setLayout(dialogRegistrarModificarLayout);
        dialogRegistrarModificarLayout.setHorizontalGroup(
            dialogRegistrarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogRegistrarModificarLayout.setVerticalGroup(
            dialogRegistrarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogtablas.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        lblbusqueda.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblbusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblbusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbusqueda.setText("TABLA");

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
        jPanel5.add(txtbuscarcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 440, -1));

        btnCancelar1.setText("Cancelar");
        btnCancelar1.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar1.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar1.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel5.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        btnmandardatos.setText("Guardar");
        btnmandardatos.setColorHover(new java.awt.Color(0, 102, 204));
        btnmandardatos.setColorPressed(new java.awt.Color(0, 204, 51));
        btnmandardatos.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnmandardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmandardatosActionPerformed(evt);
            }
        });
        jPanel5.add(btnmandardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

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
        jPanel5.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        panelPartido.setBackground(new java.awt.Color(255, 255, 255));
        panelPartido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPartido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EQUIPO 1", "EQUIPO 2", "FECHA", "CODIGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblPartido);

        panelPartido.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 760, 290));

        jPanel5.add(panelPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 780, 320));

        tblArbitro.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblArbitro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblArbitro);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 760, 290));

        javax.swing.GroupLayout dialogtablasLayout = new javax.swing.GroupLayout(dialogtablas.getContentPane());
        dialogtablas.getContentPane().setLayout(dialogtablasLayout);
        dialogtablasLayout.setHorizontalGroup(
            dialogtablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogtablasLayout.setVerticalGroup(
            dialogtablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Partidos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregar.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/boton.png"))); // NOI18N
        btnAgregar.setText("Crear nuevo");
        btnAgregar.setToolTipText("Registrar un nuevo Partido");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblAsignacion.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "FECHA", "ID ARBITRO", "NOMBRE", "APELLIDO", "PARTIDO", "EQUIPO 1", "EQUIPO 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAsignacion);

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar partido existente");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contenedor-de-basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar partido existente");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASIGNACION");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarModificarActionPerformed

    private void btnArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArbitroActionPerformed

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

    private void txtCodAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAsignacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodAsignacionActionPerformed

    private void txtcodArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodArbitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodArbitroActionPerformed

    private void dtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtfechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnArbitro;
    private LIB.FSButtonMD btnBuscar;
    public static LIB.FSButtonMD btnCancelar;
    public static LIB.FSButtonMD btnCancelar1;
    public static javax.swing.JButton btnEliminar;
    public static LIB.FSButtonMD btnInicio;
    public static javax.swing.JButton btnModificar;
    private LIB.FSButtonMD btnPartido;
    public static LIB.FSButtonMD btnRegistrarModificar;
    public static LIB.FSButtonMD btnmandardatos;
    public static javax.swing.JDialog dialogRegistrarModificar;
    public static javax.swing.JDialog dialogtablas;
    public LIB.FSTexFieldMD dtfecha;
    private javax.swing.JTextField fechaPartido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblReMoJugadores;
    private javax.swing.JLabel lblbusqueda;
    public javax.swing.JPanel panelPartido;
    public static javax.swing.JTable tblArbitro;
    public static javax.swing.JTable tblAsignacion;
    private javax.swing.JTable tblPartido;
    public static LIB.FSTexFieldMD txtBuscar;
    public static LIB.FSTexFieldMD txtCodAsignacion;
    private LIB.FSTexFieldMD txt_apellido_arb;
    private LIB.FSTexFieldMD txt_equipo_1;
    private LIB.FSTexFieldMD txt_equipo_2;
    private LIB.FSTexFieldMD txt_nombre_arb;
    public static LIB.FSTexFieldMD txtbuscarcod;
    public static LIB.FSTexFieldMD txtcodArbitro;
    public static LIB.FSTexFieldMD txtcodPartido;
    // End of variables declaration//GEN-END:variables
}

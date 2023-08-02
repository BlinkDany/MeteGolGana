/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import LIB.FSButtonMD;
import LIB.FSTexFieldMD;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Carlos
 */
public class VistaGol extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaGol
     */
    public VistaGol() {
        initComponents();
    }

    public JLabel getLblReMoGoles() {
        return lblReMoGoles;
    }

    public FSButtonMD getBtnBuscar() {
        return btnBuscar;
    }

    public JLabel getCodigo() {
        return codigo;
    }

    public JLabel getCodigo2() {
        return codigo2;
    }

    public JDialog getJdggolestabla() {
        return jdggolestabla;
    }

    public static FSButtonMD getBtnCancelar1() {
        return btnCancelar1;
    }

    public static FSButtonMD getBtnmandardatos() {
        return btnmandardatos;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JLabel getLblbusqueda() {
        return lblbusqueda;
    }

    public static JTable getTblbuscar() {
        return tblbuscar;
    }

    public static FSTexFieldMD getTxtbuscarcod() {
        return txtbuscarcod;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public FSButtonMD getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public FSButtonMD getBtnEquipo() {
        return btnEquipo;
    }

    public static FSButtonMD getBtnInicio() {
        return btnInicio;
    }

    public FSButtonMD getBtnJugador() {
        return btnJugador;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public FSButtonMD getBtnPartido() {
        return btnPartido;
    }

    public FSButtonMD getBtnRegistrarModificar() {
        return btnRegistrarModificar;
    }

    public JDialog getJdgGoles() {
        return jdgGoles;
    }

    public JTable getTblGoles() {
        return tblGoles;
    }

    public void setTblGoles(JTable tblGoles) {
        this.tblGoles = tblGoles;
    }

    public FSTexFieldMD getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(FSTexFieldMD txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public FSTexFieldMD getTxtCodEquipo() {
        return txtCodEquipo;
    }

    public FSTexFieldMD getTxtCodJugador() {
        return txtCodJugador;
    }

    public FSTexFieldMD getTxtCodPartido() {
        return txtCodPartido;
    }

    public FSTexFieldMD getTxtMinuto() {
        return txtMinuto;
    }

    public FSTexFieldMD getTxtcodGol() {
        return txtcodGol;
    }

    public FSTexFieldMD getTxtdescripcion() {
        return txtdescripcion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdgGoles = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        lblReMoGoles = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtcodGol = new LIB.FSTexFieldMD();
        txtdescripcion = new LIB.FSTexFieldMD();
        txtMinuto = new LIB.FSTexFieldMD();
        txtCodEquipo = new LIB.FSTexFieldMD();
        txtCodPartido = new LIB.FSTexFieldMD();
        txtCodJugador = new LIB.FSTexFieldMD();
        btnJugador = new LIB.FSButtonMD();
        btnPartido = new LIB.FSButtonMD();
        btnEquipo = new LIB.FSButtonMD();
        btnCancelar = new LIB.FSButtonMD();
        btnRegistrarModificar = new LIB.FSButtonMD();
        codigo2 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        jdggolestabla = new javax.swing.JDialog();
        btnCancelar1 = new LIB.FSButtonMD();
        txtbuscarcod = new LIB.FSTexFieldMD();
        btnmandardatos = new LIB.FSButtonMD();
        btnBuscar = new LIB.FSButtonMD();
        jPanel2 = new javax.swing.JPanel();
        lblbusqueda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbuscar = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new LIB.FSButtonMD();
        jPanel5 = new javax.swing.JPanel();
        txtBuscar = new LIB.FSTexFieldMD();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGoles = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        lblReMoGoles.setBackground(new java.awt.Color(0, 102, 204));
        lblReMoGoles.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblReMoGoles.setForeground(new java.awt.Color(255, 255, 255));
        lblReMoGoles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReMoGoles.setText("Registro o Modificar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReMoGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReMoGoles, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcodGol.setBackground(new java.awt.Color(255, 255, 255));
        txtcodGol.setForeground(new java.awt.Color(0, 0, 0));
        txtcodGol.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtcodGol.setPlaceholder("Codigo");
        jPanel4.add(txtcodGol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 189, -1));

        txtdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtdescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtdescripcion.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtdescripcion.setPlaceholder("Descripcion");
        jPanel4.add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 189, -1));

        txtMinuto.setBackground(new java.awt.Color(255, 255, 255));
        txtMinuto.setForeground(new java.awt.Color(0, 0, 0));
        txtMinuto.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtMinuto.setPlaceholder("Minuto");
        jPanel4.add(txtMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 189, -1));

        txtCodEquipo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodEquipo.setForeground(new java.awt.Color(0, 0, 0));
        txtCodEquipo.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodEquipo.setPlaceholder("Codigo del Equipo");
        jPanel4.add(txtCodEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 203, -1));

        txtCodPartido.setBackground(new java.awt.Color(255, 255, 255));
        txtCodPartido.setForeground(new java.awt.Color(0, 0, 0));
        txtCodPartido.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodPartido.setPlaceholder("Codigo del Partido");
        jPanel4.add(txtCodPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 199, -1));

        txtCodJugador.setBackground(new java.awt.Color(255, 255, 255));
        txtCodJugador.setForeground(new java.awt.Color(0, 0, 0));
        txtCodJugador.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtCodJugador.setPlaceholder("Codigo Del Jugador");
        jPanel4.add(txtCodJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 199, -1));

        btnJugador.setBackground(new java.awt.Color(204, 204, 204));
        btnJugador.setForeground(new java.awt.Color(0, 0, 0));
        btnJugador.setText("Buscar Jugador");
        jPanel4.add(btnJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 143, -1));

        btnPartido.setBackground(new java.awt.Color(204, 204, 204));
        btnPartido.setForeground(new java.awt.Color(0, 0, 0));
        btnPartido.setText("Buscar Partido");
        jPanel4.add(btnPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 143, -1));

        btnEquipo.setBackground(new java.awt.Color(204, 204, 204));
        btnEquipo.setForeground(new java.awt.Color(0, 0, 0));
        btnEquipo.setText("Buscar Equipo");
        jPanel4.add(btnEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 143, -1));

        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        btnRegistrarModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarModificar.setText("Registrar");
        btnRegistrarModificar.setColorHover(new java.awt.Color(0, 102, 204));
        btnRegistrarModificar.setColorPressed(new java.awt.Color(0, 204, 51));
        btnRegistrarModificar.setColorTextHover(new java.awt.Color(255, 255, 255));
        jPanel4.add(btnRegistrarModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));
        jPanel4.add(codigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 287, 37, 44));
        jPanel4.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 223, 30, 27));

        javax.swing.GroupLayout jdgGolesLayout = new javax.swing.GroupLayout(jdgGoles.getContentPane());
        jdgGoles.getContentPane().setLayout(jdgGolesLayout);
        jdgGolesLayout.setHorizontalGroup(
            jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdgGolesLayout.setVerticalGroup(
            jdgGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdgGolesLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, Short.MAX_VALUE))
        );

        btnCancelar1.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setColorHover(new java.awt.Color(0, 0, 0));
        btnCancelar1.setColorNormal(new java.awt.Color(255, 0, 0));
        btnCancelar1.setColorTextHover(new java.awt.Color(255, 255, 255));

        txtbuscarcod.setForeground(new java.awt.Color(0, 0, 0));
        txtbuscarcod.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtbuscarcod.setPlaceholder("Codigo");
        txtbuscarcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarcodActionPerformed(evt);
            }
        });

        btnmandardatos.setForeground(new java.awt.Color(0, 0, 0));
        btnmandardatos.setText("Guardar");
        btnmandardatos.setColorHover(new java.awt.Color(0, 102, 204));
        btnmandardatos.setColorPressed(new java.awt.Color(0, 204, 51));
        btnmandardatos.setColorTextHover(new java.awt.Color(255, 255, 255));
        btnmandardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmandardatosActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        lblbusqueda.setBackground(new java.awt.Color(0, 102, 204));
        lblbusqueda.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        lblbusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblbusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbusqueda.setText("tabla");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(lblbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        tblbuscar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Equipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblbuscar);

        javax.swing.GroupLayout jdggolestablaLayout = new javax.swing.GroupLayout(jdggolestabla.getContentPane());
        jdggolestabla.getContentPane().setLayout(jdggolestablaLayout);
        jdggolestablaLayout.setHorizontalGroup(
            jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdggolestablaLayout.createSequentialGroup()
                .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdggolestablaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtbuscarcod, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdggolestablaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdggolestablaLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnmandardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdggolestablaLayout.setVerticalGroup(
            jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdggolestablaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscarcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jdggolestablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmandardatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("STHupo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Goles");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setToolTipText("Ingrese el Codigo del Gol");
        txtBuscar.setBordeColorFocus(new java.awt.Color(51, 51, 255));
        txtBuscar.setPlaceholder("Buscar Goles");
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
        btnAgregar.setToolTipText("Registrar un nuevo Gol");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblGoles.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        tblGoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Del Gol", "Descripcion", "Minuto", "Jugador", "Equipo", "Partido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGoles);

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar un Gol Previamente Registrado");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/contenedor-de-basura.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar un Gol");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar))
                .addGap(381, 381, 381))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnAgregar)
                    .addContainerGap(769, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 189, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar))
                    .addContainerGap(337, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtbuscarcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarcodActionPerformed

    private void btnmandardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmandardatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmandardatosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private LIB.FSButtonMD btnBuscar;
    private LIB.FSButtonMD btnCancelar;
    public static LIB.FSButtonMD btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private LIB.FSButtonMD btnEquipo;
    public static LIB.FSButtonMD btnInicio;
    private LIB.FSButtonMD btnJugador;
    private javax.swing.JButton btnModificar;
    private LIB.FSButtonMD btnPartido;
    private LIB.FSButtonMD btnRegistrarModificar;
    public static LIB.FSButtonMD btnmandardatos;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel codigo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog jdgGoles;
    private javax.swing.JDialog jdggolestabla;
    private javax.swing.JLabel lblReMoGoles;
    private javax.swing.JLabel lblbusqueda;
    private javax.swing.JTable tblGoles;
    public static javax.swing.JTable tblbuscar;
    private LIB.FSTexFieldMD txtBuscar;
    private LIB.FSTexFieldMD txtCodEquipo;
    private LIB.FSTexFieldMD txtCodJugador;
    private LIB.FSTexFieldMD txtCodPartido;
    private LIB.FSTexFieldMD txtMinuto;
    public static LIB.FSTexFieldMD txtbuscarcod;
    private LIB.FSTexFieldMD txtcodGol;
    private LIB.FSTexFieldMD txtdescripcion;
    // End of variables declaration//GEN-END:variables
}

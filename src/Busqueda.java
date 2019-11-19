import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/** @author David Grande */
public class Busqueda extends javax.swing.JDialog {

  DefaultTableModel modelo;
  Connection con;
  ResultSet rs, rs1;
  Statement st, st1;
  String driver = "com.mysql.jdbc.Driver";
  String urlMysql = "jdbc:mysql://localhost:3306/";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");;

  /** @author David Grande */
  public Busqueda(java.awt.Frame parent, boolean modal) {
    super(parent, modal);

    initComponents();
    tablabusqueda.setAutoCreateRowSorter(true);

    try {
      Class.forName(driver).newInstance();
      con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
      st = con.createStatement();
      st1 = con.createStatement();
      rs = st.executeQuery("select DISTINCT(delegacion) from comercial ");
      if (rs.next()) {
        do {
          combobusquedadelegacion.addItem(rs.getString("delegacion"));
        } while (rs.next());
      }
      rs = st.executeQuery("select nombre from comercial where activo='SI'");
      if (rs.next()) {
        do {
          combobusquedacomercial.addItem(rs.getString("nombre"));
        } while (rs.next());
      }
      rs = st.executeQuery("select DISTINCT(operador) from venta");
      if (rs.next()) {
        do {
          combobusoperador.addItem(rs.getString("operador"));
        } while (rs.next());
      }
      rs = st.executeQuery("select DISTINCT(estado) from estados");
      if (rs.next()) {
        do {
          combobusquedaestado.addItem(rs.getString("estado"));
        } while (rs.next());
      }
      sinfiltro();
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
      Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * @wbp.parser.constructor
   */
  private Busqueda(JFrame jFrame, boolean b) {
    throw new UnsupportedOperationException(
        "Not supported yet."); // To change body of generated methods, choose Tools | Templates.
  }

  @SuppressWarnings({"unchecked", "serial"})
  private void initComponents() {

    jLabel4 = new javax.swing.JLabel();
    combobusquedadelegacion = new javax.swing.JComboBox<>();
    combomes = new javax.swing.JComboBox();
    jLabel7 = new javax.swing.JLabel();
    combobusquedacomercial = new javax.swing.JComboBox<>();
    jLabel3 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    combobusoperador = new javax.swing.JComboBox();
    jLabel6 = new javax.swing.JLabel();
    txtcodcomercial = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    txtbusquedadocumento = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    combobusquedaestado = new javax.swing.JComboBox<>();
    btnsinfiltros = new javax.swing.JButton();
    btnsalirbus = new javax.swing.JButton();
    txtcodenvio = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablabusqueda = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel4.setText("Delegaci�n :");

    combobusquedadelegacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
    combobusquedadelegacion.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combobusquedadelegacionActionPerformed(evt);
          }
        });

    combomes.setModel(
        new javax.swing.DefaultComboBoxModel(
            new String[] {
              "-",
              "ENERO",
              "FEBRERO",
              "MARZO",
              "ABRIL",
              "MAYO",
              "JUNIO",
              "JULIO",
              "AGOSTO",
              "SEPTIEMBRE",
              "OCTUBRE",
              "NOVIEMBRE",
              "DICIEMBRE"
            }));
    combomes.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combomesActionPerformed(evt);
          }
        });

    jLabel7.setText("Mes Alta :");

    combobusquedacomercial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
    combobusquedacomercial.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combobusquedacomercialActionPerformed(evt);
          }
        });
    combobusquedacomercial.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            combobusquedacomercialFocusLost(evt);
          }
        });

    jLabel3.setText("Comercial :");

    jLabel5.setText("Operador :");

    combobusoperador.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-"}));
    combobusoperador.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combobusoperadorActionPerformed(evt);
          }
        });

    jLabel6.setText("Codigo Comercial :");

    txtcodcomercial.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtcodcomercialFocusLost(evt);
          }
        });

    jLabel2.setText("Documento :");

    txtbusquedadocumento.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtbusquedadocumentoFocusLost(evt);
          }
        });

    jLabel1.setText("Estado :");

    combobusquedaestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
    combobusquedaestado.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            combobusquedaestadoFocusLost(evt);
          }
        });

    btnsinfiltros.setText("Borrar Filtos");
    btnsinfiltros.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsinfiltrosActionPerformed(evt);
          }
        });

    btnsalirbus.setText("Salir");
    btnsalirbus.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsalirbusActionPerformed(evt);
          }
        });

    tablabusqueda.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null, null, null, null, null, null, null},
              {null, null, null, null, null, null, null, null, null, null},
              {null, null, null, null, null, null, null, null, null, null},
              {null, null, null, null, null, null, null, null, null, null}
            },
            new String[] {
              "Cod_Cliente",
              "Fecha Creacion",
              "Nombre Cliente",
              "Documento",
              "Segmento",
              "Operador",
              "Oferta",
              "Delegacion",
              "Comercial",
              "Estado"
            }) {

          Class[] types =
              new Class[] {
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
              };
          boolean[] canEdit =
              new boolean[] {false, false, false, false, false, false, false, false, false, false};

          public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
          }

          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
          }
        });
    tablabusqueda.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    tablabusqueda.setRowSelectionAllowed(false);
    tablabusqueda.getTableHeader().setReorderingAllowed(false);
    tablabusqueda.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablabusquedaMouseClicked(evt);
          }
        });
    jScrollPane1.setViewportView(tablabusqueda);
    tablabusqueda
        .getColumnModel()
        .getSelectionModel()
        .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    jButton1.setText("Actualizar");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(
                                        jLabel6,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel5,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel3,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel4,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(
                                        jLabel1,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel2,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)))
                    .addGap(31, 31, 31)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combobusquedadelegacion, 0, 173, Short.MAX_VALUE)
                            .addComponent(
                                combobusquedacomercial,
                                0,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(txtbusquedadocumento)
                            .addComponent(
                                combobusquedaestado,
                                0,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                combobusoperador,
                                0,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(txtcodcomercial))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnsinfiltros)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        btnsalirbus,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        89,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(txtcodenvio)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        62,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel7,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        95,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        combomes,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        168,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(188, 188, 188)
                    .addComponent(
                        jButton1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        133,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        227,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jButton1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        26,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                combobusquedadelegacion,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addComponent(
                                                combomes,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcodenvio))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                combobusquedacomercial,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel5))
                            .addComponent(
                                combobusoperador,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtcodcomercial,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                                        18,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                btnsalirbus,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                53,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                btnsinfiltros,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                53,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(
                                                txtbusquedadocumento,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(
                                                combobusquedaestado,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))));

    pack();
  }

  private void combobusquedadelegacionActionPerformed(java.awt.event.ActionEvent evt) {
    modelo = crearModelo();
    tablabusqueda.setModel(modelo);
    filtrodelegacion(combobusquedadelegacion.getSelectedItem().toString());
    combobusquedacomercial.removeAllItems();
    combobusquedacomercial.addItem("-");
    try {
      rs =
          st.executeQuery(
              "select nombre from comercial where activo='SI' and delegacion='"
                  + combobusquedadelegacion.getSelectedItem().toString()
                  + "'");

      if (rs.next()) {
        do {
          combobusquedacomercial.addItem(rs.getString("nombre"));
        } while (rs.next());
      }
      combobusquedacomercial.setSelectedIndex(0);
    } catch (SQLException ex) {
      Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void combobusquedacomercialActionPerformed(java.awt.event.ActionEvent evt) {}

  private void combobusoperadorActionPerformed(java.awt.event.ActionEvent evt) {
    modelo = crearModelo();
    tablabusqueda.setModel(modelo);
    filtrooperador(combobusoperador.getSelectedItem().toString());
  }

  private void txtcodcomercialFocusLost(java.awt.event.FocusEvent evt) {
    if (!txtcodcomercial.getText().equalsIgnoreCase("")) {

      modelo = crearModelo();
      tablabusqueda.setModel(modelo);
      filtrocodigo(txtcodcomercial.getText());
    }
  }

  private void txtbusquedadocumentoFocusLost(java.awt.event.FocusEvent evt) {
    if (!txtbusquedadocumento.getText().equalsIgnoreCase("")) {
      int dni = validaciones.Validar.comprobar(txtbusquedadocumento.getText());
      if (dni < 0) { //
      } else {
        modelo = crearModelo();
        tablabusqueda.setModel(modelo);
        filtrodocumento(txtbusquedadocumento.getText());
      }
    }
  }

  private void btnsinfiltrosActionPerformed(java.awt.event.ActionEvent evt) {
    combobusquedacomercial.removeAllItems();
    combobusquedacomercial.addItem("-");
    try {
      txtbusquedadocumento.setText("");
      combobusquedacomercial.setSelectedIndex(0);
      combobusquedadelegacion.setSelectedIndex(0);
      combobusquedaestado.setSelectedIndex(0);
      combobusoperador.setSelectedIndex(0);
      txtcodcomercial.setText("");
      combomes.setSelectedIndex(0);
      rs = st.executeQuery("select nombre from comercial where activo='SI'");
      if (rs.next()) {
        do {
          combobusquedacomercial.addItem(rs.getString("nombre"));
        } while (rs.next());
      }
      sinfiltro();
    } catch (SQLException ex) {
      Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void btnsalirbusActionPerformed(java.awt.event.ActionEvent evt) {
    this.setVisible(false);
    Principal ps = new Principal("", "");
    ps.setVisible(true);
  }

  private void combobusquedacomercialFocusLost(java.awt.event.FocusEvent evt) {
    modelo = crearModelo();
    tablabusqueda.setModel(modelo);
    filtrocomercial(combobusquedacomercial.getSelectedItem().toString());
  }

  private void combobusquedaestadoFocusLost(java.awt.event.FocusEvent evt) {
    modelo = crearModelo();
    tablabusqueda.setModel(modelo);
    filtroestado(combobusquedaestado.getSelectedItem().toString());
  }

  // filtro por creacion de la venta
  private void combomesActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      if (!combomes.getSelectedItem().toString().equalsIgnoreCase("-")) {

        int mese = combomes.getSelectedIndex();
        String dato = "0" + String.valueOf(mese);
        rs = st.executeQuery("select * from venta where MONTH(fechacreacion) ='" + dato + "'");
        if (rs.next()) {
          modelo = crearModelo();
          do {
            rs1 =
                st.executeQuery(
                    "select * from cliente where id='" + rs.getString("idcliente") + "'");
            rs1.next();
            rs.getString("fechacreacion");
            String[] parts = rs.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs1.getString("nombre");
            filas[3] = rs1.getString("documento");
            filas[4] = rs.getString("segmento");
            filas[5] = rs.getString("operador");
            filas[6] = rs.getString("oferta");
            filas[7] = rs.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);
        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void tablabusquedaMouseClicked(java.awt.event.MouseEvent evt) {
    int mod =
        Integer.parseInt(tablabusqueda.getValueAt(tablabusqueda.getSelectedRow(), 0).toString());
    cargacliente(mod);
    if (evt.getClickCount() < 1) { //
    }
  }

  public void cargacliente(int mod) {

    this.dispose();
    Principal ps = new Principal("", String.valueOf(mod));
    ps.setVisible(true);
  }

  // inicializo modelo de tabla
  private DefaultTableModel crearModelo() {

    Object[] columnas = new Object[10];
    columnas[0] = "Cod_cliente";
    columnas[1] = "Fecha Alta";
    columnas[2] = "Nombre Cliente";
    columnas[3] = "Documento";
    columnas[4] = "Segmento";
    columnas[5] = "Operador";
    columnas[6] = "Oferta";
    columnas[7] = "Delegacion";
    columnas[8] = "Comercial";
    columnas[9] = "Estado";

    modelo = new DefaultTableModel(columnas, 0);

    return modelo;
  }

  // carga inicial de busqueda
  public void sinfiltro() {
    try {
      rs = st.executeQuery("select * from venta");

      if (rs.next()) {
        modelo = crearModelo();

        do {
          rs1 =
              st1.executeQuery(
                  "select * from cliente where id='" + rs.getString("idcliente") + "'");

          rs1.next();
          rs.getString("fechacreacion");
          String[] parts = rs.getString("fechacreacion").split("-");
          String ano = parts[0];
          String mes = parts[1];
          String dia = parts[2];
          String fecha = dia + "-" + mes + "-" + ano;
          String[] filas = new String[10];
          filas[0] = rs.getString("idventa");
          filas[1] = fecha;
          filas[2] = rs1.getString("nombre");
          filas[3] = rs1.getString("documento");
          filas[4] = rs.getString("segmento");
          filas[5] = rs.getString("operador");
          filas[6] = rs.getString("oferta");
          filas[7] = rs.getString("delegacion");
          filas[8] = rs.getString("usuario");
          filas[9] = rs.getString("estado");

          modelo.addRow(filas);
        } while (rs.next());
        tablabusqueda.setModel(modelo);

      } else {

        modelo.rowsRemoved(null);
        modelo = crearModelo();
        tablabusqueda.setModel(modelo);
      }

    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // filtro por delegacion est� o no el comercial activo o no
  public void filtrodelegacion(String delegacion) {
    try {
      if (!delegacion.equalsIgnoreCase("-")) {
        rs = st.executeQuery("select * from venta where delegacion='" + delegacion + "'");

        if (rs.next()) {
          modelo = crearModelo();
          do {
            rs1 =
                st1.executeQuery(
                    "select * from cliente where id='" + rs.getString("idcliente") + "'");

            rs1.next();
            rs.getString("fechacreacion");
            String[] parts = rs.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs1.getString("nombre");
            filas[3] = rs1.getString("documento");
            filas[4] = rs.getString("segmento");
            filas[5] = rs.getString("operador");
            filas[6] = rs.getString("oferta");
            filas[7] = rs.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);
        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // filtro por Documento del cliente
  public void filtrodocumento(String docu) {
    try {
      if (!docu.equalsIgnoreCase("-")) {
        rs = st.executeQuery("select * from cliente where documento='" + docu + "'");
        rs1 = st1.executeQuery("select * from venta where id='" + rs.getString("idcliente") + "'");
        if (rs.next()) {
          modelo = crearModelo();
          do {

            rs1.getString("fechacreacion");
            String[] parts = rs1.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs.getString("nombre");
            filas[3] = rs.getString("documento");
            filas[4] = rs1.getString("segmento");
            filas[5] = rs1.getString("operador");
            filas[6] = rs1.getString("oferta");
            filas[7] = rs1.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs1.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);
        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // filtro por estado de la venta
  public void filtroestado(String docu) {
    try {
      if (!combobusquedaestado.getSelectedItem().toString().equalsIgnoreCase("-")) {
        if (combobusquedacomercial.getSelectedItem().toString().equalsIgnoreCase("-")) {
          rs =
              st.executeQuery(
                  "select * from venta where estado='"
                      + combobusquedaestado.getSelectedItem().toString()
                      + "'");
        } else {
          rs =
              st.executeQuery(
                  "select * from venta where estado='"
                      + combobusquedaestado.getSelectedItem().toString()
                      + "' and comercial='"
                      + combobusquedacomercial.getSelectedItem().toString()
                      + "'");
        }
        if (rs.next()) {
          modelo = crearModelo();
          do {
            rs1 =
                st1.executeQuery(
                    "select * from cliente where id='" + rs.getString("idcliente") + "'");

            rs1.next();
            rs.getString("fechacreacion");
            String[] parts = rs.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs1.getString("nombre");
            filas[3] = rs1.getString("documento");
            filas[4] = rs.getString("segmento");
            filas[5] = rs.getString("operador");
            filas[6] = rs.getString("oferta");
            filas[7] = rs.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);

        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // filtro por codigo de venta
  public void filtrocodigo(String cod) {
    try {
      if (!cod.equalsIgnoreCase("-")) {
        rs = st.executeQuery("select select * from venta where codcomercial='" + cod + "'");
        if (rs.next()) {
          modelo = crearModelo();
          do {
            rs1 =
                st1.executeQuery(
                    "select * from cliente where id='" + rs.getString("idcliente") + "'");

            rs1.next();
            rs.getString("fechacreacion");
            String[] parts = rs.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs1.getString("nombre");
            filas[3] = rs1.getString("documento");
            filas[4] = rs.getString("segmento");
            filas[5] = rs.getString("operador");
            filas[6] = rs.getString("oferta");
            filas[7] = rs.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);
        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // filtro por codigo de comercial
  public void filtrocomercial(String comercial) {
    try {
      if (!comercial.equalsIgnoreCase("-")) {
        if (combobusquedaestado.getSelectedItem().toString().equalsIgnoreCase("-")) {
          rs = st.executeQuery("select * from venta where comercial='" + comercial + "'");
        } else {
          rs =
              st.executeQuery(
                  "select * from venta where estado='"
                      + combobusquedaestado.getSelectedItem().toString()
                      + "' and comercial='"
                      + combobusquedacomercial.getSelectedItem().toString()
                      + "'");
        }
        if (rs.next()) {
          modelo = crearModelo();
          do {
            rs1 =
                st1.executeQuery(
                    "select * from cliente where id='" + rs.getString("idcliente") + "'");

            rs1.next();
            rs.getString("fechacreacion");
            String[] parts = rs.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs1.getString("nombre");
            filas[3] = rs1.getString("documento");
            filas[4] = rs.getString("segmento");
            filas[5] = rs.getString("operador");
            filas[6] = rs.getString("oferta");
            filas[7] = rs.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);
        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  // filtro por operador
  public void filtrooperador(String operador) {
    try {
      if (!operador.equalsIgnoreCase("-")) {
        rs = st.executeQuery("select * from venta where operador='" + operador + "'");
        if (rs.next()) {
          modelo = crearModelo();
          do {
            rs1 =
                st1.executeQuery(
                    "select * from cliente where id='" + rs.getString("idcliente") + "'");

            rs1.next();
            rs.getString("fechacreacion");
            String[] parts = rs.getString("fechacreacion").split("-");
            String ano = parts[0];
            String mes = parts[1];
            String dia = parts[2];
            String fecha = dia + "-" + mes + "-" + ano;
            String[] filas = new String[10];
            filas[0] = rs.getString("idventa");
            filas[1] = fecha;
            filas[2] = rs1.getString("nombre");
            filas[3] = rs1.getString("documento");
            filas[4] = rs.getString("segmento");
            filas[5] = rs.getString("operador");
            filas[6] = rs.getString("oferta");
            filas[7] = rs.getString("delegacion");
            filas[8] = rs.getString("usuario");
            filas[9] = rs.getString("estado");
            modelo.addRow(filas);

          } while (rs.next());
          tablabusqueda.setModel(modelo);
        } else {
          modelo.rowsRemoved(null);
          modelo = crearModelo();
          tablabusqueda.setModel(modelo);
        }
      } else {
        sinfiltro();
      }
    } catch (SQLException ex) {
      Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Busqueda.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            Busqueda dialog = new Busqueda(new javax.swing.JFrame(), true);
            dialog.addWindowListener(
                new java.awt.event.WindowAdapter() {
                  @Override
                  public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                  }
                });
            dialog.setVisible(true);
          }
        });
  }

  private javax.swing.JButton btnsalirbus;
  private javax.swing.JButton btnsinfiltros;
  private javax.swing.JComboBox combobusoperador;
  private javax.swing.JComboBox<String> combobusquedacomercial;
  private javax.swing.JComboBox<String> combobusquedadelegacion;
  private javax.swing.JComboBox<String> combobusquedaestado;
  private javax.swing.JComboBox combomes;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tablabusqueda;
  private javax.swing.JTextField txtbusquedadocumento;
  private javax.swing.JTextField txtcodcomercial;
  private javax.swing.JLabel txtcodenvio;
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/** @author David Grande */
public class Pdfinformes extends javax.swing.JDialog {

  Connection con;
  ResultSet rs;
  Statement st;
  String driver = "com.mysql.jdbc.Driver";
  String urlMysql = "jdbc:mysql://localhost:3306/";
  private String dato;

  /**
   * Creates new form Pdfinformes
   *
   * @param parent
   * @param modal
   */
  public Pdfinformes(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    cmbcompaniames.setEnabled(false);
    cmbgeren.setEnabled(false);
    try {
      Class.forName(driver).newInstance();
      con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");

      st = con.createStatement();
      rs = st.executeQuery("select DISTINCT(delegacion) from comercial ");

      while (rs.next()) {
        combopdfdelegacion.addItem(rs.getString("delegacion"));
      }
      rs = st.executeQuery("select DISTINCT(operador) from venta ");

      while (rs.next()) {
        cmbcompaniames.addItem(rs.getString("operador"));
      }
      rs = st.executeQuery("select DISTINCT(gerente) from comercial ");

      while (rs.next()) {
        combodelegaciongeneral.addItem(rs.getString("gerente"));
      }

      rs =
          st.executeQuery(
              "select nombre,usuario from teleoperador where usuario in (select DISTINCT(teleoperadora) from visita) ");
      combonomagentemes.removeAllItems();
      combonomagentemes.addItem("-");
      while (rs.next()) {
        String datos = rs.getString("nombre") + "-" + rs.getString("usuario");
        combonomagentemes.addItem(datos);
      }

      rs = st.executeQuery("select DISTINCT(distribuidor) from visita ");
      combodistribuidormes.removeAllItems();
      combodistribuidormes.addItem("-");
      while (rs.next()) {
        combodistribuidormes.addItem(rs.getString("distribuidor"));
      }
    } catch (SQLException
        | ClassNotFoundException
        | InstantiationException
        | IllegalAccessException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel4 = new javax.swing.JPanel();
    btnimprimir = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    combopdfdelegacion = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    cmbgeren = new javax.swing.JComboBox();
    jPanel2 = new javax.swing.JPanel();
    cmbmespdfgeneral = new javax.swing.JComboBox();
    jLabel2 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel4 = new javax.swing.JLabel();
    cmbmescompania = new javax.swing.JComboBox();
    jLabel5 = new javax.swing.JLabel();
    cmbcompaniames = new javax.swing.JComboBox();
    jPanel5 = new javax.swing.JPanel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    combomesdelegacion = new javax.swing.JComboBox();
    combodelegaciongeneral = new javax.swing.JComboBox();
    jPanel6 = new javax.swing.JPanel();
    jLabel15 = new javax.swing.JLabel();
    jPanel7 = new javax.swing.JPanel();
    jLabel10 = new javax.swing.JLabel();
    combovisitasmesgeneral = new javax.swing.JComboBox();
    jPanel8 = new javax.swing.JPanel();
    jLabel11 = new javax.swing.JLabel();
    combonomagentemes = new javax.swing.JComboBox();
    comboagentemes = new javax.swing.JComboBox();
    jLabel12 = new javax.swing.JLabel();
    jPanel9 = new javax.swing.JPanel();
    jLabel13 = new javax.swing.JLabel();
    combodistrmes = new javax.swing.JComboBox();
    combodistribuidormes = new javax.swing.JComboBox();
    jLabel14 = new javax.swing.JLabel();

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE));
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE));

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    btnimprimir.setText("Generar PDF");
    btnimprimir.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnimprimirActionPerformed(evt);
          }
        });

    jButton1.setText("Salir");
    jButton1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
          }
        });

    combopdfdelegacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-"}));
    combopdfdelegacion.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combopdfdelegacionActionPerformed(evt);
          }
        });

    jLabel1.setText("Provincia :");

    jLabel3.setText("Gerencia :");

    cmbgeren.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbgerenActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                    .addGap(70, 70, 70)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combopdfdelegacion, 0, 151, Short.MAX_VALUE)
                            .addComponent(
                                cmbgeren, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(324, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(
                                combopdfdelegacion,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                cmbgeren,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(102, Short.MAX_VALUE)));

    jTabbedPane1.addTab("Semanal", jPanel1);

    cmbmespdfgeneral.setModel(
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

    jLabel2.setText("Escoger Mes :");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(
                        jLabel2,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        139,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                    .addComponent(
                        cmbmespdfgeneral,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        179,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(89, 89, 89)));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                cmbmespdfgeneral,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                    .addContainerGap(76, Short.MAX_VALUE)));

    jTabbedPane1.addTab("General por Mes", jPanel2);

    jLabel4.setText("Seleciona mes :");

    cmbmescompania.setModel(
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
    cmbmescompania.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbmescompaniaActionPerformed(evt);
          }
        });

    jLabel5.setText("Selecciona Compañía :");

    cmbcompaniames.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-"}));
    cmbcompaniames.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbcompaniamesActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbmescompania, 0, 168, Short.MAX_VALUE)
                            .addComponent(
                                cmbcompaniames,
                                0,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addGap(105, 105, 105)));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(
                                cmbmescompania,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(60, 60, 60)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(
                                cmbcompaniames,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(35, Short.MAX_VALUE)));

    jTabbedPane1.addTab("General por Compañía", jPanel3);

    jLabel6.setText("Seleciona mes :");

    jLabel7.setText("Selecciona Delegación :");

    combomesdelegacion.setModel(
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

    combodelegaciongeneral.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-"}));

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel5Layout
                    .createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combomesdelegacion, 0, 137, Short.MAX_VALUE)
                            .addComponent(
                                combodelegaciongeneral,
                                0,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addGap(88, 88, 88)));
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel5Layout
                    .createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(
                                combomesdelegacion,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(99, 99, 99)
                    .addGroup(
                        jPanel5Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(
                                combodelegaciongeneral,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    jTabbedPane1.addTab("General por Delegación", jPanel5);

    jLabel15.setText("Vas a generar los PDF de las visitas pendientes que se generaron hoy");

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(jLabel15)
                    .addContainerGap(113, Short.MAX_VALUE)));
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel6Layout
                    .createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel15)
                    .addContainerGap(98, Short.MAX_VALUE)));

    jTabbedPane1.addTab("Visitas por dia", jPanel6);

    jLabel10.setText("Mes :");

    combovisitasmesgeneral.setModel(
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

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel7Layout
                    .createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(jLabel10)
                    .addGap(67, 67, 67)
                    .addComponent(
                        combovisitasmesgeneral,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        269,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)));
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel7Layout
                    .createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(
                        jPanel7Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(
                                combovisitasmesgeneral,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(104, Short.MAX_VALUE)));

    jTabbedPane1.addTab("Visitas general mes", jPanel7);

    jLabel11.setText("Agente :");

    comboagentemes.setModel(
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

    jLabel12.setText("Mes :");

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel8Layout
                    .createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                    .addGap(54, 54, 54)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                comboagentemes,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                186,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                combonomagentemes,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                349,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(111, Short.MAX_VALUE)));
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel8Layout
                    .createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(
                                combonomagentemes,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(
                        jPanel8Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                comboagentemes,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                    .addContainerGap(75, Short.MAX_VALUE)));

    jTabbedPane1.addTab("Visitas por Agente Mes", jPanel8);

    jLabel13.setText("Mes :");

    combodistrmes.setModel(
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

    jLabel14.setText("Distribuidor :");

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel9Layout
                    .createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(
                        jPanel9Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                    .addGap(35, 35, 35)
                    .addGroup(
                        jPanel9Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                combodistribuidormes,
                                0,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(combodistrmes, 0, 186, Short.MAX_VALUE))
                    .addContainerGap(254, Short.MAX_VALUE)));
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel9Layout
                    .createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(
                        jPanel9Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                combodistribuidormes,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                    .addGroup(
                        jPanel9Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                combodistrmes,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                    .addGap(51, 51, 51)));

    jTabbedPane1.addTab("Visitas por distribuidor y mes", jPanel9);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(btnimprimir)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        jButton1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        83,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
            .addComponent(jTabbedPane1));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        jTabbedPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        241,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnimprimir)
                            .addComponent(jButton1))
                    .addGap(21, 21, 21)));

    pack();
  } 

  private void btnimprimirActionPerformed(
      java.awt.event.ActionEvent evt) { 
    int i = jTabbedPane1.getSelectedIndex();
    int b = 0;
    try {
      switch (i) {
        case 0:
          System.out.println(combopdfdelegacion.getSelectedItem().toString());
          if (!combopdfdelegacion.getSelectedItem().toString().equalsIgnoreCase("-")) {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
            st = con.createStatement();
            String part[] = cmbgeren.getSelectedItem().toString().split("-");
            rs =
                st.executeQuery(
                    "select * from venta WHERE usuario IN (SELECT usuario FROM comercial where gerente='"
                        + part[0]
                        + "' AND activo='SI') ");
            if (rs.next()) {
              Informes.informedelegacion(
                  rs, part[0], combopdfdelegacion.getSelectedItem().toString());
            } else {
              JOptionPane.showMessageDialog(
                  null, "No hay actividad de esa delegación", "Error", JOptionPane.YES_OPTION);
            }

          } else {
            JOptionPane.showMessageDialog(
                null, "Selecciona Provincia, por favor", "Error", JOptionPane.YES_OPTION);
          }
          break;
        case 1:
          if (cmbmespdfgeneral.getSelectedIndex() != 0) {
            String dato = null;
            if (cmbmespdfgeneral.getSelectedIndex() < 10) {
              int mes = cmbmespdfgeneral.getSelectedIndex();
              dato = "0" + String.valueOf(mes);
              rs =
                  st.executeQuery(
                      "SELECT * FROM venta WHERE MONTH(fechacreacion) = '" + dato + "'");
              while (rs.next()) {
                rs.beforeFirst();
                Informes.generalxmes(rs, dato, cmbmespdfgeneral.getSelectedItem().toString());
                rs.afterLast();
                b = 1;
              }
              if (b == 0) {
                JOptionPane.showMessageDialog(
                    null, "No hay ventas en Mes selecionado", "Error", JOptionPane.YES_OPTION);
              }
            }

          } else {
            JOptionPane.showMessageDialog(
                null, "Selecciona un mes", "Error", JOptionPane.YES_OPTION);
          }
          break;
        case 2:
          if (cmbmescompania.getSelectedIndex() != 0) {
            String dato = null;
            if (cmbcompaniames.getSelectedIndex() != 0) {
              if (cmbmescompania.getSelectedIndex() < 10) {
                int mes = cmbmescompania.getSelectedIndex();
                dato = "0" + String.valueOf(mes);
              }
              Class.forName(driver).newInstance();
              con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
              st = con.createStatement();
              rs =
                  st.executeQuery(
                      "SELECT * FROM venta WHERE MONTH(fechacreacion) = '"
                          + dato
                          + "' and operador='"
                          + cmbcompaniames.getSelectedItem().toString()
                          + "'");
              while (rs.next()) {
                rs.beforeFirst();
                Informes.generalxmesycia(
                    rs,
                    cmbmescompania.getSelectedItem().toString(),
                    cmbcompaniames.getSelectedItem().toString());
                rs.afterLast();
                b = 1;
              }
              if (b == 0) {
                JOptionPane.showMessageDialog(
                    null, "No hay ventas en Mes selecionado", "Error", JOptionPane.YES_OPTION);
              }

            } else {
              JOptionPane.showMessageDialog(
                  null, "Selecciona una compañía", "Error", JOptionPane.YES_OPTION);
            }

          } else {
            JOptionPane.showMessageDialog(
                null, "Selecciona un mes", "Error", JOptionPane.YES_OPTION);
          }
          break;
        case 3:
          b = 0;
          if (combomesdelegacion.getSelectedIndex() != 0) {
            String dato = null;
            if (combodelegaciongeneral.getSelectedIndex() != 0) {
              if (combomesdelegacion.getSelectedIndex() < 10) {
                int mes = combomesdelegacion.getSelectedIndex();
                dato = "0" + String.valueOf(mes);
              }
              Class.forName(driver).newInstance();
              con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
              st = con.createStatement();
              Statement st2 = con.createStatement();
              ResultSet rs2 =
                  st2.executeQuery(
                      "Select DISTINCT(delegacion) from comercial where gerente='"
                          + combodelegaciongeneral.getSelectedItem().toString()
                          + "'");

              rs =
                  st.executeQuery(
                      "SELECT * FROM venta WHERE MONTH(fechacreacion) = '"
                          + dato
                          + "' and usuario IN (SELECT usuario FROM comercial where gerente='"
                          + combodelegaciongeneral.getSelectedItem().toString()
                          + "')");
              rs2.next();
              String delegacion = rs2.getString("delegacion");
              while (rs.next()) {
                rs.beforeFirst();
                Informes.generalxdeleymes(
                    rs,
                    combomesdelegacion.getSelectedItem().toString(),
                    delegacion,
                    combodelegaciongeneral.getSelectedItem().toString());
                rs.afterLast();
                b = 1;
              }
              if (b == 0) {
                JOptionPane.showMessageDialog(
                    null,
                    "No hay ventas en la combinación selecionada",
                    "Error",
                    JOptionPane.YES_OPTION);
              }
            } else {
              JOptionPane.showMessageDialog(
                  null, "Selecciona una Delegación", "Error", JOptionPane.YES_OPTION);
            }

          } else {
            JOptionPane.showMessageDialog(
                null, "Selecciona un mes", "Error", JOptionPane.YES_OPTION);
          }
          break;

        case 4:
          b = 0;
          Class.forName(driver).newInstance();
          con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
          st = con.createStatement();
          Calendar fecha = new GregorianCalendar();
          int amo = fecha.get(Calendar.YEAR);
          int mes1 = fecha.get(Calendar.MONTH);
          int dia = fecha.get(Calendar.DAY_OF_MONTH);
          String fechafin = +amo + "-" + (mes1 + 1) + "-" + dia;
          // String fecha = combopdfano.getSelectedItem().toString() + "-" +
          // combopdfmes.getSelectedItem().toString() + "-" +
          // compdfdia.getSelectedItem().toString();
          rs =
              st.executeQuery(
                  "SELECT * FROM visita WHERE fechafin ='"
                      + fechafin
                      + "' and estado='PENDIENTE' ");
          if (rs.next()) {
            b = 1;
            Informes.visitasindividuales(rs);
          }
          break;
        case 5:
          if (combovisitasmesgeneral.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(
                null, "Por favor selecciona el Mes", "Error", JOptionPane.YES_OPTION);
          } else {
            if (combovisitasmesgeneral.getSelectedIndex() < 10) {
              int mes = combovisitasmesgeneral.getSelectedIndex();
              dato = "0" + String.valueOf(mes);
            }
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM visita where MONTH(fecha) = '" + dato + "' ");
            if (rs.next()) {
              Informes.visitasmensuales(rs, combovisitasmesgeneral.getSelectedItem().toString());
            } else {
              JOptionPane.showMessageDialog(
                  null, "No hay citas este Mes", "Error", JOptionPane.YES_OPTION);
            }
          }
          break;
        case 6:
          if (combonomagentemes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(
                null, "Por favor selecciona Un/a Agente", "Error", JOptionPane.YES_OPTION);
          } else {
            if (comboagentemes.getSelectedIndex() != 0) {
              if (comboagentemes.getSelectedIndex() < 10) {
                int mes = comboagentemes.getSelectedIndex();
                dato = "0" + String.valueOf(mes);
              }
              Class.forName(driver).newInstance();
              con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
              st = con.createStatement();
              String partes[] = combonomagentemes.getSelectedItem().toString().split("-");
              System.out.println(partes[1]);
              String agente = partes[1];
              System.out.println(partes[0]);
              String nombre = partes[0];
              rs =
                  st.executeQuery(
                      "SELECT * FROM visita where MONTH(fecha) = '"
                          + dato
                          + "' and teleoperadora='"
                          + agente
                          + "'");
              if (rs.next()) {
                Informes.visitasmensualesxagente(
                    rs, comboagentemes.getSelectedItem().toString(), nombre);
              } else {
                JOptionPane.showMessageDialog(
                    null,
                    "No hay citas este Mes para el/la agente indicado",
                    "Error",
                    JOptionPane.YES_OPTION);
              }
            } else {
              JOptionPane.showMessageDialog(
                  null, "Selecciona un mes", "Error", JOptionPane.YES_OPTION);
            }
          }
          break;
        case 7:
          if (combodistribuidormes.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(
                null, "Por favor selecciona un Distribuidor", "Error", JOptionPane.YES_OPTION);
          } else {
            if (combodistrmes.getSelectedIndex() != 0) {
              if (combodistrmes.getSelectedIndex() < 10) {
                int mes = combodistrmes.getSelectedIndex();
                dato = "0" + String.valueOf(mes);
              }
              Class.forName(driver).newInstance();
              con = DriverManager.getConnection(urlMysql + "sencitel", "sencitel", "Ludwig1753");
              st = con.createStatement();
              rs =
                  st.executeQuery(
                      "SELECT * FROM visita where MONTH(fecha) = '"
                          + dato
                          + "' and distribuidor='"
                          + combodistribuidormes.getSelectedItem().toString()
                          + "'");
              if (rs.next()) {
                Informes.visitasmensualesxdistri(
                    rs,
                    combodistrmes.getSelectedItem().toString(),
                    combodistribuidormes.getSelectedItem().toString());
              } else {
                JOptionPane.showMessageDialog(
                    null,
                    "No hay citas este Mes para distribuidor indicado",
                    "Error",
                    JOptionPane.YES_OPTION);
              }
            } else {
              JOptionPane.showMessageDialog(
                  null, "Selecciona un mes", "Error", JOptionPane.YES_OPTION);
            }
          }
          break;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
      Logger.getLogger(Pdfinformes.class.getName()).log(Level.SEVERE, null, ex);
    }
  } 

  private void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) { 
    this.setVisible(false);
  } 

  private void cmbcompaniamesActionPerformed(
      java.awt.event.ActionEvent evt) { //
  } 

  private void cmbmescompaniaActionPerformed(
      java.awt.event.ActionEvent evt) { 
    cmbcompaniames.setEnabled(true);
  } 

  private void cmbgerenActionPerformed(
      java.awt.event.ActionEvent evt) { //
  } 

  private void combopdfdelegacionActionPerformed(
      java.awt.event.ActionEvent evt) { 
    cmbgeren.removeAllItems();
    if (!combopdfdelegacion.getSelectedItem().toString().equals("-")) {
      try {
        st = con.createStatement();
        rs =
            st.executeQuery(
                "select distinct(gerente),nombre from comercial where delegacion='"
                    + combopdfdelegacion.getSelectedItem().toString()
                    + "' and usuario in (select distinct(gerente) from comercial)");
        rs.first();
        do {
          String de = rs.getString("Gerente") + "-" + rs.getString("nombre");
          cmbgeren.addItem(de);
          cmbgeren.setEnabled(true);
        } while (rs.next());

      } catch (SQLException ex) {
        Logger.getLogger(Pdfinformes.class.getName()).log(Level.SEVERE, null, ex);
      }

    } else {
      cmbgeren.setEnabled(false);
    }
  } 

  /** @param args the command line arguments */
  public static void main(String args[]) {
   
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Pdfinformes.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Pdfinformes.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Pdfinformes.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Pdfinformes.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    

    
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            Pdfinformes dialog = new Pdfinformes(new javax.swing.JFrame(), true);
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

  private javax.swing.JButton btnimprimir;
  private javax.swing.JComboBox cmbcompaniames;
  private javax.swing.JComboBox cmbgeren;
  private javax.swing.JComboBox cmbmescompania;
  private javax.swing.JComboBox cmbmespdfgeneral;
  private javax.swing.JComboBox comboagentemes;
  private javax.swing.JComboBox combodelegaciongeneral;
  private javax.swing.JComboBox combodistribuidormes;
  private javax.swing.JComboBox combodistrmes;
  private javax.swing.JComboBox combomesdelegacion;
  private javax.swing.JComboBox combonomagentemes;
  private javax.swing.JComboBox combopdfdelegacion;
  private javax.swing.JComboBox combovisitasmesgeneral;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JTabbedPane jTabbedPane1;
}

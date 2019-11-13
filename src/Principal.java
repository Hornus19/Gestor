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
import javax.swing.WindowConstants;

/** @author David Grande */
public class Principal extends javax.swing.JFrame {

  String logueado;
  int codi = -1;
  String fechafin;
  Connection con;
  ResultSet rs;
  Statement st;
  String driver = "com.mysql.jdbc.Driver";
  String urlMysql = "jdbc:mysql://localhost:3306/";
  int contador = 1;
  CargarClientePojo ccp = new CargarClientePojo();

  /** Creates new form Principal */
  public Principal(String usuario, String cod) {
    if (!usuario.equalsIgnoreCase("") || cod.equalsIgnoreCase("")) {
      initComponents();
      logueado = usuario;
      this.setVisible(true);
      buttonGroup1.add(Rdbtnlinea1ac);
      buttonGroup1.add(Rdbtnlinea1pt);
      buttonGroup1.add(Rdbtnlinea1ko);
      buttonGroup2.add(Rdbtnlinea2ac);
      buttonGroup2.add(Rdbtnlinea2pt);
      buttonGroup2.add(Rdbtnlinea2ko);
      buttonGroup3.add(Rdbtnlinea3ac);
      buttonGroup3.add(Rdbtnlinea3pt);
      buttonGroup3.add(Rdbtnlinea3ko);
      buttonGroup4.add(Rdbtnlinea4ac);
      buttonGroup4.add(Rdbtnlinea4pt);
      buttonGroup4.add(Rdbtnlinea4ko);
      buttonGroup5.add(Rdbtnlinea5ac);
      buttonGroup5.add(Rdbtnlinea5pt);
      buttonGroup5.add(Rdbtnlinea5ko);
      txtlinea1comofi.setEnabled(false);
      txtlinea1comagen.setEnabled(false);
      txtlinea1ptosagen.setEnabled(false);
      txtlinea1ptosofi.setEnabled(false);
      txtlinea2comofi.setEnabled(false);
      txtlinea2comagen.setEnabled(false);
      txtlinea2ptosagen.setEnabled(false);
      txtlinea2ptosofi.setEnabled(false);
      txtlinea3comofi.setEnabled(false);
      txtlinea3comagen.setEnabled(false);
      txtlinea3ptosagen.setEnabled(false);
      txtlinea3ptosofi.setEnabled(false);
      txtlinea4comofi.setEnabled(false);
      txtlinea4comagen.setEnabled(false);
      txtlinea4ptosagen.setEnabled(false);
      txtlinea4ptosofi.setEnabled(false);
      txtlinea5comofi.setEnabled(false);
      txtlinea5comagen.setEnabled(false);
      txtlinea5ptosagen.setEnabled(false);
      txtlinea5ptosofi.setEnabled(false);
      this.setLocationRelativeTo(null);
      Calendar fecha = new GregorianCalendar();
      int ano = fecha.get(Calendar.YEAR);
      int mes = fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      fechafin = dia + "-" + (mes + 1) + "-" + ano;
      deshabilitar();
      try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "Clientes", "sencitel", "Ludwig1753");
        txtfecha.setText(fechafin);

      } catch (SQLException
          | ClassNotFoundException
          | InstantiationException
          | IllegalAccessException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else {
      initComponents();
      logueado = usuario;
      this.setVisible(true);
      buttonGroup1.add(Rdbtnlinea1ac);
      buttonGroup1.add(Rdbtnlinea1pt);
      buttonGroup1.add(Rdbtnlinea1ko);
      buttonGroup2.add(Rdbtnlinea2ac);
      buttonGroup2.add(Rdbtnlinea2pt);
      buttonGroup2.add(Rdbtnlinea2ko);
      buttonGroup3.add(Rdbtnlinea3ac);
      buttonGroup3.add(Rdbtnlinea3pt);
      buttonGroup3.add(Rdbtnlinea3ko);
      buttonGroup4.add(Rdbtnlinea4ac);
      buttonGroup4.add(Rdbtnlinea4pt);
      buttonGroup4.add(Rdbtnlinea4ko);
      buttonGroup5.add(Rdbtnlinea5ac);
      buttonGroup5.add(Rdbtnlinea5pt);
      buttonGroup5.add(Rdbtnlinea5ko);
      txtlinea1comofi.setEnabled(false);
      txtlinea1comagen.setEnabled(false);
      txtlinea1ptosagen.setEnabled(false);
      txtlinea1ptosofi.setEnabled(false);
      txtlinea2comofi.setEnabled(false);
      txtlinea2comagen.setEnabled(false);
      txtlinea2ptosagen.setEnabled(false);
      txtlinea2ptosofi.setEnabled(false);
      txtlinea3comofi.setEnabled(false);
      txtlinea3comagen.setEnabled(false);
      txtlinea3ptosagen.setEnabled(false);
      txtlinea3ptosofi.setEnabled(false);
      txtlinea4comofi.setEnabled(false);
      txtlinea4comagen.setEnabled(false);
      txtlinea4ptosagen.setEnabled(false);
      txtlinea4ptosofi.setEnabled(false);
      txtlinea5comofi.setEnabled(false);
      txtlinea5comagen.setEnabled(false);
      txtlinea5ptosagen.setEnabled(false);
      txtlinea5ptosofi.setEnabled(false);
      this.setLocationRelativeTo(null);
      Calendar fecha = new GregorianCalendar();
      int ano = fecha.get(Calendar.YEAR);
      int mes = fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      fechafin = dia + "-" + (mes + 1) + "-" + ano;

      // deshabilitar();
      try {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "Clientes", "sencitel", "Ludwig1753");
        txtfecha.setText(fechafin);
        cargarcliente(cod);

      } catch (SQLException
          | ClassNotFoundException
          | InstantiationException
          | IllegalAccessException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  // limpiando campos

  public void limpiar() {
    txtdocumento.setText("");
    txtnombre.setText("");
    txtaltasmoviles.setText("");
    txtiua.setText("");
    txtnombre.setText("");
    txtnumfijo.setText("");
    txtvaps.setText("");
    txtobservaciones.setText("");
    txtoferta.setText("");
    txtportasmoviles.setText("");
    txtvcfijo.setText("");
    txtvcmovil.setText("");
    chekcontrato.setSelected(false);
    chekdocu.setSelected(false);
    txtidoferta.setText("");
    txtfechalinea1.setText("");
    txtfechalinea2.setText("");
    txtfechalinea3.setText("");
    txtfechalinea4.setText("");
    txtfechalinea5.setText("");
    txtlinea1.setText("");
    txtlinea2.setText("");
    txtlinea3.setText("");
    txtlinea4.setText("");
    txtlinea5.setText("");
    buttonGroup2.clearSelection();
    buttonGroup3.clearSelection();
    buttonGroup4.clearSelection();
    buttonGroup5.clearSelection();
    buttonGroup1.clearSelection();
    txtlinea1comofi.setText("");
    txtlinea1comagen.setText("");
    txtlinea1ptosagen.setText("");
    txtlinea1ptosofi.setText("");
    txtlinea2comofi.setText("");
    txtlinea2comagen.setText("");
    txtlinea2ptosagen.setText("");
    txtlinea2ptosofi.setText("");
    txtlinea3comofi.setText("");
    txtlinea3comagen.setText("");
    txtlinea3ptosagen.setText("");
    txtlinea3ptosofi.setText("");
    txtlinea4comofi.setText("");
    txtlinea4comagen.setText("");
    txtlinea4ptosagen.setText("");
    txtlinea4ptosofi.setText("");
    txtlinea5comofi.setText("");
    txtlinea5comagen.setText("");
    txtlinea5ptosagen.setText("");
    txtlinea5ptosofi.setText("");

    txtlinea1comofi.setEnabled(false);
    txtlinea1comagen.setEnabled(false);
    txtlinea1ptosagen.setEnabled(false);
    txtlinea1ptosofi.setEnabled(false);
    txtlinea2comofi.setEnabled(false);
    txtlinea2comagen.setEnabled(false);
    txtlinea2ptosagen.setEnabled(false);
    txtlinea2ptosofi.setEnabled(false);
    txtlinea3comofi.setEnabled(false);
    txtlinea3comagen.setEnabled(false);
    txtlinea3ptosagen.setEnabled(false);
    txtlinea3ptosofi.setEnabled(false);
    txtlinea4comofi.setEnabled(false);
    txtlinea4comagen.setEnabled(false);
    txtlinea4ptosagen.setEnabled(false);
    txtlinea4ptosofi.setEnabled(false);
    txtlinea5comofi.setEnabled(false);
    txtlinea5comagen.setEnabled(false);
    txtlinea5ptosagen.setEnabled(false);
    txtlinea5ptosofi.setEnabled(false);

    combocomerciales.setSelectedIndex(0);
    deshabilitar();
  }

  // deshabilitamos campos
  public void deshabilitar() {
    combodsitrOran.setEnabled(false);
    combocomerciales.setEnabled(false);
    combodelegaciones.setEnabled(false);
    txtdocumento.setEnabled(false);
    txtnombre.setEnabled(false);
    txtaltasmoviles.setEnabled(false);
    txtiua.setEnabled(false);
    txtnombre.setEnabled(false);
    txtnumfijo.setEnabled(false);
    txtfecha.setEnabled(false);
    txtobservaciones.setEnabled(false);
    txtoferta.setEnabled(false);
    txtportasmoviles.setEnabled(false);
    txtvcfijo.setEnabled(false);
    txtvcmovil.setEnabled(false);
    comboestados.setEnabled(false);
    combooperador.setEnabled(false);
    combosegmento.setEnabled(false);
    chekcontrato.setEnabled(false);
    chekdocu.setEnabled(false);
    combotecno.setEnabled(false);
    combotipo.setEnabled(false);
    checktv.setEnabled(false);
    txtidoferta.setEnabled(false);
    txtvaps.setEnabled(false);
    txtcargacliente.setEnabled(false);
    txtfechalinea1.setEnabled(false);
    txtfechalinea2.setEnabled(false);
    txtfechalinea3.setEnabled(false);
    txtfechalinea4.setEnabled(false);
    txtfechalinea5.setEnabled(false);
    txtlinea1.setEnabled(false);
    txtlinea2.setEnabled(false);
    txtlinea3.setEnabled(false);
    txtlinea4.setEnabled(false);
    txtlinea5.setEnabled(false);
    Rdbtnlinea1ac.setEnabled(false);
    Rdbtnlinea2ac.setEnabled(false);
    Rdbtnlinea3ac.setEnabled(false);
    Rdbtnlinea4ac.setEnabled(false);
    Rdbtnlinea5ac.setEnabled(false);
    Rdbtnlinea1pt.setEnabled(false);
    Rdbtnlinea2pt.setEnabled(false);
    Rdbtnlinea3pt.setEnabled(false);
    Rdbtnlinea4pt.setEnabled(false);
    Rdbtnlinea5pt.setEnabled(false);
    Rdbtnlinea5ko.setEnabled(false);
    Rdbtnlinea2ko.setEnabled(false);
    Rdbtnlinea1ko.setEnabled(false);
    Rdbtnlinea3ko.setEnabled(false);
    Rdbtnlinea4ko.setEnabled(false);
  }

  // habilitamos campos
  public void habilitar() {
    txtdocumento.setEnabled(true);
    txtnombre.setEnabled(true);
    txtaltasmoviles.setEnabled(true);
    txtiua.setEnabled(true);
    txtnombre.setEnabled(true);
    txtnumfijo.setEnabled(true);
    txtobservaciones.setEnabled(true);
    txtoferta.setEnabled(true);
    txtportasmoviles.setEnabled(true);
    txtvcfijo.setEnabled(true);
    txtvcmovil.setEnabled(true);
    combooperador.setEnabled(true);
    combosegmento.setEnabled(true);
    chekcontrato.setEnabled(true);
    chekdocu.setEnabled(true);
    combotecno.setEnabled(true);
    checktv.setEnabled(true);
    txtidoferta.setEnabled(true);
    txtvaps.setEnabled(true);
  }

  // habilitamos campos modificaciones
  public void habilitarmod() {
    //        combodsitrOran.setEnabled(true);
    txtnombre.setEnabled(true);
    txtiua.setEnabled(true);
    txtnombre.setEnabled(true);
    txtnumfijo.setEnabled(true);
    txtobservaciones.setEnabled(true);
    txtoferta.setEnabled(true);
    txtvcfijo.setEnabled(true);
    txtvcmovil.setEnabled(true);
    chekcontrato.setEnabled(true);
    chekdocu.setEnabled(true);
    combotecno.setEnabled(true);
    checktv.setEnabled(true);
    txtidoferta.setEnabled(true);
    txtvaps.setEnabled(true);
    comboestados.setEditable(true);
  }

  Principal() {}

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    buttonGroup2 = new javax.swing.ButtonGroup();
    buttonGroup3 = new javax.swing.ButtonGroup();
    buttonGroup4 = new javax.swing.ButtonGroup();
    buttonGroup5 = new javax.swing.ButtonGroup();
    jRadioButton4 = new javax.swing.JRadioButton();
    btnsalirP = new javax.swing.JButton();
    combodelegaciones = new javax.swing.JComboBox<>();
    combocomerciales = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    btnnuevo = new javax.swing.JButton();
    btnguardar = new javax.swing.JButton();
    btnbuscar = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    txtdocumento = new javax.swing.JTextField();
    txtnombre = new javax.swing.JTextField();
    txtcodcomercial = new javax.swing.JLabel();
    combosegmento = new javax.swing.JComboBox<>();
    combooperador = new javax.swing.JComboBox<>();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    txtoferta = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    txtaltasmoviles = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    txtportasmoviles = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    txtnumfijo = new javax.swing.JTextField();
    txtiua = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    txtvcmovil = new javax.swing.JTextField();
    jLabel12 = new javax.swing.JLabel();
    txtvcfijo = new javax.swing.JTextField();
    jLabel13 = new javax.swing.JLabel();
    chekdocu = new javax.swing.JCheckBox();
    jLabel14 = new javax.swing.JLabel();
    chekcontrato = new javax.swing.JCheckBox();
    comboestados = new javax.swing.JComboBox<>();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    txtidoferta = new javax.swing.JTextField();
    jLabel17 = new javax.swing.JLabel();
    checktv = new javax.swing.JCheckBox();
    jLabel18 = new javax.swing.JLabel();
    jLabel19 = new javax.swing.JLabel();
    jLabel20 = new javax.swing.JLabel();
    txtfecha = new javax.swing.JTextField();
    combotecno = new javax.swing.JComboBox();
    combotipo = new javax.swing.JComboBox();
    txtcargacliente = new javax.swing.JTextField();
    btncargar = new javax.swing.JButton();
    btngenpdf = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtvaps = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    txtobservaciones = new javax.swing.JTextArea();
    btncomerciales = new javax.swing.JButton();
    txtlinea1 = new javax.swing.JTextField();
    txtfechalinea1 = new javax.swing.JTextField();
    txtlinea2 = new javax.swing.JTextField();
    txtfechalinea2 = new javax.swing.JTextField();
    txtlinea3 = new javax.swing.JTextField();
    txtfechalinea3 = new javax.swing.JTextField();
    txtlinea4 = new javax.swing.JTextField();
    txtfechalinea4 = new javax.swing.JTextField();
    txtlinea5 = new javax.swing.JTextField();
    txtfechalinea5 = new javax.swing.JTextField();
    Rdbtnlinea1ac = new javax.swing.JRadioButton();
    Rdbtnlinea1pt = new javax.swing.JRadioButton();
    Rdbtnlinea2ac = new javax.swing.JRadioButton();
    Rdbtnlinea2pt = new javax.swing.JRadioButton();
    Rdbtnlinea3ac = new javax.swing.JRadioButton();
    Rdbtnlinea3pt = new javax.swing.JRadioButton();
    Rdbtnlinea4ac = new javax.swing.JRadioButton();
    Rdbtnlinea4pt = new javax.swing.JRadioButton();
    Rdbtnlinea5ac = new javax.swing.JRadioButton();
    Rdbtnlinea5pt = new javax.swing.JRadioButton();
    Rdbtnlinea2ko = new javax.swing.JRadioButton();
    Rdbtnlinea1ko = new javax.swing.JRadioButton();
    Rdbtnlinea3ko = new javax.swing.JRadioButton();
    Rdbtnlinea4ko = new javax.swing.JRadioButton();
    Rdbtnlinea5ko = new javax.swing.JRadioButton();
    jLabel21 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    txtlinea1ptosagen = new javax.swing.JTextField();
    txtlinea1comagen = new javax.swing.JTextField();
    txtlinea1ptosofi = new javax.swing.JTextField();
    txtlinea1comofi = new javax.swing.JTextField();
    txtlinea2comofi = new javax.swing.JTextField();
    txtlinea2ptosofi = new javax.swing.JTextField();
    txtlinea2comagen = new javax.swing.JTextField();
    txtlinea2ptosagen = new javax.swing.JTextField();
    txtlinea3comofi = new javax.swing.JTextField();
    txtlinea3ptosofi = new javax.swing.JTextField();
    txtlinea3comagen = new javax.swing.JTextField();
    txtlinea3ptosagen = new javax.swing.JTextField();
    txtlinea4comofi = new javax.swing.JTextField();
    txtlinea4ptosofi = new javax.swing.JTextField();
    txtlinea4comagen = new javax.swing.JTextField();
    txtlinea4ptosagen = new javax.swing.JTextField();
    txtlinea5comofi = new javax.swing.JTextField();
    txtlinea5ptosofi = new javax.swing.JTextField();
    txtlinea5comagen = new javax.swing.JTextField();
    txtlinea5ptosagen = new javax.swing.JTextField();
    btnabrirvisitas = new javax.swing.JButton();
    jLabel25 = new javax.swing.JLabel();
    combodsitrOran = new javax.swing.JComboBox<>();

    jRadioButton4.setText("KO");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Grupanet");

    btnsalirP.setText("Salir");
    btnsalirP.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsalirPActionPerformed(evt);
          }
        });

    combodelegaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
    combodelegaciones.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combodelegacionesActionPerformed(evt);
          }
        });

    combocomerciales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
    combocomerciales.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combocomercialesActionPerformed(evt);
          }
        });

    jLabel1.setText("Fecha :");

    btnnuevo.setText("Nuevo");
    btnnuevo.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnnuevoActionPerformed(evt);
          }
        });

    btnguardar.setText("Guardar");
    btnguardar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnguardarActionPerformed(evt);
          }
        });

    btnbuscar.setText("Buscar");
    btnbuscar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnbuscarActionPerformed(evt);
          }
        });

    jLabel2.setText("DNI / CIF :");

    jLabel3.setText("Nombre :");
    jLabel3.setMaximumSize(new java.awt.Dimension(55, 16));
    jLabel3.setMinimumSize(new java.awt.Dimension(55, 16));

    txtdocumento.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtdocumentoFocusLost(evt);
          }
        });

    txtnombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

    combosegmento.setModel(
        new javax.swing.DefaultComboBoxModel<>(new String[] {"-", "Residencial", "Empresa"}));

    combooperador.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {"-", "Orange", "Vodafone", "Yoigo", "MasMovil", "Centralita"}));
    combooperador.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combooperadorActionPerformed(evt);
          }
        });

    jLabel4.setText("Operador :");

    jLabel5.setText("Segmento :");

    jLabel6.setText("Oferta");

    jLabel7.setText("Altas Moviles :");

    jLabel8.setText("Portas Moviles :");

    txtportasmoviles.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtportasmovilesFocusLost(evt);
          }
        });

    jLabel9.setText("Nº Fijo :");

    jLabel10.setText("IUA :");

    jLabel11.setText("F. Inst :");

    jLabel12.setText("VC Fijo :");

    jLabel13.setText("Documentacion :");

    chekdocu.setText("Si");

    jLabel14.setText("Contrato :");

    chekcontrato.setText("Si");

    comboestados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));

    jLabel15.setText("Estado :");

    jLabel16.setText("Id OFerta :");

    jLabel17.setText("Observaciones :");

    checktv.setText("Si");

    jLabel18.setText("TV :");

    jLabel19.setText("VAP :");

    jLabel20.setText("Lineas Moviles :");

    combotecno.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-", "ADSL", "FIBRA"}));
    combotecno.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            combotecnoActionPerformed(evt);
          }
        });

    combotipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-", "PROPIA", "NEBA"}));

    txtcargacliente.addFocusListener(
        new java.awt.event.FocusAdapter() {
          public void focusLost(java.awt.event.FocusEvent evt) {
            txtcargaclienteFocusLost(evt);
          }
        });

    btncargar.setText("Modificaciones");
    btncargar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncargarActionPerformed(evt);
          }
        });

    btngenpdf.setText("PDF");
    btngenpdf.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btngenpdfActionPerformed(evt);
          }
        });

    txtvaps.setColumns(20);
    txtvaps.setRows(5);
    jScrollPane2.setViewportView(txtvaps);

    txtobservaciones.setColumns(20);
    txtobservaciones.setRows(5);
    jScrollPane3.setViewportView(txtobservaciones);

    btncomerciales.setText("Comercial");
    btncomerciales.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btncomercialesActionPerformed(evt);
          }
        });

    Rdbtnlinea1ac.setForeground(new java.awt.Color(0, 255, 0));
    Rdbtnlinea1ac.setText("AC");
    Rdbtnlinea1ac.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea1acActionPerformed(evt);
          }
        });

    Rdbtnlinea1pt.setForeground(new java.awt.Color(255, 255, 51));
    Rdbtnlinea1pt.setText("PT");
    Rdbtnlinea1pt.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea1ptActionPerformed(evt);
          }
        });

    Rdbtnlinea2ac.setForeground(new java.awt.Color(0, 255, 0));
    Rdbtnlinea2ac.setText("AC");
    Rdbtnlinea2ac.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea2acActionPerformed(evt);
          }
        });

    Rdbtnlinea2pt.setForeground(new java.awt.Color(255, 255, 51));
    Rdbtnlinea2pt.setText("PT");

    Rdbtnlinea3ac.setForeground(new java.awt.Color(0, 255, 0));
    Rdbtnlinea3ac.setText("AC");
    Rdbtnlinea3ac.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea3acActionPerformed(evt);
          }
        });

    Rdbtnlinea3pt.setForeground(new java.awt.Color(255, 255, 51));
    Rdbtnlinea3pt.setText("PT");

    Rdbtnlinea4ac.setForeground(new java.awt.Color(0, 255, 0));
    Rdbtnlinea4ac.setText("AC");
    Rdbtnlinea4ac.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea4acActionPerformed(evt);
          }
        });

    Rdbtnlinea4pt.setForeground(new java.awt.Color(255, 255, 51));
    Rdbtnlinea4pt.setText("PT");

    Rdbtnlinea5ac.setForeground(new java.awt.Color(0, 255, 0));
    Rdbtnlinea5ac.setText("AC");
    Rdbtnlinea5ac.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea5acActionPerformed(evt);
          }
        });

    Rdbtnlinea5pt.setForeground(new java.awt.Color(255, 255, 51));
    Rdbtnlinea5pt.setText("PT");

    Rdbtnlinea2ko.setForeground(new java.awt.Color(255, 0, 0));
    Rdbtnlinea2ko.setText("KO");

    Rdbtnlinea1ko.setForeground(new java.awt.Color(255, 0, 0));
    Rdbtnlinea1ko.setText("KO");
    Rdbtnlinea1ko.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            Rdbtnlinea1koActionPerformed(evt);
          }
        });

    Rdbtnlinea3ko.setForeground(new java.awt.Color(255, 0, 0));
    Rdbtnlinea3ko.setText("KO");

    Rdbtnlinea4ko.setForeground(new java.awt.Color(255, 0, 0));
    Rdbtnlinea4ko.setText("KO");

    Rdbtnlinea5ko.setForeground(new java.awt.Color(255, 0, 0));
    Rdbtnlinea5ko.setText("KO");

    jLabel21.setText("Com. Ofi");

    jLabel22.setText("Ptos. Ofi");

    jLabel23.setText("Com. Ag");

    jLabel24.setText("Ptos Ag");

    txtlinea2ptosofi.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea2ptosofiActionPerformed(evt);
          }
        });

    txtlinea2comagen.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea2comagenActionPerformed(evt);
          }
        });

    txtlinea3ptosofi.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea3ptosofiActionPerformed(evt);
          }
        });

    txtlinea3comagen.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea3comagenActionPerformed(evt);
          }
        });

    txtlinea4ptosofi.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea4ptosofiActionPerformed(evt);
          }
        });

    txtlinea4comagen.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea4comagenActionPerformed(evt);
          }
        });

    txtlinea5ptosofi.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea5ptosofiActionPerformed(evt);
          }
        });

    txtlinea5comagen.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtlinea5comagenActionPerformed(evt);
          }
        });

    btnabrirvisitas.setText("Visitas");
    btnabrirvisitas.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnabrirvisitasActionPerformed(evt);
          }
        });

    jLabel25.setText("Distribuidor :");

    combodsitrOran.setModel(
        new javax.swing.DefaultComboBoxModel<>(new String[] {"-", "LUSANET", "WETHINK"}));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
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
                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        jLabel9,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        50,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                    .addComponent(
                                                                        txtnumfijo,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        82,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addGap(6, 6, 6))
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(jLabel7)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(
                                                                        txtaltasmoviles,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        29,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        jLabel8,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        95,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(
                                                                        txtportasmoviles,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        30,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE))
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(jLabel10)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addComponent(
                                                                        txtiua,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        96,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE))))
                                            .addComponent(
                                                jLabel17,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                106,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING)
                                                            .addComponent(
                                                                jLabel19,
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        jLabel11,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        44,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .UNRELATED)
                                                                    .addComponent(
                                                                        txtvcmovil,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        83,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)))
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(
                                                        txtvcfijo,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(
                                                jScrollPane2,
                                                javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGap(97, 97, 97)
                                                                    .addComponent(jLabel18)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .UNRELATED)
                                                                    .addComponent(checktv))
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGap(270, 270, 270)
                                                                    .addComponent(jLabel13)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .UNRELATED)
                                                                    .addComponent(chekdocu)))
                                                    .addGap(78, 78, 78)
                                                    .addComponent(jLabel14)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(chekcontrato)
                                                    .addGap(12, 12, 12))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addComponent(jLabel20)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addComponent(
                                                                                txtlinea1,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                layout
                                                                                    .createParallelGroup(
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .Alignment
                                                                                            .LEADING,
                                                                                        false)
                                                                                    .addComponent(
                                                                                        txtlinea3,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE,
                                                                                        80,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE)
                                                                                    .addComponent(
                                                                                        txtlinea2,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE,
                                                                                        80,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE)
                                                                                    .addComponent(
                                                                                        txtlinea4,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE,
                                                                                        80,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE)
                                                                                    .addComponent(
                                                                                        txtlinea5,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE,
                                                                                        80,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE)))
                                                                    .addGap(18, 18, 18)
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING,
                                                                                false)
                                                                            .addComponent(
                                                                                txtfechalinea1,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtfechalinea2,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtfechalinea3,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtfechalinea4,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtfechalinea5,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                80,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE))
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addComponent(
                                                                                Rdbtnlinea2ac,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                Rdbtnlinea3ac,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                Rdbtnlinea4ac,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                Rdbtnlinea5ac,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                Rdbtnlinea1ac,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE))
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING,
                                                                                false)
                                                                            .addComponent(
                                                                                Rdbtnlinea1pt)
                                                                            .addComponent(
                                                                                Rdbtnlinea2pt,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea3pt,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea4pt,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea5pt,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING))
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED)
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addComponent(
                                                                                Rdbtnlinea2ko,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea1ko,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea3ko,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea4ko,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                Rdbtnlinea5ko,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING))))
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING,
                                                                false)
                                                            .addComponent(txtlinea5comofi)
                                                            .addComponent(txtlinea4comofi)
                                                            .addComponent(txtlinea2comofi)
                                                            .addComponent(txtlinea1comofi)
                                                            .addComponent(
                                                                jLabel21,
                                                                javax.swing.GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                javax.swing.GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                txtlinea3comofi,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                52,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE))
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addGroup(
                                                                                layout
                                                                                    .createSequentialGroup()
                                                                                    .addComponent(
                                                                                        jLabel22)
                                                                                    .addGap(
                                                                                        21, 21, 21))
                                                                            .addGroup(
                                                                                layout
                                                                                    .createSequentialGroup()
                                                                                    .addGroup(
                                                                                        layout
                                                                                            .createParallelGroup(
                                                                                                javax
                                                                                                    .swing
                                                                                                    .GroupLayout
                                                                                                    .Alignment
                                                                                                    .TRAILING)
                                                                                            .addComponent(
                                                                                                txtlinea1ptosofi,
                                                                                                javax
                                                                                                    .swing
                                                                                                    .GroupLayout
                                                                                                    .PREFERRED_SIZE,
                                                                                                59,
                                                                                                javax
                                                                                                    .swing
                                                                                                    .GroupLayout
                                                                                                    .PREFERRED_SIZE)
                                                                                            .addComponent(
                                                                                                txtlinea2ptosofi,
                                                                                                javax
                                                                                                    .swing
                                                                                                    .GroupLayout
                                                                                                    .PREFERRED_SIZE,
                                                                                                59,
                                                                                                javax
                                                                                                    .swing
                                                                                                    .GroupLayout
                                                                                                    .PREFERRED_SIZE))
                                                                                    .addGap(
                                                                                        18, 18,
                                                                                        18)))
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                layout
                                                                                    .createParallelGroup(
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .Alignment
                                                                                            .LEADING,
                                                                                        false)
                                                                                    .addComponent(
                                                                                        jLabel23,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .DEFAULT_SIZE,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .DEFAULT_SIZE,
                                                                                        Short
                                                                                            .MAX_VALUE)
                                                                                    .addComponent(
                                                                                        txtlinea1comagen,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE,
                                                                                        50,
                                                                                        javax.swing
                                                                                            .GroupLayout
                                                                                            .PREFERRED_SIZE))
                                                                            .addComponent(
                                                                                txtlinea2comagen,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                49,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)))
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING)
                                                                            .addComponent(
                                                                                txtlinea3ptosofi,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtlinea4ptosofi,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtlinea5ptosofi,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                58,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE))
                                                                    .addGap(18, 18, 18)
                                                                    .addGroup(
                                                                        layout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addComponent(
                                                                                txtlinea5comagen,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                49,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtlinea4comagen,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                49,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE)
                                                                            .addComponent(
                                                                                txtlinea3comagen,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                49,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE))))
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING,
                                                                false)
                                                            .addComponent(txtlinea5ptosagen)
                                                            .addComponent(txtlinea4ptosagen)
                                                            .addComponent(txtlinea3ptosagen)
                                                            .addComponent(txtlinea2ptosagen)
                                                            .addComponent(
                                                                jLabel24,
                                                                javax.swing.GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                javax.swing.GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                txtlinea1ptosagen,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                48,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE)))))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addComponent(btnbuscar)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(59, 59, 59)
                                                    .addComponent(
                                                        jLabel15,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        77,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(
                                                        btngenpdf,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        65,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(69, 69, 69)
                                                    .addComponent(
                                                        comboestados,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        238,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(
                                                        btnabrirvisitas,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        86,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(btncomerciales)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addComponent(btncargar)
                                                    .addGap(59, 59, 59)
                                                    .addComponent(btnguardar)
                                                    .addGap(52, 52, 52)
                                                    .addComponent(btnnuevo)
                                                    .addGap(51, 51, 51)))
                                    .addComponent(
                                        btnsalirP,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        63,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        false)
                                                    .addComponent(
                                                        jLabel5,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addComponent(
                                                        jLabel2,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                            .addComponent(jLabel1))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        combosegmento,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        115,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addGap(12, 12, 12))
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        txtdocumento,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        115,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .UNRELATED)))
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addComponent(
                                                                jLabel3,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                65,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE)
                                                            .addComponent(jLabel4)))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addComponent(
                                                        txtfecha,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        115,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(38, 38, 38)
                                                    .addComponent(
                                                        txtcargacliente,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        39,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addComponent(
                                                        combooperador,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        141,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(jLabel25)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .UNRELATED)
                                                    .addComponent(
                                                        combodsitrOran,
                                                        0,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .UNRELATED)
                                                    .addComponent(jLabel16)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .UNRELATED)
                                                    .addComponent(
                                                        txtidoferta,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        186,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(
                                                        combodelegaciones,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .UNRELATED)
                                                    .addComponent(
                                                        txtcodcomercial,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        56,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(
                                                        combocomerciales,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        143,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtnombre)))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        jLabel6,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        63,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        combotecno,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        70,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)
                                    .addComponent(
                                        combotipo,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        73,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtoferta))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                txtcodcomercial,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                26,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(
                                        combodelegaciones,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        combocomerciales,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(
                                        txtfecha,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        txtcargacliente,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(22, 22, 22)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                jLabel2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdocumento))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(
                                        jLabel5,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                jLabel3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtnombre,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                combosegmento,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(
                                                combooperador,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addComponent(
                                                txtidoferta,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25)
                                            .addComponent(
                                                combodsitrOran,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(
                                        combotecno,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        combotipo,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(
                                txtoferta,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                jLabel7,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                24,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtaltasmoviles,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                jLabel8,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtportasmoviles,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                jLabel9,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                13,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(
                                                        txtnumfijo,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(
                                                        txtiua,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10)))
                                    .addGap(14, 14, 14)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(
                                                txtvcfijo,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(
                                                txtvcmovil,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel19)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        jScrollPane2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        97,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel24))
                                    .addGap(21, 21, 21)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                txtlinea1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtfechalinea1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rdbtnlinea1ac)
                                            .addComponent(Rdbtnlinea1pt)
                                            .addComponent(Rdbtnlinea1ko)
                                            .addComponent(
                                                txtlinea1ptosagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea1comagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea1ptosofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea1comofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                txtlinea2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtfechalinea2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rdbtnlinea2ac)
                                            .addComponent(Rdbtnlinea2pt)
                                            .addComponent(Rdbtnlinea2ko)
                                            .addComponent(
                                                txtlinea2ptosagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea2comagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea2ptosofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea2comofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                txtlinea3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtfechalinea3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rdbtnlinea3ac)
                                            .addComponent(Rdbtnlinea3pt)
                                            .addComponent(Rdbtnlinea3ko)
                                            .addComponent(
                                                txtlinea3ptosagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea3comagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea3ptosofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea3comofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(8, 8, 8)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                txtlinea4,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtfechalinea4,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rdbtnlinea4ac)
                                            .addComponent(Rdbtnlinea4pt)
                                            .addComponent(Rdbtnlinea4ko)
                                            .addComponent(
                                                txtlinea4ptosagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea4comagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea4ptosofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea4comofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                txtlinea5,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtfechalinea5,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rdbtnlinea5ac)
                                            .addComponent(Rdbtnlinea5pt)
                                            .addComponent(Rdbtnlinea5ko)
                                            .addComponent(
                                                txtlinea5ptosagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea5comagen,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea5ptosofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                txtlinea5comofi,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(15, 15, 15)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(chekdocu)
                            .addComponent(jLabel14)
                            .addComponent(chekcontrato)
                            .addComponent(checktv)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        jScrollPane3,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                comboestados,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                btnabrirvisitas,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                41,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(
                                        btnsalirP,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        btnnuevo,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        btnguardar,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        btnbuscar,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        btncargar,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        btngenpdf,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        btncomerciales,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void btnsalirPActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnsalirPActionPerformed
    System.exit(0);
  } // GEN-LAST:event_btnsalirPActionPerformed

  private void combodelegacionesActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_combodelegacionesActionPerformed
    combocomerciales.removeAllItems();
    combocomerciales.addItem("-");
    try {
      if (combodelegaciones.getSelectedIndex() != -1 && combodelegaciones.getSelectedIndex() != 0) {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "Clientes", "sencitel", "Ludwig1753");
        st = con.createStatement();
        String delegacion = combodelegaciones.getSelectedItem().toString();
        rs =
            st.executeQuery(
                "select nombre from comerciales where delegacion='"
                    + delegacion
                    + "' and activo='SI'");
        if (rs.next()) {
          do {
            combocomerciales.addItem(rs.getString("nombre"));
          } while (rs.next());
        }
        txtcodcomercial.setText("");
        combocomerciales.setEnabled(true);
        combocomerciales.setSelectedIndex(-1);
      }
    } catch (SQLException
        | ClassNotFoundException
        | InstantiationException
        | IllegalAccessException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_combodelegacionesActionPerformed
  //  Nuevo cliente
  private void btnnuevoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnnuevoActionPerformed
    limpiar();
    combodelegaciones.setEnabled(true);
    codi = -1;
    txtcargacliente.setText("");
    if (contador < 2) {
      try {
        st = con.createStatement();
        rs = st.executeQuery("select DISTINCT(delegacion) from comerciales ");

        while (rs.next()) {
          combodelegaciones.addItem(rs.getString("delegacion"));
          contador += 1;
        }
      } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  } // GEN-LAST:event_btnnuevoActionPerformed

  private void combocomercialesActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_combocomercialesActionPerformed

    try {
      if (combocomerciales.getSelectedIndex() != -1 && combocomerciales.getSelectedIndex() != 0) {

        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(urlMysql + "Clientes", "sencitel", "Ludwig1753");
        st = con.createStatement();
        String delegacion = combodelegaciones.getSelectedItem().toString();
        String com = combocomerciales.getSelectedItem().toString();
        rs =
            st.executeQuery(
                "select usuario from comerciales where nombre='"
                    + com
                    + "' and delegacion='"
                    + delegacion
                    + "' and activo='SI' ");
        while (rs.next()) {
          txtcodcomercial.setText(rs.getString("usuario"));
          habilitar();
        }
      }
    } catch (SQLException
        | ClassNotFoundException
        | InstantiationException
        | IllegalAccessException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_combocomercialesActionPerformed
  // validación dni
  private void txtdocumentoFocusLost(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_txtdocumentoFocusLost
    txtdocumento.setText(txtdocumento.getText().toUpperCase());
    int dni = validaciones.Validar.comprobar(txtdocumento.getText());
    if (dni < 0) {
      JOptionPane.showMessageDialog(
          null, "El documentos escrito no es valido", "Error", JOptionPane.WARNING_MESSAGE);
      txtdocumento.requestFocus(true);
    }
  } // GEN-LAST:event_txtdocumentoFocusLost
  // abro ventana buscar clientes
  private void btnbuscarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnbuscarActionPerformed
    Busqueda bs = new Busqueda(this, true);
    this.setVisible(false);
    bs.setVisible(true);
    bs.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    if (!txtcargacliente.getText().equalsIgnoreCase("")) {
      this.dispose();
    }
  } // GEN-LAST:event_btnbuscarActionPerformed

  // guardar clientes tanto nuevos como antiguos
  private void btnguardarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnguardarActionPerformed
    String altas = "0",
        portas = "0",
        docu = "NO",
        contrato = "NO",
        tv = "NO",
        oferta = "",
        idoferta = "N/A",
        iua = "N/A",
        vcmovil = "N/A",
        vcfijo = "N/A",
        vaps = "N/A",
        obser = "N/A",
        lineas = "N/A",
        fijo = "N/A",
        estado,
        estado2,
        estado3,
        estado4,
        estado5;
    Boolean ok = true, ok1 = true;
    String comis = "NULL";
    int n = Integer.parseInt(txtportasmoviles.getText());
    int n1 = Integer.parseInt(txtaltasmoviles.getText());
    int ac = 0;
    n += n1;
    String[] parts = txtfecha.getText().split("-");
    String part1 = parts[0];
    String part2 = parts[1];
    String parte3 = parts[2];
    fechafin = parte3 + "-" + part2 + "-" + part1;
    try {
      Class.forName(driver).newInstance();
      con = DriverManager.getConnection(urlMysql + "Clientes", "sencitel", "Ludwig1753");

    } catch (SQLException
        | ClassNotFoundException
        | InstantiationException
        | IllegalAccessException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      if (codi == -1) {
        if (txtdocumento.getText().equalsIgnoreCase("")
            || txtnombre.getText().equalsIgnoreCase("")
            || txtoferta.getText().equalsIgnoreCase("")
            || combooperador.getSelectedItem().toString().equalsIgnoreCase("-")
            || combosegmento.getSelectedItem().toString().equalsIgnoreCase("-")
            || comboestados.getSelectedItem().toString().equalsIgnoreCase("-")) {
          ok1 = false;
          JOptionPane.showMessageDialog(
              null, "Faltan Campos Obligatorios por cubrir", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
          if (!txtaltasmoviles.getText().equals("")) {
            altas = txtaltasmoviles.getText();
          }
          if (!txtportasmoviles.getText().equals("")) {
            portas = txtportasmoviles.getText();
          }
          if (chekcontrato.isSelected()) {
            contrato = "SI";
          }
          if (chekdocu.isSelected()) {
            docu = "SI";
          }
          if (checktv.isSelected()) {
            tv = "SI";
          }
          if (combotecno.getSelectedItem().toString().equalsIgnoreCase("-")) {
            oferta = "-,-," + txtoferta.getText();
          } else {
            if (combotipo.getSelectedItem().toString().equalsIgnoreCase("-")) {
              JOptionPane.showMessageDialog(
                  null, "PROPIA O NEBA??", "Error", JOptionPane.WARNING_MESSAGE);

            } else {
              oferta =
                  combotecno.getSelectedItem().toString()
                      + ","
                      + combotipo.getSelectedItem().toString()
                      + ","
                      + txtoferta.getText();
            }
          }
          if (!txtidoferta.getText().equals("")) {
            idoferta = txtidoferta.getText();
          }
          if (!txtiua.getText().equals("")) {
            iua = txtiua.getText();
          }
          if (!txtvcmovil.getText().equals("")) {
            parts = txtvcmovil.getText().split("-");
            part1 = parts[0];
            part2 = parts[1];
            parte3 = parts[2];
            vcmovil = parte3 + "-" + part2 + "-" + part1;
          }
          if (!txtvcfijo.getText().equals("")) {
            parts = txtvcfijo.getText().split("-");
            part1 = parts[0];
            part2 = parts[1];
            parte3 = parts[2];
            vcfijo = parte3 + "-" + part2 + "-" + part1;
          }
          if (!txtvaps.getText().equals("")) {
            vaps = txtvaps.getText();
          }
          if (!txtobservaciones.getText().equals("")) {
            obser = txtobservaciones.getText();
          }

          if (n > 0) {
            switch (n) {
              case 1:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";
                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText()
                        + ",";

                lineas = txtlinea1.getText() + "," + txtfechalinea1.getText() + "," + estado;
                break;
              case 2:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2;
                break;
              case 3:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (Rdbtnlinea3ac.isSelected()) {
                  estado3 = "AC";

                } else {
                  if (Rdbtnlinea3pt.isSelected()) {
                    estado3 = "PT";
                  } else {
                    estado3 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();
                if (txtlinea3comofi.getText().equals("")) {
                  txtlinea3comofi.setText("-");
                }
                if (txtlinea3ptosofi.getText().equals("")) {
                  txtlinea3ptosofi.setText("-");
                }
                if (txtlinea3comagen.getText().equals("")) {
                  txtlinea3comagen.setText("-");
                }
                if (txtlinea3ptosagen.getText().equals("")) {
                  txtlinea3ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea3comofi.getText()
                        + ","
                        + txtlinea3ptosofi.getText()
                        + ","
                        + txtlinea3comagen.getText()
                        + ","
                        + txtlinea3ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2
                        + ","
                        + txtlinea3.getText()
                        + ","
                        + txtfechalinea3.getText()
                        + ","
                        + estado3;
                break;

              case 4:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (Rdbtnlinea3ac.isSelected()) {
                  estado3 = "AC";

                } else {
                  if (Rdbtnlinea3pt.isSelected()) {
                    estado3 = "PT";
                  } else {
                    estado3 = "KO";
                  }
                }
                if (Rdbtnlinea4ac.isSelected()) {
                  estado4 = "AC";

                } else {
                  if (Rdbtnlinea4pt.isSelected()) {
                    estado4 = "PT";
                  } else {
                    estado4 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();
                if (txtlinea3comofi.getText().equals("")) {
                  txtlinea3comofi.setText("-");
                }
                if (txtlinea3ptosofi.getText().equals("")) {
                  txtlinea3ptosofi.setText("-");
                }
                if (txtlinea3comagen.getText().equals("")) {
                  txtlinea3comagen.setText("-");
                }
                if (txtlinea3ptosagen.getText().equals("")) {
                  txtlinea3ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea3comofi.getText()
                        + ","
                        + txtlinea3ptosofi.getText()
                        + ","
                        + txtlinea3comagen.getText()
                        + ","
                        + txtlinea3ptosagen.getText();
                if (txtlinea4comofi.getText().equals("")) {
                  txtlinea4comofi.setText("-");
                }
                if (txtlinea4ptosofi.getText().equals("")) {
                  txtlinea4ptosofi.setText("-");
                }
                if (txtlinea4comagen.getText().equals("")) {
                  txtlinea4comagen.setText("-");
                }
                if (txtlinea4ptosagen.getText().equals("")) {
                  txtlinea4ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea4comofi.getText()
                        + ","
                        + txtlinea4ptosofi.getText()
                        + ","
                        + txtlinea4comagen.getText()
                        + ","
                        + txtlinea4ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2
                        + ","
                        + txtlinea3.getText()
                        + ","
                        + txtfechalinea3.getText()
                        + ","
                        + estado3
                        + ","
                        + txtlinea4.getText()
                        + ","
                        + txtfechalinea4.getText()
                        + ","
                        + estado4;
                break;
              case 5:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (Rdbtnlinea3ac.isSelected()) {
                  estado3 = "AC";

                } else {
                  if (Rdbtnlinea3pt.isSelected()) {
                    estado3 = "PT";
                  } else {
                    estado3 = "KO";
                  }
                }
                if (Rdbtnlinea4ac.isSelected()) {
                  estado4 = "AC";

                } else {
                  if (Rdbtnlinea4pt.isSelected()) {
                    estado4 = "PT";
                  } else {
                    estado4 = "KO";
                  }
                }
                if (Rdbtnlinea5ac.isSelected()) {
                  estado5 = "AC";

                } else {
                  if (Rdbtnlinea5pt.isSelected()) {
                    estado5 = "PT";
                  } else {
                    estado5 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();
                if (txtlinea3comofi.getText().equals("")) {
                  txtlinea3comofi.setText("-");
                }
                if (txtlinea3ptosofi.getText().equals("")) {
                  txtlinea3ptosofi.setText("-");
                }
                if (txtlinea3comagen.getText().equals("")) {
                  txtlinea3comagen.setText("-");
                }
                if (txtlinea3ptosagen.getText().equals("")) {
                  txtlinea3ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea3comofi.getText()
                        + ","
                        + txtlinea3ptosofi.getText()
                        + ","
                        + txtlinea3comagen.getText()
                        + ","
                        + txtlinea3ptosagen.getText();
                if (txtlinea4comofi.getText().equals("")) {
                  txtlinea4comofi.setText("-");
                }
                if (txtlinea4ptosofi.getText().equals("")) {
                  txtlinea4ptosofi.setText("-");
                }
                if (txtlinea4comagen.getText().equals("")) {
                  txtlinea4comagen.setText("-");
                }
                if (txtlinea4ptosagen.getText().equals("")) {
                  txtlinea4ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea4comofi.getText()
                        + ","
                        + txtlinea4ptosofi.getText()
                        + ","
                        + txtlinea4comagen.getText()
                        + ","
                        + txtlinea4ptosagen.getText();
                if (txtlinea5comofi.getText().equals("")) {
                  txtlinea5comofi.setText("-");
                }
                if (txtlinea5ptosofi.getText().equals("")) {
                  txtlinea5ptosofi.setText("-");
                }
                if (txtlinea5comagen.getText().equals("")) {
                  txtlinea5comagen.setText("-");
                }
                if (txtlinea5ptosagen.getText().equals("")) {
                  txtlinea5ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea5comofi.getText()
                        + ","
                        + txtlinea5ptosofi.getText()
                        + ","
                        + txtlinea5comagen.getText()
                        + ","
                        + txtlinea5ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2
                        + ","
                        + txtlinea3.getText()
                        + ","
                        + txtfechalinea3.getText()
                        + ","
                        + estado3
                        + ","
                        + txtlinea4.getText()
                        + ","
                        + txtfechalinea4.getText()
                        + ","
                        + estado4
                        + ","
                        + txtlinea5.getText()
                        + ","
                        + txtfechalinea5.getText()
                        + ","
                        + estado5;
                break;
            }

          } else {
            lineas = "";
          }
          if (!txtnumfijo.getText().equals("")) {
            fijo = txtnumfijo.getText();
          }
          String distri;
          if (combooperador.getSelectedItem().toString().equalsIgnoreCase("Orange")) {
            if (combodsitrOran.getSelectedIndex() == 0) {
              distri = " ";
            } else {
              distri = combodsitrOran.getSelectedItem().toString();
            }
          } else {
            distri = " ";
          }
          ok =
              st.execute(
                  "INSERT INTO `ventas` (`fechacreacion`, `delegacion`, `comercial`, `codcomercial`, `documento`, `nombrecliente`, `operador`, `distribuidor`, `segmento`, `idoferta`"
                      + ", `iua`, `numaltasmovi`, `numportasmovil`, `lineasmoviles`, `numfijo`, `tv`, `oferta`"
                      + ", `vap`, `activadomovil`, `activadofijo`, `comisiones`, `contrato`, `documentos`, `observaciones`, `estado`) "
                      + "VALUES ('"
                      + fechafin
                      + "', '"
                      + combodelegaciones.getSelectedItem().toString()
                      + "', '"
                      + combocomerciales.getSelectedItem().toString()
                      + "', "
                      + "'"
                      + txtcodcomercial.getText()
                      + "', '"
                      + txtdocumento.getText()
                      + "', '"
                      + txtnombre.getText()
                      + "', '"
                      + combooperador.getSelectedItem().toString()
                      + "','"
                      + distri
                      + "', "
                      + "'"
                      + combosegmento.getSelectedItem().toString()
                      + "', '"
                      + idoferta
                      + "', '"
                      + iua
                      + "', '"
                      + altas
                      + "'"
                      + ", '"
                      + portas
                      + "', '"
                      + lineas
                      + "', '"
                      + fijo
                      + "', '"
                      + tv
                      + "', '"
                      + oferta
                      + "', '"
                      + vaps
                      + "'"
                      + ", '"
                      + vcmovil
                      + "', '"
                      + vcfijo
                      + "', '"
                      + comis
                      + "', '"
                      + contrato
                      + "', '"
                      + docu
                      + "', '"
                      + obser
                      + "', '"
                      + comboestados.getSelectedItem().toString()
                      + "');");
          JOptionPane.showMessageDialog(
              null, "Alta realizada correctamente", "Alta", JOptionPane.YES_NO_CANCEL_OPTION);
        }
        if (ok) {
          limpiar();
          deshabilitar();
        } else {
          if (ok1) {
            limpiar();
            deshabilitar();
          }
        }
        // a partir de aquí si ya es cliente se busca por cod cliente y se hace un update

      } else {

        if (txtdocumento.getText().equalsIgnoreCase("")
            || txtnombre.getText().equalsIgnoreCase("")
            || txtoferta.getText().equalsIgnoreCase("")
            || combooperador.getSelectedItem().toString().equalsIgnoreCase("-")
            || combosegmento.getSelectedItem().toString().equalsIgnoreCase("-")
            || comboestados.getSelectedItem().toString().equalsIgnoreCase("-")) {
          ok1 = false;
          JOptionPane.showMessageDialog(
              null, "Faltan Campos Obligatorios por cubrir", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
          if (!txtaltasmoviles.getText().equals("")) {
            altas = txtaltasmoviles.getText();
          }
          if (!txtportasmoviles.getText().equals("")) {
            portas = txtportasmoviles.getText();
          }
          if (chekcontrato.isSelected()) {
            contrato = "SI";
          } else {
            contrato = "NO";
          }
          if (chekdocu.isSelected()) {
            docu = "SI";
          } else {
            docu = "NO";
          }
          if (checktv.isSelected()) {
            tv = "SI";
          } else {
            tv = "NO";
          }
          if (combotecno.getSelectedItem().toString().equalsIgnoreCase("-")) {
            oferta = "-,-," + txtoferta.getText();
          } else {
            if (combotipo.getSelectedItem().toString().equalsIgnoreCase("-")) {
              JOptionPane.showMessageDialog(
                  null, "PROPIA O NEBA??", "Error", JOptionPane.WARNING_MESSAGE);

            } else {
              oferta =
                  combotecno.getSelectedItem().toString()
                      + ","
                      + combotipo.getSelectedItem().toString()
                      + ","
                      + txtoferta.getText();
            }
          }
          if (!txtidoferta.getText().equals("")) {
            idoferta = txtidoferta.getText();
          }
          if (!txtiua.getText().equals("")) {
            iua = txtiua.getText();
          }
          if (!txtvcmovil.getText().equals("")) {
            parts = txtvcmovil.getText().split("-");
            part1 = parts[0];
            part2 = parts[1];
            parte3 = parts[2];
            vcmovil = parte3 + "-" + part2 + "-" + part1;
          }
          if (!txtvcfijo.getText().equals("")) {
            parts = txtvcmovil.getText().split("-");
            part1 = parts[0];
            part2 = parts[1];
            parte3 = parts[2];
            vcfijo = parte3 + "-" + part2 + "-" + part1;
          }
          if (!txtvaps.getText().equals("")) {
            vaps = txtvaps.getText();
          }
          if (!txtobservaciones.getText().equals("")) {
            obser = txtobservaciones.getText();
          }
          if (n > 0) {
            switch (n) {
              case 1:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";
                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equalsIgnoreCase("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equalsIgnoreCase("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equalsIgnoreCase("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equalsIgnoreCase("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText()
                        + ",";

                lineas = txtlinea1.getText() + "," + txtfechalinea1.getText() + "," + estado;
                break;
              case 2:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2;
                break;
              case 3:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (Rdbtnlinea3ac.isSelected()) {
                  estado3 = "AC";

                } else {
                  if (Rdbtnlinea3pt.isSelected()) {
                    estado3 = "PT";
                  } else {
                    estado3 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();
                if (txtlinea3comofi.getText().equals("")) {
                  txtlinea3comofi.setText("-");
                }
                if (txtlinea3ptosofi.getText().equals("")) {
                  txtlinea3ptosofi.setText("-");
                }
                if (txtlinea3comagen.getText().equals("")) {
                  txtlinea3comagen.setText("-");
                }
                if (txtlinea3ptosagen.getText().equals("")) {
                  txtlinea3ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea3comofi.getText()
                        + ","
                        + txtlinea3ptosofi.getText()
                        + ","
                        + txtlinea3comagen.getText()
                        + ","
                        + txtlinea3ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2
                        + ","
                        + txtlinea3.getText()
                        + ","
                        + txtfechalinea3.getText()
                        + ","
                        + estado3;
                break;

              case 4:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (Rdbtnlinea3ac.isSelected()) {
                  estado3 = "AC";

                } else {
                  if (Rdbtnlinea3pt.isSelected()) {
                    estado3 = "PT";
                  } else {
                    estado3 = "KO";
                  }
                }
                if (Rdbtnlinea4ac.isSelected()) {
                  estado4 = "AC";

                } else {
                  if (Rdbtnlinea4pt.isSelected()) {
                    estado4 = "PT";
                  } else {
                    estado4 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtobservaciones.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();
                if (txtlinea3comofi.getText().equals("")) {
                  txtlinea3comofi.setText("-");
                }
                if (txtlinea3ptosofi.getText().equals("")) {
                  txtlinea3ptosofi.setText("-");
                }
                if (txtlinea3comagen.getText().equals("")) {
                  txtlinea3comagen.setText("-");
                }
                if (txtlinea3ptosagen.getText().equals("")) {
                  txtlinea3ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea3comofi.getText()
                        + ","
                        + txtlinea3ptosofi.getText()
                        + ","
                        + txtlinea3comagen.getText()
                        + ","
                        + txtlinea3ptosagen.getText();
                if (txtlinea4comofi.getText().equals("")) {
                  txtlinea4comofi.setText("-");
                }
                if (txtlinea4ptosofi.getText().equals("")) {
                  txtlinea4ptosofi.setText("-");
                }
                if (txtlinea4comagen.getText().equals("")) {
                  txtlinea4comagen.setText("-");
                }
                if (txtlinea4ptosagen.getText().equals("")) {
                  txtlinea4ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea4comofi.getText()
                        + ","
                        + txtlinea4ptosofi.getText()
                        + ","
                        + txtlinea4comagen.getText()
                        + ","
                        + txtlinea4ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2
                        + ","
                        + txtlinea3.getText()
                        + ","
                        + txtfechalinea3.getText()
                        + ","
                        + estado3
                        + ","
                        + txtlinea4.getText()
                        + ","
                        + txtfechalinea4.getText()
                        + ","
                        + estado4;
                break;
              case 5:
                if (Rdbtnlinea1ac.isSelected()) {
                  estado = "AC";

                } else {
                  if (Rdbtnlinea1pt.isSelected()) {
                    estado = "PT";
                  } else {
                    estado = "KO";
                  }
                }
                if (Rdbtnlinea2ac.isSelected()) {
                  estado2 = "AC";

                } else {
                  if (Rdbtnlinea2pt.isSelected()) {
                    estado2 = "PT";
                  } else {
                    estado2 = "KO";
                  }
                }
                if (Rdbtnlinea3ac.isSelected()) {
                  estado3 = "AC";

                } else {
                  if (Rdbtnlinea3pt.isSelected()) {
                    estado3 = "PT";
                  } else {
                    estado3 = "KO";
                  }
                }
                if (Rdbtnlinea4ac.isSelected()) {
                  estado4 = "AC";

                } else {
                  if (Rdbtnlinea4pt.isSelected()) {
                    estado4 = "PT";
                  } else {
                    estado4 = "KO";
                  }
                }
                if (Rdbtnlinea5ac.isSelected()) {
                  estado5 = "AC";

                } else {
                  if (Rdbtnlinea5pt.isSelected()) {
                    estado5 = "PT";
                  } else {
                    estado5 = "KO";
                  }
                }
                if (txtlinea1comofi.getText().equals("")) {
                  txtlinea1comofi.setText("-");
                }
                if (txtlinea1ptosofi.getText().equals("")) {
                  txtlinea1ptosofi.setText("-");
                }
                if (txtlinea1comagen.getText().equals("")) {
                  txtlinea1comagen.setText("-");
                }
                if (txtlinea1ptosagen.getText().equals("")) {
                  txtlinea1ptosagen.setText("-");
                }
                comis =
                    txtlinea1comofi.getText()
                        + ","
                        + txtlinea1ptosofi.getText()
                        + ","
                        + txtlinea1comagen.getText()
                        + ","
                        + txtlinea1ptosagen.getText();
                if (txtlinea2comofi.getText().equals("")) {
                  txtlinea2comofi.setText("-");
                }
                if (txtlinea2ptosofi.getText().equals("")) {
                  txtlinea2ptosofi.setText("-");
                }
                if (txtlinea2comagen.getText().equals("")) {
                  txtlinea2comagen.setText("-");
                }
                if (txtlinea2ptosagen.getText().equals("")) {
                  txtlinea2ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea2comofi.getText()
                        + ","
                        + txtlinea2ptosofi.getText()
                        + ","
                        + txtlinea2comagen.getText()
                        + ","
                        + txtlinea2ptosagen.getText();
                if (txtlinea3comofi.getText().equals("")) {
                  txtlinea3comofi.setText("-");
                }
                if (txtlinea3ptosofi.getText().equals("")) {
                  txtlinea3ptosofi.setText("-");
                }
                if (txtlinea3comagen.getText().equals("")) {
                  txtlinea3comagen.setText("-");
                }
                if (txtlinea3ptosagen.getText().equals("")) {
                  txtlinea3ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea3comofi.getText()
                        + ","
                        + txtlinea3ptosofi.getText()
                        + ","
                        + txtlinea3comagen.getText()
                        + ","
                        + txtlinea3ptosagen.getText();
                if (txtlinea4comofi.getText().equals("")) {
                  txtlinea4comofi.setText("-");
                }
                if (txtlinea4ptosofi.getText().equals("")) {
                  txtlinea4ptosofi.setText("-");
                }
                if (txtlinea4comagen.getText().equals("")) {
                  txtlinea4comagen.setText("-");
                }
                if (txtlinea4ptosagen.getText().equals("")) {
                  txtlinea4ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea4comofi.getText()
                        + ","
                        + txtlinea4ptosofi.getText()
                        + ","
                        + txtlinea4comagen.getText()
                        + ","
                        + txtlinea4ptosagen.getText();
                if (txtlinea5comofi.getText().equals("")) {
                  txtlinea5comofi.setText("-");
                }
                if (txtlinea5ptosofi.getText().equals("")) {
                  txtlinea5ptosofi.setText("-");
                }
                if (txtlinea5comagen.getText().equals("")) {
                  txtlinea5comagen.setText("-");
                }
                if (txtlinea5ptosagen.getText().equals("")) {
                  txtlinea5ptosagen.setText("-");
                }
                comis +=
                    ","
                        + txtlinea5comofi.getText()
                        + ","
                        + txtlinea5ptosofi.getText()
                        + ","
                        + txtlinea5comagen.getText()
                        + ","
                        + txtlinea5ptosagen.getText();

                lineas =
                    txtlinea1.getText()
                        + ","
                        + txtfechalinea1.getText()
                        + ","
                        + estado
                        + ","
                        + txtlinea2.getText()
                        + ","
                        + txtfechalinea2.getText()
                        + ","
                        + estado2
                        + ","
                        + txtlinea3.getText()
                        + ","
                        + txtfechalinea3.getText()
                        + ","
                        + estado3
                        + ","
                        + txtlinea4.getText()
                        + ","
                        + txtfechalinea4.getText()
                        + ","
                        + estado4
                        + ","
                        + txtlinea5.getText()
                        + ","
                        + txtfechalinea5.getText()
                        + ","
                        + estado5;
                break;
            }

          } else {
            lineas = "";
          }
          if (!txtnumfijo.getText().equals("")) {
            fijo = txtnumfijo.getText();
          }
          String distri;
          if (combooperador.getSelectedItem().toString().equalsIgnoreCase("Orange")) {
            if (combodsitrOran.getSelectedIndex() == 0) {
              distri = " ";
            } else {
              distri = combodsitrOran.getSelectedItem().toString();
            }
          } else {
            distri = " ";
          }

          ac =
              st.executeUpdate(
                  "UPDATE ventas set nombrecliente='"
                      + txtnombre.getText()
                      + "', idoferta='"
                      + idoferta
                      + "' , iua='"
                      + iua
                      + "', "
                      + "numaltasmovi='"
                      + altas
                      + "',numportasmovil='"
                      + portas
                      + "',lineasmoviles='"
                      + lineas
                      + "',numfijo='"
                      + fijo
                      + "',"
                      + "oferta='"
                      + oferta
                      + "',vap='"
                      + vaps
                      + "',activadomovil='"
                      + vcmovil
                      + "',activadofijo='"
                      + vcfijo
                      + "',"
                      + "contrato='"
                      + contrato
                      + "',documentos='"
                      + docu
                      + "',distribuidor='"
                      + distri
                      + "',tv='"
                      + tv
                      + "',comisiones='"
                      + comis
                      + "',observaciones='"
                      + obser
                      + "',estado='"
                      + comboestados.getSelectedItem().toString()
                      + "' "
                      + "where numcliente='"
                      + codi
                      + "'");
        }
        if (ac == 1) {
          JOptionPane.showMessageDialog(
              null,
              "Modificación realizada correctamente",
              "Alta",
              JOptionPane.YES_NO_CANCEL_OPTION);
          limpiar();
          deshabilitar();
        } else {
          if (ac == 0) {
            JOptionPane.showMessageDialog(
                null, "Hay algo mal, preguntar a David", "Alta", JOptionPane.YES_NO_CANCEL_OPTION);
          }
        }
      }

    } catch (SQLException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_btnguardarActionPerformed

  private void combooperadorActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_combooperadorActionPerformed
    comboestados.setEnabled(true);
    comboestados.removeAllItems();
    comboestados.addItem("-");
    if (combooperador.getSelectedItem().toString().equalsIgnoreCase("Orange")) {
      combodsitrOran.setEnabled(true);
    }
    try {
      if (combooperador.getSelectedIndex() != -1) {
        String delegacion = combooperador.getSelectedItem().toString();
        rs = st.executeQuery("select estado from estados where operador='" + delegacion + "'");
        if (rs.next()) {
          do {
            comboestados.addItem(rs.getString("estado"));
          } while (rs.next());
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_combooperadorActionPerformed

  private void combotecnoActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_combotecnoActionPerformed
    combotipo.setEnabled(true);
  } // GEN-LAST:event_combotecnoActionPerformed

  private void btncargarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btncargarActionPerformed
    deshabilitar();
    txtcargacliente.setEnabled(true);
  } // GEN-LAST:event_btncargarActionPerformed

  private void txtcargaclienteFocusLost(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_txtcargaclienteFocusLost
    String estado,
        p1,
        p2,
        p3,
        fijo,
        movil,
        c1 = null,
        c2 = null,
        c3 = null,
        c4 = null,
        c5 = null,
        c6 = null,
        c7 = null,
        c8 = null,
        c9 = null,
        c10 = null,
        c11 = null,
        c12 = null,
        c13 = null,
        c14 = null,
        c15 = null,
        c16 = null,
        c17 = null,
        c18 = null,
        c19 = null,
        c20 = null;
    String par[], c[];
    if (!txtcargacliente.getText().equalsIgnoreCase("")) {
      codi = Integer.parseInt(txtcargacliente.getText());
      try {
        st = con.createStatement();
        rs =
            st.executeQuery(
                "Select * from ventas where numcliente='" + txtcargacliente.getText() + "'");
        if (rs.next()) {
          txtcodcomercial.setText(rs.getString("codcomercial"));
          txtdocumento.setText(rs.getString("documento"));
          txtnombre.setText(rs.getString("nombrecliente"));
          txtiua.setText(rs.getString("iua"));
          txtidoferta.setText(rs.getString("idoferta"));
          txtaltasmoviles.setText(rs.getString("numaltasmovi"));
          txtportasmoviles.setText(rs.getString("numportasmovil"));
          txtvaps.setText(rs.getString("vap"));
          par = rs.getString("activadofijo").split("-");
          p1 = par[0];
          p2 = par[1];
          p3 = par[2];
          fijo = p3 + "-" + p2 + "-" + p1;
          txtvcfijo.setText(fijo);
          par = rs.getString("activadomovil").split("-");
          p1 = par[0];
          p2 = par[1];
          p3 = par[2];
          movil = p3 + "-" + p2 + "-" + p1;
          txtvcmovil.setText(movil);
          txtobservaciones.setText(rs.getString("observaciones"));
          txtnumfijo.setText(rs.getString("numfijo"));
          int n = Integer.parseInt(txtportasmoviles.getText());
          int n1 = Integer.parseInt(txtaltasmoviles.getText());
          n += n1;
          if (rs.getString("operador").equalsIgnoreCase("Orange")) {
            if (rs.getString("distribuidor").equalsIgnoreCase("LUSANET")) {
              combodsitrOran.setSelectedIndex(1);
              combodsitrOran.setEnabled(true);
            } else {
              if (rs.getString("distribuidor").equalsIgnoreCase("WETHINK")) {
                combodsitrOran.setSelectedIndex(2);
                combodsitrOran.setEnabled(true);
              } else {
                combodsitrOran.setSelectedIndex(0);
                combodsitrOran.setEnabled(true);
              }
            }
          } else {
            combodsitrOran.setEnabled(false);
            combodsitrOran.setSelectedIndex(0);
          }
          if (n > 0) {
            switch (n) {
              case 1:
                String part[] = rs.getString("lineasmoviles").split(",");
                String parte1 = part[0];
                String parte2 = part[1];
                String parte3 = part[2];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);

                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);

                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                  }
                }
                txtlinea2.setText("");
                txtlinea3.setText("");
                txtlinea4.setText("");
                txtlinea5.setText("");
                Rdbtnlinea2ac.setSelected(false);
                Rdbtnlinea3ac.setSelected(false);
                Rdbtnlinea4ac.setSelected(false);
                Rdbtnlinea5ac.setSelected(false);
                Rdbtnlinea2pt.setSelected(false);
                Rdbtnlinea3pt.setSelected(false);
                Rdbtnlinea4pt.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);
                Rdbtnlinea2ko.setSelected(false);
                Rdbtnlinea3ko.setSelected(false);
                Rdbtnlinea4ko.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);
                txtlinea2comofi.setEnabled(false);
                txtlinea2comagen.setEnabled(false);
                txtlinea2ptosagen.setEnabled(false);
                txtlinea2ptosofi.setEnabled(false);
                txtlinea3comofi.setEnabled(false);
                txtlinea3comagen.setEnabled(false);
                txtlinea3ptosagen.setEnabled(false);
                txtlinea3ptosofi.setEnabled(false);
                txtlinea4comofi.setEnabled(false);
                txtlinea4comagen.setEnabled(false);
                txtlinea4ptosagen.setEnabled(false);
                txtlinea4ptosofi.setEnabled(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);
                buttonGroup2.clearSelection();
                buttonGroup3.clearSelection();
                buttonGroup4.clearSelection();
                buttonGroup5.clearSelection();
                txtfechalinea1.setText(parte2);
                txtlinea1.setText(parte1);
                txtfechalinea2.setText("");
                txtfechalinea3.setText("");
                txtfechalinea4.setText("");
                txtfechalinea5.setText("");

                break;

              case 2:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                txtlinea1.setText(parte1);
                txtfechalinea1.setText(parte2);

                String parte4 = part[3];
                String parte5 = part[4];
                String parte6 = part[5];
                txtlinea2.setText(parte4);
                txtfechalinea2.setText(parte5);
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);

                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);
                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);

                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                  }
                }
                txtlinea3.setText("");
                txtlinea4.setText("");
                txtlinea5.setText("");

                Rdbtnlinea3ac.setSelected(false);
                Rdbtnlinea4ac.setSelected(false);
                Rdbtnlinea5ac.setSelected(false);

                Rdbtnlinea3pt.setSelected(false);
                Rdbtnlinea4pt.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);

                Rdbtnlinea3ko.setSelected(false);
                Rdbtnlinea4ko.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);

                txtlinea3comofi.setEnabled(false);
                txtlinea3comagen.setEnabled(false);
                txtlinea3ptosagen.setEnabled(false);
                txtlinea3ptosofi.setEnabled(false);
                txtlinea4comofi.setEnabled(false);
                txtlinea4comagen.setEnabled(false);
                txtlinea4ptosagen.setEnabled(false);
                txtlinea4ptosofi.setEnabled(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);

                buttonGroup3.clearSelection();
                buttonGroup4.clearSelection();
                buttonGroup5.clearSelection();
                txtfechalinea3.setText("");
                txtfechalinea4.setText("");
                txtfechalinea5.setText("");
                break;

              case 3:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                parte4 = part[3];
                parte5 = part[4];
                parte6 = part[5];
                String parte7 = part[6];
                String parte8 = part[7];
                String parte9 = part[8];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);
                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                    txtlinea1.setEnabled(true);
                    txtfechalinea1.setEnabled(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);
                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);
                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                  }
                }
                if (parte9.equalsIgnoreCase("AC")) {
                  Rdbtnlinea3ac.setSelected(true);
                  txtlinea3comofi.setEnabled(true);
                  txtlinea3comagen.setEnabled(true);
                  txtlinea3ptosagen.setEnabled(true);
                  txtlinea3ptosofi.setEnabled(true);
                  txtlinea3comofi.setText(c9);
                  txtlinea3comagen.setText(c10);
                  txtlinea3ptosagen.setText(c11);
                  txtlinea3ptosofi.setText(c12);
                } else {
                  if (parte9.equalsIgnoreCase("PT")) {
                    Rdbtnlinea3pt.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                    Rdbtnlinea3ac.setEnabled(true);
                    Rdbtnlinea3pt.setEnabled(true);
                    Rdbtnlinea3ko.setEnabled(true);
                  } else {
                    Rdbtnlinea3ko.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                  }
                }
                txtlinea1.setText(parte1);
                txtfechalinea1.setText(parte2);
                txtlinea2.setText(parte4);
                txtfechalinea2.setText(parte5);
                txtlinea3.setText(parte7);
                txtfechalinea3.setText(parte8);
                txtlinea4.setText("");
                txtlinea5.setText("");

                txtfechalinea4.setText("");
                txtfechalinea5.setText("");

                Rdbtnlinea4ac.setSelected(false);
                Rdbtnlinea5ac.setSelected(false);
                Rdbtnlinea4pt.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);
                Rdbtnlinea4ko.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);
                txtlinea4comofi.setEnabled(false);
                txtlinea4comagen.setEnabled(false);
                txtlinea4ptosagen.setEnabled(false);
                txtlinea4ptosofi.setEnabled(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);

                buttonGroup4.clearSelection();
                buttonGroup5.clearSelection();
                break;

              case 4:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                parte4 = part[3];
                parte5 = part[4];
                parte6 = part[5];
                parte7 = part[6];
                parte8 = part[7];
                parte9 = part[8];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                  c13 = c[12];
                  c14 = c[13];
                  c15 = c[14];
                  c16 = c[15];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);
                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                    txtlinea1.setEnabled(true);
                    txtfechalinea1.setEnabled(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);
                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);
                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                  }
                }
                if (parte9.equalsIgnoreCase("AC")) {
                  Rdbtnlinea3ac.setSelected(true);
                  txtlinea3comofi.setEnabled(true);
                  txtlinea3comagen.setEnabled(true);
                  txtlinea3ptosagen.setEnabled(true);
                  txtlinea3ptosofi.setEnabled(true);
                  txtlinea3comofi.setText(c9);
                  txtlinea3comagen.setText(c10);
                  txtlinea3ptosagen.setText(c11);
                  txtlinea3ptosofi.setText(c12);
                } else {
                  if (parte9.equalsIgnoreCase("PT")) {

                    Rdbtnlinea3pt.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                    Rdbtnlinea3ac.setEnabled(true);
                    Rdbtnlinea3pt.setEnabled(true);
                    Rdbtnlinea3ko.setEnabled(true);
                  } else {
                    Rdbtnlinea3ko.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                  }
                }
                if (part[11].equalsIgnoreCase("AC")) {
                  Rdbtnlinea4ac.setSelected(true);
                  txtlinea4comofi.setEnabled(true);
                  txtlinea4comagen.setEnabled(true);
                  txtlinea4ptosagen.setEnabled(true);
                  txtlinea4ptosofi.setEnabled(true);
                  txtlinea4comofi.setText(c13);
                  txtlinea4comagen.setText(c14);
                  txtlinea4ptosagen.setText(c15);
                  txtlinea4ptosofi.setText(c16);
                } else {
                  if (part[11].equalsIgnoreCase("PT")) {

                    Rdbtnlinea4pt.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                    Rdbtnlinea4ac.setEnabled(true);
                    Rdbtnlinea4pt.setEnabled(true);
                    Rdbtnlinea4ko.setEnabled(true);
                  } else {
                    Rdbtnlinea4ko.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                  }
                }
                txtlinea1.setText(parte1);
                txtfechalinea1.setText(parte2);
                txtlinea2.setText(parte4);
                txtfechalinea2.setText(parte5);
                txtlinea3.setText(parte7);
                txtfechalinea3.setText(parte8);
                txtlinea4.setText(part[9]);
                txtfechalinea4.setText(part[10]);
                txtlinea5.setText("");

                txtfechalinea5.setText("");
                Rdbtnlinea5ac.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);

                buttonGroup5.clearSelection();
                break;

              case 5:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                parte4 = part[3];
                parte5 = part[4];
                parte6 = part[5];
                parte7 = part[6];
                parte8 = part[7];
                parte9 = part[8];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                  c13 = c[12];
                  c14 = c[13];
                  c15 = c[14];
                  c16 = c[15];
                  c17 = c[16];
                  c18 = c[17];
                  c19 = c[18];
                  c20 = c[19];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);

                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                    txtlinea1.setEnabled(true);
                    txtfechalinea1.setEnabled(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);

                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);
                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                  }
                }
                if (parte9.equalsIgnoreCase("AC")) {
                  Rdbtnlinea3ac.setSelected(true);
                  txtlinea3comofi.setEnabled(true);
                  txtlinea3comagen.setEnabled(true);
                  txtlinea3ptosagen.setEnabled(true);
                  txtlinea3ptosofi.setEnabled(true);
                  txtlinea3comofi.setText(c9);
                  txtlinea3comagen.setText(c10);
                  txtlinea3ptosagen.setText(c11);
                  txtlinea3ptosofi.setText(c12);

                } else {
                  if (parte9.equalsIgnoreCase("PT")) {
                    Rdbtnlinea3pt.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                    Rdbtnlinea3ac.setEnabled(true);
                    Rdbtnlinea3pt.setEnabled(true);
                    Rdbtnlinea3ko.setEnabled(true);
                  } else {
                    Rdbtnlinea3ko.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                  }
                }
                if (part[11].equalsIgnoreCase("AC")) {
                  Rdbtnlinea4ac.setSelected(true);
                  txtlinea4comofi.setEnabled(true);
                  txtlinea4comagen.setEnabled(true);
                  txtlinea4ptosagen.setEnabled(true);
                  txtlinea4ptosofi.setEnabled(true);
                  txtlinea4comofi.setText(c13);
                  txtlinea4comagen.setText(c14);
                  txtlinea4ptosagen.setText(c15);
                  txtlinea4ptosofi.setText(c16);

                } else {
                  if (part[11].equalsIgnoreCase("PT")) {
                    Rdbtnlinea4pt.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                    Rdbtnlinea4ac.setEnabled(true);
                    Rdbtnlinea4pt.setEnabled(true);
                    Rdbtnlinea4ko.setEnabled(true);
                  } else {
                    Rdbtnlinea4ko.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                  }
                }
                if (part[14].equalsIgnoreCase("AC")) {
                  Rdbtnlinea5ac.setSelected(true);
                  txtlinea5comofi.setEnabled(true);
                  txtlinea5comagen.setEnabled(true);
                  txtlinea5ptosagen.setEnabled(true);
                  txtlinea5ptosofi.setEnabled(true);
                  txtlinea5comofi.setText(c17);
                  txtlinea5comagen.setText(c18);
                  txtlinea5ptosagen.setText(c19);
                  txtlinea5ptosofi.setText(c20);
                } else {
                  if (part[14].equalsIgnoreCase("PT")) {
                    Rdbtnlinea5pt.setSelected(true);
                    txtlinea5.setEnabled(true);
                    txtfechalinea5.setEnabled(true);
                    Rdbtnlinea5ac.setEnabled(true);
                    Rdbtnlinea5pt.setEnabled(true);
                    Rdbtnlinea5ko.setEnabled(true);
                  } else {
                    Rdbtnlinea5ko.setSelected(true);
                    txtlinea5.setEnabled(true);
                    txtfechalinea5.setEnabled(true);
                  }

                  txtlinea1.setText(parte1);
                  txtfechalinea1.setText(parte2);
                  txtlinea2.setText(parte4);
                  txtfechalinea2.setText(parte5);
                  txtlinea3.setText(parte7);
                  txtfechalinea3.setText(parte8);
                  txtlinea4.setText(part[9]);
                  txtfechalinea4.setText(part[10]);
                  txtlinea5.setText(part[12]);
                  txtfechalinea5.setText(part[13]);
                  break;
                }
            }
          } else {
            txtlinea1.setText("");
            txtlinea2.setText("");
            txtlinea3.setText("");
            txtlinea4.setText("");
            txtlinea5.setText("");
            txtfechalinea1.setText("");
            txtfechalinea2.setText("");
            txtfechalinea3.setText("");
            txtfechalinea4.setText("");
            txtfechalinea5.setText("");
            Rdbtnlinea1ac.setSelected(false);
            Rdbtnlinea2ac.setSelected(false);
            Rdbtnlinea3ac.setSelected(false);
            Rdbtnlinea4ac.setSelected(false);
            Rdbtnlinea5ac.setSelected(false);
            Rdbtnlinea1pt.setSelected(false);
            Rdbtnlinea2pt.setSelected(false);
            Rdbtnlinea3pt.setSelected(false);
            Rdbtnlinea4pt.setSelected(false);
            Rdbtnlinea5pt.setSelected(false);
            Rdbtnlinea5ko.setSelected(false);
            Rdbtnlinea2ko.setSelected(false);
            Rdbtnlinea1ko.setSelected(false);
            Rdbtnlinea3ko.setSelected(false);
            Rdbtnlinea4ko.setSelected(false);
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
            buttonGroup3.clearSelection();
            buttonGroup4.clearSelection();
            buttonGroup5.clearSelection();
            txtlinea1comofi.setEnabled(false);
            txtlinea1comagen.setEnabled(false);
            txtlinea1ptosagen.setEnabled(false);
            txtlinea1ptosofi.setEnabled(false);
            txtlinea2comofi.setEnabled(false);
            txtlinea2comagen.setEnabled(false);
            txtlinea2ptosagen.setEnabled(false);
            txtlinea2ptosofi.setEnabled(false);
            txtlinea3comofi.setEnabled(false);
            txtlinea3comagen.setEnabled(false);
            txtlinea3ptosagen.setEnabled(false);
            txtlinea3ptosofi.setEnabled(false);
            txtlinea4comofi.setEnabled(false);
            txtlinea4comagen.setEnabled(false);
            txtlinea4ptosagen.setEnabled(false);
            txtlinea4ptosofi.setEnabled(false);
            txtlinea5comofi.setEnabled(false);
            txtlinea5comagen.setEnabled(false);
            txtlinea5ptosagen.setEnabled(false);
            txtlinea5ptosofi.setEnabled(false);
          }
          estado = rs.getString("estado");
          if (rs.getString("contrato").equalsIgnoreCase("SI")) {
            chekcontrato.setSelected(true);
          } else {
            chekcontrato.setSelected(false);
          }
          if (rs.getString("documentos").equalsIgnoreCase("SI")) {
            chekdocu.setSelected(true);
          } else {
            chekdocu.setSelected(false);
          }
          if (rs.getString("tv").equalsIgnoreCase("SI")) {
            checktv.setSelected(true);
          } else {
            checktv.setSelected(false);
          }

          if (!rs.getString("oferta").equalsIgnoreCase("")) {
            String[] parts = rs.getString("oferta").split(",");
            String part1 = parts[0];
            String part2 = parts[1];
            String parte3 = parts[2];
            switch (part1) {
              case "FIBRA":
                combotecno.setSelectedIndex(2);
                break;
              case "ADSL":
                combotecno.setSelectedIndex(1);
                break;
              default:
                combotecno.setSelectedIndex(0);
            }
            switch (part2) {
              case "NEBA":
                combotipo.setSelectedIndex(2);
                break;
              case "PROPIA":
                combotipo.setSelectedIndex(1);
                break;
              default:
                combotipo.setSelectedIndex(0);
            }
            txtoferta.setText(parte3);
          }
          if (rs.getString("segmento").equalsIgnoreCase("Residencial")) {
            combosegmento.setSelectedIndex(1);
          } else {
            combosegmento.setSelectedIndex(2);
          }
          switch (rs.getString("operador")) {
            case "Vodafone":
              combooperador.setSelectedIndex(2);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO KO-PARCIAL":
                  comboestados.setSelectedIndex(2);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(3);
                  break;
                case "ACTIVO OK-PARCIAL":
                  comboestados.setSelectedIndex(4);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(5);
                  break;
                case "CANCELADO":
                  comboestados.setSelectedIndex(6);
                  break;
                case "EN LOCALIZACION":
                  comboestados.setSelectedIndex(7);
                  break;
                case "FIRMADA-PROVISION":
                  comboestados.setSelectedIndex(8);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(9);
                  break;
                case "NO APTO":
                  comboestados.setSelectedIndex(10);
                  break;
                case "NO REDCHANNEL":
                  comboestados.setSelectedIndex(11);
                  break;
                case "PDTE VALIDAR":
                  comboestados.setSelectedIndex(12);
                  break;
                case "PLANTILLA":
                  comboestados.setSelectedIndex(13);
                  break;
                case "RELANZADA":
                  comboestados.setSelectedIndex(14);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(15);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(16);
                  break;
                case "VODAGEST MANUAL":
                  comboestados.setSelectedIndex(17);
                  break;
              }
              break;
            case "Orange":
              combooperador.setSelectedIndex(1);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "PLANTILLA":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(7);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(8);
                  break;
              }
              break;
            case "Yoigo":
              combooperador.setSelectedIndex(3);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "PEND. DOCU":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(7);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(8);
                  break;
                case "TRAMITADO":
                  comboestados.setSelectedIndex(9);
                  break;
              }
              break;
            case "MasMovil":
              combooperador.setSelectedIndex(4);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(7);
                  break;
              }
              break;
            default:
              combooperador.setSelectedIndex(5);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(7);
                  break;
              }
              break;
          }

          if (estado.equalsIgnoreCase("ACTIVO OK")) {
            deshabilitar();

          } else {
            habilitarmod();
          }

        } else {
          JOptionPane.showMessageDialog(
              null, "No existe cliente con ese Código", "Alta", JOptionPane.WARNING_MESSAGE);
        }
      } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else {
      JOptionPane.showMessageDialog(
          null, "Porfavor codigo para la busqueda", "Error", JOptionPane.YES_NO_CANCEL_OPTION);
    }
  } // GEN-LAST:event_txtcargaclienteFocusLost

  public void cargarcliente(String cod) {
    String codigo = cod;
    txtcargacliente.setEnabled(true);
    txtcargacliente.setText(codigo);
    String estado,
        p1,
        p2,
        p3,
        fijo,
        movil,
        c1 = null,
        c2 = null,
        c3 = null,
        c4 = null,
        c5 = null,
        c6 = null,
        c7 = null,
        c8 = null,
        c9 = null,
        c10 = null,
        c11 = null,
        c12 = null,
        c13 = null,
        c14 = null,
        c15 = null,
        c16 = null,
        c17 = null,
        c18 = null,
        c19 = null,
        c20 = null;
    String par[], c[];
    if (!txtcargacliente.getText().equalsIgnoreCase("")) {
      codi = Integer.parseInt(txtcargacliente.getText());
      try {
        st = con.createStatement();
        rs =
            st.executeQuery(
                "Select * from ventas where numcliente='" + txtcargacliente.getText() + "'");
        if (rs.next()) {
          txtcodcomercial.setText(rs.getString("codcomercial"));
          txtdocumento.setText(rs.getString("documento"));
          txtnombre.setText(rs.getString("nombrecliente"));
          txtiua.setText(rs.getString("iua"));
          txtidoferta.setText(rs.getString("idoferta"));
          txtaltasmoviles.setText(rs.getString("numaltasmovi"));
          txtportasmoviles.setText(rs.getString("numportasmovil"));
          txtvaps.setText(rs.getString("vap"));
          par = rs.getString("activadofijo").split("-");
          p1 = par[0];
          p2 = par[1];
          p3 = par[2];
          fijo = p3 + "-" + p2 + "-" + p1;
          txtvcfijo.setText(fijo);
          par = rs.getString("activadomovil").split("-");
          p1 = par[0];
          p2 = par[1];
          p3 = par[2];
          movil = p3 + "-" + p2 + "-" + p1;
          txtvcmovil.setText(movil);
          txtobservaciones.setText(rs.getString("observaciones"));
          txtnumfijo.setText(rs.getString("numfijo"));
          int n = Integer.parseInt(txtportasmoviles.getText());
          int n1 = Integer.parseInt(txtaltasmoviles.getText());
          n += n1;
          if (rs.getString("operador").equalsIgnoreCase("Orange")) {
            if (rs.getString("distribuidor").equalsIgnoreCase("LUSANET")) {
              combodsitrOran.setSelectedIndex(1);
              combodsitrOran.setEnabled(true);
            } else {
              if (rs.getString("distribuidor").equalsIgnoreCase("WETHINK")) {
                combodsitrOran.setSelectedIndex(2);
                combodsitrOran.setEnabled(true);
              } else {
                combodsitrOran.setSelectedIndex(0);
                combodsitrOran.setEnabled(true);
              }
            }
          } else {
            combodsitrOran.setEnabled(false);
            combodsitrOran.setSelectedIndex(0);
          }
          if (n > 0) {
            switch (n) {
              case 1:
                String part[] = rs.getString("lineasmoviles").split(",");
                String parte1 = part[0];
                String parte2 = part[1];
                String parte3 = part[2];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);

                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);

                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                  }
                }
                txtlinea2.setText("");
                txtlinea3.setText("");
                txtlinea4.setText("");
                txtlinea5.setText("");
                Rdbtnlinea2ac.setSelected(false);
                Rdbtnlinea3ac.setSelected(false);
                Rdbtnlinea4ac.setSelected(false);
                Rdbtnlinea5ac.setSelected(false);
                Rdbtnlinea2pt.setSelected(false);
                Rdbtnlinea3pt.setSelected(false);
                Rdbtnlinea4pt.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);
                Rdbtnlinea2ko.setSelected(false);
                Rdbtnlinea3ko.setSelected(false);
                Rdbtnlinea4ko.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);
                txtlinea2comofi.setEnabled(false);
                txtlinea2comagen.setEnabled(false);
                txtlinea2ptosagen.setEnabled(false);
                txtlinea2ptosofi.setEnabled(false);
                txtlinea3comofi.setEnabled(false);
                txtlinea3comagen.setEnabled(false);
                txtlinea3ptosagen.setEnabled(false);
                txtlinea3ptosofi.setEnabled(false);
                txtlinea4comofi.setEnabled(false);
                txtlinea4comagen.setEnabled(false);
                txtlinea4ptosagen.setEnabled(false);
                txtlinea4ptosofi.setEnabled(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);
                buttonGroup2.clearSelection();
                buttonGroup3.clearSelection();
                buttonGroup4.clearSelection();
                buttonGroup5.clearSelection();
                txtfechalinea1.setText(parte2);
                txtlinea1.setText(parte1);
                txtfechalinea2.setText("");
                txtfechalinea3.setText("");
                txtfechalinea4.setText("");
                txtfechalinea5.setText("");

                break;

              case 2:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                txtlinea1.setText(parte1);
                txtfechalinea1.setText(parte2);

                String parte4 = part[3];
                String parte5 = part[4];
                String parte6 = part[5];
                txtlinea2.setText(parte4);
                txtfechalinea2.setText(parte5);
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);

                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);
                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);

                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                  }
                }
                txtlinea3.setText("");
                txtlinea4.setText("");
                txtlinea5.setText("");

                Rdbtnlinea3ac.setSelected(false);
                Rdbtnlinea4ac.setSelected(false);
                Rdbtnlinea5ac.setSelected(false);

                Rdbtnlinea3pt.setSelected(false);
                Rdbtnlinea4pt.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);

                Rdbtnlinea3ko.setSelected(false);
                Rdbtnlinea4ko.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);

                txtlinea3comofi.setEnabled(false);
                txtlinea3comagen.setEnabled(false);
                txtlinea3ptosagen.setEnabled(false);
                txtlinea3ptosofi.setEnabled(false);
                txtlinea4comofi.setEnabled(false);
                txtlinea4comagen.setEnabled(false);
                txtlinea4ptosagen.setEnabled(false);
                txtlinea4ptosofi.setEnabled(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);

                buttonGroup3.clearSelection();
                buttonGroup4.clearSelection();
                buttonGroup5.clearSelection();
                txtfechalinea3.setText("");
                txtfechalinea4.setText("");
                txtfechalinea5.setText("");
                break;

              case 3:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                parte4 = part[3];
                parte5 = part[4];
                parte6 = part[5];
                String parte7 = part[6];
                String parte8 = part[7];
                String parte9 = part[8];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);
                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                    txtlinea1.setEnabled(true);
                    txtfechalinea1.setEnabled(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);
                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);
                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                  }
                }
                if (parte9.equalsIgnoreCase("AC")) {
                  Rdbtnlinea3ac.setSelected(true);
                  txtlinea3comofi.setEnabled(true);
                  txtlinea3comagen.setEnabled(true);
                  txtlinea3ptosagen.setEnabled(true);
                  txtlinea3ptosofi.setEnabled(true);
                  txtlinea3comofi.setText(c9);
                  txtlinea3comagen.setText(c10);
                  txtlinea3ptosagen.setText(c11);
                  txtlinea3ptosofi.setText(c12);
                } else {
                  if (parte9.equalsIgnoreCase("PT")) {
                    Rdbtnlinea3pt.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                    Rdbtnlinea3ac.setEnabled(true);
                    Rdbtnlinea3pt.setEnabled(true);
                    Rdbtnlinea3ko.setEnabled(true);
                  } else {
                    Rdbtnlinea3ko.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                  }
                }
                txtlinea1.setText(parte1);
                txtfechalinea1.setText(parte2);
                txtlinea2.setText(parte4);
                txtfechalinea2.setText(parte5);
                txtlinea3.setText(parte7);
                txtfechalinea3.setText(parte8);
                txtlinea4.setText("");
                txtlinea5.setText("");

                txtfechalinea4.setText("");
                txtfechalinea5.setText("");

                Rdbtnlinea4ac.setSelected(false);
                Rdbtnlinea5ac.setSelected(false);
                Rdbtnlinea4pt.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);
                Rdbtnlinea4ko.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);
                txtlinea4comofi.setEnabled(false);
                txtlinea4comagen.setEnabled(false);
                txtlinea4ptosagen.setEnabled(false);
                txtlinea4ptosofi.setEnabled(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);

                buttonGroup4.clearSelection();
                buttonGroup5.clearSelection();
                break;

              case 4:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                parte4 = part[3];
                parte5 = part[4];
                parte6 = part[5];
                parte7 = part[6];
                parte8 = part[7];
                parte9 = part[8];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                  c13 = c[12];
                  c14 = c[13];
                  c15 = c[14];
                  c16 = c[15];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);
                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                    txtlinea1.setEnabled(true);
                    txtfechalinea1.setEnabled(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);
                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);
                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                  }
                }
                if (parte9.equalsIgnoreCase("AC")) {
                  Rdbtnlinea3ac.setSelected(true);
                  txtlinea3comofi.setEnabled(true);
                  txtlinea3comagen.setEnabled(true);
                  txtlinea3ptosagen.setEnabled(true);
                  txtlinea3ptosofi.setEnabled(true);
                  txtlinea3comofi.setText(c9);
                  txtlinea3comagen.setText(c10);
                  txtlinea3ptosagen.setText(c11);
                  txtlinea3ptosofi.setText(c12);
                } else {
                  if (parte9.equalsIgnoreCase("PT")) {

                    Rdbtnlinea3pt.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                    Rdbtnlinea3ac.setEnabled(true);
                    Rdbtnlinea3pt.setEnabled(true);
                    Rdbtnlinea3ko.setEnabled(true);
                  } else {
                    Rdbtnlinea3ko.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                  }
                }
                if (part[11].equalsIgnoreCase("AC")) {
                  Rdbtnlinea4ac.setSelected(true);
                  txtlinea4comofi.setEnabled(true);
                  txtlinea4comagen.setEnabled(true);
                  txtlinea4ptosagen.setEnabled(true);
                  txtlinea4ptosofi.setEnabled(true);
                  txtlinea4comofi.setText(c13);
                  txtlinea4comagen.setText(c14);
                  txtlinea4ptosagen.setText(c15);
                  txtlinea4ptosofi.setText(c16);
                } else {
                  if (part[11].equalsIgnoreCase("PT")) {

                    Rdbtnlinea4pt.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                    Rdbtnlinea4ac.setEnabled(true);
                    Rdbtnlinea4pt.setEnabled(true);
                    Rdbtnlinea4ko.setEnabled(true);
                  } else {
                    Rdbtnlinea4ko.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                  }
                }
                txtlinea1.setText(parte1);
                txtfechalinea1.setText(parte2);
                txtlinea2.setText(parte4);
                txtfechalinea2.setText(parte5);
                txtlinea3.setText(parte7);
                txtfechalinea3.setText(parte8);
                txtlinea4.setText(part[9]);
                txtfechalinea4.setText(part[10]);
                txtlinea5.setText("");

                txtfechalinea5.setText("");
                Rdbtnlinea5ac.setSelected(false);
                Rdbtnlinea5pt.setSelected(false);
                Rdbtnlinea5ko.setSelected(false);
                txtlinea5comofi.setEnabled(false);
                txtlinea5comagen.setEnabled(false);
                txtlinea5ptosagen.setEnabled(false);
                txtlinea5ptosofi.setEnabled(false);

                buttonGroup5.clearSelection();
                break;

              case 5:
                part = rs.getString("lineasmoviles").split(",");
                parte1 = part[0];
                parte2 = part[1];
                parte3 = part[2];
                parte4 = part[3];
                parte5 = part[4];
                parte6 = part[5];
                parte7 = part[6];
                parte8 = part[7];
                parte9 = part[8];
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                  c13 = c[12];
                  c14 = c[13];
                  c15 = c[14];
                  c16 = c[15];
                  c17 = c[16];
                  c18 = c[17];
                  c19 = c[18];
                  c20 = c[19];
                }
                if (parte3.equalsIgnoreCase("AC")) {
                  Rdbtnlinea1ac.setSelected(true);
                  txtlinea1comofi.setEnabled(true);
                  txtlinea1comagen.setEnabled(true);
                  txtlinea1ptosagen.setEnabled(true);
                  txtlinea1ptosofi.setEnabled(true);
                  txtlinea1comofi.setText(c1);
                  txtlinea1comagen.setText(c2);
                  txtlinea1ptosagen.setText(c3);
                  txtlinea1ptosofi.setText(c4);

                } else {
                  if (parte3.equalsIgnoreCase("PT")) {
                    Rdbtnlinea1pt.setSelected(true);
                    txtfechalinea1.setEnabled(true);
                    txtlinea1.setEnabled(true);
                    Rdbtnlinea1ac.setEnabled(true);
                    Rdbtnlinea1pt.setEnabled(true);
                    Rdbtnlinea1ko.setEnabled(true);
                  } else {
                    Rdbtnlinea1ko.setSelected(true);
                    txtlinea1.setEnabled(true);
                    txtfechalinea1.setEnabled(true);
                  }
                }
                if (parte6.equalsIgnoreCase("AC")) {
                  Rdbtnlinea2ac.setSelected(true);
                  txtlinea2comofi.setEnabled(true);
                  txtlinea2comagen.setEnabled(true);
                  txtlinea2ptosagen.setEnabled(true);
                  txtlinea2ptosofi.setEnabled(true);
                  txtlinea2comofi.setText(c5);
                  txtlinea2comagen.setText(c6);
                  txtlinea2ptosagen.setText(c7);
                  txtlinea2ptosofi.setText(c8);

                } else {
                  if (parte6.equalsIgnoreCase("PT")) {
                    Rdbtnlinea2pt.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                    Rdbtnlinea2ac.setEnabled(true);
                    Rdbtnlinea2pt.setEnabled(true);
                    Rdbtnlinea2ko.setEnabled(true);
                  } else {
                    Rdbtnlinea2ko.setSelected(true);
                    txtlinea2.setEnabled(true);
                    txtfechalinea2.setEnabled(true);
                  }
                }
                if (parte9.equalsIgnoreCase("AC")) {
                  Rdbtnlinea3ac.setSelected(true);
                  txtlinea3comofi.setEnabled(true);
                  txtlinea3comagen.setEnabled(true);
                  txtlinea3ptosagen.setEnabled(true);
                  txtlinea3ptosofi.setEnabled(true);
                  txtlinea3comofi.setText(c9);
                  txtlinea3comagen.setText(c10);
                  txtlinea3ptosagen.setText(c11);
                  txtlinea3ptosofi.setText(c12);

                } else {
                  if (parte9.equalsIgnoreCase("PT")) {
                    Rdbtnlinea3pt.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                    Rdbtnlinea3ac.setEnabled(true);
                    Rdbtnlinea3pt.setEnabled(true);
                    Rdbtnlinea3ko.setEnabled(true);
                  } else {
                    Rdbtnlinea3ko.setSelected(true);
                    txtlinea3.setEnabled(true);
                    txtfechalinea3.setEnabled(true);
                  }
                }
                if (part[11].equalsIgnoreCase("AC")) {
                  Rdbtnlinea4ac.setSelected(true);
                  txtlinea4comofi.setEnabled(true);
                  txtlinea4comagen.setEnabled(true);
                  txtlinea4ptosagen.setEnabled(true);
                  txtlinea4ptosofi.setEnabled(true);
                  txtlinea4comofi.setText(c13);
                  txtlinea4comagen.setText(c14);
                  txtlinea4ptosagen.setText(c15);
                  txtlinea4ptosofi.setText(c16);

                } else {
                  if (part[11].equalsIgnoreCase("PT")) {
                    Rdbtnlinea4pt.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                    Rdbtnlinea4ac.setEnabled(true);
                    Rdbtnlinea4pt.setEnabled(true);
                    Rdbtnlinea4ko.setEnabled(true);
                  } else {
                    Rdbtnlinea4ko.setSelected(true);
                    txtlinea4.setEnabled(true);
                    txtfechalinea4.setEnabled(true);
                  }
                }
                if (part[14].equalsIgnoreCase("AC")) {
                  Rdbtnlinea5ac.setSelected(true);
                  txtlinea5comofi.setEnabled(true);
                  txtlinea5comagen.setEnabled(true);
                  txtlinea5ptosagen.setEnabled(true);
                  txtlinea5ptosofi.setEnabled(true);
                  txtlinea5comofi.setText(c17);
                  txtlinea5comagen.setText(c18);
                  txtlinea5ptosagen.setText(c19);
                  txtlinea5ptosofi.setText(c20);
                } else {
                  if (part[14].equalsIgnoreCase("PT")) {
                    Rdbtnlinea5pt.setSelected(true);
                    txtlinea5.setEnabled(true);
                    txtfechalinea5.setEnabled(true);
                    Rdbtnlinea5ac.setEnabled(true);
                    Rdbtnlinea5pt.setEnabled(true);
                    Rdbtnlinea5ko.setEnabled(true);
                  } else {
                    Rdbtnlinea5ko.setSelected(true);
                    txtlinea5.setEnabled(true);
                    txtfechalinea5.setEnabled(true);
                  }

                  txtlinea1.setText(parte1);
                  txtfechalinea1.setText(parte2);
                  txtlinea2.setText(parte4);
                  txtfechalinea2.setText(parte5);
                  txtlinea3.setText(parte7);
                  txtfechalinea3.setText(parte8);
                  txtlinea4.setText(part[9]);
                  txtfechalinea4.setText(part[10]);
                  txtlinea5.setText(part[12]);
                  txtfechalinea5.setText(part[13]);
                  break;
                }
            }
          } else {
            txtlinea1.setText("");
            txtlinea2.setText("");
            txtlinea3.setText("");
            txtlinea4.setText("");
            txtlinea5.setText("");
            txtfechalinea1.setText("");
            txtfechalinea2.setText("");
            txtfechalinea3.setText("");
            txtfechalinea4.setText("");
            txtfechalinea5.setText("");
            Rdbtnlinea1ac.setSelected(false);
            Rdbtnlinea2ac.setSelected(false);
            Rdbtnlinea3ac.setSelected(false);
            Rdbtnlinea4ac.setSelected(false);
            Rdbtnlinea5ac.setSelected(false);
            Rdbtnlinea1pt.setSelected(false);
            Rdbtnlinea2pt.setSelected(false);
            Rdbtnlinea3pt.setSelected(false);
            Rdbtnlinea4pt.setSelected(false);
            Rdbtnlinea5pt.setSelected(false);
            Rdbtnlinea5ko.setSelected(false);
            Rdbtnlinea2ko.setSelected(false);
            Rdbtnlinea1ko.setSelected(false);
            Rdbtnlinea3ko.setSelected(false);
            Rdbtnlinea4ko.setSelected(false);
            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
            buttonGroup3.clearSelection();
            buttonGroup4.clearSelection();
            buttonGroup5.clearSelection();
            txtlinea1comofi.setEnabled(false);
            txtlinea1comagen.setEnabled(false);
            txtlinea1ptosagen.setEnabled(false);
            txtlinea1ptosofi.setEnabled(false);
            txtlinea2comofi.setEnabled(false);
            txtlinea2comagen.setEnabled(false);
            txtlinea2ptosagen.setEnabled(false);
            txtlinea2ptosofi.setEnabled(false);
            txtlinea3comofi.setEnabled(false);
            txtlinea3comagen.setEnabled(false);
            txtlinea3ptosagen.setEnabled(false);
            txtlinea3ptosofi.setEnabled(false);
            txtlinea4comofi.setEnabled(false);
            txtlinea4comagen.setEnabled(false);
            txtlinea4ptosagen.setEnabled(false);
            txtlinea4ptosofi.setEnabled(false);
            txtlinea5comofi.setEnabled(false);
            txtlinea5comagen.setEnabled(false);
            txtlinea5ptosagen.setEnabled(false);
            txtlinea5ptosofi.setEnabled(false);
          }
          estado = rs.getString("estado");
          if (rs.getString("contrato").equalsIgnoreCase("SI")) {
            chekcontrato.setSelected(true);
          } else {
            chekcontrato.setSelected(false);
          }
          if (rs.getString("documentos").equalsIgnoreCase("SI")) {
            chekdocu.setSelected(true);
          } else {
            chekdocu.setSelected(false);
          }
          if (rs.getString("tv").equalsIgnoreCase("SI")) {
            checktv.setSelected(true);
          } else {
            checktv.setSelected(false);
          }

          if (!rs.getString("oferta").equalsIgnoreCase("")) {
            String[] parts = rs.getString("oferta").split(",");
            String part1 = parts[0];
            String part2 = parts[1];
            String parte3 = parts[2];
            switch (part1) {
              case "FIBRA":
                combotecno.setSelectedIndex(2);
                break;
              case "ADSL":
                combotecno.setSelectedIndex(1);
                break;
              default:
                combotecno.setSelectedIndex(0);
            }
            switch (part2) {
              case "NEBA":
                combotipo.setSelectedIndex(2);
                break;
              case "PROPIA":
                combotipo.setSelectedIndex(1);
                break;
              default:
                combotipo.setSelectedIndex(0);
            }
            txtoferta.setText(parte3);
          }
          if (rs.getString("segmento").equalsIgnoreCase("Residencial")) {
            combosegmento.setSelectedIndex(1);
          } else {
            combosegmento.setSelectedIndex(2);
          }
          switch (rs.getString("operador")) {
            case "Vodafone":
              combooperador.setSelectedIndex(2);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO KO-PARCIAL":
                  comboestados.setSelectedIndex(2);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(3);
                  break;
                case "ACTIVO OK-PARCIAL":
                  comboestados.setSelectedIndex(4);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(5);
                  break;
                case "CANCELADO":
                  comboestados.setSelectedIndex(6);
                  break;
                case "EN LOCALIZACION":
                  comboestados.setSelectedIndex(7);
                  break;
                case "FIRMADA-PROVISION":
                  comboestados.setSelectedIndex(8);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(9);
                  break;
                case "NO APTO":
                  comboestados.setSelectedIndex(10);
                  break;
                case "NO REDCHANNEL":
                  comboestados.setSelectedIndex(11);
                  break;
                case "PDTE VALIDAR":
                  comboestados.setSelectedIndex(12);
                  break;
                case "PLANTILLA":
                  comboestados.setSelectedIndex(13);
                  break;
                case "RELANZADA":
                  comboestados.setSelectedIndex(14);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(15);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(16);
                  break;
                case "VODAGEST MANUAL":
                  comboestados.setSelectedIndex(17);
                  break;
              }
              break;
            case "Orange":
              combooperador.setSelectedIndex(1);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "PLANTILLA":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(7);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(8);
                  break;
              }
              break;
            case "Yoigo":
              combooperador.setSelectedIndex(3);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "PEND. DOCU":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(7);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(8);
                  break;
                case "TRAMITADO":
                  comboestados.setSelectedIndex(9);
                  break;
              }
              break;
            case "MasMovil":
              combooperador.setSelectedIndex(4);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(7);
                  break;
              }
              break;
            default:
              combooperador.setSelectedIndex(5);
              switch (estado) {
                case "ACTIVO KO":
                  comboestados.setSelectedIndex(1);
                  break;
                case "ACTIVO OK":
                  comboestados.setSelectedIndex(2);
                  break;
                case "CANCELA CLIENTE":
                  comboestados.setSelectedIndex(3);
                  break;
                case "EN TRAMITE":
                  comboestados.setSelectedIndex(4);
                  break;
                case "INCIDENCIA":
                  comboestados.setSelectedIndex(5);
                  break;
                case "SCORING KO":
                  comboestados.setSelectedIndex(6);
                  break;
                case "SIN DOCUMENTACION":
                  comboestados.setSelectedIndex(7);
                  break;
              }
              break;
          }

          if (estado.equalsIgnoreCase("ACTIVO OK")) {
            deshabilitar();

          } else {
            habilitarmod();
          }

        } else {
          JOptionPane.showMessageDialog(
              null, "No existe cliente con ese Código", "Alta", JOptionPane.WARNING_MESSAGE);
        }
      } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    } else {
      JOptionPane.showMessageDialog(
          null, "Porfavor codigo para la busqueda", "Alta", JOptionPane.YES_NO_CANCEL_OPTION);
    }
  }

  private void btncomercialesActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btncomercialesActionPerformed
    Comercial cm = new Comercial();
    cm.setVisible(true);
    cm.setLocationRelativeTo(null);
    cm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
  } // GEN-LAST:event_btncomercialesActionPerformed

  private void btngenpdfActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btngenpdfActionPerformed
    Pdfinformes pdf = new Pdfinformes(this, true);
    pdf.setVisible(true);
    pdf.setLocationRelativeTo(null);
    pdf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
  } // GEN-LAST:event_btngenpdfActionPerformed

  private void Rdbtnlinea1acActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea1acActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea1acActionPerformed

  private void Rdbtnlinea2acActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea2acActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea2acActionPerformed

  private void Rdbtnlinea3acActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea3acActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea3acActionPerformed

  private void Rdbtnlinea4acActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea4acActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea4acActionPerformed

  private void Rdbtnlinea5acActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea5acActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea5acActionPerformed

  private void txtportasmovilesFocusLost(
      java.awt.event.FocusEvent evt) { // GEN-FIRST:event_txtportasmovilesFocusLost
    if (!txtportasmoviles.getText().equalsIgnoreCase("")) {
      if (!txtaltasmoviles.getText().equalsIgnoreCase("")) {

        int n = Integer.parseInt(txtportasmoviles.getText());
        int n1 = Integer.parseInt(txtaltasmoviles.getText());
        n += n1;
        if (n > 0) {
          switch (n) {
            case 1:
              txtfechalinea1.setEnabled(true);
              txtfechalinea2.setEnabled(false);
              txtfechalinea3.setEnabled(false);
              txtfechalinea4.setEnabled(false);
              txtfechalinea5.setEnabled(false);
              txtlinea1.setEnabled(true);
              txtlinea2.setEnabled(false);
              txtlinea3.setEnabled(false);
              txtlinea4.setEnabled(false);
              txtlinea5.setEnabled(false);
              Rdbtnlinea1ac.setEnabled(true);
              Rdbtnlinea1pt.setEnabled(true);
              Rdbtnlinea1ko.setEnabled(true);
              Rdbtnlinea2ac.setEnabled(false);
              Rdbtnlinea3ac.setEnabled(false);
              Rdbtnlinea4ac.setEnabled(false);
              Rdbtnlinea5ac.setEnabled(false);
              Rdbtnlinea2pt.setEnabled(false);
              Rdbtnlinea3pt.setEnabled(false);
              Rdbtnlinea4pt.setEnabled(false);
              Rdbtnlinea5pt.setEnabled(false);
              Rdbtnlinea1ko.setEnabled(false);
              Rdbtnlinea2ko.setEnabled(false);
              Rdbtnlinea3ko.setEnabled(false);
              Rdbtnlinea4ko.setEnabled(false);
              Rdbtnlinea5ko.setEnabled(false);
              buttonGroup1.clearSelection();
              buttonGroup2.clearSelection();
              buttonGroup3.clearSelection();
              buttonGroup4.clearSelection();
              buttonGroup5.clearSelection();
              break;
            case 2:
              txtfechalinea1.setEnabled(true);
              txtfechalinea2.setEnabled(true);
              txtfechalinea3.setEnabled(false);
              txtfechalinea4.setEnabled(false);
              txtfechalinea5.setEnabled(false);
              txtlinea1.setEnabled(true);
              txtlinea2.setEnabled(true);
              txtlinea3.setEnabled(false);
              txtlinea4.setEnabled(false);
              txtlinea5.setEnabled(false);
              Rdbtnlinea1ac.setEnabled(true);
              Rdbtnlinea2ac.setEnabled(true);
              Rdbtnlinea3ac.setEnabled(false);
              Rdbtnlinea4ac.setEnabled(false);
              Rdbtnlinea5ac.setEnabled(false);
              Rdbtnlinea1pt.setEnabled(true);
              Rdbtnlinea2pt.setEnabled(true);
              Rdbtnlinea3pt.setEnabled(false);
              Rdbtnlinea4pt.setEnabled(false);
              Rdbtnlinea5pt.setEnabled(false);

              Rdbtnlinea1ko.setEnabled(true);
              Rdbtnlinea2ko.setEnabled(true);
              Rdbtnlinea3ko.setEnabled(false);
              Rdbtnlinea4ko.setEnabled(false);
              Rdbtnlinea5ko.setEnabled(false);
              break;
            case 3:
              txtfechalinea1.setEnabled(true);
              txtfechalinea2.setEnabled(true);
              txtfechalinea3.setEnabled(true);
              txtfechalinea4.setEnabled(false);
              txtfechalinea5.setEnabled(false);
              txtlinea1.setEnabled(true);
              txtlinea2.setEnabled(true);
              txtlinea3.setEnabled(true);
              txtlinea4.setEnabled(false);
              txtlinea5.setEnabled(false);
              Rdbtnlinea1ac.setEnabled(true);
              Rdbtnlinea2ac.setEnabled(true);
              Rdbtnlinea3ac.setEnabled(true);
              Rdbtnlinea4ac.setEnabled(false);
              Rdbtnlinea5ac.setEnabled(false);
              Rdbtnlinea1pt.setEnabled(true);
              Rdbtnlinea2pt.setEnabled(true);
              Rdbtnlinea3pt.setEnabled(true);
              Rdbtnlinea4pt.setEnabled(false);
              Rdbtnlinea5pt.setEnabled(false);
              Rdbtnlinea1ko.setEnabled(true);
              Rdbtnlinea2ko.setEnabled(true);
              Rdbtnlinea3ko.setEnabled(true);
              Rdbtnlinea4ko.setEnabled(false);
              Rdbtnlinea5ko.setEnabled(false);
              break;
            case 4:
              txtfechalinea1.setEnabled(true);
              txtfechalinea2.setEnabled(true);
              txtfechalinea3.setEnabled(true);
              txtfechalinea4.setEnabled(true);
              txtfechalinea5.setEnabled(false);
              txtlinea1.setEnabled(true);
              txtlinea2.setEnabled(true);
              txtlinea3.setEnabled(true);
              txtlinea4.setEnabled(true);
              txtlinea5.setEnabled(false);
              Rdbtnlinea1ac.setEnabled(true);
              Rdbtnlinea2ac.setEnabled(true);
              Rdbtnlinea3ac.setEnabled(true);
              Rdbtnlinea4ac.setEnabled(true);
              Rdbtnlinea5ac.setEnabled(false);
              Rdbtnlinea1pt.setEnabled(true);
              Rdbtnlinea2pt.setEnabled(true);
              Rdbtnlinea3pt.setEnabled(true);
              Rdbtnlinea4pt.setEnabled(true);
              Rdbtnlinea5pt.setEnabled(false);

              Rdbtnlinea1ko.setEnabled(true);
              Rdbtnlinea2ko.setEnabled(true);
              Rdbtnlinea3ko.setEnabled(true);
              Rdbtnlinea4ko.setEnabled(true);
              Rdbtnlinea5ko.setEnabled(false);
              break;
            case 5:
              txtfechalinea1.setEnabled(true);
              txtfechalinea2.setEnabled(true);
              txtfechalinea3.setEnabled(true);
              txtfechalinea4.setEnabled(true);
              txtfechalinea5.setEnabled(true);
              txtlinea1.setEnabled(true);
              txtlinea2.setEnabled(true);
              txtlinea3.setEnabled(true);
              txtlinea4.setEnabled(true);
              txtlinea5.setEnabled(true);
              Rdbtnlinea1ac.setEnabled(true);
              Rdbtnlinea2ac.setEnabled(true);
              Rdbtnlinea3ac.setEnabled(true);
              Rdbtnlinea4ac.setEnabled(true);
              Rdbtnlinea5ac.setEnabled(true);
              Rdbtnlinea1pt.setEnabled(true);
              Rdbtnlinea2pt.setEnabled(true);
              Rdbtnlinea3pt.setEnabled(true);
              Rdbtnlinea4pt.setEnabled(true);
              Rdbtnlinea5pt.setEnabled(true);

              Rdbtnlinea1ko.setEnabled(true);
              Rdbtnlinea2ko.setEnabled(true);
              Rdbtnlinea3ko.setEnabled(true);
              Rdbtnlinea4ko.setEnabled(true);
              Rdbtnlinea5ko.setEnabled(true);
              break;
          }
        } else {
          txtfechalinea1.setEnabled(false);
          txtfechalinea2.setEnabled(false);
          txtfechalinea3.setEnabled(false);
          txtfechalinea4.setEnabled(false);
          txtfechalinea5.setEnabled(false);
          txtlinea1.setEnabled(false);
          txtlinea2.setEnabled(false);
          txtlinea3.setEnabled(false);
          txtlinea4.setEnabled(false);
          txtlinea5.setEnabled(false);
          Rdbtnlinea1ac.setEnabled(false);
          Rdbtnlinea2ac.setEnabled(false);
          Rdbtnlinea3ac.setEnabled(false);
          Rdbtnlinea4ac.setEnabled(false);
          Rdbtnlinea5ac.setEnabled(false);
          Rdbtnlinea1pt.setEnabled(false);
          Rdbtnlinea2pt.setEnabled(false);
          Rdbtnlinea3pt.setEnabled(false);
          Rdbtnlinea4pt.setEnabled(false);
          Rdbtnlinea5pt.setEnabled(false);
          Rdbtnlinea1ko.setEnabled(false);
          Rdbtnlinea2ko.setEnabled(false);
          Rdbtnlinea3ko.setEnabled(false);
          Rdbtnlinea4ko.setEnabled(false);
          Rdbtnlinea5ko.setEnabled(false);
        }
      } else {

        JOptionPane.showMessageDialog(
            null, "Pon numero en Altas", "Portas", JOptionPane.YES_NO_CANCEL_OPTION);
      }
    } else {
      JOptionPane.showMessageDialog(
          null, "Pon numero en Portas", "Portas", JOptionPane.YES_NO_CANCEL_OPTION);
    }
  } // GEN-LAST:event_txtportasmovilesFocusLost

  private void Rdbtnlinea1ptActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea1ptActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea1ptActionPerformed

  private void Rdbtnlinea1koActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_Rdbtnlinea1koActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_Rdbtnlinea1koActionPerformed

  private void txtlinea2comagenActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea2comagenActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea2comagenActionPerformed

  private void txtlinea2ptosofiActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea2ptosofiActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea2ptosofiActionPerformed

  private void txtlinea3ptosofiActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea3ptosofiActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea3ptosofiActionPerformed

  private void txtlinea3comagenActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea3comagenActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea3comagenActionPerformed

  private void txtlinea4ptosofiActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea4ptosofiActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea4ptosofiActionPerformed

  private void txtlinea4comagenActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea4comagenActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea4comagenActionPerformed

  private void txtlinea5ptosofiActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea5ptosofiActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea5ptosofiActionPerformed

  private void txtlinea5comagenActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtlinea5comagenActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtlinea5comagenActionPerformed

  private void btnabrirvisitasActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnabrirvisitasActionPerformed
    Visita vs = new Visita(this, true, logueado);
    vs.setVisible(true);
    vs.setLocationRelativeTo(null);
    vs.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
  } // GEN-LAST:event_btnabrirvisitasActionPerformed

  /** @param args the command line arguments */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
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
      java.util.logging.Logger.getLogger(Principal.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new Principal().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JRadioButton Rdbtnlinea1ac;
  private javax.swing.JRadioButton Rdbtnlinea1ko;
  private javax.swing.JRadioButton Rdbtnlinea1pt;
  private javax.swing.JRadioButton Rdbtnlinea2ac;
  private javax.swing.JRadioButton Rdbtnlinea2ko;
  private javax.swing.JRadioButton Rdbtnlinea2pt;
  private javax.swing.JRadioButton Rdbtnlinea3ac;
  private javax.swing.JRadioButton Rdbtnlinea3ko;
  private javax.swing.JRadioButton Rdbtnlinea3pt;
  private javax.swing.JRadioButton Rdbtnlinea4ac;
  private javax.swing.JRadioButton Rdbtnlinea4ko;
  private javax.swing.JRadioButton Rdbtnlinea4pt;
  private javax.swing.JRadioButton Rdbtnlinea5ac;
  private javax.swing.JRadioButton Rdbtnlinea5ko;
  private javax.swing.JRadioButton Rdbtnlinea5pt;
  private javax.swing.JButton btnabrirvisitas;
  private javax.swing.JButton btnbuscar;
  private javax.swing.JButton btncargar;
  private javax.swing.JButton btncomerciales;
  private javax.swing.JButton btngenpdf;
  private javax.swing.JButton btnguardar;
  private javax.swing.JButton btnnuevo;
  private javax.swing.JButton btnsalirP;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.ButtonGroup buttonGroup2;
  private javax.swing.ButtonGroup buttonGroup3;
  private javax.swing.ButtonGroup buttonGroup4;
  private javax.swing.ButtonGroup buttonGroup5;
  private javax.swing.JCheckBox checktv;
  private javax.swing.JCheckBox chekcontrato;
  private javax.swing.JCheckBox chekdocu;
  private javax.swing.JComboBox<String> combocomerciales;
  private javax.swing.JComboBox<String> combodelegaciones;
  private javax.swing.JComboBox<String> combodsitrOran;
  private javax.swing.JComboBox<String> comboestados;
  private javax.swing.JComboBox<String> combooperador;
  private javax.swing.JComboBox<String> combosegmento;
  private javax.swing.JComboBox combotecno;
  private javax.swing.JComboBox combotipo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel23;
  private javax.swing.JLabel jLabel24;
  private javax.swing.JLabel jLabel25;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JRadioButton jRadioButton4;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextField txtaltasmoviles;
  private javax.swing.JTextField txtcargacliente;
  private javax.swing.JLabel txtcodcomercial;
  private javax.swing.JTextField txtdocumento;
  private javax.swing.JTextField txtfecha;
  private javax.swing.JTextField txtfechalinea1;
  private javax.swing.JTextField txtfechalinea2;
  private javax.swing.JTextField txtfechalinea3;
  private javax.swing.JTextField txtfechalinea4;
  private javax.swing.JTextField txtfechalinea5;
  private javax.swing.JTextField txtidoferta;
  private javax.swing.JTextField txtiua;
  private javax.swing.JTextField txtlinea1;
  private javax.swing.JTextField txtlinea1comagen;
  private javax.swing.JTextField txtlinea1comofi;
  private javax.swing.JTextField txtlinea1ptosagen;
  private javax.swing.JTextField txtlinea1ptosofi;
  private javax.swing.JTextField txtlinea2;
  private javax.swing.JTextField txtlinea2comagen;
  private javax.swing.JTextField txtlinea2comofi;
  private javax.swing.JTextField txtlinea2ptosagen;
  private javax.swing.JTextField txtlinea2ptosofi;
  private javax.swing.JTextField txtlinea3;
  private javax.swing.JTextField txtlinea3comagen;
  private javax.swing.JTextField txtlinea3comofi;
  private javax.swing.JTextField txtlinea3ptosagen;
  private javax.swing.JTextField txtlinea3ptosofi;
  private javax.swing.JTextField txtlinea4;
  private javax.swing.JTextField txtlinea4comagen;
  private javax.swing.JTextField txtlinea4comofi;
  private javax.swing.JTextField txtlinea4ptosagen;
  private javax.swing.JTextField txtlinea4ptosofi;
  private javax.swing.JTextField txtlinea5;
  private javax.swing.JTextField txtlinea5comagen;
  private javax.swing.JTextField txtlinea5comofi;
  private javax.swing.JTextField txtlinea5ptosagen;
  private javax.swing.JTextField txtlinea5ptosofi;
  private javax.swing.JTextField txtnombre;
  private javax.swing.JTextField txtnumfijo;
  private javax.swing.JTextArea txtobservaciones;
  private javax.swing.JTextField txtoferta;
  private javax.swing.JTextField txtportasmoviles;
  private javax.swing.JTextArea txtvaps;
  private javax.swing.JTextField txtvcfijo;
  private javax.swing.JTextField txtvcmovil;
  // End of variables declaration//GEN-END:variables
}

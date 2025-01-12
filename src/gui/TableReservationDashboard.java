/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

<<<<<<< HEAD
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
=======
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.FileHandler;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.MySQL;
import model.UserBean;

=======
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.MySQL;
import model.UserBean;
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba

/**
 *
 * @author user
 */
public class TableReservationDashboard extends javax.swing.JPanel {

    private AdminHome adminHome;
    HashMap<String, String> tableMap = new HashMap<>();
    private static java.util.logging.Logger log1;
    private static FileHandler handler1;

<<<<<<< HEAD
    /**
     * Creates new form TableReservationDashboard
     */
=======
    HashMap<String, String> tableNoMap = new HashMap<>();

    private static java.util.logging.Logger log1;
    private static FileHandler handler1;

>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba
    static {
        try {
            log1 = java.util.logging.Logger.getLogger("log1");
            handler1 = new FileHandler("log.txt", true);
            log1.addHandler(handler1);
        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
<<<<<<< HEAD
    }

    public TableReservationDashboard(AdminHome adminHome) {
        initComponents();
        this.adminHome = adminHome;
        loadTable();

    }

    public void loadTable() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `table`");

            Vector<String> v = new Vector<>();
            v.add("Select");
            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                this.tableMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
//             model.removeElementAt(0);

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
=======
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba
    }

    public TableReservationDashboard() {
        initComponents();
        loadTableNo();
        loadTableData();
//        searchCusMobile();
    }

    public void loadTableNo() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `table`");

            Vector<String> v = new Vector<>();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                this.tableNoMap.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }

    public void loadTableData() {

        try {

            ResultSet rs = MySQL.execute("SELECT * FROM `reservation` "
                    + "INNER JOIN `customer` ON `customer`.`id` = `reservation`.`customer_id` "
                    + "INNER JOIN `table` ON `table`.`id` = `reservation`.`table_id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {

                Vector<String> vector = new Vector<>();

                vector.add(rs.getString("id"));
                vector.add(rs.getString("customer.name"));
                vector.add(rs.getString("customer.mobile"));
                vector.add(rs.getString("num_guests"));
                vector.add(rs.getString("table.name"));
                vector.add(rs.getString("date"));
                vector.add(rs.getString("time"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }

    }

    public void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jSpinField1.setValue(1);
        jComboBox1.setSelectedIndex(0);
        jDateChooser1.setDate(new Date());
        jTimeChooser2.setTime(new Date());
    }

//    public void searchCusMobile() {
//
//        jTextField3.setColumns(10);
//        
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
//        jTable1.setRowSorter(sorter);
//
//        // Add the key listener for filtering
//        jTextField3.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                String cusMobile = jTextField3.getText();
//
//                if (cusMobile.trim().isEmpty()) {
//                    sorter.setRowFilter(null); // Clear the filter
//
//                } else {
//                    try {
//                        sorter.setRowFilter(RowFilter.regexFilter("^d{1,9}$", 2)); // Column index for Customer Mobile
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//
//                }
//            }
//        });
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jTimeChooser2 = new lu.tudor.santec.jtimechooser.JTimeChooser();

        jLabel2.setFont(new java.awt.Font("Noto Serif Hebrew", 1, 26)); // NOI18N
        jLabel2.setText("Table Reservation");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel3.setText("Customer Name");

        jTextField1.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setText("Customer Mobile");

        jTextField2.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel5.setText("Table No");

        jComboBox1.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel6.setText("Reservation Date");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel7.setText("No of Guests");

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel8.setText("From Time");

        jPanel2.setLayout(new java.awt.GridLayout());

        jButton1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton1.setText("Add Reservation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton2.setText("Update Reservation Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jTextField3.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton4.setText("Print Reciept");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel11.setText("Customer Mobile");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "R_ID", "Customer Name", "Customer Mobile", "No of Guests", "Table No", "Date", "From Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
<<<<<<< HEAD
=======
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jDateChooser1.setDate(new Date());
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N

        jSpinField1.setMinimum(0);
        jSpinField1.setValue(1);

        jTimeChooser2.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N
        jTimeChooser2.setShowSeconds(false);
        jTimeChooser2.setTime(new Date());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2)
                                    .addComponent(jTimeChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jTimeChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
<<<<<<< HEAD
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))))
=======
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cusName = jTextField1.getText();
        String cusMobile = jTextField2.getText();
        int guestsNo = jSpinField1.getValue();
<<<<<<< HEAD
        Date reservedDate = jDateChooser1.getDate(); 
        String time = jTimeChooser2.getFormatedTime();
        String table = String.valueOf(jComboBox1.getSelectedIndex());
         UserBean us = new UserBean();
        int id =us.getId();
        
       LocalDate currentDate = LocalDate.now(); 
       
        if (cusName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!cusName.matches("^[a-zA-Z]*$")) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (cusMobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!cusMobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (guestsNo == 0) {
            JOptionPane.showMessageDialog(this, "Invalid Guest Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!new Date().before(reservedDate)) {
            JOptionPane.showMessageDialog(this, "Invalid Reservation Date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (time.equals("00.00")) {
            JOptionPane.showMessageDialog(this, "Invalid Reservation Time", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String table_id = tableMap.get(table);
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(reservedDate); 
            try {
                MySQL.execute("INSERT INTO `reservation` (`customer_name`,`num_guests`,`mobile`,`date`,`time`,`user_id`,`table_id`)VALUES('" + cusName + "','" + guestsNo + "','" + cusMobile + "','" + formattedDate + "','" + time + "','" + id + "','" + table + "')");
//                reset();
            } catch (Exception ex) {
                 log1.warning(ex.toString());
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        String cusMobile = jTextField3.getText();

        if (cusMobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
           
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TableReservationAdvancedSearch tableReservationAdvancedSearch = new TableReservationAdvancedSearch();
        tableReservationAdvancedSearch.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

=======
        String tableNo = String.valueOf(jComboBox1.getSelectedItem());

        Date date = jDateChooser1.getDate();

        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        String reservedDate = format.format(date);

        String time = jTimeChooser2.getFormatedTime();

        if (cusName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!cusName.matches("^[a-zA-Z]*$")) {
            JOptionPane.showMessageDialog(this, "Invalid Customer Name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (cusMobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!cusMobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (guestsNo == 0) {
            JOptionPane.showMessageDialog(this, "Invalid Guest Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tableNo == "Select") {
            JOptionPane.showMessageDialog(this, "Invalid Table Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!new Date().before(date) && date.equals(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid Reservation Date", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (reservedDate.equals(null)) {
            JOptionPane.showMessageDialog(this, "Reservation Date Cannot be Empty", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (time.equals("00.00")) {
            JOptionPane.showMessageDialog(this, "Invalid Reservation Time", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                int userId = AdminHome.getUserBean().getId();

                ResultSet rs = MySQL.execute("SELECT * FROM `customer` WHERE `mobile` = '" + cusMobile + "'");

                int cusId;

                String tableNoId = tableNoMap.get(tableNo);

                if (rs.next()) {

                    cusId = rs.getInt("id");

                    MySQL.execute("INSERT INTO `reservation` "
                            + "(`num_guests`,`date`,`time`,`user_id`,`table_id`,`customer_id`) VALUES "
                            + "('" + guestsNo + "','" + reservedDate + "','" + time + "','" + userId + "','" + tableNoId + "','" + cusId + "')");

                } else {

                    MySQL.execute("INSERT INTO `customer` (`name`,`mobile`) "
                            + "VALUES ('" + cusName + "','" + cusMobile + "')");

                    ResultSet rs2 = MySQL.execute("SELECT * FROM `customer` WHERE `mobile` = '" + cusMobile + "'");

                    if (rs.next()) {
                        cusId = rs2.getInt("id");

                        MySQL.execute("INSERT INTO `reservation` "
                                + "(`num_guests`,`date`,`time`,`user_id`,`table_id`,`customer_id`) VALUES "
                                + "('" + guestsNo + "','" + reservedDate + "','" + time + "','" + userId + "','" + tableNoId + "','" + cusId + "')");
                    }

                }

                loadTableData();
                reset();

            } catch (Exception e) {
                e.printStackTrace();
                log1.warning(e.toString());
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed

    }//GEN-LAST:event_jTextField3KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int guestsNo = jSpinField1.getValue();
        String tableNo = String.valueOf(jComboBox1.getSelectedItem());

        int row = jTable1.getSelectedRow();
        String id = String.valueOf(jTable1.getValueAt(row, 0));

        Date date = jDateChooser1.getDate();

        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        String reservedDate = format.format(date);

        String time = jTimeChooser2.getFormatedTime();

        if (guestsNo == 0) {
            JOptionPane.showMessageDialog(this, "Invalid Guest Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tableNo == "Select") {
            JOptionPane.showMessageDialog(this, "Invalid Table Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!new Date().before(date) && date.equals(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid Reservation Date", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (reservedDate.equals(null)) {
            JOptionPane.showMessageDialog(this, "Reservation Date Cannot be Empty", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (time.equals("00.00")) {
            JOptionPane.showMessageDialog(this, "Invalid Reservation Time", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {

                int userId = AdminHome.getUserBean().getId();

                MySQL.execute("UPDATE `reservation` SET "
                        + "`num_guests`='" + guestsNo + "', "
                        + "`date`='" + reservedDate + "', "
                        + "`time`='" + time + "' "
                        + "WHERE `id`='" + id + "'");

                loadTableData();
                reset();

            } catch (Exception e) {
                e.printStackTrace();
                log1.warning(e.toString());
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String cusMobile = jTextField3.getText();

            try {

                ResultSet rs = MySQL.execute("SELECT * FROM `customer` "
                        + "INNER JOIN `reservation` "
                        + "ON `customer`.`id` = `reservation`.`customer_id` "
                        + "INNER JOIN `table` ON `table`.`id` = `reservation`.`table_id` "
                        + "WHERE `mobile` = '" + cusMobile + "'");

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                while (rs.next()) {

                    Vector<String> vector = new Vector<>();

                    vector.add(rs.getString("id"));
                    vector.add(rs.getString("customer.name"));
                    vector.add(rs.getString("customer.mobile"));
                    vector.add(rs.getString("num_guests"));
                    vector.add(rs.getString("table.name"));
                    vector.add(rs.getString("date"));
                    vector.add(rs.getString("time"));

                    model.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
                log1.warning(e.toString());
            }

        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        try {

            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                String cusName = String.valueOf(model.getValueAt(selectedRow, 1));
                String cusMobile = String.valueOf(model.getValueAt(selectedRow, 2));
                int guestsNo = Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 3)));
                String tableNo = String.valueOf(model.getValueAt(selectedRow, 4));

                String date = String.valueOf(model.getValueAt(selectedRow, 5));
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                Date d = dateformat.parse(date);

                String time = String.valueOf(model.getValueAt(selectedRow, 6));
                SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
                Date d2 = timeformat.parse(time);

                jTextField1.setText(cusName);
                jTextField2.setText(cusMobile);
                jSpinField1.setValue(guestsNo);

                DefaultComboBoxModel table = (DefaultComboBoxModel) jComboBox1.getModel();
                table.setSelectedItem(tableNo);
                jDateChooser1.setDate(d);
                jTimeChooser2.setTime(d2);

                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jComboBox1.setEnabled(false);

            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }

    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkPurpleIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableReservationDashboard().setVisible(true);
            }
        });
    }
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeChooser2;
    // End of variables declaration//GEN-END:variables
}

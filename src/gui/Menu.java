/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import java.util.logging.FileHandler;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.MySQL;
import model.UserBean;

public class Menu extends javax.swing.JPanel {

    private AdminHome adminHome;
    HashMap<String, String> menuType = new HashMap<>();
    HashMap<String, String> sizeMap = new HashMap<>();
    
    private static java.util.logging.Logger log1;
    private static FileHandler handler1;

    static {
        try {
            log1 = java.util.logging.Logger.getLogger("log1");
            handler1 = new FileHandler("log.txt", true);
            log1.addHandler(handler1);
        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }

    public Menu(AdminHome adminHome) {
        initComponents();
        this.adminHome = adminHome;
        loadMenuType();
        loadSize();
        loadMenu();
        setupSearchFunctionality();
        loadsortsize();
        jButton2.setEnabled(false);
<<<<<<< HEAD
        setupSortFunctionality1();
    }

    private void loadsortsize() {
=======
        
//        System.out.println(AdminHome.getUserBean().getId());
    }

    private void loadsortsize(){
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba
        try {

            ResultSet resultSet2 = MySQL.execute("SELECT * FROM `size`");
            ResultSet resultSet3 = MySQL.execute("SELECT * FROM `menu_type`");

            Vector<String> v1 = new Vector<>();
            v1.add("All");
            while (resultSet2.next()) {
                v1.add(resultSet2.getString("size"));
            }
            while (resultSet3.next()) {
                v1.add(resultSet3.getString("name"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v1);
            jComboBox4.setModel(model);
//             model.removeElementAt(0);

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }

<<<<<<< HEAD
=======
            int row = jTable1.getSelectedRow();
            
            String query = "SELECT * FROM `menu` "
                    + "INNER JOIN `menu_type` ON "
                    + "`menu_type`.`id` = `menu`.`menu_type_id` "
                    + "INNER JOIN `size` ON "
                    + "`size`.`id` = `menu`.`size_id` ";
            
            if (row != -1) {
                
                String id2 = String.valueOf(jTable1.getValueAt(row, 0));
                query += "WHERE `menu`.`id` = '" + id2 + "' ";
            }
 
            String sort = String.valueOf(jComboBox4.getSelectedItem());

            query += "WHERE ";

            if (sort.equals("full")) {
                query += "`size`.`id` = 2 ";
            }else if (sort.equals("small")) {
               query += "`size`.`id` = 1 ";
            }else if(sort.equals("All")){
               query += "`size`.`id` = 1 OR  `size`.`id` = 2";
            }

            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("menu.id"));
                vector.add(resultSet.getString("menu.name"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("description"));
                vector.add(resultSet.getString("menu_type.name"));
                vector.add(resultSet.getString("size.size"));
                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba
    public void setupSearchFunctionality() {
        jTextField2.setColumns(20);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        jTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = jTextField2.getText().toLowerCase();
                if (searchText.trim().isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + searchText, 1));
                }
            }
        });
    }

    public void reset() {
        jTextField1.setText("");
        jFormattedTextField3.setText("0");
        jTextArea1.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jButton2.setEnabled(false);
        jButton1.setEnabled(true);
        loadMenu();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    }

    public void loadMenuType() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `menu_type`");

            Vector<String> v = new Vector<>();
            v.add("Select");
            while (resultSet.next()) {
                v.add(resultSet.getString("name"));
                this.menuType.put(resultSet.getString("name"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox2.setModel(model);
            // model.removeElementAt(0);

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }

    ///that code chat gpt
    public void setupSortFunctionality1() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

// Add an action listener to the JComboBox for sorting
        jComboBox4.addActionListener(e -> {
            String selectedSize = (String) jComboBox4.getSelectedItem();
            if (selectedSize == null || selectedSize.equalsIgnoreCase("All")) {
                sorter.setRowFilter(null); // Show all rows if "All" is selected
            } else {
                RowFilter<DefaultTableModel, Object> sizeFilter = RowFilter.regexFilter("(?i)^" + selectedSize, 5);
                RowFilter<DefaultTableModel, Object> typeFilter = RowFilter.regexFilter("(?i)^" + selectedSize, 4);

                ArrayList<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<>();
                filters.add(sizeFilter);
                filters.add(typeFilter);

                sorter.setRowFilter(RowFilter.orFilter(filters));
            }
        });
    }

    public void loadSize() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `size`");

            Vector<String> v = new Vector<>();
            v.add("Select");
            while (resultSet.next()) {
                v.add(resultSet.getString("size"));
                this.sizeMap.put(resultSet.getString("size"), resultSet.getString("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox3.setModel(model);
//             model.removeElementAt(0);

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }

    public void loadMenu() {
        try {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultset = MySQL.execute("SELECT * FROM `menu` "
                    + "INNER JOIN `menu_type` ON `menu`.`menu_type_id` = `menu_type`.`id` "
                    + "INNER JOIN `size` ON `menu`.`size_id` = `size`.`id`");

            while (resultset.next()) {
                String id = resultset.getString("id");
                String name = resultset.getString("menu.name");
                String price = resultset.getString("price");
                String des = resultset.getString("description");
                String type = resultset.getString("menu_type.name");
                String size = resultset.getString("size.size");

                Vector vector = new Vector(); // Row
                vector.add(id);
                vector.add(name);
                vector.add(price);
                vector.add(des);
                vector.add(type);
                vector.add(size);

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        jLabel2.setFont(new java.awt.Font("Noto Serif Hebrew", 1, 26)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel1.setText("Name");

        jTextField1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel4.setText("Description");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel5.setText("Type");

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel8.setText("Size");

        jComboBox2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
<<<<<<< HEAD
        jFormattedTextField3.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
=======
        jFormattedTextField3.setText("0");
        jFormattedTextField3.setFont(new java.awt.Font("Cambria", 0, 15)); // NOI18N
>>>>>>> 0184f6dc2b61d8a2916b8e55d5d5271d3799feba

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2)
                            .addComponent(jFormattedTextField3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Description", "Type", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel9.setText("Sort By");

        jComboBox4.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "small", "full" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jLabel6.setText("Name");

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton1.setText("Add Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("Cambria", 1, 15)); // NOI18N
        jButton2.setText("Update Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = jTextField1.getText();
        String price = jFormattedTextField3.getText();
        String des = jTextArea1.getText();
        String type = String.valueOf(jComboBox2.getSelectedItem());
        String size = String.valueOf(jComboBox3.getSelectedItem());

        try {
            
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Food name", "Warning", JOptionPane.WARNING_MESSAGE);
            
            } else if (price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Price", "Warning", JOptionPane.WARNING_MESSAGE);
            
            }else if (price.equals("0")) {
                JOptionPane.showMessageDialog(this, "Invalid Price", "Warning", JOptionPane.WARNING_MESSAGE);
            
            } else if (!price.matches("^\\d*(\\.\\d{1,3})?$")) {
                JOptionPane.showMessageDialog(this, "Please valid Price", "Warning", JOptionPane.WARNING_MESSAGE);
            
            } else if (des.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Description", "Warning", JOptionPane.WARNING_MESSAGE);
            
            } else if (type == "Select") {
                JOptionPane.showMessageDialog(this, "Please Select the Food Type", "Warning", JOptionPane.WARNING_MESSAGE);
            
            } else if (size == "Select") {
                JOptionPane.showMessageDialog(this, "Please Select the Food Size", "Warning", JOptionPane.WARNING_MESSAGE);
            
            } else {
                String menutype_id = menuType.get(type);
                String size_id = sizeMap.get(size);
                MySQL.execute("INSERT INTO `menu` (`name`,`price`,`description`,`menu_type_id`,`size_id`)VALUES('" + name + "','" + price + "','" + des + "','" + menutype_id + "','" + size_id + "')");
                reset();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log1.warning(e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();
        String id = String.valueOf(jTable1.getValueAt(row, 0));
        String name = jTextField1.getText();
        String price = jFormattedTextField3.getText();
        String des = jTextArea1.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Food Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!price.matches("^\\d*(\\.\\d{1,3})?$")) {
            JOptionPane.showMessageDialog(this, "Please valid Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select a User Type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                MySQL.execute("UPDATE `menu` SET `name`='" + name + "',`price`='" + price + "',`description`='" + des + "' WHERE `id`='" + id + "' ");
            } catch (Exception e) {
                e.printStackTrace();
                log1.warning(e.toString());
            }
            reset();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.adminHome.removeMenu();
        //this.adminHome.removeUserManagement();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // String idi = String.valueOf(model.getValueAt(selectedRow, 0));
            String name = String.valueOf(model.getValueAt(selectedRow, 1));
            String price = String.valueOf(model.getValueAt(selectedRow, 2));
            String des = String.valueOf(model.getValueAt(selectedRow, 3));
            String type = String.valueOf(model.getValueAt(selectedRow, 4));
            String size = String.valueOf(model.getValueAt(selectedRow, 5));

            jTextField1.setText(name);
            jFormattedTextField3.setText(price);
            jTextArea1.setText(des);

            DefaultComboBoxModel typec = (DefaultComboBoxModel) jComboBox2.getModel();
            DefaultComboBoxModel sizec = (DefaultComboBoxModel) jComboBox3.getModel();
            typec.setSelectedItem(type);
            sizec.setSelectedItem(size);

            jButton1.setEnabled(false);
            jButton2.setEnabled(true);
            jComboBox2.setEnabled(false);
            jComboBox3.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        //loadStocks();
    }//GEN-LAST:event_jComboBox4ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

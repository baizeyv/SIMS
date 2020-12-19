package SIMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class userUI extends JFrame {
    // Panel Array
    private JPanel contentPanel;
    private JPanel queryPanel;

    // Table Array
    private JTable table;
    private LocalTableModel model = new LocalTableModel();

    // Label Array
    private JLabel lblID; /* student ID */
    private JLabel lblSex; /* student Sex */
    private JLabel lblPhone; /* student Phone number */
    private JLabel lblName; /* student Name */
    private JLabel lblAge; /* student Age */
    private JLabel lblMail; /* student Mail */
    private JLabel lblQq; /* student Qq Number */
    private JLabel lblDel;
    private JLabel lblInfo;

    // Text Field Array
    private JTextField jtfID; /* ID text field */
    private JTextField jtfPhone; /* Phone text field */
    private JTextField jtfName; /* Name text field */
    private JTextField jtfAge; /* Age text field */
    private JTextField jtfMail; /* Mail text field */
    private JTextField jtfQq; /* Qq text field */
    private JTextField jtfDel;

    // Combo Box
    private JComboBox<String> cbxSex;

    // Button Array
    private JButton btnDel;
    private JButton btnQuery;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnReset;

    // Scroll Panel
    private JScrollPane scrollpanel;

    public userUI() {
        setTitle("Students Information Manager System"); // name of window
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 340, 533, 388);

        // content panel
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        // query panel
        queryPanel = new JPanel();
        queryPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"Set Condition Of Query",TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        queryPanel.setBounds(10, 10, 509, 156);
        contentPanel.add(queryPanel);
        queryPanel.setLayout(null);

        // student ID
        lblID = new JLabel("ID:");
        lblID.setFont(new Font("arial", Font.PLAIN, 14));
        lblID.setBounds(20, 28, 75, 15);
        queryPanel.add(lblID);

        jtfID = new JTextField();
        jtfID.setBounds(80, 25, 159, 21);
        queryPanel.add(jtfID);
        jtfID.setColumns(10);

        // student Sex
        lblSex = new JLabel("Sex:");
        lblSex.setFont(new Font("arial", Font.PLAIN, 14));
        lblSex.setBounds(20, 60, 75, 15);
        queryPanel.add(lblSex);

        cbxSex = new JComboBox<String>();
        cbxSex.setBackground(Color.WHITE);
        cbxSex.setFont(new Font("arial", Font.PLAIN, 14));
        cbxSex.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
        cbxSex.setBounds(80, 57, 77, 21);
        queryPanel.add(cbxSex);

        // student Phone
        lblPhone = new JLabel("Phone:");
        lblPhone.setFont(new Font("arial", Font.PLAIN, 14));
        lblPhone.setBounds(20, 92, 75, 15);
        queryPanel.add(lblPhone);

        jtfPhone = new JTextField();
        jtfPhone.setFont(new Font("arial", Font.PLAIN, 14));
        jtfPhone.setBounds(80, 89, 159, 21);
        queryPanel.add(jtfPhone);
        jtfPhone.setColumns(10);

        // student mail
        lblMail = new JLabel("Mail:");
        lblMail.setFont(new Font("arial", Font.PLAIN, 14));
        lblMail.setHorizontalAlignment(SwingConstants.TRAILING);
        lblMail.setBounds(272, 92, 52, 15);
        queryPanel.add(lblMail);

        jtfMail = new JTextField();
        jtfMail.setFont(new Font("arial", Font.PLAIN, 14));
        jtfMail.setBounds(330, 89, 159, 21);
        queryPanel.add(jtfMail);
        jtfMail.setColumns(7);

        // student name
        lblName = new JLabel("Name:");
        lblName.setFont(new Font("arial", Font.PLAIN, 14));
        lblName.setHorizontalAlignment(SwingConstants.TRAILING);
        lblName.setBounds(249, 28, 75, 15);
        queryPanel.add(lblName);

        jtfName = new JTextField();
        jtfName.setFont(new Font("arial", Font.PLAIN, 14));
        jtfName.setBounds(330, 25, 159, 21);
        queryPanel.add(jtfName);
        jtfName.setColumns(10);

        // student age
        lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("arial", Font.PLAIN, 14));
        lblAge.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAge.setBounds(176, 60, 45, 15);
        queryPanel.add(lblAge);

        jtfAge = new JTextField();
        jtfAge.setFont(new Font("arial", Font.PLAIN, 14));
        jtfAge.setBounds(225, 57, 45, 21);
        queryPanel.add(jtfAge);
        jtfAge.setColumns(10);

        // student qq
        lblQq = new JLabel("QQ:");
        lblQq.setFont(new Font("arial", Font.PLAIN, 14));
        lblQq.setHorizontalAlignment(SwingConstants.TRAILING);
        lblQq.setBounds(289, 60, 35, 15);
        queryPanel.add(lblQq);

        jtfQq = new JTextField();
        jtfQq.setFont(new Font("arial", Font.PLAIN, 14));
        jtfQq.setBounds(330, 57, 159, 21);
        queryPanel.add(jtfQq);
        jtfQq.setColumns(10);

        // delete
        lblDel = new JLabel("Delete:");
        lblDel.setFont(new Font("arial", Font.PLAIN, 14));
        lblDel.setBounds(20, 125, 85, 15);
        queryPanel.add(lblDel);

        jtfDel = new JTextField();
        jtfDel.setFont(new Font("arial", Font.PLAIN, 14));
        jtfDel.setBounds(80, 120, 93, 23);
        queryPanel.add(jtfDel);
        jtfDel.setColumns(7);

        // delete button
        btnDel = new JButton("Delete");
        btnDel.setBounds(270, 120, 80, 23);
        queryPanel.add(btnDel);
        btnDel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection con = new JDBCUtil().getConn();
                Statement stat;
                ResultSet rs;
                List<userData> list = new ArrayList<userData>();
                try {
                    stat = con.createStatement();
                    if (jtfDel.getText().equals("")) {
                        String id = jtfID.getText();
                        String name = jtfName.getText();
                        String age = jtfAge.getText();
                        String qq = jtfQq.getText();
                        String phone = jtfPhone.getText();
                        String mail = jtfMail.getText();
                        String sex = cbxSex.getSelectedItem().toString();
                        String sql = "SELECT * FROM student WHERE 1=1";
                        rs = stat.executeQuery(sql);
                        if(!id.equals("")){
                            sql = sql + " AND ID='" + id + "'";
                        }
                        if(!name.equals("")){
                            sql = sql + " AND NAME='" + name + "'";
                        }
                        if(!sex.equals("")){
                            sql = sql + " AND SEX='" + sex + "'";
                        }
                        if(!age.equals("")){
                            sql = sql + " AND AGE=" + age + "";
                        }
                        if(!qq.equals("")){
                            sql = sql + " AND QQ='" + qq + "'";
                        }
                        if(!phone.equals("")){
                            sql = sql + " AND PHONE='" + phone + "'";
                        }
                        if(!mail.equals("")){
                            sql = sql + " AND MAIL='" + mail + "'";
                        }
                        while(rs.next()){
                            userData u = new userData();
                            u.setId(rs.getString(1));
                            list.add(u);
                        }
                        if(list.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Delete ERROR! Not Exist");
                        }else {
                            do_btnDelete_actionPerformed(e);
                        }
                    }else {
                        rs = stat.executeQuery("SELECT ID FROM student WHERE ID='" + jtfDel.getText() + "'");
                        while(rs.next()){
                            userData u = new userData();
                            u.setId(rs.getString(1));
                            list.add(u);
                        }
                        if(list.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Delete ERROR! Not Exist");
                        }else {
                            stat.execute("DELETE FROM student WHERE ID='" + jtfDel.getText() + "';");
                            JOptionPane.showMessageDialog(null, "Delete Successfully!");
                        }
                    }
                    rs.close();
                    stat.close();
                    con.close();
                    new userUI();
                } catch (SQLException e1) {
                    //TODO: handle exception
                    e1.printStackTrace();
                }
            }
        });

        // query button
        btnQuery = new JButton("Query");
        btnQuery.setBounds(185, 120, 80, 23);
        queryPanel.add(btnQuery);
        btnQuery.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                do_btnQuery_actionPerformed(e);
            }
        });

        // insert button
        btnInsert = new JButton("Insert");
        btnInsert.setBounds(356, 120, 80, 23);
        queryPanel.add(btnInsert);
        btnInsert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                do_btnInsert_actionPerformed(e);
            }
        });

        // reset button
        btnReset = new JButton("R");
        btnReset.setBounds(445, 120, 50, 23);
        queryPanel.add(btnReset);
        btnReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                do_btnReset_actionPerformed(e);
            }
        });

        // scroll panel
        scrollpanel = new JScrollPane();
        scrollpanel.setBounds(12, 170, 507, 192);
        contentPanel.add(scrollpanel);

        // table model
        table = new JTable(model);
        scrollpanel.setViewportView(table);
        this.setVisible(true);

        // info label
        lblInfo = new JLabel("Author: baizeyv; Mail: baizeyv@Gmail.com");
        lblInfo.setFont(new Font("arial", Font.PLAIN, 14));
        lblInfo.setBounds(120, 360, 300, 20);
        contentPanel.add(lblInfo);

        // update button
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(433, 364, 85, 20);
        contentPanel.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                do_btnUpdate_actionPerformed(e);
            }
        });

    }
    protected void do_btnReset_actionPerformed(ActionEvent e) {
        new userUI();
    }

    protected void do_btnDelete_actionPerformed(ActionEvent e) {
        model.setRowCount(0);
        JDBCUtil util = new JDBCUtil();
        if(jtfID.getText().equals("")&&
                jtfName.getText().equals("")&&
                jtfPhone.getText().equals("")&&
                jtfMail.getText().equals("")&&
                jtfAge.getText().equals("")&&
                jtfQq.getText().equals("")&&
                cbxSex.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Delete ERROR!");
        }else{
            String strID = jtfID.getText();
            String strName = jtfName.getText();
            String strAge = jtfAge.getText();
            String strQq = jtfQq.getText();
            String strPhone = jtfPhone.getText();
            String strMail = jtfMail.getText();
            String strSex = cbxSex.getSelectedItem().toString();
            List<userData> list = util.deleteInfo(strID, strName, strSex, strAge, strQq, strPhone, strMail);
            JOptionPane.showMessageDialog(null, "Delete Successfully!");
        }
    }

    protected void do_btnInsert_actionPerformed(ActionEvent e) {
        model.setRowCount(0);
        JDBCUtil util = new JDBCUtil();
        if(jtfID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter ID!");
        }else{
            String strID = jtfID.getText();
            String strName = jtfName.getText();
            String strAge = jtfAge.getText();
            String strQq = jtfQq.getText();
            String strPhone = jtfPhone.getText();
            String strMail = jtfMail.getText();
            String strSex = cbxSex.getSelectedItem().toString();
            List<userData> list = util.insertInfo(strID, strName, strSex, strAge, strQq, strPhone, strMail);
            JOptionPane.showMessageDialog(null, "Inerst Successfully!");
        }
    }

    protected void do_btnUpdate_actionPerformed(ActionEvent e) {
        model.setRowCount(0);
        JDBCUtil util = new JDBCUtil();
        if(jtfID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter ID!");
        }else{
            String strID = jtfID.getText();
            String strName = jtfName.getText();
            String strAge = jtfAge.getText();
            String strQq = jtfQq.getText();
            String strPhone = jtfPhone.getText();
            String strMail = jtfMail.getText();
            String strSex = cbxSex.getSelectedItem().toString();
            List<userData> list = util.updateInfo(strID, strName, strSex, strAge, strQq, strPhone, strMail);
            JOptionPane.showMessageDialog(null, "Update Successfully!");
        }
    }

    protected void do_btnQuery_actionPerformed(ActionEvent e) {
        model.setRowCount(0);
        JDBCUtil util = new JDBCUtil();
        if(jtfID.getText().equals("")&&
                jtfName.getText().equals("")&&
                jtfPhone.getText().equals("")&&
                jtfMail.getText().equals("")&&
                jtfAge.getText().equals("")&&
                jtfQq.getText().equals("")&&
                cbxSex.getSelectedItem().toString().equals("")){
            List<userData> list = util.getAllInfo();
            for (int i = 0; i < list.size(); i++) {
                userData user = list.get(i);
                model.addRow(new Object[]{
                    user.getId(),
                        user.getName(),
                        user.getSex(),
                        user.getAge(),
                        user.getQq(),
                        user.getPhone(),
                        user.getMail()
                });
            }
        }else{
            String strID = jtfID.getText();
            String strName = jtfName.getText();
            String strAge = jtfAge.getText();
            String strQq = jtfQq.getText();
            String strPhone = jtfPhone.getText();
            String strMail = jtfMail.getText();
            String strSex = cbxSex.getSelectedItem().toString();
            List<userData> list = util.getPartInfo(strID, strName, strSex, strAge, strQq, strPhone, strMail);
            for (int i = 0; i < list.size(); i++) {
                userData user = list.get(i);
                model.addRow(new Object[]{
                    user.getId(),
                        user.getName(),
                        user.getSex(),
                        user.getAge(),
                        user.getQq(),
                        user.getPhone(),
                        user.getMail()
                });
            }
        }

    }

    // public static void main(String[] args) {
    //     userUI userui = new userUI();
    //     userui.setVisible(true);
    // }

}

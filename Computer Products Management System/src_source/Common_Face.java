import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;

import static java.lang.Integer.parseInt;
import static javax.swing.RowFilter.regexFilter;

public class Common_Face {
    public Vector<Computer> information = new Vector<>();
    public Vector<Vector<String>> computers = new Vector<>();

    private JComboBox box;
    private JComboBox box1;
    JFrame jfad = new JFrame("Computer Products Management System");
    JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    JPanel jPanel2 = new JPanel(gridBagLayout);
    private static String[] s1 = {"Please Chose", "All", "Desktop PC", "Tablet", "Laptop"};
    private static String[][] s2 = {
            {"None"},
            {"None"},
            {"Please Select", "Gaming", "Home & Study", "Business", "Compact"},
            {"Please Select", "Android", "Apple", "Windows"},
            {"Please Select", "Business", "Home & Study", "Thin & Light", "Gaming"}
    };
    //String[] label = {"category", "type", "ID", "brand", "CPU_Family", "memorysize", "SSD_capacity", "screenSize", "price"};
    JTable jt;
    TableRowSorter sorter;
    int inde;
    DefaultTableModel model;

    public Common_Face() {
        jfad.setLayout(new BorderLayout());
        JPanel jpad = new JPanel(new FlowLayout());

        JButton b1 = new JButton("Click to Log out");
        b1.setPreferredSize(new Dimension(600,200));
        ImageIcon out = new ImageIcon("login.png");
        out.setImage(out.getImage().getScaledInstance(380,180,Image.SCALE_DEFAULT));
        Font font = new Font(Font.SERIF, Font.PLAIN, 24);
        b1.setFont(font);
        b1.setIcon(out);

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Begin();
                jfad.dispose();
            }
        });
        //JPanel jpad = new JPanel(new FlowLayout());
        //jpad.add()
//        JMenuBar bar = new JMenuBar();
//        JMenu menu = new JMenu("Products");
//        JMenu menu1 = new JMenu("Details");
//        bar.add(menu);
//        bar.add(menu1);
//        //jpad.add(bar, FlowLayout.LEFT);
//        jfad.add(bar, BorderLayout.NORTH);
        JTabbedPane tabbedPane = new JTabbedPane();
        setJpanel1();
        setJpanel2();
        tabbedPane.addTab("Browse Products", jPanel1);
        tabbedPane.addTab("Check/Update Products Details",jPanel2);
        jfad.add(tabbedPane);
        jfad.setBounds(450,60,600,800);
        jfad.setVisible(true);
        jfad.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfad.add(b1,BorderLayout.SOUTH);
    }

    void setJpanel1(){
        try {
            new Read_File(information, computers);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Vector<String> label = new Vector<>();
        label.add("Category");
        label.add("Type");
        label.add("ID");
        label.add("Brand");
        label.add("CPU Family");
        label.add("Memory Size");
        label.add("SSD Capacity");
        label.add("Screen Size");
        label.add("Price($)");

        model = new DefaultTableModel(computers, label);
        jt = new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        sorter  = new TableRowSorter(model);

        jt.setRowSorter(sorter);

        JLabel jl1 = new JLabel("Computer Category:");
        jl1.setHorizontalAlignment(SwingConstants.RIGHT);
        /*
        Achieve two-level linkage
         */
        box = new JComboBox(s1);
        box.setPreferredSize(new Dimension(130,30));
        box.addActionListener(this::actionPerformed);
        JPanel jp1 = new JPanel(new BorderLayout());
        JPanel jp3 = new JPanel(new FlowLayout());
        JPanel jp4 = new JPanel(new FlowLayout());

        JLabel jl2 = new JLabel("Computer Type:");
        jl2.setHorizontalAlignment(SwingConstants.RIGHT);
        box1 = new JComboBox(s2[0]);
        box1.setPreferredSize(new Dimension(150,30));
        box1.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED){
                String itemString = (String) e.getItem();
                System.out.println(itemString);
                ArrayList<RowFilter<Object, Object>> al = new ArrayList<>(2);
                al.add(RowFilter.regexFilter(String.valueOf(box.getSelectedItem())));
                al.add(RowFilter.regexFilter(String.valueOf(box1.getSelectedItem())));
                if (itemString.equals("Please Select")){
                    sorter.setRowFilter(regexFilter(box.getSelectedItem().toString()));
                }else {
                    sorter.setRowFilter(RowFilter.andFilter(al));
                }
            }
        });

        JScrollPane scrollpane;
        scrollpane = new JScrollPane(jt){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(570,430);//括号内参数，可以根据需要更改
            }
        };
        scrollpane.setViewportView(jt);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        jp3.add(jl1);
        jp3.add(box);
        jp4.add(jl2);
        jp4.add(box1);
        jp1.add(jp3,BorderLayout.NORTH);
        jp1.add(jp4,BorderLayout.SOUTH);
        jPanel1.add(jp1);

        jPanel1.add(scrollpane);
    }
    void setJpanel2(){
        JTextField jt1 = new JTextField();
        JTextField jt2 = new JTextField();
        JTextField jt3 = new JTextField();
        JTextField jt4 = new JTextField();
        JTextField jt5 = new JTextField();
        JTextField jt6 = new JTextField();
        JTextField jt7 = new JTextField();
        JLabel jl1 = new JLabel("Model ID:", SwingConstants.RIGHT);
        JLabel jl2 = new JLabel("Category:", SwingConstants.RIGHT);
        JLabel jl3 = new JLabel("Type:", SwingConstants.RIGHT);
        JLabel jl4 = new JLabel("Brand:", SwingConstants.RIGHT);
        JLabel jl5 = new JLabel("CPU Family:", SwingConstants.RIGHT);
        JLabel jl6 = new JLabel("Memory Size:", SwingConstants.RIGHT);
        JLabel jl7 = new JLabel("SSD Capacity:", SwingConstants.RIGHT);
        JLabel jl8 = new JLabel("Screen Size:", SwingConstants.RIGHT);
        JLabel jl9 = new JLabel("Prize:", SwingConstants.RIGHT);
        JComboBox jc1;
        JComboBox jc2;
        jc1 = new JComboBox(s1);
        jc2 = new JComboBox(s2[0]);
        JButton b1 = new JButton("Add");
        JButton b2 = new JButton("Update");
        JButton b3 = new JButton("Delete");
        JButton b4 = new JButton("Clear");
        //Restrict permissions
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl1, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt1, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl2, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jc1, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl3, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jc2, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl4, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt2, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl5, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt3, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl6, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt4, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl7, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt5, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl8, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt6, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jl9, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jt7, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(b1, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(b2, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(b3, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(b4, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;

        jPanel2.add(jl1);
        jPanel2.add(jt1);
        jPanel2.add(jl2);
        jPanel2.add(jc1);
        jPanel2.add(jl3);
        jPanel2.add(jc2);
        jPanel2.add(jl4);
        jPanel2.add(jt2);
        jPanel2.add(jl5);
        jPanel2.add(jt3);
        jPanel2.add(jl6);
        jPanel2.add(jt4);
        jPanel2.add(jl7);
        jPanel2.add(jt5);
        jPanel2.add(jl8);
        jPanel2.add(jt6);
        jPanel2.add(jl9);
        jPanel2.add(jt7);
        jPanel2.add(b1);
        jPanel2.add(b2);
        jPanel2.add(b3);
        jPanel2.add(b4);

        /*
        Set monitor for table
         */
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inde = jt.getSelectedRow();
                jt1.setText(String.valueOf(jt.getValueAt(inde,2)));
                jt2.setText(String.valueOf(jt.getValueAt(inde,3)));
                jt3.setText(String.valueOf(jt.getValueAt(inde,4)));
                jt4.setText(String.valueOf(jt.getValueAt(inde,5)));
                jt5.setText(String.valueOf(jt.getValueAt(inde,6)));
                jt6.setText(String.valueOf(jt.getValueAt(inde,7)));
                jt7.setText(String.valueOf(jt.getValueAt(inde,8)));


                jc1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent a) {
                        jc2.removeAllItems();
                        JComboBox cp = (JComboBox) a.getSource();
                        //get items
                        String itemString = (String) cp.getSelectedItem();
                        System.out.println(itemString);
                        int index = jc1.getSelectedIndex();
                        //jc2.setSelectedItem(jt.getValueAt(inde,1));
                        for (int i = 0; i < s2[index].length; i++) {
                            jc2.addItem(s2[index][i]);
                        }
                        if (itemString.equals("All")){
                            jc2.setEnabled(false);
                        }else if (itemString.equals("Please Chose")){
                            jc2.setEnabled(false);
                        }else {
                            jc2.setEnabled(true);
                        }
                    }
                });
                //jc2.setSelectedItem(jt.getValueAt(inde,1));
                jc2.addItemListener(a -> {
                    if(a.getStateChange() == ItemEvent.SELECTED){
                        String itemString = (String) a.getItem();
                        System.out.println(itemString);
                    }
                });
                jc1.setSelectedItem(jt.getValueAt(inde,0));
                jc2.setSelectedItem(jt.getValueAt(inde,1));


            }
        });
//        b1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                boolean in = true;
//                for (Vector<String> judge: computers){
//                    if (judge.get(2).equals(jt1.getText())){
//                        JOptionPane.showMessageDialog(jPanel2, "ID already existed!","ERROR", 0);
//                        in = false;
//                    }
//                }
//                if (in){
//                    Vector<String> temp = new Vector<>();
//                    temp.add((String) jc1.getSelectedItem());
//                    temp.add((String) jc2.getSelectedItem());
//                    temp.add(jt1.getText());
//                    temp.add(jt2.getText());
//                    temp.add(jt3.getText());
//                    temp.add(jt4.getText());
//                    temp.add(jt5.getText());
//                    temp.add(jt6.getText());
//                    temp.add(jt7.getText());
//                    computers.add(temp);
//                    model.fireTableDataChanged();
//                    JOptionPane.showMessageDialog(jPanel2, "ADD SUCCESSFULLY!","SUCCESS", 1);
//                }
//            }
//        });
//        b2.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                boolean in = true;
//                int a = 0;
//                for (Vector<String> judge: computers){
//                    if (judge.get(2).equals(jt1.getText())){
//                        break;
//                    }
//                    a ++;
//                }
//                if (a == computers.size()){
//                    JOptionPane.showMessageDialog(jPanel2, "no ID existed!","ERROR", 0);
//                    in = false;
//                }
//                if (in){
//                    computers.removeElementAt(a);
//                    Vector<String> temp = new Vector<>();
//                    temp.add((String) jc1.getSelectedItem());
//                    temp.add((String) jc2.getSelectedItem());
//                    temp.add(jt1.getText());
//                    temp.add(jt2.getText());
//                    temp.add(jt3.getText());
//                    temp.add(jt4.getText());
//                    temp.add(jt5.getText());
//                    temp.add(jt6.getText());
//                    temp.add(jt7.getText());
//                    computers.add(temp);
//                    model.fireTableDataChanged();
//                    JOptionPane.showMessageDialog(jPanel2, "Update successfully!","Success", 1);
//                }
//            }
//        });
//        b3.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                boolean in = true;
//                int a = 0;
//                for (Vector<String> judge: computers){
//                    if (judge.get(2).equals(jt1.getText())){
//                        break;
//                    }
//                    a ++;
//                }
//                if (a == computers.size()){
//                    JOptionPane.showMessageDialog(jPanel2, "There is no this compouter!","ERROR", 0);
//                    in = false;
//                }
//                if (in){
//                    computers.removeElementAt(a);
//                    model.fireTableDataChanged();
//                    JOptionPane.showMessageDialog(jPanel2, "Delete successfully!","Success", 1);
//                }
//            }
//        });
//        b4.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                jt1.setText("");
//                jt2.setText("");
//                jt3.setText("");
//                jt4.setText("");
//                jt5.setText("");
//                jt6.setText("");
//                jt7.setText("");
//                JOptionPane.showMessageDialog(jPanel2, "Clear successfully!","success", 1);
//
//            }
//        });
//        jc2.addItemListener(e -> {
//            if(e.getStateChange() == ItemEvent.SELECTED){
//                String itemString = (String) e.getItem();
//                System.out.println(itemString);
//            }
//        });
    }

    private void actionPerformed(ActionEvent e) {
        box1.removeAllItems();
        JComboBox cb = (JComboBox) e.getSource();
        //get items
        String itemString = (String) cb.getSelectedItem();
        System.out.println(itemString);

        int index = box.getSelectedIndex();
        for (int i = 0; i < s2[index].length; i++) {
            box1.addItem(s2[index][i]);
        }
        //Vector<Vector<String>> select_computer = computers.stream().filter(computers.get())
        if (itemString.equals("All")){
            sorter.setRowFilter(null);
            box1.setEnabled(false);
        }else if (itemString.equals("Please Chose")){
            sorter.setRowFilter(null);
            box1.setEnabled(false);
        }else {
            box1.setEnabled(true);
            sorter.setRowFilter(regexFilter(box.getSelectedItem().toString()));
        }
    }
}

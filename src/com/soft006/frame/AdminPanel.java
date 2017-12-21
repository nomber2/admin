package com.soft006.frame;

import com.soft006.factory.ServiceFactory;
import com.soft006.model.Attendance;
import com.soft006.service.EmployeeService;
import com.style.MyDialog;
import com.style.MyMouseAdapter;
import com.style.RoundBorder;
import com.style.Style;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

/**
 * @auther 邓燕
 * 2017/12/21.
 */
public class AdminPanel extends JPanel{
        private JPanel mainPanel;
        private JPanel upPanel;
        private JPanel centerPanel;
        private JPanel topPanel;
        private JTable table;
        private DefaultTableModel dtm;
        private java.util.List<Attendance> attList;
        private int row;
        private String id;
        private String attendanceString;
        private EmployeeService employeeService = ServiceFactory.EmployeeServiceInstance();

        public AdminPanel() {
            setLayout(new BorderLayout());
            mainPanel = new JPanel(new BorderLayout());
            centerPanel = new JPanel(new BorderLayout());
            upPanel = new JPanel();
            topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,10));
            showAll();
            JLabel title = new JLabel("管理员考勤查询界面");
            JTextField search = new JTextField();
            JButton searchButton = new JButton("查询");
            JButton saveButton = new JButton("保存");
            JButton printButton = new JButton("打印");
            Style.setLabelStyle(title);
            Style.setFieldStyle(search);
            Style.setSmallButtonStyle(searchButton);
            Style.setSmallButtonStyle(saveButton);
            Style.setSmallButtonStyle(printButton);
            search.setBorder(new RoundBorder());
            search.setEnabled(true);
            searchButton.addMouseListener(new MyMouseAdapter(searchButton));
            saveButton.addMouseListener(new MyMouseAdapter(saveButton));
            printButton.addMouseListener(new MyMouseAdapter(printButton));
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String keywords = search.getText().trim();
                    attList = employeeService.queryLikeA(keywords);
                    int count = dtm.getRowCount();
                    for (int i = count - 1; i >= 0; i--) {
                        dtm.removeRow(i);
                    }
                    for (Attendance attendance: attList) {
                        add(attendance);
                    }
                }
            });

            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    row = table.getSelectedRow();
                    System.out.println(row);
                    id = table.getValueAt(row,0).toString();
                    attendanceString = table.getValueAt(row,5).toString();
                    Attendance attendance = null;
                    attendance = employeeService.getAttendance(id);
                    System.out.println(attendance);
                }
            });

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    id = table.getValueAt(row,0).toString();
                    Attendance attendance = null;
                    attendance = employeeService.getAttendance(id);
                    attendance.setAttendance(attendanceString);
                    int n = 0;
                    n = employeeService.update(attendance);
                    if (n == 1) {
                        new MyDialog("保存成功！");
                        dtm.removeRow(row);
                        add(attendance);
                    } else {
                        JOptionPane.showMessageDialog(null,"保存失败！");
                    }
                }
            });

            topPanel.add(search);
            topPanel.add(searchButton);
            topPanel.add(saveButton);
            topPanel.add(printButton);
            upPanel.add(title);
            //upPanel.add(printButton);
            centerPanel.add(topPanel,BorderLayout.NORTH);
            mainPanel.add(centerPanel,BorderLayout.CENTER);
            mainPanel.add(upPanel,BorderLayout.NORTH);
            add(mainPanel);
        }

        private void showAll() {
            dtm = new DefaultTableModel();
            table = new JTable();
            String[] titles = {"编号","工号","部门","月","日","是否考勤"};
            //设置表头的标题列
            dtm.setColumnIdentifiers(titles);
            //给表格设置数据模型
            table.setModel(dtm);
            //将单元格内容居中
            DefaultTableCellRenderer r = new DefaultTableCellRenderer();
            //设置水平方向居中
            r.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(Object.class, r);
            //将表头居中
            table.getTableHeader().setDefaultRenderer(r);
            //内容字符串数组
            String[] content = new String[6];
            //获取到数据库中所有用户信息
            attList = ServiceFactory.EmployeeServiceInstance().getALL();
            Iterator<Attendance> iterator = attList.iterator();
            while (iterator.hasNext()) {
                Attendance attendance = iterator.next();
                 content[0] = String.valueOf(attendance.getId());
                content[1] = attendance.getAccount();
                String string = null;
                if (attendance.getDepartmentID() == 1) {
                    string = "人事部";
                } else {
                    string = "财务部";
                }
                content[2] = string;
                content[3] = attendance.getMouth();
                content[4] = attendance.getDay();
                content[5] = String.valueOf(attendance.getAttendance());
                dtm.addRow(content);
            }
            JScrollPane jScrollPane = new JScrollPane(table);
            centerPanel.add(jScrollPane);
            centerPanel.revalidate();
        }

        /**
         * 表格增加一行考勤
         *
         * @param attendance
         */
        public void add(Attendance attendance) {
            String string = null;
           if (attendance.getDepartmentID() == 1) {
               string = "人事部";
           } else {
               string = "财务部";
           }
            Object[] rowData = {attendance.getId(),attendance.getAccount(), string,
                    attendance.getMouth(), attendance.getDay(), attendance.getAttendance()};
            dtm.addRow(rowData);
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("测试窗体");
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.add(new AdminPanel());

            frame.setVisible(true);
        }

}

package com.soft006.frame;

import com.soft006.factory.ServiceFactory;
import com.soft006.model.Attendance;
import com.soft006.model.RP;
import com.soft006.service.EmployeeService;
import com.style.MyMouseAdapter;
import com.style.RoundBorder;
import com.style.Style;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Admin on 2017/12/21.
 */
public class StaffPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel upPanel;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JTable table;
    private DefaultTableModel dtm;
    private java.util.List<Attendance> attList;
    private EmployeeService employeeService = ServiceFactory.EmployeeServiceInstance();

    public StaffPanel() {
        setLayout(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        upPanel = new JPanel();
        centerPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,0));
        showAll();
        JLabel title = new JLabel("员工个人考勤查询界面");
        JTextField search = new JTextField();
        JButton searchButton = new JButton("查询");
        Style.setLabelStyle(title);
        Style.setFieldStyle(search);
        Style.setSmallButtonStyle(searchButton);
        search.setBorder(new RoundBorder());
        search.setEnabled(true);
        searchButton.addMouseListener(new MyMouseAdapter(searchButton));
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
        topPanel.add(search);
        topPanel.add(searchButton);
        upPanel.add(title);
        centerPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(upPanel,BorderLayout.NORTH);
        add(mainPanel);
    }

    private void showAll() {
        dtm = new DefaultTableModel();
        table = new JTable();
        String[] titles = {"工号","部门","月","日","是否考勤"};
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
        String[] content = new String[5];
        //获取到数据库中所有用户信息
        attList = ServiceFactory.EmployeeServiceInstance().get("1602753135");
        Iterator<Attendance> iterator = attList.iterator();
        while (iterator.hasNext()) {
            Attendance attendance = iterator.next();
           // content[0] = String.valueOf(attendance.getId());
            content[0] = attendance.getAccount();
            String string = String.valueOf(attendance.getDepartmentID());
            if (string == "1") {
                content[1] = "财务部";
            } else {
                content[1] = "人事部";
            }
            content[2] = attendance.getMouth();
            content[3] = attendance.getDay();
            content[4] = String.valueOf(attendance.getAttendance());
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
        Object[] rowData = {attendance.getAccount(), attendance.getDepartmentID(),
                attendance.getMouth(), attendance.getDay(), attendance.getAttendance()};
        dtm.addRow(rowData);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new StaffPanel());

        frame.setVisible(true);
    }
}

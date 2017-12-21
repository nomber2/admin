package com.soft006.frame;

import com.soft006.factory.ServiceFactory;
import com.soft006.model.RP;
import com.soft006.service.EmployeeService;
import com.style.Style;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Admin on 2017/12/21.
 */
public class EmployeePanel extends JPanel{
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel upPanel;
    private JTable table;
    private DefaultTableModel dtm;
    private java.util.List<RP> rpList;
    private EmployeeService employeeService = ServiceFactory.EmployeeServiceInstance();
    private String conditon;

    public EmployeePanel() {
        mainPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel();
        upPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
        setLayout(new BorderLayout());
        JComboBox rpComboBox = new JComboBox();
        rpComboBox.addItem("奖");
        rpComboBox.addItem("惩");
        rpComboBox.setSelectedItem("奖");
        Style.setFieldStyle(rpComboBox);
        rpComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    conditon = rpComboBox.getSelectedItem().toString();
                }
            }
        });
        upPanel.add(rpComboBox);
        showAll();
        mainPanel.add(upPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.WEST);
        add(mainPanel);
    }

    private void showAll() {
        dtm = new DefaultTableModel();
        table = new JTable();
        String[] titles = {"工号","奖惩类型","奖惩名称","时间"};
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
        String[] content = new String[4];
        //获取到数据库中所有用户信息
        rpList = ServiceFactory.EmployeeServiceInstance().getRP("1602753135");
        Iterator<RP> iterator = rpList.iterator();
        while (iterator.hasNext()) {
            RP rp = iterator.next();
            content[0] = rp.getAccount();
            content[1] = rp.getKind();
            content[2] = rp.getName();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            content[3] = sdf.format(rp.getTime());
            dtm.addRow(content);
        }
        JScrollPane jScrollPane = new JScrollPane(table);
        centerPanel.add(jScrollPane);
        centerPanel.revalidate();
    }

    /**
     * 表格增加一行奖惩数据
     *
     * @param rp
     */
    public void addRP(RP rp) {
        Object[] rowData = {rp.getAccount(),rp.getKind(), rp.getName(), rp.getTime()};
        dtm.addRow(rowData);
    }

    public void updateModel() {
        rpList = employeeService.queryBy(conditon.toString());
        int count = dtm.getRowCount();
        for (int i = count - 1; i >= 0; i --) {
            dtm.removeRow(i);
        }
        for (RP rp : rpList) {
            addRP(rp);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(890, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new EmployeePanel());

        frame.setVisible(true);
    }
}

package HumanManage;

import javax.swing.*;

public class APP {
    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
        SwingUtilities.invokeLater(EmployeeManagementFrameUI::new);
    }
}

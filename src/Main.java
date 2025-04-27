
import view.FrMenu;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            // Configura o look and feel do sistema operacional
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Cria e exibe o menu principal
            FrMenu menu = new FrMenu(null, true);
            menu.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Erro ao iniciar o sistema: " + e.getMessage(), 
                "Erro", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
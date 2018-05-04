package leitorImagens;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5074428825031195287L;
	private BufferedImage img;
    private ImageIcon icon;
    private JLabel quadro;
    private JButton btn;

    public Tela() {
        init();
    }

    private void init() {

        btn = new JButton("Buscar Imagem");
        quadro = new JLabel();

        this.add(quadro);
        this.add(btn);

        JFrame frame = new JFrame();
        frame.setTitle("Carregar Imagem");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.getContentPane().add(this);
        frame.setVisible(true);

        btn.addActionListener(this); 

    }

    private File getImage() {

        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        } else {
            return null;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            img = ImageIO.read(getImage());
            icon = new ImageIcon(img);
            quadro.setIcon(icon);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
    public static void main(String[] args) {
		new Tela();
	}
}
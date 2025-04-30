package gui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    // Constructeur de la classe BackgroundPanel qui prend en paramètre l'image de fond
    public BackgroundPanel(String imagePath) {
        super();
        // Chargement de l'image de fond
        backgroundImage = new ImageIcon(imagePath).getImage();
        // Définition de la taille du panneau pour correspondre à l'image de fond
        setPreferredSize(new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));
    }

    // Méthode paintComponent qui permet de dessiner l'image de fond sur le panneau
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessin de l'image de fond
        g.drawImage(backgroundImage, 0, 0, null);
    }
}

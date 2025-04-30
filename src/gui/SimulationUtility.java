package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

public class SimulationUtility {

    // Méthode pour charger une image à partir d'un fichier

    public static Image loadImage(String fileName) {

        String imagePath = "Images" + File.separator + fileName; // Construire le chemin relatif vers le fichier image
        String absolutePath = new File(imagePath).getAbsolutePath(); // Obtenir le chemin absolu à partir du chemin relatif

        return Toolkit.getDefaultToolkit().getImage(absolutePath); // Charger l'image à partir du fichier en utilisant l'outil Toolkit de Java
    }
}

import javax.swing.*;

public class FrameUstaCollection extends JFrame {
    public FormUstaCollections _formUstaCollections;
    public FrameUstaCollection(){
        super();
        setTitle("UstaCollection");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        _formUstaCollections = new FormUstaCollections();
        setContentPane(_formUstaCollections.getPictureBoxCollections());
        setDefaultLookAndFeelDecorated(false);
        setLocation(400, 50);
        pack();
        setVisible(true);
    }
}

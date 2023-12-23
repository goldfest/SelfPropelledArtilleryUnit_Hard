import javax.swing.*;

public class MainFrameUsta extends JFrame {
    private SelfPropelledArtilleryUnit _formUsta;

    public MainFrameUsta() {
        super();
        setTitle("ArtilleryUnit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        _formUsta = new SelfPropelledArtilleryUnit();
        setContentPane(_formUsta.getPictureBox());
        setDefaultLookAndFeelDecorated(false);
        setLocation(500, 50);
        setSize(500, 850);
        pack();
        setVisible(true);
    }
}

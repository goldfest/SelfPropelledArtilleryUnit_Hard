import javax.swing.*;

public class FrameUstaBat extends JFrame {
    public FormUstaBat _formUstaCollection;
    public FrameUstaBat() {
        super();
        setTitle("UstaBat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        _formUstaCollection = new FormUstaBat();
        setContentPane(_formUstaCollection.getPictureBox());
        setDefaultLookAndFeelDecorated(false);
        setLocation(500, 200);
        pack();
        setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class SelfPropelledArtilleryUnit {
    DrawingUsta _drawingUsta = new DrawingUsta();
    private JButton buttonCreate;
    private JPanel pictureBox;
    private JButton buttonUp;
    private JButton buttonDown;
    private JButton buttonLeft;
    private JButton buttonRight;

    public JPanel getPictureBox() {
        return pictureBox;
    }
    public SelfPropelledArtilleryUnit()
    {
        buttonUp.setName("buttonUp");
        buttonDown.setName("buttonDown");
        buttonLeft.setName("buttonLeft");
        buttonRight.setName("buttonRight");

        buttonCreate.addActionListener(e -> {
            _drawingUsta = new DrawingUsta();
            Random random = new Random();

            _drawingUsta.Init(
                    random.nextInt(100, 300),
                    random.nextInt(1000, 3000),
                    new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                    new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                    random.nextBoolean(),
                    random.nextBoolean(),
                    pictureBox.getWidth(),
                    pictureBox.getHeight()
            );

            _drawingUsta.SetWheelsCount(random.nextInt(4, 7));
            _drawingUsta.SetPosition(random.nextInt(10, 100), random.nextInt(10, 100));
            Draw();
        });

        ActionListener buttonMoveClickedListener = e -> {
            String buttonName = ((JButton) e.getSource()).getName();

            switch (buttonName) {
                case ("buttonUp") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Up);
                }
                case ("buttonDown") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Down);
                }
                case ("buttonLeft") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Left);
                }
                case ("buttonRight") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Right);
                }
            }
            Draw();
        };
        buttonUp.addActionListener(buttonMoveClickedListener);
        buttonDown.addActionListener(buttonMoveClickedListener);
        buttonLeft.addActionListener(buttonMoveClickedListener);
        buttonRight.addActionListener(buttonMoveClickedListener);
    }
    public void Draw() {
        if (_drawingUsta.EntityUsta == null) {
            return;
        }
        Graphics g = pictureBox.getGraphics();
        pictureBox.paint(g);
        _drawingUsta.DrawTransport((Graphics2D) g);
    }

}

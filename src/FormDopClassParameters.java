import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FormDopClassParameters {
    private JButton ButtonGenerationRandomUsta;
    private JPanel pictureBoxGenerated;
    Random rnd;
    DrawingUsta drawingUsta;
    DopClassParameters<EntityUsta, IDrawingWheels> _dopClassParameters;

    public JPanel getPictureBoxGenerated() {
        return pictureBoxGenerated;
    }

    public FormDopClassParameters() {
        pictureBoxGenerated.setPreferredSize(new Dimension(400, 300));
        _dopClassParameters = new DopClassParameters<>(
                10,
                pictureBoxGenerated.getWidth(),
                pictureBoxGenerated.getHeight()
        );

        ButtonGenerationRandomUsta.addActionListener(e -> {
            AddEntityUsta();
            AddRandomWheels();

            drawingUsta = _dopClassParameters.RandomUsta(
                    pictureBoxGenerated.getWidth(),
                    pictureBoxGenerated.getHeight()
            );
            drawingUsta.SetPosition(rnd.nextInt(10, 100), rnd.nextInt(10, 100));
            Draw();
        });
    }

    public void AddEntityUsta() {
        rnd = new Random();
        EntityUsta entityUsta;
        Color color = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        Color color2 = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        if (rnd.nextBoolean()) {
            entityUsta = new EntityUsta(
                    rnd.nextInt(100, 300),
                    rnd.nextInt(1000, 3000),
                    color
            );
        } else {
            entityUsta = new EntityUstaBat(
                    rnd.nextInt(100, 300),
                    rnd.nextInt(1000, 3000),
                    color,
                    color2,
                    rnd.nextBoolean(),
                    rnd.nextBoolean()
            );
        }
        _dopClassParameters.Add(entityUsta);
    }

    public void AddRandomWheels() {
        rnd = new Random();
        IDrawingWheels iDrawingWheels;
        int wheelsChoice = rnd.nextInt(0, 3);
        if (wheelsChoice == 0) {
            iDrawingWheels = new DrawingWheel();
        } else if (wheelsChoice == 1) {
            iDrawingWheels = new DrawingEmptyWheels();
        } else {
            iDrawingWheels = new DrawingWheelsBlueCrom();
        }
        iDrawingWheels.SetWheelsCount(rnd.nextInt(3, 7));
        _dopClassParameters.Add(iDrawingWheels);
    }

    public void Draw() {
        if (drawingUsta.EntityUsta == null) {
            return;
        }
        Graphics g = pictureBoxGenerated.getGraphics();
        pictureBoxGenerated.paint(g);
        drawingUsta.DrawTransport((Graphics2D) g);
    }

}

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

public interface IDrawingWheels {
     void SetWheelsCount(int wheelsCount);

     WheelsCount GetWheelsCount();

     void DrawWheel(Graphics2D g2d, Color color, int x, int y, int w, int h);

     default void DrawWheels(Graphics2D g, Color color, int startPosX, int startPosY, int drawingWidth, int drawingHeight){
          WheelsCount wheelsCount = GetWheelsCount();
          if(wheelsCount == null) return;

          if (wheelsCount.count <= wheelsCount.Four.count) {


               /* наверху гусеницы*/
               g.fillOval(startPosX + 47, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 62, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 77, startPosY + 44, 13, 13);

               /* по середине гусеницы*/
               DrawWheel(g, color, startPosX + 40, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 55, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 70, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 85, startPosY + 59, 12, 12);


               /* два крайних на гусенице*/
               g.fillOval(startPosX + 10, startPosY + 50, 25, 24);
               g.fillOval(startPosX + 105, startPosY + 50, 25, 24);

          }

          if (wheelsCount.count == wheelsCount.Five.count) {


               /* наверху гусеницы*/
               g.fillOval(startPosX + 47, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 62, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 77, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 92, startPosY + 44, 13, 13);

               /* по середине гусеницы*/
               DrawWheel(g, color, startPosX + 40, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 55, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 70, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 85, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 100, startPosY + 59, 12, 12);


               /* два крайних на гусенице*/
               g.fillOval(startPosX + 10, startPosY + 50, 25, 24);
               g.fillOval(startPosX + 120, startPosY + 50, 25, 24);
          }

          if (wheelsCount.count == wheelsCount.Six.count) {


               /* наверху гусеницы*/
               g.fillOval(startPosX + 47, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 62, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 77, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 92, startPosY + 44, 13, 13);
               g.fillOval(startPosX + 107, startPosY + 44, 13, 13);

               /* по середине гусеницы*/
               DrawWheel(g, color, startPosX + 40, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 55, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 70, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 85, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 100, startPosY + 59, 12, 12);
               DrawWheel(g, color, startPosX + 115, startPosY + 59, 12, 12);


               /* два крайних на гусенице*/
               g.fillOval(startPosX + 10, startPosY + 50, 25, 24);
               g.fillOval(startPosX + 135, startPosY + 50, 25, 24);
          }
     }
}

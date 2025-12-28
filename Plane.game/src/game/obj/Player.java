
package game.obj;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;


public class Player {
    public Player(){
    this.image=new ImageIcon(getClass().getResource("/game/image/plane.png")).getImage();
    this.image_speed=new ImageIcon(getClass().getResource("/game/image/plane_speed.png")).getImage();
}
    public static final double PLAYER_SIZE=64;
    private double x;
    private double y;
    private float angle=0f;
    private final Image image ;
    private final Image image_speed;
    
    public void changeLocation(double x,double y)
    {
        this.x=x;
        this.y=y;
        
    }
    public void changeAngle ( float angle)
    {
        if(angle<0)
        {
            angle=365;
        }else if(angle>365)
        {
            angle=0;
        }
        this.angle=angle;
    }
    public void draw(Graphics2D g2)
    {
        AffineTransform oldTransform=g2.getTransform();
        g2.translate(x, y);
         AffineTransform tran=new  AffineTransform();
        tran.rotate(Math.toRadians(angle+45),PLAYER_SIZE /2,PLAYER_SIZE /2 );
        
        g2.drawImage(image, tran,null);
        g2.setTransform(oldTransform);
    }
    public double getX()
    {
        return x;
    }
     public double getY()
    {
        return y;
    }
      public float getAngle()
    {
        return angle;
    }

   
    

   
    
}

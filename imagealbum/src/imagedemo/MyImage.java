package imagedemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyImage extends JPanel{
    BufferedImage bgImage;
    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        //set size
        frame.setSize(1000,700);
        //set topic
        frame.setTitle("java image album");
        //Center display
        frame.setLocationRelativeTo(null);
        //Close the window, close the jvm
        frame.setDefaultCloseOperation(3);
        //Create panel object
        //JPanel jPanel=new JPanel();
        MyImage myImage=new MyImage();
        frame.add(myImage);
        //Call the method of initializing the picture


        frame.setVisible(true);
    }
    public  void paint(Graphics g)
    {
        if(bgImage!=null)
        {
            g.drawImage(bgImage,0,0,bgImage.getWidth(),bgImage.getHeight(),null);
        }
    }
    BufferedImage [] images=new BufferedImage[4];
    /**
     * load prepared photos
     */
    public  void initImgs() throws IOException
    {
            try {
                for(int i=1;i<=4;i++) {
                    BufferedImage image = ImageIO.read(MyImage.class.getResource("/images/bg" + i + ".png"));
                    images[i - 1] = image;
                }
                bgImage=images[0];
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}



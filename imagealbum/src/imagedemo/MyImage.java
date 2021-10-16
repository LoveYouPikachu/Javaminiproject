package imagedemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyImage extends JPanel{
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
        frame.setVisible(true);
    }
    BufferedImage [] images=new BufferedImage[4];
    /**
     * load prepared photos
     */
    public void initImgs() throws IOException {
        for(int i=1;i<=4;i++)
        {
            try {
                BufferedImage image= ImageIO.read(MyImage.class.getResource("/images/bg"+i+",png"));
                images[i-1]=image;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

    PImage imgBackground;
    PImage imgCookie;
    PImage imgNugget;
    float fltCookieX = 120;
    float fltCookieY = 120;
    boolean wPressed = false;
    boolean aPressed = false;
    boolean sPressed = false;
    boolean dPressed = false;
    boolean oPressed = false;

    public void settings() {
        size(700, 400);
    }

    public void setup() {
        imgBackground = loadImage("kitchen.jpg");
        imgBackground.resize(700, 400);

        imgCookie = loadImage("cookie.png");
        imgCookie.resize(imgCookie.width / 4, imgCookie.height / 4);

        imgNugget = loadImage("Nugget.png");
        imgNugget.resize(imgNugget.width / 10, imgNugget.height / 10);
    }

    public void draw() {
        movement();
        image(imgBackground, 0, 0);
        image(imgCookie, fltCookieX, fltCookieY);

        if (mousePressed) {
            image(imgNugget, mouseX, mouseY);

            // Finds the x values for flowers
            for (int intX = 250; intX < 500; intX += 200) {

                // Finds the y values for flowers
                for (int intY = 150; intY < 450; intY += 300) {

                    if (colourSwap(true)) {
                        // Generates flower colors if mouse pressed
                        drawFlower(intX, intY, (intX / 5) + (intY / 2), (intX / 4) + (intY / 9), (intX / 10) + (intY / 8));
                    }
                }
            }
        }

        if (oPressed) {
            // Random Size for the Square Between 50 and 100
            float squareSize = random(50, 100);

            // Random Colour for square
            int squareColor = color(random(255), random(255), random(255));

            // Square Colour
            fill(squareColor);

            // Random Size for square
            float x = mouseX - squareSize / 2;
            float y = mouseY - squareSize / 2;
            rect(x, y, squareSize, squareSize);
            
        }
    }

    public void keyPressed() {
        if (key == 'w' || keyCode == UP) {
            wPressed = true;
        } else if (key == 'a' || keyCode == LEFT) {
            aPressed = true;
        } else if (key == 's' || keyCode == DOWN) {
            sPressed = true;
        } else if (key == 'd' || keyCode == RIGHT) {
            dPressed = true;
        } else if (key == 'o' || key == 'O') {
            oPressed = true;
        }
    }

    public void keyReleased() {
        if (key == 'w' || keyCode == UP) {
            wPressed = false;
        } else if (key == 'a' || keyCode == LEFT) {
            aPressed = false;
        } else if (key == 's' || keyCode == DOWN) {
            sPressed = false;
        } else if (key == 'd' || keyCode == RIGHT) {
            dPressed = false;
        }
          else if (key == 'o')
            oPressed = false;
    }

    public void movement() {
        if (wPressed)
      fltCookieY -= 5;
    fltCookieY = Math.max(0, fltCookieY);

    if (aPressed)
      fltCookieX -= 5;
    fltCookieY = Math.max(0, fltCookieY);

    if (sPressed)
      fltCookieY += 5;
      fltCookieY = Math.min(height, fltCookieY);

    if (dPressed)
      fltCookieX += 5;
    fltCookieY = Math.min(height, fltCookieY);
    }

    public void mouseDragged() {
        image(imgNugget, mouseX, mouseY);
    }

    public void drawFlower(int intFlowerX, int intFlowerY, int intRed, int intGreen, int intBlue) {
        fill(intRed, intGreen, intBlue);
        ellipse(intFlowerX, intFlowerY - 5, 55, 55);
        ellipse(intFlowerX + 30, intFlowerY - 40, 55, 55);
        ellipse(intFlowerX - 30, intFlowerY - 40, 55, 55);
        ellipse(intFlowerX, intFlowerY - 75, 55, 55);
        stroke(256);
    }

    public boolean colourSwap(boolean MousePressed) {
        return MousePressed;
    }
}
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture. This class inherits from SimplePicture and allows the student
 * to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture() {
    /*
     * not needed but use it to show students the implicit call to super() child constructors always
     * call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName) {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * 
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width) {
    // let the parent class handle this width and height
    super(width, height);
  }

  /**
   * Constructor that takes a picture and creates a copy of that picture
   * 
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture) {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * 
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image) {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * 
   * @return a string with information about the picture such as fileName, height and width.
   */
  @Override
  public String toString() {
    String output =
        "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method to set all but blue to 0 */
  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }

  /** Method to negate colours */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }

  /** Method to make grayscale */
  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
        pixelObj.setRed(average);
        pixelObj.setGreen(average);
        pixelObj.setBlue(average);
      }
    }
  }

  /** Method to fix underwater */
  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(pixelObj.getRed() * 2);
        pixelObj.setBlue(pixelObj.getBlue() / 2);
        pixelObj.setGreen(pixelObj.getGreen() / 2);
      }
    }
  }

  /**
   * Method that mirrors the picture around a vertical mirror in the center of the picture from left
   * to right
   */
  public void mirrorVertical() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /**
   * Method that mirrors the picture around a vertical mirror in the center of the picture from
   * right to left
   */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  /**
   * Method that mirrors the picture around a horizontal mirror in the center of the picture from
   * top to bottom
   */
  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[height - 1 - row][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
  }

  /**
   * Method that mirrors the picture around a horizontal mirror in the center of the picture from
   * bottom to top
   */
  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[height - 1 - row][col];
        topPixel.setColor(botPixel.getColor());
      }
    }
  }

  /**
   * Method that mirrors the picture around a diagonal mirror in the center of the picture from
   * bottom left to top right
   */
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel botLeftPixel = null;
    Pixel topRightPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < row; col++) {
        botLeftPixel = pixels[row][col];
        topRightPixel = pixels[col][row];
        topRightPixel.setColor(botLeftPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++) {
        count++;
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  /** Mirror just part of a picture of a snowman */
  public void mirrorArms() {
    int mirrorPoint = 195;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 163; row < mirrorPoint; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 100; col < 295; col++) {
        topPixel = pixels[row][col];
        botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a seagull */
  public void mirrorGull() {
    int mirrorPoint = 350;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 230; row < 330; row++) {
      // loop from 13 to just before the mirror point
      for (int col = 235; col < mirrorPoint; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /**
   * copy from the passed fromPic to the specified startRow and startCol in the current picture
   * 
   * @param fromPic the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copy(Picture fromPic, int startRow, int startCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
        && toRow < toPixels.length; fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
          && toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /**
   * copy from the passed fromPic to the specified startRow and startCol to endRow and endCol in the
   * current picture
   * 
   * @param fromPic the picture to copy from
   * @param fromStartRow the start row to copy to
   * @param fromStartCol the start col to copy to
   */
  public void copy(Picture fromPic, int toStartRow, int toStartCol, int fromStartRow,
      int fromEndRow, int fromStartCol, int fromEndCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fromStartRow, toRow = toStartRow; fromRow < fromEndRow
        && toRow < toPixels.length; fromRow++, toRow++) {
      for (int fromCol = fromStartCol, toCol = toStartCol; fromCol < fromEndCol
          && toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1, 0, 0);
    this.copy(flower2, 100, 0);
    this.copy(flower1, 200, 0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue, 300, 0);
    this.copy(flower1, 400, 0);
    this.copy(flower2, 500, 0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  /** Method to create my collage of several pictures */
  public void myCollage() {
    Picture kitten = new Picture("kitten2.jpg");
    this.copy(kitten, 0, 0, 140, 200, 130, 220);
    kitten.zeroBlue();
    this.copy(kitten, 100, 0, 140, 200, 130, 220);
    kitten.negate();
    this.copy(kitten, 200, 0, 140, 200, 130, 220);
    kitten.keepOnlyBlue();
    this.copy(kitten, 300, 0, 140, 200, 130, 220);
    this.mirrorDiagonal();
    this.mirrorVertical();
    this.mirrorHorizontal();
  }

  /**
   * Method to show large changes in color
   * 
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetection(int edgeDist) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color downColor = null;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        leftPixel = pixels[row][col];
        if (col != pixels[0].length - 1) {
          rightPixel = pixels[row][col + 1];
          rightColor = rightPixel.getColor();
        }
        if (row != pixels.length - 1) {
          downColor = pixels[row + 1][col].getColor();
        }
        if (rightColor != null && leftPixel.colorDistance(rightColor) > edgeDist
            || downColor != null && leftPixel.colorDistance(downColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }


  /*
   * Main method for testing - each class in Java can have a main method
   */
  public static void main(String[] args) {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

} // this } is the end of class Picture, put all new methods before this

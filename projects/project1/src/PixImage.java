/* PixImage.java */

/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {					// the object is the image.

  /**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */
	private int width;
	private int height;
	private Pixel[][] Pix; 		// the object is the pixel.

  /**
   * PixImage() constructs an empty PixImage with a specified width and height.
   * Every pixel has red, green, and blue intensities of zero (solid black).
   *
   * @param width the width of the image.
   * @param height the height of the image.
   */
  public PixImage(int width, int height) {
    // Your solution here.
	  this.width = width;				// "this" should not be static.
	  this.height = height;				// set width and height.
	  Pix = new Pixel[width][height];
	  for(int i = 0; i < width; i++) {
		  for(int j = 0; j < height; j++) {
			  Pix [i][j] = new Pixel();
		  }
	  }
  }
  
 
  
  /**
   * getWidth() returns the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    // Replace the following line with your solution.
    return width;
  }

  /**
   * getHeight() returns the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return height;
  }

  /**
   * getRed() returns the red intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the red intensity of the pixel at coordinate (x, y).
   */
  public short getRed(int x, int y) {
    // Replace the following line with your solution.
	  return Pix [x][y].getred();
  }

  /**
   * getGreen() returns the green intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the green intensity of the pixel at coordinate (x, y).
   */
  public short getGreen(int x, int y) {
    // Replace the following line with your solution.
	  return Pix [x][y].getgreen();
  }

  /**
   * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the blue intensity of the pixel at coordinate (x, y).
   */
  public short getBlue(int x, int y) {
    // Replace the following line with your solution.
	  return Pix [x][y].getblue();
  }

  /**
   * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
   * and blue intensities.
   *
   * If any of the three color intensities is NOT in the range 0...255, then
   * this method does NOT change any of the pixel intensities.
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @param red the new red intensity for the pixel at coordinate (x, y).
   * @param green the new green intensity for the pixel at coordinate (x, y).
   * @param blue the new blue intensity for the pixel at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here.
	  Pix [x][y].setpixel(red, green, blue);
  }

  /**
   * toString() returns a String representation of this PixImage.
   *
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent a PixImage
   * as a String.
   *
   * @return a String representation of this PixImage.
   */
  public String toString() {
    // Replace the following line with your solution.
	  String s = "----------------------------------\n";
      for (int i = 0; i < this.width; i++) {
    	  s = s + "|";
    	  for (int j = 0; j < this.height; j++) {
    		  s = s + Short.toString(Pix[i][j].getred()) + " " + Short.toString(Pix[i][j].getgreen()) + " " + Short.toString(Pix[i][j].getblue()) + "|";
    	  }
    	  s = s + "\n";
      }
      s = s + "-------------------------------------";
      return s;
  }

  /**
   * boxBlur() returns a blurred version of "this" PixImage.
   *
   * If numIterations == 1, each pixel in the output PixImage is assigned
   * a value equal to the average of its neighboring pixels in "this" PixImage,
   * INCLUDING the pixel itself.
   *
   * A pixel not on the image boundary has nine neighbors--the pixel itself and
   * the eight pixels surrounding it.  A pixel on the boundary has six
   * neighbors if it is not a corner pixel; only four neighbors if it is
   * a corner pixel.  The average of the neighbors is the sum of all the
   * neighbor pixel values (including the pixel itself) divided by the number
   * of neighbors, with non-integer quotients rounded toward zero (as Java does
   * naturally when you divide two integers).
   *
   * Each color (red, green, blue) is blurred separately.  The red input should
   * have NO effect on the green or blue outputs, etc.
   *
   * The parameter numIterations specifies a number of repeated iterations of
   * box blurring to perform.  If numIterations is zero or negative, "this"
   * PixImage is returned (not a copy).  If numIterations is positive, the
   * return value is a newly constructed PixImage.
   *
   * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
   * appear in the new, output PixImage only.
   *
   * @param numIterations the number of iterations of box blurring.
   * @return a blurred version of "this" PixImage.
   */
  
  /*
  public PixImage copy(PixImage image) {
	  PixImage Copy = new PixImage(width, height);			
      for (int i = 0; i < width; i++) {
    	  for (int j = 0; j < height; j++) {
    		  Copy.Pix [i][j] = image.Pix [i][j];				// copy the original PixImage.
    	  }
      }
      return Copy;
  }
  */
  public Pixel copyPixel(Pixel copy, Pixel original) {
	  copy.setpixel(original.getred(), original.getgreen(), original.getblue()); // we need to copy every field to copy the object!
	  return copy;
  }
  
  public PixImage boxBluronce(PixImage image) {   				// do boxBlur once.
	  PixImage Copy = new PixImage(width, height);	
	  
	  
      for (int i = 0; i < width; i++) {
    	  for (int j = 0; j < height; j++) {
    		  copyPixel(Copy.Pix [i][j], image.Pix [i][j]);
    		  } 
      }
      if (width < 2 || height < 2) {
    	  System.out.println("the PixIamge is too strange...");  // we do not consider these cases.
    	  return this;
      } 
      
      
      // neighbors = 4: 
      // red:
      Copy.Pix[0][0].setred((short)((image.Pix[0][0].getred()+image.Pix[0][1].getred()+image.Pix[1][0].getred()+image.Pix[1][1].getred())/4));
      Copy.Pix[0][height - 1].setred((short)((image.Pix[0][height - 1].getred()+image.Pix[0][height - 2].getred()+image.Pix[1][height - 1].getred()+image.Pix[1][height - 2].getred())/4));				
      Copy.Pix[width - 1][0].setred((short)((image.Pix[width - 1][0].getred()+image.Pix[width - 2][0].getred()+image.Pix[width - 1][1].getred()+image.Pix[width - 2][1].getred())/4));
      Copy.Pix[width - 1][height - 1].setred((short)((image.Pix[width - 1][height - 1].getred()+image.Pix[width - 2][height - 1].getred()+image.Pix[width - 1][height - 2].getred()+image.Pix[width - 2][height - 2].getred())/4));
      //System.out.println("testimagehere = \n" + image);
      // green:
      Copy.Pix[0][0].setgreen((short)((image.Pix[0][0].getgreen()+image.Pix[0][1].getgreen()+image.Pix[1][0].getgreen()+image.Pix[1][1].getgreen())/4));
      Copy.Pix[0][height - 1].setgreen((short)((image.Pix[0][height - 1].getgreen()+image.Pix[0][height - 2].getgreen()+image.Pix[1][height - 1].getgreen()+image.Pix[1][height - 2].getgreen())/4));				
      Copy.Pix[width - 1][0].setgreen((short)((image.Pix[width - 1][0].getgreen()+image.Pix[width - 2][0].getgreen()+image.Pix[width - 1][1].getgreen()+image.Pix[width - 2][1].getgreen())/4));
      Copy.Pix[width - 1][height - 1].setgreen((short)((image.Pix[width - 1][height - 1].getgreen()+image.Pix[width - 2][height - 1].getgreen()+image.Pix[width - 1][height - 2].getgreen()+image.Pix[width - 2][height - 2].getgreen())/4));

      // blue:
      Copy.Pix[0][0].setblue((short)((image.Pix[0][0].getblue()+image.Pix[0][1].getblue()+image.Pix[1][0].getblue()+image.Pix[1][1].getblue())/4));
      Copy.Pix[0][height - 1].setblue((short)((image.Pix[0][height - 1].getblue()+image.Pix[0][height - 2].getblue()+image.Pix[1][height - 1].getblue()+image.Pix[1][height - 2].getblue())/4));				
      Copy.Pix[width - 1][0].setblue((short)((image.Pix[width - 1][0].getblue()+image.Pix[width - 2][0].getblue()+image.Pix[width - 1][1].getblue()+image.Pix[width - 2][1].getblue())/4));
      Copy.Pix[width - 1][height - 1].setblue((short)((image.Pix[width - 1][height - 1].getblue()+image.Pix[width - 2][height - 1].getblue()+image.Pix[width - 1][height - 2].getblue()+image.Pix[width - 2][height - 2].getblue())/4));					
      

      // neighbors = 6:
      // red:
      for (int ar = 1; ar < height - 1; ar++) {
    	  Copy.Pix[0][ar].setred((short)((image.Pix[0][ar - 1].getred()+image.Pix[0][ar].getred()+image.Pix[0][ar + 1].getred()+image.Pix[1][ar - 1].getred()+image.Pix[1][ar].getred()+image.Pix[1][ar + 1].getred())/6));
    	  Copy.Pix[width - 1][ar].setred((short)((image.Pix[width - 1][ar - 1].getred()+image.Pix[width - 1][ar].getred()+image.Pix[width - 1][ar + 1].getred()+image.Pix[width - 2][ar - 1].getred()+image.Pix[width - 2][ar].getred()+image.Pix[width - 2][ar + 1].getred())/6));											
      }
      
      for ( int br = 1; br < width - 1; br++) {
    	  Copy.Pix[br][0].setred((short)((image.Pix[br - 1][0].getred()+image.Pix[br][0].getred()+image.Pix[br + 1][0].getred()+image.Pix[br - 1][1].getred()+image.Pix[br][1].getred()+image.Pix[br + 1][1].getred())/6));
    	  Copy.Pix[br][height - 1].setred((short)((image.Pix[br - 1][height - 1].getred()+image.Pix[br][height - 1].getred()+image.Pix[br + 1][height - 1].getred()+image.Pix[br - 1][height - 2].getred()+image.Pix[br][height - 2].getred()+image.Pix[br + 1][height - 2].getred())/6));
      }
      
       // green:
      for (int ag = 1; ag < height - 1; ag++) {
    	  Copy.Pix[0][ag].setgreen((short)((image.Pix[0][ag - 1].getgreen()+image.Pix[0][ag].getgreen()+image.Pix[0][ag + 1].getgreen()+image.Pix[1][ag - 1].getgreen()+image.Pix[1][ag].getgreen()+image.Pix[1][ag + 1].getgreen())/6));
    	  Copy.Pix[width - 1][ag].setgreen((short)((image.Pix[width - 1][ag - 1].getgreen()+image.Pix[width - 1][ag].getgreen()+image.Pix[width - 1][ag + 1].getgreen()+image.Pix[width - 2][ag - 1].getgreen()+image.Pix[width - 2][ag].getgreen()+image.Pix[width - 2][ag + 1].getgreen())/6));											
      }
      
      for ( int bg = 1; bg < width - 1; bg++) {
    	  Copy.Pix[bg][0].setgreen((short)((image.Pix[bg - 1][0].getgreen()+image.Pix[bg][0].getgreen()+image.Pix[bg + 1][0].getgreen()+image.Pix[bg - 1][1].getgreen()+image.Pix[bg][1].getgreen()+image.Pix[bg + 1][1].getgreen())/6));
    	  Copy.Pix[bg][height - 1].setgreen((short)((image.Pix[bg - 1][height - 1].getgreen()+image.Pix[bg][height - 1].getgreen()+image.Pix[bg + 1][height - 1].getgreen()+image.Pix[bg - 1][height - 2].getgreen()+image.Pix[bg][height - 2].getgreen()+image.Pix[bg + 1][height - 2].getgreen())/6));
      }      
      // blue:
      for (int ab = 1; ab < height - 1; ab++) {
    	  Copy.Pix[0][ab].setblue((short)((image.Pix[0][ab - 1].getblue()+image.Pix[0][ab].getblue()+image.Pix[0][ab + 1].getblue()+image.Pix[1][ab - 1].getblue()+image.Pix[1][ab].getblue()+image.Pix[1][ab + 1].getblue())/6));
    	  Copy.Pix[width - 1][ab].setblue((short)((image.Pix[width - 1][ab - 1].getblue()+image.Pix[width - 1][ab].getblue()+image.Pix[width - 1][ab + 1].getblue()+image.Pix[width - 2][ab - 1].getblue()+image.Pix[width - 2][ab].getblue()+image.Pix[width - 2][ab + 1].getblue())/6));											
      }
      
      for ( int bb = 1; bb < width - 1; bb++) {
    	  Copy.Pix[bb][0].setblue((short)((image.Pix[bb - 1][0].getblue()+image.Pix[bb][0].getblue()+image.Pix[bb + 1][0].getblue()+image.Pix[bb - 1][1].getblue()+image.Pix[bb][1].getblue()+image.Pix[bb + 1][1].getblue())/6));
    	  Copy.Pix[bb][height - 1].setblue((short)((image.Pix[bb - 1][height - 1].getblue()+image.Pix[bb][height - 1].getblue()+image.Pix[bb + 1][height - 1].getblue()+image.Pix[bb - 1][height - 2].getblue()+image.Pix[bb][height - 2].getblue()+image.Pix[bb + 1][height - 2].getblue())/6));
      }
      
      // neighbors = 9:
      for (int a = 1; a < width - 1; a++) {
    	  for (int b = 1; b < height - 1; b++) {
    		   Copy.Pix[a][b].setred((short)((image.Pix[a - 1][b - 1].getred()+image.Pix[a - 1][b].getred()+image.Pix[a - 1][b + 1].getred()+image.Pix[a][b - 1].getred()+image.Pix[a][b].getred()+image.Pix[a][b + 1].getred()+image.Pix[a + 1][b - 1].getred()+image.Pix[a + 1][b].getred()+image.Pix[a + 1][b + 1].getred())/9));	
    		   Copy.Pix[a][b].setgreen((short)((image.Pix[a - 1][b - 1].getgreen()+image.Pix[a - 1][b].getgreen()+image.Pix[a - 1][b + 1].getgreen()+image.Pix[a][b - 1].getgreen()+image.Pix[a][b].getgreen()+image.Pix[a][b + 1].getgreen()+image.Pix[a + 1][b - 1].getgreen()+image.Pix[a + 1][b].getgreen()+image.Pix[a + 1][b + 1].getgreen())/9));					
    		   Copy.Pix[a][b].setblue((short)((image.Pix[a - 1][b - 1].getblue()+image.Pix[a - 1][b].getblue()+image.Pix[a - 1][b + 1].getblue()+image.Pix[a][b - 1].getblue()+image.Pix[a][b].getblue()+image.Pix[a][b + 1].getblue()+image.Pix[a + 1][b - 1].getblue()+image.Pix[a + 1][b].getblue()+image.Pix[a + 1][b + 1].getblue())/9));
    	  }
      }
      
      
      //System.out.println("testcopy = \n" + Copy);

      return Copy;
  }
  
  public PixImage boxBlur(int numIterations) {
    // Replace the following line with your solution.
	// copy the original PixImage, then change it!
	  if (numIterations <= 0) {
		  return this;
	  }
	  PixImage temp = this;
	  for (int i = 1; i <= numIterations; i++) {
		  PixImage outputtemp = boxBluronce(temp);     		// do boxBlur once.
		  temp = outputtemp;
	  }
	  
	  return temp;
  }

  /**
   * mag2gray() maps an energy (squared vector magnitude) in the range
   * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
   * is logarithmic, but shifted so that values of 5,080 and below map to zero.
   *
   * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
   * correct images and pass the autograder.
   *
   * @param mag the energy (squared vector magnitude) of the pixel whose
   * intensity we want to compute.
   * @return the intensity of the output pixel.
   */
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

  /**
   * sobelEdges() applies the Sobel operator, identifying edges in "this"
   * image.  The Sobel operator computes a magnitude that represents how
   * strong the edge is.  We compute separate gradients for the red, blue, and
   * green components at each pixel, then sum the squares of the three
   * gradients at each pixel.   We convert the squared magnitude at each pixel
   * into a grayscale pixel intensity in the range 0...255 with the logarithmic
   * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
   * pixel intensities reflect the strength of the edges.
   *
   * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
   *
   * @return a grayscale PixImage representing the edges of the input image.
   * Whiter pixels represent stronger edges.
   */
  public PixImage reflectBoundary(PixImage large, PixImage image) {
	  for (int i = 1; i < width + 1; i++) {
		  for (int j = 1; j < height + 1; j++) {				// do the for loop in the original size.
			  copyPixel(large.Pix[i][j], image.Pix[i-1][j-1]);
			  if (i == 1) {
				  copyPixel(large.Pix[i-1][j], image.Pix[i-1][j-1]);
			  }
			  if (j == 1) {
				  copyPixel(large.Pix[i][j-1], image.Pix[i-1][j-1]);
			  }
			  if (i == width) {
				  copyPixel(large.Pix[width + 1][j], image.Pix[i-1][j-1]);
			  }
			  if (j == height) {
				  copyPixel(large.Pix[i][height + 1], image.Pix[i-1][j-1]);
			  }
		  }
	  }											// reflect the side boundary
	  // reflect the corner pixel:
	  copyPixel(large.Pix[0][0], image.Pix[0][0]);
	  copyPixel(large.Pix[0][height + 1], image.Pix[0][height-1]);
	  copyPixel(large.Pix[width + 1][0], image.Pix[width-1][0]);
	  copyPixel(large.Pix[width + 1][height + 1], image.Pix[width-1][height-1]);
	  return large;
  }
  
  public PixImage sobelEdges() {
    // Replace the following line with your solution.
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
	  PixImage large = new PixImage(width + 2,height + 2);
	  reflectBoundary(large, this);						// refelct the pixel, then calculate the gradient.
	  PixImage grad = new PixImage(width, height);		// store the output PixImage.
	  long [][] gxr = new long [width][height];			// store the gx for red.
	  long [][] gyr = new long [width][height];			// stor the gy for red.
	  long [][] gxg = new long [width][height];
	  long [][] gyg = new long [width][height];
	  long [][] gxb = new long [width][height];
	  long [][] gyb = new long [width][height];
	  //now calculate gx in red, green, blue:
	  for (int i = 1; i < width + 1; i++) {					
		  for (int j = 1; j < height + 1; j++) {
			  gxr[i-1][j-1] = 1 * (large.Pix[i-1][j-1].getred()) - 1 * (large.Pix[i+1][j-1].getred()) + 2 * (large.Pix[i-1][j].getred()) - 2 * (large.Pix[i+1][j].getred()) + 1 * (large.Pix[i-1][j+1].getred()) - 1 * (large.Pix[i+1][j+1].getred());		  
		  }
	  }
	  
	  for (int i = 1; i < width + 1; i++) {					
		  for (int j = 1; j < height + 1; j++) {
			  gxg[i-1][j-1] = 1 * (large.Pix[i-1][j-1].getgreen()) - 1 * (large.Pix[i+1][j-1].getgreen()) + 2 * (large.Pix[i-1][j].getgreen()) - 2 * (large.Pix[i+1][j].getgreen()) + 1 * (large.Pix[i-1][j+1].getgreen()) - 1 * (large.Pix[i+1][j+1].getgreen());		  
		  }
	  }
	  
	  for (int i = 1; i < width + 1; i++) {					
		  for (int j = 1; j < height + 1; j++) {
			  gxb[i-1][j-1] = 1 * (large.Pix[i-1][j-1].getblue()) - 1 * (large.Pix[i+1][j-1].getblue()) + 2 * (large.Pix[i-1][j].getblue()) - 2 * (large.Pix[i+1][j].getblue()) + 1 * (large.Pix[i-1][j+1].getblue()) - 1 * (large.Pix[i+1][j+1].getblue());		  
		  }
	  }
	//now calculate gy in red, green, blue:
	  for (int i = 1; i < width + 1; i++) {					
		  for (int j = 1; j < height + 1; j++) {
			  gyr[i-1][j-1] = 1 * (large.Pix[i-1][j-1].getred()) + 2 * (large.Pix[i][j-1].getred()) + 1 * (large.Pix[i+1][j-1].getred()) - 1 *(large.Pix[i-1][j+1].getred()) - 2 * (large.Pix[i][j+1].getred()) - 1 * (large.Pix[i+1][j+1].getred());		  
		  }
	  }
	  
	  for (int i = 1; i < width + 1; i++) {					
		  for (int j = 1; j < height + 1; j++) {
			  gyg[i-1][j-1] = 1 * (large.Pix[i-1][j-1].getgreen()) + 2 * (large.Pix[i][j-1].getgreen()) + 1 * (large.Pix[i+1][j-1].getgreen()) - 1 *(large.Pix[i-1][j+1].getgreen()) - 2 * (large.Pix[i][j+1].getgreen()) - 1 * (large.Pix[i+1][j+1].getgreen());		  
		  }
	  }
	  
	  for (int i = 1; i < width + 1; i++) {					
		  for (int j = 1; j < height + 1; j++) {
			  gyb[i-1][j-1] = 1 * (large.Pix[i-1][j-1].getblue()) + 2 * (large.Pix[i][j-1].getblue()) + 1 * (large.Pix[i+1][j-1].getblue()) - 1 *(large.Pix[i-1][j+1].getblue()) - 2 * (large.Pix[i][j+1].getblue()) - 1 * (large.Pix[i+1][j+1].getblue());		  
		  }
	  }
	  // now calculate the energy;
	  long [][] energy = new long [width][height];
	  short [][] I = new short [width][height];			// flatten the energy to a grayscale intensity.
	  for (int p = 0; p < width; p++) {
		  for (int q = 0; q < height; q++) {
			  energy[p][q] = (gxr[p][q]) * (gxr[p][q]) + (gyr[p][q]) * (gyr[p][q]) + (gxg[p][q]) * (gxg[p][q]) + (gyg[p][q]) * (gyg[p][q]) + (gxb[p][q]) * (gxb[p][q]) + (gyb[p][q]) * (gyb[p][q]);
			  I[p][q] = mag2gray(energy[p][q]);
			  grad.Pix[p][q].setpixel(I[p][q], I[p][q], I[p][q]);
		  }
	  }
	  return grad;
  }


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * equals() checks whether two images are the same, i.e. have the same
   * dimensions and pixels.
   *
   * @param image a PixImage to compare with "this" PixImage.
   * @return true if the specified PixImage is identical to "this" PixImage.
   */
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main() runs a series of tests to ensure that the convolutions (box blur
   * and Sobel) are correct.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");
    System.out.print(image1);
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 3x3 image.");
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
    
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })),
           "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");
    System.out.print(image2);
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals(
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
  
  }
}

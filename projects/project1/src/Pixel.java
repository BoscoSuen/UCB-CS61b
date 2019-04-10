/*Pixel.java*/

public class Pixel {
	private short red;
	private short green;
	private short blue;
	
	public Pixel() {			// no-arg constructor.
		red = 0;
		green = 0;
		blue = 0;
	}
	
	public short getred() {
		return red;
	}
	
	public short getgreen() {
		return green;
	}
	
	public short getblue() {
		return blue;
	}
	public void setpixel(short red, short green, short blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void setred(short red) {
		this.red = red;
	}
	
	public void setgreen(short green) {
		this.green = green;
	}
	
	public void setblue(short blue) {
		this.blue = blue;
	}
}

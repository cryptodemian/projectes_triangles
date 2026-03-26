/*
 * Triangles.java 14 Oct 2022
 *
 *
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package triangles;
import java.util.Scanner;
public class Triangles {
	public static final byte DECIMALS = 4;
	public static final String SCALENE = "SCALENE";
	public static final String ISOSCELES = "ISOSCELES";
	public static final String EQUILATERAL = "EQUILATERAL";
	public static final String ACUTE = "ACUTE-ANGLED";
	public static final String RIGHT = "RIGHT-ANGLED";
	public static final String OBTUSE = "OBTUSE-ANGLED";
	public static final String ERROR = "ERROR";
	public static Scanner scanner = new Scanner(System.in);
 /**
 * Determines if 3 segments form a triangle.
 *
 * @param a the length of a segment.
 * @param b the length of a segment.
 * @param c the length of a segment.
 * @return true if -a-, -b- and -c- form a triangle, false otherwise.
 */
 public boolean isTriangle(double a, double b, double c) {
	 return a + b > c && a + c > b && b + c > a;
 }
 /**
 * Returns the type of triangle:
 * "Equilateral": triangle with 3 equal sides
 * "Isosceles": triangle with two equals sides "Scalene": triangle with three
 * diferent sides
 *
 * @param a the length of a segment.
 * @param b the length of a segment.
 * @param c the length of a segment.
 * @return "Equilateral", "Isosceles" or "Scalene" or "ERROR" otherwise.
 */
 public String typeOfTriangle(double a, double b, double c) {
	 String tot; // Type of triangle
	 if (!isTriangle(a, b, c)) {
		 tot = ERROR;
	 } else if (a == b && a == c) {
		 tot = EQUILATERAL;
	 } else if (a == b || a == c || b == c) {
		 tot = ISOSCELES;
	 } else {
		 tot = SCALENE;
	 }
	 return tot;
 }
 /**
 * Returns the area of a triangle.
 *
 * @param a the length of a segment.
 * @param b the length of a segment.
 * @param c the length of a segment.
 * @return the area of the triangle, or -1 in case it is not a triangle
 */
 public double area(double a, double b, double c) {
	 double result = 0;
	 switch (typeOfTriangle(a, b, c).toUpperCase()) {
	 case EQUILATERAL:
		 result = Math.sqrt(3) * Math.pow(a, 2) / 4;
		 break;
	 case ISOSCELES:
		 if (a == b)
			 result = c * Math.sqrt(Math.pow(a, 2) - Math.pow(c, 2) / 4) / 2;
		 else if (a == c)
			 result = b * Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2) / 4) / 2;
		 else // b == c
			 result = a * Math.sqrt(Math.pow(b, 2) - Math.pow(a, 2) / 4) / 2;
		 break;
	 case SCALENE:
		 double s = (a + b + c) / 2;
		 result = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		 break;
	 case ERROR:
		 result = -1;
		 break;
	 default:
		 result = -1;
	 }
	 return result;
 }
 public double round(double num, byte dec) {
	 return Math.round(num * Math.pow(10, dec)) / Math.pow(10, dec);
 }
 public double perimetre() {
	 return a + b;
	 //123
 }
}
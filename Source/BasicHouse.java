
import java.awt.Color;
import java.awt.Graphics2D;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : TenantTerror
//  @ File Name : BasicHouse.java
//  @ Date : 11/11/2014
//  @ Author : Serhat CAN
//
//

public class BasicHouse extends House {
	public BasicHouse(Simulation sim) {
		super(sim);
	}

	public boolean act(House house) {
		return true; // bak
	}

	@Override
	public void draw(Graphics2D g2d) {

		Graphics2D ga = (Graphics2D) g2d;
		ga.setPaint(Color.red);
		ga.fillRect((int) x, (int) y, DO.radius, DO.radius);

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		g2d.setPaint(Color.WHITE);

		dObject.drawCenteredText(g2d, (int) x, (int) y, Integer.toString(price));

	}

	@Override
	public void step(double deltaTime) {
		// TODO Auto-generated method stub
	}
}

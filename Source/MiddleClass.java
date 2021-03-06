
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : TenantTerror
//  @ File Name : MiddleClass.java
//  @ Date : 11/11/2014
//  @ Author : Serhat CAN
//
//

public class MiddleClass extends BrokerDecorator {
	public MiddleClass(Broker component) {
		super(component);

		this.component = component;
		x = component.x;
		y = component.y;
		speed = component.speed;
		strategy = component.strategy;
		setHouses(component.getHouses());
		money = component.money;
	}

	public boolean act(House house) {
		return true;
	}

	@Override
	public void draw(Graphics2D g2d) {
		component.x = x;
		component.y = y;
		component.speed = speed;
		component.setHouses(houses);
		component.money = money;

		component.draw(g2d);

		g2d.setColor(Color.GREEN);

		g2d.setStroke(new BasicStroke(DO.stroke));
		g2d.drawOval((int) component.x - 4, (int) component.y - 4,
				DO.radius + 8, DO.radius + 8);
	}

	@Override
	public void step(double deltaTime) {
		strategy.step(this, deltaTime);

	}
}

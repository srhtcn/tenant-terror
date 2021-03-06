
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : TenantTerror
//  @ File Name : Broker.java
//  @ Date : 11/11/2014
//  @ Author : Serhat CAN
//

/*
 Brokers are persisting in the map, they have a pre-dened maximum number. (Say, 10)
 They will go from house to house, trying to reach a house before a student. In such case, the rental
 price of house will be doubled and the extra will be added to Broker's money when the house is
 rented. Brokers will also have 2 types of movements: randomMove and closestFirst. The brokers
 will be represented by filled cyan circles that will be decorated according to their money.

 */

public abstract class Broker extends Entity {
	protected int money;

	protected List<House> houses;

	public Broker(Strategy strategy, Simulation sim) {
		super(strategy, sim);

		money = 0;
	}

	public void step(double deltaTime) {
		strategy.step(this, deltaTime);
	};

	// think about what a broker will do if it cross a house on the way!!!
	public boolean act(House house) {

		try {

			if (!house.isRented() && house.isFromOwner()) {

				house.setFromOwner(false);
				house.setBroker(this);
				house.setPrice(house.getPrice() * 2);
				// houses.add(house);

				return true;
			}

			return false;
		} catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {

		Graphics2D ga = (Graphics2D) g2d;
		ga.setPaint(Color.CYAN);
		ga.fillOval((int) x, (int) y, DO.radius, DO.radius);

		// ------------------------------------------------------------------------

		g2d.setPaint(Color.BLACK);

		dObject.drawCenteredText(g2d, (int) x, (int) y, Integer.toString(money));

	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

}

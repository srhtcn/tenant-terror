
import java.util.List;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : TenantTerror
//  @ File Name : ClosestFirst.java
//  @ Date : 11/11/2014
//  @ Author : Serhat CAN
//
//

public class ClosestFirst extends Strategy {

	Entity closest;

	Simulation s;
	DO dObject;

	public double scanRadius; // will be random
	public double direction;

	public double searchX, search_X, searchY, search_Y;

	public double targetX;
	public double targetY;

	public ClosestFirst(Simulation simulation) {
		isFinished = false;
		closest = null;
		dObject = new DO();
		s = simulation;
		scanRadius = 80;

		randomXandY();
	}

	@Override
	public void step(Entity e, double deltaTime) {
		List<Entity> temp = s.entities;

		searchX = e.x + scanRadius;
		search_X = e.x - scanRadius;
		searchY = e.y + scanRadius;
		search_Y = e.y - scanRadius;

		// if there is no closest target defined, find one in your redius or get
		// a random target
		if (closest == null) {
			for (Entity en : temp) {

				if (en instanceof House) {
					if ((en.x <= searchX && en.x >= search_X)
							&& (en.y <= searchY && en.y >= search_Y)) {
						targetX = en.x;
						targetY = en.y;
						closest = en;
					}

				}
			}

		}

		// target is known

		double deltaX = targetX - e.x;
		double deltaY = targetY - e.y;

		double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

		double stepX = (deltaX / distance) * e.speed * deltaTime;
		double stepY = (deltaY / distance) * e.speed * deltaTime;

		if (distance < e.speed) {
			stepX = deltaX;
			stepY = deltaY;

		}

		e.x += stepX;
		e.y += stepY;

		// check for correct place and do your job cause you found a house
		if (distance == 0.0) {

			House hous = (House) closest;

			if (hous != null) {

				// just act
				if (e.act(hous))
					isFinished = true;

			}
			randomXandY();
		}

	}

	private void randomXandY() {
		targetX = dObject.randomXInGridArea();
		targetY = dObject.randomYInGridArea();
	}
}
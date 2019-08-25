package domain;

import java.math.BigDecimal;

public class Personal {
	private final double height;
	private final double weight;
	private final Integer age;
	private final Integer activitity;
	private final Integer goal;
	private final double basalMetabolism;
	
	
	public Personal(double height, double weight, Integer age, Integer activitity, Integer goal) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.activitity = activitity;
		this.goal = goal;
		this.basalMetabolism = makeBasalMetabolism(this.height,this.weight,this.age);
	}
	
	
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getActivitity() {
		return activitity;
	}
	public Integer getGoal() {
		return goal;
	}
	public BigDecimal getBasalMetabolism() {
		return this.toValue(this.basalMetabolism);
	}
	
	
	public BigDecimal getCostCaloriesPerDay() {
		// TODO enumなど利用して動的にしたい
		//０⇒１．２、１⇒１．６、２⇒１．７
		double act = 0;
		if (Integer.valueOf(0).equals(this.activitity))	act = 1.2;
		if (Integer.valueOf(1).equals(this.activitity))	act = 1.6;
		if (Integer.valueOf(2).equals(this.activitity))	act = 1.7;

		double c = this.basalMetabolism * act;
		return this.toValue(c);
	}
	
	private double makeBasalMetabolism(double height, double weiht, Integer age) {
		return 10d * weight + 6.25d * height - 5d * age + 5d;
	}
	
	private BigDecimal toValue(double v) {
		return BigDecimal.valueOf(v).setScale(1, BigDecimal.ROUND_HALF_UP);
	}
	
	
}

package com.muscle.domain;

import java.math.BigDecimal;

public class Personal {
	private final double height;
	private final double weight;
	private final Integer age;
	private final Activitity activitity;
	private final Integer goal;
	private final Sex sex;
	
	public Personal(double height, double weight, Sex sex,Integer age, Activitity activitity, Integer goal) {
		super();
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.age = age;
		this.activitity = activitity;
		this.goal = goal;
	}
	
	public enum Sex {
		Man, Woman;
	}

	public enum Activitity {
		High(1.7d), Normal(1.6d), Low(1.2d);
		private final double value;

		private Activitity(final double value) {
			this.value = value;
		}

		public double getValue() {
			return value;
		}
	}
	
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public Sex getSex() {
		return sex;
	}
	public Integer getAge() {
		return age;
	}
	public Activitity getActivitity() {
		return activitity;
	}
	public Integer getGoal() {
		return goal;
	}

	// 1日当たりの消費カロリー
	public BigDecimal getCostCaloriesPerDay() {
		double c = this.makeBasalMetabolism() * this.activitity.getValue();
		return this.toValue(c);
	}
	
	// 基礎代謝
	public BigDecimal getBasalMetabolism() {
		return this.toValue(makeBasalMetabolism());
	}
	private double makeBasalMetabolism() {
		if (Sex.Man.equals(this.sex))
			return 10d * this.weight + 6.25d * this.height - 5d * this.age + 5d;
		if (Sex.Woman.equals(this.sex))
			return 10d * this.weight + 6.25d * this.height - 5d * this.age - 161;
		throw new IllegalArgumentException("性別の指定が男と女以外になっています");
	}
	
	private BigDecimal toValue(double v) {
		return BigDecimal.valueOf(v).setScale(1, BigDecimal.ROUND_HALF_UP);
	}
	
	
}

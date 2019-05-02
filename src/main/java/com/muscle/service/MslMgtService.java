package com.muscle.service;

public class MslMgtService{
	private final double height;
	private final double weight;
	private final Integer age;
	private final double basicMetabolism;
	
	public MslMgtService(double height, double weight, Integer age) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.basicMetabolism = createBasicMetabolism();
	}
	
	/**
	 * マクロ計算について
	 * https://dietgenius.jp/macro-nutrient-calculator/
	 * @return
	 */
	private double createBasicMetabolism() {
		return 10 * weight + 6.25 * height - 5 * age + 5;
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

	public double getBasicMetabolism() {
		return basicMetabolism;
	}
	
	public String getBasicMetabolismFormat() {
		return String.format("%.2f", this.basicMetabolism);
	}
	
	
}

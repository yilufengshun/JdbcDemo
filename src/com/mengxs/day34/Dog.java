package com.mengxs.day34;
//shitiliei
public class Dog {	
		private int id;
		private String name;
		private int health;
		private int love;
		@Override
		public String toString() {
			return "Dog [id=" + id + ", name=" + name + ", health=" + health + ", love=" + love + ", strain=" + strain
					+ "]";
		}
		public Dog(int id, String name, int health, int love, String strain) {
			super();
			this.id = id;
			this.name = name;
			this.health = health;
			this.love = love;
			this.strain = strain;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getHealth() {
			return health;
		}
		public void setHealth(int health) {
			this.health = health;
		}
		public int getLove() {
			return love;
		}
		public void setLove(int love) {
			this.love = love;
		}
		public String getStrain() {
			return strain;
		}
		public void setStrain(String strain) {
			this.strain = strain;
		}
		private String strain;
}

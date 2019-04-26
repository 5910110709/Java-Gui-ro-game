public class Novice extends GameCharacter {
	private int experience;
	private int level;
	private int manaPoint;

	private final int maxLevel;

	private int[] levelUpExperiences = {0, 10, 28, 56, 96, 187, 338, 543, 811, 1151};

	//private Bag bag;


	public Novice(String name){
		super(name);

		experience = 0;
		level = 0;
		healthPoint = 100;
		manaPoint = 100;
		damagePoint = 10;

		maxLevel = 70;
		maxHealthPoint = 100;
		maxManaPoint = 100;
		
		//bag = new Bag();
		
	}

	public int getExperience(){
		return experience;
	}
	
	public int getLevel(){
		return level;
	}
	public int getMaxLevel(){
		return maxLevel;
	}

	public int getHealthPoint(){
		return healthPoint;
	}

	public int getMaxHealthPoint(){
		return healthPoint;
	}
	public int getManaPoint(){
		return manaPoint;
	}

	private void levelUp(){
		for(int i = levelUpExperiences.length;
				i>0;
				--i)
			if(experience > levelUpExperiences[i])
				level = i;
	}

	public void gianExperience(int experience){
		this.experience += experience;
		levelUp();
	}

/*	public void keepItem(Item item){
		bag.addItem(item);
	} */

	public void print(){
		super.print();
		System.out.println("Level: " + level);
		System.out.println("Experience: " + experience);
		//bag.print();
		
	}
	public String status(){
		if(maxHealthPoint <=50){
			return "Warnnig";

		}
		else if(maxHealthPoint >=90){
			return "Good";

		}
		else if(maxHealthPoint <=25){
			return "Danger";
		}
		else if(maxHealthPoint <=70){
			return "Normal";
		}
		return "Death";


	}
}

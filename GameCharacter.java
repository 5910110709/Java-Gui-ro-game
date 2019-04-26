public class GameCharacter {
	private String name;
	protected int healthPoint;
	protected int manaPoint;
	protected int damagePoint;

	protected int maxHealthPoint;
	protected int maxManaPoint;

	public GameCharacter(String name){
		this.name = name;

		healthPoint = 0;
		manaPoint = 0;
		damagePoint = 0;

		maxHealthPoint = 0;
		maxManaPoint = 0;
		
	}

	public String getName(){
		return name;
	}

	public boolean isDead(){
		if(healthPoint == 0)
			return true;
		return false;
	}

	public int getHealthPoint(){
		return healthPoint;
	}

	public int getManaPoint(){
		return manaPoint;
	}

	public int getDamagePoint(){
		return damagePoint;
	}

	public int getMaxHealthPoint(){
		return healthPoint;
	}


	public void damage(int healthPoint){
		this.healthPoint -= healthPoint;
		if(this.healthPoint < 0)
			this.healthPoint = 0;
	}	

	public void attack(GameCharacter enemy){
		enemy.damage(damagePoint);
	}


	public void print(){
		System.out.println("Name: " + name);
		System.out.println("Health Point: " + healthPoint);
		System.out.println("Mana Point: " + manaPoint);
	}
}

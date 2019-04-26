public class Monster extends GameCharacter {
	private int healthPoint;
	private int manaPoint;
	private int damagePoint;
	public Monster(String name, int healthPoint, int manaPoint, int damagePoint) {
		super(name);
		this.healthPoint = healthPoint;
		this.manaPoint = manaPoint;
		this.damagePoint = damagePoint;
	}

	public void print(){
		System.out.print("Monster ");
		super.print();
	}
	public String getName(){
		return super.getName();
	}
	public int getHealthPoint(){
		return this.healthPoint;
	}
	public int getDamagePoint(){
		return this.damagePoint;
	}
	public int getMana(){
		return this.manaPoint;
	}
}

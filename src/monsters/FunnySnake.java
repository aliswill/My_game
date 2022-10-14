package monsters;

public class FunnySnake extends Monster{

	public FunnySnake(){
		super();
		this.monster_name="頑皮蛇";
		this.alive_yn=true;
		this.life = 12;
		this.atk = 10;
		this.def = 6;
		this.dex = 14;
		this.magic = 10;
		this.exp = 11;
		this.crit = 0.15;
		this.atk_style="毒液";
	}
	
	public int magic_atk(int hero_life) {
		if(this.magic>=5) {
			this.magic-=5;
			return (int) (hero_life*0.15);
		}else {
			return 0;
		}
		
	}; 
}

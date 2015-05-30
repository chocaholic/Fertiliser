package ie.woden.GameWorld;

public class GameWorld {
	
	private float runTime = 0;
	private int midPointY;
	private GameRenderer renderer;
	
	public GameWorld(int midPointY){
		this.midPointY = midPointY;
	}
	
	public void update(float delta){
		runTime += delta;
	}

	public void setRenderer(GameRenderer renderer) {
		// TODO Auto-generated method stub
		
	}

	public int getMidPointY() {
		// TODO Auto-generated method stub
		return 0;
	}
}

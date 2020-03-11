import java.awt.Graphics;

public abstract class AppObject {
	
	protected int x, y;
	protected ID id;
	
	public AppObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
}

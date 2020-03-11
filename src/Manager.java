import java.awt.Graphics;
import java.util.LinkedList;


public class Manager {

	LinkedList<AppObject> object = new LinkedList<AppObject>();
	//LinkedList<Hour> godzina = new LinkedList<Hour>();
	

	
	public void tick() {
		
		//System.out.println(godzina.size());
		
		for( int i = 0; i < object.size(); i++ ) {
			AppObject tempObj = object.get(i);
			
			tempObj.tick();
			
		}
		
		
	}
	
	public void render(Graphics g) {
		for( int i = 0; i < object.size(); i++ ) {
			AppObject tempObj = object.get(i);
			
			tempObj.render(g);
			
		}
		
	}
	
	public void addObject(AppObject object) {
		this.object.add(object);
		
	}
	
	public void removeObject(AppObject object) {
		this.object.remove(object);
		
	}
}

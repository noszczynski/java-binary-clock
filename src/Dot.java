import java.awt.Color;
import java.awt.Graphics;

public class Dot extends AppObject {

	private boolean show;
	private Color color;
	private int power;
	private String text;
	
	public Dot(Color color, int power, int x, int y, ID id) {
		super(x, y, id);
		
		this.show = true;
		this.color = color;
		this.power = power;
		if(power != -1) 
			this.text = String.valueOf(power);
		else 
			this.text = String.valueOf("1");
	}

	
	public void tick() {
		
	}

	
	public void render(Graphics g) {
		if(power != -1) {
			if(show) 
				g.setColor(color);
			else
				g.setColor(Color.BLACK);
		}else 
			g.setColor(Color.green);
		
		g.fillRect(x, y, 64, 64);
		
		g.setColor(Color.BLACK);
		g.drawString(text, x+24, y+32);
		
	}
	
	
	
}


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.time.LocalTime;

public class BinaryClock extends Canvas implements Runnable {

	private static final long serialVersionUID = 5282422421289185269L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;
	
	private Hour hour;
	private Manager manager;
	

	public BinaryClock() {
		
		hour = new Hour();
		manager = new Manager();
		
		
		new Window(WIDTH, HEIGHT, "Binary Clock by Adam Noszczyñski", this);
		
		
			
			manager.addObject(new Dot(Color.MAGENTA, 4, 80, 24, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 3, 160, 24, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 2, 240, 24, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 1, 320, 24, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 0, 400, 24, ID.Dot));
			
			manager.addObject(new Dot(Color.MAGENTA, -1, 480, 24, ID.NumericValue));
			manager.addObject(new Dot(Color.MAGENTA, -1, 560, 24, ID.Name));
			
			
			manager.addObject(new Dot(Color.MAGENTA, 5, 0, 184, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 4, 80, 184, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 3, 160, 184, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 2, 240, 184, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 1, 320, 184, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 0, 400, 184, ID.Dot));
			
			manager.addObject(new Dot(Color.MAGENTA, -1, 480, 184, ID.NumericValue));
			manager.addObject(new Dot(Color.MAGENTA, -1, 560, 184, ID.Name));
			
			
			manager.addObject(new Dot(Color.MAGENTA, 5, 0, 344, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 4, 80, 344, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 3, 160, 344, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 2, 240, 344, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 1, 320, 344, ID.Dot));
			manager.addObject(new Dot(Color.MAGENTA, 0, 400, 344, ID.Dot));
			
			manager.addObject(new Dot(Color.MAGENTA, -1, 480, 344, ID.NumericValue));
			manager.addObject(new Dot(Color.MAGENTA, -1, 560, 344, ID.Name));
			

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if(running)
				render();
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}

	private void tick() {
		
		hour.tick();
		manager.tick();

	}

	private void render() {

		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.green);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		manager.render(g);
		
		g.dispose();
		bs.show();
	}

	

	public static void main(String[] args) {

		new BinaryClock();
		 

	}

}

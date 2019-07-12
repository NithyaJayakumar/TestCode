public class GenerateFibinocci implements Runnable {
	
	private int threshold;
	
	
	public void getFirstTerm(int i){
		
		int f0=0,f1=1,f2=1;
		boolean conditionMet = false;
		int term=1;
		
		while(!conditionMet){
			
			
			f2= f0+f1;
			term++;
			
			f0=f1;
			f1=f2;
			if(f2>=threshold){
				conditionMet=true;
				System.out.println("First Term for " + threshold + " in Fibinocci series is " + term);

			}
			
		}

	}

	@Override
	public void run() {
		this.getFirstTerm(threshold);
		
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	
}

import java.util.concurrent.ExecutionException;

public class CircularPrime {
	
	public static void main(String args[]){
		
		CircularPrimeExecutorService primeService = new CircularPrimeExecutorService();
		try {
			primeService.executeTask();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					}
	
	
}

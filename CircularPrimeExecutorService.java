import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class CircularPrimeExecutorService {
	
	private class CircularPrimeTask implements Callable<Integer> {
		private int startNumber;
		private int endNumber;
		

		CircularPrimeTask(int start, int end) {
			this.startNumber = start;
			this.endNumber = end;
//			this.counter = counter;

		}

		public Integer call() throws InterruptedException{
			Integer counter =0;
			for(int i=startNumber;i<endNumber;i++){
				
				if(isCircularPrime(Integer.toString(i))){
					counter++;
					
				}
				
			}
			System.out.println("Number of Circular prime between "+ startNumber + " and " + endNumber  + " is " + counter);
 
			return counter;
		}
		
		public  boolean isCircularPrime(String num){
			
			int length = num.length();
			
			for(int i=0;i<length;i++){
				
				int newNumber = Integer.parseInt(num.substring(i, length) + num.substring(0,i));
				
				if(!isPrime(newNumber))
					return false;
				
			}
			return true;
			
		}
		
		public  boolean isPrime(int number){
			
			for(int i=2;i<=number/2;i++){
				
				if(number%i == 0){
					return false;
				}
			}
			return true;
		}

	}

	
	public void executeTask()
			throws InterruptedException, ExecutionException {
		
		int finalCount=0;
		
		ExecutorService serviceExecutor = Executors.newFixedThreadPool(5);
		List<Callable<Integer>> task = new ArrayList<Callable<Integer>>();
		task.add(new CircularPrimeTask(2,100000));
		task.add(new CircularPrimeTask(100001,300000));
		task.add(new CircularPrimeTask(300001,600000));
		task.add(new CircularPrimeTask(600001,800000));
		task.add(new CircularPrimeTask(800001,1000000));
		List<Future<Integer>> totalCount = Collections
				.synchronizedList(new ArrayList<Future<Integer>>());
		totalCount = serviceExecutor.invokeAll(task);
		
		for (Future<Integer> circularfuture : totalCount) {
			
			if (!circularfuture.isCancelled() && circularfuture.isDone()) {
				
				finalCount = finalCount+  circularfuture.get();
			}

		}
		
		serviceExecutor.shutdown();
		System.out.println("Final count of circular prime under 1 Million is " + finalCount);
		
	}

}

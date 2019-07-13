import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class NumberChainExecutorService {
	
	private class NumberChainTask implements Callable<Integer> {
		private int startNumber;
		private int endNumber;
		

		NumberChainTask(int start, int end) {
			this.startNumber = start;
			this.endNumber = end;


		}

		public Integer call() throws InterruptedException{
			Integer totalCount =0;
			int sum=0,tempResult=0;
			for(int i=startNumber;i<=endNumber;i++){
				System.out.print(i + "=>");
				sum=0;
				tempResult=i;
				
				while(sum !=1 && sum!=89)
				{ 
					sum=sqrtandsum(tempResult);
					if(sum == 89 || sum == 1){
						if(sum==89){	
							totalCount++;
							System.out.println(sum);
							
						}
						break;
					}else{
						tempResult=sum;
						System.out.print(sum + "=>");
					}
					
				}
				
				
			}
			 
			return totalCount;
		}
		
		public int sqrtandsum(int n){
			int sum=0;
			
			while (n != 0) {
				sum = (int) (sum + Math.pow(n % 10,2)); 
				n = n/10;
				
			}
			return sum;
			
		}
		
		
	}

	
	public void executeTask()
			throws InterruptedException, ExecutionException {
		
		int finalTotalCount=0;
		ExecutorService serviceExecutor=Executors.newFixedThreadPool(5);
		try{
			serviceExecutor = Executors.newFixedThreadPool(6);
			List<Callable<Integer>> task = new ArrayList<Callable<Integer>>();
			task.add(new NumberChainTask(1,100000));
			task.add(new NumberChainTask(100001,300000));
			task.add(new NumberChainTask(300001,600000));
			task.add(new NumberChainTask(600001,800000));
			task.add(new NumberChainTask(800001,1000000));
			task.add(new NumberChainTask(1000001,10000000));
			List<Future<Integer>> totalCount = Collections
					.synchronizedList(new ArrayList<Future<Integer>>());
			totalCount = serviceExecutor.invokeAll(task);
			
			for (Future<Integer> circularfuture : totalCount) {
				
				if (!circularfuture.isCancelled() && circularfuture.isDone()) {
					
					System.out.println("total count @each task:" + circularfuture.get());
					
					finalTotalCount = finalTotalCount +  circularfuture.get();
					System.out.println("finaltotalcount:" + finalTotalCount);
				}
	
			}
			
			serviceExecutor.shutdown();
			System.out.println("Final total count of number chain that ends at 89 under 1 Million is " + finalTotalCount);
		}catch(Exception e){
			throw e;
		}finally{
			serviceExecutor.shutdown();
		}
	
	}
}

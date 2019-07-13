import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SequenceExecutorService {
	
	static ConcurrentHashMap<Integer,Integer> noofTermsMap = new ConcurrentHashMap<Integer,Integer>();
	
	private class IterativeSequenceTask implements Callable<Integer> {
		private int startNumber;
		private int endNumber;
		

		IterativeSequenceTask(int start, int end) {
			this.startNumber = start;
			this.endNumber = end;


		}

		public Integer call() throws InterruptedException{
			
			int currentOccurence=0;
					
			
			for(int i=startNumber;i<=endNumber;i++){
				currentOccurence=i;
				int ChainSize=1;
				System.out.print(currentOccurence+"=>");
					while(currentOccurence != 1){
						currentOccurence = getNextOccurence(currentOccurence);
						ChainSize++;
						if(currentOccurence == 1){
							System.out.println(currentOccurence);
							break;
						}else{
							System.out.print(currentOccurence+"=>");
						}
					}
					
					noofTermsMap.put(i,ChainSize);
				}
			
			
			Integer highestChain = Collections.max(noofTermsMap.values());
			
			noofTermsMap.forEach((k,v)->{ if(v == highestChain) System.out.print("key:" + k);});
			return highestChain;
			
		}
		
		public int getNextOccurence(int number){
			if(number%2 == 0){
				return number/2;
			}else{
				return number*3+1;
			}
		}
		
		
	}

	
	public void executeTask()
			throws InterruptedException, ExecutionException {
		
		int finalTotalCount=0;
		ExecutorService serviceExecutor=Executors.newFixedThreadPool(5);
		try{
			
			List<Callable<Integer>> task = new ArrayList<Callable<Integer>>();
			task.add(new IterativeSequenceTask(1,100));
			task.add(new IterativeSequenceTask(101,1000));
			task.add(new IterativeSequenceTask(1001,100000));
			task.add(new IterativeSequenceTask(100001,500000));
			task.add(new IterativeSequenceTask(800001,1000000));
			serviceExecutor.invokeAll(task);
			
			/*List<Future<Integer>> totalCount = Collections
					.synchronizedList(new ArrayList<Future<Integer>>());
			totalCount = serviceExecutor.invokeAll(task);
			
			for (Future<Integer> iterationfuture : totalCount) {
				
				if (!iterationfuture.isCancelled() && iterationfuture.isDone()) {
					
					System.out.println("total count @each task:" + iterationfuture.get());
					
					finalTotalCount = finalTotalCount +  iterationfuture.get();
					System.out.println("finaltotalcount:" + finalTotalCount);
				}
	
			}
			
	*/				//System.out.println("Final total count of number chain that ends at 89 under 1 Million is " + finalTotalCount);
		}catch(Exception e){
			throw e;
		}finally{
			serviceExecutor.shutdown();
		}
	
	}


}

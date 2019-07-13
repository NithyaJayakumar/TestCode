import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Code to generate sequence number that ends with 1 and identify starting number under one million which 
 * produces the longest chain
 * */
class SequenceExecutorService extends Thread{

	
	private int startValue = 1;
	private int endValue = 100;
	private  int count = 0;
	private  int sequencecount = 0;
	static ConcurrentHashMap<Integer, Integer> noofTermsMap =  new ConcurrentHashMap<Integer, Integer>(); 
	

	public SequenceExecutorService(int startValue, int endValue) {

		
		this.startValue = startValue;
		this.endValue = endValue;

	}

	public void run() {
		
		
		for (int i = startValue; i <= endValue; i++) {
			this.sequencecount = 0;
			//System.out.print(i+"->");
			System.out.println(i);
			int chainSize = getChainSize(i);
			noofTermsMap.put(i, chainSize);

		}
		
		System.out.println("Largest chain under 1 million is produced by : "+Collections.max(noofTermsMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
		
		
	}

	private int getChainSize(int n) {
		int sum = 0;
		//System.out.println("N1 : "+n);

		try {

			if(n % 2 == 0) {

				sum = n/2;

			}  else {

				sum = 3*n +1 ;

			}

			if (sum == 1) {
				System.out.println(sum);
				this.sequencecount++;
				this.count++;
				
				return this.sequencecount ;

			}
			else {
				System.out.print(sum+"->");
				this.sequencecount++;
				getChainSize(sum);
			} 


		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.sequencecount;


	}

	



}

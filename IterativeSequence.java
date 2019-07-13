import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IterativeSequence {

	public static void main(String[] args) {
		ExecutorService serviceExecutor=Executors.newFixedThreadPool(6);
		try{
		
		
		SequenceExecutorService sequenceService1 = new SequenceExecutorService(1,1000);
		serviceExecutor.execute(sequenceService1);
		SequenceExecutorService sequenceService2 = new SequenceExecutorService(1001,100000);
		serviceExecutor.execute(sequenceService2);
		SequenceExecutorService sequenceService3 = new SequenceExecutorService(100001,300000);
		serviceExecutor.execute(sequenceService3);
		SequenceExecutorService sequenceService4 = new SequenceExecutorService(300001,600000);
		serviceExecutor.execute(sequenceService4);
		SequenceExecutorService sequenceService5 = new SequenceExecutorService(600001,800000);
		serviceExecutor.execute(sequenceService5);
		SequenceExecutorService sequenceService6 = new SequenceExecutorService(800001,1000000);
		serviceExecutor.execute(sequenceService6);
		
		}catch(Exception e){
			
		}finally{
			serviceExecutor.shutdown();
		}
		
	}

	
	
	

}

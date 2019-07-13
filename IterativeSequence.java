import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class IterativeSequence {

	public static void main(String[] args) {
		
		SequenceExecutorService sequenceService = new SequenceExecutorService();
		try {
			sequenceService.executeTask();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	
	

}

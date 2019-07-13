import java.util.concurrent.ExecutionException;

public class NumberChainGenerator {

	public static void main(String[] args) {
		NumberChainExecutorService executorService = new NumberChainExecutorService();
		try {
			executorService.executeTask();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

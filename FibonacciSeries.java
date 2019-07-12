
public class FibonacciSeries {

	public static void main(String[] args) {
		GenerateFibinocci generateFibinocci = new GenerateFibinocci();
		try{
			
			generateFibinocci.setThreshold(1000);
			Thread t = new Thread(generateFibinocci);
			t.start();
		}catch(Exception e){
			System.err.println("Exception in Main" + e.getMessage());
		}
	}
	
}

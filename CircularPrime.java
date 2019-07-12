
public class CircularPrime {
	
	public static void main(String args[]){
		
				for(int i=2;i<100;i++){
					
					if(isCircularPrime(Integer.toString(i))){
						System.out.println(i + "is a circular prime");
					}
					
				}
	}
	
	public static boolean isCircularPrime(String num){
		
		int length = num.length();
		
		for(int i=0;i<length;i++){
			
			int newNumber = Integer.parseInt(num.substring(i, length) + num.substring(0,i));
			
			if(!isPrime(newNumber))
				return false;
			
		}
		return true;
		
	}
	
	public static boolean isPrime(int number){
		
		for(int i=2;i<=number/2;i++){
			
			if(number%i == 0){
				return false;
			}
		}
		return true;
	}

}

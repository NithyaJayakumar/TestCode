
public class NumberChainGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0,count=0;
		int tempResult=0;
		
		for (int i=1;i<1000;i++){
			System.out.print(i + "=>");
			sum=0;
			tempResult=i;
			
			while(sum !=1 && sum!=89)
			{ 
				sum=sqrtandsum(tempResult);
				if(sum==89){
					count++;
					System.out.println(sum);
					break;
				}else{
					tempResult=sum;
					System.out.print(sum + "=>");
				}
				
			}
		}
		System.out.println("Total count:" + count);

	}
	
	public static int sqrtandsum(int n){
		int sum=0;
		
		while (n != 0) {
			sum = (int) (sum + Math.pow(n % 10,2)); 
			n = n/10;
			
		}
		return sum;
		
	}

}

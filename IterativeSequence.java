import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IterativeSequence {

	public static void main(String[] args) {
		
		int currentOccurence=0;
		HashMap<Integer,Integer> noofTermsMap = new HashMap<Integer,Integer>();
		
		
		for(int i=1;i<=100;i++){
			currentOccurence=i;
			int ChainSize=1;
			System.out.print(currentOccurence+"=>");
				while(currentOccurence != 1){
					currentOccurence = getNextOccurence(currentOccurence);
					ChainSize++;
					if(currentOccurence == 1){
						System.out.println(currentOccurence);
					}else{
						System.out.print(currentOccurence+"=>");
					}
				}
				
				noofTermsMap.put(Integer.valueOf(i), Integer.valueOf(ChainSize));
			}
		
		System.out.println("Highest chain is formed by : " + Collections.max(noofTermsMap.values()));
		Integer highestChain = Collections.max(noofTermsMap.values());
		Integer key;
		Integer value;
		noofTermsMap.forEach((k,v)->{ if(v == highestChain) System.out.print("key:" + k);});
		
	}

	
	
	public static  int getNextOccurence(int number){
		if(number%2 == 0){
			return number/2;
		}else{
			return number*3+1;
		}
	}

}

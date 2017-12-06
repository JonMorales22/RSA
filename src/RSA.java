import java.util.*;

public class RSA
{
	private char map[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',' ', '.', ',', ';', '?'};
	public RSA_Key key;
	
	public void encrypt(String s, int p, int q)
	{
		int plain[] = mapping(s);
		List<Integer> blocks = createBlocks(plain);

		RSA_Key tempKey = new RSA_Key();
		KeyPair keyPairs[] = tempKey.generateKeys(p,q);
		
		//System.out.println(keyPairs[0]);
		for(int x=0;x<keyPairs.length;x++)
		{
			for(int i=0;i<blocks.size();i++)
			{
				int tempC = pMod(blocks.get(i), keyPairs[x].getE(), keyPairs[x].getN());
				List<Integer> cipher = new ArrayList();
				cipher.add(tempC);
				System.out.print(cipher);
			}
			System.out.println();
		}


	}
	
	private int[] mapping(String s)
	{
		int temp[]=new int[s.length()];
		for(int i=0;i<s.length();i++)
		{
			for(int x=0;x<map.length;x++)
			if(s.charAt(i) == map[x])
				temp[i]=x;
		}
		return temp;
		//tempKey.generateKey(73, 151);
		//main.printArray(tempKey.generateKey(73, 151));
	}
	
	private List<Integer> createBlocks(int p[])
	{
		List<Integer> temp = new ArrayList();
		for(int i=0;i<p.length;i++)
		{
			if((i+1)%2==0)
			{
				String s1 = ""; String s2 = "";
				
				if(p[i-1]<10)
					s1 = "0" + Integer.toString(p[i-1]);
				else
					s1=Integer.toString(p[i-1]);
				
				if(p[i]<10)
					s2 = "0" + Integer.toString(p[i]);
				else
					s2 = Integer.toString(p[i]);
 
				temp.add(Integer.valueOf(s1+s2));
			}
		}
		return temp;
	}
	
	//The PowerMod method begins here
	private int  pMod(int a, int b, int m) {
	   int  tempo;
	  if (b ==0 ){
	   tempo =  1;  //EXIT condition
	   }//if
	  else  if (b == 1) tempo = a;
	        else { int temp = pMod(a,b/2,m);
	            if (b%2 == 0)
	               tempo = (temp*temp)%m;
	            else
	     		    tempo = ((temp*temp)%m)*a%m;
			   }
	    return tempo;
	 } //POWERMOD method

}
import java.util.*;

public class RSA
{
	private char map[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',' ', '.', ',', ';', '?'};
	
	//C=(m^e) % n
	public List<Integer> encrypt(String s, KeyPair keyPair)
	{
		int plain[] = mapping(s);
		List<Integer> blocks = createBlocks(plain);
		List<Integer> cipher = new ArrayList();
		for(int i=0;i<blocks.size();i++)
		{
			int tempC = pMod(blocks.get(i), keyPair.getE(), keyPair.getN());

			cipher.add(tempC);
		}
		return cipher;
	}
	
	//D=(c^e) % n
	public List<Integer> decrypt(List<Integer> cipher, KeyPair keyPair)
	{
		List<Integer> plain = new ArrayList();
		for(int i=0;i<cipher.size();i++)
		{
			int tempC = pMod(cipher.get(i), keyPair.getD(), keyPair.getN());

			plain.add(tempC);
		}
		return plain;
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
	}
	
	/*	method takes in the in an int array and splits it into blocks as specified by the RSA standard
	 * 	each block = a[i] and a[i+1] 
	 *	params
	 *		int p[] = plain text converted to decimal according to the mapping function
	 *	returns
	 *		list<int> 
	 */
	private List<Integer> createBlocks(int p[])
	{
		List<Integer> temp = new ArrayList();
		for(int i=0;i<p.length;i++)
		{
			if((i+1)%2==0)
			{
				String s1 = ""; String s2 = "";
				
				//pretty sure this was completely unnecessary, but it made me feel better anyways
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
	
	//had to create a PowerMod method because the numbers we were taking powers of were too large for Java to handle
	private int  pMod(int a, int b, int m)
	{
	  int  temp1;
	  if (b ==0 )
	  {
	   temp1 =  1;
	  }
	  else  if (b == 1)
		  temp1 = a;
	        else 
	        	{ 
	        	int temp = pMod(a,b/2,m);
	            if (b%2 == 0)
	               temp1 = (temp*temp)%m;
	            else
	     		    temp1 = ((temp*temp)%m)*a%m;
			}
	    return temp1;
	 }
}

import java.math.BigInteger;
public class RSA_Key {
	private static final int COUNT = 5;
	
	int n,phi,e,d;
	
	
	
	public KeyPair[] generateKeys(int p, int q)
	{
		KeyPair[] keyPairs = new KeyPair[COUNT];
		
		n = p*q;
		phi = (p-1)*(q-1);
		int rp_Val [] = find_RP_Val(phi);
		int dVal[] = find_DVal(rp_Val);
	
		for(int i=0;i<COUNT;i++)
		{
			keyPairs[i] = new KeyPair(rp_Val[i],dVal[i], n);
			//System.out.println(keyPairs[i]);
		}
		
		return keyPairs;
	}
	
	private int[] find_RP_Val(int t)
	{
		int val[] = new int[COUNT];
		int num = 2;
		int count = 0;
		while(count<COUNT)
		{
			if(gcd(t,num)==1)
			{
				val[count]=num;
				count++;
			}
			num++;
		}
		return val;
	}
	
	private int gcd(int a, int b)
	{
		int temp=0;
		while(b!=0)
		{
			temp=b;
			b= a%b;
			a = temp;
		}
		return a;
	}
	
	int[] find_DVal(int num[])
	{
		int dVal[] = new int[COUNT];
		for(int i=0;i<COUNT;i++)
		{
			dVal[i] = xgcd(num[i], phi);
		}
			
		return dVal;
	}
	
	private int xgcd(int a, int b)
	{
		int dividend = a;
		int divisor = b;
		int r = 0;
		int x_1 = 1; int x0 = 0; 
		int y_1 = 0; int y0 = 1;
		
		while(divisor!=0)
		{
			int q = dividend/divisor;
			r = dividend%divisor;
			int x = x_1-x0*q;
			int y = y_1-y0*q;
			
			dividend = divisor;
			divisor = r;
			x_1 = x0;
			x0 = x;
			y_1 = y0;
			y0 = y;
			
			if(r==0)
			{
				if(x_1<0)
					return x0+x_1;
				else
					return x_1;
			}
			
		}
		return 0;
	}
	
	public int getN()
		{return n;}
	public int getPhi()
		{return phi;}	

}
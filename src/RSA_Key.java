public class RSA_Key {
	private static final int COUNT = 5;
	
	int n,phi;
	int e[], d[];
	
	public void generateKeys(int p, int q)
	{
		n = p*q;
		phi = (p-1)*(q-1);
		e = find_RP_Val(phi);
		d= find_DVal(e);
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
	
	//Euclid's OG method for finding the GCD, nothing too fancy here
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
	
	//Euclid's new and improved method for finding our "D" values.
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
			
			//????????????????
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
	
	//Getter methods
	public int getN()
		{return n;}
	public int getPhi()
		{return phi;}	
	public int[] getE_Arr()
		{return e;}	
	public int[] getD_Arr()
		{return d;}

}
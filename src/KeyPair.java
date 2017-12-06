
//this is basically just a placeholder class that holds info
//figured this was easier to do to make output look cleaner
public class KeyPair {
	private int e,d,n;
	
	public KeyPair(int e,int d, int n)
	{
		this.e=e;
		this.d=d;
		this.n=n;
	}
	
	//Getter Methods
	public int getE()
	{return e;}
	public int getD()
	{return d;}
	public int getN()
	{return n;}
	
	@Override
	public String toString()
	{
		return String.format("[E = " + e + ",  D = " + d + ", N = " + n + "]");
	}
}

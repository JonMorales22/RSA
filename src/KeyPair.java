
public class KeyPair {
	private int e,d,n;
	
	public KeyPair(int e,int d, int n)
	{
		this.e=e;
		this.d=d;
		this.n=n;
	}
	
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
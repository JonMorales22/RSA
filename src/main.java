import java.math.BigInteger;
import java.util.Arrays;

public class main {
	public static void main(String args[])
	{
		String s1 = "How are you?";
		String s2 = "Public key cryptography";
		
		RSA rsa = new RSA();
		rsa.encrypt(s1, 73, 151);
	}
	
	public static void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}



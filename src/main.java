import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class main {
	public static void main(String args[])
	{
		String s1 = "How are you?";
		String s2 = "Public key cryptography";
		
		RSA_Key rsaKeyGen = new RSA_Key();
		rsaKeyGen.generateKeys(73, 151);
		
		int[] e = rsaKeyGen.getE_Arr();
		int[] d = rsaKeyGen.getD_Arr();
		int n = rsaKeyGen.getN();
		
		KeyPair[] keyPairs = new KeyPair[5];
		for(int i=0;i<5;i++)
		{
			keyPairs[i] = new KeyPair(e[i],d[i], n);
		}
		
		System.out.print("Phi = " + rsaKeyGen.getPhi());
		System.out.println("\tN = " + rsaKeyGen.getN());
		System.out.println();
		
		System.out.print("List of e's: "); printArray(e);
		System.out.print("List of d's: "); printArray(d);
		System.out.println();
		
		System.out.println("Original Plaintext: " + s2);
		System.out.println();
		
		RSA rsa = new RSA();
		for(int i=0;i<5;i++)
		{
			System.out.println("\tPublic Key: ("+keyPairs[i].getE() + "," + keyPairs[i].getN() +")");
			List<Integer> cipher = rsa.encrypt(s2, keyPairs[i]);
			System.out.print("\tCipher = " + cipher);
			System.out.println();
			
			System.out.println("\tPrivate Key: ("+keyPairs[i].getD() + "," + keyPairs[i].getN() +")");
			List<Integer> plain = rsa.decrypt(cipher,keyPairs[i]);
			System.out.print("\tPlain = " + plain);
			System.out.println();
			System.out.println();
		}
	}
	
	public static void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();;
	}
}



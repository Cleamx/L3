package test.exo;


public class Calculs {

	public static int calculsX(int x){
		if (x < 0) 
			x = -x;
		else 
			x -= 1;
		if (x == 2) 
			x = 1;
		else 
			x += 2;
		return x;
	}

	public static void main(String[] args) {
		System.out.println(Calculs.calculsX(0));
		System.out.println(Calculs.calculsX(10));
	}
	
}

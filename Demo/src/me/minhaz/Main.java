package me.minhaz;

public class Main {

	public  void Calc() {
		
		
		
		int a=74556132;
	int current=a+1;
	Boolean flag=true;
		
	
	
	while(true) {
		flag=true;
		for(int i=2;i<=current/2 && flag == true;i++) {
			if(current%i==0) {
				System.out.println("Is in Check"+ current + i);
				flag=false;
			}

		}
		if(flag==true) {
			System.out.println(current);
			break;
		}
		current++;
	}
	
		System.out.println(current);
		
		
	}
	
	
}

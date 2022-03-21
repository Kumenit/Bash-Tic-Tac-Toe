package ticToc;
import java.util.*;
public class tictoc {
	static ArrayList<Integer> ap=new ArrayList<Integer>();
	static ArrayList<Integer> ac=new ArrayList<Integer>();
	public static void game(char[][] c)
	{
		for(char c1[]:c)
		{
			for(char c2:c1)
			{
				System.out.print(c2);
			}
			System.out.println();
		}
	}
	public static void dir(char[][] c,int pos,String user)
	{  
		char symbol=' ';
		if(user.equals("player"))
		{
			symbol='X';
			ap.add(pos);
		}
		else if (user.equals("cpu")) 
		{
			symbol='O';
			ac.add(pos);
		} 
		switch(pos)
		{
		case 1: c[0][0]=symbol;
			break;
		case 2: c[0][2]=symbol;
			break;
		case 3: c[0][4]=symbol;
			break;
		case 4: c[2][0]=symbol;
		break;
		case 5: c[2][2]=symbol;
		break;
		case 6: c[2][4]=symbol;
		break;
		case 7: c[4][0]=symbol;
		break;
		case 8: c[4][2]=symbol;
		break;
		case 9: c[4][4]=symbol;
		break;
		}
	}
	public static String win()
	{
		List f1=Arrays.asList(1,2,3);
		List f2=Arrays.asList(4,5,6);
		List f3=Arrays.asList(7,8,9);
		List f4=Arrays.asList(1,4,7);
		List f5=Arrays.asList(2,5,8);
		List f6=Arrays.asList(3,6,9);
		List f7=Arrays.asList(1,5,9);
		List f8=Arrays.asList(7,5,3);
		List<List> al=new ArrayList<List>();
		al.add(f1);
		al.add(f2);
		al.add(f3);
		al.add(f4);
		al.add(f5);
		al.add(f6);
		al.add(f7);
		al.add(f8);
		for(List l:al)
		{
			if(ap.containsAll(l))
			{
				return("congratulation you won!");
			}
			else if(ac.containsAll(l))
			{
				return("you lose cpu win :(");
			}
			else if(ap.size() + ac.size()==9)
			{
				return("it is CAT");
			}
		}	
		return "";
	}
	public static void main(String[] args) {
		char c[][]= {{' ','|',' ','|',' '},
				     {'-','+','-','+','-'},
				     {' ','|',' ','|',' '},
				     {'-','+','-','+','-'},
				     {' ','|',' ','|',' '}};
		game(c);
		while(true)
		{
		Scanner s=new Scanner(System.in);
		System.out.println("enter number b/t 1-9");
		int i=s.nextInt();
		while(ap.contains(i) || ac.contains(i))
		{
			System.out.println("space is taken");
			i=s.nextInt();
		}
		dir(c,i,"player");
		String s1=win();
		if(s1.length() > 0)
		{
			System.out.println(s1);
			break;
		}
		
		Random r=new Random();
		int l=r.nextInt(9)+1;
		while(ap.contains(l) || ac.contains(l))
		{
			l=r.nextInt(9)+1;
		}
		dir(c, l,"cpu");

	game(c);
	 s1=win();
	 if(s1.length() > 0)
	 {
	System.out.println(s1);
	break;
		}
		}
 }
}
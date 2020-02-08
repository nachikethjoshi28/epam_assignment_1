package com.epam.newyeargift;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

abstract class Gifts
{
	String name;
	int quant; //quantity
	int weight;
}

class Chocolate extends Gifts
{
	Chocolate(String name,int quantity,int weight)
	{
		this.name=name;
		this.quant =quantity;
		this.weight = weight;
	}
}

class Sweet extends Gifts
{
	Sweet(String name,int quantity,int weight)
	{
		this.name=name;
		this.quant =quantity;
		this.weight = weight;
	}
}

class Candy extends Gifts
{
	Candy(String name,int quantity,int weight)
	{
		this.name=name;
		this.quant =quantity;
		this.weight = weight;
	}
}

 
public class App 
{	
	public static boolean search_in_giftbox(String name,Vector<Gifts> giftbox)
	{
		boolean found=false;
		for(Gifts g : giftbox)
		{
			if(g instanceof Candy)
			{
				Candy c=(Candy) g;
				if(c.name.equals(name))
				{
					found=true;
					break;
				}
			}
			else if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				if(c.name.equals(name))
				{
					found=true;
					break;
				}
			}
		}
		return found;
	}
	
    public static void main( String[] args ) throws IOException
    {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	Vector<Gifts> giftbox=new Vector<Gifts>();
    	System.out.print("Enter the no of chocolates you want to add to the giftbox : ");
    	int num=Integer.parseInt(br.readLine());
    	System.out.println("Enter the name,quantity and weight for each of "+num+" chocolates");
    	for(int i=0;i<num;i++)
    	{
    		String s=br.readLine();
    		int q=Integer.parseInt(br.readLine());
    		int w=Integer.parseInt(br.readLine());
    		giftbox.add(new Chocolate(s,q,w));
    	}
    	System.out.println("Enter the no of sweets you want to add to the giftbox : ");
    	num=Integer.parseInt(br.readLine());
    	System.out.println("Enter the name,quantity and weight for each of "+num+" sweets");
    	for(int i=0;i<num;i++)
    	{
    		String s=br.readLine();
    		int q=Integer.parseInt(br.readLine());
    		int w=Integer.parseInt(br.readLine());
    		giftbox.add(new Sweet(s,q,w));
    	}
    	System.out.println("Enter the no of candies you want to add to the giftbox : ");
    	num=Integer.parseInt(br.readLine());
    	System.out.println("Enter the name,quantity and weight for each of "+num+" candies");
    	for(int i=0;i<num;i++)
    	{
    		String s=br.readLine();
    		int q=Integer.parseInt(br.readLine());
    		int w=Integer.parseInt(br.readLine());
    		giftbox.add(new Candy(s,q,w));
    	}
    	System.out.println("The contents of gift box are :- ");
    	for(Gifts g:giftbox)
    	{
    		System.out.println("\t"+g.name);
    	}
    	
    	System.out.print("\nTotal weight of the Gift Box (in grams) : ");
    	int sum_of_weight=0;
    	for(Gifts g:giftbox)
    	{
    		sum_of_weight+=g.weight*g.quant;
    	}
    	System.out.println(sum_of_weight+"\n");
    	char des='y';
    	while(des!='n' && des!='N')
    	{
	    	System.out.println("Enter a candy or chocolate name you want to search in the gift Box : ");
	    	String name=br.readLine();
	    	if(search_in_giftbox(name,giftbox))
	    	{
	    		System.out.println(name+" is in giftbox");
	    	}
	    	else
	    		System.out.println(name+"is not present in giftbox");
	    	System.out.println("Do you want to search more ?(y/n)");
	    	des=br.readLine().charAt(0);
    	}
    }
}

//Exercise 4 - BST Sort
//Lachlan Matthews
//lm301

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class BSTSort
{	
    static BufferedReader bufferedReader;
    static FileReader fileReader;
	static String value;
	static Node root;
	static int count = 0;
	static int x = 0;
	
	public static void main(String[] args) throws IOException
	{
		System.out.print("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String file = scanner.next();
        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch(Exception e)
        {
            System.out.println("Failed to open file");
        }
        while ((value = bufferedReader.readLine()) != null)
        {
            try
            {
				if (count > 0)
				{
					insert(root, Integer.parseInt(value));
				}
				else
				{
					insertFirst(Integer.parseInt(value));
				}
            }
            catch(Exception e)
            {
                System.out.println("Failed to read line");                       
            }
			count++;
        }
		visit(root);
	}
	
	public static Node insert(Node node, int value)
	{
		if (node == null)
		{
			return new Node(value);
		}
		
		if (value < node.value)
		{
			node.left = insert(node.left, value);
		}
		else if (value > node.value)
		{
			node.right = insert(node.right, value);
		}
		else
		{
			return node;
		}
		
		return node;
	}
	
	public static void insertFirst(int value)
	{
		root = insert(root, value);
	}
	
	public static void visit(Node root)
	{
		
		if (root.left != null)
		{
			visit(root.left);
		}
		print(root.value);
		if (root.right != null)
		{
			visit(root.right);
		}
	}
	
	public static void print(int value)
	{
		System.out.printf("%5s ", value);
		System.out.print(" ");
		if (x == 9)
		{
			System.out.print("\n");
			x = -1;
		}
		x++;
	}
}

class Node
{
	int value;
	Node left;
	Node right;
	
	Node(int value)
	{
		this.value = value;
		left = null;
		right = null;
	} 
}
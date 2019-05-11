import java.io.EOFException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainClass {
	 public static void main(String[] args) throws Exception
	    {
		 	Scanner in = new Scanner(System.in);
	        BinaryTree binarytree=new BinaryTree();
	        
	        int n, key, offset;
	        //int numberOfRecords = 8;
	        System.out.print("Enter file name -> ");
	        String filename= in.nextLine();
	        /*System.out.print("Enter number of records -> ");
	        n = in.nextInt();
	        System.out.print("Enter key value -> ");
	        key = in.nextInt();
	        System.out.print("Enter offset -> ");
	        offset = in.nextInt();*/
	        int choice;
	        
	        RecordClass record = new RecordClass();
	        /*binarytree.CreateRecordsFile (filename, numberOfRecords);
	        binarytree.InsertNewRecordAtIndex ( filename, 5 ,12);
	        binarytree.InsertNewRecordAtIndex ( filename, 12 ,24);
	        binarytree.InsertNewRecordAtIndex ( filename, 3 ,36);
	        binarytree.InsertNewRecordAtIndex ( filename, 9 ,48);
	        binarytree.InsertNewRecordAtIndex ( filename, 8 ,60);
	        binarytree.InsertNewRecordAtIndex ( filename, 2 ,72);
	        binarytree.InsertNewRecordAtIndex ( filename, 4 ,84);*/
	        
	        binarytree.SearchRecordInIndex (filename, 4);
	        
	        binarytree.DisplayIndexFileContent (filename);
	        
	        while(true)
	        {
	        	System.out.println("To create record file, enter 1");
	        	System.out.println("To insert to tree, enter 2");
	        	System.out.println("To search, enter 3");
	        	System.out.println("To display, enter 4");
	        	System.out.println("To exit, enter 0");
	        	System.out.print("Enter your choice -> ");
	        	choice = in.nextInt();
	        	if(choice == 1)
	        	{
	        		System.out.print("Enter number of records -> ");
	    	        n = in.nextInt();
	        		binarytree.CreateRecordsFile(filename, n);
	        		System.out.print("file created...");
	        		//break;
	        	}
	        	else if(choice == 2)
	        	{
	        		System.out.print("Enter key value -> ");
	    	        key = in.nextInt();
	    	        System.out.print("Enter offset -> ");
	    	        offset = in.nextInt();
	        		binarytree.InsertNewRecordAtIndex(filename, key, offset);
	        	}
	        	else if(choice == 3)
	        	{
	        		System.out.print("Enter key value -> ");
	    	        key = in.nextInt();
	        		binarytree.SearchRecordInIndex(filename, key);
	        	}
	        	else if(choice == 4)
	        	{
	        		binarytree.DisplayIndexFileContent(filename);
	        	}
	        	else
	        	{
	        		in.close();
	        		return;
	        	}
	        }
	    }
}

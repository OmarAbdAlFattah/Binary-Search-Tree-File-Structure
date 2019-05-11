import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryTree {
	public static int counter = 1;
   
    public static void CreateRecordsFile (String filename, int numberOfRecords) throws Exception, EOFException
    {
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        
        for(int i = 1; i <= numberOfRecords; i++)
        {
            if(i != numberOfRecords)
            {
            	if(i == 1)
            	{
            		file.writeInt(counter);
                    file.writeInt(0);
                    file.writeInt(0);
                    file.writeInt(0);
            	}
            	else
            	{
            		file.writeInt(i);
                    file.writeInt(0);
                    file.writeInt(0);
                    file.writeInt(0);
            	}
            }
            
            else
            {
                file.writeInt(-1);
                file.writeInt(0);
                file.writeInt(0);
                file.writeInt(0);
            }
        }
        file.close();
    }  
    
    public static int InsertNewRecordAtIndex (String filename, int Key, int ByteOffset) throws Exception, EOFException
    {
    	
       RandomAccessFile file = new RandomAccessFile(filename, "rw");
       file.seek(0) ;
       counter = file.readInt();
       
       file.seek(counter * 16);
       file.writeInt(Key);
       file.writeInt(ByteOffset);
       file.writeInt(-1);
       file.writeInt(-1);
       
       for(int i = 1; i < counter; i++)
       {
    	   file.seek(counter * 16);
    	   int v1 = file.readInt();
    	   file.seek(i * 16);
    	   int v2 = file.readInt();
	    	if(v1 > v2)
	    	{
	    		file.seek((i * 16) + 12);
	    		int check = file.readInt();
	    		
	    		if(check == -1)
	    		{
	    			file.seek((i * 16) + 12);
	    			file.writeInt(counter);
	    			break;
	    		}
	    		
	    		else
	    		{
	    			i = check - 1;
	    		}
	    	}
	    	else
	    	{
	    		file.seek((i * 16) + 8);
	    		int check1 = file.readInt();
	    		
	    		if(check1 == -1)
	    		{
	    			file.seek((i * 16) + 8);
	    			file.writeInt(counter);
	    			break;
	    		}
	    		else
	    		{
	    			i = check1 - 1;
	    		}
	    	}
    	   
       } 
       
       counter++;
       file.seek(0);
       file.writeInt(counter);
       file.close();
       return counter;
    }
    
    public static void SearchRecordInIndex (String filename, int Key) throws IOException
    {
    	RandomAccessFile file = new RandomAccessFile(filename, "rw");
    	for (int i=1 ; i<file.length()/16 ; i++ )
    	{
    		file.seek(i*16);
    		int check ;
    		int v1= file.readInt();
    		if (Key>v1)
    		{
    			file.seek((i*16)+12);
    			check = file.readInt();
    			if (check==-1)
    			{
    				
    				System.out.print(-1);
    			}
    			else
    			{
    				i=check-1;
    			}
    		
    			
    		}
    		else if (Key<v1)
    		{
    			file.seek(i*16+8);
    			check=file.readInt();
    			if (check==-1)
    			{
    				System.out.print(-1);
    			
    			}
    			else 
    			{
    				i=check -1;
    	
    			}
    		}
    		else 
    		{
    			int offset;
    			file.seek(i*16+4);
    			offset=file.readInt();
    			System.out.println("key is at " + offset);	
    		}
    		
    	}
    	file.close();
    	
    }
    
    public void DisplayIndexFileContent (String filename) throws Exception
    {
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
      for(int i = 0; i < file.length(); i += 16) {
	       	file.seek(i);
	        int key= file.readInt();
	        int offset=file.readInt();
	        int left =file.readInt();
	        int right=file.readInt();
	        System.out.print(key+" | "+offset+" | "+left+" | "+right+" | ");
	        System.out.println();
      }
      file.close();
    }   
}
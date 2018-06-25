import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Server {
	

    public static void main(String[] args)
        throws Exception
    {
    	ArrayList<Block> blockChain = new ArrayList<>();
    	 try{
    	        ServerSocket ss = new ServerSocket(12348);
    	        Socket s = ss.accept();
    	        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
    	        ObjectInputStream in = new ObjectInputStream(s.getInputStream());

    	     /*   Scanner scanner = new Scanner(s.getInputStream());
    	        String text = scanner.nextLine();*/
    	        
    	        
    	        int i = 0;
    	        int previousHash = 0;
    	        do { 	 
    	        	Object ob = in.readObject();
    	        	if(ob.toString().equalsIgnoreCase("no")){
    	        		i=20;
    	        	}
    	        	else{
    	        	MedicalReport rp = (MedicalReport)ob;
    	        	Block block = new Block(rp,previousHash);
    	        	blockChain.add(block);
    	        	System.out.println("Block " + blockChain.size() + " added to blockchain");
    	        	System.out.println(blockChain.get(i));
    	        	previousHash = block.getBlockHash();
    	        	
    	        	i++;
    	        	}
    	        	
    	        } while (i != 20);
    	        
    	        try{
		            ss.close();
		            }
		            catch(Exception e){
		            	System.out.println(e);
		            }
		            

    	      }catch(Exception e){
    	        System.out.println(e);
    	}

    }
}

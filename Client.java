import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client implements Runnable{
		
	
	 public static void main(String[] args) throws Exception {
	 
		 (new Thread(new Client())).start();
		      
		       
	}
	public static MedicalReport createReport(Scanner in){
		 
         System.out.println("Type the name: ");
         String name = in.nextLine();
         System.out.println("Type the age: ");
         int age = in.nextInt();
         in.nextLine();//clean the buffer
         System.out.println("Type the id: ");
         String id = in.nextLine();
         System.out.println("Type the record: ");
         String record = in.nextLine();
         //in.close();
         
         return new MedicalReport(age,name,id,record);
		//return new MedicalReport(10,"pepe","id","record");
		
	}
	@Override
	public void run() {
		Scanner sc = new Scanner (System.in);
	
	        try{
	            Socket s = new Socket("localhost", 12348);
	            ObjectOutputStream p = new ObjectOutputStream(s.getOutputStream());
	            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
	        
	           /* PrintWriter print = new PrintWriter(s.getOutputStream());
	            print.println("ready");
	            print.flush();*/
	            
	          //manda informe al servidor serializado y espera respuesta
	            boolean stop = false;
	            while(!stop){
	            	try{
	            	MedicalReport report = createReport(sc);
	            	p.writeObject(report);
	            	p.flush();
	            	p.reset();
	            	
	            	System.out.println("Do you want to continue? Yes or No");
	            	;
	            	String answer="";
	            	if(sc.hasNextLine())
	            		answer = sc.nextLine();
	            	
	            	if(answer.equalsIgnoreCase("no"))
	            		stop = true;
	            		
	            	}
	            	catch(Exception e){
	            		System.out.println(e);
	            	}
	            	
	            }
	            
	            try{
	            Object wait = sc.next();
	            s.close();
	            sc.close();
	            }
	            catch(Exception e){
	            	System.out.println(e);
	            }
	            
	         


	      
	          }catch(Exception e){
	            System.out.println(e);
	  }
		
	}
	
}
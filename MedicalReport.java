import java.io.Serializable;


public class MedicalReport implements Serializable {
	
	private int age;
	private String name;
	private String id;
	private String record;
	
	private static final long serialVersionUID = 1L;
	
	public MedicalReport(){super();}
	public MedicalReport(int age, String name, String id, String record) {
		super();
		this.age = age;
		this.name = name;
		this.id = id;
		this.record = record;
	}
	
/*	public void addRecord(String record){
		this.record = this.record + ". \n" + record;
	}*/
	public String getRecord(){
		return this.record;
	}
	public String toString(){
		return this.name + ". \n" + this.age + ". \n" + this.id + ". \n" + this.record;
	}
	
	

}

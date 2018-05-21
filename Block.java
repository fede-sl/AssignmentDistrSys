

public class Block {
	
	private int blockHash;
	private int previousHash;
	private MedicalReport report;

	//Block Constructor.
	public Block(MedicalReport report,int previousHash ) {
		this.previousHash = previousHash;
		this.report = report;
		this.blockHash = report.hashCode();
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public MedicalReport getReport() {
		return report;
	}

	public int getBlockHash() {
		return blockHash;
	}
}

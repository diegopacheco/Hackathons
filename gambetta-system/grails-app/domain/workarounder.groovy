import gambetta.system.Fault
import java.util.List

public class Workarounder {
	String name
	String email
	String twitter	
	Float  totalDebits
	Float  currentdebits
	List<Fault>  fault
	
	String toString(){
		"${this.name},${this.email},${this.twitter}" 
	}	
	
}
package gambetta.system

import java.util.List

public class Workarounder {
	String name
	String email
	String twitter
	Float  totalDebits
	Float  currentdebits

	static constraints = {
		name(blank:false)
		email(blank:false)
		totalDebits(min:0.1f)
		currentdebits(min:0.1f)
	}

	String toString() { "${this.name}" }
}


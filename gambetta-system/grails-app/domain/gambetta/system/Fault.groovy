package gambetta.system

//import groovy.transform.ToString


//@ToString(includeFields=true,excludes='price')
class Fault {
	String name
	Float price

	static constraints = {
		name(maxLength:50,blank:false)
		price(min:0.5f,max:999.99f)
	}

	String toString() {
	    "${this.name}"
    }

}


package gambetta.system

class Debit {

    String faultDescription
    Date occurred = new Date()
    Float value
    Workarounder workarounder

    static constraints = {
        faultDescription nullable:false
        workarounder nullable:false
        occurred nullable:false
        value(min:0.5f)
    }

    String toString() {
        "${this.occurred} ${this.faultDescription} ${this.value}"
    }

}


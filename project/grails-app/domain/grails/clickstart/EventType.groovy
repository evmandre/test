package grails.clickstart

class EventType {
	
	String typeofCategory
	static belongsTo = [category :EventCategory]
	
	String toString(){
		
		"$typeofCategory"
	}

    static constraints = {
    }
}

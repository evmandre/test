package grails.clickstart

class EventCategory {
	
	String categoryName
	static hasMany = [type :EventType, event :Event]
	
	String toString(){
		
		"$categoryName"
	}

    static constraints = {
		
    }
}

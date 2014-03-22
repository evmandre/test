package grails.clickstart

class EventComment {
	
	Event event
	Date dateCreated 
	static belongsTo = Event
	String comment
	
	String toString(){
		
		"$comment"
	}

    static constraints = {
    }
}

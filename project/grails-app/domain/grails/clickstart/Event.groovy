package grails.clickstart

class Event {
	
	String eventTitle
	Date dateOfEvent
//	byte[] imageOfEvent
	String description
	BigDecimal fee
	String contactInfo
	//Address locationOFevent  IMPLEMENT!!
	static belongsTo = [category :EventCategory,type:EventType]
	static hasMany = [comments: EventComment]
	
	String toString(){
		
		"$eventTitle, $contactInfo, $fee" 
	}

    static constraints = {
		
		description(maxSize:5000)
    }
}

package demoapp_grails

import com.dhtmlx.planner.DHXEventRec

class EventRec extends DHXEventRec {

	static mapping = {
		table 'events_rec'
		id column: 'event_id'
	}

}

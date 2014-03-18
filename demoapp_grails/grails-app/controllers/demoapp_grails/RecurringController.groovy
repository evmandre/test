package demoapp_grails

import com.dhtmlx.planner.DHXPlanner
import com.dhtmlx.planner.DHXSkin
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension

class RecurringController {

    def recurring_04() {
		DHXPlanner s = new DHXPlanner('./codebase/', DHXSkin.TERRACE);
		s.setInitialDate(2013, 1, 7);
    	s.config.setScrollHour(8);
    	s.config.setFullDay(true);
    	s.config.setMultiDay(true);
    	s.setWidth(900);
		s.load("04_events", DHXDataFormat.JSON);
		s.data.dataprocessor.setURL("04_events");
		s.extensions.add(DHXExtension.RECURRING);

		def map = [
			planner: s.render(),
			sample_name: "Recurring events",
			sample_dsc: "Recurring events are events that repeat in series, for example, the birthday of your friend, a monthly salary or a weekly staff meeting. Create a recurring event and try to edit it: you may change all occurrences in the series at once or edit just a single instance."
		]
		render(view: "/shared/article", model: map)
	}

	def events_04() {
		def evs = new CustomRecEventsManager(request);
		render evs.run();
	}

}

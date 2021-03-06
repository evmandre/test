package demoapp_grails

import com.dhtmlx.planner.DHXPlanner
import com.dhtmlx.planner.DHXSkin
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension


class SavingController {

    def saving_03() {
		DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
    	s.setInitialDate(2013, 1, 7);
    	s.config.setScrollHour(8);
    	s.setWidth(900);
		s.extensions.add(DHXExtension.RECURRING);
		s.load("/demoapp_grails/03_events", DHXDataFormat.JSON);
		s.data.dataprocessor.setURL("/demoapp_grails/03_events");

		def map = [
			planner: s.render(),
			sample_name: "Saving",
			sample_dsc: "JavaPlanner provides simple integration with the server side. Add, edit, delete events and then, reload the page. All the changes will be saved."
		]
		render(view: "/shared/article", model: map)
	}

	def events_03() {
		def evs = new CustomEventsManager(request);
		render evs.run();
	}
}

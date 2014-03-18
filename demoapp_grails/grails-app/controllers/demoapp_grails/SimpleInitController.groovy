package demoapp_grails

import com.dhtmlx.planner.DHXPlanner
import com.dhtmlx.planner.DHXSkin
import com.dhtmlx.planner.extensions.DHXExtension

class SimpleInitController {

	def simple_01() {
		DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
    	s.setInitialDate(2013, 1, 7);
    	s.config.setScrollHour(8);
    	s.setWidth(900);

		CustomEventsManager evs = new CustomEventsManager(request);
		s.parse(evs.getEvents());

		def map = [
			planner: s.render(),
			sample_name: "Simple init",
			sample_dsc: "Basic planner has 3 default views: Day, Week, Month. You can add, edit, delete events but when you reload the page all changes will be lost."
		]
		render(view: "/shared/article", model: map)
	}
}

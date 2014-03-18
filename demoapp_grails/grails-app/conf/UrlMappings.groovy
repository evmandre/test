class UrlMappings {

	static mappings = {
		"/"(controller: "SimpleInit", action: "simple_01")
		"/01_simple_init"(controller: "SimpleInit", action: "simple_01")

		"/02_loading"(controller: "Loading", action: "loading_02")
		"/02_events"(controller: "Loading", action: "events_02")

		"/03_saving"(controller: "Saving", action: "saving_03")
		"/03_events"(controller: "Saving", action: "events_03")

		"/04_recurring"(controller: "Recurring", action: "recurring_04")
		"/04_events"(controller: "Recurring", action: "events_04")

		"/05_agenda"(controller: "Agenda", action: "agenda_05")
		"/05_events"(controller: "Agenda", action: "events_05")

		"/06_map"(controller: "Map", action: "map_06")
		"/06_events"(controller: "Map", action: "events_06")

		"/07_grid_view"(controller: "GridView", action: "gridview_07")
		"/07_events"(controller: "GridView", action: "events_07")

		"/08_units_view"(controller: "UnitsView", action: "unitsview_08")
		"/08_events"(controller: "UnitsView", action: "events_08")

		"/09_timeline_view"(controller: "Timeline", action: "timeline_09")
		"/09_events"(controller: "Timeline", action: "events_09")

		"/10_lightbox"(controller: "Lightbox", action: "lightbox_10")
		"/10_events"(controller: "Lightbox", action: "events_10")

		"/11_custom_lightbox"(controller: "CustomLightbox", action: "custom_lightbox_11")
		"/11_custom_editor"(controller: "CustomLightbox", action: "custom_editor_11")
		"/11_events"(controller: "CustomLightbox", action: "events_11")

		"/12_mini_calendars"(controller: "MiniCalendars", action: "mini_calendars_12")
		"/12_events"(controller: "MiniCalendars", action: "events_12")

		"/13_highlights"(controller: "Highlights", action: "highlights_13")
		"/13_events"(controller: "Highlights", action: "events_13")

		"/14_filtering"(controller: "Filtering", action: "filtering_14")
		"/14_events"(controller: "filtering", action: "events_14")

		"/15_security"(controller: "Security", action: "security_15")
		"/15_events"(controller: "Security", action: "events_15")

		"/16_export"(controller: "Export", action: "export_16")
		"/16_events"(controller: "Export", action: "events_16")
		"/16_ical"(controller: "Export", action: "ical_16")

		"500"(view:'/error')
	}
}

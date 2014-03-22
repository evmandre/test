package grails.clickstart

import grails.test.GrailsUnitTestCase
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
//@TestFor(EventType)
class EventTypeTests extends GrailsUnitTestCase {

    def setup() {
    }

    def cleanup() {
    }

      void testToString() {

		  def category = new EventCategory(categoryName: 'Music')
		  def type = new EventType(typeofCategory: 'festival', category:[categoryName:'Music'] as EventCategory)
		  assertEquals 'festival', type.toString()
		  }
}

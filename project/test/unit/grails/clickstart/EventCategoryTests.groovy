package grails.clickstart

import grails.test.GrailsUnitTestCase
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
//@TestFor(EventCategory)
class EventCategoryTests extends GrailsUnitTestCase {

    def setup() {
    }

    def cleanup() {
    }

   void testToString() {

	   def category = new EventCategory(categoryName: 'Music')
	   assertEquals 'Music', category.toString()

}
}

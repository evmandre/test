package grails.clickstart

import java.util.Date;

import grails.test.GrailsUnitTestCase
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class EventTests extends GrailsUnitTestCase {

    def setup() {
    }

    def cleanup() {
    }

    void testToString() {

		  def category = new EventCategory(categoryName: 'Music')
		  def type = new EventType(typeofCategory: 'festival', category:[categoryName:'Music'] as EventCategory)
		  def event = new Event(eventTitle: 'The biggest Festival!',
			  dateOfEvent: new Date('10/10/2014'),
			  description: 'This event will...',
			  fee : '500',
			  contactInfo : 'dimitris',
			  category : [categoryName:'Music'] as EventCategory,
			  type : [typeofCategory:'festival'] as EventType)
		  assertEquals 'The biggest Festival!, dimitris, 500', event.toString()
		  }
}

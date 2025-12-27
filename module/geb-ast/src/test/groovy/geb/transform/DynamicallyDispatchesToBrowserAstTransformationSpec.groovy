package geb.transform

import spock.lang.Specification
import org.codehaus.groovy.control.MultipleCompilationErrorsException

class DynamicallyDispatchesToBrowserAstTransformationSpec extends Specification {

    def "metadata methods on a static nested class that extends GebSpec will compile"() {
        given:
        def scriptText = """
import geb.spock.GebSpec

class Foo {
  static class Bar extends GebSpec { }
}
"""

        when:
        new GroovyShell().parse(scriptText)

        then:
        notThrown(MultipleCompilationErrorsException)
    }

}

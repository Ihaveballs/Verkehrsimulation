/** Datentyp fuer Elemente einer linearen Liste von Verkehrsteilnehmern
 * @see Liste
 * @author Juergen Giesl
 * @author Joachim Protze
 */
class Element {
    
    Verkehrsteilnehmer wert;
    Element next; //Element ist eine rekursive Datenstruktur.
    
    /** Erzeugt ein neues Element ohne Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     */
    Element (Verkehrsteilnehmer wert) {
	this.wert = wert;
	next = null;
    }
    
    /** Erzeugt ein neues Element mit Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     *   @param next Nachfolgerelement des neuen Elements
     */
    Element (Verkehrsteilnehmer wert, Element next) {
	this.wert = wert;
	this.next = next;
    }
    
    /** @return Wert des Elements
     */
    Verkehrsteilnehmer getWert () {
	return wert;
    }
    
    /** @param wert Wert, den das Element erhalten soll
     */	
    void setWert (Verkehrsteilnehmer wert) {
	this.wert = wert;
    }
    /** @return Nachfolger des Elements
     */
    Element getNext () {
	return next;
    }
    
    /** @param next Nachfolger, den das Element erhalten soll
     */	
    void setNext (Element next) {
	this.next = next;
    }
    
    public String toString () {
	return wert.toString();
    }
    
}

/** Datentyp fuer lineare Listen von Verkehrsteilnehmern
 * @see Element
 * @author Juergen Giesl
 * @author Joachim Protze
 */
public class Liste {
    
    /** Attribut, das auf das erste Element der Liste zeigt
     */
    private Element kopf;
    private int size;
    
      
    /** Erzeugt eine neue leere Liste
     */
    public Liste () {
	kopf = null;
	size = 0;
    }
    
    /** Gibt die Laenge der Liste zurueck
     *   @return Die Laenge der Liste
     */
    public int size () {
	    return size;
    }
    
    /** Sucht nach einem Element in der Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @return Das erste Element in der Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    public Element suche (Verkehrsteilnehmer wert) {
	return suche (wert, kopf);
    }
    
    /** Sucht nach einem Element in einer vorgegebenen Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @param kopf Der Kopf der Liste, in der gesucht wird.
     *   @return Das erste Element in jener Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    private static Element suche (Verkehrsteilnehmer wert, Element kopf) {
	if	(kopf == null) 		return null;
	else if (kopf.wert == wert)     return kopf;
	else				return suche (wert, kopf.next);
    }
    
    /** @return Das kopfelement
     */
    public Element getKopf () {
    	return kopf;
    }
    
    /** Sucht nach dem i-ten Element in der Liste.
     *   @param i Der Index des gesuchten Elements.
     *   @return Das Element in der Liste an der stelle i, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    public Element get (int i) {
        if (i>size)
          return null;
	return get (i, kopf);
    }
    
    /** Sucht nach einem Element in einer vorgegebenen Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @param kopf Der Kopf der Liste, in der gesucht wird.
     *   @return Das erste Element in jener Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    private static Element get (int i, Element kopf) {
	if	(kopf == null) 		return null;
	else if (i == 0)     return kopf;
	else	return get (i-1, kopf.next);
    }
    
    /** Erzeugt einen String, der die Elemente der Liste von vorne nach hinten
     *   aufzaehlt.
     *   @return Die Liste als Zeichenkette
     */
    public String toString () {
	return 	"( " + durchlaufe(kopf) + ")";
    }
    
    /** Gibt den Inhalt der Liste (von vorne nach hinten) auf dem Bildschirm aus.
     *   
     */
    public void drucke() {
	System.out.println (this);
    }
    
    
    /** Erzeugt einen String, der aus allen Elementen einer vorgegebenen Liste (von vorne
     *   nach hinten) besteht.
     *   @param kopf Der Kopf der zu durchlaufenden Liste.
     *   @return Die Zeichenkette aller Elemente jener Liste.
     */
    private static String durchlaufe (Element kopf) {
	if (kopf != null) return kopf.wert + " " + durchlaufe(kopf.next);
	else              return "";
    }
    
    /** Erzeugt einen String, der die Elemente der invertieren Liste 
     *   (d.h., von hinten nach vorne) aufzaehlt.
     *   @return Die invertierte Liste als Zeichenkette
     */
    public String toStringRueckwaerts () {
	return 	"(" + durchlaufeRueckwaerts(kopf) + " )";
    }
    
    /** Gibt den Inhalt der invertierten Liste (d.h., von hinten nach 
     *   vorne) auf dem Bildschirm aus.
     *  
     */
    public void druckeRueckwaerts() {
	System.out.println (this.toStringRueckwaerts());
    }
    
    
    /** Erzeugt einen String, der aus allen Elementen einer 
     *   invertierten vorgegebenen Liste (von hinten
     *   nach vorne) besteht. 
     *   @param kopf Der Kopf der zu durchlaufenden Liste.
     *   @return Die Zeichenkette aller Elemente jener invertierten Liste.
     */
    private static String durchlaufeRueckwaerts (Element kopf) {
	if (kopf != null) return durchlaufeRueckwaerts(kopf.next) + " " + kopf.wert;
	else	          return "";
    }
    
    
    /** Fuegt ein Element in die Liste ein. (fuer kompatibilitaet mit List<>)
     *   @param wert Der Wert des einzufuegenden Elements.
     */
    public void add (Verkehrsteilnehmer wert) {
        fuegeVorneEin(wert);
    }

    /** Fuegt ein Element in die Liste ein. (fuer kompatibilitaet mit List<>)
     *   @param wert Der Wert des einzufuegenden Elements.
     */
    public void addAll (Liste andereListe) {
        Element kopf = andereListe.getKopf();
        while (kopf != null)
        {
            fuegeVorneEin(kopf.getWert());
            kopf=kopf.getNext();
        }
    }

    /** Fuegt ein Element vorne in die Liste ein.
     *   @param wert Der Wert des einzufuegenden Elements.
     */
    public void fuegeVorneEin (Verkehrsteilnehmer wert) {
        size++;
	if 	(kopf == null)	kopf = new Element (wert);
	else			kopf = new Element (wert, kopf);
    }
    
   
    /** Loescht die komplette Liste. (fuer kompatibilitaet mit List<>)
     */
    public void clear () {
        size=0;
	    kopf = null;
    }
	
    /** Loescht die komplette Liste.
     */
    public void loesche () {
        size=0;
	    kopf = null;
    }
	
    /** Loescht das erste Element mit dem angegebenen Wert aus der Liste. (fuer kompatibilitaet mit List<>)
     *   @param wert Der Wert des zu loeschenden Elements.
     */
    public void remove (Verkehrsteilnehmer wert) {
        size--;
	    kopf = loesche (wert, kopf);
    }

    /** Loescht das erste Element mit dem angegebenen Wert aus der Liste. 
     *   @param wert Der Wert des zu loeschenden Elements.
     */
    public void loesche (Verkehrsteilnehmer wert) {
        size--;
	    kopf = loesche (wert, kopf);
    }

    /** Loescht das erste Element mit dem angegebenen Wert, das ab einem vorgegebenen
     *   Element in der Liste auftritt.
     *   @param wert Der Wert des zu loeschenden Elements.
     *   @param element Das Element der Liste, ab dem erst geloescht werden kann.
     *   @return Das erste Element der Teilliste ab dem vorgegebenen Element,
     *           wobei der zu loeschende Wert geloescht wurde.
     */
    private static Element loesche (Verkehrsteilnehmer wert, Element element) {
	if 	(element == null) 	return null;
	else if (wert == element.wert) 	return element.next;
	else				{element.next = loesche (wert, element.next);
	                                return element;}											
    }
			
			
}	

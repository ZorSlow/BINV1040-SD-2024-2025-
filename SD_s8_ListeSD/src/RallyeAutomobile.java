public class RallyeAutomobile {
    private ListeSDImpl listePilotes;

    public RallyeAutomobile(String[] lesPilotes) {
        listePilotes = new ListeSDImpl();
        for (String pilote: lesPilotes) {
            listePilotes.insererEnQueue(pilote);
        }
    }
}

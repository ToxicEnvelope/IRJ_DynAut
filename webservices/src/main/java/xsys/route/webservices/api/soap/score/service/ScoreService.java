package xsys.route.webservices.api.soap.score.service;


import xsys.route.webservices.api.soap.score.Score;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class ScoreService {

    private static Score score = new Score();

    public ScoreService() {}

    @WebMethod(operationName = "resetScore")
    public void reset() {
        score.wins = score.losses = score.ties = 0;
    }

    public int increaseWins() { return ++ score.wins; }
    public int increaseLosses() { return ++ score.losses; }
    public int increaseTies() { return ++ score.ties; }

    public int getWins() { return score.wins; }
    public int getLosses() { return score.losses; }
    public int getTie() { return score.ties; }
}

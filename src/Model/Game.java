package Model;

import java.util.ArrayList;
import java.util.Collections;
import View.Observed;
import View.Observer;

class Game implements Observed{
    private static Game game = null;
    
    // Lista de jogadores
    private ArrayList<Player> players = new ArrayList<Player>();

    private ArrayList<Observer> lst = new ArrayList<Observer>();

    // Cartas de objetivo
    private ObjectiveCardDeck objectiveCardDeck;

    // Inicializa o jogo
    public boolean initiateGame(){
        return true;
    }
    private Game() {}

    // Singleton
    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public void add(Observer o){
        lst.add(o);
    }

    public void remove(Observer o){
        lst.remove(o);
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    // Pegar o jogador da vez
    public Player getJogadorVez(int i){
		return players.get(i);
	}

    //implementar 
    public Object get() {
        return this;
    }

    public void notifyObservers() {
        for (Observer o : lst) {
            o.notify(this);
        }
    }


    // Adiciona jogador na partida
    public boolean addPlayer(Player jogador){
        for (Player j: players){
            if (j.getName().equals(jogador.getName()) || j.getColor() == jogador.getColor())
                return false;
        }
        players.add(jogador);
        return true;
    }
}
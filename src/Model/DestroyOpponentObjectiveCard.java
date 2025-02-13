package Model;

class DestroyOpponentObjectiveCard extends ObjectiveCard{
    Player enemy;
    private String name;
    private String color;

    public DestroyOpponentObjectiveCard( String name, String color) {
        this.name = name;
        this.color = color;
        this.image = "war_carta_" + name + ".png";
        this.description = "Destruir todos os exércitos"+ color +". Se você é quem possui os exércitos " + color + "ou se esses exércitos já foram destruídos por outro jogador, o seu objetivo passa a ser conquistar 24 territorios a sua escolha.";
    }

    public String getName() {
        return this.name;
    } 

    public boolean checkStatus() {

        if (enemy.getEnemy().getColor().equals(color)) {
            if (owner.getTerritoryNumber() >= 24){
                return true;
            }
            return false;
        }
        if (enemy.getEnemy() == null){
            return false;
        }
        else if (enemy.getEnemy().equals(owner)){
            return true;
        }
        else if (owner.getTerritoryNumber() >= 24){
            return true;
        }
        return false;
    }

    public void checkOwner(Player dono) {
        this.owner = dono;
    }

}

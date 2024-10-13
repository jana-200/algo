public class JeuChatSouris {

    public static void main(String[] args){

        PlateauJeuChatSouris jeu = new PlateauJeuChatSouris();
        int positionSouris = 3;
        int positionChat = 1;
        jeu.afficherInformation("Vas-y !");
        jeu.placerSouris(positionSouris);
        jeu.placerChat(positionChat);
        while(positionSouris<16){
            jeu.afficherInformation("à la souris ");
            int lanceSouris = jeu.lancerDe();

            if(16-positionSouris<=lanceSouris){
                positionSouris=16;
                jeu.afficherInformation("La souris a gagné");
                jeu.supprimerSouris();
                jeu.placerSouris(positionSouris);
                break;
            }
            else{
                positionSouris+=lanceSouris;
                jeu.supprimerSouris();
                jeu.placerSouris(positionSouris);
            }

            jeu.afficherInformation("au chat");
            int lanceChat=jeu.lancerDe();
            positionChat+=lanceChat;
            if(positionChat>=positionSouris){
                positionChat=positionSouris;
                jeu.supprimerSouris();
                jeu.supprimerChat();
                jeu.placerChat(positionChat);
                jeu.afficherInformation("le chat a gagné");
                break;
            }
            else{
                jeu.supprimerChat();
                jeu.placerChat(positionChat);
            }
        }
    }
}

public class JeuChienChatSouris {

    public static void main(String[] args){

        PlateauJeuChienChatSouris jeu = new PlateauJeuChienChatSouris();
        int positionChien=10;
        int positionSouris = 3;
        int positionChat = 1;
        jeu.afficherInformation("Vas-y !");
        jeu.placerSouris(positionSouris);
        jeu.placerChat(positionChat);
        jeu.placerChien(positionChien);
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
                if(positionChien-2<=positionSouris){
                    positionSouris=positionSouris-2;
                    jeu.supprimerSouris();
                    jeu.placerSouris(positionSouris);
                }
                else{
                    positionSouris+=lanceSouris;
                    jeu.supprimerSouris();
                    jeu.placerSouris(positionSouris);}
            }

            jeu.afficherInformation("au chat");
            int lanceChat=jeu.lancerDe();
            if(positionChien-2<=positionChat){
                positionChat=positionChat-2;
                jeu.supprimerSouris();
                jeu.placerChat(positionChat);
            }
            else{
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
}

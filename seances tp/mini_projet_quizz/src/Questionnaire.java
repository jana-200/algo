
public class Questionnaire {
	
	private QuestionCM[] tableQuestions;
	private int indiceDer = -1; // l'indice de la derniere question fournie

	
	/**
	 * renvoie la question suivante
	 * La question qui "suit" la derniere question est la premiere
	 * precondition (a ne pas verifier) : la table est non vide
	 * @return une question QuestionCM
	 */
	public QuestionCM fournirQuestion(){
		if(indiceDer< tableQuestions.length)
			indiceDer++;
		if(indiceDer==tableQuestions.length)
			indiceDer=0;
		return tableQuestions[indiceDer];
	}

	public Questionnaire(QuestionCM[] tableARecopier) {
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		if(tableARecopier.length==0)
			throw new IllegalArgumentException();
		this.tableQuestions = new QuestionCM[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			if(tableARecopier[i]==null)
				throw new IllegalArgumentException();
			this.tableQuestions[i]=tableARecopier[i];
		}
	}

}

package es.iessaladillo.pedrojoya.pr05_trivial.data

object QuestionDB{

    private val allQuestions: MutableList<Question> = mutableListOf(

        Question("¿Cual es la capital de brasil?",
             mutableListOf(Answer("Brasilia", true), Answer("Rio de Janeiro", false),
                 Answer("Bogotá", false), Answer("Caracas", false))),

        Question("¿Cómo se llama la protagonista de la saga de videojuegos \"The Legend of Zelda\"?",
            mutableListOf(Answer("Link", true), Answer("Rio de Janeiro", false),
                Answer("Bogotá", false), Answer("Caracas", false))),

        Question("¿Quién escribió la Ilíada y la Odisea?",
            mutableListOf(Answer("Brasilia", false), Answer("Rio de Janeiro", false),
                Answer("Bogotá", false), Answer("Homero", true))),

        Question("¿Quién pintó el “Guernica”?",
            mutableListOf(Answer("Brasilia", false), Answer("Rio de Janeiro", false),
                Answer("Picasso", true), Answer("Caracas", false))),

        Question("¿Qué gas nos protege de la radiación solar, concretamente de la radiación ultravioleta, formando una capa en la atmósfera?",
            mutableListOf(Answer("Brasilia", false), Answer("Rio de Janeiro", false),
                Answer("Ozono", true), Answer("Caracas", false))),

        Question("¿Quiénes fueron, según la leyenda, los dos hermanos fundadores de la ciudad de Roma?",
            mutableListOf(Answer("Brasilia", false), Answer("Rómulo y Remo", true),
                Answer("Bogotá", false), Answer("Caracas", false))),

        Question("¿Cuál es el río más largo del mundo?",
            mutableListOf(Answer("El Nilo", true), Answer("Rio de Janeiro", false),
                Answer("Bogotá", false), Answer("Caracas", false))),

        Question("Si 50 es el 100%, ¿cuánto es el 90%?",
            mutableListOf(Answer("Brasilia", false), Answer("45", true),
                Answer("Bogotá", false), Answer("Caracas", false))),

        Question("¿A qué país pertenece la ciudad de Varsovia?",
            mutableListOf(Answer("Brasilia", false), Answer("Rio de Janeiro", false),
                Answer("Bogotá", false), Answer("Polonia", true))),

        Question("¿Cuántos corazones tienen los pulpos?",
            mutableListOf(Answer("Brasilia", false), Answer("Rio de Janeiro", false),
                Answer("3", true), Answer("Caracas", false)))
     )

    fun getNRandomQuestions(num: Int): MutableList<Question>{
        return allQuestions.shuffled().take(num) as MutableList<Question>
    }

}
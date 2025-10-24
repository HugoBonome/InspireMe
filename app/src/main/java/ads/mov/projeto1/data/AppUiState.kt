package ads.mov.projeto1.data

import java.util.LinkedList

data class AppUiState (
    val assuntosFav: List<Int> = emptyList(), // Assuntos favoritados
    val materiasDoFeed: List<Materia> = emptyList(), // Matérias correspondentes aos assuntos
    val indiceMateriaAtual: Int = 0, //Indice da matéria atual
    val materiasAcessadas: LinkedList<Int> = LinkedList(), // pilha para poder voltar à ultima materia vista
    val user: User = DataSource.juca, // Dados do usuário
    val isLoggedIn: Boolean = false // Verificação se o login foi realizado
)

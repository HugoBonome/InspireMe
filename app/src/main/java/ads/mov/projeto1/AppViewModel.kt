package ads.mov.projeto1

import ads.mov.projeto1.data.AppUiState
import ads.mov.projeto1.data.DataSource
import ads.mov.projeto1.data.User
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState = _uiState.asStateFlow()

    fun login(username: String, password: String): Boolean {
        // Lógica de login simples com valores pré-definidos
        val user = _uiState.value.user
        if (username == user.username && password == user.senha) {
            _uiState.update { currentState -> currentState.copy(isLoggedIn = true) }
            return true
        }
        return false
    }

    fun selecionarAssunto(idAssunto: Int) {
        _uiState.update { currentState ->
            val assuntosFavoritos =
                currentState.assuntosFav // pegando assuntos favoritados
            val listaAtualizada = if (assuntosFavoritos.contains(idAssunto)) {
                assuntosFavoritos - idAssunto // tira o assunto se já favoritado
            } else {
                assuntosFavoritos + idAssunto // asiciona o assunto se não favoritado
            }
            currentState.copy(assuntosFav = listaAtualizada)
        }
        atualizarMateriasDoFeed()
    }

    //pega as matérias dos assuntos favoritados e guarda no UI State
    private fun atualizarMateriasDoFeed() {
        _uiState.update { currentState ->

            val materias = DataSource.assuntos // pegando apenas as matérias com o assunto favorito selecionado
                .filter { currentState.assuntosFav.contains(it.id) }
                .flatMap { it.materias } // transforma lista de lista de materias em uma unica lista de materias
            currentState.copy(
                materiasDoFeed = materias,
                indiceMateriaAtual = 0,  // Reinicia o índice ao atualizar a lista
            )
        }
    }

    fun proximaMateria() {
        _uiState.update { currentState ->
            if (currentState.materiasDoFeed.size > 1) {
                var novoIndice = currentState.indiceMateriaAtual
                // Garante que o próximo índice seja aleatório e diferente do atual
                while (novoIndice == currentState.indiceMateriaAtual) {
                    novoIndice = currentState.materiasDoFeed.indices.random()
                }

                val novaPilhaAcessadas = currentState.materiasAcessadas
                novaPilhaAcessadas.push(currentState.indiceMateriaAtual)

                currentState.copy(
                    indiceMateriaAtual = novoIndice,
                    materiasAcessadas = novaPilhaAcessadas // Garante que a nova pilha seja salva
                )
            } else {
                currentState // não tem materias selecionada -> continua vazio
            }
        }
    }


    fun materiaAnterior() {
        _uiState.update { currentState ->
            if (currentState.materiasDoFeed.isNotEmpty()) {
                val materiasAcessadas = currentState.materiasAcessadas

                val indiceAnterior = if (materiasAcessadas.isNotEmpty()) {
                    materiasAcessadas.pop() // pega a última matéria acessada do topo da pilha
                } else {
                    if (currentState.indiceMateriaAtual == 0) {
                        currentState.materiasDoFeed.lastIndex
                    } else {
                        currentState.indiceMateriaAtual - 1
                    }
                }
                currentState.copy(indiceMateriaAtual = indiceAnterior)
            } else {
                currentState
            }
        }
    }

    fun logout() {
        _uiState.update { currentState ->
            currentState.copy(isLoggedIn = false)
        }
    }

    fun changePassword(newPassword: String) {
        _uiState.update { currentState ->
            val userSenhaNova =
                User(currentState.user.username, currentState.user.email, newPassword)
            currentState.copy(
                user = userSenhaNova
            )

        }
    }

    fun changeEmail(newEmail: String) {
        _uiState.update { currentState ->
            val userEmailNovo = User(currentState.user.username, newEmail, currentState.user.senha)
            currentState.copy(
                user = userEmailNovo
            )

        }
    }

    fun changeUsername(newUsername: String) {
        _uiState.update { currentState ->
            val userUsernameNovo = User(newUsername, currentState.user.email, currentState.user.senha)
            currentState.copy(
                user = userUsernameNovo
            )

        }
    }

    fun esqueciSenha(){
        _uiState.update { currentState -> currentState.copy(isLoggedIn = true) }
    }
}


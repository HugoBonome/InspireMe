package ads.mov.projeto1

import ads.mov.projeto1.data.DataSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun App(
    viewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoggedIn) {
        Scaffold(
            topBar = {},
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, end = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {

                        IconButton(onClick = {
                            navController.navigate(route = "perfil")

                        }) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Perfil",
                            )
                        }
                        IconButton(onClick = { navController.navigate(route = "Assuntos") }) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Favoritos"
                            )
                        }
                        IconButton(onClick = { navController.navigate(route = "Feed") }) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Feed"
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "Feed", // Inicia no Feed após o login
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = "Assuntos") {
                    AssuntosScreen(
                        assuntos = DataSource.assuntos,
                        assuntosSelecionados = uiState,

                        onSelectAssunto = {
                            viewModel.selecionarAssunto(it)
                        },

                        modifier = Modifier,
                    )
                }

                composable(route = "Feed") {
                    FeedScreen(
                        uiState = uiState,
                        onProximaMateria = {
                            viewModel.proximaMateria()
                        },
                        onMateriaAnterior = {
                            viewModel.materiaAnterior()
                        },
                    )
                }

                composable(route = "Perfil") {
                    UserScreen(
                        modifier = Modifier,
                        uiState = uiState,
                        onChangeEmail = { email ->
                            viewModel.changeEmail(email)
                        },
                        onChangePassword = { password ->
                            viewModel.changePassword(password)
                        },
                        onChangeUsername = { username ->
                            viewModel.changeUsername(username)
                        },
                        onLogout = {
                            viewModel.logout()
                        },


                    )
                }
            }

        }
    } else {
        LoginScreen(
            onLoginClicked = { username, password -> viewModel.login(username, password)},
            onEsqueciSenhaClicked ={ viewModel.esqueciSenha()}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AppPreview() {
    App()
}

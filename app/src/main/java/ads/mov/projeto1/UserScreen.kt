package ads.mov.projeto1

import ads.mov.projeto1.data.AppUiState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Um enum para controlar qual campo está em modo de edição.
private enum class CampoEdicao {
    NONE, USERNAME, EMAIL, SENHA
}

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    onChangeUsername: (String) -> Unit = {},
    onChangeEmail: (String) -> Unit = {},
    onChangePassword: (String) -> Unit = {},
    onLogout: () -> Unit = {},
    uiState: AppUiState,
) {
    var modoDeEdicao by remember { mutableStateOf(CampoEdicao.NONE) }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(R.drawable._856),
            modifier = Modifier.padding(10.dp).weight(2f),
            contentDescription = "User Avatar",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp).weight(4f),
            verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            // Nome de Usuário
            EditableField(
                label = "Usuário",
                value = uiState.user.username,
                isEditing = modoDeEdicao == CampoEdicao.USERNAME,
                onEditClick = { modoDeEdicao = CampoEdicao.USERNAME },
                onSaveClick = { newValue ->
                    onChangeUsername(newValue)
                    modoDeEdicao = CampoEdicao.NONE
                }
            )

            // Email
            EditableField(
                label = "Email",
                value = uiState.user.email,
                isEditing = modoDeEdicao == CampoEdicao.EMAIL,
                onEditClick = { modoDeEdicao = CampoEdicao.EMAIL },
                onSaveClick = { newValue ->
                    onChangeEmail(newValue)
                    modoDeEdicao = CampoEdicao.NONE
                }
            )

            // Senha
            EditableField(
                label = "Senha",
                value = uiState.user.senha,
                isEditing = modoDeEdicao == CampoEdicao.SENHA,
                isPassword = true,
                onEditClick = { modoDeEdicao = CampoEdicao.SENHA },
                onSaveClick = { newValue ->
                    onChangePassword(newValue)
                    modoDeEdicao = CampoEdicao.NONE
                }
            )
        }

        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "Sair")
        }
    }
}

@Composable
private fun EditableField(
    label: String,
    value: String,
    isEditing: Boolean,
    isPassword: Boolean = false,
    onEditClick: () -> Unit,
    onSaveClick: (String) -> Unit
) {
    var textValue by remember(value, isEditing) { mutableStateOf(value) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Se estiver editando, mostra um TextField. Senão, mostra um Text.
        if (isEditing) {
            OutlinedTextField(
                value = textValue,
                onValueChange = { textValue = it },
                label = { Text(label) },
                modifier = Modifier.weight(1f), // Faz o campo ocupar o espaço disponível
                singleLine = true,
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
            )
        } else {
            // Se não for edição, mostra o texto. Para senha, mostra asteriscos.
            val displayText = if (isPassword) "********" else value
            Text(
                text = "$label: $displayText",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f).padding(top = 8.dp) // Alinha melhor com o TextField
            )
        }

        IconButton(onClick = {
            if (isEditing) {
                onSaveClick(textValue)
            } else {
                onEditClick()
            }
        }) {
            Icon(
                imageVector = if (isEditing) Icons.Default.Done else Icons.Default.Edit,
                contentDescription = if (isEditing) "Salvar" else "Editar"
            )
        }
    }
}


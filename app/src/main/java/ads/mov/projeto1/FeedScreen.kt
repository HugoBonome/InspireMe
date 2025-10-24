package ads.mov.projeto1

import ads.mov.projeto1.data.AppUiState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FeedScreen(
    onProximaMateria: () -> Unit = {},
    onMateriaAnterior: () -> Unit = {},
    uiState: AppUiState,
) {
    val materias = uiState.materiasDoFeed
    val materia = materias.getOrNull(uiState.indiceMateriaAtual)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centraliza o bloco todo
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (materia != null) {
                Text(
                    text = materia.titulo,
                    fontSize = 22.sp, // Tamanho maior
                    fontWeight = FontWeight.Bold, // Em negrito
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = materia.corpo,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            } else {
                Text(
                    text = stringResource(R.string.feed_vazio ),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // Centraliza os botões
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onMateriaAnterior,
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Matéria Anterior",
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.width(32.dp)) // Espaço entre os botões

            IconButton(
                onClick = onProximaMateria,

            ) {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "Próxima Matéria",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}





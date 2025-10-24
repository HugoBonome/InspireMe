# Projeto 1 — Programação para Dispositivos Móveis

**Autor:** Hugo Zacarioto Bonome

---

## Descrição do Projeto

O projeto consiste em um aplicativo mobile que funciona como um **visualizador de frases e curiosidades** sobre diversos temas (como Filosofia, Tecnologia, História do Brasil, entre outros).

O objetivo é oferecer ao usuário uma experiência leve e educativa, semelhante a um feed de rede social — porém, ao invés de vídeos ou fotos, o conteúdo apresentado são **frases curtas e curiosidades** de aprendizado.

### Fluxo da Aplicação

1.  **Autenticação**: Telas de login e cadastro para gerenciamento de usuários.
2.  **Seleção de Interesses (`AssuntosScreen`)**: Uma grade interativa onde os usuários podem selecionar seus tópicos favoritos (ex: Tecnologia, Esportes, Saúde). O feedback visual é instantâneo, mostrando os itens selecionados.
3.  **Feed (`FeedScreen`)**: Exibe os conteúdos correspondentes aos interesses do usuário. A navegação permite avançar para uma matéria aleatória ou retroceder para a matéria vista anteriormente.
4.  **Tela de Perfil (`UserScreen`)**: Permite que o usuário visualize e edite suas informações de perfil (nome, email e senha) diretamente na tela, sem a necessidade de diálogos ou pop-ups. Também inclui a funcionalidade de logout.


## Tecnologias Utilizadas

*   **Linguagem de Programação**: Kotlin
*   **Arquitetura**: Android Jetpack
    *   **Navigation Component**
    *   **ViewModel**
    *   **StateFlow**



## Funcionalidades

1. **Login de Usuário**  
   - [x] Usuário e senha pré-definidos (para simplificar o escopo)  
   - [x] Validação básica dos campos e navegação para a próxima tela  

2. **Edição de Perfil**  
   - [x] O usuário pode visualizar seus dados  
   - [x] O usuário pode editar seus dados  

3. **Tela de Preferências**  
   - [x] Seleção dos temas de interesse (ex: Filosofia, Tecnologia, História do Brasil etc)  
   - [x] As preferências são armazenadas localmente e usadas para filtrar o conteúdo exibido  

4. **Tela de Frases (Feed)**  
   - [x] Exibição de frases e curiosidades conforme as preferências escolhidas  
   - [x] Interface semelhante a um “feed vertical” (estilo TikTok)  
   - [x] Cada frase aparece em tela cheia  
   - [x] Clicando numa seta para baixo ou arrastando o usuário poderá visualizar as demais frases


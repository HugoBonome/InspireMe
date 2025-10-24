package ads.mov.projeto1.data


data class Assunto(
    val id: Int,
    val desc: String,
    val materias: List<Materia>
)

data class User(
    val username: String,
    val email: String,
    val senha: String
)


data class Materia(
    val titulo: String,
    val corpo: String
)

object DataSource {

    val filosofia = listOf(
        Materia("O que é filosofia?", "Estudo das questões fundamentais sobre existência, razão e valores."),
        Materia("Sócrates e o diálogo", "Acreditava que o diálogo era o melhor caminho para a verdade."),
        Materia("A dúvida filosófica", "Duvidar é o primeiro passo para o pensamento crítico."),
        Materia("Platão e as ideias", "Defendia que o mundo real é apenas uma cópia do mundo das ideias."),
        Materia("Aristóteles e a lógica", "Criou as bases da lógica e da razão ocidental."),
        Materia("Ética", "A filosofia busca entender o que é o bem e como agir corretamente."),
    )

    val esportes = listOf(
        Materia("Benefícios do esporte", "Melhora a saúde física e reduz o estresse."),
        Materia("Futebol no Brasil", "É o esporte mais popular e parte da identidade nacional."),
        Materia("Espírito esportivo", "Competir com respeito é mais importante que vencer."),
        Materia("Esportes olímpicos", "Reúnem atletas do mundo todo em busca de superação."),
        Materia("Treino e disciplina", "O sucesso no esporte vem da prática constante."),
        Materia("História do basquete", "Criado em 1891 por James Naismith nos Estados Unidos."),
    )

    val historiaDoBrasil = listOf(
        Materia("Independência do Brasil", "Proclamada em 7 de setembro de 1822 por Dom Pedro I."),
        Materia("Abolição da escravidão", "A Lei Áurea foi assinada em 13 de maio de 1888."),
        Materia("República", "Em 1889, o Brasil deixou de ser império e virou república."),
        Materia("Era Vargas", "Getúlio Vargas governou o Brasil por quase 20 anos."),
        Materia("Ditadura Militar", "Período de governo autoritário entre 1964 e 1985."),
        Materia("Constituição de 1988", "Marcou a redemocratização e garantias de direitos."),
    )

    val biologia = listOf(
        Materia("Célula", "Unidade básica da vida, pode ser animal ou vegetal."),
        Materia("Fotossíntese", "Plantas produzem energia a partir da luz solar."),
        Materia("DNA", "Contém as informações genéticas dos seres vivos."),
        Materia("Ecossistema", "Conjunto de seres vivos que interagem com o ambiente."),
        Materia("Evolução", "Teoria que explica a origem e transformação das espécies."),
        Materia("Respiração celular", "Processo que converte glicose em energia."),
    )

    val tecnologia = listOf(
        Materia("O que é IA?", "Simula a inteligência humana em máquinas."),
        Materia("Internet das Coisas", "Conecta objetos comuns à internet para automação."),
        Materia("Computação em nuvem", "Armazena dados pela internet, sem precisar de servidor local."),
        Materia("Robótica", "Área que cria máquinas capazes de realizar tarefas humanas."),
        Materia("Cibersegurança", "Protege sistemas e dados contra ataques digitais."),
        Materia("Realidade aumentada", "Combina elementos virtuais com o mundo real."),
    )

    val curiosidades = listOf(
        Materia("O som mais alto da Terra", "Foi a erupção do vulcão Krakatoa em 1883."),
        Materia("Girafas dormem pouco", "Elas dormem menos de duas horas por dia."),
        Materia("Origem do Wi-Fi", "O termo veio de 'Wireless Fidelity'."),
        Materia("Abelhas reconhecem rostos", "Estudos mostram que elas identificam padrões humanos."),
        Materia("Oceano mais profundo", "A Fossa das Marianas tem cerca de 11 mil metros."),
        Materia("O animal mais rápido", "O falcão-peregrino atinge mais de 300 km/h."),
    )

    val astronomia = listOf(
        Materia("O Sol", "Estrela que fornece energia e luz para a Terra."),
        Materia("Buracos negros", "Regiões do espaço com gravidade extrema."),
        Materia("Via Láctea", "Galáxia onde está o Sistema Solar."),
        Materia("Planetas gasosos", "Júpiter e Saturno são compostos principalmente por gases."),
        Materia("A Lua", "Único satélite natural da Terra e influencia as marés."),
        Materia("Constelações", "Agrupamentos de estrelas que formam desenhos no céu."),
    )

    val assuntos = listOf(
        Assunto(1,"Filosofia", filosofia),
        Assunto(2,"Esportes", esportes),
        Assunto(3,"História do Brasil", historiaDoBrasil),
        Assunto(4,"Biologia", biologia),
        Assunto(5,"Tecnologia", tecnologia),
        Assunto(6,"Curiosidades", curiosidades),
        Assunto(7,"Astronomia", astronomia),
    )




    val juca = User("Juca", "juca@gmail.com", "juca123")

}
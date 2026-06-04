 ## 📱 Sobre o Projeto

**Vero** é um aplicativo de lista de tarefas desenvolvido como projeto de estudo, seguindo as boas práticas de desenvolvimento Android moderno. O app foi construído do zero com **Jetpack Compose** para a interface declarativa e o padrão de arquitetura **MVVM** para separação de responsabilidades.

---

## 🛠️ Tecnologias e Bibliotecas

| Tecnologia | Descrição |
|---|---|
| [Kotlin](https://kotlinlang.org/) | Linguagem principal |
| [Jetpack Compose](https://developer.android.com/jetpack/compose) | UI declarativa |
| [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) | Gerenciamento de estado da UI |
| [Room](https://developer.android.com/training/data-storage/room) | Persistência local de dados |
| [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) | Operações assíncronas |
| [StateFlow / LiveData](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow) | Observação reativa de estado |
| [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) | Navegação entre telas |

---

## 🏗️ Arquitetura

O projeto segue o padrão **MVVM (Model-View-ViewModel)** recomendado pelo Google:

```
app/
├── data/
│   ├── local/
│   │   ├── TaskDao.kt
│   │   └── TaskDatabase.kt
│   ├── model/
│   │   └── Task.kt
│   └── repository/
│       └── TaskRepository.kt
├── ui/
│   ├── screens/
│   │   ├── TaskListScreen.kt
│   │   └── AddEditTaskScreen.kt
│   ├── components/
│   │   └── TaskItem.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
└── viewmodel/
    └── TaskViewModel.kt
```

---

## ✨ Funcionalidades

- [x] Listar todas as tarefas
- [x] Adicionar nova tarefa
- [x] Marcar tarefa como concluída
- [x] Editar tarefa existente
- [x] Deletar tarefa
- [x] Persistência local com Room Database

---

## 🚀 Como Executar

### Pré-requisitos

- Android Studio Hedgehog ou superior
- JDK 17+
- Android SDK API 26+

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/balzaNeli/VeroList.git
   ```

2. Abra o projeto no **Android Studio**

3. Aguarde o Gradle sincronizar as dependências

4. Conecte um dispositivo físico ou inicie um emulador

5. Clique em **Run ▶** (ou `Shift + F10`)

---

## 📄 Licença

Este projeto é de uso educacional. Sinta-se livre para usar e modificar.
# Vero
> A clean, minimal To-Do List app for Android built with Jetpack Compose and MVVM architecture.

